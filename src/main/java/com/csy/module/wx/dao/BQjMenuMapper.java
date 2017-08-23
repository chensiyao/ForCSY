package com.csy.module.wx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.csy.module.wx.entity.BQjMenu;
import com.csy.module.wx.entity.BQjMenuExample;

public interface BQjMenuMapper {
    int countByExample(BQjMenuExample example);

    int deleteByExample(BQjMenuExample example);

    int deleteByPrimaryKey(String xh);

    int insert(BQjMenu record);

    int insertSelective(BQjMenu record);

    List<BQjMenu> selectByExample(BQjMenuExample example);

    BQjMenu selectByPrimaryKey(String xh);

    int updateByExampleSelective(@Param("record") BQjMenu record, @Param("example") BQjMenuExample example);

    int updateByExample(@Param("record") BQjMenu record, @Param("example") BQjMenuExample example);

    int updateByPrimaryKeySelective(BQjMenu record);

    int updateByPrimaryKey(BQjMenu record);
    /**
	  * 根据map查询
	  */
	 List<BQjMenu> selectByMap(Map<String,Object> map);
	 
	 /**
	  * 子系统一级二级菜单数据查询(根据用户和岗位权限过滤)
	  */
	 List<BQjMenu> selectSubSystemMenu(BQjMenu bQjSubsystemMenu);
	 
	 /**
	  * 根据序号查询
	  * @param xh
	  * @return
	  */
	 BQjMenu selectByPrimaryKey(long xh);
}