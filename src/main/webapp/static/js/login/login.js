$(function() {
	// 初始化执行一些函数
	init();
	//表单验证
	formValidate();
	$('#fullpage').fullpage({
		'verticalCentered' : false,
		'css3' : true,
		//'anchors' : [ "head",'loginWindow', 'pic2', 'pic3', 'pic4' ],
		'navigation' : true,
		'loopBottom' : false,
		'navigationPosition' : 'right',
		//'navigationTooltips' : [ 'head','loginWindow', 'pic2', 'pic3', 'pic4' ],
	});
	
	if(navigator.appName.indexOf("Microsoft Internet Explorer") != -1 && document.all){//ie8
		GetLastUser();
		if($("#account").val() == "" || $("#password").val() == ""){
			$("#btnLogin").attr("disabled",true);
		}
	}
	
	var placeholderfriend = {
		  focus: function(s) {
		      s = $(s).hide().prev().show().focus();
		      var idValue = s.attr("id");
		      if (idValue) {
		    	  s.attr("id", idValue.replace("placeholderfriend", ""));
		      }
		      var clsValue = s.attr("class");
		      if (clsValue) {
		          s.attr("class", clsValue.replace("placeholderfriend", ""));
		      }
		      $("#btnLogin").attr("disabled",false);
		      GetPwdAndChk(); 
		  }
    };

	  //判断是否支持placeholder
	  function isPlaceholer() {
	    var input = document.createElement('input');
	    return "placeholder" in input;
	  }
	  //不支持的代码
	  if (!isPlaceholer()) {
		  $(function() {
			  var form = $(this);
			  //遍历所有文本框，添加placeholder模拟事件
			  var elements = form.find("input[type='text'][placeholder]");
			  elements.each(function() {
				  var s = $(this);
				  var pValue = s.attr("placeholder");
				  var sValue = s.val();
				  if (pValue) {
					  if (sValue == '') {
						  s.val(pValue);
					  }
				  }
			  });
			  elements.focus(function() {
				  var s = $(this);
				  var pValue = s.attr("placeholder");
				  var sValue = s.val();
				  if (sValue && pValue) {
					  if (sValue == pValue) {
						  s.val('');
					  }
				  }
				  $("#btnLogin").attr("disabled",false);
			  });
			  elements.blur(function() {
				  var s = $(this);
				  var pValue = s.attr("placeholder");
				  var accountValue = s.val();
				  if (!accountValue) {
					  s.val(pValue);
				  }
			  });

			  //遍历所有密码框，添加placeholder模拟事件
			  var elementsPass = form.find("input[type='password'][placeholder]");
			  elementsPass.each(function(i) {
				  var s = $(this);
				  var pValue = s.attr("placeholder");
				  var sValue = s.val();
				  if (pValue) {
					  if (sValue == '') {
						  //DOM不支持type的修改，需要复制密码框属性，生成新的DOM
						  var html = "<input type='text' placeholderfriend class='form-control' id='password1' name='password' placeholder='输入密码' placeholderfriend value="+pValue+" onfocus='placeholderfriendfocus(this);'>";
						  var idValue = s.attr("id");
						  if (idValue) {
							  s.attr("id", idValue + "placeholderfriend");
						  }
						  var clsValue = s.attr("class");
						  if (clsValue) {
							  s.attr("class", clsValue + "placeholderfriend");
						  }
						  s.hide();
						  s.after(html);
					  }
				  }
			  });
			  elementsPass.blur(function() {
				  var s = $(this);
				  var sValue = s.val();
				  if (sValue == '') {
					  var idValue = s.attr("id");
					  if (idValue) {
						  s.attr("id", idValue + "placeholderfriend");
					  }
					  var clsValue = s.attr("class");
					  if (clsValue) {
						  s.attr("class", clsValue + "placeholderfriend");
					  }
					  s.hide().next().show();
				  }
			  });
		  });
	  }
	  window.placeholderfriendfocus = placeholderfriend.focus;
});
function GetLastUser() { 
	var id = "49BAC005-7D5B-4231-8CEA-16939BEACD67";//GUID标识符 
	var usr = GetCookie(id); 
	if (usr != null) { 
		$("#account").val(usr);
	}  
	else { 
		$("#account").val("");
	} 
	GetPwdAndChk();
}
//用户名失去焦点时调用该方法 
function GetPwdAndChk() { 
	var usr = $("#account").val();; 
	var pwd = GetCookie(usr); 
	if (pwd != null) { 
		document.getElementById('rememberAccount').checked = true; 
		$("#password").val(pwd);
	}else { 
		document.getElementById('rememberAccount').checked = false; 
		$("#password").val("");
	} 
}

function GetCookie(name) { 
	  var arg = name + "="; 
	  var alen = arg.length; 
	  var clen = document.cookie.length; 
	  var i = 0; 
	  while (i < clen) { 
	  var j = i + alen; 
	  if (document.cookie.substring(i, j) == arg) return getCookieVal(j); 
	  i = document.cookie.indexOf(" ", i) + 1; 
	  if (i == 0) break; 
	  } 
	  return null; 
} 
function getCookieVal(offset) { 
	  var endstr = document.cookie.indexOf(";", offset); 
	  if (endstr == -1) endstr = document.cookie.length; 
	  return unescape(document.cookie.substring(offset, endstr)); 
}


function init() {
	// 手机注册按钮 暂不可用
	$(".safeLogin").tooltip({
		title : "扫码登录方式暂未提供",
		placement : "right"
	});

	// disabled标记的内容不允许点击
	$(".disabled").bind('click mousedown', function(e) {
		e.preventDefault();
		return false;
	});
	
	// 解决firefox下input有默认值的问题
	$(".loginForm")[0].reset();
	
	$("#securityCodeImg").parents("a").click(function(){
		var imgUrl = $("#securityCodeImg").attr("src");
		var index = imgUrl.lastIndexOf("?");
		if(index > -1){
			imgUrl.substring(0, index);
		}
		$("#securityCodeImg").attr("src",imgUrl+"?a="+Math.random());
	});
	
	$("#account,#password,#securityCode").blur(function(){
		$(this).popover("hide");
	});
}

function formValidate() {
	
	$("#account").popover({
		selector: "#account",
		placement: "top",
		content: "account"
	});
	
	$("#password").popover({
		selector: "#password",
		placement: "top",
		content: "password"
	});
	
	$("#securityCode").popover({
		selector: "#securityCode",
		placement: "top",
		content: "securityCode"
	});
	
	var resetPopoverContext = function(dom,msg){
		dom.popover("show");
		dom.nextAll(".popover").find(".popover-content").text(msg);
	};
	if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/8./i)=="8."){//ie8
		$("#btnLogin").click(function(){
			var usr = $("#account").val();
			//将最后一个用户信息写入到Cookie 
			SetLastUser(usr); 
			//如果记住密码选项被选中 
			if(document.getElementById('rememberAccount').checked == true) { 
				//取密码值 
				var pwd = $("#password").val(); 
				var expdate = new Date(); 
				expdate.setTime(expdate.getTime() + 14 * (24 * 60 * 60 * 1000)); 
				//将用户名和密码写入到Cookie 
				SetCookie(usr, pwd, expdate); 
			}else { 
				//如果没有选中记住密码,则立即过期 
				ResetCookie(); 
			} 
			if(!$("#securityCodeDiv").hasClass("hidden")){
				var isTure = false;
				$.ajax({
					type: "post",
					url: rootPath+"/login/securityCodeCheck",
					data: {
						securityCode: $("#securityCode").val()
					},
					async: false,
					success: function(rst){
						if(rst=="true"){
							isTure = true;
						}else{
							resetPopoverContext($("#securityCode"),"验证码不正确!");
							$("#securityCodeImg").parents("a").click();
						}
					}
				});
				//验证码不正确
				if(!isTure)
					return false;
			}
			$.ajax({
				type: "post",
				url: rootPath+"/login/accountLogin",
				data: {
					account:$("#account").val(),
					password:md5(md5(md5($("#password").val()))+$("#securityCode").val())
				},
				dataType: "json",
				success: function(rst, textStatus){
					if(!!rst.errorMsg){
						alert(rst.errorMsg);
						return ;
					}else{
						windowOpen();
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					resetPopoverContext($("#account"), "登录异常!"+ XMLHttpRequest.status);
				}
			});
			return false;
		});
	}else{
		jQuery.getScript(rootPath+"/static/plugins/bootstrapValidate/dist/js/bootstrapValidator.min.js", function(data, status, jqxhr) {
			$('.loginForm').bootstrapValidator({
				message : '验证未通过!',
				feedbackIcons: { 
					valid: 'glyphicon glyphicon-ok', 
					invalid: 'glyphicon glyphicon-remove', 
					validating: 'glyphicon glyphicon-refresh' 
				},
				fields : {
					account:{
						validators:{
							callback:{
								message:'<div></div>',
								callback: function(value,validate,jQuerydom){
									if(!value){
										resetPopoverContext(jQuerydom,"帐号不可为空!");
										return false;
									}
									return true;
								}
							}
						}
					},
					password:{
						validators:{
							callback:{
								message:'<div></div>',
								callback: function(value,validate,jQuerydom){
									if(!value){
										resetPopoverContext(jQuerydom,"密码不可为空!");
										return false;
									}
									return true;
								}
							}
						}
					},
					securityCode:{
						validators:{
							callback:{
								message:'<div></div>',
								callback: function(value,validate,jQuerydom){
									if($("#securityCodeDiv").hasClass("hidden")){
										return true;
									}
									if(!value){
										resetPopoverContext(jQuerydom,"输入验证码!");
										return false;
									}
									return true;
								}
							}
						}
					}
				}
			}).on("success.form.bv",function(e){
				if(!$("#securityCodeDiv").hasClass("hidden")){
					var isTure = false;
					$.ajax({
						type: "post",
						url: rootPath+"/login/securityCodeCheck",
						data: {
							securityCode: $("#securityCode").val()
						},
						async: false,
						success: function(rst){
							if(rst=="true"){
								isTure = true;
							}else{
								resetPopoverContext($("#securityCode"),"验证码不正确!");
								$("#securityCodeImg").parents("a").click();
							}
						}
					});
					//验证码不正确
					if(!isTure)
						return false;
				}
				
				$.ajax({
					type: "post",
					url: rootPath+"/login/accountLogin",
					data: {
						account:$("#account").val(),
						password:md5(md5(md5($("#password").val()))+$("#securityCode").val())
					},
					dataType: "json",
					success: function(rst, textStatus){
						if(!!rst.errorMsg){
							resetPopoverContext($("#account"), rst.errorMsg);
							if(rst.securityCode){
								$("#securityCodeDiv").removeClass("hidden");
								$("#securityCodeImg").parents("a").click();
							}
							return;
						}
						windowOpen();
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						resetPopoverContext($("#account"), "登录异常!"+ XMLHttpRequest.status);
					}
				});
				e.preventDefault();
				return false;
			});	
		});
	}
}
function SetLastUser(usr) { 
	var id = "49BAC005-7D5B-4231-8CEA-16939BEACD67"; 
	var expdate = new Date(); 
	//当前时间加上两周的时间 
	expdate.setTime(expdate.getTime() + 14 * (24 * 60 * 60 * 1000)); 
	SetCookie(id, usr, expdate); 
}
//写入到Cookie 
function SetCookie(name, value, expires) { 
	var argv = SetCookie.arguments; 
	//本例中length = 3 
	var argc = SetCookie.arguments.length; 
	var expires = (argc > 2) ? argv[2] : null; 
	var path = (argc > 3) ? argv[3] : null; 
	var domain = (argc > 4) ? argv[4] : null; 
	var secure = (argc > 5) ? argv[5] : false; 
	document.cookie = name + "=" + escape(value) + ((expires == null) ? "" : ("; expires=" + expires.toGMTString())) + ((path == null) ? "" : ("; path=" + path)) + ((domain == null) ? "" : ("; domain=" + domain)) + ((secure == true) ? "; secure" : ""); 
}
function ResetCookie() { 
	var usr = document.getElementById('account').value; 
	var expdate = new Date(); 
	SetCookie(usr, null, expdate); 
} 
function windowOpen(){
//	$.post(rootPath+"/lose.do", {param:$('#account').val()}, function(response) {
//		window.open(rootPath+"/lose.do","_self");
//    });
	$.post(rootPath+"/frame_main.do", {param:$('#account').val()}, function(response) {
		window.open(rootPath+"/frame_main.do","_self");
    });
}


