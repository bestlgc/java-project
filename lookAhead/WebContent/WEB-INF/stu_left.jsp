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
    <span><img src="/lookAhead/static/images/leftico01.png" /></span><a href="stu_courseList.html" target="rightFrame">课件推荐</a>
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="/lookAhead/stu_courseList" target="rightFrame">计算机</a><i></i></li>
        <li class="active"><cite></cite><a href="/lookAhead/stu_courseList" target="rightFrame">电子商务</a><i></i></li>
        <li><cite></cite><a href="/lookAhead/stu_courseList" target="rightFrame">工商管理</a><i></i></li>
        </ul>    
    </dd>
    
	<dd><div class="title"><span><img src="/lookAhead/static/images/leftico03.png" /></span><a href="/lookAhead/stu_lookCourse" target="rightFrame" >课件浏览</a></div>
    <ul class="menuson">
        <li><cite></cite><a href="/lookAhead/stu_lookCourse" target="rightFrame">计算机</a></li>
        <li><cite></cite><a href="/lookAhead/stu_lookCourse" target="rightFrame">电子商务</a></li>
		<li><cite></cite><a href="/lookAhead/stu_lookCourse" target="rightFrame">工商管理</a></li>
    </ul>    
    </dd>
    
    <dd><div class="title"><span><img src="/lookAhead/static/images/leftico04.png" /></span><a href="stu_lookAdmin.html" target="rightFrame">个人账户管理</a></div>
    <ul class="menuson">
        <li><cite></cite><a href="stu_lookAdmin.html" target="rightFrame">信息修改</a></li>
    </ul>    
    </dd> 
     <dd><div class="title"><span><img src="/lookAhead/static/images/leftico04.png" /></span><a href="/lookAhead/stu_score" target="rightFrame">学生评分</a></div>
     	<ul class="menuson">
        <li><cite></cite><a href="/lookAhead/stu_score2" target="rightFrame">历史评分</a></li>
        </ul>
    </ul> 
     </dd>
    </dl>
</body>
</html>