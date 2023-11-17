<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/public/top.jsp" />




<style type="text/css">

*{
	margin: 0px auto; 
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
	obj.style.backgroundColor="#f0f0f0";
}

function mOut(obj){
	obj.style.backgroundColor="#ffffff";
}

</script>

<div style="width: 960px;background-color: white; padding:0px 50px;" >


<div style="width: 960px;height:700px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=public" />'>公告</a>
		</span>
	</div>
	<div style="clear: both;"></div>
	
	<div style="padding: 50px;">
		<div style="text-align: center;margin:0px auto;padding: 0px 100px;">
			<h1 style="text-align:center;">
				<span style=" color: red;">【动态】</span>
				<span style=" color: orange;">关于网站开发进度的说明</span>
			</h1>
		</div>
		<div style="padding: 50px 100px;">
			<p style="text-indent: 2em;line-height: 30px;">
			目前本网站仅仅实现发帖回帖等基本功能，还有其他较多的常用功能，例如在帖子中嵌入图片、表情图等，均没有实现，
			由于时间的限制，加上最近四六级临近，估计开发人员在未来几个星期都没有多少时间投入到开发当中，因此当前本网站所
			实现的所有功能，可能就是课程设计的最终成果，如若四六级过后还有足够的时间，我们将继续维护更新下去，若当前有
			限的功能让你感到不便，敬请原谅。</p>
		</div>
		<div style="padding: 0px 100px;">
			<div style="float: right;">
				<span>2023/12/05</span>
			</div>
			<div style="clear: both;">
				
			</div>
		</div>
	</div>

</div>
	



<br>
<br>
</div>

<jsp:include page="/public/foot.jsp" />








































