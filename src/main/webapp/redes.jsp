<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Redes Sociales</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">

<style>
html, body {
	height: 100%;
	width: 100%;
	padding: 0;
	margin: 0;
}

body {
	display: flex;
	flex-direction: column;
}

header {
	height: 33, 3px;
}

main {
	flex: auto;
}

footer {
	padding: 1rem 0;
	margin-top: 2rem;
}

.footer_texto {
	text-align: center;
	font-size: 1.2rem;
	font-family: 'Staatliches', cursive;
	color: #292828;
}

.navegacion {
	padding: 1rem 0 1rem 0;
	display: flex; /* FLEXBOX: Para elementos dentro de otro contenedor*/
	justify-content: center;
	gap: 2rem;
	padding-top: 20px;
}

.navegacion__enlace {
	font-family: 'Staatliches', cursive;
}

.navegacion__enlace:hover {
	margin-right: 0;
	color: #f1f1f1;
}

.navegacion__enlace--active, .navegacion__enlace {
	/* Para que cambie de color cuando paso el cursor encima*/
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

* {
	box-sizing: border-box;
}

.columna1 {
	float: left;
	width: 50%;
	padding-right: 5px;
}

.columna2 {
	float: left;
	width: 33%;
	padding-right: 5px;
	
}

.fila1{
	padding-left: 10px;
	padding-top: 5px;
}

.fila1{
	padding-left: 10px;
	padding-top: 5px;
}

.fila::after {
	content: "";
	clear: both;
	display: table;

}

img {
	width: 100%; /* Para que sea responsive */
}
</style>

<jsp:include page="/ini.jsp"></jsp:include>

</head>


<body background="img/ecole.jpg">

	<nav class="navegacion bg-dark">
		<a class="navegacion__enlace navegacion__enlace--active colorText"
			href="/TierraMedia/rindex.jsp">Tierra Media</a> <a
			class="navegacion__enlace navegacion__enlace--active colorText"
			href="/TierraMedia/contacto.jsp">Contacto</a> <a
			class="navegacion__enlace navegacion__enlace--active colorText"
			href="/TierraMedia/nosotros.jsp">Nosotros</a> <a
			class="navegacion__enlace navegacion__enlace--active colorText"
			href="/TierraMedia/redes.jsp">Redes Sociales</a>
	</nav>
	<main>

		<div class="fila1">
			<div class="columna1">
				<img src="https://picsum.photos/800/600">
			</div>
			<div class="columna1">
				<img src="https://picsum.photos/800/600">
			</div>
		</div>
		<div class="fila2">
			<div class="columna2">
				<img src="https://picsum.photos/800/600">
			</div>
			<div class="columna2">
				<img src="https://picsum.photos/800/600">
			</div>
			<div class="columna2">
				<img src="https://picsum.photos/800/600">
			</div>
		</div>


	</main>
	<footer class="footer">
		<p class="footer_texto">Turismo en la Tierra Media - Todos los
			derechos reservados 2022.</p>
	</footer>
</body>
</html>