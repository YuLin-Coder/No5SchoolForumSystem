<%@page import="campusbbs.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>


//图片上传预览    IE是用了滤镜。
function previewImage(file)
{
	
	if(!get()){
		return;
	}
	
	var MAXWIDTH  = 200; 
	var MAXHEIGHT = 200;
  var prevDiv = document.getElementById('preview');  
  if (file.files && file.files[0]){  
      var reader = new FileReader();  
      reader.onload = function(evt){ 
      	prevDiv.innerHTML = '<img class="image" src="' + evt.target.result + '" />'; 
      }    
      reader.readAsDataURL(file.files[0]);  
  } else { 
		prevDiv.innerHTML = '<div class="image" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>'; 
	}  
}

function get(){
	
	var d = document.getElementById("img");
	var s = d.value;
	var fl = s.split(".");
	
    //图片文件格式   "jpeg","jpg",
	var ary = ["jpeg","jpg","png"];
	 
	for(var i=0;i<ary.length;i++){
		if(fl[1]==ary[i]){
			
			return true;
			
		}
	}
	
	d.value="";
	alert("文件格式不正确！");
	return false;
   
}

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

function doPost(name){
	var form=document.forms[name];
	if(checkForm(form)==true){
		form.submit();
	}
}



function checkForm(form){
	/*
	var userName=form["userName"].value;
	if(!checkUserName(userName)){
		alert("用户名格式不正确！");
		return false;
	}
	var passwd=form["passwd"].value;
	if(!checkPasswd(passwd)){
		alert("密码格式不正确！");
		return false;
	}
	var passwdagain=form["passwdagain"].value;
	if(passwd!=passwdagain){
		alert("密码不一致！");
		return false;
	}	
	var email=form["email"].value;
	if(!checkEmail(email)){
		alert("邮箱格式不正确！");
		return false;
	}	
	*/
	return true;
}

function checkEmail(email) {

	var patterns = /^([a-z]|[_0-9])+@([\w-]+\.)+[a-zA-z]{2,7}$/i;
	if(email.match(patterns)) 
	{ 
		return true; 
	} 
	return false; 
}

function checkUserName(userName)
{ 
	var patterns = /^[a-z]+$/i; 
	if(userName.match(patterns)) 
	{ 
		return true; 
	} 
	return false; 
}

function checkPasswd(passwd)
{ 
	var patterns = /^([a-z]|[0-9])+$/i; 
	if(passwd.match(patterns)) 
	{ 
		return true; 
	} 
	return false; 
}

//window.onload = init; 

</script>

<style>
#preview, .image{  
    width:200px;  
    height:200px;  
}  
#preview{  
    border:1px solid gray;  
} 
.content {
	color: gray;
	font-size: 18px;
	font-family: 宋体;
	width: 3px  0px;
	height: 40px;
	line-height: 40px;
}

.regist input {
	width: 260px;
	padding: 0px 10px;
}

.regist {
	border-collapse: collapse;
}

.regist td {
	padding:10px 0px;
}
.regist span {
	margin: 0px;
	padding: 0px;
}
.regist div {
	margin: 0px;
	padding: 0px;
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

</head>
<body>


<div style="width: 960px;">

		
		<div>
			<span>
				<a href="<c:url value='/AdPageServlet?page=user' /> ">&lt;返回</a>
			</span>
		</div>
	<table >
	
		<tr>
			
			<td valign="top">
			
		
				<div style="margin: 50px;">				
		
					<form action='<c:url value="/AdUpdateServlet?op=updateUserInfo" />' name="form" method="post" enctype="multipart/form-data">
					
						<input type="hidden" name="userName" value="${ userInfoBean.userInfo.userName }" />
						<input type="hidden" name="head" value="${ userInfoBean.userInfo.head }" />
				
				
						<table  class="regist" >
						
							<tr>
								<th colspan="2" align="left">
									<div>
										<div>
											<span style="font-family: 微软雅黑;font-size: 18px;color: gray; line-height: 50px;">个人信息：</span>
										</div>
					
										<hr style="margin-bottom: 10px;">
									</div>
								</th>
							</tr>
				
							<tr>
								<td align="center" colspan="2">
								
									<div style="margin: 0px auto;">
										<div  id="preview" style="padding: 10px;border: solid 1px gray; width: 200px;">
											<img class="image" id="view"  alt="头像" src="" style="width: 200px; height: 200px;"/>
										</div>
										
										<div style="width: 222px; text-align: left;">
											<input  id="img" name="upImg" 
													style="font-size:14px; line-height:50px; height: 30px;padding: 5px 0px;margin: 0px;" 
													type="file" 
													onchange="previewImage(this)" />					
										</div>
									</div>
				
								</td>
							</tr>
				
							<tr>
								<td align="right">
									<div>
										<span class="content" style="padding: 0px;margin: 0px;">昵称：</span>
									</div>
								</td>
								<td align="left">
									<input class="content" type="text"
										name="name" 
										value="${ userInfoBean.userInfo.nickname }" />
								</td>
							</tr>
				
							<tr>
								<td align="right"><span class="content">邮箱：</span></td>
								<td align="left">
								
									<div style="float: left;width: 180px;">
										<input class="content" type="text"
											name="email"
											style="width: 148px;"
											value="${ userInfoBean.userInfo.emailAccount }" />
									</div>
									
									<div style="float: left;">
										
										<select class="content" name="serverId" style="width: 100px; height: 42px;"  >
											<c:forEach var="mailServer" items="${ userInfoBean.mailServerList }">
												
												<c:choose>
												
													<c:when test="${ mailServer.emailServerId==userInfoBean.userInfo.emailServerId }">
														<option selected="selected"
															value="${ mailServer.emailServerId }" >
															${ mailServer.domain }
														</option>
													</c:when>
													<c:otherwise>
														<option 
															value="${ mailServer.emailServerId }" >
															${ mailServer.domain }
														</option>
													</c:otherwise>
												
												</c:choose>
												
											</c:forEach>
										</select>
										
									</div>
									
									<div  style="clear: both;"></div>
									
								</td>
				
							</tr>
				
							<tr>
								<td></td>
								<td class="login_content"
									style="text-align: left; padding: 10px 0px;">
									<div>
										<img style="cursor:pointer;" alt=""
											src="${ pageContext.request.contextPath }/img/save.png"
											onclick="doPost('form')" />
									</div>
								</td>
							</tr>
							
						</table>
					</form>
				
				</div>		
			
			</td>
			
			<td valign="top" >			
			
				<div style="margin: 50px;">
										
					<form action='<c:url value="/AdUpdateServlet?op=updateUserPwd&userName=${ userInfoBean.userInfo.userName }" />' name="updatePwd" method="post" enctype="application/x-www-form-urlencoded" >
									
						<table class="regist">						
							<tr>
								<th colspan="2" align="left">
									<div>
										<div>
											<span style="font-family: 微软雅黑;font-size: 18px;color: gray; line-height: 50px;">更改密码：</span>
										</div>
					
										<hr style="margin-bottom: 10px;">
									</div>
								</th>
							</tr>
							
							<tr>
								<td align="right"><span class="content" >旧的密码：</span></td>
								<td align="left">
									<input class="content" type="password"
										name="oldpasword" />
								</td>
							</tr>
							
							<tr>
								<td align="right"><span class="content">新的密码：</span></td>
								<td align="left">
									<input class="content" type="password"
										name="newpasword" />
								</td>
							</tr>
							
							<tr>
								<td align="right"><span class="content">确认密码：</span></td>
								<td align="left">
									<input class="content" type="password"
										name="paswordagain" />
								</td>
							</tr>
				
							<tr>
								<td></td>
								<td class="login_content"
									style="text-align: left; padding: 10px 0px;">
									<div>
										<img style="cursor:pointer;" alt=""
											src="${ pageContext.request.contextPath }/img/updatePwd.png"
											onclick="doPost('updatePwd')" />
									</div>
								</td>
							</tr>
							
						</table>
					</form>
		
				
				</div>
				
			
			</td>
		
		</tr>
	
	</table>

</div>

<br>

<div>
	
	<div style=" background-color: #f7f7f7;border: 1px solid #cccccc;width: 1570px;">
		<div>
			<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px 10px;padding: 0px;line-height: 50px;">用户主题帖管理:</span>
		</div>
		<c:choose>
		
			<c:when test="${ requestScope.userInfoBean.lastPostBean!=null and requestScope.userInfoBean.lastPostBean.recordTotel>0 }">
			
				<c:forEach var="item" items="${ requestScope.userInfoBean.lastPostBean.beanList }">
				
					<div id="${ item.postId }" class="postItem" onmouseover="mOver(this)" onmouseout="mOut(this)" 
						style="float: left;margin : 10px;padding: 10px 0px;border: 1px solid gray; width: 500px;">
												
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
									<a 
href="${ pageContext.request.contextPath }/AdUpdateServlet?op=deletePost&userName=${ userInfoBean.userInfo.userName }&postId=${ item.postId }&replyPageCode=${ userInfoBean.replyListBean.pageCode }&postPageCode=${ userInfoBean.lastPostBean.pageCode }" style="color: blue;">
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
												<span style="color: ${ userInfoBean.lastPostBean.postTypeMap[key].color };">
													[&nbsp;${ userInfoBean.lastPostBean.postTypeMap[key].postType }&nbsp;]&nbsp;
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
								<a href='<c:url 
								value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&replyPageCode=${ userInfoBean.replyListBean.pageCode }" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ userInfoBean.lastPostBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url 
value="/AdPageServlet?page=editUser&replyPageCode=${ userInfoBean.replyListBean.pageCode }&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode-1 }" />'>
										<span>上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ userInfoBean.lastPostBean.pageNum>7 }">
							
									<c:set var="begin" value="${ userInfoBean.lastPostBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ userInfoBean.lastPostBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>userInfoBean.lastPostBean.pageNum }">
										<c:set var="begin" value="${ userInfoBean.lastPostBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ userInfoBean.lastPostBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ userInfoBean.lastPostBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url 
value="/AdPageServlet?page=editUser&replyPageCode=${ userInfoBean.replyListBean.pageCode }&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ i }" />">
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
								
									<c:forEach var="i" begin="1" end="${ userInfoBean.lastPostBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ userInfoBean.lastPostBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url 
				value="/AdPageServlet?page=editUser&replyPageCode=${ userInfoBean.replyListBean.pageCode }&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ i }" />">
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
							
							<c:if test="${ userInfoBean.lastPostBean.pageCode<userInfoBean.lastPostBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url 
value="/AdPageServlet?page=editUser&replyPageCode=${ userInfoBean.replyListBean.pageCode }&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url 
value="/AdPageServlet?page=editUser&replyPageCode=${ userInfoBean.replyListBean.pageCode }&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageNum }" />'>
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
	
	<div style="border: 1px solid #cccccc; width: 960px;">
	
		<div style="border-bottom : 1px solid #cccccc;background-color:#eeeeee;  ">
			<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px;padding: 0px 20px;line-height: 50px;">
				用户回复管理:
			</span>
		</div>
	
		<c:choose>
		
			<c:when test="${ userInfoBean.replyListBean!=null and userInfoBean.replyListBean.recordTotel>0 }">
			
				<c:forEach var="reply" items="${ userInfoBean.replyListBean.beanList }">
				
					<div style="border-bottom : 1px solid #cccccc; ">
						    
					    <div  style="padding:0px 20px;">
				
					        <div style="border-bottom:dashed 1px gray;padding: 10px 0px;">
					        	<div>
					        		<c:set var="key" value="k${ reply.postId }"></c:set>
					        		<span style="font-size: 14px;color: gray;font-size: 18px;">
					        			回复：
					        			<a href="#">
					        				${ userInfoBean.postMap[key].postTitle }
					        			</a>
					        		</span>					     
					        	</div>	            
					        	<div>
					        		<span style="font-size: 14px;color: gray;">发表于：${ reply.replyTime }</span>
					        				        		
						        	<span style="font-size: 14px;color: gray;padding: 0px 10px;">|</span>
									<a 
href='<c:url 
value="/AdUpdateServlet?op=deleteReply&userName=${ userInfoBean.userInfo.userName }&replyId=${ reply.replyId }&replyPageCode=${ userInfoBean.replyListBean.pageCode }&postPageCode=${ userInfoBean.lastPostBean.pageCode }" />' >
										<span style="font-size: 14px;color: gray;">删除</span>
									</a>
					     
					        	</div>	            
					        </div>
					        
					        <div style="min-height:100px;padding: 20px 0px;">
					            ${ reply.replyContent }
					        </div>
					    </div>
					
					</div>
				
				</c:forEach>			
				
				<div>					
					
					<div>
						
						<div style="float: right;margin: 20px;">
						
							<div style="float: left;  margin:0px 5px; line-height: 30px;">
								<a href='<c:url 
value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode }" />'>
									<span>首页</span>
								</a>
							</div>
							
							<c:if test="${ userInfoBean.replyListBean.pageCode>1 }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url 

value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode }&replyPageCode=${ userInfoBean.replyListBean.pageCode-1 }" />'>
									
										<span>上一页</span>
									</a>
								</div>						
							</c:if>
							
							<c:choose>
							
								<c:when test="${ userInfoBean.replyListBean.pageNum>7 }">
							
									<c:set var="begin" value="${ userInfoBean.replyListBean.pageCode-3 }"></c:set>
									<c:set var="end" value="${ userInfoBean.replyListBean.pageCode+3 }"></c:set>
									<c:if test="${ begin<1 }">
										<c:set var="begin" value="${ 1 }"></c:set>
										<c:set var="end" value="${ 7 }"></c:set>
									</c:if>
									<c:if test="${ end>userInfoBean.replyListBean.pageNum }">
										<c:set var="begin" value="${ userInfoBean.replyListBean.pageNum-6 }"></c:set>
										<c:set var="end" value="${ userInfoBean.replyListBean.pageNum }"></c:set>
									</c:if>
									
									<c:forEach var="i" begin="${ begin }" end="${ end }">
										
										<c:choose>
										
											<c:when test="${ userInfoBean.replyListBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url 
value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode }&replyPageCode=${ i }" />">
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
								
									<c:forEach var="i" begin="1" end="${ userInfoBean.replyListBean.pageNum }">
										
										<c:choose>
										
											<c:when test="${ userInfoBean.replyListBean.pageCode!=i }">
												<div style="float: left; 
															margin:0px 5px;
															width: 30px; 
															line-height: 30px;
															text-align: center;
															border: solid 1px #cccccc;">
													<a href=" <c:url 
value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode }&replyPageCode=${ i }" />">
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
							
							<c:if test="${ userInfoBean.replyListBean.pageCode<userInfoBean.replyListBean.pageNum }">
								<div style="float: left; margin:0px 5px; line-height: 30px;">
									<a href='<c:url 
value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode }&replyPageCode=${ userInfoBean.replyListBean.pageCode+1 }" />'>
										<span>下一页</span>
									</a>
								</div>						
							</c:if>
							
							<div style="float: left; margin:0px 5px; line-height: 30px;">
								<a href='<c:url 
value="/AdPageServlet?page=editUser&userName=${ userInfoBean.userInfo.userName }&postPageCode=${ userInfoBean.lastPostBean.pageCode }&replyPageCode=${ userInfoBean.replyListBean.pageNum }" />'>
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

<br>
<br>


	<c:if test="${ requestScope.msg!=null }">
		<script type="text/javascript">
			alert("${requestScope.msg}");
		</script>
	</c:if>
<script>

var imgView = document.getElementById('view');  
imgView.src='img/user_head/${ userInfoBean.userInfo.head }'+'?st='+Math.random()+Math.random()+Math.random()+Math.random()+Math.random();

</script> 


</body>
</html>