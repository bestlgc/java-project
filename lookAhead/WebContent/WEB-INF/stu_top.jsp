<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
    <li><a href="stu_courseList.html" target="rightFrame" class="selected"><img src="/lookAhead/static/images/icon01.png" title="课件推荐" /><h2>课件推荐</h2></a></li>
	<li><a href="stu_lookCourse.html" target="rightFrame" ><img src="/lookAhead/static/images/ico003.png" title="课件浏览" /><h2>课件浏览</h2></a></li>
    <li><a href="stu_lookAdmin.html" target="rightFrame"><img src="/lookAhead/static/images/ico001.png" title="个人账户管理" /><h2>个人账户管理</h2></a></li>
	<li><a href="stu_score.html" target="rightFrame"><img src="/lookAhead/static/images/ico004.png" title="学生评分" /><h2>学生评分</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="/lookAhead/static/images/help.png" title="帮助"  class="helpimg"/></span><a href="stu_register.html" target="_parent">注册</a></li>
    <li><a href="login.html" target="_parent">登陆</a></li>
    <li><a href="login.html" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><a href="/lookAhead/stu_main" target="_parent">回到首页</span>
    
    </div>    
    
    </div>
</body>

</html>