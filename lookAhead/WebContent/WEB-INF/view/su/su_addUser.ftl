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
    <li><a href="su_lookUser.html">教研组长管理</a></li>
	<li><a href="#">新增教研组长</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    <form action="../new.html" method="post">
    <div class="formtitle"><span>新增用户</span></div>
    
    <ul class="forminfo">
    <li><label>用户名</label><input name="account" type="text" class="dfinput" /><i>姓名的全拼</i></li>
    <li><label>密码</label><input name="password" type="text" class="dfinput" /><i>6位以上数字</i></li>
    <li><label>姓名</label><input name="name" type="text" class="dfinput" /></li>
    <li><label>性别</label><cite><input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="女" />女</cite></li>
    <li><label>出生年月</label><input name="" type="text" class="dfinput" /></li>
	<li><label>邮箱</label><input name="email" type="text" class="dfinput" /></li>
	<li>
		<label>任职教研组</label>
		<select name="subject">
		<option value="数学组">数学组</option>
		<option value="英语组">英语组</option>
		<option value="物理组">物理组</option>
		</select>
	</li>
	<li><label>任职状态</label><form><cite><input name="state" type="radio" value="在职" checked="checked" />在职&nbsp;&nbsp;&nbsp;&nbsp;<input name="state" type="radio" value="离职" />离职</cite></form></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </div>
    </form>
</body>
</html>
