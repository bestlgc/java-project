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
    <li><a href="leader_lookUser.html">教师管理</a></li>
	<li><a href="#">修改教师信息</a></li>
    </ul>
    </div>
   
    <div class="rightinfo">  
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>性别</th>
		<th>邮箱</th>
        <th>任职科目</th>
		<th>任职状态</th>
        </tr>
        </thead>
        <tbody>
		<form action="../save.html" method="post">
        <tr>
        <input name="id" type="hidden" value="${viewteacher.id}"id="txt"  />
        <td><input name="account" type="text" value="${viewteacher.account}"id="txt"  /></td>
		<td><input name="password" type="password" value="${viewteacher.password}"id="txt" /></td>
		<td><input name="name" type="text" value="${viewteacher.name}"id="txt"  /></td>
		<td><input name="sex" type="radio" value="男" <#if viewteacher.sex=='男'>checked="checked"</#if> />男&nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="女" <#if viewteacher.sex=='女'>checked="checked"</#if>/>女</td>
		<td><input name="email" type="text" value="${viewteacher.email}"id="txt" /></td>
		<td>
			
			<select name="subject">
			<option value="数学" <#if viewteacher.subject=='数学'>selected="selected"</#if>>数学</option>
			<option value="英语" <#if viewteacher.subject=='英语'>selected="selected"</#if>>英语</option>
			<option value="物理" <#if viewteacher.subject=='物理'>selected="selected"</#if>>物理</option>
			</select>
			
		</td>
		<td><cite><input name="state" type="radio" value="正常" <#if viewteacher.state=='正常'>checked="checked" </#if>/>正常&nbsp;&nbsp;&nbsp;&nbsp;<input name="state" type="radio" <#if viewteacher.state=='待定'>checked="checked" </#if> value="待定" />待定</cite></td>
        </tr> 
        </tbody>
    </table>
    <div style="text-align:center;padding:10px;">
		 <li><input name="" type="submit" class="btn" value="确认修改" /></li>
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
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
