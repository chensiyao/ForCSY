package com.csy.util.wx;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csy.module.wx.bean.result.WxAccessToken;
import com.csy.module.wx.bean.result.WxError;
import com.csy.module.wx.dto.BWxUserDto;
import com.csy.util.WxConfig;

import net.sf.json.JSONObject;

/**
 * 用户授权access_token管理
 * @author wangqiang
 *
 */
public class AccessTokenUtil {

	private static Logger logger = LoggerFactory.getLogger(AccessTokenUtil.class);
	
	/**
	 * 获取微信用户信息
	 * @param accessToken
	 */
	public static Object getWxUserInfo(final WxAccessToken accessToken){
		
		accessToken.refresh();
		
		String url = "https://api.weixin.qq.com/sns/userinfo?"
				+ "access_token=" + accessToken.getAccess_token() 
				+ "&openid=" + accessToken.getOpenid() + "&lang=zh_CN ";
		
		logger.info("微信用户信息url:" + url);
		
		Object object = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String rst = new String(jsonBytes, "UTF-8");
			
			logger.info("授权返回码:" + rst);
			
			//返回结果转换
			@SuppressWarnings("static-access")
			JSONObject jsonObject = new JSONObject().fromObject(rst);
			if(jsonObject.containsKey("errcode")){
				object = JSONObject.toBean(jsonObject, WxError.class);
				logger.error(jsonObject.toString());
			}else{
				object = ((BWxUserDto)JSONObject.toBean(jsonObject, BWxUserDto.class)).parseToBWxUser();
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			object = WxError.newInstance(-1, e.getMessage());
		}
		return object;
	}
	
	/**
	 * 刷新accessToken
	 * @param accessToken
	 */
	public static void refreshToken(final WxAccessToken accessToken){
		String appid = WxConfig.getInstance().getAppid();
		
		final String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?"
						+ "appid=" + appid+ "&grant_type=refresh_token"
						+ "&refresh_token=" + accessToken.getRefresh_token();
		
		logger.info("refresh微信授权的url:" + url);
		
		//不影响现有进程的情况下刷新accessToken
		new Runnable() {
			@Override
			public void run() {
				//如果数据已经过期, 则无限刷新, 最多刷新10次
				int i = 0;
				while (new Date().getTime() > accessToken.getExpires_in() && i < 10) {
					i++;
					try {
						URL urlGet = new URL(url);
						HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
						http.setRequestMethod("GET"); // 必须是get方式请求
						http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						http.setDoOutput(true);
						http.setDoInput(true);
						System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
						System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
						http.connect();
						InputStream is = http.getInputStream();
						int size = is.available();
						byte[] jsonBytes = new byte[size];
						is.read(jsonBytes);
						String rst = new String(jsonBytes, "UTF-8");
						
						logger.info("refresh授权返回码:" + rst);
						
						//返回结果转换
						@SuppressWarnings("static-access")
						JSONObject jsonObject = new JSONObject().fromObject(rst);
						if(jsonObject.containsKey("errcode")){
							logger.error("refresh失败:" + jsonObject.toString());
							
						}else{
							//refresh成功后 直接克隆对象
							WxAccessToken tempToken2 = (WxAccessToken)JSONObject.toBean(jsonObject, WxAccessToken.class);
							accessToken.setAccess_token(tempToken2.getAccess_token());
							//设置过期时间为有效期前200秒
							accessToken.setExpires_in(new Date().getTime() + (tempToken2.getExpires_in() - 200)*1000);
							accessToken.setOpenid(tempToken2.getOpenid());
							accessToken.setRefresh_token(tempToken2.getRefresh_token());
							accessToken.setScope(tempToken2.getScope());
						}
						is.close();
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("refresh失败:" + e.getMessage());
					}
				}
			}
		};
	}
	
	/**
	 * 首次获取accessToken
	 * @param code
	 * @return
	 */
	public static Object getOAuth2AccessToken(String code) {
		
		String appid = WxConfig.getInstance().getAppid();
		String appsecret = WxConfig.getInstance().getAppsecret();
		
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appid +"&secret=" + appsecret + "&code=" + code 
				+ "&grant_type=authorization_code";
		
		logger.info("微信授权的url:" + url);
		
		Object object = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String rst = new String(jsonBytes, "UTF-8");
			
			logger.info("授权返回码:" + rst);
			
			//返回结果转换
			@SuppressWarnings("static-access")
			JSONObject jsonObject = new JSONObject().fromObject(rst);
			if(jsonObject.containsKey("errcode")){
				object = JSONObject.toBean(jsonObject, WxError.class);
				logger.error(jsonObject.toString());
				
			}else{
				WxAccessToken token= (WxAccessToken)JSONObject.toBean(jsonObject, WxAccessToken.class);
				//设置过期时间为有效期前200秒
				token.setExpires_in(new Date().getTime() + (token.getExpires_in() - 200)*1000);
				object = token;
			}
			
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			object = WxError.newInstance(-1, e.getMessage());
		}
		return object;
	}
}
