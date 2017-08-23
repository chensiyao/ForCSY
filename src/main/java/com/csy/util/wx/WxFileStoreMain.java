package com.csy.util.wx;

import com.csy.util.WxConfig;

/**
 * 微信文件上传类
 * @author wangqiang
 */
public class WxFileStoreMain {

	public void startThread(){
		int i = WxConfig.getInstance().getDownloadThreadNum();
		for(int j=0; j<i; j++){
			Thread thread = new WxFileStoreThread();
			thread.start();
		}
	}
}
