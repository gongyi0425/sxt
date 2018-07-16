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
<title>员工信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 员工相关 <span class="c-gray en">&gt;</span> 员工信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 
	
	<div class="mt-20">
		<form action="servlet/EmployeeServlet?method=findEmpByXXX" method="post">
			<span class="c-red">用户名：</span>
			<input type="text" class="input-text" style="width:100px" placeholder="用户名" id="" name="empid" value="${empid }">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				所属部门：
				 <span class="select-box" style="width:80px">
					<select class="select" size="1" name="deptno"  >
						<option value="0" selected>--全部--</option>
						<c:forEach items="${deptList}" var="dept">
							<c:if test="${deptno==dept.deptno }">
								<option value="${dept.deptno }" selected="selected">${dept.deptName }</option>
							</c:if>
							<c:if test="${deptno!=dept.deptno }">
								<option value="${dept.deptno }">${dept.deptName }</option>
							</c:if>
						</c:forEach>
					</select>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				从事岗位：	
					 <span class="select-box" style="width:80px">
					<select class="select" size="1" name="posid"  >
						<option value="0" selected>--全部--</option>
						<c:forEach items="${posList}" var="pos">
							<c:if test="${posid==pos.posid }">
								<option value="${pos.posid }" selected="selected">${pos.posName }</option>
							</c:if>
							<c:if test="${posid!=pos.posid }">
								<option value="${pos.posid }" >${pos.posName }</option>
							</c:if>
						</c:forEach>
					</select>
					</span> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<c:if test="${onDuty == 1 }">
				<label for="sex-1">在职</label>
				<input name="onDuty" type="radio" id="sex-1" value="1" checked>			
				<label for="sex-2">离职</label>
				<input type="radio" id="sex-2" name="onDuty" value="0">
			</c:if>
			
			<c:if test="${onDuty == 0 }">
				<label for="sex-1">在职</label>
				<input name="onDuty" type="radio" id="sex-1" value="1" >			
				<label for="sex-2">离职</label>
				<input type="radio" id="sex-2" name="onDuty" value="0" checked>
			</c:if>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			入职时间：
			<input type="text" value="${hireDate }"  name="hireDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"  class="input-text Wdate" style="width:120px;" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			
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
				<th width="80">用户名</th>
				<th width="100">员工姓名</th>
				<th width="40">性别</th>				
				<th width="50">部门</th>
				<th width="130">岗位</th>
				<th width="70">入职时间</th>
				<th width="70">上级</th>			
				<th width="100">手机</th>
			
				<th width="200">基本操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td id="empid">${ emp.empid}</td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${emp.empName }  的详细信息','servlet/EmployeeServlet?method=findEmpInfo&empid=${emp.empid}','10001','360','400')">${emp.empName }</u></td>
					<td>${emp.empSex }</td>
					<td>${emp.dept.deptName }</td>
					<td>${emp.pos.posName }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.mgr.empName }</td>				
					<td>${emp.phone }</td>
					<td class="td-manage">
					<span class="label label-success radius"><a href="servlet/EmployeeServlet?method=findEmpInfo&empid=${emp.empid}">查看员工详细信息 </a></span>
					<a title="编辑" href="javascript:;"  onclick="member_edit('编辑','servlet/EmployeeServlet?method=toUpdateEmp&empid=${emp.empid}','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="pwdReset('${emp.empid}')"  title="重置密码"><i class="Hui-iconfont">&#xe63f;</i></a> 
					<a title="删除" href="javascript:;" onclick="deleteEmp('${emp.empid}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
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
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
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


/*用户重置 -- 密码*/
function pwdReset(empid){
	layer.confirm("确认要重置密码吗？", { title: "重置确认" }, function (index) {  
          layer.close(index);  
          $.post("servlet/EmployeeServlet?method=pwdReset", { empid:empid }, function (data) { 
                   
              layer.alert(data, {  
                 title: "重置密码",  
                btn: ['确定'] 
                 
              },  
                  function (index, item) {  
                      //layer.close(index);  
                      location.reload();  
                  }); 
           
          });  
      }); 
}

/*用户-删除*/
function deleteEmp(empid){
	layer.confirm("确认要删除该员工信息吗？", { title: "删除确认" }, function (index) {  
          layer.close(index);  
          $.post("servlet/EmployeeServlet?method=deleteEmp", { empid:empid }, function (data) { 
                   
              layer.alert(data, {  
                 title: "删除员工信息",  
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