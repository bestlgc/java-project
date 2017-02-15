//XMLHttpRequest 
	var xmlhttp = false;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e2) {
			xmlhttp = false;
		}
	}
	if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	function Ajax(data){	
		xmlhttp.open("GET","/lookAhead/user_check?username="+document.getElementById("username").value,true);		
		xmlhttp.send(null);
	    document.getElementById('username_notice').innerHTML = process_request;//显示状态
		xmlhttp.onreadystatechange=function(){
			if (4==xmlhttp.readyState){
				if (200==xmlhttp.status){
				var responseText = xmlhttp.responseText;
				
				 if (responseText=="true" ){  
	                   ck_user("true");  
	              }  
	                 else{  
	                   ck_user("false");  
	                 }  
	            }
				else{  
	                    alert("发生错误!");  
	            }  
		  }
		}
	}
	function chkUserName(obj){
	     if (checks(obj.value)== false)
		  {
			obj.className = "FrameDivWarn";
			showInfo("username_notice",msg_un_format);
			  change_submit("true");
		  }
		else if(obj.value.length<1){
			obj.className = "FrameDivWarn";
			showInfo("username_notice",username_empty);
			  change_submit("true");
		}
		else if(obj.value.length<3){
			obj.className = "FrameDivWarn";
			showInfo("username_notice",username_shorter);
			  change_submit("true");
		}
		else if(obj.value.length>20){
			obj.className = "FrameDivWarn";
			showInfo("username_notice",msg_un_length);
			  change_submit("true");
		}
		else{
			//调用Ajax函数,向服务器端发送查询
			Ajax(obj.value);
		}			

	}
//--------------用户名检测---------------------//
function ck_user(result)
{
  if (result == "true" )
  {  
    document.getElementById('username').className = "FrameDivWarn";

	showInfo("username_notice",msg_un_registered);
	  change_submit("true");
  }
  else
  { 
    document.getElementById('username').className = "FrameDivPass";
	showInfo("username_notice",info_can);
	  change_submit("false");
  }
}


function checks(t){
	
    var reg=/^\w+$/;
   if(!reg.test(t)){   	  
          return false;
        }
   return true;
}
   

//--------------------密码检测-----------------------------//
function check_password( password )
{    var reg=/^\w+$/;
    if ( password.value.length < 5 )
    {
		showInfo("password_notice",password_shorter_s);
		password.className = "FrameDivWarn";
		change_submit("true");
    }
	else if(password.value.length > 30){
		showInfo("password_notice",password_shorter_m);
		password.className = "FrameDivWarn";
		change_submit("true");
	}
		else if (!reg.test(password.value)){
			showInfo("password_notice",password_un_format);
			password.className = "FrameDivWarn";
			change_submit("true");
		}
		
    else
    {
		showInfo("password_notice",info_right);
		password.className = "FrameDivPass";
		change_submit("false");
    }
}

function check_conform_password( conform_password )
{
    password = document.getElementById('pwd').value;
    
    if ( conform_password.value.length < 5 )
    {
		showInfo("conform_password_notice",password_shorter_s);
		conform_password.className = "FrameDivWarn";
		change_submit("true");
        return false;
    }
    if ( conform_password.value!= password)
    {
		showInfo("conform_password_notice",confirm_password_invalid);
		conform_password.className = "FrameDivWarn";
		change_submit("true");
		
    }
    else
    {   
	    conform_password.className = "FrameDivPass";
		showInfo("conform_password_notice",info_right);
		change_submit("false");
    }
}
//* *--------------------检测密码强度-----------------------------* *//

function checkIntensity(pwd)
{
  var Mcolor = "#FFF",Lcolor = "#FFF",Hcolor = "#FFF";
  var m=0;

  var Modes = 0;
  for (i=0; i<pwd.length; i++)
  {
    var charType = 0;
    var t = pwd.charCodeAt(i);
    if (t>=48 && t <=57)
    {
      charType = 1;
    }
    else if (t>=65 && t <=90)
    {
      charType = 2;
    }
    else if (t>=97 && t <=122)
      charType = 4;
    else
      charType = 4;
    Modes |= charType;
  }

  for (i=0;i<4;i++)
  {
    if (Modes & 1) m++;
      Modes>>>=1;
  }

  if (pwd.length<=4)
  {
    m = 1;
  }

  switch(m)
  {
    case 1 :
      Lcolor = "2px solid red";
      Mcolor = Hcolor = "2px solid #DADADA";
    break;
    case 2 :
      Mcolor = "2px solid #f90";
      Lcolor = Hcolor = "2px solid #DADADA";
    break;
    case 3 :
      Hcolor = "2px solid #3c0";
      Lcolor = Mcolor = "2px solid #DADADA";
    break;
    case 4 :
      Hcolor = "2px solid #3c0";
      Lcolor = Mcolor = "2px solid #DADADA";
    break;
    default :
      Hcolor = Mcolor = Lcolor = "";
    break;
  }
  document.getElementById("pwd_lower").style.borderBottom  = Lcolor;
  document.getElementById("pwd_middle").style.borderBottom = Mcolor;
  document.getElementById("pwd_high").style.borderBottom   = Hcolor;

}

//-------------处理注册程序-----------------------------//
function register() 
{
if(document.RegForm.username.value=="")
	{
	showclass("username","FrameDivWarn");
	showInfo("username_notice",username_empty);
	  document.RegForm.username.focus();
	  return false;
	 }
 else if(document.RegForm.password.value=="")
	{
	showclass("password","FrameDivWarn");
	showInfo("password_notice",password_empty);
      document.RegForm.password.focus();
	  return false;
	 }
 else if(document.RegForm.repassword.value=="")
	{
	showclass("repassword","FrameDivWarn");
	showInfo("conform_password_notice",confirm_password_invalid);
      document.RegForm.password.focus();
	  return false;
	 }
}
//------------ 按钮状态设置-----------------------------//
function change_submit(zt)
{ 
     if (zt == "true")
     {
  // document.forms['formUser'].elements['Submit1'].disabled = 'disabled';
   document.getElementById("zhuce").disabled=true;
     }
   else
     {
  // document.forms['formUser'].elements['Submit1'].disabled = '';
   document.getElementById("zhuce").disabled=false;
     }
}
//------公用程序------------------------------------//
function showInfo(target,Infos){
    document.getElementById(target).innerHTML = Infos;
	}
	function showclass(target,Infos){
    document.getElementById(target).className = Infos;
	}	
var process_request = "<img src='/lookAhead/static/images/loading.gif' width='16' height='16' border='0' align='absmiddle'>正在数据处理中...";
var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";
var username_shorter = "<span style='COLOR:#ff0000'> × 用户名长度不能少于 3 个字符。</span>";
var username_invalid = "- 用户名只能是由字母数字以及下划线组成。";
var msg_un_length = "<span style='COLOR:#ff0000'> × 用户名最长不得超过30个字符</span>";
var msg_un_format = "<span style='COLOR:#ff0000'> × 用户名含有非法字符!</span>";
var msg_un_registered = "<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";
//var username_exist = "用户名 %s 已经存在";
var password_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空。</span>";
var password_shorter_s = "<span style='COLOR:#ff0000'> × 登录密码不能少于 5 个字符。</span>";
var password_shorter_m = "<span style='COLOR:#ff0000'> × 登录密码不能多于 30 个字符。</span>";
var password_un_format = "<span style='COLOR:#ff0000'> × 密码含有非法字符!</span>";
var confirm_password_invalid = "<span style='COLOR:#ff0000'> × 两次输入密码不一致!</span>";
var info_can="<span style='COLOR:#006600'> √ 可以注册!</span>";
var info_right="<span style='COLOR:#006600'> √ 填写正确!</span>";
