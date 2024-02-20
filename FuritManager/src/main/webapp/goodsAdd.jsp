<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品添加</title>
</head>
<link rel="stylesheet" href="css/goodmanage.css"/>
<link rel="stylesheet" href="css/all.css"/>
<body  style="text-align: center;">
<div style="text-align: center;
	position: absolute;
	width: 400px;
	height: 230px;
	background-color: #ffffff;
	margin-left: 50em;
	margin-top: 20em;
	border-radius: 30px 30px 30px 30px">
	<p style="font-size: 20px;">添加水果</p>
<form id="AddForm" action="FuritServlet?type=add" method="post">
商品编号：<input id="Gid" type="text" name="gid"><br>
商&nbsp;&nbsp;品&nbsp;&nbsp;名：<input id="Gname" type="text" name="gname"><br>
单位：<select name="gunit">
		<option value="公斤">公斤</option>
		<option value="斤">斤</option>
	</select>  <br>
单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：<input id="Gp" type="text" name="gprice"><br>
库&nbsp;&nbsp;存&nbsp;&nbsp;量：<input id="Gnumber" type="text" name="grem"><br>
<button  type="button" id="AddBtn" class="button1">添加</button>
</form>
<a href="goodsManage.jsp"><button class="button2">返回主页</button></a>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$("#AddBtn").click(function() {
		var Gid = $("#Gid").val();
		var Gname = $("#Gname").val();
		var Gp = $("#Gp").val();
		var Gnumber = $("#Gnumber").val();
		if (!isEmpty(Gid)&&!isEmpty(Gname)&&!isEmpty(Gp)&&!isEmpty(Gnumber)) {
			$("#AddForm").submit();
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

