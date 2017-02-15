<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Look Ahead 在线学习平台</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery.js"></script>
<#assign path="${rc.contextPath}">
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
    <li><a href="su_rightMain.html">首页</a></li>
    <li><a href="su_lookUser.html">教研组长管理</a></li>
	<li><a href="#">修改教研组长信息</a></li>
    </ul>
    </div>
   <form action="../save.html" method="post" id="sform">
    <div class="rightinfo">  
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>性别</th>
		<th>邮箱</th>
        <th>任职教研组</th>
		<th>任职状态</th>
        </tr>
        </thead>
        <tbody>

        <tr>
		<input name="vid" type="hidden" value="${viewleader.vid}" id="txt"  />
        <td><input name="account" type="text" value="${viewleader.account}"id="txt"  /></td>
		<td><input name="password" type="password" value="${viewleader.password}"id="txt"  /></td>
		<td><input name="name" type="text" value="${viewleader.name}"id="txt"  /></td>
		<td><input name="sex" type="radio" value="男" <#if viewleader.sex=='男'>checked="checked"</#if> />男&nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" <#if viewleader.sex=='女'>checked="checked"</#if> type="radio" value="女" />女</td>
		<td><input name="email" type="text" value="${viewleader.email}"id="txt"  /></td>
		<td>
			 
			<select name="subject">
			<option value="数学组" <#if viewleader.subject=='数学组'> selected="selected" </#if>>数学组</option>
			<option value="英语组" <#if viewleader.subject=='英语组'> selected="selected" </#if>>英语组</option>
			<option value="物理组" <#if viewleader.subject=='物理组'> selected="selected" </#if>>物理组</option>
			</select>
			 
		</td>
		<td><cite><input name="state" type="radio" value="在职" <#if viewleader.state=='在职'>checked="checked" </#if>/>在职&nbsp;&nbsp;&nbsp;&nbsp;<input name="state" type="radio" value="离职" <#if viewleader.state=='离职'>checked="checked" </#if>/>离职</cite></td>
        </tr> 
        

        </tbody>
    </table>
    <div style="text-align:center;padding:10px;">
		 <li><input type="button" class="btn" value="确认修改" /></li>
	</div>
 

    
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
        <input name="" type="button"  class="sure" value="确定" onclick="$('#sform').submit();"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
      </form>
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
