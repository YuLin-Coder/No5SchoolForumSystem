<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

a:link {
	text-decoration: none;
	color: blue;
}

a:visited {
	text-decoration: none;
	color: blue;
}

a:hover {
	text-decoration: none;
	color: blue;
}

a:active {
	text-decoration: none;
	color: blue;
}

</style>

</head>
<body>

		<div style="margin-top: 20px;">
			
			<form action="${pageContext.request.contextPath }/AdUpdateServlet?op=editPostType" method="post">
			
				<input type="hidden" name="typeId" value="${ postType.postTypeId }" />
				
				<table style="float: left;">
					<tr>
						<td colspan="2" align="left">	
							<div style="margin: 10px 0px;">
								<a href="${pageContext.request.contextPath }/AdPageServlet?page=post&${ param.pageCode }"><span>&lt;返回</span> </a>
								&nbsp;|&nbsp;
								<span style="margin: 0px;padding: 0px;">添加分类</span>
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span>类型名：</span>
						</td>
						<td>
							<input type="text" name="postTypeName" value="${ postType.postType }" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<span>标题颜色：</span>
						</td>
						<td>
							<input type="text" name="titleColor" value="${ postType.color }" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="right">
							<input type="submit" value="修改">
						</td>
					</tr>
				</table>
			
			</form>
			<div style="clear: both;"></div>
			
		</div>
	

</body>



	<c:if test="${ requestScope.msg!=null }">
		<script type="text/javascript">
			alert("${requestScope.msg}");
		</script>
	</c:if>


</html>