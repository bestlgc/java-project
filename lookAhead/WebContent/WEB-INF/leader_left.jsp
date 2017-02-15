<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/lookAhead/static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="/lookAhead/static/js/jquery.js"></script>

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
    <span><img src="/lookAhead/static/images/leftico01.png" /></span>教师管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="leader_addUser.html" target="rightFrame">新增教师</a><i></i></li>
        <li class="active"><cite></cite><a href="leader_lookUser.html" target="rightFrame">修改教师</a><i></i></li>
        <li><cite></cite><a href="leader_lookUser.html" target="rightFrame">删除教师</a><i></i></li>
        </ul>    
    </dd>
    
	<dd><div class="title"><span><img src="/lookAhead/static/images/leftico03.png" /></span>课件管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="leader_addAdmin.html" target="rightFrame">上传课件</a></li>
        <li><cite></cite><a href="su_lookAdmin.html" target="rightFrame">审核课件</a></li>
		<li><cite></cite><a href="su_lookAdmin.html" target="rightFrame">任务分配</a></li>
    </ul>    
    </dd>
    
    <dd><div class="title"><span><img src="/lookAhead/static/images/leftico04.png" /></span>个人账户管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="/lookAhead/leader_lookAdmin" target="rightFrame">密码修改</a></li>
    </ul>    
    </dd> 
    
    </dl>
</body>
</html>