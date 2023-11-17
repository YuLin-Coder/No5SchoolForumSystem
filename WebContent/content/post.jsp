<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/public/top.jsp" />

<style>


.reply_content {
	color: gray;
	font-size: 18px;
	font-family: 宋体;
	width: 330px;
	height: 40px;
	line-height: 40px;
}

</style> 



<script>

function trim(s) {   
   var count = s.length;   
   var st    = 0;       // start   
   var end   = count-1; // end 
   if (s == "") return s;   
   while (st < count) {   
     if (s.charAt(st) == " ")   
       st ++;   
     else  
       break;   
   }   
   while (end > st) {   
     if (s.charAt(end) == " ")  
       end --;   
     else  
       break;   
   }   
   return s.substring(st,end + 1);   
}

function onFocus(name,id) {
	var tem=document.getElementById(id);
	tem.innerHTML="";
}

function onBlur(name,id,v) {
	var str = document.forms["send"][name].value;
    if(trim(str)==""){   
    	var tem=document.getElementById(id);      
    	tem.innerHTML=v;
    	document.forms["send"][name].value="";
    }   
}

function doPost() {
	var form=document.forms["send"];
	
	if(checkForm(form)){
		form.submit();
	}
}

function checkForm(form){
	
	var content=form["replyContent"].value;	
	if(content==""){
		alert("回复内容不能为空！");
		return false;
	}
	if(content.length>512){
		alert("内容长度超出限制！");
		return false;
	}
	
	return true;
}

function changCheck(){
	var check=document.getElementById('checkImg');
	check.src="${ pageContext.request.contextPath }/CheckServlet?check="+Math.random();
}

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
	
		<div style="float: left;width: 20px;height: 20px;padding: 0px;margin: 0px; text-align: center;">
			<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		</div>
	
	<div style="float: left;line-height: 20px;margin: 0px; text-align: center;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=clubList" />'>版块</a>
		</span>
	</div>
	
		<div style="float: left;width: 20px;height: 20px;padding: 0px;margin: 0px; text-align: center;">
			<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		</div>
		
	<div style="float: left;line-height: 20px;margin: 0px; text-align: center;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=club&clubName=${ postBean.post.clubName }" />'> ${ postBean.post.clubName } </a>
		</span>
	</div>
		
		<div style="float: left;width: 20px;height: 20px;padding: 0px;margin: 0px; text-align: center;">
			<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		</div>
	
	<div style="float: left;line-height: 20px; text-align: left;margin: 0px; width:300px; overflow: hidden;text-overflow:ellipsis; ">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray; overflow: hidden;white-space:nowrap;text-overflow:ellipsis; ">
			<a href='<c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }" />'> ${ postBean.post.postTitle } </a>
		</span>
	</div>
	<div style="clear: both;"></div>

</div>
	<div id="postContainer" style="margin:0px auto; border:solid 1px #cccccc;">
	
	    <div id="userData" style="float:left; width:200px;padding-top: 30px;" align="center">
	    
	    	<div>
	    	 	<img src="${ pageContext.request.contextPath }/img/user_head/${postBean.post.userHead}" width="100" height="100"  style="padding: 10px;border: solid 1px gray;"/>
	    	</div>
	    	<div>
	    		<a href="#">
	    			<span style="text-decoration:none;line-height: 30px;"> ${postBean.post.userName} </span>
	    		</a>
	    	</div>
	    	<div>
	    		<a href="#">
	    			<span style="text-decoration:none;line-height: 30px;"> ${postBean.post.userNickname} </span>
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
	        			<c:if test="${ postBean.post.postTypeId!=0 }">		
							<c:set var="key" value="k${ postBean.post.postTypeId }" />	
							<span style="color: ${ postBean.postTypeMap[key].color };">
								[&nbsp;${ postBean.postTypeMap[key].postType }&nbsp;]&nbsp;
							</span> 											
						</c:if>
	        			${ postBean.post.postTitle } 
	        			</span>
	        	</div>
	        	<div>
	        		<span style="font-size: 14px;color: gray;">回复：${postBean.recordTotel}</span>
	        		<span style="font-size: 14px;color: gray;padding: 0px 10px;">|</span>
	        		<span style="font-size: 14px;color: gray;">
	        			发表于：
	        			<fmt:formatDate type="both" 
						            dateStyle="medium" timeStyle="medium" 
						            value="${postBean.post.postTime}" />
	        		</span>
	        		<c:if test="${ sessionScope.user.userName==postBean.post.userName }">
	        		
		        		<span style="font-size: 14px;color: gray;padding: 0px 10px;">|</span>
						<a href="${ pageContext.request.contextPath }/FormServlet?op=delPost&clubName=${ postBean.post.clubName }&postId=${ postBean.post.postId }">
							<span style="font-size: 14px;color: gray;">删除</span>
						</a>
	        		
	        		</c:if>
	        	</div>	            
	        </div>
	        
	        <div id="postContent" style="min-height:200px;padding: 20px 0px; word-break:break-all; word-wrap:break-word ;">
	            ${postBean.post.postContent}
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
		
			<c:when test="${ postBean!=null and postBean.recordTotel>0 }">
			
				<c:forEach var="reply" items="${ postBean.beanList }">
				
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
					        					        		
					        		<c:if test="${ reply.userName==sessionScope.user.userName }">
					        		
						        		<span style="font-size: 14px;color: gray;padding: 0px 10px;">|</span>
										<a href="${ pageContext.request.contextPath }/FormServlet?op=delReply&replyId=${ reply.replyId }&postId=${ postBean.post.postId }&pageCode=${ postBean.pageCode }">
											<span style="font-size: 14px;color: gray;">删除</span>
										</a>
					        		
					        		</c:if>
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
								<a href='<c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ postBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }&pageCode=${ postBean.pageCode-1 }" />'>
										<span>上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ postBean.pageNum>7 }">
							
									<c:set var="begin" value="${ postBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ postBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>postBean.pageNum }">
										<c:set var="begin" value="${ postBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ postBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ postBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }&pageCode=${ i }" />">
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
								
									<c:forEach var="i" begin="1" end="${ postBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ postBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }&pageCode=${ i }" />">
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
							
							<c:if test="${ postBean.pageCode<postBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }&pageCode=${ postBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/ContentServlet?op=post&postId=${ postBean.post.postId }&pageCode=${ postBean.pageNum }" />'>
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
	    
	<br>

	<div style="margin:0px auto; border:solid 1px #cccccc;">
	
	    <div style="float:left; width:200px;padding-top: 30px;" align="center">
	    
	    	<c:choose>
	    	
	    		<c:when test="${ sessionScope.user!=null }">
	    	
			    	<div>
			    	 	<img src="${ pageContext.request.contextPath }/img/user_head/${ sessionScope.user.userInfo.head }" width="100" height="100"  style="padding: 10px;border: solid 1px gray;"/>
			    	</div>
			    	<div>
			    		<a href="#">
			    			<span style="text-decoration:none;line-height: 30px;">${ sessionScope.user.userName }</span>
			    		</a>
			    	</div>
			    	<div>
			    		<a href="#">
			    			<span style="text-decoration:none;line-height: 30px;">${ sessionScope.user.userInfo.nickname }</span>
			    		</a>
			    	</div>
	    		
	    		</c:when>
	    		<c:otherwise>
	    		
			    	<div>
			    	 	<img src="${ pageContext.request.contextPath }/img/user_head/head.png" width="100" height="100"  style="padding: 10px;border: solid 1px gray;"/>
			    	</div>
			    	<div>
			    		<a href="#">
			    			<span style="text-decoration:none;line-height: 30px;">游客请先登录</span>
			    		</a>
			    	</div>
	    		
	    		</c:otherwise>
	    	
	    	</c:choose>
	           
	    </div>
	    
	    <div id="bottom" 
	    	style=" border-left:solid 1px #cccccc; 
			    	margin-left:200px;
			    	padding:0px 20px;">
		<!-- ${ pageContext.request.contextPath }/FormServlet?op=addReply -->
		<form action="${ pageContext.request.contextPath }/FormServlet?op=addReply&pageCode=${ postBean.pageCode }" name="send" method="post">
		
			<input type="hidden" name="postId" value="${ postBean.post.postId }" />
		
			<div style="line-height: 50px; border-bottom:dashed 1px gray;">回复主题</div>
	        
	   		<div style="padding: 20px 20px 10px 0px;">
				<textarea rows="5" cols="" name="replyContent" style="width: 100%; padding: 10px;" ></textarea>
			</div>
			
									
			<div style="padding: 10px 0px;">	
									
				<div style="float: left;">
					<input class="reply_content" type="text" name="check"
										onfocus="onFocus('check','checktip')"
										onblur="onBlur('check','checktip','验证码')"
										style="width: 150px; padding: 0px 15px;" />
					<div style="position: relative; color: #aaaaaa">
						<div id="checktip"
								style="position: absolute; top: -40px; left: 15px; line-height: 40px;">验证码</div>
					</div>
				</div>
				
				<div style="float: left;">
					<img class="reply_content" id="checkImg" alt=""
										src="${ pageContext.request.contextPath }/CheckServlet"
										style="border: 1px solid gray; background-color: #aaaaaa; width: 100px; height: 40px; margin: 0px 9px;">
				</div>
				<div style="float: left;">
					<span class="reply_content" style="width: 60px;"><a
										href="javascript:;" onclick="changCheck();">换一换</a></span>
				</div>
				
				<div style="clear: both;"></div>
				
			</div>
			
			<div style="padding: 10px 0px 20px 0px;">
				<img style="cursor:pointer;" alt="发表帖子" src="${ pageContext.request.contextPath }/img/sendReply.png" onclick="doPost()" />
			</div>
			
		
		</form>
		
	    </div>
	    
	    <div style="clear: both;"></div>
	    
	</div>
<br>
<br>

</div>

	<c:if test="${ requestScope.msg!=null }">
		<script type="text/javascript">
			alert("${requestScope.msg}");
		</script>
	</c:if>

<jsp:include page="/public/foot.jsp" />































































