/**
 * 全屏查看
 */
function fullWindowLook(type,time){
	if(type=="out"){
		$("#full-window-box").fadeOut(time);
		$('.main-content').append($('.page-content'));
	}else{
		$("#full-window-box").fadeIn(time);
		$('#table-box').append($('.page-content'));
	}
}
/*
 * 
 * bigin
 * */
$(document).ready(function(){
	$("#full-window-ico").click(function(){
		fullWindowLook("",1000);
	});
	$("#restore-ico").click(function(){
		fullWindowLook("out",1000);
	});
});