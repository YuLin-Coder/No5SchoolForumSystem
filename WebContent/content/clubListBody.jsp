<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
* {
	margin: 0px auto;
}
</style>

<div style="width: 960px;background-color: white; padding:0px 50px;">

<div style="width: 960px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=clubList" />'>版块</a>
		</span>
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
								<div style="float: left;width: 300px; padding: 10px 0px;">
									<table style="margin-left: 0px;padding-left: 0px;">
										<tr>
											<td rowspan="3">
												<img alt="图标" src="img/club_icon/${ item.clubIcon }" style="width:80px; height: 80px; padding: 0px 10px;"/>
											</td>
											<td >
												<span style="font-size: 16px;">
													<a href='<c:url value="/ContentServlet?op=club&clubName=${ item.clubName }" />'>
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
				<p>暂无内容</p>
			</c:otherwise>
		
		</c:choose>

	</div>


<br>


</div>



































