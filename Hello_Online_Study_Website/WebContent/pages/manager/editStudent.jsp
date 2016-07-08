<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会员信息编辑</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
#main .update_left{
	height:150px;
	width:450px;
	margin: 20px;
	float: left;
	margin-right:10px;
	margin-top:20px;
	margin-bottom:0px;
	/* border: 1px #e3e3e3 solid; */
	text-align: center;
}
#main .update_right{
	height:150px;
	width:450px;
	margin: 20px;
	float: left;
	margin-left:10px;
	margin-top:20px;
	margin-bottom:0px;
	/* border: 1px #e3e3e3 solid; */
	text-align: center;
}
.user_img {
	margin-top:20px;
	margin-bottom:20px;
	height:150px;
	width:150px;
}
.user_img_div{
	width: 150px;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#img_update").change(function(){
			var $imgPreview = $("#imgPreview");
			var $img_update = $("#img_update");
			var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
			if(!pattern.test($img_update.val())){
				alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
			}else{
				alert(URL.createObjectURL(this.files[0]));
				var path = URL.createObjectURL(this.files[0]);
				$imgPreview.attr("src",path);
			}			
		});		
	});
</script>
</head>
<body>
	<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
		<%@ include file="/WEB-INF/include/manager-info.jsp" %>
	</div>

	<div id="main">
	<s:form action=" updateStudentAction.action" theme="simple" enctype="multipart/form-data" validate="true" >
	<s:hidden name="id"></s:hidden>
			<div class="user_img_div" >
				<img class="user_img" alt="" src="${pageContext.request.contextPath}${requestScope.user.img }" id="imgPreview"/><br>
			</div>
			<div class="update_left">
				<table>
					<tr>
						<td>用户名：</td>
						<td><s:textfield name="username"></s:textfield></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><s:password name="password" showPassword="true" /></td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td><s:textfield name="email"></s:textfield></td>
					</tr>
				</table>
			</div>
			<div class="update_right">
				<table>
					<tr>
						<td>头像：</td>
						<td><s:file name="imgUpload" cssStyle="width:150px;" id="img_update"></s:file></td>
					</tr>
					<tr>
						<td>真实姓名：</td>
						<td><s:textfield name="realname"></s:textfield></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><s:radio list="#{'男':'男','女':'女' }" name="sex"></s:radio></td>
					</tr>
				</table>
			</div>
		<center><input type="submit" value="提交"></center>
		</s:form>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>