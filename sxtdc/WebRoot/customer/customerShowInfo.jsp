<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>查看客户信息</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
	<img class="avatar size-XL l" src="static/h-ui/images/ucnter/avatar-default.jpg">
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">${cus.cusName }</span>
			<span class="pl-10 f-12">---</span>
		</dt>
		<dd class="pt-10 f-12" style="margin-left:0">${cus.remark }</dd>
	</dl>
</div>
<div class="pd-20">
	<table class="table">
		<tbody>
			<tr>
				<th class="text-r" width="80">性别：</th>
				<td>${cus.cusSex }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">所属员工：</th>
				<td>${cus.emp.empName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">客户类型：</th>
				<td>${cus.type.typeName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">客户状态：</th>
				<td>${cus.status.staName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">客户来源：</th>
				<td>${cus.source.souName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">生日：</th>
				<td>${cus.birthday }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">客户公司：</th>
				<td>${cus.cusCompany }</td>
			</tr>
			<tr>
				<th class="text-r">客户职位：</th>
				<td>${cus.cusJob }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">客户住址：</th>
				<td>${cus.cusAddress }</td>
			</tr>
			<tr>
				<th class="text-r">客户手机号码：</th>
				<td>${cus.cusPhone }</td>
			</tr>
			<tr>
				<th class="text-r">客户电话号码：</th>
				<td>${cus.cusPlane }</td>
			</tr>
			<tr>
				<th class="text-r">QQ：</th>
				<td>${cus.cusQQ }</td>
			</tr>
			<tr>
				<th class="text-r">客户邮箱：</th>
				<td>${cus.email }</td>
			</tr>
			<tr>
				<th class="text-r">创建人：</th>
				<td>${cus.fouder }</td>
			</tr>
			<tr>
				<th class="text-r">创建时间：</th>
				<td>${cus.addTime }</td>
			</tr>
			<tr>
				<th class="text-r">修改人：</th>
				<td>${cus.changeMan }</td>
			</tr>
			<tr>
				<th class="text-r">修改时间：</th>
				<td>${cus.updateTime }</td>
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