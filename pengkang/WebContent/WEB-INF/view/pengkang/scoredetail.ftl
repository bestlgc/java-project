<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>彭康书院成绩分析系统</title>


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
				<a> <img style="padding-top: 3px;width:44px;"
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
							<div class="tablekey">学院</div>
							<div class="tablevalue">${score.collegeName}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">专业</div>
							<div class="tablevalue">${score.professionName}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">入学年份</div>
							<div class="tablevalue">${score.year}</div>
						</div>
						<div class="tablerow" >
							<div class="tablekey">成绩文件</div>
							<div class="tablevalue"><a href="download.html?id=${score.id}">${score.fileName}</a></div>
						</div>
					<div class="tabletailgray">
						<div class="tablefunc" style="padding:10px;">
							<div class="btn-group">
									<a type="button" class="btn btn-default" href="download.html?id=${score.id}">下载成绩文件</a>
									<a type="button" class="btn btn-default" href="report.html?id=${score.id}">生成成绩报表</a>
									<a type="button" class="btn btn-default" onclick="if(confirm('确定删除这张成绩表吗？')){}else{return false;}" href="delete.html?id=${score.id}">删除</a>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {

			});
		</script>
</body>
</html>