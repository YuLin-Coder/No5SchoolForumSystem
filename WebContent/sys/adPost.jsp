<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
* {
	margin: 0px auto;
}
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


<script>


function mOver(obj){
	obj.style.backgroundColor="#ffffff";
}

function mOut(obj){
	obj.style.backgroundColor="#f7f7f7";
}

</script> 

</head>
<body>

<div style="width: 1570px;" >

	<br>

	<div style=" background-color: #f7f7f7;border: 1px solid #cccccc; padding: 10px;">
		
						
		<div>
			<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px;padding: 0px;line-height: 50px;">主题帖类型管理:</span>
		</div>
		
		<div class="table" >
			
			<table  border="0" cellspacing="0" cellpadding="0" style="float: left;">
			
				<tr>
				
					<td>
						<span>分类</span>
					</td>
					<td>
						<span>标题颜色</span>
					</td>
					<td>
						<span>编辑</span>
					</td>
					<td>
						<span>删除</span>
					</td>
				
				</tr>
				
				<c:forEach var="id" items="${ lastPostBean.postTypeIdList }">
				
					<c:set var="key" value="k${ id }"></c:set>
				
					<tr>
					
						<td>
							<span>${ lastPostBean.postTypeMap[key].postType }</span>
						</td>	
					
						<td>
							<span style="color: ${ lastPostBean.postTypeMap[key].color };">${ lastPostBean.postTypeMap[key].color }</span>
						</td>	
						<td>
							<a href="${pageContext.request.contextPath }/AdPageServlet?page=postTypeEdit&typeId=${ id }&pageCode=${ lastPostBean.pageCode }"><span>编辑</span></a>

						</td>
						<td>
							<a href="${pageContext.request.contextPath }/AdUpdateServlet?op=deletePostType&typeId=${ id }"><span>删除</span></a>
						</td>
					
					</tr>
					
				
				</c:forEach>
			
			</table>
			<div style="clear: both;"></div>
		 
		</div>
		
		<div style="margin-top: 20px;">
			
			<form action="${pageContext.request.contextPath }/AdUpdateServlet?op=addPostType" method="post">
			
				<table style="float: left;">
					<tr>
						<td>	
							<div>
								<span style="margin: 0px;padding: 0px;">添加分类</span>
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span>类型名：</span>
						</td>
						<td>
							<input type="text" name="postTypeName" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<span>标题颜色：</span>
						</td>
						<td>
							<input type="text" name="titleColor" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="right">
							<input type="submit" value="添加">
						</td>
					</tr>
				</table>
			
			</form>
			<div style="clear: both;"></div>
			
		</div>
	
		
	</div>

	<br>
	
	<div style=" background-color: #f7f7f7;border: 1px solid #cccccc;">
		<div>
			<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px 10px;padding: 0px;line-height: 50px;">主题帖管理:</span>
		</div>
		<c:choose>
		
			<c:when test="${ requestScope.lastPostBean!=null and requestScope.lastPostBean.recordTotel>0 }">
			
				<c:forEach var="item" items="${ requestScope.lastPostBean.beanList }">
				
					<div id="${ item.postId }" class="postItem" onmouseover="mOver(this)" onmouseout="mOut(this)" 
						style="float:left; margin : 10px;padding: 10px 0px;border: 1px solid gray; width: 500px;">
												
						<div style="padding:0px 10px;">
						
							<div style="float: left;"> 
															
								<span style="color:gray; line-height: 20px;font-size: 14px;">
									用户：
	
								</span>
								<span style="color:gray; line-height: 20px;font-size: 14px;">
									${ item.userName }
								</span>
								<span style="margin-left:20px; color:gray; line-height: 20px;font-size: 14px;">
									版块：
	
								</span>
								<span style="color:gray; line-height: 20px;font-size: 14px;">
									${ item.clubName }
								</span>
								<span style="margin-left:20px; color:gray; line-height: 20px;font-size: 14px;">
									回复量：
	
								</span>
								<span style="color:gray; line-height: 20px;font-size: 14px;">
									${ item.replyNum }
								</span>
							</div>
							<div style="float: right;">
								<span style="color:blue; line-height: 20px;font-size: 14px;">
									<a href="${ pageContext.request.contextPath }/AdUpdateServlet?op=deletePost&postId=${ item.postId }&pageCode=${ lastPostBean.pageCode }" style="color: blue;">
										删除
									</a>
								</span>
							</div>
							<div style="clear: both;">
							</div>
						</div>
						
						<div style="padding:0px 10px;">
							<span style="color:gray; line-height: 30px;font-size: 14px; float: left; ">
								发表于：
								<fmt:formatDate type="both" 
							    	dateStyle="medium" timeStyle="medium"
							        value="${item.postTime}" />

							</span>
							<span style="color:gray; line-height: 30px;font-size: 14px;float:right; ">
								最新回复：
								<fmt:formatDate type="both" 
							    	dateStyle="medium" timeStyle="medium" 
							        value="${item.lastTime}" />

							</span>
							<div style="clear: both;"></div>
						</div>
						
						
						<div style="padding:0px 10px;">
							
							<div style="overflow: hidden;text-overflow:ellipsis;max-width: 500px; ">
								<div style="float: left;width: 50px;">
									<span style="line-height: 30px;color: gray;">
										标题：
									</span>
								</div>
								<div style="border: 1px solid gray;margin-left: 50px;padding: 0px 10px;">
									<a href="${pageContext.request.contextPath }/AdPageServlet?page=reply&postId=${ item.postId }">
										<span style="line-height: 30px; overflow: hidden;white-space:nowrap;text-overflow:ellipsis; ">
											<c:if test="${ item.postTypeId!=0 }">		
												<c:set var="key" value="k${ item.postTypeId }" />	
												<span style="color: ${ lastPostBean.postTypeMap[key].color };">
													[&nbsp;${ lastPostBean.postTypeMap[key].postType }&nbsp;]&nbsp;
												</span> 											
											</c:if>
											${ item.postTitle }
										</span>
									</a>
								</div>
								<div style="clear: both;"></div>
							</div>
							
						</div>
						
				        <div id="postContent" 
				        		style="height:150px; overflow-y: scroll;
				        				padding: 10px; 
				        				word-break:break-all; 
				        				word-wrap:break-word ;
				        				border: 1px solid gray; 
				        				margin:0px 10px; 
				        				margin-top: 10px;
				        				font-size: 14px;">
				            ${item.postContent}
				        </div>
							
						<div style="clear: both;"></div>
					
					</div>
					
				</c:forEach>
				
				<div style="clear: both;"></div>
			
				<div>
					
					<div>
						
						<div style="float: right;margin: 20px;">
						
							<div style="float: left;  margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/AdPageServlet?page=post" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ lastPostBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/AdPageServlet?page=post&pageCode=${ lastPostBean.pageCode-1 }" />'>
										<span>上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ lastPostBean.pageNum>7 }">
							
									<c:set var="begin" value="${ lastPostBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ lastPostBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>lastPostBean.pageNum }">
										<c:set var="begin" value="${ lastPostBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ lastPostBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ lastPostBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/AdPageServlet?page=post&pageCode=${ i }" />">
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
								
									<c:forEach var="i" begin="1" end="${ lastPostBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ lastPostBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/AdPageServlet?page=post&pageCode=${ i }" />">
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
							
							<c:if test="${ lastPostBean.pageCode<lastPostBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/AdPageServlet?page=post&pageCode=${ lastPostBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/AdPageServlet?page=post&pageCode=${ lastPostBean.pageNum }" />'>
									<span>尾页</span>
								</a>
							</div>
							
							<div style="clear: both;"></div>
						
						</div>
						
						<div style="clear: both;"></div>
					</div>
					
				</div>
			
			</c:when>
			
			<c:otherwise>
				<div style="padding: 20px;">
					<p>还没有任何主题帖~</p>
				</div>				
			</c:otherwise>
		
		</c:choose>
	
	</div>
	
</div>

<br>
<br>


</body>
</html>