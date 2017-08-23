package com.csy.module.wx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csy.module.wx.dto.DriverAccident;
import com.csy.module.wx.entity.BAccidentDriver;
import com.csy.module.wx.entity.BWxFkyj;
import com.csy.module.wx.service.service.BAccidentInfoService;
import com.csy.module.wx.service.service.BWxFkyjService;
import com.csy.util.ExportExcel;
import com.csy.util.JSONUtil;
import com.csy.util.StringUtils;
import com.csy.util.TXGis;
import com.csy.util.TimeFormatUtil;
import com.csy.util.algorithm.RSAUtil;

@Controller
public class QuickLoseAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private BAccidentInfoService bAccidentInfoService;
	
	@Resource
	private BWxFkyjService bWxFkyjService;
	
	private static String Param = "";
	/**
	 * 说明:快处快赔查询页面
	 * 创建时间：2017-02-20 09:00
	 * @author wangyonghui
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/lose.do")
	public ModelAndView register(String param,HttpServletRequest req) throws Exception{
		  Map<String, Object> paramsMap  = new HashMap<String, Object>();
		  Calendar calendar = Calendar.getInstance();
		  String formatTime = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		  calendar.add(Calendar.DATE, - 7);  
		  String formatTime1 = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		  paramsMap.put("startTime", formatTime1);
		  paramsMap.put("endTime", formatTime);
		  if(!StringUtils.isNull(param)){
			  Param = param;
		  }
		  paramsMap.put("param", Param);
		  return new ModelAndView("lose/kckpcx",paramsMap);
	}
	/**
	 * 说明：根据事故发生时间、微信号、号牌号码去查询驾驶员、事故、微信用户信息
	 * 创建时间：2017-02-21 15:00
	 * @author wangyonghui
	 */
	@RequestMapping("/kckpcx.do")
	public void findByParam(HttpServletRequest request, HttpServletResponse response,DriverAccident accident){
		List<DriverAccident> list = new ArrayList<DriverAccident>();
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("error", "");
	    try {
	    	list = bAccidentInfoService.selectByExample(accident);
	    } catch (Exception e) {
	      jsonObject.put("error", e);
	      JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	      e.printStackTrace();
	    }
	    jsonObject.put("data", list);
	    JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	}
	/**
	 * 说明:反馈意见页面
	 * 创建时间：2017-03-13 10:00
	 * @author wangyonghui
	 * @return
	 */
	@RequestMapping("/fkyj.do")
	public ModelAndView queryFkyj(String param){
		 Map<String, Object> paramsMap  = new HashMap<String, Object>();
		  Calendar calendar = Calendar.getInstance();
		  String formatTime = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		  calendar.add(Calendar.DATE, - 7);  
		  String formatTime1 = TimeFormatUtil.timeToStr(calendar, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		  paramsMap.put("startTime", formatTime1);
		  paramsMap.put("endTime", formatTime);
		  return new ModelAndView("lose/fkyjcx",paramsMap);
	}
	/**
	 * 说明：根据条件查询反馈意见内容信息
	 * @param request
	 * @param response
	 * @param bwfkyj
	 * @author wangyonghui
	 * @since 2017-03-13 15:12
	 */
	@RequestMapping("/fkyjcx.do")
	public void fkyjcx(HttpServletRequest request, HttpServletResponse response,BWxFkyj bwfkyj){
		List<BWxFkyj> list = new ArrayList<BWxFkyj>();
	    JSONObject jsonObject = new JSONObject();
	    String page = request.getParameter("page");// 当前页
		String rows = request.getParameter("rows");// 每页显示数目
		int pageNum = 1;
		int pageSize = 10;
		int total  = 0;		
		if (page != null) {
			pageNum = Integer.parseInt(page);
		}
		if (rows != null) {
			pageSize = Integer.parseInt(rows);
		}
	    jsonObject.put("error", "");
	    RowBounds rowBounds = new RowBounds((pageNum-1)*pageSize,pageSize);
	    bwfkyj.setDescription(bwfkyj.getKssj());
	    bwfkyj.setImage(bwfkyj.getJssj());
	    bwfkyj.setId(bwfkyj.getNickName());
	    try {
	    	total = bWxFkyjService.countByMap(bwfkyj);
	    	list = bWxFkyjService.queryAllInfo(bwfkyj,rowBounds);
	    } catch (Exception e) {
	      jsonObject.put("error", e);
	      JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	      e.printStackTrace();
	    }
	    jsonObject.put("rows", list);
	    jsonObject.put("total", total);
	    JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	}
	/**
	 * 说明：标记有问题的图片
	 * 创建时间：2017-05-05 13:31
	 * @author wangyonghui
	 */
	@RequestMapping("/flagImage.do")
	public void update(HttpServletRequest request, HttpServletResponse response,String id,String num){
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("error", "");
	    String imageString = "";
	    try {
	    	imageString = bAccidentInfoService.updateByPrimaryKeySelective(id, num);
	    } catch (Exception e) {
	      jsonObject.put("error", e);
	      e.printStackTrace();
	    }
	    jsonObject.put("data", imageString);
	    JSONUtil.writeJSONObjectToResponse(response, jsonObject);
	}
	/**
	 * 数据导出
	 * queryDataExport(这里用一句话描述这个方法的作用)        
	 * author wangyonghui  
	 * 日期  2017年6月19日 上午9:41:03
	 * @param        
	 * @return void    
	 * @Exception 异常对象
	 */
	@RequestMapping("/queryDataExport.do")
	public void queryDataExport(HttpServletRequest request,HttpServletResponse response){
		DriverAccident statisticsParam = new DriverAccident();
		statisticsParam.setHphm(request.getParameter("hphm"));
		statisticsParam.setJssj(request.getParameter("jssj"));
		statisticsParam.setKssj(request.getParameter("kssj"));
		statisticsParam.setWxzh(request.getParameter("wxzh"));
		List<DriverAccident> list = bAccidentInfoService.selectByExample(statisticsParam);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String filename = df.format(new Date())+".xls";
		String[] headers= new String[] {};
		headers= new String[] {"发生日期","发生地点","经度","纬度","号牌号码","警情描述","备注"};
		// 导出数据列表
		List<String[]> datalist = new ArrayList<String[]>();
		// 导出数据
		ExportExcel<BAccidentDriver> ee = new ExportExcel<BAccidentDriver>();
		try {
			response.addHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(filename,"utf-8")  );
			response.setContentType("octets/stream");
			response.setCharacterEncoding("gbk");
			response.setContentType("application/octet-stream");
			if (null != list && list.size() > 0) {
				for(DriverAccident statisticsVehicleDataDTO:list){
					String sgdd = "";
					try {
						sgdd = TXGis.getAdd(statisticsVehicleDataDTO.getSgjd(), statisticsVehicleDataDTO.getSgwd());
						Thread.sleep(220);
					} catch (Exception e) {
						// TODO: handle exception
					}
					String[] st = new String[]{};
					String sgms = "";
					if(!StringUtils.isNull(statisticsVehicleDataDTO.getSgms())){
						sgms = statisticsVehicleDataDTO.getSgms();
					}
					if(null == statisticsVehicleDataDTO.getbDriverInfos() || statisticsVehicleDataDTO.getbDriverInfos().size() <= 0){
						// 数据封装成数组
						st = new String[] {
								String.valueOf(statisticsVehicleDataDTO.getSgsj()),sgdd,String.valueOf(statisticsVehicleDataDTO.getSgjd()),String.valueOf(statisticsVehicleDataDTO.getSgwd()),
								"",sgms,""
						};
					}else{
						String hphm = "";
						String bz = "";
						for(int i = 0 ; i < statisticsVehicleDataDTO.getbDriverInfos().size(); i++){
							if(i == 0){
								hphm = statisticsVehicleDataDTO.getbDriverInfos().get(i).getHphm();
							}else{
								bz = bz+statisticsVehicleDataDTO.getbDriverInfos().get(i).getHphm()+"  ";
							}
						}
						// 数据封装成数组
						st = new String[] {
								String.valueOf(statisticsVehicleDataDTO.getSgsj()),sgdd,String.valueOf(statisticsVehicleDataDTO.getSgjd()),String.valueOf(statisticsVehicleDataDTO.getSgwd()),
								hphm,sgms,bz
						};
					}
					// 数据添加到列表
					datalist.add(st);
				}
			}
			ee.exportExcel(headers, datalist, response.getOutputStream());
		} catch (Exception e) {
			logger.error("数据导出异常_"+filename, e);
		}
	}
}
