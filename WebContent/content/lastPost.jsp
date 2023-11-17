<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/public/top.jsp" />


<style>
* {
	margin: 0px auto;
}
#clubName
{
}
#clubName td
{
	height:50px;
	vertical-align:bottom;
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

</style>


<script>


function mOver(obj){
	obj.style.backgroundColor="#ffffff";
}

function mOut(obj){
	obj.style.backgroundColor="#f7f7f7";
}

</script> 

<div style="width: 960px;background-color: white; padding:0px 50px;">


<div style="width: 960px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=lastPost" />'>最新帖子</a>
		</span>
	</div>
	<div style="clear: both;"></div>

</div>

	<div style=" background-color: #f7f7f7;border: 1px solid #cccccc;">
	
		<c:choose>
		
			<c:when test="${ requestScope.lastPostBean!=null and requestScope.lastPostBean.recordTotel>0 }">
			
				<c:forEach var="item" items="${ requestScope.lastPostBean.beanList }">
				
					<div id="${ item.postId }" class="postItem" onmouseover="mOver(this)" onmouseout="mOut(this)" style="margin : 0px 20px;padding: 15px 0px;">
					
						<div style="float: left;padding: 0px 10px;">
							<div style="overflow: hidden;text-overflow:ellipsis;max-width: 700px; ">
								<a href="${ pageContext.request.contextPath }/ContentServlet?op=post&postId=${ item.postId }">
									<span style="line-height: 30px; overflow: hidden;white-space:nowrap;text-overflow:ellipsis;">
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
							<div>
								<span style="color:gray; line-height: 20px;font-size: 14px; ">
								最新回复：
								<fmt:formatDate type="both" 
						            dateStyle="medium" timeStyle="medium" 
						            value="${item.lastTime}" />

								</span>
							</div>
						</div>		
								
						<div style="line-height: 50px;float: right;padding: 0px 10px;">
							<span >${ item.userName }</span>
						</div>
							
						<div style="clear: both;"></div>
					
					</div>
					<div style=" background-color: #eeeeee;border-top: 1px solid #cccccc;margin: 0px 20px;"></div>
				</c:forEach>
			
				<div>
					
					<div>
						
						<div style="float: right;margin: 20px;">
						
							<div style="float: left;  margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/ContentServlet?op=lastPost" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ lastPostBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/ContentServlet?op=lastPost&pageCode=${ lastPostBean.pageCode-1 }" />'>
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
													<a href=" <c:url value="/ContentServlet?op=lastPost&pageCode=${ i }" />">
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
													<a href=" <c:url value="/ContentServlet?op=lastPost&pageCode=${ i }" />">
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
									<a href='<c:url value="/ContentServlet?op=lastPost&pageCode=${ lastPostBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/ContentServlet?op=lastPost&pageCode=${ lastPostBean.pageNum }" />'>
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

<br>
<br>
	
</div>
<jsp:include page="/public/foot.jsp" />
	
	