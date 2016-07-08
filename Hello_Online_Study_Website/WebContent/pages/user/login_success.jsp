<%@page import="com.superz.study.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员个人中心</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function(){
		var $stu_exam=$(".stu_exam");
		var $stu_1=$("#stu_1");
		var $stu_2=$("#stu_2");
	
		$stu_exam.toggle(function(){
			$(this).text("自我检测");
			$stu_1.show();
			$stu_2.hide();
		},
		function(){
			$(this).text("检测成绩");
			$stu_1.hide();
			$stu_2.show();
		});
		
		$("#file_upload")
		.change(
				function() {
					var pattern = /(\.*.txt$)/;
					if (!pattern.test($(this).val())) {
						alert("系统仅支持txt格式的文件！");
					} 
				});
	});
</script>
<style type="text/css">
#que_2{
	margin: auto;
	margin-bottom: 0px;
	margin-top: 0px;

	height:180px;
	text-align: center;
}
#que_1{
	margin: auto;
	margin-bottom: 0px;
	margin-top: 0px;

	height:180px;
	text-align: center;
}
#que_2 .que{
	margin: auto;
	margin-bottom: 20px;
	margin-top: 20px;

	/* height:230px; */
	text-align: center;
}
#que_1 .que{
	margin: auto;
	margin-bottom: 20px;
	margin-top: 20px;

	/* height:230px; */
	text-align: center;
}
#stu_2 .tab{
	margin-top: 50px;
}

#stu_1 .tab{
	margin-top: 20px;
}

#que_1 .tab{
	margin-top: 20px;
}



</style>
</head>

<body>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
	</div>

	<div id="main">
	<div>
	
		<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
		
	</div>

	<div id="bottom">
	
	</div>
</body>

</html>