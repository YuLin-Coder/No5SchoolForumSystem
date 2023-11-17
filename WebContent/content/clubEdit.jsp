<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/public/top.jsp" />

<style>
#preview, .image{  
    width:200px;  
    height:200px;  
}  
#preview{  
    border:1px solid gray;  
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

<div style="width: 960px;background-color: white; padding:0px 50px;">


<div style="width: 960px; padding: 20px 0px;" >

	<div style="float: left;width: 20px;height: 20px;padding: 0 5px;margin: 0px;">
		<a href='<c:url value="/ContentServlet?op=home" />'>
			<img alt="论坛" src="img/home.png" width="20" height="20" />
		</a>
	</div>
	
		<div style="float: left;width: 20px;height: 20px;padding: 0px;margin: 0px; text-align: center;">
			<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		</div>
	
	<div style="float: left;line-height: 20px;margin: 0px; text-align: center;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=clubList" />'>版块</a>
		</span>
	</div>
	
		<div style="float: left;width: 20px;height: 20px;padding: 0px;margin: 0px; text-align: center;">
			<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		</div>
		
	<div style="float: left;line-height: 20px;margin: 0px; text-align: center;">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: gray;">
			<a href='<c:url value="/ContentServlet?op=club&clubName=${ clubEditBean.club.clubName }" />'> ${ clubEditBean.club.clubName } </a>
		</span>
	</div>
		
		<div style="float: left;width: 20px;height: 20px;padding: 0px;margin: 0px; text-align: center;">
			<span style="padding: 0px;font-family: 黑体;font-size: 18px;">&gt;</span>
		</div>
	
	<div style="float: left;line-height: 20px; text-align: left;margin: 0px; width:300px; overflow: hidden;text-overflow:ellipsis; ">
		<span style="padding: 0px;font-family: 黑体;font-size: 18px;font-style: oblique;color: black; overflow: hidden;white-space:nowrap;text-overflow:ellipsis; ">
			版块编辑
		</span>
	</div>
	<div style="clear: both;"></div>

</div>

<form action='<c:url value="/FormServlet?op=editClub" />' name="form" method="post" enctype="multipart/form-data">
						
	<div style="width: 700px;">
	
		<table style="width: 100%;">
		
			<tr>
				<td align="left"> 
					<span style="line-height: 50px;font-size: 24px;font-family: 微软雅黑;">
						${ clubEditBean.club.clubName } 	
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<hr>
				</td>
			</tr>
			<tr>
			
				<td align="left">
				
						<input type="hidden" name="currClubName" value="${ clubEditBean.club.clubName }" />
						<input type="hidden" name="clubIcon" value="${ clubEditBean.club.clubIcon }" />
						<input type="hidden" id="state" name="url" value="${ clubEditBean.url }" />
					
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

						<div style="padding: 20px 0px;">
							<div>
								<span style="line-height: 30px;">描述：</span>
							</div>
							<textarea name="clubDescribe" rows="10" cols="10" style="width: 100%;">${ clubEditBean.club.clubDescribe }</textarea>
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
	
	</div>

</form>

<br>
<br>

</div>

<script>

var imgView = document.getElementById('view');  
imgView.src='img/club_icon/${ clubEditBean.club.clubIcon }'+'?st='+Math.random();

</script> 

<jsp:include page="/public/foot.jsp" />









































