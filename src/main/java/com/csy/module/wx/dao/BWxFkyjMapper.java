package com.csy.module.wx.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.csy.module.wx.entity.BWxFkyj;
import com.csy.module.wx.entity.BWxFkyjExample;
import com.csy.util.spring.BaseDao;

public interface BWxFkyjMapper extends BaseDao<BWxFkyj, BWxFkyjExample>{
	List<BWxFkyj> queryAllInfo(BWxFkyj wxFkyj,RowBounds rowBounds);
	List<BWxFkyj> queryAllInfo(BWxFkyj wxFkyj);
	int countByMap(BWxFkyj wxFkyj);
}