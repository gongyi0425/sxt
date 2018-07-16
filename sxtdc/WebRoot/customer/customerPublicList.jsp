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
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 
		<form action="servlet/CustomerServlet?method=findCusByXXX" method="post">
			请输入查询内容<input type="text" class="input-text" style="width:250px" placeholder="请输入内容" id="" name="content" value="${content }">
			 <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：<select name="queryType" style="width: 100px">
			 				<option value="0" selected>--全部--</option>
			 				<c:if test="${queryType==0 }">
			 					<option value="1">客户姓名</option>
		     				 	<option value="2">客户状态</option>
		     				 	<option value="3">客户来源</option>
		     				 	<option value="4">客户类型</option>
		     				 	<option value="5">所属员工</option>
		     				 	<option value="6">客户公司</option>
			 				</c:if>
			 				<c:if test="${queryType==1 }">
			 					<option value="1" selected="selected">客户姓名</option>
		     				 	<option value="2">客户状态</option>
		     				 	<option value="3">客户来源</option>
		     				 	<option value="4">客户类型</option>
		     				 	<option value="5">所属员工</option>
		     				 	<option value="6">客户公司</option>
			 				</c:if>
			 				<c:if test="${queryType==2 }">
				 				<option value="1">客户姓名</option>
		     				 	<option value="2" selected="selected">客户状态</option>
		     				 	<option value="3">客户来源</option>
		     				 	<option value="4">客户类型</option>
		     				 	<option value="5">所属员工</option>
		     				 	<option value="6">客户公司</option>
			 				</c:if>
			 				<c:if test="${queryType==3 }">
				 				<option value="1">客户姓名</option>
		     				 	<option value="2">客户状态</option>
		     				 	<option value="3" selected="selected">客户来源</option>
		     				 	<option value="4">客户类型</option>
		     				 	<option value="5">所属员工</option>
		     				 	<option value="6">客户公司</option>
			 				</c:if>
			 				<c:if test="${queryType==4 }">
				 				<option value="1">客户姓名</option>
		     				 	<option value="2">客户状态</option>
		     				 	<option value="3">客户来源</option>
		     				 	<option value="4" selected="selected">客户类型</option>
		     				 	<option value="5">所属员工</option>
		     				 	<option value="6">客户公司</option>
			 				</c:if>
			 				<c:if test="${queryType==5 }">
				 				<option value="1">客户姓名</option>
		     				 	<option value="2">客户状态</option>
		     				 	<option value="3">客户来源</option>
		     				 	<option value="4">客户类型</option>
		     				 	<option value="5" selected="selected">所属员工</option>
		     				 	<option value="6">客户公司</option>
			 				</c:if>
			 				<c:if test="${queryType==6 }">
				 				<option value="1">客户姓名</option>
		     				 	<option value="2">客户状态</option>
		     				 	<option value="3">客户来源</option>
		     				 	<option value="4">客户类型</option>
		     				 	<option value="5">所属员工</option>
		     				 	<option value="6" selected="selected">客户公司</option>
			 				</c:if>
	      					
	   				 </select>            
	   				</td>
		
			
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
		</form>
	</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <a href="javascript:;" onclick="member_add('添加用户','customerAdd.html','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加客户</a>
		
		
	</div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">客户姓名</th>
				<th width="80">状态</th>
				<th width="80">来源</th>
				<th width="90">所属员工</th>
				<th width="100">类型</th>
				<th width="50">性别</th>
				<th width="130">手机</th>
				<th width="150">职位</th>
				<th width="150">公司</th>
				<th width="50">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cusList }" var="cus">
					<c:if test="${empty cus.empid}">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${cus.cusName}','servlet/CustomerServlet?method=findCusInfo&cusid=${cus.cusid }','10001','360','400')">${cus.cusName }</u></td>
					<td>${cus.status.staName }</td>				
					<td>${cus.source.souName }</td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${cus.emp.empName}','servlet/EmployeeServlet?method=findEmpInfo&cusid=${cus.empid }','10001','360','400')">${cus.emp.empName }</u></td>					
					<td>${cus.type.typeName }</td>
					<td>${cus.cusSex }</td>			
					<td>${cus.cusPhone }</td>
					<td>${cus.cusJob }</td>
					<td >${cus.cusCompany }</td>
					<td class="td-manage">
						<span class="label label-success radius"><a href="servlet/CustomerServlet?method=findCusInfo&cusid=${cus.cusid }">查看 </a></span>&nbsp;	
						
					</td>
				</tr>
				</c:if>
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
		"aLengthMenu":[5,10,20,30],  //用户可自选每页展示数量 5条或10条
		//"searching":false,//禁用搜索（搜索框）
		"bStateSave": true,//状态保存
		
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,10]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-删除*/
function deleteCus(cusid){
	layer.confirm("确认要删除该客户信息吗？", { title: "删除确认" }, function (index) {  
          layer.close(index);  
          $.post("servlet/CustomerServlet?method=deleteCus", { cusid:cusid }, function (data) { 
                   
              layer.alert(data, {  
                 title: "删除客户信息",  
                btn: ['确定'] 
                 
              },  
                  function (index, item) {  
                      //layer.close(index);  
                      location.reload();  
                  }); 
           
          });  
      }); 
}
</script> 
</body>
</html>