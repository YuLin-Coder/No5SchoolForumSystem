<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

.table{

	padding: 5px 10px;
	background-color: #cccccc;
	width: 100px;
	text-align: center;
	margin: 5px;
	
}

.table-c table{

	border-right:1px solid gray;
	border-bottom:1px solid gray;

}


.table-c span{

	margin: 10px 20px;
	padding: 10px 20px; 

}

.table-c table td{

	border-left:1px solid gray;
	border-top:1px solid gray;
	text-align:center;
	min-width:150px;
	max-width:300px;
	height: 30px;

}

.table-c table th{
	
	border-left:1px solid gray;
	border-top:1px solid gray;
	min-width:150px;
	height: 30px;
	max-width:300px;
	text-align: center;
	
}

</style>


</head>
<body>

	<div style="margin: 10px 50px; ">
		
		<jsp:include page="public/dataTableTop.jsp"></jsp:include>
		
		<hr>
	
	</div>
	
	<div style="margin: 10px 50px; ">
	
		<div style="margin: 0px auto;">		
		
			<c:choose>
			
				<c:when test="${ param.table==null }">
					
					<div>
						<span style="line-height: 50px;font-family: 微软雅黑; font-size: 18px;">bbs_user表</span>
					</div>
					
				</c:when>
				<c:otherwise>
					
					<div style="float: left;">
						<span style="line-height: 50px;font-family: 微软雅黑; font-size: 18px;">${ param.table }表</span>
					</div>
					
					<div style="float: right;">
						<span style="line-height: 50px;font-family: 微软雅黑; font-size: 18px;">共 ${ listBean.recordTotel } 条数据</span>
					</div>
					
					<div style="clear: both;"></div>
					
				</c:otherwise>
			
			</c:choose>
			
			
		</div>
	
		<div class="table-c">
		
			<table border="0" cellspacing="0" cellpadding="0">
			
				<c:choose>
				
					<c:when test="${ param.table=='user_info' }">
						<!-- 用户信息表 -->
						<tr>
							<th>
								<span>userName</span>
							</th>
							<th>
								<span>nickname</span>
							</th>
							<th>
								<span>head</span>
							</th>
							<th>
								<span>emailAccount</span>
							</th>
							<th>
								<span>emailServerId</span>
							</th>
						</tr>
						
						<c:forEach var="info" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ info.userName } </span>
								</td>
								<td>
									<span> ${ info.nickname } </span>
								</td>
								<td>
									<span> ${ info.head } </span>
								</td>
								<td>
									<span> ${ info.emailAccount } </span>
								</td>
								<td>
									<span> ${ info.emailServerId } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
									
					<c:when test="${ param.table=='mail_server' }">
						<!-- 邮件服务器表 -->
						<tr>
							<th>
								<span>emailServerId</span>
							</th>
							<th>
								<span>domain</span>
							</th>
						</tr>
						
						<c:forEach var="mail" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ mail.emailServerId } </span>
								</td>
								<td>
									<span> ${ mail.domain } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
				
					<c:when test="${ param.table=='club' }">
						
						<!-- 版块表 -->
						<tr>
							<th>
								<span>clubName</span>
							</th>
							<th>
								<span>clubIcon</span>
							</th>
							<th>
								<span>clubDescribe</span>
							</th>
							<th>
								<span>clubTypeId</span>
							</th>
						</tr>
						
						<c:forEach var="club" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ club.clubName } </span>
								</td>
								<td>
									<span> ${ club.clubIcon } </span>
								</td>
								<td>
									<span> ${ club.clubDescribe } </span>
								</td>
								<td>
									<span> ${ club.clubTypeId } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
				
					<c:when test="${ param.table=='club_type' }">
						
						<!-- 版块表 -->
						<tr>
							<th>
								<span>clubTypeId</span>
							</th>
							<th>
								<span>clubType</span>
							</th>
						</tr>
						
						<c:forEach var="clubType" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ clubType.clubTypeId } </span>
								</td>
								<td>
									<span> ${ clubType.clubType } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
				
					<c:when test="${ param.table=='club_admin' }">
						
						<!-- 版主表 -->
						<tr>
							<th>
								<span>userName</span>
							</th>
							<th>
								<span>clubName</span>
							</th>
						</tr>
						
						<c:forEach var="admin" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ admin.userName } </span>
								</td>
								<td>
									<span> ${ admin.clubName } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
				
					<c:when test="${ param.table=='post' }">
						
						<!-- 主题帖表 -->
						<tr>
							<th>
								<span>postId</span>
							</th>
							<th>
								<span>postTitle</span>
							</th>
							<th>
								<span>postContent</span>
							</th>
							<th>
								<span>postTime</span>
							</th>
							<th>
								<span>lastTime</span>
							</th>
							<th>
								<span>userName</span>
							</th>
							<th>
								<span>clubName</span>
							</th>
							<th>
								<span>postTypeId</span>
							</th>
						</tr>
						
						<c:forEach var="post" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ post.postId } </span>
								</td>
								<td>
									<span> ${ post.postTitle } </span>
								</td>
								<td>
									<span> ${ post.postContent } </span>
								</td>
								<td>
									<span> ${ post.postTime } </span>
								</td>
								<td>
									<span> ${ post.lastTime } </span>
								</td>
								<td>
									<span> ${ post.userName } </span>
								</td>
								<td>
									<span> ${ post.clubName } </span>
								</td>
								<td>
									<span> ${ post.postTypeId } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
				
					<c:when test="${ param.table=='post_type' }">
						
						<!-- 主题帖类型表-->
						<tr>
							<th>
								<span>postTypeId</span>
							</th>
							<th>
								<span>postType</span>
							</th>
							<th>
								<span>color</span>
							</th>
						</tr>
						
						<c:forEach var="postType" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ postType.postTypeId } </span>
								</td>
								<td>
									<span> ${ postType.postType } </span>
								</td>
								<td>
									<span> ${ postType.color } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
				
					<c:when test="${ param.table=='reply' }">
						
						<!-- 回复内容表-->
						<tr>
							<th>
								<span>replyId</span>
							</th>
							<th>
								<span>replyContent</span>
							</th>
							<th>
								<span>replyTime</span>
							</th>
							<th>
								<span>postId</span>
							</th>
							<th>
								<span>userName</span>
							</th>
						</tr>
						
						<c:forEach var="reply" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ reply.replyId } </span>
								</td>
								<td>
									<span> ${ reply.replyContent } </span>
								</td>
								<td>
									<span> ${ reply.replyTime } </span>
								</td>
								<td>
									<span> ${ reply.postId } </span>
								</td>
								<td>
									<span> ${ reply.userName } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:when>
					
					<c:otherwise>
						
						<!-- 用户表 -->
						<tr>
							<th>
								<span>userName</span>
							</th>
							<th>
								<span>passwd</span>
							</th>
						</tr>
						
						<c:forEach var="user" items="${ listBean.beanList }">
							<tr>
								<td>
									<span> ${ user.userName } </span>
								</td>
								<td>
									<span> ${ user.passwd } </span>
								</td>
							</tr>
						</c:forEach>
					
					</c:otherwise>
				
				</c:choose>
							
			</table>
			
			<c:if test="${ param.table==null||param.table=='bbs_user'||param.table=='user_info'||param.table=='club_admin'||param.table=='post'||param.table=='reply' }">

				<div style="margin: 10px 0px;">
					
					<div>
						
						<div>
						
							<div style="float: left;  line-height: 30px;">
								<a href='<c:url value="/AdPageServlet?page=table&table=${ param.table }" />'>
									<span style="padding: 0px 5px;margin: 0px;">首页</span>
								</a>
							</div>
							
							<c:if test="${ listBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/AdPageServlet?page=table&table=${ param.table }&pageCode=${ listBean.pageCode-1 }" />'>
										<span style="padding: 0px 5px;margin: 0px;">上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ listBean.pageNum>7 }">
							
									<c:set var="begin" value="${ listBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ listBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>listBean.pageNum }">
										<c:set var="begin" value="${ listBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ listBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ listBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/AdPageServlet?page=table&table=${ param.table }&pageCode=${ i }" />">
														<span style="padding: 0px 5px;margin: 0px;">${ i }</span>
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
													<span style="padding: 0px 5px;margin: 0px;">${ i }</span>
												</div>
											</c:otherwise>
										
										</c:choose>
										
									</c:forEach>
									
								</c:when>
								
								<c:otherwise>
								
									<c:forEach var="i" begin="1" end="${ listBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ listBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/AdPageServlet?page=table&table=${ param.table }&pageCode=${ i }" />">
														<span style="padding: 0px 5px;margin: 0px;">${ i }</span>
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
													<span style="padding: 0px 5px;margin: 0px;">${ i }</span>
												</div>
											</c:otherwise>
										
										</c:choose>
										
									</c:forEach>
								
								</c:otherwise>
							
							</c:choose>
							
							<c:if test="${ listBean.pageCode<listBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/AdPageServlet?page=table&table=${ param.table }&pageCode=${ listBean.pageCode+1 }" />'>
										<span style="padding: 0px 5px;margin: 0px;">下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/AdPageServlet?page=table&table=${ param.table }&pageCode=${ listBean.pageNum }" />'>
									<span style="padding: 0px 5px;margin: 0px;">尾页</span>
								</a>
							</div>
							
							<div style="clear: both;"></div>
						
						</div>
						
					</div>
					
				</div>
			
			</c:if>
			
		
		</div>
	
	</div>
	
</body>
</html>