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

<title>添加客户</title>
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
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			cusName:{
				required:true,
				minlength:2,
				maxlength:12
			},
			
			cusPhone:{
				required:true,
				number: true
				
			},
			cusQQ:{
				//required:true,
				number: true
			},
			cusPlane:{
				//required:true,
				number: true
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
			
		}/*,
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}*/
	});
	
	

});

/*------------------------------------------------------------*/
$(function(){
   			//alert("ok")
   			$.ajax({
   				type:"post",
   				url:"servlet/CustomerServlet?method=getAreaInfo",
   				data:{"parentID":0},
   				dataType:"text",
   				success:function(result){
 
   					//将得到的result转换成对象
   					eval("var arr="+result)
   					var str="";
   					for(i=0;i<arr.length;i++){
   						str+= '<option value ="'+arr[i].areaID+'" >'+arr[i].areaName+'</option>)';	
   						//$("#province").html('<option value ="'+arr[i].areaID+'" >'+arr[i].areaName+'</option>)')
   					}
   					$("#province").html(str);
   					getCity();
   					
   					
   				}
   			})

   		});
   		
   		
   		function getCity(){
   			//得到当前的vlaue   			
   			var pid = $("#province").val();
   			$.ajax({
   				type:"post",
   				url:"servlet/CustomerServlet?method=getAreaInfo",
   				data:{"parentID":pid},
   				dataType:"text",
   				success:function(result){
 
   					//将得到的result转换成对象
   					eval("var arr="+result)
   					var str="";
   					for(i=0;i<arr.length;i++){
   						str+= '<option value ="'+arr[i].areaID+'" >'+arr[i].areaName+'</option>)';	
   						//$("#province").html('<option value ="'+arr[i].aeaid+'" >'+arr[i].areaName+'</option>)')
   					}
   					$("#city").html(str)
   					getCounty();
   				}
   			})
		}
		
		function getCounty(){
				//得到当前的vlaue   			
   			var pid = $("#city").val();
   			$.ajax({
   				type:"post",
   				url:"servlet/CustomerServlet?method=getAreaInfo",
   				data:{"parentID":pid},
   				dataType:"text",
   				success:function(result){
 
   					//将得到的result转换成对象
   					eval("var arr="+result)
   					var str="";
   					for(i=0;i<arr.length;i++){
   						str+= '<option value ="'+arr[i].areaID+'" >'+arr[i].areaName+'</option>)';	
   						//$("#province").html('<option value ="'+arr[i].aeaid+'" >'+arr[i].areaName+'</option>)')
   					}
   					$("#county").html(str)
   				}
   			})
		}
</script> 


</head>
<body>
<article class="page-container">
	<form action="servlet/CustomerServlet?method=addCus" method="post" class="form form-horizontal" id="form-member-add">
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户姓名：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="cusName" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="cusSex" type="radio" id="sex-1" checked value="男">
					<label for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="cusSex" value="女">
					<label for="sex-2">女</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-3" name="cusSex" value="保密">
					<label for="sex-3">保密</label>
				</div>
			</div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户状态：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
				<select class="select" size="1" name="staid"  >
					<option value="0" selected>--客户状态--</option>
					<c:forEach items="${staList }" var="sta">
						<option value="${sta.staid }">${sta.staName }</option>
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
						<option value="${type.typeid }">${type.typeName }</option>
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
						<option value="${sou.souid }">${sou.souName }</option>
					</c:forEach>	
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户公司：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="cusCompany" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户职位：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="cusJob" style="width:250px">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">出生日期：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="birthday" style="width:250px" onfocus="WdatePicker()">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户地址：</label>
			
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px">
					<select class="select" size="1" name="province" id="province" onchange="getCity()"  >
						
							
					</select>
				</span> 
				<span class="select-box" style="width:150px">
					<select class="select" size="1" name="city" id="city" onchange="getCounty()"  >
						
						
						
					</select>
				</span>
				<span class="select-box" style="width:150px">
					<select class="select" size="1" name="county" id="county"  >
						
					</select>
				</span>
				</div>
			</div>
			
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户详细地址：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				
				
				<input type="text" class="input-text" value="" placeholder="" id="" name="cusAddress">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="cusPhone" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">客户座机：</label>
			
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="cusPlane" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>QQ：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="cusQQ" id="qq" style="width:250px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="@" name="email" id="" style="width:250px">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
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