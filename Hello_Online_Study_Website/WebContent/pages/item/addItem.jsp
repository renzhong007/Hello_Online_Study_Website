<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
<div id="header">
<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
		<%@ include file="/WEB-INF/include/manager-info.jsp" %>
	</div>

	<div id="main">
	<div style="margin-top: 30px;">
	<form action="item_saveItemAction.action" method="post">
		<s:hidden name="sub_id" value="%{#request.subject.id}"/>
		<s:hidden name="num" value="%{#request.num}"/>
		<table>
			<tr>
				<td>科目：</td>
				<td><s:property value="%{#request.subject.name}"/></td>
			</tr>
			<tr>
				<td>题目：</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>选项A：</td>
				<td><input type="text" name="optionA"></td>
			</tr>
			<tr>
				<td>选项B：</td>
				<td><input type="text" name="optionB"></td>
			</tr>
			<tr>
				<td>选项C：</td>
				<td><input type="text" name="optionC"></td>
			</tr>
			<tr>
				<td>选项D：</td>
				<td><input type="text" name="optionD"></td>
			</tr>
			<tr>
				<td>答案：</td>
				<td><input type="text" name="answer"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
		
	</div>
	</div>

	<div id="bottom">
	
	</div>
	
</body>
</html>