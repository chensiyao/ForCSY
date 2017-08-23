package com.csy.module.wx.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BAccidentDriverMapper;
import com.csy.module.wx.dao.BAccidentInfoMapper;
import com.csy.module.wx.dao.BDriverInfoMapper;
import com.csy.module.wx.dao.BWxUserMapper;
import com.csy.module.wx.dto.DriverAccident;
import com.csy.module.wx.dto.KckpUploadInfo;
import com.csy.module.wx.entity.BAccidentDriver;
import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.entity.BWxUser;
import com.csy.module.wx.service.service.BAccidentInfoService;
import com.csy.util.StringUtils;
import com.csy.util.TimeFormatUtil;
import com.csy.util.XtpzUtil;
import com.csy.util.spring.BaseService;
import com.csy.util.wx.en.WxFileEnum;
import com.csy.util.wx.queue.FileQueue;
import com.csy.util.wx.queue.FileQueue.FileDescription;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

/**
 * @author wangqiang
 * @date 2017-02-19
 */
@Service
public class BAccidentInfoServiceImpl extends BaseService<BAccidentInfo, BAccidentInfoExample> 
	implements BAccidentInfoService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BAccidentInfoMapper accidentDao;
	@Autowired
	private BDriverInfoMapper driverDao;
	@Autowired
	private BAccidentDriverMapper accidentDriverDao;
	@Autowired
	private BWxUserMapper wxUserDao;
	
	@Override
	public JSONObject insertAccident(KckpUploadInfo accident) {
		
		List<BDriverInfo> drivers = accident.getJsyxxs();
		
		accident.setId(UUID.randomUUID().toString());
		
		List<BAccidentDriver> accidentDrivers = new ArrayList<BAccidentDriver>(drivers.size());
		for(BDriverInfo driver: drivers){
			driver.setId(UUID.randomUUID().toString());
			
			//关联信息写入
			BAccidentDriver accidentDriver = new BAccidentDriver();
			accidentDriver.setId(accident.getId());
			accidentDriver.setFkDriverId(driver.getId());
			accidentDrivers.add(accidentDriver);
		}
		driverDao.insertPatch(drivers);
		accidentDriverDao.insertPatch(accidentDrivers);
		
		//数据全部操作成功之后,将上传数据 加入队列
		wxfileUpload(accident);
		
		accidentDao.insertSelective(accident);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("errMsg", "");
		return jsonObject;
	}

	@Override
	public PageInfo selectPageInfo(int pageNum, int pageSize, Map<String, Object> map) {
		BAccidentInfoExample infoExample = new BAccidentInfoExample();
		infoExample.setOrderByClause("occurrence_time desc");
		infoExample.createCriteria().andFkWxOpenidEqualTo((String)map.get("fk_wx_openid"));
		PageHelper.startPage(pageNum, pageSize);
		PageInfo accidentInfos = new PageInfo(accidentDao.selectByExample(infoExample));
		return accidentInfos;
	}
	
 @Override
 public JSONObject updateAccident(String id, String... wxIds){
   JSONObject rtnObj = new JSONObject();
   BAccidentInfo info = accidentDao.selectByPrimaryKey(id);
   if(info == null){
     rtnObj.put("errMsg", "记录无效");
   }else{
     List<String> liveImage2;
     if(!StringUtils.isTrimEmpty(info.getLiveImage())){
       liveImage2 = new ArrayList<String>(Arrays.asList(info.getLiveImage().split(",")));
     }else{
       liveImage2 = new ArrayList<String>();
     }
     
     List<String> newUpload2 = new ArrayList<String>();
     
     for(String wxId : wxIds){
       String newLiveImage = new StringBuffer().append(UUID.randomUUID().toString()).append(".jpg").toString();
       FileDescription fileDetail = FileQueue.getInstance()
           .new FileDescription(wxId, info.getFkWxOpenid(), newLiveImage ,WxFileEnum.IMAGE, info.getUploadTime());
       FileQueue.getInstance().add(fileDetail);
       newUpload2.add(newLiveImage);
     }
     
     liveImage2.addAll(newUpload2);
     
     BAccidentInfo updateInfo = new BAccidentInfo();
     updateInfo.setId(info.getId());
     updateInfo.setLiveImage(StringUtils.join(liveImage2));
     /***********将reupload->reuploaded*********/
     updateInfo.setImgreuploadedIndex(info.getImgreuploadIndex());
     accidentDao.updateByPrimaryKeySelective(updateInfo);
   }
   return rtnObj;
 }
	
	private void wxfileUpload(KckpUploadInfo accident){
		//图片文件转换
		if(accident.getLiveImage() != null && !"".equals(accident.getLiveImage().trim())){
			String[] liveImages = accident.getLiveImage().split(",");
			List<String> newLiveImages = new ArrayList<String>();
			for(String liveImage : liveImages){
				String newLiveImage = new StringBuffer().append(UUID.randomUUID().toString()).append(".jpg").toString();
				FileDescription fileDetail = FileQueue.getInstance()
						.new FileDescription(liveImage, accident.getFkWxOpenid(), newLiveImage, WxFileEnum.IMAGE, accident.getUploadTime());
				FileQueue.getInstance().add(fileDetail);
				newLiveImages.add(newLiveImage);
			}
			accident.setLiveImage(StringUtils.join(newLiveImages));
		}
		//声音文件转换
		if(accident.getLiveVoice() != null && !"".equals(accident.getLiveVoice().trim())){
			String[] liveVoices = accident.getLiveVoice().split(",");
			List<String> newLiveVoices = new ArrayList<String>();
			for(String liveVoice : liveVoices){
				String newLiveVoice = new StringBuffer().append(UUID.randomUUID().toString()).append(".mp3").toString();
				FileDescription fileDetail = FileQueue.getInstance()
						.new FileDescription(liveVoice, accident.getFkWxOpenid(), newLiveVoice ,WxFileEnum.VOICE, accident.getUploadTime());
				FileQueue.getInstance().add(fileDetail);
				newLiveVoices.add(newLiveVoice.toString());
			}
			accident.setLiveVoice(StringUtils.join(newLiveVoices));
		}
	}
	
	/**
	 * 说明：根据事故发生时间和微信号、号牌号码查询事故、驾驶员、微信信息
	 */
	public List<DriverAccident> selectByExample(DriverAccident accidentInfo) {
		List<DriverAccident> list = new ArrayList<DriverAccident>();
		List<BAccidentInfo> bAccidentInfos = new ArrayList<BAccidentInfo>();
		BAccidentInfo bAccidentInfo = new BAccidentInfo();//事故对象
		BWxUser user1 = new BWxUser();//微信用户对象
		HashMap<String, String> map = new HashMap<String, String>();
		if(accidentInfo.getKssj() != null  && accidentInfo.getKssj() != ""){
			bAccidentInfo.setDescription(accidentInfo.getKssj());
		}
		if(accidentInfo.getJssj() != null  && accidentInfo.getJssj() != ""){
			bAccidentInfo.setLiveVoice(accidentInfo.getJssj());
		}
		if(accidentInfo.getHphm() != null  && accidentInfo.getHphm() != ""){
			map.put("hphm",accidentInfo.getHphm());
		}
		bAccidentInfos = accidentDao.selectBysj(bAccidentInfo);
		if(bAccidentInfos.size() > 0){
			for(BAccidentInfo info : bAccidentInfos){
				List<BDriverInfo> bDriverInfos = new ArrayList<BDriverInfo>();
				BWxUser user = new BWxUser();//微信用户对象
				DriverAccident accident = new DriverAccident();//返回所有信息对象
				//微信
				if(info.getFkWxOpenid() != null && info.getFkWxOpenid() != ""){
					user1.setOpenid(info.getFkWxOpenid());
					if(accidentInfo.getWxzh() != null  && accidentInfo.getWxzh() != ""){
						user1.setNickname(accidentInfo.getWxzh());
					}
					user = wxUserDao.selectByParam(user1);
					if(null != user && !user.getOpenid().isEmpty()){
						accident.setWxzh(user.getNickname());
						if(user.getHeadimgurl() != null && user.getHeadimgurl() != ""){
							if(user.getHeadimgurl().substring(user.getHeadimgurl().lastIndexOf("/")+1).equals("0")){
								accident.setWxtx(user.getHeadimgurl().substring(0, user.getHeadimgurl().lastIndexOf("/")+1)+64);
							}
						}
					}
				}else{
					logger.error("事故信息表没有关联微信用户表");
				}
				accident.setSgsj(TimeFormatUtil.dateToString(info.getOccurrenceTime()));
				accident.setSgzr(info.getDuty());
				accident.setSgms(info.getDescription());
				accident.setSgjd(info.getLongitude());
				accident.setSgwd(info.getLatitude());
				accident.setImagePath(XtpzUtil.getXtpzByName("wxResource").getVal());
				accident.setLiveImage(info.getLiveImage());
				accident.setLiveVoice(info.getLiveVoice());
				accident.setWxid(info.getFkWxOpenid());
				accident.setAccdientId(info.getId());
				if(null != info.getImgreuploadIndex() && !"".equals(info.getImgreuploadIndex())){
					accident.setImageUploadIndex(info.getImgreuploadIndex());
				}
				//驾驶员
				if(info.getId() != null && info.getId() != ""){
					List<BAccidentDriver> accidentDrivers =  accidentDriverDao.selectAll(info.getId());
					for(BAccidentDriver accidentDriver : accidentDrivers){
						map.put("id",accidentDriver.getFkDriverId());
						BDriverInfo bDriverInfo = driverDao.selectById(map);
						if(null != bDriverInfo){
							bDriverInfos.add(bDriverInfo);
						}
					}
					accident.setbDriverInfos(bDriverInfos);
				}else{
					logger.error("事故信息表没有关联事故驾驶员关联表");
				}
				if(!accident.getbDriverInfos().isEmpty() && null != user){
					list.add(accident);
				}
			}
		}
		return list;
	}

	@Override
	public String updateByPrimaryKeySelective(String id,String num) {
		BAccidentInfo accidentInfo = accidentDao.selectByPrimaryKey(id);
		if(null != accidentInfo.getImgreuploadIndex() && !"".equals(accidentInfo.getImgreuploadIndex())){
			String imageIndex = accidentInfo.getImgreuploadIndex();
			accidentInfo.setImgreuploadIndex(num+","+imageIndex);
		}else{
			accidentInfo.setImgreuploadIndex(num);
		}
		accidentDao.updateByPrimaryKeySelective(accidentInfo);
		return accidentInfo.getImgreuploadIndex();
	}
}
