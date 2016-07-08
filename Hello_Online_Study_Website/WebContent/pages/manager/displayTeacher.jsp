<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>

	<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
		<%@ include file="/WEB-INF/include/manager-info.jsp" %>
	</div>

	<div id="main">
	<s:form>
	<table>
	<tr>
		<th>用户名</th>
		<th>性别</th>
		<th>真是姓名</th>
		<th>Email</th>
		<th>注册时间</th>
		<th>编辑</th>
		<th>删除</th>
	</tr>
	<s:iterator value="#request.userBill"><tr>
	
		<td><s:property value="username"/></td>
		<td><s:property value="sex"/></td>
		<td><s:property value="realname"/></td>
		<td><s:property value="email"/></td>
		<td><s:date name="dateCreated" format="yyyy-MM-dd HH:mm"/></td>
		<td><s:a href="editTeacherAction.action?id=%{id}">编辑</s:a></td>
		<td><s:a href="deleteTeacherAction.action?id=%{id}">删除</s:a></td>
	</tr>
	</s:iterator>
	<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td><a href="pages/manager/addTeacher.jsp">添加</a></td>
	</table>
	</s:form>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>