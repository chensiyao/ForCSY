package com.csy.util;

import java.net.URL;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TXGis {
	
	private static Logger logger = LoggerFactory.getLogger(TXGis.class);
     /**
      * 通过经纬度调用腾讯地图获取地理位置信息
      * @param log
      * @param lat
      * @author 王永辉
      * 创建时间 2017-06-19 14:39
      * @return
      */
    public static String getAdd(String log, String lat ){  
    	String location = lat +","+log;
        String urlString = "http://apis.map.qq.com/ws/geocoder/v1/?output=jsonp&key=5RTBZ-NPL3I-LK4GF-5FXGZ-EW2SH-VDFU2&get_poi=0&location="+location+"";  
        String res = "";     
        try {     
            URL url = new URL(urlString);    
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();    
            conn.setDoOutput(true);    
            conn.setRequestMethod("GET");  
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));    
            String line;    
            while ((line = in.readLine()) != null) {    
               res += line+"\n";    
            }    
            String newName = res.substring(res.indexOf("{"),res.lastIndexOf("}")+1);
            JSONObject object = (JSONObject) JSONObject.fromObject(newName).get("result");
            JSONObject json1 = (JSONObject) object.get("address_component");
            JSONObject json = (JSONObject) object.get("formatted_addresses");
            res = json1.get("province").toString()+json1.get("city")+json.get("recommend");
            in.close();    
        } catch (Exception e) {    
        	logger.error("error in wapaction,and e is " + e.getMessage());
        }   
        return res;    
    }
}
