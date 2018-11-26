<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    
 <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/register.js"></script>  

</head>
<body>
<form action="RegisterServlet"   method="post">
	用户名：<input type="text" name="stunam1" id="id">
	<span id="idInfo" ></span>
	密码：<input type="password" name="stupsd1" id="passWord">
	<span id="passWordInfo" ></span><br>

	
   验证码： <img  id='imgVcode'	  src="${pageContext.request.contextPath}/checkCode.action" /> <br>
				    <span id="vcodeValidMsg">请输入验证码:</span>
			      	<input 	name="checkCode" type="text" id="txtVerifyCode" />	<br>
				 	<a href="javascript:location.reload();"	id="checkCode">换个图片</a>
				 	<span id="numberInfo"style="color: red"></span><br>
					<input type="submit" value="注册">
					<input type="reset" value="重置">
</form>
</body>
</html>