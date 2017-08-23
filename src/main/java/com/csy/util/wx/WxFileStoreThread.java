package com.csy.util.wx;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csy.util.FileUtils;
import com.csy.util.WxConfig;
import com.csy.util.wx.queue.FileQueue;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

/**
 * 2017-020-22
 * @author wangqiang
 * 微信图片存储
 */

public class WxFileStoreThread extends Thread{

	private static Logger logger = LoggerFactory.getLogger(AccessTokenUtil.class);
	
	private static final String RESOURCE_PATH = WxConfig.getInstance().getResourceStore();
	
	private static final String WX_DOWNLOAD_PATH = "http://file.api.weixin.qq.com/cgi-bin/media/get";
	
	@Override
	public void run() {
		while (true) {
			//线程休眠
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			FileQueue.FileDescription fileDetail = FileQueue.getInstance().get();
			if(fileDetail != null){
				boolean b = false;
				int i=0;
				//十次执行都失败的话 就放弃该数据
				while (!b && i<3) {
					String filePath = RESOURCE_PATH + fileDetail.getStorePath();
					try {
						String fileDownPath = WX_DOWNLOAD_PATH + "?access_token=" + WxConfig.getInstance().getAccess_token()
								+ "&media_id=" + fileDetail.getServerId();
						logger.info("access_token:"+WxConfig.getInstance().getAccess_token());
						logger.info("media_id:"+fileDetail.getServerId());
						URL urlGet = new URL(fileDownPath);
						URLConnection connection = (URLConnection) urlGet.openConnection();
						connection.setConnectTimeout(2000);
						connection.setReadTimeout(30000);
						connection.connect();
						InputStream is = connection.getInputStream();
						
						//文件存储时,先存储.amr格式,后续再进行格式转换为mp3
						b = FileUtils.saveFile(is, filePath, fileDetail.getFileName().replace(".mp3", ".amr"));
					} catch (Exception e) {
						logger.error("文件下载失败:{文件名"+fileDetail.getServerId()+"},错误信息:"+e.getMessage());
						e.printStackTrace();
					}
					if(!b){
						i++;
						continue;
					}
					//如果是语音文件需要进行转换成mp3格式
					if(fileDetail.getFileName().endsWith(".mp3")){
						String targetPath = filePath + File.separator + fileDetail.getFileName();
						String sourcePath = targetPath.replace(".mp3", ".amr");
						changeToMp3(sourcePath, targetPath);
					}
				}
				
				//如果是多次下载失败的数据
				if(!b){
					FileQueue.fileStoreError(fileDetail);
				}else{
					FileQueue.fileStoreSuccess(fileDetail);
				}
			}
		}
	}
	
	/**
	 * 音频转换需要调用exe文件.多线程情况下禁止调用
	 */
	public static void changeToMp3(String sourcePath, String targetPath) {
		synchronized (RESOURCE_PATH) {
			File source = new File(sourcePath);
			File target = new File(targetPath);
			AudioAttributes audio = new AudioAttributes();
			Encoder encoder = new Encoder();
			audio.setCodec("libmp3lame");
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("mp3");
			attrs.setAudioAttributes(audio);
			try {
				encoder.encode(source, target, attrs);
				source.delete();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InputFormatException e) {
				e.printStackTrace();
			} catch (EncoderException e) {
				if(e.getMessage().indexOf("bitrate: N/A") > -1){
					source.delete();
				}else{
					e.printStackTrace();
					logger.info("微信amr转mp3失败:" + e.getMessage());
				}
			}
		}
	}
}
