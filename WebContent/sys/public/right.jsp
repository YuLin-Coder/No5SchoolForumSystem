<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>

<body>
	
<script language="javascript">  
	function topicReload(){  
		window.parent.frames["gggtop"].location.reload();  
		window.parent.frames["left"].location.reload();  
	}  
	//topicReload();
</script>

	<c:choose>
	
		<c:when test="${ sessionScope.adminUser==null }">
			<script language="javascript">  
				topicReload();
			</script>
			<jsp:include page="/sys/adminLogin.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<script language="javascript">  
			//alert("${requestScope.msg}+----------------");
				topicReload();
			</script>
			<center>
				<h1 style="margin: 50px;">欢迎使用吉珠联盟后台管理</h1>
			</center>
		</c:otherwise>
	
	</c:choose>
	
 
</body>


</html>