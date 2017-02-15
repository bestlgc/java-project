<html xmlns="http://www.w3.org/1999/xhtml">
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

		<div class="loginbody"> 
			<span class="systemlogo"></span> 			   
			<div class="loginbox" style="position: absolute; left: 87px; margin-top: 13px;">
				<ul>
					<li><input name="" type="text" class="loginuser" value="admin" onClick="JavaScript:this.value=''"/></li>
					<li><input name="" type="text" class="loginpwd" value="密码" onClick="JavaScript:this.value=''"/></li>
					<li>
						<input name="" type="button" class="loginbtn" value="登录"  onclick="javascript:window.location='su_main.html'"  />
						<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label>
						<label><a href="#">忘记密码？</a></label>
					</li>
				</ul>
			</div>		
		</div>

		<div class="loginbm">版权所有  2016  ffj.com 仅供学习交流，勿用于任何商业用途</div>
	</body>

</html>

