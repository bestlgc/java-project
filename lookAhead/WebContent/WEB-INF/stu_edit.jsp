<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Look Ahead 在线学习平台</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".btn").click(function(){
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
    <li><a href="stu_profile.html">个人账户管理</a></li>
	<li><a href="#">信息修改</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
	<table class="tablelist">
    	<thead>
    	<tr>
        <th>ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
		<th>年级</th>
        <th>性别</th>
		<th>关注科目</th>
        </tr>
        </thead>
        <tbody>

        <tr>
		<td>1234445</td>
        <td>
			<input type="text"  id="txt" value="zhangsan"/>
		</td>
		<td>
			<input type="text"  id="txt" value="123455"/>
		</td>
		<td>
			<input type="text"  id="txt" value="张三"/>
		</td>
		<td>
			<input type="text"  id="txt" value="大学"/>
		</td>
		<td>
			<input type="text"  id="txt" value="男"/>
		</td>
		<td>
			<input type="text"  id="txt" value="电子商务"/>
		</td>
        </tr> 

        </tbody>
    </table>
  

    <div style="text-align:center;padding:10px;">
		 <li><input name="" type="button" class="btn" value="确认修改" /></li>
	</div>
     <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
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
</body>
</html>