package com.csy.module.wx.bean.result;

import java.io.Serializable;

import net.sf.json.JSONObject;

/**
 * 微信错误码说明，请阅读： <a href="http://mp.weixin.qq.com/wiki/10/6380dc743053a91c544ffd2b7c959166.html">
 * 全局返回码说明</a>
 *
 * @author wangqiang
 */
public class WxError implements Serializable {

	private static final long serialVersionUID = 7869786563361406291L;

	private int errcode;

	private String errmsg;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "错误信息:" + JSONObject.fromObject(this).toString();
	}

	public static WxError newInstance(int errorCode, String errorMsg){
		WxError wxError = new WxError();
		wxError.errcode = errorCode;
		wxError.errmsg = errorMsg;
		return wxError;
	}
	
}
