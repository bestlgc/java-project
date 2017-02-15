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

</head>
<body>
	<div class="header">
		<div class="header-inner">
			<div class="page-logo">
				<a> <img style="padding-top: 3px;"
					src="${path}/image/logo.png">
				</a>
			</div>
			<div class="page-nav">
				<ul>
					<#include "header.ftl">
				</ul>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar">
				<ul class="page-sidebar-menu">
				 <#assign consoleapp="1">
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
					<div class="tablebody">
						<div class="tablerow">
							<div class="tablekey">应用名称</div>
							<div class="tablevalue">${app.name}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用编码</div>
							<div class="tablevalue">${app.code}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用归属</div>
							<div class="tablevalue"><a href="../partner/${app.partnerCode}.html">${app.partnerCode}</a></div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用状态</div>
							<div class="tablevalue">${app.status.getDesc()}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用描述</div>
							<div class="tablevalue">${app.desc}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用主密钥</div>
							<div class="tablevalue">${app.apk} <a href="../resetKey.html?appCode=${app.code}" style="margin-left:10px;cursor: pointer;">重置</a></div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用认证码</div>
							<div class="tablevalue">${app.secret}</div>
						</div>
						<div class="tablerow1" >
							<div class="tablekey">白名单列表</div>
							<div class="tablevalue">
							    <form id="form" action="${path}/app/update.html" method="post">
								  <div style="float: left">
									<textarea name="context" class="tablevalue required context" style="margin-left: 2px; width: 400px; height: 100px; max-width: 400px; max-height: 100px;">${context}</textarea>
									<span class="error">必填</span>
								  </div>
								  <div style="float: left; margin-left: 20px;">
									<input type="submit" class="btn btn-default" value="保存" />
								  </div>
								</form>
							</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用回调地址</div>
							<div class="tablevalue">${app.callback}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">应用联系人</div>
							<div class="tablevalue">${app.appCName}</div>
						</div>
						<div class="tablerow" >
							<div class="tablekey">应用联系手机</div>
							<div class="tablevalue">${app.appCPhone}</div>
						</div>
					    <div class="tablerow1">
								<div class="tablekey">应用logo</div>
								<img src="${imgPath}" id="uploadImage" <#if imgPath?exists> style="width: 50px;height:39px;margin-left:2px;" <#else>style="width: 50px;height:39px;margin-left:2px;display:none;"</#if> />
						</div>
							<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
								<div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" />
								</div>
							</div>
						<div style="border-bottom: none;padding: 15px 30px 0px 30px;" class="tablerow" >
							<div class="tablekey">应用包含能力包</div>
							<div style="padding:0px;" class="tablevalue">
								<#if app.vp??>
								<ul style="list-style: none;">
									<#list app.vp as v>
										<li onclick="javascript:$('.tablepr').hide();$('.table_${v.code}').show();$('.tableli').removeClass('active');$(this).addClass('active');" class="tableli  <#if v_index == 0>active</#if>" >${v.name}</li>
									</#list>
								</ul>
								<#else>
									无
								</#if>
								
							</div>
						</div>
						<div class="tablerow" style="margin-left: 40px;padding:0px;">
							<div class="tablekey"></div>
							<div class="tablevalue" style="<#if app.vp??>border: 1px solid rgb(216, 216, 216);</#if>width: 67%;">
								<#if app.vp??>
									<table>
										<thead>
											<tr>
												<td>能力组</td>
												<td>秒</td>
												<td>分</td>
												<td>时</td>
												<td>日</td>
												<td>月</td>
												<td>授权</td>
											</tr>
										</thead>
										<tbody>
											<#list app.vp as v>
												<#list v.packetRgs as pr>
													<tr <#if v_index != 0>style="display:none;"</#if> class="table_${v.code} tablepr">
														<td>${pr.rgName}</td>
														<td>${pr.second}</td>
														<td>${pr.minutes}</td>
														<td>${pr.hour}</td>
														<td>${pr.day}</td>
														<td>${pr.month}</td>
														<td><#if pr.isAuth>是<#else>否</#if></td>
													</tr>
												</#list>
											</#list>
										</tbody>
									</table>
								</#if>
							</div>
						</div>
						<div style="clear: both"></div>
					</div>
					<div class="tabletailgray">
						<div class="tablefunc" style="padding:10px;">
							<div class="btn-group">
								<#if appChange.approveResult == 's0'>
									<a type="button" class="btn btn-default" >正在审批中...</a>
								</#if>
								<#if (app.status == 's0' ||  app.status == 's1') && (appChange.approveResult != 's0')>
									<a type="button" class="btn btn-default" href="../change.html?appCode=${app.code}">修改</a>
								</#if>
								<#if app.status == 's0' && appChange.approveResult != 's0'>
									<a type="button" class="btn btn-default" href="../totest/${app.code}.html" onclick="if(confirm('确定申请测试吗？')){}else{return false;}">申请测试</a>
								</#if>
								<#if app.status == 's1' && appChange.approveResult != 's0'>
									<a type="button" class="btn btn-default" href="../publish/${app.code}.html" onclick="if(confirm('确定申请吗？')){}else{return false;}">发布</a>
								</#if>
								<#if app.status == 's2' >
									<a type="button" class="btn btn-default" href="../pause/${app.code}.html" onclick="if(confirm('确定暂停吗？')){}else{return false;}">暂停</a>
								</#if>
								<#if app.status == 's3' >
									<a type="button" class="btn btn-default" href="../regain/${app.code}.html" onclick="if(confirm('确定恢复吗？')){}else{return false;}">恢复</a>
								</#if>
								<#if app.status == 's2'>
									<a type="button" class="btn btn-default" href="../off/${app.code}.html" onclick="if(confirm('确定下线吗？')){}else{return false;}">下线</a>
								</#if>
								<#if app.status == 's3'>
									<a type="button" class="btn btn-default" href="../off/${app.code}.html" onclick="if(confirm('确定下线吗？')){}else{return false;}">下线</a>
								</#if>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${path}/js/attach.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {

			});
		</script>
</body>
</html>