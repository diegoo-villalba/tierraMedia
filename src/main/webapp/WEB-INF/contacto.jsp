<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nosotros</title>
<link rel="stylesheet" href="css/normalize.css">
<!-- Para que los todos los navegadores nos muestren correctamente los elementos -->
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">

<style>
html {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	padding: 0;
	margin: 0;
	display: flex;
	flex-direction: column;
	font-size: 1.6rem;
	line-height: 1.5;
}


.titulo_nosotros {
	font-size: 3rem;
	text-align: center;
	font-family: 'Staatliches', cursive;
	padding-top: 10px;
	"
}

.texto_foto {
	text-align: center;
	font-size: 1.3rem;
	font-family: Arial, Helvetica, sans-serif;
	color: rgb(61, 59, 59);
}

.comprar_titulo {
	color: #292828;
	text-align: center;
	font-size: 2.30rem;
	font-family: 'Staatliches', cursive;
	padding-top: 50px;
}

img {
	width: 100%;
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

.nosotros {
	display: grid; /* Nos permite posicionarlo en la grilla*/
	grid-template-rows: repeat(2, auto);
	padding-top: 10px;
}

@media ( min-width : 768px) {
	.nosotros {
		grid-template-columns: repeat(2, 1fr); /*Creamos 2 columnas */
		column-gap: 2rem;
	}
}

.nosotros__imagen {
	grid-row: 1/2;
	padding-right:10px;
	/* Para que al achicar la pantalla se posicione la imagen por debajo del texto */
}

@media ( min-width : 768px) {
	.nosotros__imagen {
		grid-column: 2/3;
	}
}

.bloques {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 2rem;
}

@media ( min-width : 768px) {
	.bloques {
		grid-template-columns: repeat(4, 1fr);
		/* Para que en pantalla de escritorio se vean 4 columnas y 2 columnas en cel*/
	}
}

.bloque {
	text-align: center;
}

.bloque__titulo {
	margin: 10px; /* Para el margen entre imagen y pie*/
	font-family: 'Staatliches', cursive;
}

.texto_miniaturas {
	text-align: center;
	font-size: 1.2rem;
	font-family: Arial, Helvetica, sans-serif;
	color: rgb(61, 59, 59);
	padding: 10px;
}

.contenedor {
	max-width: 120rem;
	margin: 0 auto; /* Para centrar el contenido */
}

.comprar {
	padding-left:10px;
	padding-right: 10px;
}
</style>

<jsp:include page="/ini.jsp"></jsp:include>

</head>


<body background="img/ecole.jpg">


	<nav class="navegacion bg-dark">
		<a class="navegacion__enlace navegacion__enlace--active colorText"
			href="/TierraMedia/rindex.jsp">Tierra Media</a> <a
			class="navegacion__enlace navegacion__enlace--active colorText"
			href="nosotros.html">Nosotros</a> <a
			class="navegacion__enlace navegacion__enlace--active colorText"
			href="nosotros.html">Redes Sociales</a> <a
			class="navegacion__enlace navegacion__enlace--active colorText"
			href="nosotros.html">Contacto</a>
	</nav>

	<main class="contenedor">
		<h1 class="titulo_nosotros">Nosotros</h1>
		<div class="nosotros">
			<div class="nosotros__contenido">
				<p class="texto_foto">Cras egestas mauris nisl, cursus consequat
					tellus dapibus id. Mauris vestibulum, mi id tristique sodales,
					neque tellus consequat leo, a egestas ipsum turpis nec dolor.
					Mauris vitae maximus dui. Nullam vel sem non metus aliquet aliquam.
					Donec tincidunt semper egestas. Duis eget volutpat sem. Vivamus
					fringilla dolor ut pellentesque tincidunt.</p>

				<p class="texto_foto">Etiam bibendum nec tellus ac scelerisque.
					Ut sed pretium sapien, id euismod nibh. Proin viverra varius tortor
					mattis eleifend. Suspendisse mollis enim at pharetra pretium.
					Suspendisse lobortis, sapien sit amet posuere tincidunt, eros metus
					maximus nibh, eu semper mi tortor nec mi.</p>
			</div>
			<img class="nosotros__imagen" src="/TierraMedia/img/tierramedia.jpg"
				alt="imagen nosotros">
		</div>
	</main>
	<section class="contenedor comprar">
		<h2 class="comprar_titulo">¿Por qué comprar con nosotros?</h2>
		<div class="bloques">
			<div class="bloque">
				<img class="bloque__imagen" src="/TierraMedia/img/coins.jpg"
					alt="por que comprar">
				<h3 class="bloque__titulo">El mejor precio</h3>
				<p class="texto_miniaturas">Etiam bibendum nec tellus ac scelerisque. Ut sed pretium
					sapien, id euismod nibh.</p>
			</div>
			<!-- .bloque -->

			<div class="bloque">
				<img class="bloque__imagen" src="/TierraMedia/img/degustacion.jpg"
					alt="por que comprar">
				<h3 class="bloque__titulo">Atención amigable</h3>
				<p class="texto_miniaturas">Etiam bibendum nec tellus ac scelerisque. Ut sed pretium
					sapien, id euismod nibh.</p>
			</div>
			<!-- .bloque -->

			<div class="bloque">
				<img class="bloque__imagen" src="/TierraMedia/img/psg.jpg"
					alt="por que comprar">
				<h3 class="bloque__titulo">Atracciones únicas</h3>
				<p class="texto_miniaturas">Etiam bibendum nec tellus ac scelerisque. Ut sed pretium
					sapien, id euismod nibh.</p>
			</div>
			<!-- .bloque -->

			<div class="bloque">
				<img class="bloque__imagen" src="/TierraMedia/img/race.jpg"
					alt="por que comprar">
				<h3 class="bloque__titulo">Ahorre tiempo</h3>
				<p class="texto_miniaturas">Etiam bibendum nec tellus ac scelerisque. Ut sed pretium
					sapien, id euismod nibh.</p>
			</div>
			<!-- .bloque -->
		</div>
		<!-- .bloques -->

	</section>
	<footer class="footer">
		<p class="footer_texto">Turismo en la Tierra Media - Todos los
			derechos reservados 2022.</p>
	</footer>
</body>
</html>