package com.csy.module.wx.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BIllegalTipoffMapper;
import com.csy.module.wx.dao.BWxUserMapper;
import com.csy.module.wx.dto.BIllegalTipoffUser;
import com.csy.module.wx.entity.BIllegalTipoff;
import com.csy.module.wx.entity.BIllegalTipoffExample;
import com.csy.module.wx.entity.BWxUser;
import com.csy.module.wx.service.service.BIllegalTipoffService;
import com.csy.util.StringUtils;
import com.csy.util.TimeFormatUtil;
import com.csy.util.XtpzUtil;
import com.csy.util.spring.BaseService;
import com.csy.util.wx.en.WxFileEnum;
import com.csy.util.wx.queue.FileQueue;
import com.csy.util.wx.queue.FileQueue.FileDescription;

@Service
public class BIllegalTipoffServiceImpl extends BaseService<BIllegalTipoff, BIllegalTipoffExample> 
implements BIllegalTipoffService{
  
  @Autowired
  private BIllegalTipoffMapper tipoffDao;
  
  @Autowired
  private BWxUserMapper userdao;
  
  @Override
  public int addTipOff(BIllegalTipoff tipoff){
    
    Date curDate = new Date();
    tipoff.setOccurrenceTime(curDate);
    tipoff.setId(UUID.randomUUID().toString());
    String s_imgUrls = tipoff.getIllegalImages();
    if(StringUtils.notTrimEmpty(s_imgUrls)){
     //图片文件转换
     String[] liveImages = s_imgUrls.split(",");
     List<String> newLiveImages = new ArrayList<String>();
     for(String liveImage : liveImages){
      String newLiveImage = new StringBuffer().append(UUID.randomUUID().toString()).append(".jpg").toString();
      FileDescription fileDetail = FileQueue.getInstance()
        .new FileDescription(liveImage, tipoff.getFkWxOpenid(), newLiveImage, WxFileEnum.IMAGE, curDate);
      FileQueue.getInstance().add(fileDetail);
      newLiveImages.add(newLiveImage);
     }
     tipoff.setIllegalImages(StringUtils.join(newLiveImages));
    }
    return tipoffDao.insertSelective(tipoff);
  }

	/**
	 * 说明：根据时间查询违法记录、举报人、微信信息
	 */
@Override
public List<BIllegalTipoffUser> selectByExample(BIllegalTipoffUser tipoffUser) {
	List<BIllegalTipoffUser> lists=new ArrayList<BIllegalTipoffUser>();
	List<BIllegalTipoff> tipofflists=new ArrayList<BIllegalTipoff>();
    String kssj = null;
    String jssj = null;
    String status=null;
	if(tipoffUser.getKssj() != null && tipoffUser.getKssj() != "")
	{
	   kssj=tipoffUser.getKssj();
	}
	if(tipoffUser.getJssj() !=null && tipoffUser.getJssj() != "")
	{
		jssj=tipoffUser.getJssj();
	}
	if(tipoffUser.getWfstate() !=null&&tipoffUser.getWfstate() !="")
	{
		status=tipoffUser.getWfstate();
	}
	tipofflists=tipoffDao.selectTipoffBysj(kssj,jssj,status);
	for(int i=0;i<tipofflists.size();i++)
	{
		BIllegalTipoffUser btu=new BIllegalTipoffUser();
	/*	String name=tipofflists.get(i).getName();
		bu.setJbr(name);*/
		BIllegalTipoff tipoff=tipofflists.get(i);
		//号牌号码
		String hphm=tipoff.getPlateNumber();
		//通过openid获得微信用户
		String openid=tipoff.getFkWxOpenid();
		BWxUser bwxUser=new BWxUser();
		bwxUser.setOpenid(openid);
		BWxUser user=userdao.selectByParam(bwxUser);
		//微信账号
		String wxh=user.getNickname();
		//违法时间
		Date occurrenceTime=tipoff.getOccurrenceTime();
		//违法地点
		String wfdd=tipoff.getIllegalPosition();
		//违法描述--违法行为
		String wfms=tipoff.getIllegalAct();
		//举报人
		String name=tipoff.getName();
		//举报人电话
		String lxdh=tipoff.getPhone();
		//举报人身份证号
		String sfzh=tipoff.getIdcard();
		//微信头像
		if(user.getHeadimgurl() != null && user.getHeadimgurl() != ""){
		String wxtx=user.getHeadimgurl().substring(0, user.getHeadimgurl().lastIndexOf("/")+1)+64;

		btu.setWxtx(wxtx);
		}
		//违法经度
		String wfjd=tipoff.getLongitude();
		//违法纬度
		String wfwd=tipoff.getLatitude();
		//现场图片
		String wftp=tipoff.getIllegalImages();
		//违法id
		String wfid=tipoff.getId();
		//处理状态
		String wfstate=tipoff.getStatus();
		//号牌号码
		btu.setHphm(hphm);
		//微信账号
		btu.setWxzh(wxh);
		//违法时间
		btu.setWfsj(TimeFormatUtil.dateToString(occurrenceTime));
		//违法地点
		btu.setWfdd(wfdd);
		//违法描述--违法行为
		btu.setWfxw(wfms);
		//举报人
		btu.setJbr(name);
		//举报人电话
		btu.setLxdh(lxdh);
		//举报人身份证账号
		btu.setSfzh(sfzh);
		//违法经度
		btu.setWfjd(wfjd);
		//违法纬度
		btu.setWfwd(wfwd);
		//违法图片
		btu.setWftp(wftp);
		//图片路径前缀
		btu.setImagepath(XtpzUtil.getXtpzByName("wxResource").getVal());
		//openid
		btu.setWxid(openid);
		//违法id
		btu.setWfid(wfid);
		//违法状态
		btu.setWfstate(wfstate);
	
		lists.add(btu);
	}
	

	return lists;

}

/*	@Override
	public void updateState(String wfid, String wfstate) {
		// TODO Auto-generated method stub
		tipoffDao.updateState(wfid,wfstate);
		
	}*/
}
