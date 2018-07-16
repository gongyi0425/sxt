<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<!--/meta 作为公共模版分离出去-->

<title>添加员工</title>
<meta name="keywords" content="sxt-dc突击组">
<meta name="description" content="bjsxt-dc_507突击组">
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->


<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
</script> 
</head>
<body>
<article class="page-container">
	<form action="servlet/EmployeeServlet?method=updateEmp" method="post" class="form form-horizontal" id="form-member-add1">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${emp.empid }" placeholder="不可修改" id="username" name="empid" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${emp.empName }" placeholder="不可修改" id="username" name="empName" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>员工等级：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="empType" type="radio" id="sex-1" value="1" checked>
					<label for="sex-1">基层员工</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="empType" value="2">
					<label for="sex-2">各级管理人员</label>
				</div>
				
			</div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所属部门：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="deptno"  >
					<option value="" selected>--请选择部门--</option>
					<c:forEach items="${deptList }" var="dept">
						<c:if test="${emp.deptno == dept.deptno}">
							<option value="${dept.deptno }" selected="selected">${dept.deptName }</option>
						</c:if>
						<c:if test="${emp.deptno != dept.deptno}">
							<option value="${dept.deptno }" >${dept.deptName }</option>
						</c:if>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>从事岗位：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="posid"  >
					<option value="" selected>--请选择岗位--</option>
					<c:forEach items="${posList }" var="pos">
						<c:if test="${emp.posid == pos.posid}">
							<option value="${pos.posid }" selected="selected">${pos.posName }</option>
						</c:if>
						<c:if test="${emp.posid != pos.posid}">
							<option value="${pos.posid }" >${pos.posName }</option>
						</c:if>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>直接上级：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="mgrid"  >
					
					<option value="" selected>直接上级</option>
					
					<c:forEach items="${mgrList }" var="e">
						<c:if test="${emp.mgrid == e.empid }">
							<option value="${e.empid }" selected="selected">${e.empName }</option>
						</c:if>
						<c:if test="${emp.empid != e.mgr.empid }">
							<option value="${e.empid }" >${e.empName }</option>
						</c:if>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>家庭住址：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${emp.address }" placeholder="" id="" name=address>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>婚否：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${emp.marry }" placeholder="" id="" name="marry" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>银行卡号：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${emp.wagesnum }" placeholder="" id="" name="wagesnum" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">紧急联系人信息：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="emerContactPerson" cols="" rows="" class="textarea"  placeholder="必填" onKeyUp="$.Huitextarealength(this,100)">${emp.emerContactPerson }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="empDesc" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)">${emp.empDesc }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/50</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>


<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>