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
    <li><a href="tc_rightMain.html">首页</a></li>
	<li><a href="#">我的课件</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class=""><a href="tc_addCourse.html"><span><img src="${path}/images/t01.png" /></span>上传课件</a></li>
        <li><span><img src="${path}/images/t03.png" /></span>删除</li>
        </ul>
        
        
        <ul id="find" >
			<li><input type="text" name="findUser" id ="findUser"/><a href="#"><img src="${path}/images/ico06.png" /></a></li>
        </ul>
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
	<th><input name="" type="checkbox" value="" checked="checked"/></th>
    <th>ID<i class="sort"><img src="${path}/images/px.gif" /></i></th>
    <th width="100px;">课件图</th>
    <th>课件名称</th>
    <th>科目</th>
    <th>发布人</th>
    <th>课件状态</th>
	<th>分数</th>
    <th>下载量</th>
	<th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    
    <tr>
	<td><input name="" type="checkbox" value="" /></td>
    <td>20130908</td>
    <td class="imgtd"><img src="${path}/images/img11.png" /></td>
    <td><a href="#">课程模板</a><p>发布时间：2013-10-12 09:25:18</p></td>
    <td>英语</td>
    <td>张三</td>
    <td>已审核</td>
    <td>5分</td>
	<td>50次</td>
	<td><a href="#" class="tablelink">查看</a> &nbsp<a href="#" class="tablelink"> 删除</a></td>

    </tr>
    
    <tr>
	<td><input name="" type="checkbox" value="" /></td>
    <td>20130908</td>
    <td class="imgtd"><img src="${path}/images/img12.png" /></td>
    <td><a href="#">简约形状图标</a><p>发布时间：2013-10-12 09:25:18</p></td>
    <td>英语</td>
    <td>张三</td>
    <td><i>未审核</i></td>
    <td>5分</td>
	<td>50次</td>
	<td><a href="#" class="tablelink">查看</a> &nbsp<a href="#" class="tablelink"> 删除</a></td>
	</tr>
    
   
    
    </tbody>
    
    </table>
    
    
    
    
    
   
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
        <span><img src="${path}/images/ticon.png" /></span>
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
    
    
    
   
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
