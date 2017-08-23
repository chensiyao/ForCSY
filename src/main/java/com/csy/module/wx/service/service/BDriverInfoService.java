package com.csy.module.wx.service.service;

import java.util.List;

import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.entity.BDriverInfoExample;
import com.csy.util.spring.BaseDao;

public interface BDriverInfoService extends BaseDao<BDriverInfo, BDriverInfoExample>{
	
	List<BDriverInfo> selectDriversByAccidentID(String accidentID);
}
