<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册</title>
<!-- Bootstrap -->
<link href="/lookAhead/static/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="/lookAhead/static/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="/lookAhead/static/css/blue.css" rel="stylesheet" type="text/css" media="all" />
<!----font-Awesome----->
<link rel="stylesheet" href="/lookAhead/static/fonts/css/font-awesome.min.css">
<!--start slider -->
<link rel="stylesheet" href="/lookAhead/static/css/fwslider.css" media="all">
<!--end slider -->
<!-- must have -->
<link href="/lookAhead/static/css/allinone_carousel.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript" src="/lookAhead/static/js/from_ck.js"></script>


<style type="text/css">
<!--
.STYLE2 {font-size: 24px}
-->
</style>
</head>
<body>
<div class="header_bg">
  <div class="container">
    <div class="header">
      <div class="logo"> <a href="index.html"><img src="/lookAhead/static/images/logo001.png" alt=""/></a> </div>
      
      <div class="clearfix"></div>
    </div>
  </div>
</div>
<div class="main_bg"><!-- start main -->
  <div class="container">  </div>
</div>
<style >


#login{
	width:600px;
	}


</style>
<div class="container" id="login">
  <form class="form-horizontal" data-toggle="validator" role="form" name="RegForm" 
        action="/lookAhead/stuRegister" onSubmit="return register();" method="POST">
   
    <div class="form-group">
      <label class="col-xs-2 control-label" ><span style="color:red; ">*</span>用户名：</label>
      <div class="col-xs-10">
        <input type="text" name="username" id="username" onBlur="chkUserName(this)" placeholder="用户名" required >
		<SPAN id="username_notice" ></SPAN><span class="help-block" >用户名由字母、数字或_组成，长度3-20</span>      </div>
    </div>
    <div class="form-group">
      <label class="col-xs-2 control-label"><span style="color:red; ">*</span>密码：</label>
      <div class="col-xs-10">
        <input type="password" class="form-control" name="password" id="pwd" onBlur="check_password(this)" onkeyup="checkIntensity(this.value)" placeholder="输入密码" required>
       <SPAN id=password_notice ></SPAN> <span class="help-block">密码由字母、数字或_组成，长度5-30</span>     
      </div>
    </div>
    <div class="form-group">  
        <label class="col-xs-2 control-label">密码强度:</label>
        <table cellSpacing=0 cellPadding=1 width=145 border=0>
        <TR align=middle>
             <td id=pwd_lower width="33%">弱</td>
              <td id=pwd_middle width="33%">中</td>
              <td id=pwd_high width="33%">强</td>    
              </TR>       
        </table>
     </div>
    <div class="form-group">
      <label class="col-xs-2 control-label"><span style="color:red; ">*</span>确认密码：</label>
      <div class="col-xs-10">
        <input type="password" class="form-control" name="repassword" id="repwd" onBlur="check_conform_password(this)" placeholder="再输入一次密码">
        <SPAN id=conform_password_notice ></SPAN>
      </div>
    </div>
    <div class="form-group">
      <label class="col-xs-2 control-label">姓名:</label>
      <div class="col-xs-10">
        <input class="form-control " type="text" placeholder="姓名" name="studentName" id="studentName" data-error="姓名不能为空" >
      </div>
    </div>
     <div class="form-group">
      <label class="col-xs-2 control-label">年级：</label>
      <div class="col-xs-10">
        <select>
			<option>小学</option>
			<option>中学</option>
			<option>大学</option>
			<option>硕士及硕士以上</option>
		</select>
      </div>
    </div>
    <div class="form-group">
      <label class="col-xs-2 control-label">性　　别：</label>
      <div class="col-xs-10">
        <label><input type="radio" name="sex" class="sex" value="男" checked="checked"/>男　　</label><label><input type="radio" name="sex" class="sex" value="女"/>女</label>
      </div>
    </div>  
    
    <div class="form-group">
      <label class="col-xs-2 control-label">关注科目：</label>
      <div class="col-xs-10">
       <select>
			<option>语文</option>
			<option>数学</option>
			<option>英语</option>
			<option>计算机</option>
			<option>软件工程</option>
			<option>电子商务</option>
			<option>工商管理</option>
		</select>
      </div>
    </div>
   
    <button class="btnLogin"  type="submit" id="zhuce" disabled>注册</button>
  </form>
</div>


<div class="footer_bg"><!-- start footer -->
<div class="container">
  <div class="footer">
    <div class="footer1_of_3">
      <div class="f_logo">
        <a href="index.html"></a>      </div>
      <div class="container">
        <p class="f_para">四川华迪信息技术有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 公司地址:xxxxxxxxxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱地址:xxxxxxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;咨询热线:xxxxxxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系方式:xxxxxxxxxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传真:xxxxxxxxxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p> 
      </div>          
    </div>  
  </div>
</div>
</div>

${request.registPerson}
</body>
</html>