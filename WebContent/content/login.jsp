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
	if(checkForm(form)){
		form.submit();
	}
}

function checkForm(form){
	var userName=form["userName"].value;
	if(userName==""){
		alert("用户名不能为空！");
		return false;
	}
	var passwd=form["passwd"].value;
	if(passwd==""){
		alert("密码不能为空！");
		return false;
	}
	var check=form["check"].value;
	if(check==""){
		alert("验证码不能为空！");
		return false;
	}	
	return true;
}

function changCheck(){
	var check=document.getElementById('checkImg');
	check.src="${ pageContext.request.contextPath }/CheckServlet?check="+Math.random();
}


//window.onload = init; 

</script>

<style>
.login_content {
	color: gray;
	font-size: 18px;
	font-family: 宋体;
	width: 330px;
	height: 50px;
	line-height: 50px;
}

#login_table {
	border-collapse: collapse;
}

#login_table td {
	width: 360px;
	height: 50px;
	padding: 10px 0px;
}
</style>

<div style="width: 960px;height:700px; background-color: white; padding:0px 50px;">


<div style="width: 960px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;padding-right:5px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=login" />'>登陆</a>
		</span>
	</div>
	<div style="clear: both;"></div>

</div>

	<div style="width: 600px; height: 100px;">
		<img alt="登陆"
			src="${ pageContext.request.contextPath }/img/login_logo.png" />
	</div>

	<form name="form"
		action="${ pageContext.request.contextPath }/FormServlet?op=login"
		method="post">

		<input type="hidden" name="VIEWSTATE" value="" />

		<table id="login_table">
			<tr>
				<td colspan="3"><input class="login_content" type="text"
					name="userName" onfocus="onFocus('userName','nametip')"
					onblur="onBlur('userName','nametip','用户名')"
					style="padding: 0px 15px;" />
					<div style="position: relative; color: #aaaaaa">
						<div id="nametip"						
							onclick="getFocus('userName')"
							style="position: absolute; top: -50px; left: 15px; line-height: 50px;">用户名</div>
					</div></td>
			</tr>
			<tr>
				<td colspan="3"><input class="login_content" type="password"
					name="passwd" onfocus="onFocus('passwd','passwdtip')"
					onblur="onBlur('passwd','passwdtip','密码')"
					style="padding: 0px 15px;" />
					<div style="position: relative; color: #aaaaaa">
						<div id="passwdtip"						
							onclick="getFocus('passwd')"
							style="position: absolute; top: -50px; left: 15px; line-height: 50px;">密码</div>
					</div></td>
			</tr>
			<tr>
				<td>
					<div style="float: left;">
						<input class="login_content" type="text" name="check"
							onfocus="onFocus('check','checktip')"
							onblur="onBlur('check','checktip','验证码')"
							style="width: 150px; padding: 0px 15px;" />
						<div style="position: relative; color: #aaaaaa">
							<div id="checktip"						
								onclick="getFocus('check')"
								style="position: absolute; top: -50px; left: 15px; line-height: 50px;">验证码</div>
						</div>
					</div>
					<div style="float: left;">
						<img class="login_content" id="checkImg" alt=""
							src="${ pageContext.request.contextPath }/CheckServlet"
							style="border: 1px solid gray; background-color: #aaaaaa; width: 100px; height: 40px; margin: 4px 9px;">
					</div>
					<div style="float: left;">
						<span class="login_content" style="width: 60px;"><a
							href="javascript:;" onclick="changCheck();">换一换</a></span>
					</div>
					<div style="clear: both;"></div>
				</td>
			</tr>
			<tr>
				<td colspan="3" valign="bottom" style="padding: 0px; height: 40px;">

					<div style="float: left;">
						<span style="color: gray;"><input type="checkbox" />&nbsp;记住我</span>
					</div>
					<div style="float: right;">
						<span><a href="#">忘记密码</a></span>
					</div>
					<div style="clear: both;"></div>

				</td>
			</tr>
			<tr>
				<td colspan="3" class="login_content"
					style="text-align: center; padding: 10px 0px;">
					<div>
						<img style="cursor:pointer;" alt="登陆"
							src="${ pageContext.request.contextPath }/img/login_btn.png"
							onclick="doPost()" />
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="login_content" align="right" valign="top"
					style="padding: 0px;">
					<div>
						<span style="line-height: 20px; color: gray;">还没有账号？<a
							href="${ pageContext.request.contextPath }/content/register.jsp">点此注册</a></span>
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



































