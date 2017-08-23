
$(function() {
	initResize();
	//初始化尺寸
	$(window).resize(function(){
		initResize();
	});
	initComponent();
	init();
});
function initResize(){
	var  winWidth = $(window).width();//窗口宽度
	var  winHeight = $(window).height();//窗口高度
	$(".whole-div").width(winWidth); //整体的宽度
	$(".whole-div").height(winHeight - 20);//整体的高度
	$(".main-top").height((winHeight/100)*19);//整体的高度
	$('#dataGrid').height($('.main-top').height() - $('.titleDiv').height());
	$('.znjt-search-table').height($('#dataGrid').height());
	$('.main-top1').height($('.whole-div').height() - $('.main-top').height()-35);
	$('.main-top1').width($('.main-top').width());
	$('#divList').width($('.main-top1').width());
	$('#divList').height($('.main-top1').height() - $('.titleDiv').height());
	$(".container").width($('.main-top1').width());
	$(".container").height($('.main-top1').height() - $('.titleDiv').height());
	$(".tempWrap").height($(".container").height());
	$(".item").height($(".container").height());
	$(".content").height($(".container").height()/2 - 22);
}
//注册点击事件
function initComponent(){
	//查询按钮注册
	$("#vehicleSearchBtn").click(function(){
		btnSearch();
	});
	//重置按钮注册
	$("#vehicleSearchResetBtn").click(function(){
		restParam();
	});
}
//把条件参数重置成空
function restParam(){
	$("#fklx").val("-1");
	$('#wxh').val('');
	$('#kssj').val($('#hidden_kssj').val());
	$('#jssj').val($('#hidden_jssj').val());
}
//查询方法
var flag = true;
function btnSearch(){
	switchView(flag);
}
function getParam(flag){
	var type = "";
	if($("#fklx").val() == "-1"){
		type = "";
	}else{
		type = $("#fklx").val();
	}
	var param = {
		kssj:$('#kssj').val(),
		jssj:$('#jssj').val(),
		nickName:$('#wxh').val(),
		type:type,
		flag:flag
	};
	return param;
}
function init(){
	var param = getParam(false);
	$(".container").showLoading();
	makeFishBone(param);
}
function makeFishBone(param){
	$.ajax({
		type: "post",
		url: rootPath + "/fkyjcx.do",
		data: param,
		dataType: "json",
		success: function(data){
			if(data.error != ""){
				jAlert(data.error);
				return ;
			}else{
				$(".container").hideLoading();
				if(data.rows.length == 0){
					jAlert("没有查询到数据");
					return ;
				}
				$(".fishBone").fishBone(data.rows);
				$(".tempWrap").height($(".container").height());
				$(".item").height($(".container").height());
				$(".content").height($(".container").height()/2 - 22);
			}
		}
	});
}

function makeDataGrid(){
	var param = getParam(true);
	$('#divTable').datagrid({
		url : rootPath + "/fkyjcx.do",
		queryParams :param,
		rownumbers: true,
		striped:true,
		fitColumns: true,
		fit: true,
		singleSelect:true,
		columns:[[
		          {field:'nickName',title:'微信号',align : 'center',width:'20%'},    
		          {field:'kssj',title:'提交时间',align : 'center',width:'15%'},    
		          {field:'type',title:'反馈类型',align : 'center',width:'15%',
		        	  formatter:function(value,rowData,rowIndex){
				        	var ret ='';
							if(value == 1){//系统异常
								ret="系统异常";
							}else if(value == 2){//优化建议
								ret="优化建议";
							}
							return ret;
		        	  }
		          },    
		          {field:'description',title:'反馈意见',align : 'center',width:'40%',
		        	  formatter:function(value){
		        		  return "<div class='text-resize' title='"+value+"'>"+value+"</div>";
		        	  }
		          },
		          {field:'operation',title:'操作',align : 'center',width:'9.8%',
			          	formatter:function(value,rowData,rowIndex){
			          		var ret = "";
			          		if(rowData.image == ""){
			          			ret ="<div style='cursor:pointer;FILTER: gray;color:#41D4FF;'>查看详情<div>";
			          		}else{
			          			ret ="<div style='cursor:pointer;color:#41D4FF' onclick='showDetail(this,"+JSON.stringify(rowData)+")'>查看详情<div>";
			          		}
							return ret;
			          	}
		          }  
		        ]], 
		border : false,
		idField : 'xh',
		loadMsg : '正在查询数据，请稍候...',
		pagination : true,
		pageSize : 15,
		pageList:[15,30,45,60],
		onSelect : function(rowIndex, rowData) {},
		onLoadSuccess : function(reData) {
			if(reData.error != ""){
				jAlert('提示', reData.error);
				return ;
			}
		},
	});
}
function showDetail(e,data){
	$("#fkyjxx").css('display','block'); 
	$("#fkyjxx").dialog({
		closed : true,
		modal : true,
		resizable : false,
		width : 900,
		height:400,
	});
	 $("#fkyjxx").dialog('open');
	 $("#fkyjxx").empty();
	 if(data.image != ""){
		 var str = data.image.split(",");
		 if(str.length > 0){
			 var imagePath = data.imagePath;
			 $("#fkyjxx").append("<div id='imageDiv' style='width:99.7%;height:230px;border: 1px solid #d1d1d1;'></div>");
			 $("#imageDiv").append("<div id='imageFirst'style='width: 100%;height:16px'></div>");
			 $("#imageFirst").append("<div id='imageTwo'style='padding-left:20px;margin-top: 10px;'></div>");
			 $("#imageTwo").append("<img style='float: left;' src='"+rootPath+"/static/img/common/site.png'/>");
			 $("#imageTwo").append("<font color='#41D4FF' style='float: left;padding-left: 10px;font-size:18px;'>现场照片</font>");
			 $("#imageDiv").append("<div id='imageFirst1'style='width: 100%;height:205px;'></div>");
			 $("#imageFirst1").append("<table id='imageTable' style='width:100%;height:99%;border: 1px solid #d1d1d1;'></table>");
			 if(str != null && str.length > 0){
					if(str.length <= 5){
						$("#imageTable").append("<tr id='imageTr1' style='border: 1px solid #d1d1d1;'></tr>");
						for(var i = 0; i < str.length; i ++){
							$("#imageTr1").append("<td style='width:20%;text-align:center;'><img style='width:170px;height:180px;cursor:pointer'onclick='onClickImage(this,"+JSON.stringify(imagePath+str[i])+")' src='"+(imagePath+str[i])+"'/></td>");
						}
					}else{
						$("#fkyjxx").height("461px");
						$("#imageDiv").height("327px");
						$("#imageFirst").height("16px");
						$("#imageFirst1").height("300px");
						var a = str.length/5;
						if(str.length > a*5){
							a = a+1;
						}
						for(var i = 0; i < a; i++){
							$("#imageTable").append("<tr id='imageTr"+i+"' style='border: 1px solid #d1d1d1;'></tr>");
							if((i+1)*5 > str.length){
								for(var j = i*5; j < str.length; j ++){
									$("#imageTr"+i).append("<td style='width:20%;text-align:center;'><img style='width:140px;height:140px;cursor:pointer'onclick='onClickImage(this,"+JSON.stringify(imagePath+str[j])+")' src='"+(imagePath+str[j])+"'/></td>");
								}
							}else{
								for(var j = i*5; j < (i+1)*5; j ++){
									$("#imageTr"+i).append("<td style='width:20%;text-align:center;'><img style='width:140px;height:140px;cursor:pointer'onclick='onClickImage(this,"+JSON.stringify(imagePath+str[j])+")' src='"+(imagePath+str[j])+"'/></td>");
								}
							}
						}

					}
				}
		 }
	 }
	 $("#fkyjxx").append("<div id='fkyjInfo' style='width:99.7%;height:130px;border: 1px solid #d1d1d1;'></div>");
	 $("#fkyjInfo").append("<div id='driverdiv' style='width: 100%;height:16px;'></div>");
	 $("#driverdiv").append("<div id='driverdiv1' style='padding-left:20px;margin-top: 10px;'></div>");
	 $("#driverdiv1").append("<img style='float: left;' src='"+rootPath+"/static/img/common/accident.png'/>");
	 $("#driverdiv1").append("<font color='#41D4FF' style='float: left;padding-left: 10px;font-size:18px;'>反馈信息</font>");
	 $("#fkyjInfo").append("<div id='driver' style='width: 100%;height:100px;'></div>");
	 $("#driver").append("<table id='driverTable' style='width:100%;height:100%;border: 1px solid #d1d1d1;'></table>");
	 $("#driverTable").append("<tr id='driverTr' style='border: 1px solid #d1d1d1;'></tr>");
	 $("#driverTr").append("<td style='width:10%;font-size:17px' class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>反馈意见</strong></td>");
	 $("#driverTr").append("<td style='font-size:16px;text-align:left;'>"+data.description+"</td>");
}
//点击图片进行放大
function onClickImage(e,url){
	  var tmp=window.open("about:blank","","");
	  tmp.moveTo(0,0);
	  tmp.resizeTo(screen.width+20,screen.height);
	  tmp.focus();
	  tmp.location=url;
}
//列表和鱼骨图的切换
function switchView(checked) {
	flag = checked;
	if(checked){//加载鱼骨图
		$(".container").css('display','block');
		$("#divList").css('display','none');
		init();
	}else{//加载列表
		$(".container").css('display','none');
		$("#divList").css('display','block');
		makeDataGrid();
	}
}