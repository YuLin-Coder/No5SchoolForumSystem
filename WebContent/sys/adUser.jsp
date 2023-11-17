<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

.namespan{
	line-height: 30px;
	color:#555555;
	padding: 0px 5px;
}
.post_content {
	color: gray;
	font-size: 18px;
	font-family: 宋体;
	width: 330px;
	height: 40px;
	line-height: 40px;
}

.table table{

	border-right:1px solid gray;
	border-bottom:1px solid gray;

}


.table span{

	margin: 10px 20px;
	padding: 10px 20px; 

}

.table table td{

	border-left:1px solid gray;
	border-top:1px solid gray;
	text-align:center;
	min-width:150px;
	max-width:300px;
	height: 30px;

}

.table table th{
	
	border-left:1px solid gray;
	border-top:1px solid gray;
	min-width:150px;
	height: 30px;
	max-width:300px;
	text-align: center;
	
}

.postItem a:link {
	text-decoration: none;
	color: black;
}

.postItem a:visited {
	text-decoration: none;
	color: black;
}

.postItem a:hover {
	text-decoration: none;
	color: black;
}

.postItem a:active {
	text-decoration: none;
	color: black;
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


</style>

</head>
<body>

<div style="margin: 20px;">

	<div>
		<span style="font-family: 微软雅黑;font-size: 24px;padding: 0px;margin: 0px;line-height: 50px;">用户列表：</span>
	</div>
	
	<div class="table" >
						
		<table  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<span>用户头像</span>	
				</td>
				<td>
					<span>用户名</span>	
				</td>
				<td>
					<span>用户昵称</span>	
				</td>
				<td>
					<span>用户密码</span>	
				</td>
				<td>
					<span>注册邮箱</span>	
				</td>
				<td>
					<span>管理</span>	
				</td>
				<td>
					<span>删除</span>	
				</td>
			</tr>
			
			<c:forEach var="user" items="${ adUserBean.beanList }">
				<c:set var="key" value="k${ user.userInfo.emailServerId }" />
				<tr>
					<td>
					
						<div style=" margin: 0px auto;">
							<div style="width: 80px;;height: 80px; border: 1px solid gray; margin: 10px auto;">
								<img alt="头像" src="${ pageContext.request.contextPath }/img/user_head/${ user.userInfo.head }" 
										style="max-height: 80px;max-width: 80px;
								 		height: 80px;width: 80px;
									"/>	
							</div>
						</div>
						
					</td>
					<td>
						<div><span>${ user.userName }</span>	</div>
						
					</td>
					<td>
						<div><span>${ user.userInfo.nickname }</span>	</div>
						
					</td>
					<td>
						<div><span>${ user.passwd }</span>	</div>
						
					</td>
					<td>
						<div>
							<span>${ user.userInfo.emailAccount }@${ adUserBean.mailServerMap[key].domain }</span>	
						</div>
						
					</td>
					<td>
						<div><a href="${pageContext.request.contextPath }/AdPageServlet?page=editUser&userName=${ user.userName }"><span>编辑</span></a></div>
						
					</td>
					<td>
						<div><a href="${pageContext.request.contextPath }/AdUpdateServlet?op=deleteUser&userName=${ user.userName }"><span>删除</span></a></div>
						
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

				
	<div>
		
		<div>
			
			<div style="float: left;margin: 20px;">
			
				<div style="float: left;  margin:0px 5px; line-height: 30px;">
					<a href='<c:url value="/AdPageServlet?page=user" />'>
						<span>首页</span>
					</a>
				</div>
				
				<c:if test="${ adUserBean.pageCode>1 }">
					<div style="float: left; margin:0px 5px; line-height: 30px;">
						<a href='<c:url value="/AdPageServlet?page=user&pageCode=${ adUserBean.pageCode-1 }" />'>
							<span>上一页</span>
						</a>
					</div>						
				</c:if>
				
				<c:choose>
				
					<c:when test="${ adUserBean.pageNum>7 }">
							
						<c:set var="begin" value="${ adUserBean.pageCode-3 }"></c:set>
						<c:set var="end" value="${ adUserBean.pageCode+3 }"></c:set>
						<c:if test="${ begin<1 }">
							<c:set var="begin" value="${ 1 }"></c:set>
							<c:set var="end" value="${ 7 }"></c:set>
						</c:if>
						<c:if test="${ end>adUserBean.pageNum }">
							<c:set var="begin" value="${ adUserBean.pageNum-6 }"></c:set>
							<c:set var="end" value="${ adUserBean.pageNum }"></c:set>
						</c:if>
						
						<c:forEach var="i" begin="${ begin }" end="${ end }">
									
							<c:choose>
										
								<c:when test="${ adUserBean.pageCode!=i }">
									<div style="float: left; 
												margin:0px 5px;
												width: 30px; 
												line-height: 30px;
												text-align: center;
												border: solid 1px #cccccc;">
										<a href=" <c:url value="/AdPageServlet?page=user&pageCode=${ i }" />">
											<span>${ i }</span>
										</a>
									</div>
								</c:when>
								<c:otherwise>
									<div style="float: left; 
												margin:0px 5px;
												width: 30px; 
												line-height: 30px;
												text-align: center;
												background-color:#11B7EF;
												border: solid 1px #11B7EF;">
										<span>${ i }</span>
									</div>
								</c:otherwise>
							
							</c:choose>
							
						</c:forEach>
									
					</c:when>
							
					<c:otherwise>
								
						<c:forEach var="i" begin="1" end="${ adUserBean.pageNum }">
										
							<c:choose>
										
								<c:when test="${ adUserBean.pageCode!=i }">
									<div style="float: left; 
												margin:0px 5px;
												width: 30px; 
												line-height: 30px;
												text-align: center;
												border: solid 1px #cccccc;">
										<a href=" <c:url value="/AdPageServlet?page=user&pageCode=${ i }" />">
											<span>${ i }</span>
										</a>
									</div>
								</c:when>
								<c:otherwise>
									<div style="float: left; 
												margin:0px 5px;
												width: 30px; 
												line-height: 30px;
												text-align: center;
												background-color:#11B7EF;
												border: solid 1px #11B7EF;">
										<span>${ i }</span>
									</div>
								</c:otherwise>
							
							</c:choose>
										
						</c:forEach>
								
					</c:otherwise>
					
				</c:choose>
							
				<c:if test="${ adUserBean.pageCode<adUserBean.pageNum }">
					<div style="float: left; margin:0px 5px; line-height: 30px;">
						<a href='<c:url value="/AdPageServlet?page=user&pageCode=${ adUserBean.pageCode+1 }" />'>
							<span>下一页</span>
						</a>
					</div>						
				</c:if>
							
				<div style="float: left; margin:0px 5px; line-height: 30px;">
					<a href='<c:url value="/AdPageServlet?page=user&pageCode=${ adUserBean.pageNum }" />'>
						<span>尾页</span>
					</a>
				</div>
							
				<div style="clear: both;"></div>
						
			</div>
						
			<div style="clear: both;"></div>
		</div>
					
	</div>
			

</div>

<c:if test="${ requestScope.msg!=null }">
	<script>
		alert("${requestScope.msg}");
	</script> 
</c:if>
</body>
</html>