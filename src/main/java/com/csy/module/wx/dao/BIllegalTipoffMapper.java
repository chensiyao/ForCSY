package com.csy.module.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.csy.module.wx.entity.BIllegalTipoff;
import com.csy.module.wx.entity.BIllegalTipoffExample;
import com.csy.util.spring.BaseDao;

public interface BIllegalTipoffMapper extends BaseDao<BIllegalTipoff, BIllegalTipoffExample>{



	List<BIllegalTipoff> selectTipoffBysj(@Param("kssj")String kssj,@Param("jssj") String jssj,@Param("status")String status);


  
}