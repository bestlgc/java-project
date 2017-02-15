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
<script type="text/javascript" src="${path}/js/echarts.js"></script>
<script type="text/javascript" src="${path}/js/dark.js"></script>
<script type="text/javascript" src="${path}/js/macarons.js"></script>
<script type="text/javascript" src="${path}/js/vintage.js"></script>
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
						${viewreport.collegeName}${viewreport.professionName}专业 ${viewreport.year}年成绩报表 <span class="table-name-div"><span>
					</div>
					<div class="tablehead"></div>
					<div class="tablebody">
						<div class="tablerow">
							<div class="tablekey">平均分：</div>
							<div class="tablevalue">${viewreport.averageScore}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">学生人数：</div>
							<div class="tablevalue">${viewreport.studentCount}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">班级个数</div>
							<div class="tablevalue">${viewreport.classCount}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">优良率(平均分)：</div>
							<div class="tablevalue">${viewreport.excellentRate}</div>
						</div>
						<div class="tablerow">
							<div class="tablekey">不及格率(平均分):</div>
							<div class="tablevalue">${viewreport.failurerate}</div>
						</div>
					</div>
					<div class="tablebody">
						<div id="main" style="width:1000px;height:600px;"></div>
					</div>
					
					<div class="tablebody">
						<div id="main2" style="width:1000px;height:600px;"></div>
					</div>
					<div class="tablebody">
						<div id="main3" style="width:1000px;height:600px;"></div>
					</div>
					<div class="tablebody">
						<div id="main4" style="width:1000px;height:600px;"></div>
					</div>
				</div>
			</div>

		</div>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		
		<script type="text/javascript">
			var myChart = echarts.init(document.getElementById('main'),'dark');
			var myChart2 = echarts.init(document.getElementById('main2'),'dark');
			var myChart3 = echarts.init(document.getElementById('main3'),'dark');
			var myChart4 = echarts.init(document.getElementById('main4'),'dark');
			var option = {
				title : {
			        text: '成绩分布统计',
			        subtext: '数据来自${viewreport.collegeName}'
			    },
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    legend: {
			        data: ['0-59分', '60-79分','80-100分']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis:  {
			        type: 'value'
			    },
			    yAxis: {
			        type: 'category',
			        data: ${classStrList}
			    },
			    series: [
			        {
			            name: '0-59分',
			            type: 'bar',
			            stack: '总量',
			            label: {
			                normal: {
			                    show: true,
			                    position: 'insideRight'
			                }
			            },
			            data: ${viewreport.dis59Json}
			        },
			        {
			            name: '60-79分',
			            type: 'bar',
			            stack: '总量',
			            label: {
			                normal: {
			                    show: true,
			                    position: 'insideRight'
			                }
			            },
			            data: ${viewreport.dis79Json}
			        },
			        {
			            name: '80-100分',
			            type: 'bar',
			            stack: '总量',
			            label: {
			                normal: {
			                    show: true,
			                    position: 'insideRight'
			                }
			            },
			            data: ${viewreport.dis100Json}
			        }
			    ]
			};
		 var option2 = {
			    title : {
			        text: '科目挂科率统计',
			        subtext: '数据来自${viewreport.collegeName}'
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['挂科人数']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			    	
			        {
			            type : 'category',
			            data : ${viewreport.listSubject},
			            axisLabel:{   interval: 0 }  
			        }
			    ],
			      grid: { // 控制图的大小，调整下面这些值就可以，
			             x: 40,
			             x2: 100,
			             y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
			         },
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'挂科人数',
			            type:'bar',
			            data:${viewreport.listSubjectFailure},
			            markPoint : {
			                data : [
			                    {type : 'max', name: '最大值'},
			                    {type : 'min', name: '最小值'}
			                ]
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        }
			    ]
			};
		
		option3 = {
		    title: {
		        text: '各班优良率和不及格率对比',
		        subtext: '数据来自${viewreport.collegeName}'
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    legend: {
		        data: ['优良率', '不及格率']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'value',
		        boundaryGap: [0, 0.01]
		    },
		    yAxis: {
		        type: 'category',
		        data: ${classStrList}
		    },
		    series: [
		        {
		            name: '优良率',
		            type: 'bar',
		            data: ${viewreport.goodRate}
		        },
		        {
		            name: '不及格率',
		            type: 'bar',
		            data: ${viewreport.badRate}
		        }
		    ]
		};
		
		//每个班平均分对比
		option4 = {
			title: {
		        text: '班级专业平均分对比',
		        subtext: '数据来自${viewreport.collegeName}'
		    },
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		        data:${viewreport.listSubject}
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : ${classStrList}
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		    	<#list viewreport.listAverages as listAverage>
		    		 {
			            name:"${listAverage.subject}",
			            type:'bar',
			            data:${listAverage.subjectBanJiScore}
		       		 },
		    	</#list>
		       
		    ]
		};
		 myChart.setOption(option);
		 myChart2.setOption(option2);
		 myChart3.setOption(option3);
		 myChart4.setOption(option4);
		</script>
</body>
</html>