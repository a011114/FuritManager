<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<link rel="stylesheet" href="css/goodmanage.css"/>
<link rel="stylesheet" href="css/all.css"/>
<style>
table, th, td {
	border: 1px solid #000;
	border-collapse: collapse;
	border-spacing: 0;
}
/* css注释：只对table td标签设置红色边框样式 */
</style>
</head>
<body>
    <div style="text-align: center;
	position: absolute;
	height: auto;
	width: 400px;
	min-height: 230px;
	background-color: #ffffff;
	margin-left: 50em;
	margin-top: 20em;
	border-radius: 30px 30px 30px 30px;
	clear:both;">
	<a href="goodsAdd.jsp"><button class="button2">添加商品</button></a>
	<table  style="margin: auto;">
		<tr>
			<th>序号</th>
			<th>商品名</th>
			<th>单位</th>
			<th>单价</th>
			<th>库存量</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${glist }" var="goods">
			<tr>
				<td>${goods.gid }</td>
				<td>${goods.gname }</td>
				<td>${goods.unit }</td>
				<td>${goods.price }</td>
				<td>${goods.remain }</td>
				<td>${goods.status==1?"正常":"下架" }</td>
				<td><a href="FuritServlet?type=toUpdate&gid=${goods.gid }"><button class="button1">修改</button></a>
				&nbsp;&nbsp;
					<a href="FuritServlet?type=delete&gid=${goods.gid }"onClick="del(${goods.gid })"><button class="button3">删除</button></a>
					</td>
			</tr>
		</c:forEach>
	</table>
	${ empty glist? "暂无商品数据":"" }<br>
	
	<a href="FuritServlet?type=showAll"><button class="button1">查看全部商品</button></a>
	<a href="UserServlet?type=logout"><button class="button3">退出系统</button></a>
	</div>
</body>
<script type="text/javascript">
	function del(gid) {
		var isDel = confirm('确认删除？');
		//选了“否”
		if(!isDel){
			//取消超链接的默认行为（取消跳转到href指定地址）
			event.preventDefault();
			return false;
		}
	}
</script>
</html>