<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>上海移动能力开放平台</title>


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
						应 用 列 表 <span class="table-name-div"><span>
					</div>
					<div class="tablehead"></div>
					<div class="tablebody">
						<table>
							<thead>
								<tr>
									<th>应用名称</th>
									<th>应用编码</th>
									<th>应用申请人</th>
									<th>应用状态</th>
								</tr>
							</thead>
							<tbody>
								<#list vlp.tableApps as app>
								<tr onclick="location.href='../../${app.code}.html'">
									<td>${app.name}</td>
									<td>${app.code}</td>
									<td>${app.cName}</td>
									<td>${app.status.getDesc()}</td>
								</tr>
								</#list>
							</tbody>
						</table>


						<div class="tabletail">
							<div class="tablefunc">
								<div class="btn-group">
									<button onclick="location.href='../../new.html'" type="button"
										class="btn btn-default">创建新应用</button>

								</div>
							</div>
							<div class="tablepage">
								<ul class="pagination">
									<#if vlp.pageIndex+1 gt 2>
										<li><a href="../0/20.html">&laquo;</a></li>
									</#if>
									<#if vlp.pageIndex+1 gt 1>
											<li><a href="../${vlp.pageIndex-1}/20.html">${vlp.pageIndex}</a></li>
									</#if>
									<li class="active"><a href="../${vlp.pageIndex}/20.html">${vlp.pageIndex+1}</a></li>
									<#if vlp.pageIndex+1 lt vlp.totalNum/vlp.pageNum>
										<li><a href="../${vlp.pageIndex+1}/20.html">${vlp.pageIndex+2}</a></li>
									</#if>
									<#if vlp.pageIndex+2 lt vlp.totalNum/vlp.pageNum>
										<li><a href="../${(vlp.totalNum/vlp.pageNum)?ceiling-1}/20.html">&raquo;</a></li>
									</#if>
								</ul>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>

	</div>
	<script type="text/javascript"
		src=src="${path}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</body>
</html>