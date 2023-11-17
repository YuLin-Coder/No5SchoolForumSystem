<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

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

<div style="max-width: 960px; margin: 0px auto;">

	<div id="postContainer" style="margin:0px auto; border:solid 1px #cccccc;">
	
	    <div id="userData" style="float:left; width:200px;padding-top: 30px;" align="center">
	    
	    	<div>
	    	 	<img src="${ pageContext.request.contextPath }/img/user_head/${adReplyBean.post.userHead}" width="100" height="100"  style="padding: 10px;border: solid 1px gray;"/>
	    	</div>
	    	<div>
	    		<a href="#">
	    			<span style="text-decoration:none;line-height: 30px;"> ${adReplyBean.post.userName} </span>
	    		</a>
	    	</div>
	    	<div>
	    		<a href="#">
	    			<span style="text-decoration:none;line-height: 30px;"> ${adReplyBean.post.userNickname} </span>
	    		</a>
	    	</div>
	    
	    </div>
	    
	    <div id="bottom" 
	    	style=" border-left:solid 1px #cccccc; 
			    	margin-left:200px;
			    	padding:0px 20px;">

	        <div id="postTitle" style="border-bottom:dashed 1px gray;padding: 10px 0px;">
	        	<div>
	        		<span style="font-size: 18px;"> 
	        			<c:if test="${ adReplyBean.post.postTypeId!=0 }">		
							<span style="color: ${ adReplyBean.postType.color };">
								[&nbsp;${ adReplyBean.postType.postType }&nbsp;]&nbsp;
							</span> 											
						</c:if>
	        			${ adReplyBean.post.postTitle } 
	        			</span>
	        	</div>
	        	<div>
	        		<span style="font-size: 14px;color: gray;">回复：${adReplyBean.recordTotel}</span>
	        		<span style="font-size: 14px;color: gray;padding: 0px 10px;">|</span>
	        		<span style="font-size: 14px;color: gray;">
	        			发表于：
	        			<fmt:formatDate type="both" 
						            dateStyle="medium" timeStyle="medium" 
						            value="${postBean.post.postTime}" />
	        		</span>
		        	<span style="font-size: 14px;color: gray;padding: 0px 10px;">&nbsp;|&nbsp;</span>
					<a href="${ pageContext.request.contextPath }/AdUpdateServlet?op=deletePost&postId=${ adReplyBean.post.postId }&pageCode=${ adReplyBean.pageCode }">
							<span style="font-size: 14px;color: gray;">删除</span>
					</a>
	        	</div>	            
	        </div>
	        
	        <div id="postContent" style="min-height:200px;padding: 20px 0px; word-break:break-all; word-wrap:break-word ;">
	            ${adReplyBean.post.postContent}
	        </div>
	        
	        <div id="postFooter" style="border-top:dashed 1px gray;line-height: 50px;">
	        	
	        	<div style="float: right;">
	        		<span>
	        			<a href="#" style="text-decoration:none;">举报</a>
	        		</span> 
	        	</div>
	    		<div style="clear: both;"></div>
	            
	        </div>
	        
	    </div>
	    
	    <div style="clear: both;"></div>
	    
	</div>
	    
	<br>
	

	<div style="border: 1px solid #cccccc; ">
	
		<c:choose>
		
			<c:when test="${ adReplyBean!=null and adReplyBean.recordTotel>0 }">
			
				<c:forEach var="reply" items="${ adReplyBean.beanList }">
				
					<div style="border-bottom : 1px solid #cccccc; ">
					
					    <div id="userData" style="float:left; width:200px;padding-top: 30px;" align="center">
					    
					    	<div>
					    	 	<img src="${ pageContext.request.contextPath }/img/user_head/${ reply.userHead }" width="100" height="100"  style="padding: 10px;border: solid 1px gray;"/>
					    	</div>
					    	<div>
					    		<a href="#">
					    			<span style="text-decoration:none;line-height: 30px;"> ${ reply.userName } </span>
					    		</a>
					    	</div>
					    	<div>
					    		<a href="#">
					    			<span style="text-decoration:none;line-height: 30px;"> ${ reply.userNickname } </span>
					    		</a>
					    	</div>
					           
					    </div>
					    
					    
						    
					    <div  style=" border-left:solid 1px #cccccc; 
							    	margin-left:200px;
							    	padding:0px 20px;">
				
					        <div style="border-bottom:dashed 1px gray;padding: 10px 0px;">
					        	<div>
					        		<span style="font-size: 14px;color: gray;">发表于：${ reply.replyTime }</span>
					        				        		
						        	<span style="font-size: 14px;color: gray;padding: 0px 10px;">|</span>
									<a href="${ pageContext.request.contextPath }/AdUpdateServlet?op=deleteReply&postId=${ reply.postId }&replyId=${ reply.replyId }&pageCode=${ adReplyBean.pageCode }">
										<span style="font-size: 14px;color: gray;">删除</span>
									</a>
					     
					        	</div>	            
					        </div>
					        
					        <div style="min-height:200px;padding: 20px 0px;">
					            ${ reply.replyContent }
					        </div>
					        
					        <div  style="border-top:dashed 1px gray;line-height: 50px;">
					        	
					        	<div style="float: right;">
					        		<span>
					        			<a href="#" style="text-decoration:none;">举报</a>
					        		</span> 
					        	</div>
					    		<div style="clear: both;"></div>
					            
					        </div>
					        
					    </div>
	    				
	    				<div style="clear: both;"></div>
					
					</div>
				
				</c:forEach>			
				
				<div>					
					
					<div>
						
						<div style="float: right;margin: 20px;">
						
							<div style="float: left;  margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/AdPageServlet?page=reply&postId=${ adReplyBean.post.postId }" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ adReplyBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/AdPageServlet?page=reply&postId=${ adReplyBean.post.postId }&pageCode=${ adReplyBean.pageCode-1 }" />'>
										<span>上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ adReplyBean.pageNum>7 }">
							
									<c:set var="begin" value="${ adReplyBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ adReplyBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>adReplyBean.pageNum }">
										<c:set var="begin" value="${ adReplyBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ adReplyBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ adReplyBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/AdPageServlet?page=reply&postId=${ adReplyBean.post.postId }&pageCode=${ i }" />">
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
								
									<c:forEach var="i" begin="1" end="${ adReplyBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ adReplyBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/AdPageServlet?page=reply&postId=${ adReplyBean.post.postId }&pageCode=${ i }" />">
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
							
							<c:if test="${ adReplyBean.pageCode<adReplyBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/AdPageServlet?page=reply&postId=${ adReplyBean.post.postId }&pageCode=${ adReplyBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/AdPageServlet?page=reply&postId=${ adReplyBean.post.postId }&pageCode=${ adReplyBean.pageNum }" />'>
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
			
				<div style="padding: 10px;margin: 0px auto;text-align: center;">
				
					<p>暂无回复~</p>
				
				</div>
			
			</c:otherwise>
		
		</c:choose>
		
	</div>
	
</div>

</body>
</html>