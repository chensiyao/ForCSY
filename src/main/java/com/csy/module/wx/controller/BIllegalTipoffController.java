package com.csy.module.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.wx.entity.BIllegalTipoff;
import com.csy.module.wx.entity.BWxUser;
import com.csy.module.wx.service.service.BIllegalTipoffService;
import com.csy.util.JSONUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("wx/tipoff")
public class BIllegalTipoffController{
  
  @Autowired
  private BIllegalTipoffService tipoffService;

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @RequestMapping("/index")
  public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
    ModelAndView mv = new ModelAndView("weixin/tipoff");
    return mv;
  }

  @RequestMapping(method = RequestMethod.POST)
  public void post(HttpServletRequest request, HttpServletResponse response, @RequestBody BIllegalTipoff tipoff){
    JSONObject rst = null;
    BWxUser wxUser = (BWxUser) request.getSession(true).getAttribute("bWxUser");
    if(wxUser == null){
      rst = new JSONObject();
      rst.put("errMsg", "未抓取到上传用户信息");
    }else{
      rst = new JSONObject();
      try{
        tipoff.setPlateNumber(tipoff.getPlateNumber().toUpperCase());
        tipoff.setFkWxOpenid(wxUser.getOpenid());
        tipoffService.addTipOff(tipoff);
        rst.put("errMsg", "");
      }catch(Exception e){
        rst.put("errMsg", e.getMessage());
        e.printStackTrace();
        logger.error(e.getMessage());
      }
    }
    JSONUtil.writeJSONObjectToResponse(response, rst);
  }
}
