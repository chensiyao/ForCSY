package com.csy.module.wx.service.service;

import java.util.Map;
import java.util.List;
import com.csy.module.wx.dto.DriverAccident;
import com.csy.module.wx.dto.KckpUploadInfo;
import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.util.spring.BaseDao;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

public interface BAccidentInfoService extends BaseDao<BAccidentInfo, BAccidentInfoExample>{
	
	JSONObject insertAccident(KckpUploadInfo uploadInfo);
	
	PageInfo selectPageInfo(int pageNum, int pageSize, Map<String, Object> map);
	
	public List<DriverAccident> selectByExample(DriverAccident accidentInfo);
	
	/**
	 * 事故重新传图
	 * @param id     事件编号
	 * @param wxIds  微信Id
	 * @return
	 */
	JSONObject updateAccident(String id, String... wxIds);
	String updateByPrimaryKeySelective(String id,String num);
}
