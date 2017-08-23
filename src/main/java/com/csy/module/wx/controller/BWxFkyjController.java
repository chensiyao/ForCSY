package com.csy.module.wx.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.wx.entity.BWxFkyj;
import com.csy.module.wx.entity.BWxUser;
import com.csy.module.wx.service.service.BWxFkyjService;
import com.csy.util.DmxUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/wx/fkyj")
public class BWxFkyjController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BWxFkyjService fkyjService;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, ModelMap map){
		map.put("fkyjs", DmxUtil.getDmxList(20001));
		return new ModelAndView("/weixin/fkyj", map);
	}

 @RequestMapping(method = RequestMethod.POST)
	public void addKckpInfo( HttpServletRequest request, HttpServletResponse response, 
			@RequestBody BWxFkyj fkyj) throws IOException{
		//返回的json数据
		JSONObject rst = null;
		BWxUser wxUser = (BWxUser)request.getSession(true).getAttribute("bWxUser");
		if(wxUser==null){
			rst = new JSONObject();
			rst.put("errMsg", "未抓取到上传用户信息");
		}else{
			rst = new JSONObject();
			try {
				fkyj.setOpenid(wxUser.getOpenid());
				fkyjService.addFkyj(fkyj);
				rst.put("errMsg", "");
			} catch (Exception e) {
				rst.put("errMsg", e.getMessage());
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
		response.getWriter().print(rst);
	};
	
}
