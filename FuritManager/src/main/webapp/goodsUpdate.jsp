<%@ page import="bean.Furit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品添加</title>
</head>
<link rel="stylesheet" href="css/goodmanage.css"/>
<link rel="stylesheet" href="css/all.css"/>
<body style="text-align: center;">
<div style="text-align: center;
	position: absolute;
	width: 400px;
	height: 230px;
	background-color: #ffffff;
	margin-left: 50em;
	margin-top: 20em;
	border-radius: 30px 30px 30px 30px">
	<p style="font-size: 20px;">修改商品</p>
	<form id="UpForm" action="FuritServlet?type=update" method="post">
		商品编号：<input type="text" id="Gid" readonly name="gid" value="${goods.gid }"><br>
		商&nbsp;&nbsp;品&nbsp;&nbsp;名：<input type="text" id="Gname" name="gname"
			value="${goods.gname }"><br>
			
		<!-- select元素中，通常value存储id，显示值展示名称。这里进行简单化处理，value和显示值均用名称。-->
		单位：<select name="gunit">
			<option ${goods.unit=='公斤'?"selected":"" } value="公斤">公斤</option>
			<option ${goods.unit=='斤'?"selected":"" } value="斤">斤</option>
		</select> <br>
		 单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：<input
			type="text" id="Gp" name="gprice" value="${goods.price }"><br>
		库&nbsp;&nbsp;存&nbsp;&nbsp;量：<input type="text" id="Gnumber" name="grem"
			value="${goods.remain }"><br>
			<button id="UpBtn" type="button" class="button1">修改</button> 
	</form>
	<a href="goodsManage.jsp"><button class="button2">返回主页</button></a>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$("#UpBtn").click(function() {
		var Gid = $("#Gid").val();
		var Gname = $("#Gname").val();
		var Gp = $("#Gp").val();
		var Gnumber = $("#Gnumber").val();
		if (!isEmpty(Gid) && !isEmpty(Gname)&& !isEmpty(Gp)&& !isEmpty(Gnumber)) {
			$("#UpForm").submit();
		} else {
			alert("请填写完整")
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

