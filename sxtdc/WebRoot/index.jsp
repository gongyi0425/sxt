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
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/green/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>SXT-DC</title>
<meta name="keywords" content="bjsxt-dc 507_突击组">
<meta name="description" content="bjsxt-dc 507_突击组"">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl" > <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">尚学堂地产</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">客户关系管理系统</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">
				<ul class="cl">
					<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 开发中 <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 开发中</a></li>
							<li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 开发中</a></li>
							<li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 开发中</a></li>
							<li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
					</ul>
					<li class="navbar-levelone current"><a href="javascript:;">平台</a></li>
					<li class="navbar-levelone"><a href="javascript:;">个人信息</a></li>
					<li class="navbar-levelone"><a href="javascript:;">客户信息</a></li>
					<li class="navbar-levelone"><a href="javascript:;">交易信息</a></li>
				</li>
			</ul>
		</nav>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>${emp.pos.posName}</li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${emp.empName} <i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						
						<li><a  onclick="member_show('${emp.empName}','servlet/EmployeeServlet?method=findEmpInfo&empid=${emp.empid}','10001','360','400')">个人信息</a></li>
						<li><a href="servlet/EmployeeServlet?method=outLogin">切换账户</a></li>
						<li><a href="servlet/EmployeeServlet?method=outLogin">退出</a></li>
				</ul>
			</li>
				<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">



	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
		
		<dl id="menu-member">
		
		
		<c:if test="${emp.pos.posid==10 }">		
			<dt><i class="Hui-iconfont">&#xe60d;</i>&nbsp;&nbsp;客户中心<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="servlet/CustomerServlet?method=toAddCus" data-title="添加客户信息" href="javascript:;">添加客户信息</a></li>
					<li><a data-href="servlet/CustomerServlet?method=findCusByXXX" data-title="管理客户信息" href="javascript:;">管理客户信息</a></li>
					<li><a data-href="customer/customerDis.jsp" data-title="客户分布图" href="javascript:;">客户分布图</a></li>
					<li><a data-href="servlet/CustomerServlet?method=findCusByAllot" data-title="公共客户信息" href="javascript:;">公共客户信息</a></li>
					<li><a data-href="servlet/CustomerServlet?method=findCusByEmpid" data-title="我的客户信息" href="javascript:;">我的客户信息</a></li>
					
					<li><a data-href="customerCare.html" data-title="客户关怀" href="javascript:;">客户关怀</a></li>
					<li><a data-href="servlet/CustomerTypeServlet?method=findCustomerType" data-title="客户类型" href="javascript:;">客户类型</a></li>
					<li><a data-href="servlet/CustomerStatusServlet?method=findAllStatus" data-title="客户状态" href="javascript:;">客户状态</a></li>
					<li><a data-href="servlet/CustomerSourceServlet?method=findAllSource" data-title="客户来源" href="javascript:;">客户来源</a></li>
					<li><a data-href="servlet/CustomerReviewServlet?method=findAllReview" data-title="客户回访" href="javascript:;">客户回访</a></li>	
					<li><a data-href="AnalyzeReview.jsp" data-title="展示" href="javascript:;">图表展示</a></li>	
					<li><a data-href="MyJsp.jsp" data-title="展示" href="javascript:;">测试展示</a></li>	
									
				</ul>
			</dd>
		</dl>
		
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i>&nbsp;&nbsp;员工相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					<li><a data-href="servlet/HouseServlet?method=toAddHouse" data-title="添加房屋信息" href="javascript:void(0)">添加房屋信息</a></li>
					<li><a data-href="servlet/HouseServlet?method=findHouse" data-title="房屋信息管理" href="javascript:;">房屋信息管理</a></li>
					<li><a data-href="servlet/HouseServlet?method=findHouseByXXX" data-title="房屋信息" href="javascript:;">房屋信息</a></li>
					<li><a data-href="servlet/HouseTypeServlet?method=findHouseType" data-title="房屋类型" href="javascript:;">房屋类型</a></li>
					
					<li><a data-href="servlet/AnnouncementServlet?method=findIdAnn" data-title="公告" href="javascript:;">公告</a></li>
					
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i>&nbsp;&nbsp;交易管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			
			<dd>
				<ul>
					<li><a data-href="bargain/bargainAdd.jsp" data-title="添加交易单" href="javascript:void(0)">添加交易单</a></li>
					<li><a data-href="servlet/BargainServlet?method=findAllBargain" data-title="查看交易单" href="javascript:void(0)">查看交易单</a></li>
					<li><a data-href="servlet/BargainServlet?method=findBarByEmpid" data-title="我的交易单" href="javascript:void(0)">我的交易单</a></li>
			</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i>&nbsp;&nbsp;人事管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="servlet/EmployeeServlet?method=toAddEmp" data-title="添加员工" href="javascript:void(0)">添加员工</a></li>
					<li><a data-href="servlet/EmployeeServlet?method=findEmpByXXX" data-title="员工管理" href="javascript:;">员工管理</a></li>
					<li><a data-href="system/deptAdd.jsp" data-title="添加部门" href="javascript:void(0)">添加部门</a></li>
					<li><a data-href="servlet/DepartmentServlet?method=findAllDept" data-title="部门管理" href="javascript:void(0)">部门管理</a></li>
					<li><a data-href="system/posAdd.jsp" data-title="添加岗位" href="javascript:void(0)">添加岗位</a></li>
					<li><a data-href="servlet/PositionServlet?method=findAllPos" data-title="岗位管理" href="javascript:void(0)">岗位管理</a></li>
					<li><a data-href="system/annAdd.jsp" data-title="添加公告" href="javascript:void(0)">添加公告</a></li>
					<li><a data-href="servlet/AnnouncementServlet?method=findAllAnn" data-title="公告管理" href="javascript:void(0)">公告管理</a></li>
					
				</ul>
			</dd>
		</dl>				
		</c:if>
		
		
		<!--  !!!!!!!!!!!!!!!!!!! -->
		<c:if test="${emp.pos.posid==20 }">
			
			<dt><i class="Hui-iconfont">&#xe60d;</i>&nbsp;&nbsp;客户中心<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					
					<li><a data-href="servlet/CustomerServlet?method=findCusByAllot" data-title="公共客户信息" href="javascript:;">公共客户信息</a></li>
					<li><a data-href="servlet/CustomerServlet?method=findCusByEmpid" data-title="我的客户信息" href="javascript:;">我的客户信息</a></li>
					
					<li><a data-href="customerCare.html" data-title="客户关怀" href="javascript:;">客户关怀</a></li>
							
				</ul>
			</dd>
		</dl>
		
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i>&nbsp;&nbsp;员工相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>										
					<li><a data-href="servlet/HouseServlet?method=toAddHouse" data-title="添加房屋信息" href="javascript:void(0)">添加房屋信息</a></li>
					<li><a data-href="servlet/HouseServlet?method=findHouse" data-title="房屋信息管理" href="javascript:;">房屋信息管理</a></li>
					<li><a data-href="servlet/HouseServlet?method=findHouseByXXX" data-title="房屋信息" href="javascript:;">房屋信息</a></li>
					<li><a data-href="servlet/HouseTypeServlet?method=findHouseType" data-title="房屋类型" href="javascript:;">房屋类型</a></li>
	
					<li><a data-href="servlet/AnnouncementServlet?method=findIdAnn" data-title="公告" href="javascript:;">公告</a></li>
					
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i>&nbsp;&nbsp;交易管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			
			<dd>
				<ul>
					<li><a data-href="bargain/bargainAdd.jsp" data-title="添加交易单" href="javascript:void(0)">添加交易单</a></li>
					<li><a data-href="servlet/BargainServlet?method=findAllBargain" data-title="查看交易单" href="javascript:void(0)">查看交易单</a></li>
					<li><a data-href="servlet/BargainServlet?method=findBarByEmpid" data-title="我的交易单" href="javascript:void(0)">我的交易单</a></li>
			</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i>&nbsp;&nbsp;人事管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					<li><a data-href="system/annAdd.jsp" data-title="添加公告" href="javascript:void(0)">添加公告</a></li>
					<li><a data-href="servlet/AnnouncementServlet?method=findAllAnn" data-title="公告管理" href="javascript:void(0)">公告管理</a></li>
					
				</ul>
			</dd>
		</dl>

		</c:if>
		
		<!--  !!!!!!!!!!!!!!!!!!! -->
		<c:if test="${emp.pos.posid==30 }">
		
		
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i>&nbsp;&nbsp;员工相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					
					<li><a data-href="servlet/HouseServlet?method=findHouseByXXX" data-title="房屋信息" href="javascript:;">房屋信息</a></li>
					
					
					<li><a data-href="servlet/AnnouncementServlet?method=findIdAnn" data-title="公告" href="javascript:;">公告</a></li>
					
					
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i>&nbsp;&nbsp;人事管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="servlet/EmployeeServlet?method=toAddEmp" data-title="添加员工" href="javascript:void(0)">添加员工</a></li>
					<li><a data-href="servlet/EmployeeServlet?method=findEmpByXXX" data-title="员工管理" href="javascript:;">员工管理</a></li>
					<li><a data-href="system/deptAdd.jsp" data-title="添加部门" href="javascript:void(0)">添加部门</a></li>
					<li><a data-href="servlet/DepartmentServlet?method=findAllDept" data-title="部门管理" href="javascript:void(0)">部门管理</a></li>
					<li><a data-href="system/posAdd.jsp" data-title="添加岗位" href="javascript:void(0)">添加岗位</a></li>
					<li><a data-href="servlet/PositionServlet?method=findAllPos" data-title="岗位管理" href="javascript:void(0)">岗位管理</a></li>
					<li><a data-href="system/annAdd.jsp" data-title="添加公告" href="javascript:void(0)">添加公告</a></li>
					<li><a data-href="servlet/AnnouncementServlet?method=findAllAnn" data-title="公告管理" href="javascript:void(0)">公告管理</a></li>
					
				</ul>
			</dd>
		</dl>
		</c:if>
		
		<c:if test="${emp.pos.posid==40 }">
		
			<dt><i class="Hui-iconfont">&#xe60d;</i>&nbsp;&nbsp;客户中心<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="servlet/CustomerServlet?method=toAddCus" data-title="添加客户信息" href="javascript:;">添加客户信息</a></li>
					<li><a data-href="servlet/CustomerServlet?method=findCusByXXX" data-title="管理客户信息" href="javascript:;">管理客户信息</a></li>
					<li><a data-href="customer/customerDis.jsp" data-title="客户分布图" href="javascript:;">客户分布图</a></li>
					<li><a data-href="customerCare.html" data-title="客户关怀" href="javascript:;">客户关怀</a></li>
					<li><a data-href="servlet/CustomerTypeServlet?method=findCustomerType" data-title="客户类型" href="javascript:;">客户类型</a></li>
					<li><a data-href="servlet/CustomerStatusServlet?method=findAllStatus" data-title="客户状态" href="javascript:;">客户状态</a></li>
					<li><a data-href="servlet/CustomerSourceServlet?method=findAllSource" data-title="客户来源" href="javascript:;">客户来源</a></li>	
					<li><a data-href="servlet/CustomerReviewServlet?method=findAllReview" data-title="客户回访" href="javascript:;">客户回访</a></li>					
				</ul>
			</dd>
		</dl>
		
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i>&nbsp;&nbsp;员工相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
				
					<li><a data-href="servlet/AnnouncementServlet?method=findIdAnn" data-title="公告" href="javascript:;">公告</a></li>
					
					
				</ul>
			</dd>
		</dl>
		
		</c:if>
		
			
		<c:if test="${emp.pos.posid==50 }">		
			
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i>&nbsp;&nbsp;员工相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
				
					
					<li><a data-href="servlet/AnnouncementServlet?method=findIdAnn" data-title="公告" href="javascript:;">公告</a></li>
					
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i>&nbsp;&nbsp;交易管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			
			<dd>
				<ul>
					<li><a data-href="bargain/bargainAdd.jsp" data-title="添加交易单" href="javascript:void(0)">添加交易单</a></li>
					<li><a data-href="servlet/BargainServlet?method=findAllBargain" data-title="查看交易单" href="javascript:void(0)">查看交易单</a></li>
					
			</ul>
			</dd>
		</dl>
			
		</c:if>
		
		
		<c:if test="${emp.pos.posid==60 }">		
			<dt><i class="Hui-iconfont">&#xe60d;</i>&nbsp;&nbsp;客户中心<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					<li><a data-href="servlet/CustomerServlet?method=findCusByAllot" data-title="公共客户信息" href="javascript:;">公共客户信息</a></li>
					<li><a data-href="servlet/CustomerServlet?method=findCusByEmpid" data-title="我的客户信息" href="javascript:;">我的客户信息</a></li>
					
					<li><a data-href="customerCare.html" data-title="客户关怀" href="javascript:;">客户关怀</a></li>
				
				</ul>
			</dd>
		</dl>
		
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i>&nbsp;&nbsp;员工相关<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
										
					<li><a data-href="servlet/HouseServlet?method=findHouseByXXX" data-title="房屋信息" href="javascript:;">房屋信息</a></li>

					
					<li><a data-href="servlet/AnnouncementServlet?method=findIdAnn" data-title="公告" href="javascript:;">公告</a></li>
					
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i>&nbsp;&nbsp;交易管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			
			<dd>
				<ul>
					<li><a data-href="bargain/bargainAdd.jsp" data-title="添加交易单" href="javascript:void(0)">添加交易单</a></li>
					
					<li><a data-href="servlet/BargainServlet?method=findBarByEmpid" data-title="我的交易单" href="javascript:void(0)">我的交易单</a></li>
			</ul>
			</dd>
		</dl>
			
		</c:if>
		
		
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i>&nbsp;&nbsp;个人平台<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="servlet/EmployeeServlet?method=findEmpInfo&empid=${emp.empid}" data-title="我的信息" href="javascript:void(0)">我的信息</a></li>
					<li><a data-href="servlet/EmployeeServlet?method=toMyInfoUpdate" data-title="修改我的信息" href="javascript:void(0)">修改我的信息</a></li>
					<li><a data-href="myself/updatePwd.jsp" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
					
				</ul>
		</dd>
	</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i>&nbsp;&nbsp;系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
			
					<li><a data-href="servlet/LogServlet?method=findAllLog" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
				</ul>
			</dd>
		</dl>
	</div>


<!-- =================== -->




	<div class="menu_dropdown bk_2" style="display:none">
		<dl id="menu-aaaaa">
			<dt><i class="Hui-iconfont">&#xe616;</i> 二级导航1<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">三级导航</a></li>
				</ul>
			</dd>
		</dl>
	</div>

	<div class="menu_dropdown bk_2" style="display:none">
		<dl id="menu-bbbbb">
			<dt><i class="Hui-iconfont">&#xe616;</i> 二级导航2<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">三级导航</a></li>
				</ul>
			</dd>
		</dl>
	</div>

	<div class="menu_dropdown bk_2" style="display:none">
		<dl id="menu-ccccc">
			<dt><i class="Hui-iconfont">&#xe616;</i> 二级导航3<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">三级导航</a></li>
				</ul>
			</dd>
		</dl>
	</div>
     
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="首页" data-href="welcome.html">首页</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/


	$("body").Huitab({
		tabBar:".navbar-wrapper .navbar-levelone",
		tabCon:".Hui-aside .menu_dropdown",
		className:"current",
		index:0,
	});
});
/*个人信息*/
function myselfinfo(){
	layer.open({
		type: 1,
		area: ['500px','500px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: '<div>我的信息</div>'
	});
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

</script> 

<!--此乃百度统计代码，请自行删除-->
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<!--/此乃百度统计代码，请自行删除-->
</body>
</html>