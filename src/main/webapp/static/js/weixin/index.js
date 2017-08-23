/**
 * author: wq
 * date: 2017-06-16
 */
$(function(){
	
	$("#button_showIn").click(function(){
		//初始化隐藏
		$("div.dialog").removeClass("initHideen");
		
		$("div.dialog .ui_mask").show();
		$("div.dialog").removeClass("showOut").addClass("showIn");
	});
	
	$("#button_showOut").click(function(){
		$("div.dialog .ui_mask").hide();
		$("div.dialog").removeClass("showIn").addClass("showOut");
	});
	
	if($("#isLogInFistTime").val()=="true"){
		$("#button_showIn").click();
	}
});