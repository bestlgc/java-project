<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>彭康书院成绩分析系统</title>


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
				<ul><#include "header.ftl">
				</ul>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar">
				<ul class="page-sidebar-menu"><#assign consolequery="1">
					<#include "console.ftl">
				</ul>
			</div>
		</div>
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="eoptable">
					<div class="table-name">
						成绩查询<span class="table-name-div"><span>
					</div>
					<div class="tablehead"></div>
					<div class="tablebody">
						
						<div class="tablerow">
							<div class="tablekey">学号：</div>
							<div class="tablevalue">${queryResult.stuNo}</div>
						</div>
						
						<div class="tablerow">
							<div class="tablekey">姓名：</div>
							<div class="tablevalue">${queryResult.stuName}</div>
						</div>
						<#list queryResult.viewSubjectScores as subjectScore>
							<div class="tablerow">
								<div class="tablekey">${subjectScore.subjectName}:</div>
								<div class="tablevalue">${subjectScore.score}</div>
							</div>
						</#list>
						<div class="tabletail">
					
						</div>
					</div>
				</div>


			</div>
		</div>

	</div>
	<script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
	
</body>
</html>