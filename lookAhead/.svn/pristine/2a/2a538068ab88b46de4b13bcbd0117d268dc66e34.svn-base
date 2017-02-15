<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Look Ahead 在线学习平台</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery.js"></script>
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
    <li><a href="leader_rightMain.html">首页</a></li>
    <li><a href="leader_lookAdmin.html">个人账户管理</a></li>
	<li><a href="#">密码修改</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
	<table class="tablelist">
    	<thead>
    	<tr>
        <th>用户名</th>
        <th>密码</th>
		<th>邮箱</th>
        </tr>
        </thead>
        
        <tbody>

 		
 		<form action="savePW.html" method="post" id="pwform">
        <tr>
        <td>${leader.account}</td>
        <td><input name="password" type="text" value="${leader.password}"id="txt"  /></td>
        <td>${leader.email}</td>
        </tr> 

  		
  		
  	
        </tbody>
    </table>
  

    <div style="text-align:center;padding:10px;">
		 <li><input name="" type="button" class="btn" value="确认修改" /></li>
	</div>
	</form>
     <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${path}/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="submit"  class="sure" value="确定" onclick="$('#pwform').submit();"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
</body>
</html>
