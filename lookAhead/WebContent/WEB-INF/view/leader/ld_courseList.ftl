<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="leader_rightMain.html">首页</a></li>
    <li><a href="ld_lookCourse.html">课件管理</a></li>
	<li><a href="#">课件模板</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class=""><a href="ld_addCourse.html" ><span><img src="${path}/images/t01.png" /></span>添加</a></li>
        <li class="click"><span><img src="${path}/images/t02.png" /></span>修改</li>
        <li><span><img src="${path}/images/t03.png" /></span>删除</li>
        </ul>    
    
    </div>
    
    
    <ul class="imglist">
    
    <li class="selected">
    <span><img src="${path}/images/img01.png" /></span>
    <h2><a href="#">软件界面设计下载</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img02.png" /></span>
    <h2><a href="#">界面样式素材下载</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img03.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img04.png" /></span>
    <h2><a href="#">羽毛图标设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img05.png" /></span>
    <h2><a href="#">日历组件样式设计</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img06.png" /></span>
    <h2><a href="#">羽毛图标设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img07.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img08.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img09.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="${path}/images/img10.png" /></span>
    <h2><a href="#">软件界面设计下载</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    </ul>
    
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
</body>
</html>