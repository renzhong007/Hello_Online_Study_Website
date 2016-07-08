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
			<th style="width: 800px;">回复</th> 
			<th style="width: 120px;">回复人</th>
			<th style="width: 120px;">回复时间</th>
			<th style="width: 120px;">删除</th>
		</tr>
		<s:if test="#request.listAllReply==null||#request.listAllReply.empty">
			<tr>
				<td colspan="4">尚未有人回帖<s:a action="thread_listAllThreadAction.action">返回上一层</s:a></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="#request.listAllReply">
				<tr>
					<td style="text-align: left;"><s:property value="content"/></td>
					<td><s:property value="author.username"/></td>
					<td><s:date name="dateCreated" format="yyyy-MM-dd"/></td>
					<td><s:a href="reply_deleteReplyAction.action?id=%{id}">删除</s:a></td>
				</tr>
			</s:iterator>
				<tr>
					<td></td>
					<td></td>
					<td colspan="2"><s:a action="thread_listAllThreadAction.action">返回上一层</s:a></td>
				</tr>
		</s:else>
	</table>
	</s:form>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>