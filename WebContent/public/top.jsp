<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校园社团论坛</title>
<style>
* {
	padding: 0px;
	margin: 0px auto;
}

body{
	background: url('${pageContext.request.contextPath }/img/body.png');
}

.top_div {
	margin: 0px auto;
	width: 960px;
	padding:0px 50px;
}

.nav_text {
	line-height: 50px;
	font-family: 黑体;
	font-size: 28px;
	color: white;
}

.nav_text a:link {
	color: white;
}

.nav_text a:visited {
	color: white;
}

.nav_text a:hover {
	color: #3F48CC;
}

.nav_text a:active {
	color: #00a2e8;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}

div {
	margin: auto;
}

li {
	display: inline;
	text-align: center;
	margin-left: 10px;
	margin-right: 10px;
}
</style>


</head>

<body>
	<div style="margin:0px auto;background-color:#2f2f2f;  ">
		<div class="top_div" style="height: 130px; background-color: #2f2f2f;">
			<div style="float: left;height: 130px;">
				<img alt="logo" src="img/logo.png">
			</div>
			<div style="height: 130px;float: right; text-align: right;">
			
				<c:choose>
					
					<c:when test="${ sessionScope.user==null }">
						<div
							style="float: right;height: 30px; position: relative; top: 100%; margin-top: -30px; padding: 0px 10px; ">
							<span style="line-height: 30px;"> <a
								href="<c:url value="/ContentServlet?op=login" />">登录</a>
								| <a
								href="<c:url value="/ContentServlet?op=register" />">注册</a></span>
						</div>
					</c:when>
					<c:otherwise>
						<div style="float: right;margin: 65px 0px 0px 5px;padding:5px;">
							<img style="width: 50px; height: 50px;" alt="头像" src="img/user_head/${ sessionScope.user.userInfo.head }">
						</div>
						<div style="float: right;margin: 65px 0px 0px 5px;padding:5px; ">	
							<div>			
								<span style="line-height: 30px;font-size: 18px;  text-align: right;">
									<a href="<c:url value="/ContentServlet?op=userSetting" />">${ sessionScope.user.userInfo.nickname }</a>
								</span>
							</div>						
							<div>	
								<span style=" text-align: right;">
									<a href="${ pageContext.request.contextPath }/ContentServlet?op=loginOut">注销</a>
								</span>
							</div>		
						</div>			
						<div style="clear: both;"></div>
					</c:otherwise>
				
				</c:choose>
				
			</div> 
			<div style="clear: both;"></div>
		</div>
		
		<div style="background-color: #2f2f2f;
						 height: 50px;">
		
			<div>
				<div class="top_div" style="height: 50px; background-color: #2f2f2f;">
					<div style="float: left;">
						<ul>
							<li><span class="nav_text"><a href="${ pageContext.request.contextPath }/ContentServlet?op=home">首页</a></span></li>
							<li><span class="nav_text"><a
									href="${ pageContext.request.contextPath }/ContentServlet?op=lastPost">最新</a></span></li>
							<li><span class="nav_text"><a
									href="${ pageContext.request.contextPath }/ContentServlet?op=clubList">版块</a></span></li>
							<li><span class="nav_text"><a
									href="${ pageContext.request.contextPath }/ContentServlet?op=public">公告</a></span></li>
						</ul>
					</div>
					<div style="float: right;">
						<form action="" method="post">
							<table style="height: 50px;">
								<tr>
									<td><input type="text" value="输入搜索内容..."
										style="width: 200px; height: 30px;"></td>
									<td><input type="submit" value="搜索" height="50"
										style="width: 50px; height: 30px;"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
		
		</div>
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	