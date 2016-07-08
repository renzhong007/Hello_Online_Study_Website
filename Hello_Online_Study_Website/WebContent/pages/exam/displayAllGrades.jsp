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
				<table>
					<tr>
						<td>时间</td>
						<td>科目</td>
						<td>成绩</td>
					</tr>
					<s:iterator value="#request.grades">
						<tr>
							<td><s:date name="date" format="yyyy-MM-dd HH:mm"/></td>
							<td><s:property value="subject.name"/></td>
							<td><s:property value="grade"/></td>
						</tr>
					</s:iterator>
				</table>
	</div>

	<div id="bottom">
	
	</div>
</body>
</html>