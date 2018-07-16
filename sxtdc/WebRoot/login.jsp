<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<link href="static/mycss/mycss.css" rel="stylesheet" type="text/css" />
<style type="text/css" >
#header1{background:#426374 url("/myimg/tou.jpg") 0px 0px repeat-x;
		border-bottom:1px solid #E8E8E8;
		text-align: center;
		line-height: 60px; 
		}
#li01{ font-size: 50px; font-weight: bold; font-family: "微软雅黑";color: #fff}
#li02{ font-size: 35px; font-weight: bold; font-family: "楷体";color: #fff}

</style>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<title>sxt-dc管理系统登录</title>
<meta name="keywords" content="sxt-dc_507突击组">
<meta name="description" content="sxt-dc_507突击组">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="222222" />
<div class="header" id ="header1">
<ul>
	<li id="li01">SXT-dc</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<li id="li02">客户关系管理系统</li>
</ul>
</div>
<%
  		Cookie [] cookies = request.getCookies();
  		
		String user = "";
		String pwd = "";
		String isChecked ="";
		if(cookies != null){ 
			for(int i=0;i<cookies.length;i++){
				//cookies[i].getName()  cookies[i].getValue()
				String cname = cookies[i].getName();//uname,pwd
				if("user".equals(cname)){
					user = cookies[i].getValue();
					isChecked = "checked";
				}
				if("pwd".equals(cname)){
					pwd = cookies[i].getValue();
				}
				request.setAttribute("user", user);
				request.setAttribute("pwd", pwd);
				request.setAttribute("isChecked", isChecked);			
			}
		}
%>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="servlet/EmployeeServlet?method=login" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="user" type="text" placeholder="账户" class="input-text size-L" value="${user }">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="pwd" type="password" placeholder="密码" class="input-text size-L" value="${pwd }">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" name="yzm" type="text" placeholder="请输入验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="" style="width:150px;">
          <img src="Random.jpg?method=jpg" id="randImg" onclick="changeRandom()"> <a id="kan" href="javascript:;" onclick="changeRandom2()"></a> 
          <span style="color: #FF4040;font-family: 楷体;font-size: 25px">${ verifyCode}</span>
          </div> 
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="yes" ${isChecked }>
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer" style="text-align: center;">
	感谢SXTTV 507TV CCTV1-100 
			Copyright &copy;2018-2020 sxt-dc_502 突击组 All Rights Reserved.
			本后台系统由<a href="#" target="_blank" title="H-ui前端框架" style="color: #00E5EE;font-size: 16px">  sxt.502_突击组  </a> .提供前端技术支持</p>
</div>
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


function changeRandom(){
						
			//修改图片的地址
			$("#randImg").attr("src","Random.jpg?method=jpg&time="+new Date());
			
		} 
		function changeRandom2(){
						
			//修改图片的地址
			$("#kan").attr("href","Random.jpg?method=jpg&time="+new Date());
			
		} 
</script>
