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
	<%
		int i = 0;
	%>
	<s:form>
	<table>
	<tr>
		<th style="width: 10px">题号</th>
		<th style="width: 1500px">题目</th>
		<th style="width: 10px">科目</th>
		<th style="width: 10px">编辑</th>
		<th style="width: 10px">删除</th>
	</tr>
	<s:iterator value="#request.itemList">
	<tr>
		<td><%=++i %></td>
		<td style="text-align: left;"><s:property value="title"/></td>
		<td><s:property value="#request.allSubject[num].name"/></td>
		<td><s:a href="item_editItemAction.action?id=%{id}&num=%{#request.num}">编辑</s:a></td>
		<td><s:a href="item_deleteItemAction.action?id=%{id}&num=%{#request.num}">删除</s:a></td>
	</tr>
	</s:iterator>
	<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td><s:a href="item_toAddItemAction.action?num=%{#request.num}">添加</s:a></td>
	</table>
	</s:form>
	<div id="page_nav">
		<s:if test="#request.num>0">
			<s:a href="item_displayItemAction.action?num=%{#request.num-1}">上一科是《<s:property value="%{#request.allSubject[num-1].name}"/>》</s:a>
		</s:if>

		<s:if test="#request.num<#request.sub_list_size">
			<s:a href="item_displayItemAction.action?num=%{#request.num+1}">下一科是《<s:property value="%{#request.allSubject[num+1].name}"/>》</s:a>
		</s:if>
	</div>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>