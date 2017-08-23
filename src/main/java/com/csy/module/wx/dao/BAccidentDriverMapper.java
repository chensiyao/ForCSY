package com.csy.module.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.csy.module.wx.entity.BAccidentDriver;
import com.csy.module.wx.entity.BAccidentDriverExample;
import com.csy.util.spring.BaseDao;

public interface BAccidentDriverMapper extends BaseDao<BAccidentDriver, BAccidentDriverExample>{

	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int insertPatch(@Param("list") List<BAccidentDriver> list);
	
	List<BAccidentDriver> selectAll(String id);
}