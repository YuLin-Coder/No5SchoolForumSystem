<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/public/top.jsp" />

<script>

function getFocus(name){
	document.forms["form"][name].focus();
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

function onFocus(name,id) {
	var tem=document.getElementById(id);
	tem.innerHTML="";
}

function onBlur(name,id,v) {
	var str = document.forms["form"][name].value;
    if(trim(str)==""){   
    	var tem=document.getElementById(id);      
    	tem.innerHTML=v;
    	document.forms["form"][name].value="";
    }   
}

function doPost(){
	var form=document.forms["form"];
	if(checkForm(form)==true){
		form.submit();
	}
}

function checkForm(form){
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
		alert("邮箱不正确！");
		return false;
	}	
	return true;
}

function checkEmail(email) {

	//var patterns = /^([a-z]|[_0-9])+@([\w-]+\.)+[a-zA-z]{2,7}$/i;
	if(email!="") 
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

function changCheck(){
	var check=document.getElementById('checkImg');
	check.src="${ pageContext.request.contextPath }/CheckServlet?check="+Math.random();
}

//window.onload = init; 

</script>

<style>
.content {
	color: gray;
	font-size: 18px;
	font-family: 宋体;
	width: 300px;
	height: 40px;
	line-height: 40px;
}

#regist input {
	width: 280px;
	padding: 0px 10px;
}

#regist {
	border-collapse: collapse;
}

#regist td {
	padding: 10px 0px;
}
</style>



<div style="width: 960px; height: 700px;background-color: white; padding:0px 50px;">


<div style="width: 960px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;padding-right:5px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=register" />'>注册</a>
		</span>
	</div>
	<div style="clear: both;"></div>

</div>

	<div style="width: 600px; height: 100px;">
		<img alt="登陆"
			src="${ pageContext.request.contextPath }/img/register_logo.png" />
	</div>

	<form
		action="${ pageContext.request.contextPath }/FormServlet?op=register"
		name="form" method="post">

		<table id="regist">

			<tr>
				<td align="right"><span class="content">用户名：</span></td>
				<td align="left">
					<input class="content" type="text"
						name="userName" onfocus="onFocus('userName','nametip')"
						onblur="onBlur('userName','nametip','请设置用户名(不可更改,仅限字母组成)')" />
					<div style="position: relative; color: #aaaaaa">
						<div id="nametip"
							style="position: absolute; top: -40px; left: 10px; line-height: 40px;"
							onclick="getFocus('userName')"
							>
							请设置用户名(不可更改,仅限字母组成)
						</div>
					</div></td>
			</tr>

			<tr>
				<td align="right"><span class="content">昵称：</span></td>
				<td align="left"><input class="content" type="text"
					name="nickname" onfocus="onFocus('nickname','nicknametip')"
					onblur="onBlur('nickname','nicknametip','请设置用户名')" />
					<div style="position: relative; color: #aaaaaa">
						<div id="nicknametip"
							style="position: absolute; top: -40px; left: 10px; line-height: 40px;"							
							onclick="getFocus('nickname')"
							>
							请设置昵称
							</div>
					</div></td>
			</tr>

			<tr>
				<td align="right"><span class="content">密码：</span></td>
				<td align="left"><input class="content" type="password"
					name="passwd" onfocus="onFocus('passwd','passwdtip')"
					onblur="onBlur('passwd','passwdtip','请设置密码')" />
					<div style="position: relative; color: #aaaaaa">
						<div id="passwdtip"					
							onclick="getFocus('passwd')"
							style="position: absolute; top: -40px; left: 10px; line-height: 40px;">请设置密码</div>
					</div></td>
			</tr>

			<tr>
				<td align="right"><span class="content">确认密码：</span></td>
				<td align="left"><input class="content" type="password"
					name="passwdagain"
					onfocus="onFocus('passwdagain','passwdagaintip')"
					onblur="onBlur('passwdagain','passwdagaintip','请确认密码')" />
					<div style="position: relative; color: #aaaaaa">
						<div id="passwdagaintip"					
							onclick="getFocus('passwdagain')"
							style="position: absolute; top: -40px; left: 10px; line-height: 40px;">请确认密码</div>
					</div></td>
			</tr>

			<tr>
				<td align="right"><span class="content">邮箱：</span></td>
				<td align="left">
				
					<div style="float: left;width: 200px;">
						<input class="content" type="text"
							name="email"
							style="width: 168px;" onfocus="onFocus('email','emailtip')"
							onblur="onBlur('email','emailtip','请设置邮箱')"
							value="${ userInfoBean.userInfo.emailAccount }" />
						<div style="position: relative; color: #aaaaaa">
							<div id="emailtip"					
								onclick="getFocus('email')"
								style="position: absolute; top: -40px; left: 10px; line-height: 40px;">请设置邮箱</div>
						</div>
					</div>
					
					<div style="float: left;">
						
						<select class="content" name="serverId" style="width: 100px; height: 42px;"  >
							<c:forEach var="mailServer" items="${ registBean.mailServerList }">
								
								<option
									value="${ mailServer.emailServerId }" >
									${ mailServer.domain }
								</option>
								
							</c:forEach>
						</select>
						
					</div>
					
					<div  style="clear: both;"></div>
					
				</td>
			</tr>

			<tr>
				<td align="right"><span class="content">验证码：</span></td>
				<td align="left">
					<div style="float: left;">
						<input class="content" type="text" name="check"
							style="width: 100px;" onfocus="onFocus('check','checktip')"
							onblur="onBlur('check','checktip','验证码')" />
						<div style="position: relative; color: #aaaaaa">
							<div id="checktip"					
								onclick="getFocus('check')"
								style="position: absolute; top: -40px; left: 10px; line-height: 40px;">验证码</div>
						</div>
					</div>
					<div style="float: left;">
						<img class="content" alt="" id="checkImg"
							src="${ pageContext.request.contextPath }/CheckServlet"
							style="border: 1px solid gray; background-color: #aaaaaa; width: 100px; height: 38px; margin: auto 9px;">
					</div>
					<div style="float: left;">
						<span class="content" style="width: 60px;"><a
							href="javascript:;" onclick="changCheck();">换一张</a></span>
					</div>
					<div style="clear: both;"></div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td class="login_content"
					style="text-align: center; padding: 10px 0px;">
					<div>
						<img style="cursor:pointer;" alt=""
							src="${ pageContext.request.contextPath }/img/regist_btn.png"
							onclick="doPost()" />
					</div>
				</td>
			</tr>

			<tr>
				<td></td>
				<td class="login_content" align="right" valign="top"
					style="padding: 0px;">
					<div>
						<span style="line-height: 20px; color: gray;">已有账号，<a
							href="${ pageContext.request.contextPath }/content/login.jsp">马上登陆</a></span>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<c:if test="${ requestScope.msg!=null }">
		<script type="text/javascript">
			alert("${requestScope.msg}");
		</script>
	</c:if>
</div>

<jsp:include page="/public/foot.jsp" />






































