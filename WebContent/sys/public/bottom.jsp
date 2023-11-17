<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Frame bottom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
	<link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		body{
			margin: 0;
		}
		img{
			vertical-align: inherit;
			border:0;
		}
		a:link, a:hover, a:visited {
			color: #A9DCFF;
			text-decoration: none;
		}
		#StatusBar {
			 background-color: #4386B7;
			border-top: 1px solid #FFFFFF;
			height: 30px;
			width: 100%;
		}
		#StatusBar #StatusBar_Links {
			line-height30px;
			color: #A9DCFF;
			float: left;
			font-family: "宋体";
			font-size: 18px;
			padding-left: 20px;
			padding-top: 3px;
		}
		#StatusBar #StatusBar_Right a{
			color: #A9DCFF;
			float: right;
			font-family: "宋体";
			font-size: 18px;
			padding-right: 20px;
			line-height: 30px;
		}
	</style>
</head>

<body> 

<div id="StatusBar">
	<!-- 链接 -->
    <div id="StatusBar_Links">
		吉林大学珠海学院
    </div>
	<!-- 右侧功能按钮 -->
    <div id="StatusBar_Right">
		<!-- 版本 -->
		<a target="_parent" href="${ pageContext.request.contextPath }/ContentServlet?op=home">
			论坛首页
		</a>
    </div>
</div>

</body>
</html>