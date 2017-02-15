﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#assign path="${rc.contextPath}">
<head>
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
    <span><img src="${path}/images/leftico01.png" /></span>教研组长管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="su_addUser.html" target="rightFrame">新增教研组长</a><i></i></li>
        <li class="active"><cite></cite><a href="../list/20/1.html" target="rightFrame">修改教研组长</a><i></i></li>
        <li><cite></cite><a href="../list/20/1.html" target="rightFrame">删除教研组长</a><i></i></li>
        </ul>    
    </dd>
    
    
    <dd><div class="title"><span><img src="${path}/images/leftico03.png" /></span>个人账户管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="su_addAdmin.html" target="rightFrame">新增个人账户</a></li>
        <li><cite></cite><a href="../adminlist/20/1.html" target="rightFrame">修改个人账户</a></li>
		<li><cite></cite><a href="../adminlist/20/1.html" target="rightFrame">删除个人账户</a></li>
    </ul>    
    </dd> 
    
    </dl>
</body>
</html>