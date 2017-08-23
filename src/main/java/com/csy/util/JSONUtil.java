/**
* @description 将List,Map,bean 等传递到页面 工具类 
* @since  2014/12/10
* @author 董新江
* @version 1.0
* @date 2014/12/10
* @see 用来引用其他参考
*/
package com.csy.util;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
public class JSONUtil {
	
	 //将JSONObject写入输出流
     public static void writeJSONObjectToResponse(HttpServletResponse response ,JSONObject jobject){
    	 PrintWriter out = null ;
    	 response.setCharacterEncoding("utf-8");
    	 response.setContentType("text/html;charset=utf-8");
    	 try {
			out = response.getWriter();
			out.print(jobject);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null !=out){
				out.close();
			}
		}
     }
	 //将JSONArray写入输出流
     public static void writeJSONArrayToResponse(HttpServletResponse response ,net.sf.json.JSONArray ja){
    	 PrintWriter out = null ;
    	 response.setCharacterEncoding("utf-8");
    	 response.setContentType("text/html;charset=utf-8");
    	 try {
			out = response.getWriter();
			out.print(ja);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null !=out){
				out.close();
			}
			
		}
     }
     
     /**
 	 * 字符串写到输出流
 	 * writeStringToResponse(这里用一句话描述这个方法的作用)        
 	 * author liuzhuo   
 	 * 日期  2016年1月23日 下午5:32:03
 	 * @param        
 	 * @return void    
 	 * @Exception 异常对象
 	 */
 	public static void writeStringToResponse(HttpServletResponse response ,String msg){
 		 PrintWriter out = null ;
     	 response.setCharacterEncoding("utf-8");
     	 response.setContentType("text/html;charset=utf-8");
     	 try {
 			out = response.getWriter();
 			out.print(msg);
 			out.flush();
 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally{
 			if(null !=out){
 				out.close();
 			}
 		}
 	}
 	
 	/**
	 * 向HttpServletResponse中写数据,设置ContentType为html/txt;charset=utf-8
	 * @param response
	 * @param text 要写入的数据
	 */
	public static void writeUtf8Text(HttpServletResponse response,String text){
		//response 相关处理
		response.setContentType("html/text;charset=utf-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		try {
			response.getWriter().write(text);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
