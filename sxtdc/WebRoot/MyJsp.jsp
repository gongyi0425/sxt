<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello ECharts</title>

<!-- 使用单文件引入的方式使用ECharts.JS -->
<script src="echarts-all.js"></script>
<script src="jquery.js"></script>
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
<script>DD_belatedPNG.fix('*');</script>
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
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
</script> 
</head>

<body onload="loadData()">
<div id="content" style="margin:40px auto;width:1300px;height:400px">
<div id="myBarDiv" style="height: 300px; width: 400px;display:inline-block" ></div>
<div id="myLineDiv" style="height: 300px; width: 400px;display:inline-block" ></div>
<div id="myPieDiv" style="height: 300px; width: 400px;display:inline-block" ></div>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 客户中心 <span class="c-gray en">&gt;</span> 图表展示 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				
				<th width="80">序号</th>				
				<th width="300">客户回访类型</th>	
				<th width="300">客户回访描述</th>				
				<th width="100">基本操作</th>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach items="${reviewList }" var="review">
				<tr class="text-c">
					<td>${review.reviewId }</td>				
					<td>${review.reviewName }</td>	
					<td>${review.reviewDesc }</td>					
					<td class="td-manage"><a title="编辑" href="servlet/CustomerReviewServlet?method=findByIdReview&reviewId=${review.reviewId }" onclick="member_edit('编辑','customerReviewUpdate.html','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a title="删除" href="javascript:deleteReview(${review.reviewId })" onclick="member_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

<!-- <div id="myTest" style="width: 600px; height: 60px;margin:20px auto">
		<label for="name">商品名称:</label> <input type="text" id="myName">
		<label for="num">销量:</label> <input type="num" id="myNum">
		<button id="myButton" type="submit" onClick="sub()">数据更新</button>
</div> --> 







<script type="text/javascript">
	function sub(){ 
		var j = {"name":$("#myName").val(),"num":$("#myNum").val()};
		$.ajax({
	        type: 'post',
	        url: 'jso.do',
	        dataType: 'json',
	        data: {"name":$("#myName").val(),"num":$("#myNum").val()},  
	        contentType: "application/x-www-form-urlencoded" ,
	        success: function (message) {
	        	alert("success");
	        }
	       
	    });
		window.location.reload();
	}
	</script>
	
		<script type="text/javascript">
	
		function loadData(option) {
			$.ajax({
				type : 'post',	//传输类型
				async : false,	//同步执行
				url : 'bar.do',	//web.xml中注册的Servlet的url-pattern
				data : {},
				dataType : 'json', //返回数据形式为json
				success : function(result) {
					if (result) {
						//初始化xAxis[0]的data
						option.xAxis[0].data = [];
						for (var i=0; i<result.length; i++) {
							option.xAxis[0].data.push(result[i].name);
						}
						//初始化series[0]的data
						option.series[0].data = [];
						for (var i=0; i<result.length; i++) {
							option.series[0].data.push(result[i].num);
						}
					}
				},
				error : function(errorMsg) {
					alert("加载数据失败");
				}
			});//AJAX
		}//loadData()
		
		var myChart = echarts.init(document.getElementById('myBarDiv'));
		var option = {
			title: {
	            text: 'ECharts技术(柱状图)'
	        },

			tooltip : {
				show : true
			},
			legend : {
				data : [ '销量' ]
			},
			xAxis : [ {
				type : 'category'
				
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '销量',
				type : 'bar'
			} ]
		};
		//加载数据到option
		loadData(option);
		//设置option
		myChart.setOption(option);
	</script>
	
		<script type="text/javascript">
	
		function loadData(option) {
			$.ajax({
				type : 'post',	//传输类型
				async : false,	//同步执行
				url : 'bar.do',	//web.xml中注册的Servlet的url-pattern
				data : {},
				dataType : 'json', //返回数据形式为json
				success : function(result) {
					if (result) {
						//初始化xAxis[0]的data
						option.xAxis[0].data = [];
						for (var i=0; i<result.length; i++) {
							option.xAxis[0].data.push(result[i].name);
						}
						//初始化series[0]的data
						option.series[0].data = [];
						for (var i=0; i<result.length; i++) {
							option.series[0].data.push(result[i].num);
						}
					}
				},
				error : function(errorMsg) {
					alert("加载数据失败");
				}
			});//AJAX
		}//loadData()
		
		var myChart = echarts.init(document.getElementById('myLineDiv'));
		var option = {
			title: {
	            text: 'ECharts技术(折线图)'
	        },

			tooltip : {
				show : true
			},
			legend : {
				data : [ '销量' ]
			},
			xAxis : [ {
				type : 'category'
				
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '销量',
				type : 'line'
			} ]
		};
		//加载数据到option
		loadData(option);
		//设置option
		myChart.setOption(option);
	</script>
	
	
	<script type="text/javascript">
		function loadData(option) {
			
			$.ajax({
				type : 'post', //传输类型
				async : false, //同步执行
				url : 'bar.do', //web.xml中注册的Servlet的url-pattern
				data : {},
				dataType : 'json', //返回数据形式为json
				success : function(result) {
					
					if (result) {
						var myChart = echarts.init(document
								.getElementById('myPieDiv'));
						var option = {
								title: {
						            text: 'ECharts技术(饼图)'
						        },
							series : [ {
								name : '商品名称',
								type : 'pie',
								radius : '65%',
						
								
								data : [ {
									value : result[0].num,
									name : '省会1'
								}, {
									value : result[1].num,
									name : '省会2'
								}, {
									value : result[2].num,
									name : '省会3'
								}, {
									value : result[3].num,
									name : '省会4'
								}, {
									value : result[4].num,
									name : '省会5'
								}, {
									value : result[5].num,
									name : '省会6'
								} ]
							} ]
						};

						myChart.setOption(option);
					}
				},
		
				error : function(errorMsg) {
					alert("加载数据失败");
				}
			});//AJAX
		}//loadData()
	</script>
	


</body>
</html>