package com.csy.module.wx.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.wx.bean.result.WxAccessToken;
import com.csy.module.wx.bean.result.WxError;
import com.csy.module.wx.entity.BWxUser;
import com.csy.module.wx.service.service.BWxUserService;
import com.csy.util.wx.AccessTokenUtil;
import com.csy.util.wx.Sign;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("wx")
public class BasicAuthController {
  
  @Autowired
  private BWxUserService       wxUserService;
	
	@RequestMapping("sign")
	@ResponseBody
	public void baseAuthorize(HttpServletRequest request, 
			HttpServletResponse response,String url) throws IOException{
		Map<String, String> map = Sign.sign(url);
		JSONObject object = JSONObject.fromObject(map);
		response.getWriter().println(object);
	}
	
 /**
  * 静默授权页面
  * @param request
  * @param response
  * @return
  */
 @RequestMapping("baseAuthorize")
 public ModelAndView baseAuthorize(HttpServletRequest request){
   return new ModelAndView("/weixin/baseAuthorize");
 }

 /**
  * 用户授权页面
  * @param request
  * @param response
  * @return
  */
 @RequestMapping("userinfoAuthorize")
 public ModelAndView userinfoAuthorize(HttpServletRequest request){
   return new ModelAndView("/weixin/userinfoAuthorize");
 }

	
	@RequestMapping("accountInfo")
	public void baseAuth(HttpServletRequest request, HttpServletResponse response, String code, String state) throws IOException{
	  
   HttpSession session = request.getSession(true);

   Object object = AccessTokenUtil.getOAuth2AccessToken(code);
   // 如果验证正常
   if(object instanceof WxAccessToken){
     WxAccessToken accessToken = (WxAccessToken) object;
     Object object2 = AccessTokenUtil.getWxUserInfo(accessToken);
     // 如果用户信息获取失败
     if(object2 instanceof WxError){
       WxError wxError = (WxError) object2;
       // 如果授权过期或者未授权
       if(42001 == wxError.getErrcode() || 48001 == wxError.getErrcode()){
         response.sendRedirect(session.getServletContext().getContextPath() + "/wx/userinfoAuthorize");
       }
     }
     // 如果成功获取到用户信息，则新增或者更新用户信息
     else{
       BWxUser wxUserUpdated = (BWxUser) object2;
       BWxUser wxUser = wxUserService.selectByPrimaryKey(accessToken.getOpenid());
       // 如果从未存储过该用户,新增该用户
       if(wxUser == null){
         wxUserService.insert(wxUserUpdated);
       }
       // 如果用户已经存在，更新用户信息
       else{
         wxUserService.updateByPrimaryKey(wxUserUpdated);
       }
       session.setAttribute("bWxUser", wxUserUpdated);
       String targetUrl = (String)session.getAttribute("wx_targetUrl");
       if(targetUrl != null){
         response.sendRedirect(targetUrl);
         session.removeAttribute("wx_targetUrl");
       }else{
         response.sendRedirect(session.getServletContext().getContextPath() + "/wx/index");
       }
     }
   }
   // 验证不通过直接抛回原来的页面吧
   else{
     WxError wxError = (WxError) object;
     // 如果收code过期,或者已近被使用, 抛回静默授权页面
     if(42003 == wxError.getErrcode() || 40163 == wxError.getErrcode() || 40029 == wxError.getErrcode()){
       response.sendRedirect(session.getServletContext().getContextPath() + "/wx/baseAuthorize");
     }else{
       response.setStatus(500);
     }
   }
	}
	
}
