<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/lookAhead/static/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/lookAhead/static/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="stu_rightMain.html">首页</a></li>
    <li><a href="#">个人账户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <!--  li class="#"><a href="stu_edit"><span><img src="images/t02.png" /></span>修改</a></li -->
        </ul>
		
    </div>

	
    
    
        <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
		<th>年级</th>
        <th>性别</th>
		<th>关注科目</th>
        </tr>
        </thead>
        <tbody>
		<form action="stu_edit.html" method = "post">
        
         <tr>
        <td><input name="username" value="${student.username}" style="height:27px;"></td>
        <input name="id" type="hidden" value="${student.id}" >
		<td><input name="password" value="${student.password}" style="height:27px;"></td>
		<td><input name="studentName" value="${student.studentName}" style="height:27px;"></td>
		<td><input name="studentGrade" value="${student.studentGrade}" style="height:27px;"></td>
		<td><input name="studentSex" value="${student.studentSex}" style="height:27px;"></td>
		<td><input name="studentSubject" value="${student.studentSubject}" style="height:27px;"></td>
        </tr> 
        
		
		
        </tbody>
    </table>
    <input name="" type="submit" class="btn" style="margin-top:40px;margin-right:600px;float:right;" value="确认修改" />
    </form>
    </div>
</body>
</html>