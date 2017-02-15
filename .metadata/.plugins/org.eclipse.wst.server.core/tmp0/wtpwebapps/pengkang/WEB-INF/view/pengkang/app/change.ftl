<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>上海移动能力开放平台</title>


<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css" href="${path}/css/base.css">
<link rel="stylesheet" type="text/css" href="${path}/css/base1.css">
</head>
<body>
	<div class="header">
		<div class="header-inner">
			<div class="page-logo">
				<a> <img style="padding-top: 3px;"
					src="/operation/image/logo.png">
				</a>
			</div>
			<div class="page-nav">
				<ul><#include "header.ftl">
				</ul>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar">
				<ul class="page-sidebar-menu"><#assign consoleapp="1">
					<#include "console.ftl">
				</ul>
			</div>
		</div>
		<div class="page-content-wrapper">
			<div class="page-content">


				<div class="eoptable">
					<div class="table-name">
						应 用 详 情 <span class="table-name-div"><span>
					</div>
					<div class="tablehead"></div>
					<form id="form" method="post" action="modify.html">
						<div class="tablebody">
							<div class="tablerow">
								<div class="tablekey">应用名称</div>
								<div class="tablevalue">${app.name}</div>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用编码</div>
								<div class="tablevalue">${app.code}</div>
								<input id="code" name="code" class="tablevalue required code"
									type="hidden" value="${app.code}" />
							</div>
							<div class="tablerow">
								<div class="tablekey">应用归属</div>
								<div class="tablevalue">
									<a href="../partner/${app.partnerCode}.html">${app.partnerCode}</a>
								</div>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用状态</div>
								<div class="tablevalue">${app.status.getDesc()}</div>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用描述</div>
								<input name="desc" class="tablevalue required description"
									type="text" value="${app.desc}" /> <span class="error">必填,英文+中文+数字,最大长度40</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用主密钥</div>
								<div class="tablevalue">${app.apk}</div>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用认证码</div>
								<div class="tablevalue">${app.secret}</div>
							</div>
							<div class="tablerow" >
								<div class="tablekey">白名单列表</div>
								<div class="tablevalue">
									<#list IPS as IP>
								 	<p>${IP}</p>
									</#list>
								</div>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用回调地址</div>
								<input name="callback" class="tablevalue required url"
									type="text" value="${app.callback}" /> <span class="error">必填，URL类型</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">应用联系人</div>
								<input name="appCName" class="tablevalue required name"
									type="text" value="${app.appCName}" /> <span class="error">必填,英文+中文,最大长度10</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">联系方式</div>
								<input name="appCPhone" class="tablevalue required phone"
									type="text" value="${app.appCPhone}" /> <span class="error">必填,11位手机号码</span>
							</div>
							<div class="tablerow1">
								<div class="tablekey">应用logo</div>
								<div class="div1">
								<div class="div2">选择图片</div>
					            <input type = "file" name = "attach" id = "attach"  class="inputstyle" onchange="ajaxFileUpload();"/>
					            </div>
					            
								<img src="${imgPath}" id="uploadImage" <#if imgPath?exists> style="width: 50px;height:39px;margin-left:10px;position: absolute;" <#else>style="width: 50px;height:39px;margin-left:2px;display:none;"</#if> />
							</div>
							<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
								<div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" />
								</div>
								</div>
								<div id="result"></div>
							<div style="border-bottom: none; padding: 15px 30px 0px 30px;"
								class="tablerow">
								<div class="tablekey">应用包含能力包</div>
								<div style="padding: 0px;" class="tablevalue">
									<ul style="list-style: none;">
										<#list vps as v>
										<li style="text-align: center;">${v.packetName} <input<#list
											app.vp as vv> <#if v.packetCode==vv.code> checked="checked"
											</#if> </#list> name="packetCodes" value="${v.packetCode}"
											type="checkbox">
										</li> </#list>
									</ul>
								</div>
							</div>
							<div style="clear: both"></div>
						</div>
						<div class="tabletailgray">
							<div class="tablefunc" style="padding: 10px;">
								<div class="btn-group">
									<input type="submit" class="btn btn-default" onclick="if(confirm('确定保存吗？')){}else{return false;}" value="确认保存" />
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${path}/js/jquery.validVal.js"></script>
		<script type="text/javascript" src="${path}/js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${path}/js/attach.js"></script>
		<script src="${path}/js/jquery.validVal-customValidations.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(function() {
					$("#form").validVal();
				});
			});
		</script>
</body>
</html>