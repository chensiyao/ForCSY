
$(function() {
	initResize();
	//初始化尺寸
	$(window).resize(function(){
		initResize();
	});
	initComponent();
	$('#user-name').val($('#hidden_param').val());
	btnSearch();

	
});
function initResize(){
	var  winWidth = $(window).width();//窗口宽度
	var  winHeight = $(window).height();//窗口高度
	$(".wholessp-div").width(winWidth); //整体的宽度
	$(".wholessp-div").height(winHeight - 10);//整体的高度
	$(".main-top").height(winHeight-10);//整体的高度
	$('.main-top1').height($('.wholessp-div').height()-20);
	$('.main-top1').width($('.main-top').width()-40);
	$('#dataGrid').width($('.main-top1').width());
	$('#dataGrid').height(($('.main-top1').height()/100)*10);
	
	$('#mainDiv1').height($('.wholessp-div').height() - $('#dataGrid').height()-$('.lbtitleDiv').height()-20);
	$('#mainDiv1').width(($('.main-top1').width()/100)*25);
	$('#mainDiv2').height($('.wholessp-div').height() - $('#dataGrid').height()-$('.lbtitleDiv').height()-20);
	$('#mainDiv2').width(($('.main-top1').width()/100)*75);

}

//注册点击事件
function initComponent(){
	//查询按钮注册
	$("#vehicleSearchBtn").click(function(){
		btnSearch();
	});
}

//查询方法

function btnSearch(){
	$('#mainDiv1').showLoading();
	
	$.ajax({
		type: "post",
		url: rootPath + "/wfjlcx.do",
		data: {
			kssj:$('#kssj').val(),
			jssj:$('#jssj').val(),
			wfstate:$('#statusSelect').val()
	
		},
		dataType: "json",
		success: function(data){
			if(data.error != ""){
				jAlert(data.error);
				return ;
			}else{
				$('#mainDiv1').hideLoading();
				$("#mainDiv1").empty(); 
				$("#mainDiv2").empty();
				if(data.data.length == 0){
					jAlert("没有查询到数据");
					return ;
				}
				jsonData = data;
				makeLeftTable(data.data);
			}
		}
	});
}



var jsonData = "";
//左侧动态生成随手拍查询列表
function makeLeftTable(data){
	$("#mainDiv1").append("<div id='searchDiv' style='margin-top:10px;margin-left:-20px'><img onclick='dosearch();' src='"+rootPath+"/static/img/wfjlgl/search-icon.png'/>" +
			"&nbsp;&nbsp;<input type='text'  id='searchText' style='border:none;background-color: #F6FAF9;font-size: 15px;font-weight:bold;' placeholder='请输入号牌或微信名称关键字'/></div>" +
			"<br><div style='width: 90%;margin-top:-30px'><hr style='border:none;border-top:2px solid #5E6577;' /></div>");
	      
	if(data != null && data.length > 0){
	
		
		$.each(data, function (i, item) {
			
			$("#mainDiv1").append("<div id='main"+i+"' class='item_over'  onmouseover='sizeOver("+i+")' onmouseout='sizeOut("+i+")' style='width: 90%;height:100px;margin-top: 10px;border-radius:8px;border: 1px solid #ffffff;cursor:pointer' onclick='onClick(this,"+JSON.stringify(item)+","+i+")'></div>");
			$("#main"+i).append("<div id='divDiv"+i+"' style='width:30%;float: left;margin-top: 15px;position: relative;border:none;'></div>");
			/*显示微信头像*/
			$("#divDiv"+i).append("<img src='"+item.wxtx+"' style='width:60px;height:60px;border-radius:50px;border: 1px solid #EFEFEF;'>");
			$("#main"+i).append("<div id='divTable"+i+"' style='width:70%;float: center;margin-top: 5px;'></div>");
			$("#divTable"+i).append("<table id='table"+i+"'></table>");
			$("#table"+i).append("<tr id='tr1"+i+"'></tr>");
			$("#tr1"+i).append("<td style='height:30px;'><div style='height: 29px;width: 75px;position:relative;'>" +
					"<img  src='"+rootPath+"/static/img/wfjlgl/hphmbjt.png' style='height: 29px;width: 75px;border-radius:8px;border: 1px solid #EFEFEF;' /> " +
							"<div class='upDiv' style='position:absolute;top:4px;left:7px;'><span style='color: white'>"+item.hphm+"</span></div></div></td>");
			$("#table"+i).append("<tr id='tr2"+i+"'></tr>");
			$("#tr2"+i).append("<td style='height:20px;'><span id='span2"+i+"' class='s_first'>"+item.wxzh+"</span></td>");
			$("#table"+i).append("<tr id='tr3"+i+"'></tr>");
			$("#tr3"+i).append("<td style='height:20px;'><span id='span3"+i+"' class='s_first'>"+item.wfsj+"</span></td>");
			$("#table"+i).append("<tr id='tr4"+i+"'></tr>");
			$("#tr4"+i).append("<td id='td4"+i+"' style='height:20px;'></td>");
			if(item.wfstate == 0)
				{
				  $("#td4"+i).append("<span id='span4"+i+"' class='s_first'>未处理</span>");
				}else if(item.wfstate == 1)
					{
					  $("#td4"+i).append("<span id='span4"+i+"' class='s_first'>已确认</span>");
					}else
						{
						  $("#td4"+i).append("<span id='span4"+i+"' class='s_first'>已忽略</span>");
						}
		}); 
		$('#mainDiv1').niceScroll(scroll());
	}
}
//设置滚动条样式
function scroll()
{
	
	var scroll={
			cursorcolor: "#ccc",//#CC0071 光标颜色
		    cursoropacitymax: 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0
		    touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备
		    cursorwidth: "5px", //像素光标的宽度
		    cursorborder: "0", // 游标边框css定义
		    cursorborderradius: "5px",//以像素为光标边界半径
		    autohidemode: false //是否隐藏滚动条
			
	};
	return scroll;
}

function dosearch()
{
	
	var query=$("#searchText").val();
	 if(query=='')
		{
		 jAlert('您还未输入关键字！', '警告');
		return;
		}
	$('#mainDiv1').showLoading();
	$('#mainDiv1').hideLoading();
	$("#mainDiv1").empty(); 
	$("#mainDiv2").empty();

	var searchedData=[];
	$.each(jsonData.data, function (i, jsonDataObj) {
		if(jsonDataObj.hphm.indexOf(query)>=0 || jsonDataObj.wxzh.indexOf(query)>=0)
			{
			 searchedData.push(jsonDataObj);
			}

			
	
		
	}); 
	makeLeftTable(searchedData);
	
}

//鼠标移入事件
function sizeOver(e){
	$("#span2"+e).removeClass("s_in");
	$("#span3"+e).removeClass("s_in");
	$("#span4"+e).removeClass("s_in");
	$("#span2"+e).addClass("s_first");
	$("#span3"+e).addClass("s_first");
	$("#span4"+e).addClass("s_first");
	$("#main"+e).removeClass("item_over");
	$("#main"+e).addClass("d_out");

}
//鼠标移出事件
function sizeOut(e){
	$("#span2"+e).removeClass("s_in");
	$("#span3"+e).removeClass("s_in");
	$("#span4"+e).removeClass("s_in");
	$("#span2"+e).addClass("s_first");
	$("#span3"+e).addClass("s_first");
	$("#span4"+e).addClass("s_first");
	$("#main"+e).removeClass("d_out");
	$("#main"+e).addClass("item_over");
}
//选中区域的点击事件
function onClick(value,data,e){
	$.each(jsonData.data, function (i, item) {
		if(i != e && $("#main"+i).attr('class') == "d_over item_over"){
			$("#main"+i).removeClass("d_over");
		}
	});
	codeLatLng(data,e);
	$("#main"+e).removeClass("d_out");
	$("#main"+e).addClass("d_over");
	$("#span2"+e).removeClass("s_first");
	$("#span3"+e).removeClass("s_first");
	$("#span4"+e).removeClass("s_first");
	$("#span2"+e).addClass("s_in");
	$("#span3"+e).addClass("s_in");
	$("#span4"+e).addClass("s_in");
}
//根据地图上面的经纬度来获取具体城市坐在位置名称

function codeLatLng(data,e){
	$("#mainDiv2").showLoading();
    getgisInfo(data,e);
}
//点击图片进行放大
function onClickImage(e,url){
	  var tmp=window.open("about:blank","","");
	  tmp.moveTo(0,0);
	  tmp.resizeTo(screen.width+20,screen.height);
	  tmp.focus();
	  tmp.location=url;
}
//右侧区域动态生成
function makeRightLane(data,e){
	var imagePath = data.imagepath+"/"+data.wfsj.substring(0,10)+"/"+data.wxid+"/";
	var wfsjstr = data.wfsj;

    var time=getDateDiff(wfsjstr);


	$("#mainDiv2").empty();
	//微信
	$("#mainDiv2").append("<div id='right1' style='width: 100%;background-color:#ffffff'></div>");
	$("#right1").height(($("#mainDiv2").height()/100)*18);
	$("#right1").append("<table id='rightTable' style='width:100%;height:100%;'></table>");
	$("#rightTable").append("<tr id='rightTr1'></tr>");
	$("#rightTr1").append("<td style='width:5%'></td>");
	$("#rightTr1").append("<td rowspan='2' style='text-align: center;width: 15%;'><img src='"+data.wxtx+"' style='width:85px;height:85px;border-radius:50px;border: 1px solid #EFEFEF;'></td>");
	$("#rightTr1").append("<td style='text-align: left;width: 30%;font-size:16px'><font color='#6A6A6A' style='font-weight:bolder'>"+data.wxzh+"</font></td>");
	$("#rightTr1").append("<td style='text-align: center;width: 5%;'><img src='"+rootPath+"/static/img/wfjlgl/name-icon.png' ></td>");
	$("#rightTr1").append("<td style='text-align: left;width: 15%;font-size:16px'><font color='#A3A3A3' style='font-weight:bolder'>"+data.jbr+"</font></td>");
	$("#rightTr1").append("<td style='text-align: center;width: 5%;'><img src='"+rootPath+"/static/img/wfjlgl/lxfs-icon.png' ></td>");
	$("#rightTr1").append("<td style='text-align: left;width: 35%;font-size:16px'><font color='#A3A3A3' style='font-weight:bolder'>"+data.lxdh+"</font></td>");
	$("#rightTable").append("<tr id='rightTr2'></tr>");
	$("#rightTr2").append("<td></td>");
	$("#rightTr2").append("<td style='text-align: left;font-size:14px'><font color='#CCCCCC' style='font-weight:bolder'>"+time+"</font></td>");
	$("#rightTr2").append("<td style='text-align: center;'><img src='"+rootPath+"/static/img/wfjlgl/sfz-icon.png' ></td>");
	$("#rightTr2").append("<td style='font-size:16px'><font color='#A3A3A3' style='font-weight:bolder'>"+data.sfzh+"</font></td>");
	$("#rightTr2").append("<td></td>");

	//违法信息
	$("#mainDiv2").append("<div id='right2'style='width:94%;border:none;margin-top:18px;background-color:#ffffff' align='center'></div>");
	$("#right2").height(($("#mainDiv2").height()/100)*72-18);
	$("#right2").append("<div id='accident' style='width: 90%;'></div>");
	$("#accident").height(($("#right2").height()/100)*20);
	$("#accident").append("<table id='accidentTable' style='width:100%;height:100%;'></table>");
	$("#accidentTable").append("<tr><td style='width:4%;height:15px'></td><td style='width:10%;></td><td style='width:36%'></td><td style='width:50%'></td></tr>");
	$("#accidentTable").append("<tr id='accidenttr1'></tr>");
	$("#accidenttr1").append("<td colspan='3' id='accidenttd11' style='text-align: left;font-size:16px;height:50px;'><font color='#A3A3A3' style='font-weight:bolder'>违法信息</font></td>");
	$("#accidenttr1").append("<td id='accidenttd12' style='width:50%;text-align: left;font-size:16px;height:50px'><font color='#A3A3A3' style='font-weight:bolder'>违法描述</font></td>");
	$("#accidentTable").append("<tr id='accidenttr2'></tr>");
	$("#accidenttr2").append("<td id='accidenttd21'></td>");
	$("#accidenttd21").append("<img src='"+rootPath+"/static/img/wfjlgl/wfxx.png'/>");
	$("#accidenttr2").append("<td id='accidenttd22'></td>");
	$("#accidenttd22").append("<img src='"+rootPath+"/static/img/wfjlgl/warning-icon.png'/>");
	$("#accidenttr2").append("<td id='accidenttd23' style='height:50px;'></td>");
	$("#accidenttd23").append("<font color='#5E5E5E' style='font-weight:bolder'>"+data.wfsj+"</font><br><br>");
	$("#accidenttd23").append("<font color='#5E5E5E' style='font-weight:bolder'>"+data.wfdd+"</font><span style='color:#41D4FF;cursor:pointer;' onclick='change("+JSON.stringify(data)+")'>切至地图</span><br><br>");
	$("#accidenttd23").append("<div style='height: 42px;width: 88px;position:relative;'>" +
					"<img  src='"+rootPath+"/static/img/wfjlgl/hphmbjt.png' style='height: 42px;width: 88px;border-radius:8px;border: 1px solid #EFEFEF;' /> " +
							"<div class='upDiv' style='position:absolute;top:8px;left:12px;'><span style='color: white'>"+data.hphm+"</span></div></div>");
	$("#accidenttr2").append("<td id='accidenttd24'></td>");
	$("#accidenttd24").append("<font color='#5E5E5E' style='font-weight:bolder'>"+data.wfxw+"</font>");
	//违法图片
	$("#accidentTable").append("<tr id='accidenttr3'></tr>");
	$("#accidenttr3").append("<td colspan='5' style='font-size:16px;text-align:left;height:50px'><font color='#A3A3A3' style='font-weight:bolder'>违法图片</font></td>");
	

	//图片切换=================================================================================
	if (data.wftp != "") {
		  $("#right2")
			.append(
					"<div id='imgslideDiv' style='width:90%;margin-top:150px;margin-left:80px'  align='center'></div>");
	 $("#imgslideDiv")
			.append(
					"<div class='carousel' style='width:100%;margin-top:20px;' align='center'></div>");
		// 现场照片
		 var str = data.wftp.split(",");
		$(".carousel")
				.append(
						"<a href='javascript:void(0);' class='prev disabled' id='prev'>&nbsp </a>");
		$(".carousel")
				.append("<div class='jCarouselLite' id='imgslide'></div>");
		$(".jCarouselLite").append("<ul id='ulimg'></ui>");

		for (var n = 0; n < str.length; n++) {
			$("#ulimg").append("<li><a href='#'><img height='140' width='140' src='"+(imagePath+str[n])+"' onclick='onClickImage(this,"+JSON.stringify(imagePath+str[n])+")'  /></a></li>");
			
		
		}
		$(".carousel")
				.append(
						"<a href='javascript:void(0);' class='next' id='next'>&nbsp </a>");
		$(".carousel").append("<div class='clear'></div> ");
		pictureSwitch();
		$(".carousel").append("<div id='wfbtnDiv' style='width:100%;margin-top:20px;margin-bottom:100px;margin-left:200px'></div>");
		
		
	}
	
	
	//图片平铺==================================================================================================
/*	if(data.wftp != ""){
		$("#right2").append("<div id='wfimgDiv' style='width:90%;margin-top:120px;display:none;' align='center'></div>");
		$("#wfimgDiv").append("<div id='wfimg' style='width:100%;margin-top:20px;' align='center'></div>");
		$("#wfimg").append("<br><table id='wfimgtable' ></table>");
		//现场照片
		var str = data.wftp.split(",");
		var i;
		var j;
		//str.length
		for(i=0;i<str.length;i++)
			{
			var now= Math.ceil((i+1)/5);
			var before=Math.ceil(i/5);
			if((now-before)==1)
				{
			       $("#wfimgtable").append("<tr id='wfimgtr"+i+"' style='border: 8px solid #ffffff;'></tr>");
			       j=i;
				}
			$("#wfimgtr"+j+"").append("<td style='border: 8px solid #ffffff;width:20%;text-align:center'><img class='imageClass' onclick='onClickImage(this,"+JSON.stringify(imagePath+str[i])+")' src='"+(imagePath+str[i])+"' /></td>");
			   
			}
		$("#wfimgDiv").append("<div id='wfbtnDiv' style='width:100%;margin-top:20px;margin-bottom:100px;' align='right'></div>");
		
		
	}*/
	
	var spantext = 	$("#span4"+e).text();
	var confirm=1;
	var ignore=2;
	if(spantext=="未处理")
		{
	$("#wfbtnDiv").append("<button id='confirmwfbtn' type='button' onclick='doCheck("+JSON.stringify(data)+","+confirm+","+e+")' class='btn btn-sm btn-primary'>确认违法</button>&nbsp;");
	$("#wfbtnDiv").append("<button id='ignorebtn' type='button' onclick='doCheck("+JSON.stringify(data)+","+ignore+","+e+")' class='btn btn-sm btn-primary'>忽略</button>");
		}
	$('#right2').niceScroll(scroll());
	
}
//图片切换
function pictureSwitch()
{
	$('#imgslide').jCarouselLite({
		btnPrev: '#prev',
		btnNext: '#next',
		circular: false,
		scroll:1,
		visible:4
	});		
}
//切换到腾讯地图
function change(data){
	var url = "http://apis.map.qq.com/uri/v1/geocoder?coord="+data.wfwd+","+data.wfjd+"&referer=myapp";
	var tmp=window.open("about:blank","","");
	tmp.moveTo(0,0);
	tmp.resizeTo(screen.width+20,screen.height);
	tmp.focus();
	tmp.location=url;
	
}
//审核违法
function doCheck(dataSingle,value,e)
{
	if(value==1)
		{
		jConfirm('是否确认违法?', '提示', function(r) {
			   if(r==true)
				   {
				   $.ajax({
						type: "post",
						url: rootPath + "/wfcheck.do",
						data: {
							wfid:dataSingle.wfid,
							wfstate:value,
					
						},
						dataType: "json",
						complete: function(){

								$("#wfbtnDiv").remove();
								$("#span4"+e).remove();
								$("#td4"+e).append("<span id='span4"+e+"' class='s_first'>已确认</span>");							
						}
					});
				   }
			       else
				   {
				   return;
				   }
			});
		
		}
	else
		{
		jConfirm('是否忽略?', '提示', function(r) {
			   if(r==true)
				   {
				   $.ajax({
						type: "post",
						url: rootPath + "/wfcheck.do",
						data: {
							wfid:dataSingle.wfid,
							wfstate:value,
					
						},
						dataType: "json",
						complete: function(){

								$("#wfbtnDiv").remove();
								$("#span4"+e).remove();
								$("#td4"+e).append("<span id='span4"+e+"' class='s_first'>已忽略</span>");								
						}
					});
				   }
			       else
				   {
				   return;
				   }
			});
		
		}

	
}
//比较时间
function getDateDiff(dateTime){
	var now = new Date().getTime();
	var dateTimeStamp=getDateTimeStamp(dateTime);
	var diffValue = now - dateTimeStamp;
	var minute = 1000 * 60;
	var hour = minute * 60;
	var day = hour * 24;
	var month = day * 30;
	if(diffValue < 0){
	 //若日期不符则弹出窗口告之
	 //alert("结束日期不能小于开始日期！");
	 }
	var monthC =diffValue/month;
	var weekC =diffValue/(7*day);
	var dayC =diffValue/day;
	var hourC =diffValue/hour;
	var minC =diffValue/minute;
	if(monthC>=1){
	 result=parseInt(monthC) + "个月前";
	 }
	 else if(weekC>=1){
	 result=parseInt(weekC) + "周前";
	 }
	 else if(dayC>=1){
	 result=parseInt(dayC) +"天前";
	 }
	 else if(hourC>=1){
	 result=parseInt(hourC) +"个小时前";
	 }
	 else if(minC>=1){
	 result=parseInt(minC) +"分钟前";
	 }else
	 result="刚刚";
	return result;
	}
function getDateTimeStamp(dateStr){
	 return Date.parse(dateStr.replace(/-/gi,"/"));
	}


//根据经纬度调用腾讯地图获取具体位置信息
var rightData = "";
function getgisInfo(info,e){
	 rightData = info;
	 var data={location:info.sgwd+"," +info.sgjd,key:"5RTBZ-NPL3I-LK4GF-5FXGZ-EW2SH-VDFU2",get_poi:0};
     var url="http://apis.map.qq.com/ws/geocoder/v1/?";
     data.output="jsonp";  
     $.ajax({
        type:"get",
        dataType:'jsonp',
        data:data,
        jsonp:"callback",
        jsonpCallback:"QQmap",
        timeout:3000,
        url:url,
        success:function(json){
        	$("#mainDiv2").hideLoading(); 	 
        	console.info(json.result);
        	if(json.result !== undefined){
        		sgwzmc = json.result.address + json.result.formatted_addresses.recommend;
        	}
        	makeRightLane(info,e);
        },
        error : function(err){
       	    $("#mainDiv2").hideLoading(); 	 
        }
	});
}

