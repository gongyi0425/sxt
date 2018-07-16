<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>"/>
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
<title>房屋信息</title>
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
		  {"orderable":false,"aTargets":[0,9]}// 制定列不参与排序
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
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function deleteHouse(houseid){
	layer.confirm("确认要删除该房屋信息吗？", { title: "删除确认" }, function (index) {  
          layer.close(index);  
          $.post("servlet/HouseServlet?method=deleteHou", { houseid:houseid }, function (data) { 
                   
              layer.alert(data, {  
                 title: "删除房屋信息",  
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
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 员工相关 <span class="c-gray en">&gt;</span> 房屋信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 
		<form action="servlet/HouseServlet?method=findHouse" method="post">
			按房屋地址查询&nbsp;&nbsp;<input type="text" class="input-text" style="width:200px" placeholder="按房屋地址查询" id="" name="location" value="${location }" onclick="JavaScript:this.value=''"/>&nbsp;&nbsp;&nbsp;&nbsp;
			按户型查询&nbsp;&nbsp;
				 <span class="select-box" style="width:120px">
					<select class="select" size="1" name="typeid"  >
						<option value="0" selected>--全部--</option>
						<c:forEach items="${houseTypeList}" var="houseType">
							<c:if test="${typeid == houseType.typeid }">
								<option value="${houseType.typeid }" selected="selected">${houseType.typeName }</option>
							</c:if>
							<c:if test="${typeid != houseType.typeid }">
								<option value="${houseType.typeid }">${houseType.typeName }</option>
							</c:if>
						</c:forEach>
					</select>
				</span> &nbsp;&nbsp;&nbsp;&nbsp;
			按交易状态查询&nbsp;&nbsp;<input type="text" class="input-text" style="width:200px" placeholder="按交易状态查询" id="" name="housestate" value="${housestate }" onclick="JavaScript:this.value=''"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
			<input type="button" class="btn btn-primary radius" value="清空"> 
		</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	<span class="r"><strong></strong> </span>
	</div>
		
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="60">房屋编号</th>
				<th width="200">房屋地址</th>
				<th width="70">户型</th>
				<th width="70">面积<span class="c-red">（M²）</span></th>
				<th width="70">价格<span class="c-red">（/M²）</span></th>
				<th width="80">总价<span class="c-red">（￥）</th>
				<th width="50">状态</th>
				<th width="140">房屋环境</th>
				
				<th width="70">基本操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${houseList }" var="house">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${house.houseid }</td>
					<td>${house.location }</td>
					<td>${house.type.typeName }</td>
					<td>${house.area }</td>	
					<td >${house.price }</td>
					<td >${house.totalPrice }</td>
					<td>${house.housestate }</td>
					<td >${house.ambient }</td>
					
					
					<td class="td-manage"> 
					
					<a title="查看" href="javascript:;" onclick="member_edit('查看','house/houseImgShow.jsp?houseid=${house.houseid}','4','','510')" class="ml-5" style="text-decoration:none"><span class="label label-success radius">查看房屋图片</span></a> 		
					<a title="编辑" href="servlet/HouseServlet?method=findHouseById&houseid=${house.houseid}" onclick="member_edit('编辑','','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
					<a title="删除" href="javascript:;" onclick="deleteHouse('${house.houseid}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

</div>

</body>
</html>
