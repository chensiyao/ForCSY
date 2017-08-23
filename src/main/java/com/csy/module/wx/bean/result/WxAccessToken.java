package com.csy.module.wx.bean.result;

import java.io.Serializable;

import com.csy.util.wx.AccessTokenUtil;

import net.sf.json.JSONObject;

public class WxAccessToken implements Serializable {
	
	private static final long serialVersionUID = 8709719312922168909L;

	private String access_token;

	private long expires_in = -1;

	private String refresh_token;

	private String openid;

	private String scope;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public void refresh(){
		AccessTokenUtil.refreshToken(this);
	}
	
	@Override
	public String toString(){
		return "授权信息：" + JSONObject.fromObject(this).toString();
	}
}
