<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
	<img class="avatar size-XL l" src="static/h-ui/images/ucnter/avatar-default.jpg">
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">${emp.empName }</span>
			<span class="pl-10 f-12">---</span>
		</dt>
		<dd class="pt-10 f-12" style="margin-left:0">${emp.sign }</dd>
	</dl>
</div>
<div class="pd-20"  >
	<table class="table">
		<tbody >
			<tr>
				<th class="text-r" width="80">性别：</th>
				<td>${emp.empSex }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">所属部门：</th>
				<td>${emp.dept.deptName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">从事岗位：</th>
				<td>${emp.pos.posName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">直接上级：</th>
				<td>${emp.mgr.empName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">年龄：</th>
				<td>${emp.empAge }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">出生日期：</th>
				<td>${emp.brithDate }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">入职时间：</th>
				<td>${emp.hireDate }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">离职时间：</th>
				<td>${emp.leaveDate }</td>
			</tr>
			<tr>
				<th class="text-r">手机：</th>
				<td>${emp.phone }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">QQ：</th>
				<td>${emp.qq }</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>${emp.email }</td>
			</tr>
			<tr>
				<th class="text-r">银行卡号：</th>
				<td>${emp.wagesnum }</td>
			</tr>
			<tr>
				<th class="text-r">身份证号：</th>
				<td>${emp.idcard }</td>
			</tr>
			<tr>
				<th class="text-r">家庭地址：</th>
				<td>${emp.address }</td>
			</tr>
			<tr>
				<th class="text-r">学历：</th>
				<td>${emp.empEducation }</td>
			</tr>
			<tr>
				<th class="text-r">婚姻：</th>
				<td>${emp.marry }</td>
			</tr>
			<tr>
				<th class="text-r">紧急联系人信息：</th>
				<td>${emp.emerContactPerson }</td>
			</tr>
			
		</tbody>
	</table>
</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;返回&nbsp;&nbsp;" onclick="history.back()">
			</div>
		</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
</body>
</html>