package com.csy.util.wx.queue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.csy.util.TimeFormatUtil;
import com.csy.util.wx.en.WxFileEnum;

/**
 * 文件拉取队列
 * @author wangqiang
 */
public class FileQueue {
	
	public static final Object LOCAL_OBJ = new Object();
	
	public static final FileQueue FILE_QUEUE = new FileQueue();
	
	/****待下载队列***/
	private final List<FileDescription> queue = Collections.synchronizedList(new ArrayList<FileDescription>());
	
	/***正在下载队列**/
	private final List<FileDescription> downQueue = Collections.synchronizedList(new ArrayList<FileDescription>());

	/***正在下载队列**/
	private final List<FileDescription> errorQueue = Collections.synchronizedList(new ArrayList<FileDescription>());
	
	public void add(FileDescription fileDescription){
		FILE_QUEUE.queue.add(fileDescription);
	}
	
	public boolean remove(FileDescription fileDescription){
		return FILE_QUEUE.downQueue.remove(fileDescription);
	}
	
	public FileDescription get(){
		synchronized (LOCAL_OBJ) {
			if(FILE_QUEUE.queue.size() == 0) return null;
			FileDescription fileDescription = FILE_QUEUE.queue.remove(0);
			FILE_QUEUE.downQueue.add(fileDescription);
			return fileDescription;
		}
	}
	
	public static boolean fileStoreSuccess(FileDescription fileDescription){
		return FILE_QUEUE.downQueue.remove(fileDescription);
	}

	public static void fileStoreError(FileDescription fileDescription){
		FILE_QUEUE.downQueue.remove(fileDescription);
		FILE_QUEUE.errorQueue.add(fileDescription);
	}
	
	public static FileQueue getInstance(){
		return FILE_QUEUE;
	}
	
	/**
	 * 队列的内部类
	 */
	public class FileDescription{
		private String serverId;
		private String openId;
		private String fileName;
		private WxFileEnum fileType;
		private Date uploadTime;
		
		public FileDescription(String serverId, String openId, String fileName,WxFileEnum fileType, Date uploadTime) {
			this.serverId = serverId;
			this.openId = openId;
			this.fileName = fileName;
			this.fileType = fileType;
			this.uploadTime = uploadTime;
		}
		
		public String getFileName(){
			return this.fileName;
		}
		
		public String getServerId(){
			return this.serverId;
		}
		
		public WxFileEnum getFileType(){
			return this.fileType;
		}
		
		public String getStorePath(){
			String time = TimeFormatUtil.dateToString(uploadTime, "yyyy-MM-dd");
			return File.separator + time + File.separator + openId + File.separator;
		}
	}
}
