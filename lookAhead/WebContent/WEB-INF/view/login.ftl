
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Look Ahead在线学习平台</title>

	<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${path}/js/jquery.js"></script>
	<script src="${path}/js/cloud.js" type="text/javascript"></script>

	<script language="javascript">
		$(function(){
			$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			$(window).resize(function(){  
			$('.loginbox').css({'position':'absolute','left':($(window).width()-650)/2});
		})  
		});  
	</script> 
	<script language="JavaScript">
	if (window != top) {
		//alert("对不起，你还未登录，请登录后再进行操作！");
		top.location.href = location.href;
	}
</script>
</head>
<body style="background-color:#1c77ac; background-image:url(${path}/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

		<div id="mainBody">
		  <div id="cloud1" class="cloud"></div>
		  <div id="cloud2" class="cloud"></div>
		</div>

		<div class="logintop">    
			<span>欢迎登录Look Ahead在线学习平台</span>    
			<ul>
				<li><a href="#">回首页</a></li>
				<li><a href="#">帮助</a></li>
				<li><a href="#">关于</a></li>
			</ul>    
		</div>
<form action="loginAction.html" method="post">
		<div class="loginbody"> 
			<span class="systemlogo"></span> 			   
			<div class="loginbox" style="position: absolute; left: 87px; margin-top: 13px;">
				<ul>
					<li><input name="account" type="text" class="loginuser" value="" /></li>
					<li><input name="password" type="password" class="loginpwd" value="" /></li>
					<li >
						<SELECT id="droplist" class="sel" onchange="" name="role"> 
							<OPTION selected>－请选择登录身份－</OPTION> 
							<option value="0">教研组长</option>
							<option value="1">教师</option>
							<option value="2">学生</option>
							<option value="3">超级管理员</option>
						</SELECT>
						<li><input name="" type="submit" class="loginbtn" value="登录" />
						<input name="" type="button" class="loginbtn" value="注册"  onclick="javascript:window.location='student_register.jsp'"  />
						<label><input name="" type="checkbox" value=""
						checked="checked" />记住密码</label> <label><a href="#">忘记密码？</a></label></li>
						
				</ul>
			</div>		
		</div>
</form>
		<div class="loginbm">版权所有  2016  ffj.com 仅供学习交流，勿用于任何商业用途</div>
	</body>
</html>