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
	<div style="border: 1px black solid;width: 400px;height: 300px;margin-top: 70px;">
	<table style="margin-top: 20px;">
	<s:form action="exam_addSubjectAction.action" theme="simple">
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><s:textfield name="subjectName"  cssStyle="width: 200px;"></s:textfield></td>
			<td><s:submit value="创建课程" id="addSubject"></s:submit></td>
		</tr>
	</s:form>		
		</div>
		<div>
		<!-- 文件上传 -->
		<s:form action="item_uploadAction.action" enctype="multipart/form-data" method="post" validate="true" theme="simple">
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">选择上传科目：<s:select list="#request.allSubject" listKey="id" listValue="name" name="sub_id" cssStyle="width:200px;" label="选择上传科目"></s:select></td>
				</tr>
				<tr>
					<td><s:file name="fileText" label="批量上传试题" id="file_upload" cssStyle="width: 200px;"></s:file></td> 
					<td><s:submit value="开始上传"></s:submit></td> 
				</tr>
		</s:form>
		
	</div>
	</table>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>