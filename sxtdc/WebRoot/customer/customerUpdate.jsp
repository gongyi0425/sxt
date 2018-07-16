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

<title>修改客户信息</title>
<meta name="keywords" content="bjsxt-sxtdc 507_突击组">
<meta name="description" content="bjsxt-sxtdc 507_突击组">
</head>
<body>
<article class="page-container">
	<form action="servlet/CustomerServlet?method=updateCus" method="post" class="form form-horizontal" id="form-member-add2">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="hidden" class="input-text" value="${cus.cusid }" placeholder="" id="" name="cusid">
				<input type="text" class="input-text" value="${cus.cusName }" placeholder="" id="" name="cusName">
				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户状态：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="staid"  >
					<option value="0" selected>--客户状态--</option>
					<c:forEach items="${staList }" var="sta">
					    <c:if test="${cus.staid==sta.staid }">
					    	<option value="${sta.staid }" selected="selected">${sta.staName }</option>
					    </c:if>
						 <c:if test="${cus.staid != sta.staid }">
					    	<option value="${sta.staid }" >${sta.staName }</option>
					    </c:if>
					</c:forEach>
					
					
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户类型：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="typeid"  >
					<option value="0" selected>--客户类型--</option>
					<c:forEach items="${typeList }" var="type">
					 	<c:if test="${cus.typeid == type.typeid }">
					   		 <option value="${type.typeid }" selected="selected">${type.typeName }</option>
					    </c:if>
						<c:if test="${cus.typeid != type.typeid }">
					   		 <option value="${type.typeid }">${type.typeName }</option>
					    </c:if>
					</c:forEach>	
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户来源：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="souid"  >
					<option value="0" selected>--客户来源--</option>
					<c:forEach items="${souList }" var="sou">
					 	<c:if test="${cus.souid == sou.souid}">
					    	<option value="${sou.souid }" selected="selected">${sou.souName }</option>
					    </c:if>
						<c:if test="${cus.souid != sou.souid}">
					    	<option value="${sou.souid }" >${sou.souName }</option>
					    </c:if>
					</c:forEach>	
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户公司：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${cus.cusCompany }" placeholder="" id="" name="cusCompany" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户职位：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${cus.cusJob }" placeholder="" id="" name="cusJob" style="width:250px">
			</div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户住址：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${cus.cusAddress }" placeholder="" id="" name="cusAddress">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${cus.cusPhone }" placeholder="" id="" name="cusPhone" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户座机：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${cus.cusPlane }" placeholder="" id="" name="cusPlane" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>QQ：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" value="${ cus.cusQQ}" name="cusQQ" id="" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="@" value="${cus.email }" name="email" id="" style="width:250px">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)">${cus.remark }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" >
			</div>
		</div>
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

/*function btn(){
	
	document.fileForm.submit();
	 window.opener=null;
  window.open('','_self');
  window.close();

}*/
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>