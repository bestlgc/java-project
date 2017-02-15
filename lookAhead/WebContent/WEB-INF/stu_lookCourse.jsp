<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="/lookAhead/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/lookAhead/static/js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="stu_rightMain.html">首页</a></li>
    <li><a href="#">课件浏览</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <table class="imgtable">
    
    <thead>
    <tr>
    <th>ID<i class="sort"><img src="/lookAhead/static/images/px.gif" /></i></th>
    <th width="230px;">课件图</th>
    <th width="230px;">课件名称</th>
    <th>科目</th>
    <th>发布人</th>
	<th>分数</th>
    <th>下载量</th>
	<th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    
    <tr>
    <td>20130908</td>
    <td class="imgtd"><img src="/lookAhead/static/images/img11.png" /></td>
    <td><a href="#">课程模板</a><p>发布时间：2013-10-12 09:25:18</p></td>
    <td>英语</td>
    <td>张三</td>
    <td>5分</td>
	<td>50次</td>
	<td><a href="stu_detail.html" class="tablelink">查看</a> &nbsp<a href="stu_addCourse.html" class="tablelink">下载</a></td>

    </tr>
    
    <tr>
    <td>20130908</td>
    <td class="imgtd"><img src="/lookAhead/static/images/img12.png" /></td>
    <td><a href="#">简约形状图标</a><p>发布时间：2013-10-12 09:25:18</p></td>
    <td>英语</td>
    <td>张三</td>
    <td>5分</td>
	<td>50次</td>
	<td><a href="stu_detail.html#" class="tablelink">查看</a> &nbsp<a href="stu_addCourse.html" class="tablelink">下载</a></td>
	</tr>
    
   
    
    </tbody>
    
    </table>
    
    
    
    
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="/lookAhead/static/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
   
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>