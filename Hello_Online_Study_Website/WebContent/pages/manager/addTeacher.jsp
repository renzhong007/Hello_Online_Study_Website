<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会员信息编辑</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
	<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
		<%@ include file="/WEB-INF/include/manager-info.jsp" %>
	</div>

	<div id="main">
	<div style="margin-top: 30px">
	<s:form action="addTeacherAction.action" theme="simple">
	<br>
			<br>
			<center>添加用户</center>
			<br>
			<table>
				<tr>
					<td>用户名：</td>
					<td><s:textfield name="username"></s:textfield></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><s:password name="password" value=""></s:password></td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><s:textfield name="email" value=""></s:textfield></td>
				</tr>

				<tr>
					<td>真实姓名：</td>
					<td><s:textfield name="realname" value=""></s:textfield></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td> <s:radio list="#{'男':'男','女':'女' }" name="sex"></s:radio></td>
				</tr>
				<tr>
						<td colspan="2"><s:submit value="提交"></s:submit></td>
				</tr>
			</table>
		
		</s:form>
	</div>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>