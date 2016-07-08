<%@page import="java.util.Iterator"%>
<%@page import="com.superz.study.bean.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%-- <script type="text/javascript">

	function testA(){
		window.location = "${pageContext.request.contextPath}/thread_listThreadAction.action?pageNo=1";
	}

</script> --%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <%@ include file="/WEB-INF/include/base.jsp" %> --%>
</head>
<!--  onload="testA()" -->
<body>

	
	
	<%
		response.sendRedirect(request.getContextPath()+"/thread_listThreadAction.action?pageNo=1");
	%>
	
</body>
</html>