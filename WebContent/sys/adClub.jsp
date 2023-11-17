<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style>


a:link {
	text-decoration: none;
	color: blue;
}

a:visited {
	text-decoration: none;
	color: blue;
}

a:hover {
	text-decoration: none;
	color: blue;
}

a:active {
	text-decoration: none;
	color: blue;
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

</style>


</head>
<body>

<div style="margin: 0px auto;">

	<div class="table" style="margin: 10px 20px;">
				
		<div>
			<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px;padding: 0px;line-height: 50px;">版块类型管理:</span>
		</div>
		
		<table  border="0" cellspacing="0" cellpadding="0">
		
			<tr>
			
				<td>
					<span>分类</span>
				</td>
				<td>
					<span>编辑</span>
				</td>
				<td>
					<span>删除</span>
				</td>
			
			</tr>
			
			<c:forEach var="type" items="${ clubListBean.clubTypeList }">
			
				<tr>
				
					<td>
						<span>${ type.clubType }</span>
					</td>	
					<td>
						<a href="${pageContext.request.contextPath }/AdPageServlet?page=clubTypeEdit&typeId=${ type.clubTypeId }"><span>编辑</span></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/AdUpdateServlet?op=deleteClubType&typeId=${ type.clubTypeId }"><span>删除</span></a>
					</td>
				
				</tr>
				
			
			</c:forEach>
		
		</table>
		
		<div style="margin-top: 20px;">
		
			<div>
				<span style="margin: 0px;padding: 0px;">添加分类：</span>
			</div>
			
			<form action="${pageContext.request.contextPath }/AdUpdateServlet?op=addClubType" method="post">
			
				<input type="text" name="clubTypeName" />
				<input type="submit" value="添加">
			
			</form>
			
		</div>
	
	</div>

	
	<div>
		<hr style="margin: 50px 20px;">
	</div>
	
	<div style="margin: 10px 20px;">
				
		<div style="margin-bottom: 10px;">
			<div style="float: left;">
				<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px;padding: 0px;line-height: 50px;">版块管理:</span>
			</div>
			<div style="float:right;">
				<a href="${pageContext.request.contextPath }/AdPageServlet?page=adEditClub">
					<span style="font-size: 24px;font-family: 微软雅黑;margin: 0px;padding: 0px;line-height: 50px;">+添加版块</span>
				</a>
			</div>
			<div style="clear: both;"></div>
		</div>
		
		<div>
		
			<c:choose>
		
				<c:when test="${ clubListBean!=null and clubListBean.clubTypeList!=null }">
					<c:forEach var="type" items="${ clubListBean.clubTypeList }">
						<div>
						
							<div style="border: 1px solid gray;border-bottom-color: #11B7EF;">
								<span style="padding: 0px 20px; line-height: 40px; font-size: 18px; font-family: 微软雅黑;">
									${ type.clubType }
								</span>
							</div>
							
							<div style="background-color: #ffffff; border: 1px solid gray; border-top-width: 0px; padding: 10px 20px;">
							
								<c:set var="key" value="k${ type.clubTypeId }"/>
								<c:forEach var="item" items='${ clubListBean.clubMap[key] }'>
									<div style="float: left;width: 300px; padding: 10px 0px;min-height: 100px;">
										<table style="margin-left: 0px;padding-left: 0px;">
											<tr>
												<td rowspan="3">
													<div style="width: 80px;height: 80px;
																padding: 0px 10px;">
														
														<img alt="图标" src="img/club_icon/${ item.clubIcon }" 
															style="width: 80px;height: 80px; max-height: 80px; "/>
													</div>
												</td>
												<td >
													<span style="font-size: 16px;">
														<a href='${pageContext.request.contextPath }/AdPageServlet?page=adEditClub&clubName=${ item.clubName }'>
															${ item.clubName }
														</a>
													</span>
												</td>
											</tr>
											<tr>
												<td >
													<span style="font-size: 14px; color: gray;">主题：${ item.postNum }</span>
												</td>
											</tr>
											<tr>
												<td >
													<span style="font-size: 14px; color: gray;">贴数：${ item.replyNum+item.postNum }</span>
												</td>
											</tr>
										</table>
									</div>
								</c:forEach>
								<c:remove var="key"/>
								<div style="clear: both;"></div>
							</div>
							<br>
						
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>暂无版块</p>
				</c:otherwise>
			
			</c:choose>
	
		
		</div>
	
	</div>


</div>



</body>
</html>








































