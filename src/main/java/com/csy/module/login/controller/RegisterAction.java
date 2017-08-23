package com.csy.module.login.controller;

import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.login.service.service.RegisterService;
import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.util.StringUtils;
import com.csy.util.algorithm.RSAUtil;

@Controller
public class RegisterAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private BuserAccountService accountService;
	
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest req) throws Exception{
		RSAUtil.generateKeyPair();
		Map<String, Object> param = new HashMap<String, Object>();
		req.getSession(true).setAttribute("privateKey", RSAUtil.PRIVATEKEY);
		param.put("publicKey", RSAUtil.PUBLICKEY.getModulus().toString(16));
		param.put("publicExponent", RSAUtil.PUBLICKEY.getPublicExponent().toString(16));
		return new ModelAndView("login/register",param);
	}
	
	@RequestMapping("/register/emailAccount")
	public void registerAccount(HttpServletRequest req, HttpServletResponse res
			,BUserAccount account) throws IOException{
		JSONObject jsonObject = new JSONObject();
		try {
			byte[] en_result = RSAUtil.hexStringToBytes(account.getPassword()); 
			byte[] de_result = RSAUtil.decrypt((RSAPrivateKey)req.getSession(true).getAttribute("privateKey"), en_result);  
			StringBuffer sb = new StringBuffer();  
			sb.append(new String(de_result));  
			String descPassword = sb.reverse().toString();
			account.setPassword(descPassword);
			registerService.insertAccount(account);
			jsonObject.put("success", "success");
			jsonObject.put("account", account.getAccount());
		} catch (Exception e){
			logger.info(account.getAccount()+"添加失败！", e);
			jsonObject.put("errorMsg", e.getMessage());
		}
		res.getWriter().print(jsonObject);
	}
	
	@RequestMapping("/register/accountIsExist")
	public void accountIsExist(HttpServletRequest req, HttpServletResponse res
			, String account,String email,String phone) throws IOException{
		Map<String, Object> paramMap = new HashMap<String, Object>(); 
		if(!StringUtils.isTrimEmpty(account)){
			paramMap.put("account", account);
		}
		if(!StringUtils.isTrimEmpty(email)){
			paramMap.put("email", email);
		}
		if(!StringUtils.isTrimEmpty(phone)){
			paramMap.put("phone", phone);
		}
		boolean b = accountService.isAlreayExist(paramMap);
		res.getWriter().print(b);
	}
}
