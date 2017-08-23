package com.csy.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * 获取外网ip
 * @author 王永辉
 *
 */
public class GetExtranetIp {
/**
 * 通过ip138方式获取外网ip
 * @param strUrl
 * @return
 */
public static String getWebIp() {
	String webContent = "";
	try {
	   URL url = new URL("http://www.ip138.com/ip2city.asp");
	   BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	   String s = "";
	   StringBuffer sb = new StringBuffer("");
	   while ((s = br.readLine()) != null) {
	    sb.append(s + "\r\n");
	   }
	   br.close();
	   webContent = sb.toString();
	   int start = webContent.indexOf("[")+1;
	   int end = webContent.indexOf("]");
	   webContent = webContent.substring(start,end);
	 } catch (Exception e) {
	   e.printStackTrace();
	 }
	return webContent;
  }
}