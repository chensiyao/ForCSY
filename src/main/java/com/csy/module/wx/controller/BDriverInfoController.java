package com.csy.module.wx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csy.module.wx.entity.BDriverInfo;
import com.csy.module.wx.service.service.BDriverInfoService;
import com.csy.util.JSONUtil;
import com.csy.util.StringUtils;

import net.sf.json.JSONArray;

@Controller
public class BDriverInfoController {
	
	@Autowired
	private BDriverInfoService driverService;
	
	@RequestMapping("/getDriverByEventID")
	public void getDriverByEventID(HttpServletResponse response, String id){
		List<BDriverInfo> driverInfos;
		if(StringUtils.isTrimEmpty(id)){
			driverInfos = new ArrayList<BDriverInfo>();
		}else{
			driverInfos = driverService.selectDriversByAccidentID(id); 
		}
		JSONUtil.writeJSONArrayToResponse(response, JSONArray.fromObject(driverInfos));
	}
}
