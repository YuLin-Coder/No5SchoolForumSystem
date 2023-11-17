<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	var title=form["title"].value;
	if(title==""){
		alert("标题不能为空！");
		return false;
	}
	if(title.length>80){
		alert("标题长度超出限制！");
		return false;
	}
	
	var content=form["content"].value;	
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
<c:set var="isAdmin" value="${ false }"></c:set>

<div style="width: 960px;background-color: white; padding:0px 50px;">
	

<div style="width: 960px; margin: 0px auto; padding:20px 0px; background-color: white;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;padding-right:5px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=clubList" />'>版块</a>
		</span>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px; font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }" />'> ${ clubBean.club.clubName } </a>
		</span>
	</div>
	<div style="clear: both;"></div>

</div>
	
	<div style="min-height: 260px; background-color:#f7f7f7; border: 1px solid gray; padding: 20px; margin: 0px;">	
	
		<div style="margin: 0px;"> 
			<div style="float: left;">
				<table id="clubName" style="margin: 0px;">				
					<tr>				
						<td>
							<span style="font-size: 36px; font-weight:bold; color: #000000; padding-right: 5px;">${ clubBean.club.clubName }</span>
						</td>
						<td>
							<span class="namespan">|</span>
						</td>
						<td>
							<span class="namespan">主题：${ clubBean.club.postNum }</span>
						</td>
						<td>
							<span class="namespan">|</span>
						</td>
						<td>
							<span class="namespan">回复：${ clubBean.club.replyNum }</span>
						</td>				
					</tr>			
				</table>
			</div>
			<div style="float: right;">
				<c:forEach var="admin" varStatus="s" items="${ clubBean.clubAdminList }">
					<c:if test="${ admin.userName==sessionScope.user.userName }">						
						<c:set var="isAdmin" value="${ true }"></c:set>
						<span style="font-size: 18px;margin: 0px 20px;">
							<a href=" <c:url value="/ContentServlet?op=clubEdit&clubName=${ clubBean.club.clubName }" /> ">编辑</a>
						</span>
					</c:if>
				</c:forEach>

			</div>
			<div style="clear: both;"></div>
		</div>	
		
		<div style="margin: 0px; "> 
			<table id="clubadmin" style="margin: 0px; line-height: 50px;">				
				<tr>				
					<td>
						<span style="padding: 0px 5px;">版主：
							<c:forEach var="admin" varStatus="s" items="${ clubBean.clubAdminList }">
								<c:if test="${ s.count!=1 }">
									<span style="color: gray;">|</span>
								</c:if>
								<a href="#"> ${ admin.userName } </a>
							</c:forEach>
						</span>
					</td>			
				</tr>			
			</table>
		</div>
		
		<div style="margin:0px;padding: 5px;">
			<p style="font-size: 14px;line-height: 30px;" >${ clubBean.club.clubDescribe }</p>
		</div>
	
	</div>
	
	<br>
	
	<div style=" background-color: #f7f7f7;border: 1px solid #cccccc;"> 
	
		<c:choose>
		
			<c:when test="${ requestScope.clubBean!=null and requestScope.clubBean.recordTotel>0 }">
			
				<c:forEach var="item" items="${ requestScope.clubBean.beanList }">
				
					<div id="${ item.postId }" class="postItem" onmouseover="mOver(this)" onmouseout="mOut(this)" style="margin : 0px 20px;padding: 15px 0px;">
					
						<div style="padding: 0px 10px;line-height: 30px;">
							<div style=" float: left;overflow: hidden;text-overflow:ellipsis;max-width: 700px; ">
								<a href='<c:url value="/ContentServlet?op=post&postId=${ item.postId }" />'>
									<span style="line-height: 30px; overflow: hidden;white-space:nowrap;text-overflow:ellipsis; font-size: 18px;">
										<c:if test="${ item.postTypeId!=0 }">		
											<c:set var="key" value="k${ item.postTypeId }" />	
											<span style="color: ${ clubBean.postTypeMap[key].color };">
												[&nbsp;${ clubBean.postTypeMap[key].postType }&nbsp;]&nbsp;
											</span> 											
										</c:if>
										${ item.postTitle }
									</span>
								</a>
							</div>
							<div style="text-align: right;">
								<span style="line-height: 30px;">${ item.userName }</span>
							</div>
							<div style="clear: both;"></div>
						</div>
						
						<div style="padding: 0px 10px;line-height: 20px;">
							<div style="float: left;">
								<span style="color:gray; line-height: 20px;font-size: 14px; ">
									发表于
									<fmt:formatDate type="both" 
								           dateStyle="medium" timeStyle="medium" 
								           value="${item.postTime}" />
								</span>
							</div>
							<c:choose>
							
								<c:when test="${ (sessionScope.user!=null and item.userName==sessionScope.user.userName)||isAdmin==true }">
									<div>
										<div style="float: right;text-align: right;">
											<span style="color:gray; line-height: 20px;font-size: 14px;">
												最后回复： ${ item.lastTime } &nbsp;|&nbsp;
											</span>
											<a href="${ pageContext.request.contextPath }/FormServlet?op=delPost&clubName=${ clubBean.club.clubName }&postId=${ item.postId }&pageCode=${ clubBean.pageCode }">
												<span style="color:gray; line-height: 20px;font-size: 14px;">删除</span>
											</a>
										</div>
									</div>					
								</c:when>
								
								<c:otherwise>	
									<div>
										<div style="float: right;text-align: right;">
											<span style="color:gray; line-height: 20px;font-size: 14px;">
												最后回复： ${ item.lastTime }
											</span>
										</div>
									</div>	
								</c:otherwise>
							
							</c:choose>
							<div style="clear: both;"></div>
						
						</div>
							
					
					</div>
					<div style=" background-color: #eeeeee;border-top: 1px solid #cccccc;margin: 0px 20px;"></div>
				</c:forEach>
			
				
				<div>
					
					
					<div>
						
						<div style="float: right;margin: 20px;">
						
							<div style="float: left;  margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ clubBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }&pageCode=${ clubBean.pageCode-1 }" />'>
										<span>上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ clubBean.pageNum>7 }">
							
									<c:set var="begin" value="${ clubBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ clubBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>clubBean.pageNum }">
										<c:set var="begin" value="${ clubBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ clubBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ clubBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }&pageCode=${ i }" />">
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
								
									<c:forEach var="i" begin="1" end="${ clubBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ clubBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }&pageCode=${ i }" />">
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
							
							<c:if test="${ clubBean.pageCode<clubBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }&pageCode=${ clubBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url value="/ContentServlet?op=club&clubName=${ clubBean.club.clubName }&pageCode=${ clubBean.pageNum }" />'>
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
	
	<div style=" background-color: #f7f7f7; border: 1px solid gray;">
	
		<div style="border-bottom: 1px solid gray;">
			<span style="line-height: 50px;padding: 0px 20px;">发表新帖</span>
		</div>
	
		<div style="padding: 20px;">
		
			<form action="${ pageContext.request.contextPath }/FormServlet?op=addPost" name="send" method="post">
			
				<input type="hidden" name="clubName" value="${ clubBean.club.clubName }" />
			
				<table style="margin: 0px;width: 100%;">
					<tr>
					
						<td>
							<div style="padding: 10px 0px;">					
								<div style="float: left;line-height: 30px;border: 1px solid gray;width: 50px;text-align: center;">
									<span style="line-height: 30px;">标题</span>
								</div>
								<div style="float: left;line-height: 32px; margin:0px 10px; height:32px; text-align: center;">
								
									<select name="postTypeId" style="line-height: 32px; height: 32px;width: 80px;">
										<c:forEach var="id" items="${ clubBean.postTypeIdList }">			
											<c:set var="key" value="k${ id }" />								
											<option value="${ id }"  style="line-height: 30px;"> ${ clubBean.postTypeMap[key].postType } </option>
										</c:forEach>
										<c:remove var="key"/>
									</select>
								
								</div>
								<div style="line-height: 30px;margin-left: 150px;padding: 0px 20px;padding-left: 3px;">
									<input type="text" name="title" style="line-height: 30px;  width: 100%; padding: 0px 10px;" />
								</div>
								<div style="clear: both;"></div>
							</div>
						</td>
					
					</tr>
					<tr>
					
						<td>
							<div style="padding: 10px 20px 10px 0px;">
								<textarea rows="5" cols="" name="content" style="width: 100%; padding: 10px;" ></textarea>
							</div>
						</td>
					
					</tr>
					
					<tr>
						
						<td>
						
							<div style="padding: 10px 0px;">							
								<div style="float: left;">
									<input class="post_content" type="text" name="check"
										onfocus="onFocus('check','checktip')"
										onblur="onBlur('check','checktip','验证码')"
										style="width: 150px; padding: 0px 15px;" />
									<div style="position: relative; color: #aaaaaa">
										<div id="checktip"
											style="position: absolute; top: -40px; left: 15px; line-height: 40px;">验证码</div>
									</div>
								</div>
								<div style="float: left;">
									<img class="post_content" id="checkImg" alt=""
										src="${ pageContext.request.contextPath }/CheckServlet"
										style="border: 1px solid gray; background-color: #aaaaaa; width: 100px; height: 40px; margin: 0px 9px;">
								</div>
								<div style="float: left;">
									<span class="post_content" style="width: 60px;"><a
										href="javascript:;" onclick="changCheck();">换一换</a></span>
								</div>
								<div style="clear: both;"></div>
							</div>
						
						</td>
						
					</tr>
					
					<tr>
					
						<td>
							<div style="padding: 10px 0px;">
								<img style="cursor:pointer;" alt="发表帖子" src="${ pageContext.request.contextPath }/img/sendPost.png" onclick="doPost()" />
							</div>
						</td>
					
					</tr>
				</table>
			
			</form>
			
		</div>
		
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









































