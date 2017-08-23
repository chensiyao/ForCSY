/**
 * 授权处理
 * @author wangqiang
 * @description
 */
$(function(){
	
	var appid = $("#wx_appid").val();
	var redirect_uri = location.origin + rootPath + "wx/accountInfo";
	var scope = "snsapi_userinfo";
	var accessUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+
			"&redirect_uri="+ encodeURIComponent(redirect_uri) +"&response_type=code" +
			"&scope="+ scope +"&state=STATE#wechat_redirect";
	window.open(accessUrl, "_self");
});