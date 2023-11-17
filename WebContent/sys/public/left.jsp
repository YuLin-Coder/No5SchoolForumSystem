<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Frame left</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
    <link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		// 显示或隐藏二级菜单 
		function menuClick( menuDiv ){
			$(".MenuLevel2").not( $(menuDiv).next() ).hide();
			$(menuDiv).next().toggle();
		}
		
		$(function(){
			// 默认只显示第1个二级菜单
			$(".MenuLevel2").hide();
			$(".MenuLevel2:first").show();
		});
	</script>
	<!-- 内容总宽度为 3px边框 * 2 + 155px内容 = 161px; -->
	<style type="text/css">
<!--
html{
height: 100%;
}
body {
	background: none repeat scroll 0 0 #D8EDFC;
	margin: 0;
	padding: 0;
}
#Menu {
    margin: 0;
    padding: 0;
    width: 155px;
	background: none repeat scroll 0 0 #D8EBF7;
    list-style: none outside none;
	
	margin-left: 3px;
	border-top: 3px solid #4891C6;
}
#Menu .level1 {
 color: #005790;
    font-weight: bold;
    padding-bottom: 1px;
	  cursor: pointer;
}
#Menu .level1 .level1Style {
    height: 50px;
    padding-left: 10px;
    padding-top: 5px;
    width: 135px;
    line-height:50px;
	margin-bottom: -4px;
	font-size: 16px;
}
#Menu .level1 .level1Style .Icon {
	margin-top: -2px;
}
#Menu .level1 .MenuLevel2 {
 background: none repeat scroll 0 0 #D8EBF7;
    list-style: none outside none;
    margin: 0;
    padding: 0;
}
#Menu .level1 .MenuLevel2 .level2Style{
	color: #005790;
    font-weight: normal;
	border-top: 1px solid #EFF6FB;
	height: 30px;
	padding-left: 30px;
	width: 120px;
	line-height:30px;
}
-->
	</style>
</head>
<body>
	
    <ul id="Menu">
	    <li class="level1">
            <div onClick="menuClick(this);" class="level1Style">
				<img src="${pageContext.request.contextPath }/sys/style/images/func20001.gif" class="Icon" /> 
				系统
			</div>
			
			<c:if test="${ sessionScope.adminUser!=null }">				
				
	            <ul class="MenuLevel2">
	            
	            	<li class="level2 level2Style">
	            		<div>
	            			<div style="float: left;height: 14px;padding: 8px 5px;">            				
								<img style="width: 14px;height: 14px;" src="${pageContext.request.contextPath }/sys/style/images/img/menu_arrow_single.gif"/> 
	            			</div>
	            			<div style="float: left;">
	                    		<a target="right" style="font-size: 16px;" href="${pageContext.request.contextPath }/AdPageServlet?page=user">用户</a>
	            			</div>
	            			<div style="float: left;"></div>
	            		</div>
					</li>
	            
	            	<li class="level2 level2Style">
	            		<div>
	            			<div style="float: left;height: 14px;padding: 8px 5px;">            				
								<img style="width: 14px;height: 14px;" src="${pageContext.request.contextPath }/sys/style/images/img/menu_arrow_single.gif"/> 
	            			</div>
	            			<div style="float: left;">
	                    		<a target="right" style="font-size: 16px;" href="${pageContext.request.contextPath }/AdPageServlet?page=club">版块</a>
	            			</div>
	            			<div style="float: left;"></div>
	            		</div>
					</li>
	            
	            	<li class="level2 level2Style">
	            		<div>
	            			<div style="float: left;height: 14px;padding: 8px 5px;">            				
								<img style="width: 14px;height: 14px;" src="${pageContext.request.contextPath }/sys/style/images/img/menu_arrow_single.gif"/> 
	            			</div>
	            			<div style="float: left;">
	                    		<a target="right" style="font-size: 16px;" href="${pageContext.request.contextPath }/AdPageServlet?page=post">主题帖</a>
	            			</div>
	            			<div style="float: left;"></div>
	            		</div>
					</li>
					
	            	<li class="level2 level2Style">
	            		<div>
	            			<div style="float: left;height: 14px;padding: 8px 5px;">            				
								<img style="width: 14px;height: 14px;" src="${pageContext.request.contextPath }/sys/style/images/img/menu_arrow_single.gif"/> 
	            			</div>
	            			<div style="float: left;">
	                    		<a target="right" style="font-size: 16px;" href="${pageContext.request.contextPath }/AdPageServlet?page=table">数据表</a>
	            			</div>
	            			<div style="float: left;"></div>
	            		</div>
					</li>
	
	            </ul>
			
			</c:if>
			
        </li>
    </ul>
</body>

</html>
