<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新版块</title>

<style>
#preview, .image{  
    width:200px;  
    height:200px;  
}  
#preview{  
    border:1px solid gray;  
} 

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


<script type="text/javascript">


function mOver(obj){
	obj.style.backgroundColor="#ffffff";
}

function mOut(obj){
	obj.style.backgroundColor="#f7f7f7";
}

function doPost() {
	var form=document.forms["form"];
	
	if(checkForm(form)){
		form.submit();
	}
}

function checkForm(form){
	/*
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
	}*/
	
	return true;
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


</script>

</head>
<body>

<div style="margin: 0px auto;width: 700px;">
	
	<div style="margin: 0px auto;min-width: 700px;">
		
		<hr>
			
		<div style="width: 700px; border: 1px solid gray;padding: 50px;">
			
			<form action='<c:url value="/AdUpdateServlet?op=editClub" />' name="form" method="post" enctype="multipart/form-data">						
				
				<c:if test="${ param.clubName!=null }">
					<input type="hidden" name="oldClubName" value="${ adClubEditBean.club.clubName }" />
				</c:if>
				
					<table style="width: 100%;">
					
						<tr>
							<td align="left"> 
								<c:choose>
								
									<c:when test="${ adClubEditBean.club==null }">
										<span style="line-height: 50px;font-size: 24px;font-family: 微软雅黑;">
											<a href="${pageContext.request.contextPath }/AdPageServlet?page=club">&lt;返回</a>&nbsp;|&nbsp;添加新版块：	
										</span>						
									</c:when>
									<c:otherwise>		
										<div>
										
											<div style="float: left;">		
												<span style="line-height: 50px;font-size: 24px;font-family: 微软雅黑;">
													<a href="${pageContext.request.contextPath }/AdPageServlet?page=club">&lt;返回</a>
													&nbsp;|&nbsp;更改版块：${ adClubEditBean.club.clubName }
												</span>
											</div>
										
											<div style="float: right;">
												<span style="line-height: 50px;font-size: 18px;font-family: 微软雅黑;">										
													<a href="<c:url value="/AdUpdateServlet?op=deleteClub&clubName=${ adClubEditBean.club.clubName }" />">&nbsp;删除这个版块</a>
												</span>
											</div>
										
											<div style="clear: both;">
											</div>
										
										</div>			
									</c:otherwise>
								
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>
								<hr>
							</td>
						</tr>
						<tr>
						
							<td align="left">
							
									<input type="hidden" name="clubIcon" value="${ adClubEditBean.club.clubIcon }" />
									<input type="hidden" id="url" name="url" value="${ adClubEditBean.url }" />
								
									<div style="padding: 20px 0px;">	
													
										<div>
											<span style="line-height: 30px;">图标预览：</span>
										</div>
										
										<div id="preview" style="width: 200px; height: 200px; margin: 0px; border: solid  1px #cccccc; padding: 10px; ">
											  <img class="image" id="view" 
											  		style="width: 200px; height: 200px; " 
											  		src=''>
										</div>						     
										
										<div style="padding: 10px 0px; ">		
										    <input id="img" name="upImg" style="font-size:14px; line-height:50px; height: 30px;" type="file" onchange="previewImage(this)" />
										</div>
										
									</div>
			
							</td>
						</tr>
						<tr>
							<td>
								<hr>
							</td>
						</tr>
						<tr>
							<td align="left"> 
								<div  style="padding: 20px 0px;">
									<span style="line-height: 30px;font-size: 18px;" >
										版块类型：
									</span>
									<select name="clubTypeId" style="line-height: 32px; height: 32px;width:200px;font-size: 18px;" >
										<c:forEach var="type" items="${ adClubEditBean.typeList }">
											<c:choose>
												<c:when test="${ type.clubTypeId==adClubEditBean.club.clubTypeId }">
													<option selected="selected" value="${ type.clubTypeId }" style="line-height: 30px; font-size: 18px;">${ type.clubType }</option>		
												</c:when>
												<c:otherwise>
													<option value="${ type.clubTypeId }" style="line-height: 30px; font-size: 18px;">${ type.clubType }</option>		
												</c:otherwise>
											</c:choose>					
										</c:forEach>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td align="left"> 
								<div  style="padding: 20px 0px;">
									<span style="line-height: 30px;font-size: 18px;" >
										版块名称：
									</span>
									<input style="line-height: 30px;width:200px;" type="text" name="clubName" value="${ adClubEditBean.club.clubName }"/>
								</div>
							</td>
						</tr>
						<tr>
							<td align="left">
			
									<div>
										<div>
											<span style="line-height: 30px;font-size: 18px;">描述：</span>
										</div>
										<textarea name="clubDescribe" rows="10" cols="10" style="width: 100%;">${ adClubEditBean.club.clubDescribe }</textarea>
									</div>
								
							</td>
						</tr>
						
						<tr>
							<td>
								<hr>
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<div style="padding: 20px 0px; ">
									<img style="cursor:pointer;" alt="保存" src="img/save.png" onclick="doPost();" />
								</div>
							</td>
						</tr>
					
					</table>
			
			</form>
			
		</div>
		
		<br>
		
		<c:if test="${ param.clubName!=null }">
		
			<div style="width: 700px; border: 1px gray solid; padding: 50px;">
			
				<div>
					<span style="line-height: 50px;font-size: 24px;font-family: 微软雅黑;">设置版主：</span>
				</div>
				<hr>
			
				<div style="margin: 20px 0px;">
					<form action="<c:url value="/AdUpdateServlet?op=addClubAdmin" />" method="post">
					
						<input  type="hidden" name="clubName" value="${ adClubEditBean.club.clubName }" />
						
						<span style="line-height: 30px;width:200px;font-size: 18px;">添加版主：</span>
						<input style="line-height: 30px;width:200px;font-size: 18px;" type="text" name="userName" />
						<input style="line-height: 30px;width:50px;font-size: 18px;" type="submit" value="添加"/>
						
					</form>
				</div>
				
				<div>
					<div>
						<span style="line-height: 30px;font-size: 18px;">当前版主：</span>
					</div>
					<div class="table" >
						<table  border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><span style="line-height: 30px;font-size: 18px;font-family: 微软雅黑;">用户名</span></td>
								<td><span style="line-height: 30px;font-size: 18px;font-family: 微软雅黑;">编辑</span></td>
							</tr>
							
							<c:forEach var="admin" items="${ adClubEditBean.adminList }">
								<tr>
									<td>
										<a href="#">
											<span style="line-height: 30px;font-size: 18px;font-family: 微软雅黑;"> ${ admin.userName } </span>
										</a>
									</td>
									<td>
										<a href="<c:url value="/AdUpdateServlet?op=deleteClubAdmin&userName=${ admin.userName }&clubName=${ adClubEditBean.club.clubName }" />">
											<span style="line-height: 30px;font-size: 18px;font-family: 微软雅黑;">删除</span>
										</a>
									</td>
								</tr>
							</c:forEach>
							
						</table>
					</div>
				</div>
				
			</div>
		</c:if>
	
	</div>
		

</div>

<br>
<br>

<script>
var imgView = document.getElementById('view');  
imgView.src='img/club_icon/${ adClubEditBean.club.clubIcon }'+'?st='+Math.random();
</script> 

<c:if test="${ requestScope.msg!=null }">
	<script>
		alert("${requestScope.msg}");
	</script> 
</c:if>



</body>
</html>
















































