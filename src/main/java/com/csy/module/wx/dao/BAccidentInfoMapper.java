package com.csy.module.wx.dao;

import java.util.List;

import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BAccidentInfoExample;
import com.csy.util.spring.BaseDao;

public interface BAccidentInfoMapper extends BaseDao<BAccidentInfo, BAccidentInfoExample>{
  List<BAccidentInfo> selectBysj(BAccidentInfo accidentInfo);
}