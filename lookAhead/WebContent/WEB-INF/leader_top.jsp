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
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>

</head>
<body style="background:url(/lookAhead/static/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="/lookAhead/static/images/logo001.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="leader_lookUser.html" target="rightFrame" class="selected"><img src="/lookAhead/static/images/ico004.png" title="教研组长管理" /><h2>教师管理</h2></a></li>
	<li><a href="su_lookUser.html" target="rightFrame" ><img src="/lookAhead/static/images/ico003.png" title="教研组长管理" /><h2>课件管理</h2></a></li>
    <li><a href="leader_lookAdmin.html" target="rightFrame"><img src="/lookAhead/static/images/ico001.png" title="个人账户管理" /><h2>个人账户管理</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="/lookAhead/static/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="su_login.html" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>admin</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>