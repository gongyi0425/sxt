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
</head>


<body onload="loadData(),loadData1()"><!--页面加载的时候执行-->

<div id="myPieDiv" style="height: 300px; width: 400px;display:inline-block" ></div>
<div id="attentionPieDiv" style="height: 300px; width: 400px;display:inline-block" ></div>
	
<script type="text/javascript">
	function loadData(option) {
		$.ajax({
			type : 'post', //传输类型
			async : false, //同步执行
			url : 'ana.do', //web.xml中注册的Servlet的url-pattern
			data : {},
			dataType : 'json', //返回数据形式为json
			success : function(result) {
				
				if (result) {
					var myChart = echarts.init(document
							.getElementById('myPieDiv'));
					var option = {
							title: {
					            text: '客户回访'
					        },
					        tooltip:{
					        	trigger: 'item',
					        	bottom:10,
      							    formatter: "{a} <br/>{b} : {c} ({d}%)"
					        },
						series : [ {
							name : '商品名称',
							type : 'pie',
							radius : '65%',
							center:['50%','60%'],
							selectedMode: 'single',//单击进行偏移
					        selectedOffset: 10,//饼图单击偏移量
					        clockwise: true,
							itemStyle: {
								normal: {
					                borderWidth: 2,
					                borderColor: '#ffffff',
					            },
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
			           	    },
							data:(function(){
		                    var res = [];
		                    var len = result.length;
		                        for(var i=0,size=len;i<size;i++) {
		                         res.push({
		                             //通过把result进行遍历循环来获取数据并放入Echarts中
		                             name: result[i].ReviewName,
		                             value: result[i].ReviewNum
		                         });
		                        }
		                        return res;
		               		 })()			
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

<script type="text/javascript">

	function loadData1(option) {
		$.ajax({
			type : 'post', //传输类型
			async : false, //同步执行
			url : 'att.do', //web.xml中注册的Servlet的url-pattern
			data : {},
			dataType : 'json', //返回数据形式为json
			success : function(result) {
				
				if (result) {
					var myChart = echarts.init(document
							.getElementById('attentionPieDiv'));
					var option = {
							title: {
					            text: '客户痛点'
					        },
					        tooltip:{
					        	trigger: 'item',
					        	bottom:10,
      							    formatter: "{a} <br/>{b} : {c} ({d}%)"
					        },
						series : [ {
							name : '商品名称',
							type : 'pie',
							radius : '65%',
							center:['50%','60%'],
							selectedMode: 'single',//单击进行偏移
					        selectedOffset: 10,//饼图单击偏移量
					        clockwise: true,
							itemStyle: {
								normal: {
					                borderWidth: 2,
					                borderColor: '#ffffff',
					            },
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
			           	    },
							data:(function(){
		                    var res = [];
		                    var len = result.length;
		                        for(var i=0,size=len;i<size;i++) {
		                         res.push({
		                             //通过把result进行遍历循环来获取数据并放入Echarts中
		                             name: result[i].AttentionName,
		                             value: result[i].AttentionNum
		                         });
		                        }
		                        return res;
		               		 })()			
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