package com.csy.module.wx.dao;

import java.util.HashMap;
import java.util.List;

import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.entity.BDriverInfoExample;
import com.csy.util.spring.BaseDao;

public interface BDriverInfoMapper extends BaseDao<BDriverInfo, BDriverInfoExample>{
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int insertPatch(List<BDriverInfo> list);
	
	BDriverInfo selectById(HashMap<String, String> map);
	
	List<BDriverInfo> selectDriversByAccidentID(String id);
}