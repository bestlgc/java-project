<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Look Ahead在线学习平台3232</title>


<link href="/lookAhead/static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="/lookAhead/static/js/jquery.js"></script>
<script src="/lookAhead/static/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 650) / 2
			});
		})
	});
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

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
<form action="/lookAhead/loginact" method="post">
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<ul>
				<li><input name="account" type="text" class="loginuser"/></li>
				<li><input name="password" type="password" class="loginpwd" /></li>
				<li><input name="" type="submit" class="loginbtn" value="登录" />
					<label><input name="" type="checkbox" value=""
						checked="checked" />记住密码</label> <label><a href="#">忘记密码？</a></label></li>
			</ul>
		</div>
	</div>
</form>
	<div class="loginbm">版权所有 2016 ffj.com 仅供学习交流，勿用于任何商业用途</div>
</body>


</html>