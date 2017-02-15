<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign path="${rc.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Look Ahead 在线学习平台</title>
<link href="${path}/css/style.css" rel="stylesheet" type="text/css" />

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="leader_rightMain.html">首页</a></li>
    <li><a href="#">课件列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="#"><a href="/lookAhead/initUpload"><span><img src="${path}/images/t01.png" /></span>添加</a></li>
        <li class="#"><a href="leader_editUser.html"><span><img src="${path}/images/t02.png" /></span>修改</a></li>
        <li><span><img src="${path}/images/t03.png" /></span>删除</li>
		
        </ul>
		
		<ul id="find" >
			<li><input type="text" name="findUser" id ="findUser"/><a href="#"><img src="${path}/images/ico06.png" /></a></li>
        </ul>
    </div>  
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>ID</th>
        <th>文件名</th>
        <th>描述</th>
		<th>上传者</th>
		<th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list vlist as vl>
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        
        <td>${vl.id}</td>
        <td>${vl.fileName}</td>
        <td>${vl.comment}</td>
  
		<td>${vl.author}</td>
        <td><a href="/lookAhead/download/${vl.id}" class="tablelink">下载</a><a href="/lookAhead/delete/${vl.id}" class="tablelink"> 删除</a></td>
        </tr> 
         </#list>
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
    
    
    </div>
</body>
</html>
