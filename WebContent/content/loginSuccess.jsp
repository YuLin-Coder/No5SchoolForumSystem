<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/public/top.jsp" />
<script type="text/javascript"> 
function load(){ 
	setInterval(go, 1000); 
}; 
var x=3; 
function go(){ 
	x--; 
	if(x>0){ 
		document.getElementById("sp").innerHTML=x; 
	}else{ 
		window.location.href='${ pageContext.request.contextPath }/ContentServlet?op=home'; 
	} 
} 
window.onload = load; 
</script>
<div style="width: 960px; height: 700px; text-align: center;background-color: white; padding:0px 50px;">
	<p style="padding: 100px;line-height: 30px;">
		登陆成功！<br>
		<span id="sp">3</span>秒后自动跳转到首页...<br>
		<a href="${ pageContext.request.contextPath }/ContentServlet?op=home">立即跳转</a>
	</p>
</div>

<jsp:include page="/public/foot.jsp" />