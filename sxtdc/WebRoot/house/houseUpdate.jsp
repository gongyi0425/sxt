<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>"/>
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

<title>添加房屋信息</title>
<meta name="keywords" content="bjsxt-dc  507 突击组">
<meta name="description" content="bjsxt-dc  507 突击组">
</head>
<body>
<article class="page-container">
	<form action="servlet/HouseServlet?method=updateHouse" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>房屋编号：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${house.houseid }" placeholder="" id="username" name="houseid" readonly="readonly">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*&nbsp;</span>房屋地址：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${house.location }" placeholder="" id="username" name="location">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*&nbsp;</span>户型：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="typeid" >
					<option value="" selected>请选择户型</option>
					<c:forEach items="${houseTypeList}" var="type">
						<c:if test="${type.typeid == house.type.typeid }">
							<option value="${type.typeid }" selected="selected">${type.typeName }</option>
						</c:if>
						<c:if test="${type.typeid != house.type.typeid }">
							<option value="${type.typeid }">${type.typeName }</option>
						</c:if>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*&nbsp;</span>面积：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${house.area }" placeholder="" id="username" name="area" style="width:250px"><span class="c-red">（M²）</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*&nbsp;</span>每平米价格：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${house.price }" placeholder="" id="username" name="price" style="width:250px"><span class="c-red">（/M²）</span>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">房屋环境：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="ambient" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)">${house.ambient }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注信息：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="houseDesc" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)">${house.houseDesc }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*&nbsp;</span>交易状态：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${house.housestate }" placeholder="默认为未交交易状态" id="username" name="housestate" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
		<span style="color:red;font-weight: bold;font-size: 16px;">${error }</span>
	</form>
</article>

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
// $(function(){
// 	$('.skin-minimal input').iCheck({
// 		checkboxClass: 'icheckbox-blue',
// 		radioClass: 'iradio-blue',
// 		increaseArea: '20%'
// 	});
	
// 	$("#form-member-add").validate({
// 		rules:{
// 			username:{
// 				required:true,
// 				minlength:2,
// 				maxlength:16
// 			},
// 			sex:{
// 				required:true,
// 			},
// 			mobile:{
// 				required:true,
// 				isMobile:true,
// 			},
// 			email:{
// 				required:true,
// 				email:true,
// 			},
// 			uploadfile:{
// 				required:true,
// 			},
			
// 		},
// 		onkeyup:false,
// 		focusCleanup:true,
// 		success:"valid",
// 		submitHandler:function(form){
			$(form).ajaxSubmit();
// 			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
// 			parent.layer.close(index);
// 		}
// 	});
// });
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
