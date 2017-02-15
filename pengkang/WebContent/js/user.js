 $(document).ready(function () {  
    $("#uploadfile").click(function(){  
    	ajaxFileUpload();  
    });  
  
});  

function validate(){
	var flag = true;
	var url = "isTrue/" + $("#vCode").val() +".html";
	var input = $("#vCode").val();
	if(input.length==0){
		$("#resultInfo").empty();
		$("#resultInfo").append("<span>请输入正确的验证码<span>");
		return false;
	}
	var radomNUm = generateMixed(5);
	var codePath = "getVCode.html?" + radomNUm;
	$.ajax({
		type:"POST",
		url:url,
		success : function(data) {
			if (data == "yes") {
				$("#resultInfo").empty();
				$("#resultInfo").append("<span>验证码正确<span>");
			} else {
				$("#resultInfo").empty();
				$("#resultInfo").append("<span>验证码错误<span>");
				flag = false;
				//$("#codeImage").attr("src",codePath);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("操作失败，请重试！");
		}
	});
	return flag;
}

var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];

function generateMixed(n) {
     var res = "";
     for(var i = 0; i < n ; i ++) {
         var id = Math.ceil(Math.random()*35);
         res += chars[id];
     }
     return res;
}

function refresh(){
	var radomNUm = generateMixed(5);
	var codePath = "getVCode.html?" + radomNUm;
	$("#codeImage").attr("src",codePath);
}

function check(username,pw){
	if(username.length==0||username==null){
		$("#resultInfo").empty();
		$("#resultInfo").append("<span>请输入正确的用户名<span>");
		return false;
	}else if(pw.length==0||pw==null){
		$("#resultInfo").empty();
		$("#resultInfo").append("<span>请输入正确的密码<span>");
		return false;
	}
	return true;
}
function submitForm(){
	var username = $("#username").val();
	var pw = $("#password").val();
//	var yes = validate();
//	if(!yes){
//		return;
//	}
	if(!check(username,pw)){
		return;
	}
	
	var digested = digest(username,pw);
	$("#password").val(digested);
	$("#loginForm").submit();
	$("#password").val("");
//	var url = "login.html";
//	var postData = "username=" + username + "&password=" + digested + "&vCode" + vCode;
//	$.ajax({
//		type : "POST",
//		url : url,
//		dataType : "json",
//		data : postData,
//		success : function(data) {
//			if (data=="s0") {
//				window.location.href = "/partner/partner/create.html";
//			} else if(data=="s1"){
//				window.location.href = "/partner/personPartner/approve.html";
//			}else if(data=="s2"){
//				window.location.href = "";
//			}
//			else if(data == "s3"){
//				window.location.href = "";
//			}
//		},
//		error : function(XMLHttpRequest, textStatus, errorThrown) {
//			alert("操作失败，请重试！");
//		}
//	});
}
function digest(username,pw){
	return $.md5(username+pw);
}
function test(){
	alert($.md5("fasfss111111"));
}