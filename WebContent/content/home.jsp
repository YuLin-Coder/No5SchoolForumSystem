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

#change_pic {
	margin: 0px auto;
	padding: 0px;
	height: 300px;
	width: 533px;
	position: relative;
}
#change_pic #choose {
	position: absolute;
	top: 270px;
	left: 10px;
}
#change_pic #p1 {
	display: none;
	float:left;
	position: relative;
}
#change_pic #p2 {
	display: none;
	float:left;
	position: relative;
}
#change_pic #p3 {
	display: none;
	float:left;
	position: relative;
}
#change_pic #p4 {
	display: none;
	float:left;
	position: relative;
}
#change_pic #p0 {
	display: block;
	float:left;
	position: relative;
}

</style>

<script>

function mOver(obj){
	obj.style.backgroundColor="#f0f0f0";
}

function mOut(obj){
	obj.style.backgroundColor="#ffffff";
}

var n1=0,n2=0;
function change(n)
{
	n2=n;
	document.getElementById("p"+n1).style.display="none"
	document.getElementById("p"+n).style.display="block";
	n1=n;
}

function ch_time()
{
	change(n2);
	if(n2==4)
		n2=0;
	else
		n2++;
}

//onload="setInterval('ch_time();',1000);alert("执行");"

</script>


<div style="width: 960px;background-color: white; padding:0px 50px;" >

<div style="width: 960px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<img alt="论坛" src="img/home.png" width="20" height="20" />
	</div>
	<div style="float: left;line-height: 20px;margin: 0px;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=home" />'>首页</a>
		</span>
	</div>
	<div style="clear: both;"></div>

</div>

	<div>
	
		<div>
	
			<div style="border: 1px solid gray;">
				<span style="padding: 0px 20px; line-height: 50px; font-size: 24px; font-family: 黑体">热门话题</span>
			</div>
	
			<div style="background-color: #ffffff; border: 1px solid gray; border-top-width: 0px; padding: 10px 20px;">

				<div class="postItem"  style="float: left; width: 533px; height: 300px;border: 1px solid #cccccc;">
				
					<!-- <img alt="img" src="img/adv.png"/> -->
					
						<div id="change_pic">
						
							<div id="p0">
								<img src="pic/01.jpg" width="533" height="300" />
							</div>
							
							<div id="p1">
								<img src="pic/02.jpg" width="533" height="300" /> </div>
							
							<div id="p2">
								<img src="pic/03.jpg" width="533" height="300" /> </div>
							
							<div id="p3">
								<img src="pic/04.jpg" width="533" height="300" />
							</div>
							
							<div id="p4">
								<img src="pic/05.jpg" width="533" height="300" />
							</div>
							
							<div id="choose">
							  <form name="butt">
							  <table>
							    <tr>
							      <td><input name="ch_pic" type="radio" value="ch_pic" onclick="change(0*1);" /></td>
							      <td><input name="ch_pic" type="radio" value="ch_pic" onclick="change(1*1);" /></td>
							      <td><input name="ch_pic" type="radio" value="ch_pic" onclick="change(2*1);" /></td>
							      <td><input name="ch_pic" type="radio" value="ch_pic" onclick="change(3*1);" /></td>
							      <td><input name="ch_pic" type="radio" value="ch_pic" onclick="change(4*1);" /></td>
							    </tr>
							  </table>
							  </form>
							</div>
							
						</div>
								
				</div>
				
				<div style=" border: 1px solid #cccccc; margin-left: 553px;padding:15px 10px; min-height: 270px;">
				
					<c:choose>
					
						<c:when test="${ homeBean!=null and homeBean.hostPosts!=null }">
						
							<div style="padding:0px 10px;border-top : 1px dashed #cccccc;" ></div>
							
							<c:forEach var="post" items="${ homeBean.hostPosts }">
							
								<div class="postItem" style="padding:0px 10px; overflow: hidden;text-overflow:ellipsis; " onmouseover="mOver(this)" onmouseout="mOut(this)" >
								
									<a href="${ pageContext.request.contextPath }/ContentServlet?op=post&postId=${ post.postId }">
										<span style="line-height: 29px; overflow: hidden;white-space:nowrap;text-overflow:ellipsis; ">
										${ post.postTitle }
										</span>
									</a>
								
								</div>
								<div style="padding:0px 10px;border-top : 1px dashed #cccccc;" ></div>
							
							</c:forEach>
						
						</c:when>
						
						<c:otherwise>
						
							<div style="margin: 0px auto; width: 100%; text-align: center; ">
							
								<span style="line-height: 270px;">暂无更新</span>
							
							</div>
						
						</c:otherwise>
					
					</c:choose>
				
				</div>
				
				<div style="clear: both;"></div>

			</div>
	
		</div>
	
		<br>	
	
		<div>
	
			<div style="border: 1px solid gray;">
				<span style="padding: 0px 20px; line-height: 50px; font-size: 24px; font-family: 黑体">人气板块</span>
			</div>
	
			<div style="background-color: #ffffff; border: 1px solid gray; border-top-width: 0px; padding: 10px 20px;">
				
				<c:choose>
					
					<c:when test="${ homeBean!=null and homeBean.hostClubs!=null }">
						<c:forEach var="item" items="${ homeBean.hostClubs }">
							<div style="float: left;width: 300px;min-height:100px; padding: 10px 0px;">
								<table style="margin-left: 0px;padding-left: 0px;">
									<tr>
										<td rowspan="3">
											<img alt="图标" src="img/club_icon/${ item.clubIcon }" style="width:80px; height: 80px; padding: 0px 10px;"/>
										</td>
										<td>
											<span style="font-size: 16px;">
												<a href="${ pageContext.request.contextPath }/ContentServlet?op=club&clubName=${ item.clubName }">
													${ item.clubName }
												</a>
											</span>
										</td>
									</tr>
									<tr>
										<td>
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
					</c:when>
					<c:otherwise>
						<p>暂无版块</p>
					</c:otherwise>
				
				</c:choose>
				
				<div style="clear: both;"></div>
			</div>
	
		</div>		
	
	</div>	
	

<br>
<br>
</div>

<script type="text/javascript">
<!--

//-->

setInterval('ch_time();',3000);
//alert("执行");


</script>

<jsp:include page="/public/foot.jsp" />








































