<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
.login_form {
	height: 420px;
	margin-top: 25px;
}
</style>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		var flag = [ "", "", "", "", "" ];
		var flag2 = [ false, false, false, false, false ];
		var $errorMsg = $(".errorMsg");
		//$errorMsg.text("请输入用户信息！").hide();
		var $username = $("[name='username']");
		var $password = $("[name='password']");
		var $repwd = $("[name='repwd']");
		var $email = $("[name='email']");
		var $code = $("[name='kaptchafield']");
		var regName = /^[a-z0-9\u2E80-\u9FFF_-]{3,16}$/; ///^[a-z0-9_-\u2E80-\u9FFF]+{3,16}$/; 
		var regPassword = /^[a-z0-9_-]{6,18}$/;
		var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		//验证用户名
		$username.blur(function() {
			var url = "client/UserServlet?method=valiateUsername";
			var val = this.value;
			val = $.trim(val);
			var args = {
				"username" : val,
				"time" : new Date()
			};
			if (this.value == "") {
				flag[0] = "用户名不能为空！";
			} else if (!regName.test(this.value)) {
				flag[0] = "用户名格式错误！";
			} else{
				$.post(url, args, function(data) {
					//使用 javascript 局部更新当前页面的内容
					if (data == "0") {
						flag[0] = "";
						flag2[0] = true;
						$errorMsg.text(flag[0]);
					} else if (data == "1") {
						flag[0] = "用户名已占用！";
						$errorMsg.text(flag[0]);
					}
				}, "json");
			}
			
			$errorMsg.text(flag[0]);
		}); 
		//验证密码
		$password.blur(function() {
			if (this.value == "") {
				flag[1] = "用户密码不能为空！";
			} else if (!regPassword.test(this.value)) {
				flag[1] = "用户密码格式错误！";
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
		//验证确认密码
		$repwd.blur(function() {
			if (this.value == "") {
				flag[2] = "确认密码不能为空！";
			} else if (this.value != $password.val()) {
				flag[2] = "密码不一致";
			} else {
				flag[2] = "";
				flag2[2] = true;
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
		//验证邮箱
		$email.blur(function() {
			if (this.value == "") {
				flag[3] = "邮箱不能为空！";
			} else if (!regEmail.test(this.value)) {
				flag[3] = "请输入正确的的邮箱！";
			} else {
				flag[3] = "";
				flag2[3] = true;
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
		//验证验证码
		$code.blur(function() {
			if (this.value == "") {
				flag[4] = "验证码不能为空！";
			} else {
				flag[4] = "";
				flag2[4] = true;
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
			/* for (var i = 0; i < flag2.length; i++) {
				alert(flag2[i]);
			} */
			//if($errorMsg.text()!=""){
			for (var i = 0; i < flag.length; i++) {
				//alert($email.val());
				if (flag[i] != "" || flag2[i] == false) {
					$errorMsg.text("请填写完整用户信息！").show();
					return false;
				}
			}
			//return false;
			//}
		});
		$(function() {
			$("#kaptchaImage").click(
					function() {
						$(this).attr(
								"src",
								"Kaptcha.jpg?"
										+ Math.floor(Math.random() * 100));
					});
		});
	});
</script>
</head>

<body>

	<div id="login_header">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎注册</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>注册会员</h1>
						<span class="errorMsg">${msg}<%-- <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %> --%></span>
					</div>
					<div class="form">
						<form action="client/UserServlet?method=regist" method="post">
							<label>用户名称：</label> 
							<input value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" /> <br /> <br /> 
							<label>用户密码：</label> 
							<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" /> <br /> <br />
							<label>确认密码：</label> 
							<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" /><br /> <br /> 
							<label>电子邮件：</label> 
							<input value="<%=request.getParameter("email")==null?"":request.getParameter("email") %>" class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" /> <br /> <br /> 
							<label>验证码：</label>
							<input class="itxt" type="text" style="width: 150px;" name="kaptchafield" />
							<img id="kaptchaImage" alt="" src="Kaptcha.jpg" style="float: right; margin-right: 40px"> <br /> <br />
							<input type="submit" value="注册" id="sub_btn" />
					
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
	</div>
</body>

</html>