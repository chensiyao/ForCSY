package com.csy.module.wx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.wx.dto.BIllegalTipoffUser;
import com.csy.module.wx.dto.DriverAccident;
import com.csy.module.wx.entity.BIllegalTipoff;
import com.csy.module.wx.service.service.BAccidentInfoService;
import com.csy.module.wx.service.service.BIllegalTipoffService;
import com.csy.util.JSONUtil;
import com.csy.util.StringUtils;
import com.csy.util.TimeFormatUtil;

@Controller
public class WfjbglAction {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private BAccidentInfoService bAccidentInfoService;

	@Resource
	private BIllegalTipoffService bIllegalTipooffService;

	private static String Param = "";

	/**
	 * 说明:违法举报查询页面 创建时间：2017-08-15
	 * 
	 * @author guwenwen
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/WFJBGL")
	public ModelAndView wfjbgl(String param, HttpServletRequest req)
			throws Exception {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		String formatTime = TimeFormatUtil.timeToStr(calendar,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		calendar.add(Calendar.DATE, -7);
		String formatTime1 = TimeFormatUtil.timeToStr(calendar,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		paramsMap.put("startTime", formatTime1);
		paramsMap.put("endTime", formatTime);
		if (!StringUtils.isNull(param)) {
			Param = param;
		}
		paramsMap.put("param", Param);
		return new ModelAndView("wfjlgl/wfjbcx", paramsMap);
	}

	/**
	 * 说明：根据事故发生时间、微信号、号牌号码去查询事故、微信用户信息 创建时间：2017-08-15
	 * 
	 * @author guwenwen
	 */
	@RequestMapping("/wfjlcx.do")
	public void findByParam(HttpServletRequest request,
			HttpServletResponse response, BIllegalTipoffUser tipoff) {

		List<BIllegalTipoffUser> list = new ArrayList<BIllegalTipoffUser>();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("error", "");
		try {
			list = bIllegalTipooffService.selectByExample(tipoff);
		} catch (Exception e) {
			jsonObject.put("error", e);
			JSONUtil.writeJSONObjectToResponse(response, jsonObject);
			e.printStackTrace();
		}
		jsonObject.put("data", list);
		JSONUtil.writeJSONObjectToResponse(response, jsonObject);

	}

	@RequestMapping("/wfcheck.do")
	public void wfcheck(HttpServletRequest request,
			HttpServletResponse response, BIllegalTipoff btipoff) {
		String wfid = request.getParameter("wfid");
		String wfstate = request.getParameter("wfstate");
		btipoff.setId(wfid);
		btipoff.setStatus(wfstate);
		bIllegalTipooffService.updateByPrimaryKeySelective(btipoff);
		/* bIllegalTipooffService.updateState(wfid,wfstate); */
	}

}
