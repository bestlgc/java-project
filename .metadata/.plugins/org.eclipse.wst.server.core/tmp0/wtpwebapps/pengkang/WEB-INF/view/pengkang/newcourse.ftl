<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>彭康书院成绩分析系统</title>
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css" href="${path}/css/base.css">
<link rel="stylesheet" type="text/css" href="${path}/css/base1.css">
<script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
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
				<ul class="page-sidebar-menu"><#assign consoleapp="1">
					<#include "console.ftl">
				</ul>
			</div>
		</div>
		<div class="page-content-wrapper">
			<div class="page-content">


				<div class="eoptable">
					<div class="table-name">
						添加课程 <span class="table-name-div"><span>
					</div>
					<div class="tablehead"></div>
					<form id="form" method="post" action="save.html">
						<div class="tablebody">
							
							<div class="tablerow">
								<div class="tablekey">课程号：</div>
								<input name="courseId" class="tablevalue required name" type="text" />
								<span class="error">必填,英文+中文,最大长度10</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">课程名称：</div>
								<input name="courseName" class="tablevalue required description" type="text" />
								<span class="error">必填,英文+中文+数字,最大长度40</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">课程学分：</div>
								<input name="courseCredit" class="tablevalue required name" type="text" />
								<span class="error">必填,英文+中文,最大长度10</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">课程所属专业：</div>
								<input name="courseProfession" class="tablevalue required name" type="text" />
								<span class="error">必填,英文+中文,最大长度10</span>
							</div>
							<div class="tablerow">
								<div class="tablekey">课程所属年级：</div>
								<input name="courseGrade" class="tablevalue required name" type="text" />
								<span class="error">必填,英文+中文,最大长度10</span>
							</div>
							
						<div class="tabletailgray">
							<div class="tablefunc" style="padding: 10px;">
								<div class="btn-group">
									<a class="btn btn-default" style="width: 110px;color: white"  onclick="if(confirm('确定保存吗？')){$("#form").submit();}else{return false;}">
                                  		  保存
                                	</a>
                       			</div>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
		
		<script type="text/javascript" src="${path}/js/jquery.validVal.js"></script>
		<script type="text/javascript" src="${path}/js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${path}/js/attach.js"></script>
		<script src="${path}/js/jquery.validVal-customValidations.js" type="text/javascript"></script>
</body>
</html>