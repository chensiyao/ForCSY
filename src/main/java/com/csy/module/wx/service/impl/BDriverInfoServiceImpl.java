package com.csy.module.wx.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BDriverInfoMapper;
import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.entity.BDriverInfoExample;
import com.csy.module.wx.service.service.BDriverInfoService;
import com.csy.util.spring.BaseService;

/**
 * @author wangqiang
 * @date 2017-02-19
 */
@Service
public class BDriverInfoServiceImpl extends BaseService<BDriverInfo, BDriverInfoExample> 
	implements BDriverInfoService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BDriverInfoMapper driverDao;
	
	@Override
	public List<BDriverInfo> selectDriversByAccidentID(String accidentID) {
		return driverDao.selectDriversByAccidentID(accidentID);
	}
}
