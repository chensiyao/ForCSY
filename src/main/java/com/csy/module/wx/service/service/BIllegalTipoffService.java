package com.csy.module.wx.service.service;

import java.util.List;

import com.csy.module.wx.dto.BIllegalTipoffUser;
import com.csy.module.wx.entity.BIllegalTipoff;
import com.csy.module.wx.entity.BIllegalTipoffExample;
import com.csy.util.spring.BaseDao;

public interface BIllegalTipoffService extends BaseDao<BIllegalTipoff, BIllegalTipoffExample>{
  
  int addTipOff(BIllegalTipoff tipoff);


public List<BIllegalTipoffUser> selectByExample(BIllegalTipoffUser tipoff);


/*void updateState(String wfid, String wfstate);*/
}
