<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>交易信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 交易管理 <span class="c-gray en">&gt;</span> 交易信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="servlet/BargainServlet?method=findByIdBargain" method="post">
		<div class="text-c"> 
			请输入查询内容<input type="text" class="input-text" style="width:250px" placeholder="请输入内容" id="" name="query" value="${query }">
			 <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：
		 		<select name="queryType" style="width: 100px" id="queryType">
		 			<c:if test="${queryType == null  }">
		 				<option value="0" selected="selected">--全部--</option>
		 				<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>	
		 			<c:if test="${queryType == 0 }">
		 				<option value="0" selected="selected">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
					<c:if test="${queryType == 1 }">
		 				<option value="0">--全部--</option>
						<option value="1" selected="selected">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
		 			<c:if test="${queryType == 2 }">
		 				<option value="0">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2" selected="selected">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
		 			<c:if test="${queryType == 3 }">
		 				<option value="0">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3" selected="selected">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
		 			<c:if test="${queryType == 4 }">
		 				<option value="0">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4" selected="selected">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
		 			<c:if test="${queryType == 5 }">
		 				<option value="0">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5" selected="selected">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
		 			<c:if test="${queryType == 6 }">
		 				<option value="0">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6" selected="selected">成交价格</option>
					 	<option value="7">交易时间</option>
		 			</c:if>
		 			<c:if test="${queryType == 7 }">
		 				<option value="0">--全部--</option>
						<option value="1">订单编号</option>
					 	<option value="2">客户姓名</option>
					 	<option value="3">员工姓名</option>
					 	<option value="4">房屋类型</option>
					 	<option value="5">房屋面积</option>
					 	<option value="6">成交价格</option>
					 	<option value="7" selected="selected">交易时间</option>
		 			</c:if>
				 </select>            
	   		</td>
		
			
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			 <a><input name="" id="btn2" type="button" style="width:100px" class="btn btn-primary radius" value="导出" /></a>
			 <a><input name="" type="button" style="width:100px" class="btn btn-danger radius" value="清空" /></a>
			 
		</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"><span class="r"><strong></strong> </span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">订单号</th>
				<th width="80">客户姓名</th>
				<th width="80">员工姓名</th>				
				<th width="80">房屋类型</th>
				<th width="80">房屋面积</th>
				<th width="80">成交价格</th>
				<th width="100">成交时间</th>			
				<th width="150">备注信息</th>
			
				<th width="200">基本操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bargainList }" var="bargain">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${bargain.barid }</td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${bargain.cus.cusName }','servlet/CustomerServlet?method=findCusInfo&cusid=${bargain.cus.cusid }','10001','360','400')">${bargain.cus.cusName }</u></td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${bargain.emp.empName }','servlet/EmployeeServlet?method=findEmpInfo&cusid=${bargain.emp.empid }','10001','360','400')">${bargain.emp.empName }</u></td>
					<td>${bargain.hou.type.typeName }</td>
					<td>${bargain.hou.area }</td>
					<td>${bargain.barprice }</td>
					<td>${bargain.fixturedate }</td>
					<td>${bargain.barDesc }</td>
					<td class="td-manage">
					<span class="label label-success radius">
						<u style="cursor:pointer" class="text-primary" onclick="member_show('交易单详细信息','servlet/BargainServlet?method=findBarInfo&barid=${bargain.barid }','10001','360','400')">查看交易详细信息</u>
					</span>
					<!--  <a title="删除" href="javascript:;" onclick="deleteSource(${bargain.barid })" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aLengthMenu":[5,10,20,30],  //用户可自选每页展示数量 5条或10条
		"searching":false,//禁用搜索（搜索框）
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
	
	//给导出按钮绑定单击事件
	$("#btn2").click(function(){
	//获取三个查询条件的值
	var query = $("#query").val();
	var queryType = $("#queryType").val();
	
	
	//访问指定的Servlet，不使用Ajax（因为Ajax是通过回调函数处理结果的，导出XLS是直接返回流，所以也不使用转发和重定向）
	location.href="servlet/BargainServlet?method=exportXls&query="+query+"&queryType="+queryType;
	
	});
});

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

function change_password(obj,id){
	layer.confirm('确定重置密码？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('密码重置成功!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
function deleteSource(barid){
	var flag = window.confirm("您确定要删除该交易记录吗");
	if(flag){
		location.href="servlet/BargainServlet?method=deleteBargain&barid="+barid;
	}
}
</script> 
</body>
</html>