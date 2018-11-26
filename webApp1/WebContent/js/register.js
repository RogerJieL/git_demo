/**
 * 
 */
$(function(){
	$("#id").blur(function(){
		var  id=$(this).val();
		var info = $("#idInfo");
		if(id){
			info.text(" √").css('color','green');
		}else{
			info.text("手机号码不能为空").css('color','red');
		}
	})
	
	$("#passWord").blur(function(){
		var  id=$(this).val();
		var info = $("#passWordInfo");
		if(id){
			info.text(" √").css('color','green');
		}else{
			info.text("密码不能为空").css('color','red');
		}
	})
});
//刷新验证码
$(function(){
	$("#checkCode").click(function(){
		$("#imgVcode").attr("src",$("#PageContext").val()+"/checkCode.action?dt="+new Date().getTime()); 
		// 携带当前时间以便url是没有被缓存过的，以确保重新访问到后台的servlet，再重新生成。
});
});
