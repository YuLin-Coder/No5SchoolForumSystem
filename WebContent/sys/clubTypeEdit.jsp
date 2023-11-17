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

	<div style="margin:0px 50px;">
		
		<div style="padding: 10px 0px; font-size: 18px;">
			<span>版块类型编辑：</span>
		</div>
		
		<div>
			<div style="border: 1px solid gray;float: left; padding: 20px;">
			
				<form action="${pageContext.request.contextPath }/AdUpdateServlet?op=clubTypeUpdate" name="clubTypeUpdateForm" method="post">
					
					<table>
						<tr>
							<td align="right">原类型名：</td>
							<td><span> ${ clubType.clubType }</span></td>				
						</tr>
						<tr>
							<td align="right">更改名称：</td>
							<td>			
								<input type="hidden" name="clubTypeId" value="${ clubType.clubTypeId }" />	
								<input type="text" name="clubTypeName" />
								<input type="submit" value="更改">
							</td>				
						</tr>
					</table>
					
				</form>
			
			</div>
			<div style="clear: both; "></div>
		</div>
		
		<div style="padding: 10px 0px; font-size: 18px;">
			<a href="${pageContext.request.contextPath }/AdPageServlet?page=club">
				<span> &lt; 返回</span>
			</a>
		</div>


	
	</div>

</body>



	<c:if test="${ requestScope.msg!=null }">
		<script type="text/javascript">
			alert("${requestScope.msg}");
		</script>
	</c:if>


</html>