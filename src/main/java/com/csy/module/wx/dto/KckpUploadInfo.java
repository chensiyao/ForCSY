package com.csy.module.wx.dto;

import java.util.List;

import com.csy.module.wx.entity.BAccidentInfo;
import com.csy.module.wx.entity.BDriverInfo;

public class KckpUploadInfo extends BAccidentInfo{
	
	private List<BDriverInfo> jsyxxs;

	public List<BDriverInfo> getJsyxxs() {
		return jsyxxs;
	}

	public void setJsyxxs(List<BDriverInfo> jsyxxs) {
		this.jsyxxs = jsyxxs;
	}
	
}
