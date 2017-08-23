package com.csy.module.wx.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BWxFkyjMapper;
import com.csy.module.wx.entity.BWxFkyj;
import com.csy.module.wx.entity.BWxFkyjExample;
import com.csy.module.wx.service.service.BWxFkyjService;
import com.csy.util.StringUtils;
import com.csy.util.XtpzUtil;
import com.csy.util.spring.BaseService;
import com.csy.util.wx.en.WxFileEnum;
import com.csy.util.wx.queue.FileQueue;
import com.csy.util.wx.queue.FileQueue.FileDescription;

@Service
public class BWxFkyjServiceImpl extends BaseService<BWxFkyj, BWxFkyjExample>
	implements BWxFkyjService{

	@Autowired
	private BWxFkyjMapper fkyjDao;
	
	@Override
	public int addFkyj(BWxFkyj fkyj) {
		Date curDate = new Date();
		fkyj.setCreateTime(curDate);
		fkyj.setId(UUID.randomUUID().toString());
		String s_imgUrls = fkyj.getImage();
		if(StringUtils.notTrimEmpty(s_imgUrls)){
			//图片文件转换
			String[] liveImages = s_imgUrls.split(",");
			List<String> newLiveImages = new ArrayList<String>();
			for(String liveImage : liveImages){
				String newLiveImage = new StringBuffer().append(UUID.randomUUID().toString()).append(".jpg").toString();
				FileDescription fileDetail = FileQueue.getInstance()
						.new FileDescription(liveImage, fkyj.getOpenid(), newLiveImage, WxFileEnum.IMAGE, curDate);
				FileQueue.getInstance().add(fileDetail);
				newLiveImages.add(newLiveImage);
			}
			fkyj.setImage(StringUtils.join(newLiveImages));
		}
		return fkyjDao.insertSelective(fkyj);
	}

	@Override
	public List<BWxFkyj> queryAllInfo(BWxFkyj bWxFkyj,RowBounds rowBounds) {
		List<BWxFkyj> list = new ArrayList<BWxFkyj>();
		if(!bWxFkyj.isFlag()){
			list = fkyjDao.queryAllInfo(bWxFkyj);
		}else{
			list = fkyjDao.queryAllInfo(bWxFkyj,rowBounds);
		}
		String imagePath = XtpzUtil.getXtpzByName("wxResource").getVal();
		if(null != list && list.size() > 0){
			for(BWxFkyj fkyj : list){
				if(null != fkyj.getImage() && !"".equals(fkyj.getImage())){
					String image = imagePath+"/"+fkyj.getKssj().substring(0,10)+"/"+fkyj.getOpenid()+"/";
					fkyj.setImagePath(image);
				}
			}
		}
		return list;
	}

	@Override
	public int countByMap(BWxFkyj wxFkyj) {
		int count = fkyjDao.countByMap(wxFkyj);
		return count;
	}
	
}
