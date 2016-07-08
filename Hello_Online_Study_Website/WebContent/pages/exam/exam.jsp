<%@page import="java.util.Iterator"%>
<%@page import="com.superz.study.bean.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#submit").click(function() {
			if (!confirm("确定提交成绩吗?")) {
				return false;
			} 
		});
		$(":radio").click(function(){
			//alert($(this).val());
			$(".option").text($(this).val());
		});
	});
</script>
</head>
<body>
	<%
		int i =0;
	
	%>
	<form action="exam/ExamServlet?method=getGrade" method="post"
		style="border: 1px solid;">
		<c:forEach items="${sessionScope.itemBill.bill }" var="item">
			<div>
				<table align="center" width="60%">
					<tr>
						<td width="10px"><%=++i%>.</td>
						<td>${item.value.title }</td>
					</tr>
					<tr>
						<td>
							<c:if test="${empty requestScope.grade }">
								<input type="radio" name="<%=i%>" value="A" />
							</c:if>
						</td>
						<td>${item.value.optionA }</td>
					</tr>
					<tr>
						<td>
							<c:if test="${empty requestScope.grade }">
								<input type="radio" name="<%=i%>" value="B" />
							</c:if>
						</td>
						<td>${item.value.optionB}</td>
					</tr>
					<tr>
						<td>
							<c:if test="${empty requestScope.grade }">
								<input type="radio" name="<%=i%>" value="C" />
							</c:if>
						</td>
						<td>${item.value.optionC}</td>
					</tr>
					<tr>
						<td>
							<c:if test="${empty requestScope.grade }">
								<input type="radio" name="<%=i%>" value="D" />
							</c:if>
						</td>
						<td>${item.value.optionD}</td>
					</tr>
					<c:if test="${!empty requestScope.grade }">
						<tr>
							<td colspan="2">
								正确答案是：
								<span style="color: red;">
								${item.value.answer }
								</span>
								&ensp;&ensp;您选择的是：
								<span style="color: red;">
								${item.value.result }
								</span>
							</td>
						</tr>
					</c:if>
				</table>
			</div>
			<input type="hidden" value="${item.value.answer }" name="answer<%=i %>">
		</c:forEach>
		<c:if test="${!empty requestScope.grade }">
			<h1><font color="red">${requestScope.grade }</font></h1>
			<%@ include file="/WEB-INF/include/manager-info.jsp" %>
		</c:if>
		<c:if test="${empty requestScope.grade }">
			<input type="hidden" value="${item.value.itemCount }">
			<input type="submit" id="submit" value="提交并查看成绩" >
		</c:if>

	</form>


</body>
</html>