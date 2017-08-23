/**
 * @description 
 * @author 赵春杨
 * @version 1.0
 * @date 2015-8-26
 */
package com.csy.module.wx.service.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csy.module.wx.dao.BQjMenuMapper;
import com.csy.module.wx.entity.BQjMenu;
@Service
public class BQjMenuService{
	
	@Resource
	private BQjMenuMapper _dao;

	/**
	 * 根据map查询s
	 */
	public List<BQjMenu> selectByMap(Map<String, Object> map) {
		return _dao.selectByMap(map);
	}

	/**
	 * 子系统一级二级菜单数据查询(根据用户和岗位权限过滤)
	 */
	public List<BQjMenu> selectSubSystemMenu(BQjMenu bQjSubsystemMenu) {
		return _dao.selectSubSystemMenu(bQjSubsystemMenu);
	}
}
