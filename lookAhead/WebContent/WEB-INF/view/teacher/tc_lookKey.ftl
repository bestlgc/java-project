<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Look Ahead 在线学习平台</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="su_rightMain.html">首页</a></li>
    <li><a href="#">个人账户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="#"><a href="tc_edit_Key.html"><span><img src="${path}/images/t02.png" /></span>修改</a></li>
        </ul>
		
    </div>


    
    
        <table class="tablelist">
    	<thead>
    	<tr>
        <th>ID<i class="sort"><img src="${path}/images/px.gif" /></i></th>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>性别</th>
		<th>邮箱</th>
        <th>任职教研组</th>
		<th>任职状态</th>
        </tr>
        </thead>
        <tbody>
 		<#list users as user>
        <tr>
		
		<td>${user.id}</td>
        <td>${user.account}</td>
		<td>${user.password}</td>
		<td>${user.teacherName}</td>
		<td>${user.teacherSex}</td>
		<td>${user.teacherEmail}</td>
		<td>${user.teacherSubject}</td>
		<td>${user.teacherState}</td>
        </tr> 
        
 	    </#list>


        </tbody>
    </table>
    
    </div>
</body>
</html>
