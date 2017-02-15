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
				<ul class="page-sidebar-menu"><#assign consoleapp="1">
					<#include "console.ftl">
				</ul>
			</div>
		</div>
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="eoptable">
					<div class="table-name">
						成绩列表<span class="table-name-div"><span>
					</div>
					<div class="tablehead"></div>
					<div class="tablebody">
						<table>
							<thead>
								<tr>
									<th>学院</th>
									<th>专业</th>
									<th>入学年份</th>
									<th>成绩文件</th>
								</tr>
							</thead>
							<tbody>
								<#list page.results as score>
								<tr onclick="location.href='detail.html?id=${score.id}'">
									<td>${score.collegeName}</td>
									<td>${score.professionName}</td>
									<td>${score.year}</td>
									<td>${score.fileName}</td>
								</tr>
								</#list>
							</tbody>
						</table>


						<div class="tabletail">
							<div class="tablefunc">
								<div class="btn-group">
									<button onclick="location.href='newscore.html'" type="button"
										class="btn btn-default">添加课程</button>
								</div>
							</div>
							<div class="tablepage">
								<ul class="pagination">
									<#if page.pageNo+1 gt 2>
										<li><a href="list.html?pageindex=0&pageNum=15">&laquo;</a></li>
									</#if>
									<#if page.pageNo+1 gt 1>
											<li><a href="list.html?pageindex=${page.pageNo-1}&pageNum=15">${page.pageNo}</a></li>
									</#if>
									<li class="active"><a href="list.html?pageindex=${page.pageNo}&pageNum=15">${page.pageNo+1}</a></li>
									<#if page.pageNo+1 lt page.totalRecord/page.pageSize>
										<li><a href="list.html?pageindex=${page.pageNo+1}&pageNum=15">${page.pageNo+2}</a></li>
									</#if>
									<#if page.pageNo+2 lt page.totalRecord/page.pageSize>
										<li><a href="list.html?pageindex=${page.totalPage}&pageNum=15">&raquo;</a></li>
									</#if>
								</ul>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>

	</div>
	<script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
	
</body>
</html>