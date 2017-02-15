<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="/lookAhead/static/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/lookAhead/static/js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})
	
})
function scoreSubmit(id){
	
	
	
	var score =$('input:radio[name=radio'+id+']:checked').val();
	if (typeof(score) == "undefined")
		{
		alert("请选择评分！");
		return;
		}else{
			
			$.ajax({
			    url: "/lookAhead/stu_scoresubmit",    //请求的url地址
			    dataType: "json",   //返回格式为json
			    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
			    data: { "id": id, "score":score},    //参数值
			    type: "GET",   //请求方式
			    
			    success: function(date) {
			        //提示成功
			    	if(date.msg==1)
			    		{
			    		   alert("成功！")
			    		
			    		   $('#spansc'+id).text(date.score);
			    		
			    		   //隐藏评分按钮
			    		   $('input:radio[name=radio'+id+']').attr("disabled","true");
			    		   //禁用提交按钮:
			    		   $('input:button[name=sub'+id+']').attr("disabled","true");
			    		  
			    		}else if(date.msg==-1){
			    			alert("课件ID不存在！");
			    		}else if(date.msg==0){
			    			alert("评分失败！");
			    		}
			   },
			   error: function() {
			       alert("ajax通讯错误，请联系管理员！");
			    }
			});
		}
}


</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
<style>
	#subbtn{
		border:none;
		background:none;
		-webkit-appearance:none;
		color:#046dae;
		font-size:10pt;
		font-family:'微软雅黑';
	}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="/lookAhead/stu_rightMain">首页</a></li>
			<li><a href="#">学生评分</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<form action="#" method="post">
			<table class="imgtable">

				<thead>
					<tr>
						<th>ID<i class="sort"><img
								src="/lookAhead/static/images/px.gif" /></i></th>
						<th width="120px;">课件图</th>
						<th width="120px;">课件名称</th>
						<th>科目</th>
						<th>发布人</th>
						<th>分数</th>
						<th>下载量</th>
						<th>评分</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="courseware" items="${coursewares}">
						<tr>
							<td>${courseware.id}</td>
							<td class="imgtd"><img
								src="/lookAhead/static/images/img11.png" /></td>
							<td><a href="#">${courseware.coursewareName}</a>
								<p>发布时间：2013-10-12 09:25:18</p></td>
							<td>${courseware.coursewareSubject}</td>
							<td>张三</td>
							<td><span id="spansc${courseware.id}" style="color:red">${courseware.coursewareScore}</span> </td>
							<td>${courseware.downloadNum}</td>
							<td><label><input type="radio"
									name="radio${courseware.id}" value="-2">
									非常不满（-2分）&nbsp;&nbsp;&nbsp;</label> <label><input type="radio"
									name="radio${courseware.id}" value="-1">
									不满意（-1分）&nbsp;&nbsp;&nbsp;</label> <label><input type="radio"
									name="radio${courseware.id}" value="3">
									一般（3分）&nbsp;&nbsp;&nbsp;</label> <label><input type="radio"
									name="radio${courseware.id}" value="4">
									基本满意（4分）&nbsp;&nbsp;&nbsp;</label> <label><input type="radio"
									name="radio${courseware.id}" value="5">
									非常满意（5分）&nbsp;&nbsp;&nbsp;</label> <input type="button" value="提交"
								onclick="scoreSubmit(${courseware.id})"
								name="sub${courseware.id}" id="subbtn"/></td>

						</tr>
					</c:forEach>

				</tbody>

			</table>
			<!-- <div id="saveScore">
				<input type="submit" class="mybtn" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="mybtn" value="取消" />
			</div> -->
		</form>



		<div class="pagin">
			<div class="message">
				共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
						class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">1</a></li>
				<li class="paginItem current"><a href="javascript:;">2</a></li>
				<li class="paginItem"><a href="javascript:;">3</a></li>
				<li class="paginItem"><a href="javascript:;">4</a></li>
				<li class="paginItem"><a href="javascript:;">5</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">10</a></li>
				<li class="paginItem"><a href="javascript:;"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="/lookAhead/static/images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>





		<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
</script>
</body>
</html>