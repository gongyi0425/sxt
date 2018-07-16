<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<script type="text/javascript" src="My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>客户信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 客户中心 <span class="c-gray en">&gt;</span> 客户信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 
		<form action="servlet/HouseServlet?method=findHouseByName" method="post">
			房屋地址查询：
			<input type="text" class="input-text" style="width:100px" placeholder="用户名" id="" name="houName" value="${houName }">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			按户型查询&nbsp;&nbsp;
				 <span class="select-box" style="width:150px">
					<select class="select" size="1" name="typeName">
						<option value="0">全部</option>
						<c:forEach items="${houseTypeList }" var="houseType">
							<c:if test="${houseType.typeid == typeid }">
								<option value="${houseType.typeid }" selected="selected">${houseType.typeName }</option>
							</c:if>
							<c:if test="${houseType.typeid != typeid }">
								<option value="${houseType.typeid }">${houseType.typeName }</option>
							</c:if>
						</c:forEach>
					</select>
				</span> &nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			房屋单价查询：
			<input type="text" class="input-text" style="width:100px" placeholder="用户名" id="" name="price" value="${price }">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
			<button type="submit" style="width:100px" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			
			 <a><input name="" type="button" style="width:100px" class="btn btn-primary radius" value="清空" /></a>
		</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"><span class="r">共有数据：<strong>--</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">房屋编号</th>
				<th width="100">房屋类型</th>								
				<th width="50">房屋地址</th>
				<th width="130">房屋面积</th>
				<th width="130">房屋单价</th>					
							

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${houList}" var="hou">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td id="empid">${hou.houseid }</td>
					<td>${hou.type.typeName }</td>					
					<td>${hou.location }</td>
					<td>${hou.price }</td>	
					<td>${hou.area }</td>							
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



</script> 
</body>
</html>