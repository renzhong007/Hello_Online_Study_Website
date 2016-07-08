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
		<th style="width: 1000px;">题目</th> 
		<th style="width: 30px;">发帖人</th>
		<th style="width: 30px;">发布时间</th>
		<th style="width: 30px;">删除</th>
	</tr>
	<s:iterator value="#request.allThread"><tr>
	
		<td style="text-align: left;"><s:a href="reply_listAllReplyAction.action?id=%{id}" cssStyle="font-size: 16px;"><s:property value="title"/></s:a></td>
		<td><s:property value="author.username"/></td>
		<td><s:date name="createTime" format="yyyy-MM-dd"/></td>
		<td><s:a href="thread_deleteThreadAction.action?id=%{id}">删除</s:a></td>
	</tr>
	</s:iterator>
	</table>
	</s:form>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>