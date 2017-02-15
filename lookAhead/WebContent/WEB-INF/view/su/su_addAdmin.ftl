<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="su_rightMain.html">首页</a></li>
    <li><a href="su_lookAdmin.html">个人账户管理</a></li>
	<li><a href="#">新增超级用户</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>新增用户</span></div>
    <form action="../newadmin.html" method="post">
    <ul class="forminfo">
    <li><label>用户名</label><input name="username" type="text" class="dfinput" /><i>姓名的全拼</i></li>
    <li><label>密码</label><input name="password" type="text" class="dfinput" /><i>6位以上数字</i></li>
    <li><label>确认密码</label><input name="" type="text" class="dfinput" /></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>
</body>
</html>
