﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${path}/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>系统管理</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${path}/images/leftico01.png" /></span>教师管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="leader_addUser.html" target="rightFrame">新增教师</a><i></i></li>
        <li class="active"><cite></cite><a href="../list/20/1.html" target="rightFrame">修改教师</a><i></i></li>
        <li><cite></cite><a href="../list/20/1.html" target="rightFrame">删除教师</a><i></i></li>
        </ul>    
    </dd>
    
	<dd><div class="title"><span><img src="${path}/images/leftico03.png" /></span>课件管理</div>
    <ul class="menuson">
         <li><cite></cite><a href="/lookAhead/initUpload" target="rightFrame">上传课件模板</a></li>
        <li><cite></cite><a href="/lookAhead/showCourseList/10/1" target="rightFrame">课件列表</a></li>

    </ul>    
    </dd>
    
    <dd><div class="title"><span><img src="${path}/images/leftico04.png" /></span>个人账户管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="../../leader_edit_Admin.html" target="rightFrame">密码修改</a></li>
    </ul>    
    </dd> 
    
    </dl>
</body>
</html>
