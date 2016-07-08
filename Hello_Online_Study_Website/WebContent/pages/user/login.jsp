<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>会员登录页面</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript">
	$(function() {
		var flag = [ "", "" ];
		var flag2 = [ false, false ];
		var $errorMsg = $(".errorMsg");
		var $username = $("[name='username']");
		var $password = $("[name='password']");
		//验证用户名
		$username.blur(function() {
			
			if (this.value == "") {
				flag[0] = "用户名不能为空！";
			} else {
				flag[0] = "";
				flag2[0] = true;
			}
			for (var i = 0; i < flag.length; i++) {
				if (flag[i] != "") {
					$errorMsg.text(flag[i]).show();
					return false;
				} else {
					$errorMsg.text("").show();
				}
			}
		});
		//验证密码
		$password.blur(function() {
			if (this.value == "") {
				flag[1] = "用户密码不能为空！";
			} else {
				flag[1] = "";
				flag2[1] = true;
			}
			for (var i = 0; i < flag.length; i++) {
				if (flag[i] != "") {
					$errorMsg.text(flag[i]).show();
					return false;
				} else {
					$errorMsg.text("").show();
				}
			}
		});
		//提交按钮
		$("#sub_btn").click(function() {
			//alert(flag);
			//if($errorMsg.text()!=""){
			for (var i = 0; i < flag.length; i++) {
				if (flag[i] != "") {
					$errorMsg.text(flag[i]).show();
					return false;
				}
			}
		});
	});
</script>
</head>

<body>


	<div id="login_header">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎登录</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>Hello!考研会员</h1>
						<a href="pages/user/regist.jsp">立即注册</a>
					</div>
					<div class="msg_cont">
						<b></b> <span class="errorMsg">${msg==null?"请输入用户名和密码":msg}<%--  <%=request.getAttribute("msg") == null?"请输入用户名和密码":request.getAttribute("msg") %> --%></span>
					</div>
					<div class="form">
						<s:form action="user_loginAction.action" theme="simple">
							<s:label>用户名称：</s:label>
							<s:textfield cssClass="itxt" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"></s:textfield><br /> <br />
							<s:label>用户密码：</s:label>
							<s:password cssClass="itxt" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"></s:password><br /> <br />
							<s:submit value="登录" id="sub_btn"></s:submit>
						</s:form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">

	</div>
</body>

</html>