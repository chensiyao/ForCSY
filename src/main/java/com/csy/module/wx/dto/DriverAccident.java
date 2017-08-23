package com.csy.module.wx.dto;

import java.util.ArrayList;
import java.util.List;

import com.csy.module.wx.entity.BDriverInfo;

public class DriverAccident {
	
	
	private String kssj;//事故开始时间
	
	private String jssj;//事故结束时间
	
	private String sgsj;//事故发生时间
	
	private String wxzh;//微信账号
	
	private String wxtx;//微信头像
	private String wxid;//微信id
	
	private String sgdd;//事故发生地点
	private String sgjd;//事故经度
	private String sgwd;//事故纬度
	
	private String sgzr;//事故责任
	
	private String sgms;//事故描述
	private String liveImage;//现场关于事故的一些图片
	private String liveVoice;//现场事故的一些录音
	private String imagePath;
	private String accdientId;
	private String imageUploadIndex;
	private List<BDriverInfo> bDriverInfos = new ArrayList<BDriverInfo>();
	public String getImageUploadIndex() {
		return imageUploadIndex;
	}

	public void setImageUploadIndex(String imageUploadIndex) {
		this.imageUploadIndex = imageUploadIndex;
	}

	private String hphm;//号牌号码
	public String getAccdientId() {
		return accdientId;
	}

	public void setAccdientId(String accdientId) {
		this.accdientId = accdientId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getLiveImage() {
		return liveImage;
	}

	public void setLiveImage(String liveImage) {
		this.liveImage = liveImage;
	}

	public String getLiveVoice() {
		return liveVoice;
	}

	public void setLiveVoice(String liveVoice) {
		this.liveVoice = liveVoice;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public List<BDriverInfo> getbDriverInfos() {
		return bDriverInfos;
	}

	public void setbDriverInfos(List<BDriverInfo> bDriverInfos) {
		this.bDriverInfos = bDriverInfos;
	}

	public String getSgjd() {
		return sgjd;
	}

	public void setSgjd(String sgjd) {
		this.sgjd = sgjd;
	}

	public String getSgwd() {
		return sgwd;
	}

	public void setSgwd(String sgwd) {
		this.sgwd = sgwd;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public String getSgsj() {
		return sgsj;
	}

	public void setSgsj(String sgsj) {
		this.sgsj = sgsj;
	}

	public String getWxzh() {
		return wxzh;
	}

	public void setWxzh(String wxzh) {
		this.wxzh = wxzh;
	}

	public String getWxtx() {
		return wxtx;
	}

	public void setWxtx(String wxtx) {
		this.wxtx = wxtx;
	}
	public String getSgdd() {
		return sgdd;
	}

	public void setSgdd(String sgdd) {
		this.sgdd = sgdd;
	}

	public String getSgzr() {
		return sgzr;
	}

	public void setSgzr(String sgzr) {
		this.sgzr = sgzr;
	}

	public String getSgms() {
		return sgms;
	}

	public void setSgms(String sgms) {
		this.sgms = sgms;
	}
	
}
