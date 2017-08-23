$(function() {
	// 初始化执行一些函数
	init();

	// 表单提交验证
	formValidate();
	
});

function init() {
	// 手机注册按钮 暂不可用
	$(".phoneRegister").tooltip({
		title : "手机注册方式暂未提供",
		placement : "right"
	});

	// disabled标记的内容不允许点击
	$(".disabled").bind('click mousedown', function(e) {
		e.preventDefault();
		return false;
	});
	
	// 解决firefox下input有默认值的问题
	$(".registerForm")[0].reset();
	
	//重置表单
	$(".resetFormBtn").click(function(){
		$('.registerForm').data('bootstrapValidator').resetForm(true);
	});
}

function formValidate() {
	$('.registerForm').bootstrapValidator({
		message : '验证未通过!',
		feedbackIcons: { 
			valid: 'glyphicon glyphicon-ok', 
			invalid: 'glyphicon glyphicon-remove', 
			validating: 'glyphicon glyphicon-refresh' 
		},
		fields : {
			account : {
				validators : {
					notEmpty : {
						message : '账户名不可为空'
					},
					stringLength : {
						min : 6,
						max : 30,
						message : '账户名长度6-30位'
					},
					regexp : {
						regexp : /^\w*[a-zA-Z_]+\w*$/,
						message : '字母数字下划线组成(至少一个字母)'
					},
					callback: {
						message: '该账户已经被注册',
						callback: function(value,validate,jQuerydom){
							if(!value){
								return true;
							}
							var res = true;
							var name = jQuerydom[0].name;
							var param = {};
							param[name] = value;
							$.ajax({
								type: 'POST',
								url: rootPath + '/register/accountIsExist',
								async: false,
								data: param,
								success: function(rst){
									if(rst=="true" || rst==true){
										res = false;
									}
								}
							});
							return res;
						}
					}
				}
			},
			email : {
				validators : {
					notEmpty : {
						message : '邮箱不可为空'
					},
					emailAddress : {
						message : '邮箱格式不正确'
					},
					callback: {
						message: '该邮箱已经被注册',
						callback: function(value,validate,jQuerydom){
							if(!value){
								return true;
							}
							var res = true;
							var name = jQuerydom[0].name;
							var param = {};
							param[name] = value;
							$.ajax({
								type: 'POST',
								url: rootPath + '/register/accountIsExist',
								async: false,
								data: param,
								success: function(rst){
									if(rst=="true" || rst==true){
										res = false;
									}
								}
							});
							return res;
						}
					}
				}
			},
			password : {
				validators : {
					stringLength : {
						min : 6,
						max : 24,
						message : '密码长度6-24位'
					},
					notEmpty : {
						message : '请输入密码'
					},
					regexp : {
						regexp : /^[a-zA-Z0-9\-_@%!?+\.]+$/,
						message : '密码由数字、字母、中划线、下划线组成'
					},
					identical : {
						field : 'repassword',
						message : '两次密码输入不一致'
					}
				}
			},
			repassword : {
				validators : {
					notEmpty : {
						message : '请确认密码'
					},
					identical : {
						field : 'password',
						message : '两次密码输入不一致'
					}
				}
			},
			readProtocol: {
				validators : {
					notEmpty : {
						min: 1,
						message : '您需要同意服务使用协议'
					}
				}
			}
		}
	}).on("success.form.bv",function(e){
		setMaxDigits(130);  
		var key = new RSAKeyPair($("#publicExponent").val(),"",$("#publicKey").val());  
	    var encryptData = encryptedString(key, $("#password").val());
		$.ajax({
			type: "post",
			url: rootPath+"/register/emailAccount",
			data: {
				account:$("#account").val(),
				email:$("#email").val(),
				password:encryptData
			},
			dataType: "json",
			success: function(rst, textStatus){
				$("#registerTip").modal("show");
				if(!!rst.success){
					$("#registerTip_account").text(rst.account);
					$("#registerTip .error").hide();
					$("#registerTip .success").show();
				}else{
					if(!rst.errorMsg)
						rst.errorMsg = "未知错误";
					$("#registerTip_errorMsg").text(rst.errorMsg);
					$("#registerTip .error").show();
					$("#registerTip .success").hide();
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$("#registerTip").modal("show");
				var errorMsg = XMLHttpRequest.status;
				if(!errorMsg){
					errorMsg = "未知异常!";
				}
				$("#registerTip_errorMsg").text(errorMsg);
				$("#registerTip .error").show();
				$("#registerTip .success").hide();
			}
		});
		e.preventDefault();
		return false;
	});
	
	
}
