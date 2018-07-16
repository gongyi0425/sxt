<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
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
<title>首页</title>
</head>
<body>
<%
	Date now = new Date();
 %>
<div class="page-container">
	<p class="f-20 text-success radius" >sxt <span class="f-14">-dc&nbsp;&nbsp;&nbsp;</span>客户关系管理系统！</p>

<!-- <%=application.getAttribute("count") %> -->
	<p>当前用户访问次数：<span style="color: #33CCCC "> ${emp.empcount }  </span> 次</p>
	<p>网站总浏览量：<span style="color: #33CCCC "><%=application.getAttribute("count") %>  </span> 次</p>
	<p>当前用户IP:<span style="color: #33CCCC "> http:// ${Log.cip }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本次登录时间：<span style="color: #33CCCC "> <%=now.toLocaleString() %></span></p>

	<table class="table table-border table-bordered table-bg">
		
	</table>
</div>
<footer class="footer mt-20">
	<div class="container">
		<p>感谢SXTTV 502TV CCTV1-100 <br>
			Copyright &copy;2018-2020 sxt-dc_502 突击组 All Rights Reserved.<br>
			本后台系统由<a href="#" target="_blank" title="H-ui前端框架">sxt.502_突击组.  </a>提供前端技术支持</p>
	</div>
</footer>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
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