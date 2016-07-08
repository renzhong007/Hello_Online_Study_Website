<%@page import="com.superz.study.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员个人中心</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>

<body>


	<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
		<%@ include file="/WEB-INF/include/manager-info.jsp" %>
	</div>

	<div id="main">
	<div>
		<s:form action="quest_addAnswerAction.action" method="post" theme="simple">
		<s:hidden name="id" value="%{#request.answerList[0].question.id}"/>
		<table>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>
					<img alt="" src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}${requestScope.answerList[0].question.student.img}" style="width: 100px;height: 100px;"><br/>
					<s:property value="#request.answerList[0].question.student.username"/>
				</td>
				<td colspan="3" style="height: 150px">
					<s:property value="#request.answerList[0].question.content"/>
				</td>
				<td></td>
			</tr>
			<s:iterator value="#request.answerList">
			
				<s:if test="teacher.id==#request.answerList[0].question.student.id">
					<tr>
						<td>
							<img alt="" src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}<s:url value='%{teacher.img}'/>" style="width: 100px;height: 100px;"><br>
							<s:property value="teacher.username"/>
						</td>
						<td colspan="3">
							<s:property value="content"/>
						</td>
						<td></td>
					</tr>
				</s:if>
				
				<s:else>
					<tr>
						<td></td>
						<td colspan="3">
							<s:property value="content"/>
						</td>
						<td>
							<img alt="" src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}<s:url value='%{teacher.img}'/>" style="width: 100px;height: 100px;"><br>
							<s:property value="teacher.username"/>
						</td>
					</tr>
				</s:else>
			</s:iterator>
			<tr>
				<td colspan="4"><s:textarea  style="width: 700px;height: 100px;resize: none;" placeholder="请输入回复内容"  name="content"></s:textarea></td>
				<td><s:submit value="回复"></s:submit></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><s:a action="quest_displayAllQuestionAction.action">返回上一层</s:a></td>
			</tr>
		</tbody>
		</table>
		</s:form>
	</div>

	</div>

	<div id="bottom">
	
	</div>
</body>

</html>