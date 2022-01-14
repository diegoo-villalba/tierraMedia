<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contacto</title>
<link rel="stylesheet" href="css/normalize.css">
<!-- Para que los todos los navegadores nos muestren correctamente los elementos -->
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

*, *:before, *:after {
	box-sizing: inherit;
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

h1 {
	font-size: 3rem;
	text-align: center;
	font-family: 'Staatliches', cursive;
	padding-top: 20px;
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
	display: flex;
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

form {
	display: block;
	margin-top: 0em;
}

.formulario {
	background-color: rgb(33, 37, 41);
	width: min(50rem, 75%);
	margin: 0 auto;
	padding: 2rem;
	border-radius: 1rem;
	padding-top: 20px;
}

.formulario fieldset {
	border: none;
}

.formulario legend {
	text-align: center;
	font-size: 1.8rem;
	text-transform: uppercase;
	font-weight: 700;
	margin-bottom: 2rem;
	color: white;
}

legend {
	box-sizing: border-box;
	display: table;
	max-width: 100%;
	padding: 0;
	white-space: normal;
}

.area_formulario {
	padding: 0.35em 0.75em 0.625em;
	display: block;
	margin-inline-start: 2px;
	margin-inline-end: 2px;
	padding-block-start: 0.35em;
	padding-inline-start: 0.75em;
	padding-inline-end: 0.75em;
	padding-block-end: 0.625em;
	min-inline-size: min-content;
}

.campo {
	margin-bottom: 1rem;
}

.campo label {
	color: white;
	font-weight: bold;
	margin-bottom: 0.5rem;
	display: block;
}

.campo input[type="text"], .campo input[type="tel"], .campo input[type="email"],
	.input-text {
	width: 100%;
	border: none;
	padding: 1.5rem;
	border-radius: 0.5rem;
}

button, input {
	overflow: visible;
}

button, input, optgroup, select, textarea {
	font-family: inherit;
	font-size: 100%;
	line-height: 1.15;
	margin: 0;
}

.campo textarea {
	height: 20rem;
}

.campo input[type="text"], .campo input[type="tel"], .campo input[type="email"],
	.input-text {
	width: 100%;
	border: none;
	padding: 1.5rem;
	border-radius: 0.5rem;
}

textarea {
	overflow: auto;
	font-family: inherit;
	font-size: 100%;
	line-height: 1.15;
	margin: 0;
}

.botonSend {
	justify-content: center;
}

.flex {
	display: flex;
}

.w-sm-100 {
	width: 100%;
}

.boton {
	background-color: white;
	color: var(- -blanco);
	padding: 1rem 3rem;
	margin-top: 3rem;
	font-size: 2rem;
	text-decoration: none;
	text-transform: uppercase;
	font-weight: bold;
	border-radius: 0.5rem;
	width: 90%;
	text-align: center;
	border: none;
}

button, [type="submit"] {
	-webkit-appearance: button;
}

button, input {
	overflow: visible;
}

input {
	font-family: inherit;
	font-size: 100%;
	line-height: 1.15;
	margin: 0;
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
			href="nosotros.html">Redes Sociales</a>
	</nav>

	<main>
		<section>

			<h1>Contacto</h1>
			<form class="formulario">
				<fieldset class="area_formulario">

					<legend>Por favor, rellena los campos aquí debajo para que
						podamos contactarte</legend>

					<div class="contenedor_campos">
						<div class="campo">

							<label>Nombre</label> <input type="text" placeholder="Tu nombre">

						</div>

						<div class="campo">
							<label>Teléfono</label> <input type="text"
								placeholder="Tu telefóno">

						</div>

						<div class="campo">

							<label>Email</label> <input type="text" placeholder="Tu email">

						</div>

						<div class="campo">

							<label>Mensaje</label>
							<textarea class="input-text"> </textarea>

						</div>


					</div>

					<div class="botonSend flex">

						<input class="boton w-sm-100" type="submit" value="enviar">

					</div>

				</fieldset>
			</form>


		</section>
	</main>



	<footer class="footer">
		<p class="footer_texto">Turismo en la Tierra Media - Todos los
			derechos reservados 2022.</p>
	</footer>
</body>
</html>