 <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>用户登录</title>
</head>
<link rel="stylesheet" href="css/admin.css"/>
<link rel="stylesheet" href="css/all.css"/>
<body>
	<div style="text-align: center;
	position: absolute;
	width: 400px;
	height: 240px;
	background-color: #ffffff;
	margin-left: 50em;
	margin-top: 20em;
	border-radius: 30px 30px 30px 30px">
		<p style="font-size: 20px;">用户登录</p>
		<form action="UserServlet?type=login" method="post" id="loginForm">
			用户名：<input type="text" name="uname" id="uname"><br> <span
				id="namemsg" style="font-size: 12px; color: red">&nbsp;</span> <br>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd"
				id="upwd"><br> <span id="pwdmsg"
				style="font-size: 12px; color: red">&nbsp;</span> <br>
			<button type="button" id="loginBtn" class="button1">登录</button>
			<a href="reg.html"><button type="button" class="button2">注册用户</button></a>
			<a href="pwdReset.html"><button type="button" class="button3">忘记密码</button></a>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$("#loginBtn").click(function() {
		var uname = $("#uname").val();
		var upwd = $("#upwd").val();
		if (!isEmpty(uname) && !isEmpty(upwd)) {
			$("#loginForm").submit();
		} else {
			if (isEmpty(uname) && isEmpty(upwd)) {
				$("#namemsg").html("用户姓名不能为空");
				$("#pwdmsg").html("密码不能为空");
			} else {
				if (isEmpty(uname)) {
					//赋值给span，html（）方法
					$("#namemsg").html("用户姓名不能为空");
					$("#pwdmsg").html("&nbsp;");
				} else {
					$("#namemsg").html("&nbsp;");
					$("#pwdmsg").html("密码不能为空");
				}
			}
		}
	});

	/**
	 * 判断是否为空
	 *   如果为空，返回true
	 *   如果不为空，返回false
	 * @param str
	 * @returns {boolean}
	 */
	function isEmpty(str) {
		if (str == null || str.trim() == "") {
			return true;
		} else
			return false;
	}
</script>
</html>
