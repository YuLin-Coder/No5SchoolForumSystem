<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
#foot {
	background-color: #2f2f2f;
	height: 130px;
	margin: auto;
	padding: 10px 50px;
	width:960px;
}

#foot span {
	font-family: 黑体;
	color: white;
}

#foot td {
	padding: 5px;
}

#foot a:link {
	color: white;
}

#foot a:visited {
	color: white;
}

#foot a:hover {
	color: white;
}

#foot a:active {
	color: white;
}
</style>

<div style="margin:0px auto;background-color:#2f2f2f;">

<div id="foot">

	<table>
		<tr>
			<td align="center"><span> <a href="#">关于我们</a>&nbsp;|&nbsp;<a
					href="#">免责声明</a>&nbsp;|&nbsp;<a href="${ pageContext.request.contextPath }/sys/sysAdmin.jsp">系统管理</a>
			</span></td>
		</tr>
		<tr>
			<td align="center"><span>@2023 校园社团论坛</span></td>
		</tr>
		<tr>
			<td align="center"><span>地址：广东省珠海市吉林大学珠海学院</span></td>
		</tr>
	</table>
</div>



</div>

</body>
</html>
