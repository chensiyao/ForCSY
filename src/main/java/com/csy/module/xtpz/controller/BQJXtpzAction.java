package com.csy.module.xtpz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csy.module.xtpz.entity.BXtpzDmx;
import com.csy.util.DmxUtil;
import com.csy.util.JSONUtil;
import com.csy.util.XtpzUtil;

@Controller
public class BQJXtpzAction {
	
   @RequestMapping("/xtpz")
   public void getIllegalInfo(HttpServletRequest request, HttpServletResponse response){
    List<BXtpzDmx> list = new ArrayList<BXtpzDmx>();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("error", "");
    try {
    	list = DmxUtil.getDmxList(8);
        jsonObject.put("cysf", XtpzUtil.getXtpzByName("cysf"));
    } catch (Exception e) {
      jsonObject.put("error", e);
      JSONUtil.writeJSONObjectToResponse(response, jsonObject);
      e.printStackTrace();
    }
    jsonObject.put("data", list);
    JSONUtil.writeJSONObjectToResponse(response, jsonObject);
  } 
}
