package com.csy.module.login.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.interfaces.RSAPrivateKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.user.entity.BUserAccount;
import com.csy.module.user.service.service.BuserAccountService;
import com.csy.module.wx.entity.BQjMenu;
import com.csy.module.wx.service.service.BQjMenuService;
import com.csy.util.GetExtranetIp;
import com.csy.util.JSONUtil;
import com.csy.util.ObjectUtils;
import com.csy.util.SecurityCodeImg;
import com.csy.util.StringUtils;
import com.csy.util.TimeFormatUtil;
import com.csy.util.algorithm.MD5Util;
import com.csy.util.algorithm.RSAUtil;
import com.csy.util.exception.account.EmailNotActivatedException;
import com.csy.util.exception.account.PhoneNotActivatedException;
import com.csy.util.exception.account.UserNotUniqueException;


@Controller
public class LoginAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BuserAccountService accountService;
	@Resource
	private BQjMenuService bQjSubsystemMenuService;
	
	private static int Flag = 0;
	private static Map<String,Calendar> map = new HashMap<String, Calendar>();
	public static String imageCode = "";
	
	@RequestMapping("/login.do")
	public ModelAndView index(HttpServletRequest req){
		req.getSession(true).setAttribute("user", null);
		return new ModelAndView("login/login");
	}
	
	@RequestMapping("/login/accountLogin")
	public void accountLogin(HttpServletRequest req,HttpServletResponse res
			,String account,String password,String isCache) throws IOException{
		
		JSONObject jsonObject = new JSONObject();
		try {
			if(!map.isEmpty() && map.containsKey(account)){
				Calendar calendar = map.get(account); 
				calendar.add(Calendar.DATE,+1);
				String formatTime = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				Date date = TimeFormatUtil.StringToDate(formatTime, "yyyy-MM-dd HH:mm:ss");
				if(new Date().getTime() - date.getTime() > 0){//已经超过一天时间，可以进行登录
					map.clear();
					BUserAccount user = accountService.loginUser(account, password);
					if(ObjectUtils.isNull(user)){
						jsonObject.put("errorMsg", "帐号或密码不正确!");
						Flag ++;
					}else{
						if(checkIp(account)){//验证通过
							jsonObject.put("success", "验证通过!");
							jsonObject.put("account_id", user.getId());
							req.getSession(true).setAttribute("user", user);
						}else{
							jsonObject.put("errorMsg", "用户绑定的外网ip不正确！");
						}
					}
					if(Flag >= 4){
						jsonObject.put("errorMsg", "输入账号或者密码错误超过3次，一天后才能正常使用登录");
						map.put(account, Calendar.getInstance());
						Flag = 0;
					}
				}else{
					jsonObject.put("errorMsg", "输入账号或者密码错误超过3次，一天后才能正常使用登录");
				}
			}else{
				BUserAccount user = accountService.loginUser(account, password);
				if(ObjectUtils.isNull(user)){
					jsonObject.put("errorMsg", "帐号或密码不正确!");
					Flag ++;
				}else{
					if(checkIp(account)){//验证通过
						jsonObject.put("success", "验证通过!");
						jsonObject.put("account_id", user.getId());
						req.getSession(true).setAttribute("user", user);
					}else{
						jsonObject.put("errorMsg", "用户绑定的外网ip不正确！");
					}
				}
				if(Flag >= 4){
					jsonObject.put("errorMsg", "输入账号或者密码错误超过3次，一天后才能正常使用登录");
					map.put(account, Calendar.getInstance());
					Flag = 0;
				}
			}
		} catch (UserNotUniqueException e) {
			jsonObject.put("errorMsg", "后台服务异常!");
			logger.info(account,e);
		} catch (EmailNotActivatedException e) {
			jsonObject.put("errorMsg", "邮箱未激活，无法登录!");
		} catch (PhoneNotActivatedException e) {
			jsonObject.put("errorMsg", "手机未激活，无法登录!");
		} catch (Exception e) {
			jsonObject.put("errorMsg", "帐号或密码不正确!");
			e.printStackTrace();
		}
		res.getWriter().print(jsonObject);
	}
	
	@RequestMapping("login/securityCodeImg")
	public void SecurityCodeImg(HttpServletRequest req,
			HttpServletResponse response) throws IOException {
		SecurityCodeImg securityCodeImg = new SecurityCodeImg();
		req.getSession(true).setAttribute("login_security", securityCodeImg.getSecurityCode());
		securityCodeImg.outPutStream(response);
	}
	
	@RequestMapping("login/securityCodeCheck")
	public void SecurityCodeImg(HttpServletRequest req,
			HttpServletResponse response,String securityCode) throws IOException {
		String realCode = (String)req.getSession(true).getAttribute("login_security");
		imageCode = securityCode;
		boolean b=false;
		if(realCode!=null && realCode.toUpperCase().equals(securityCode.toUpperCase()))
			b=true;
		response.getWriter().print(b);
	}
	/**
	 * 创建时间：2017-06-12 16:44
	 * 创建人：wangyonghui
	 * @param req
	 * @param res
	 * @param oldPwd
	 * @param newPwd
	 */
	@RequestMapping("login/modifyPassword.do")
	public void update(HttpServletRequest req,HttpServletResponse res,String oldPwd,
			String newPwd){
		JSONObject jsonObject = new JSONObject(); 
		try {
			jsonObject.put("error", "");
			if(StringUtils.isEmpty(oldPwd)){
				jsonObject.put("error", "原密码不能为空");
				JSONUtil.writeJSONObjectToResponse(res, jsonObject);
				return ;
			}
			if(StringUtils.isEmpty(newPwd)){
				jsonObject.put("error", "新密码不能为空");
				JSONUtil.writeJSONObjectToResponse(res, jsonObject);
				return ;
			}
			BUserAccount user = (BUserAccount) req.getSession(true).getAttribute("user");
			String encryptPassword = user.getPassword();
			if(!encryptPassword.equals(oldPwd)){
				jsonObject.put("error", "原密码输入错误");
				JSONUtil.writeJSONObjectToResponse(res, jsonObject);
				return ;
			}else{
				byte[] en_result = RSAUtil.hexStringToBytes(newPwd); 
				byte[] de_result = RSAUtil.decrypt((RSAPrivateKey)req.getSession(true).getAttribute("key"), en_result); 
				String descPassword = URLDecoder.decode(new StringBuffer(new String(de_result)).reverse().toString());
				//对新密码加密
				user.setPassword(MD5Util.MD5(MD5Util.MD5(descPassword)));
				accountService.updateByPrimaryKeySelective(user);
			}
		} catch (Exception e) {
			jsonObject.put("error", "修改密码失败!");
			e.printStackTrace();
		}
		JSONUtil.writeJSONObjectToResponse(res, jsonObject);
	}
	/**
	 * 通过用户绑定的ip，判断此用户所对应的外网ip是否一致
	 * @param account
	 * @return
	 */
	public boolean checkIp(String account){
		boolean flag = false;
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties("userNet.properties");
			String userIp = properties.getProperty(account);
			if(null == userIp){
				flag = true;
				logger.error("此用户没有绑定ip:"+account);
			}else{
				String ip = GetExtranetIp.getWebIp();
				if(userIp.equals(ip)){
					flag = true;
				}else{
					flag = false;
				}
			}
		} catch (IOException e) {
			logger.error("checkIp is error:"+e);
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 登录时候直接进行页面链接
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/frame_main.do")
    public ModelAndView main(HttpServletRequest request) throws Exception{
		Map<String, Object> paramsMap  = new HashMap<String, Object>();
		RSAUtil.generateKeyPair();
		request.getSession(true).setAttribute("key", RSAUtil.PRIVATEKEY);
		paramsMap.put("publicKey", RSAUtil.PUBLICKEY.getModulus().toString(16));
		paramsMap.put("publicExponent", RSAUtil.PUBLICKEY.getPublicExponent().toString(16));
        return new ModelAndView("login/main",paramsMap);
    }
	/**
	 *  根据节点名称获取子系统菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/frame_getSubSystemMenu.do")
	public void frame_getSubSystemMenu(HttpServletRequest request,HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", true);
		jsonObject.put("msg", "");
		//菜单节点级别
		short pageJdjb = 3;
		try {
			String fjd = request.getParameter("fjd");
			if(null != fjd && fjd.length() > 0)
			{
				//取菜单数据
				BQjMenu bQjSubsystemMenu = new BQjMenu();
				bQjSubsystemMenu.setFjd(fjd);
				bQjSubsystemMenu.setSfxs(1);
				List<BQjMenu> list  = bQjSubsystemMenuService.selectSubSystemMenu(bQjSubsystemMenu);
				if(null != list && list.size()>0)
				{
					for(int i=0;i<list.size();i++)
					{
						BQjMenu entity = (BQjMenu)list.get(i);
						if( pageJdjb != entity.getJdjb())
						{
							continue;
						}
						//得到菜单表的接口名称
						String url = entity.getLjymmc();
						if(null != url && !url.contains("http://"))
						{
							url ="./" + url;
							entity.setLjymmc(url);
						}
					}
					jsonObject.put("data", list);
				}
				else {
					jsonObject.put("data", "{}");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("success", false);
			jsonObject.put("msg",e.getMessage());
		}
		JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	}
}
