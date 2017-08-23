package com.csy.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class WxConfig {
	
	private static final WxConfig WX_CONFIG = new WxConfig();
	
	private static final String WX_CONFIG_LOCAL = "/weixin.properties";
	
	private String appid;
	
	private String appsecret;
	
	private String resourceStore;
	
	private int downloadThreadNum;
	
	private String access_token;
	
	private String jsapi_ticket;
	
	public String getResourceStore() {
		return resourceStore;
	}

	public void setResourceStore(String resourceStore) {
		this.resourceStore = resourceStore;
	}

	public int getDownloadThreadNum() {
		return downloadThreadNum;
	}

	public void setDownloadThreadNum(int downloadThreadNum) {
		this.downloadThreadNum = downloadThreadNum;
	}

	public String getJsapi_ticket() {
		return jsapi_ticket;
	}

	public void setJsapi_ticket(String jsapi_ticket) {
		this.jsapi_ticket = jsapi_ticket;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getAppid() {
		return appid;
	}
	
	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	public String getAppsecret() {
		return appsecret;
	}
	
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public static WxConfig getInstance(){
		return WX_CONFIG;
	}
	
	static{
		//微信配置读取
		Properties properties;
		try {
			properties = PropertiesLoaderUtils.loadAllProperties(WX_CONFIG_LOCAL);
			WX_CONFIG.setAppid(properties.getProperty("appid"));
			WX_CONFIG.setAppsecret(properties.getProperty("appsecret"));
			WX_CONFIG.setDownloadThreadNum(Integer.parseInt(properties.getProperty("downloadThreadNum")));
			WX_CONFIG.setResourceStore(properties.getProperty("resourceStore"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
