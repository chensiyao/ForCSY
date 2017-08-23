package com.csy.util;

import java.util.List;

import com.csy.module.xtpz.entity.BQjXtpz;
import com.csy.module.xtpz.entity.BQjXtpzExample;
import com.csy.module.xtpz.service.service.BQjXtpzService;

/**@author wangqiang
 * @date 2016-9-21 16:31:42
 * @description 代码项工具类，用于快速获取代码项内容
 */
public class XtpzUtil {
	
	private static final BQjXtpzService  B_QJ_XTPZ_SERVICE= SpringFactory.getBean("bQjXtpzService");
	
	/**
	 * @author wangqiang
	 * @date 2016-9-21 17:06:49
	 * @param dmlxbh
	 * @return
	 * @description 根据代码类型序号 筛选代码项类型
	 */
	public static BQjXtpz getXtpzByName(String name){
		BQjXtpzExample example = new BQjXtpzExample();
		example.createCriteria().andNameEqualTo(name);
		List<BQjXtpz> list = B_QJ_XTPZ_SERVICE.selectByExample(example);
		if(list.size()>0) 
			return list.get(0);
		return null;
	}
	
}
