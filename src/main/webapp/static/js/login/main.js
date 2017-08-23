  //一级菜单left值
  var __left = 0;
  //当前选中的一级菜单
  var _currentMenuIndex = 0;
  //每一项目菜单的宽度
  var _menuItemWidth = 97;
  //每次翻页滚动的菜单数
  var _mainMenuPage = 2;

$(function(){	
	
   i18nInit();
	/**
	 * 语言初始化
	 */
	function i18nInit()
	{
		jQuery.i18n.properties({
            name : 'strings', //资源文件名称
            path : 'static/js/i18n/', //资源文件路径
            mode : 'map', //用Map的方式使用资源文件中的值
            language : 'zh',
            callback : function() {//加载成功后设置显示内容
				document.title = $i18n('login.system.name');
            }
        });
	}
	  //页面加载初始化
	  function page_onload(){
		  $.ajax({
			type : "POST",
			url : rootPath + "/frame_getSubSystemMenu.do",
			data : {"fjd": "KCKPGLPT" },
			dataType : "text",
			success : function(info) {
				var data = eval("(" + info + ")");
				if (data.msg != undefined && data.msg != "") {
					alert(data.msg);
				} 
				else if(data.success)
				{
					if(data.data.length == undefined || data.data.length <= 0)
					{
						$alert("main.js.menuDataEmptyMsg");
						return;
					}
					$("#hdnMenuInfo").val(info);
					
					//设置系统名称
					setSystemName(data.data);
					//获取子系统一级菜单默认序号
					var defaultMainMenuId = getDefaultSubMenu(data.data);
					//获取默认页面模块名
					var defaultSubMenuId = getDefaultSubMenuId(data.data,defaultMainMenuId);
					//设置主菜单
					setMainMenu(data.data,defaultMainMenuId,defaultSubMenuId);
				}
				else
				{
					$alert("main.js.menuDataErrorMsg");
				}
			}
		});
		  
	}
	  
	//设置系统名称
	function setSystemName(data)
    {
		  //系统名称
		  var name = "";
		  //系统标题文字图片
		  var sysname_icon_name = "";
		  //子系统级别
		  var zxtjb = 1;
		  for(var i=0;i<data.length;i++)
		  {
			  if(data[i].jdjb == zxtjb)
			  {
				   name = data[i].jdzwmqc;
				   sysname_icon_name = data[i].ylzd3;
				   break;
			  }
		  }
		  
		 //$(".logo-text").html(name);
		 document.title = name;
	 }
	  
	  //设置菜单
	  function setMainMenu(data,defaultMainMenuId,defaultSubMenuId)
	  {
		  var htmlStr = "";
		  var ulhtmlStr = "";
		  var menuStyle = "subNav";
		  var spanTagStyle = "left-tag";
		  var defaultPageUrl = "";		  
		  //一级菜单级别
		  var yjcdjb = 2;
		  //子系统级别
		  var zxtjb = 1;
		  
		  for(var i=0;i<data.length;i++)
		  {
			  if(data[i].jdjb == yjcdjb)
			  {
				  if(data[i].xh == defaultMainMenuId)
				  {
					  menuStyle = "subNav currentDd currentDt";
					  spanTagStyle = "left-tag left-tag-sel";
					  $("#span-menu-1s").html(data[i].jdzwm);
				  }
				  else {
					  menuStyle = "subNav";
					  spanTagStyle = "left-tag";
				  }
				  htmlStr += '<div class="'+ menuStyle +'">';
				  htmlStr += '<span class="'+ spanTagStyle +'"></span>';
				  htmlStr += '<div class="menu-text-1">' + data[i].jdzwm + '</div>';
				  htmlStr += '</div>';
				  
				  ulhtmlStr = "";
				  //设置二级菜单
				  for(var j=0;j<data.length;j++){
					  if(data[j].xh == defaultSubMenuId){
						  defaultPageUrl = data[j].ljymmc;
						  $("#span-menu-2s").html(data[j].jdzwm);
					  }
					  
					  if(data[j].fjd == data[i].jdywm)
					  {
						  if(data[j].xh == defaultSubMenuId){
							  ulhtmlStr += '<li><a href="#" style="background:#CCEEFF" onclick="subMenu_click(\'' 
								  + data[j].ljymmc + '\',' + data[j].sftc + ',\'' +data[i].jdzwm+ '\',\''+data[j].jdzwm+ '\')">' 
								  + data[j].jdzwm + '</a></li>';
						  }else{
							  ulhtmlStr += '<li><a href="#" onclick="subMenu_click(\'' 
								  + data[j].ljymmc + '\',' + data[j].sftc + ',\'' +data[i].jdzwm+ '\',\''+data[j].jdzwm+ '\')">' 
								  + data[j].jdzwm + '</a></li>';
						  }
					  }
				  }
				  if(ulhtmlStr != ""){
					  if(data[i].xh == defaultMainMenuId)
					  {
						  htmlStr += '<ul class="navContent" style="display:block;">';
					  }else {
						  htmlStr += '<ul class="navContent">';
					  }
					  htmlStr += ulhtmlStr;
					  htmlStr += '</ul>';
				  }
			  }
		  }

		  $(".subNavBox").html(htmlStr);
		  
			$(".subNav").click(function(){
				$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd");
				$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt");
				$(this).next(".navContent").slideToggle(600).siblings(".navContent").slideUp(600);
				
				$(".left-tag").removeClass("left-tag-sel");
				$(this).find("span").addClass("left-tag-sel");
			});
			
			$(".navContent li a").click(function(){
				$(".navContent li a").css("background","transparent");
				$(this).css("background-color","#CCEEFF");
			});
			
			  if(defaultPageUrl != "")
			  {
				  openPage(defaultPageUrl);
			  }
	  }
	  
	  //获取父节点名称
	  function  getMainMenuName(data,defaultSubMenuId)
	  {
		  var result = "";
		  for(var i=0;i<data.length;i++)
		  {
			  if(data[i].xh == defaultSubMenuId)
			  {
				  result = data[i].fjd;
				  break;
			  }
		  }
		  return result;
	  }
	  
	  //获取节点名称
	  function  getMenuName(data,menuId)
	  {
		  var result = "";
		  for(var i=0;i<data.length;i++)
		  {
			  if(data[i].xh == menuId)
			  {
				  result = data[i].jdywm;
				  break;
			  }
		  }
		  return result;
	  }
	  
	  //获取子系统默认一级菜单序号
	  function  getDefaultSubMenu(data)
	  {
		  //一级菜单级别
		  var jdjb = 2;
		  //默认页面值
		  var sfsy = 1;
		  var result = "";
		  
		  for(var i=0;i<data.length;i++)
		  {
			  if(data[i].jdjb == jdjb)
			  {
				  if(result == "")
				  {
					  result = data[i].xh;
				  }
				  if(data[i].sfxtsy == sfsy)
				  {
					  result = data[i].xh;
					  break;
				  }
			  }
		  }
		  return result;
	  }
	  
	  //获取默认页面序号
	  function getDefaultSubMenuId(data,defaultMainMenuId)
	  {
		  var result = "";
		  //默认页面值
		  var sfsy = 1;
		  var jdywm = getMenuName(data,defaultMainMenuId);
		  for(var i=0;i<data.length;i++)
		  {
			  if(data[i].fjd == jdywm)
			  {
				  if(result =="")
				  {
					  result = data[i].xh;
				  }
				  if(data[i].sfmksy==sfsy)
				  {
					  result = data[i].xh;
					  break;  
				  }
			  }
		  }
		  return result;
	  }
	 
		resize();
		$(window).resize(function(){
			resize();
		});
		
	  doSomething($i18n("main.js.pageLoadingMsg"));	  
	  $('#frameContent').attr("src","");
	  page_onload();
});

/**
 * 页面元素尺寸
 */
function resize(){
	var winHeight = $(window).height();
	var winWidth = $(window).width();
	
	if(winWidth < 1100) winWidth = 1100;
	if(winHeight < 400) winHeight = 400;
	
	$('#container').width(winWidth);
	$('#container').height(winHeight);
	
	$('#center').width(winWidth);
	$('#center').height(winHeight);
	
	$('#centerAside').height(winHeight);
	
	$('.content-frame').height(winHeight);
	$('.content-frame').width(winWidth-215);
	
	$('#frameContent').height($(".content-frame").height());
	$('#frameContent').width(winWidth-215);
}

//得到随机字符串
function generateMixed(n) {
		var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	     var res = "";
	     for(var i = 0; i < n ; i ++) {
	         var id = Math.ceil(Math.random()*35);
	         res += chars[id];
	     }
	     return res;
}
	
//打开页面
function openPage(param,sftc)
{
	if(param == "")
	{
		$alert("main.js.urlEmptyErrorMsg");
		return;
	}
    var user = $('#user-name').val();
	if(user == "")
	{
	    user = "admin";
	}
	//去掉自动登录跳转功能
	if(param.indexOf("login.do") > -1 && param.indexOf("?")>-1)
	{
		var array = param.split("?");
		if(array.length == 2)
		{
			param = getUrlParamFromStr(array[1], "url");
		}
	}

	if(param.indexOf("?")>-1)
	{
		param += "&param=" +  user +"&frame_random_k="+generateMixed(5); 
	}
	else {
		param += "?param=" +  user +"&frame_random_k="+generateMixed(5); 
	}
	
	doSomething($i18n("main.js.pageLoadingMsg"));	  
	
	var currentPageUrl = window.location.href;
	if(currentPageUrl.indexOf("ForCsy")>0){
		if(param.indexOf("http")<0 && param.indexOf("LinkShell.html")>-1){
			param = "." + param;
		}
	}
	//sftc是否弹出值为1时弹出新页面
	if(sftc && sftc == 1){
		$('#frameContent').attr("src",'./popup.do');	
		var features = 'width='+ (window.screen.availWidth-10)+',height='+(window.screen.availHeight-73)+ ',fullscreen=1,location=1,top=0,left=0,resizable=no,status=no,menubar=no,scrollbars=yes';
		window.open(param,"",features);
	}else {
		$('#frameContent').attr("src",param);	
	}
}

//菜单项点击
function subMenu_click(menuParam,sftc,mainMenuName,subMenuName)
{	
	$("#span-menu-1s").html(mainMenuName);
	$("#span-menu-2s").html(subMenuName);
  	
	openPage(menuParam,sftc); 
}

function $$(id){
    return document.getElementById(id);
  }

//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return ""; // 返回参数值
}

//获取urlStr中的参数
function getUrlParamFromStr(urlStr,name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = urlStr.match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return ""; // 返回参数值
}

/**
 * 读取i18n字符串
 * @param msg
 */
function $i18n(key)
{
	return $.i18n.prop(key);
}

/**
 * 读取i18n字符串
 * @param msg
 */
function $alert(key)
{
	alert($i18n(key));
}

function iframe_onload(obj)
{
	MaskUtil.unmask(); 
}

//追加内层的onbeforeunload
window.onbeforeunload = function(){
	var beforeUnload = $("#frameContent")[0].contentWindow.onbeforeunload;
	if(!!beforeUnload){
		var rtn = beforeUnload();
		if(!!rtn){
			return rtn;
		}
	}
};
/**
 * 密码修改
 */
function modifyPassword(){
	$("#password").css('display','block'); 
	$("#password").dialog({
		closed : true,
		modal : true,
		resizable : false,
		width :360,
		height:200,
	});
	 $("#password").dialog('open');
}
/**
 * 修改密码
 */
function btnModifyOk(){
	var regex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,16}');
	if(!regex.test($("#txtNewPwd").val())){
		alert("8～16个字符,包含数字、字母、特殊字符");
		return ;
	}
	if($("#txtNewPwd").val() != $("#txtNewPwd2").val()){
		alert("新密码两次输入不一致");
		return ;
	}
	setMaxDigits(130);  
	var key = new RSAKeyPair($("#publicExponent").val(),"",$("#publicKey").val());  
    var txtNewPwd = encryptedString(key, $("#txtNewPwd").val());
	$.ajax({
		type: "post",
		url:rootPath + "/login/modifyPassword.do",
		data:{
			oldPwd : md5(md5($("#txtOldPwd").val())),
			newPwd : txtNewPwd
		},
		dataType: "json",
		success: function(data){
			if(data.error != ""){
				alert(data.error);
				return ;
			}else{
				alert("修改密码成功");
				$("#password").dialog('close');
				window.open(rootPath+"/login.do","_self");
			}
		}
	});
}
/**
 * 密码重置
 */
function btnModifyReset(){
	$("#txtOldPwd").val("");
	$("#txtNewPwd").val("");
	$("#txtNewPwd2").val("");
}