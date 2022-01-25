<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<style>
ul.menu {
	padding-top: 50px;
	display: inline-block;
	margin-left: 10px;
	margin-right: 10px;
	list-style-type: none;
	white-space: nowrap;
	border: rgb(100, 100, 00) solid 0px;
	border-radius: 5px;
	padding: 5px 5px;
	background: transparent;
}

ul.menu ul {
	display: none;
	position: absolute;
	top: 100%;
	left: 0;
	background: transparent;
	border: rgb(100, 100, 00) solid 0px;
	margin: 0px;
	padding: 0;
	border-radius: 2px;
	list-style-type: none;
}

ul.menu ul li {
	display: block;
	border: none;
	border-top: #333 solid 1px;
}

ul.menu ul li:first-child {
	border: none;
}

ul.menu li {
	position: relative;
	display: inline-block;
	zoom: 1;
	border-left: #333 solid 1px;
}

ul.menu li:first-child {
	border: none;
}

ul.menu li a {
	display: block;
	padding: 5px 10px;
	text-decoration: none;
	color: white;
	text-decoration-style: solid;
}

ul.menu li a:hover {
	border: rgb(70,130,180) solid 1px;
	background: black;
	border-radius: 5px;
}

ul.menu li:hover ul {
	display: block;
	zoom: 1;
}

ul.menu ul li:hover ul {
	display: inline-block;
	position: absolute;
	top: 0;
	left: 100%;
	background: black;
}
</style>
</head>

<body style = "bottom: 0px;">
	<table align="center">
		<tr width=100%>
			<td align="center">
				<ul class="menu">
					<li><a class="menu" href="/TierraMedia/rindex.jsp">Tierra Media</a></li>
					<li><a class="item" href="/TierraMedia/contacto.jsp">Contacto</a>
					<li><a class="item" href="/TierraMedia/nosotros.jsp">Nosotros</a>
					<li><a class="item" href="/TierraMedia/redes.jsp">Redes sociales</a></li>
				</ul>

			</td>
		</tr>
	</table>
	<div class="footer-copyright text-center py-3">©2022 Copyright</div>
</body>

</html>