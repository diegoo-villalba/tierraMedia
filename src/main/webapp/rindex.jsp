<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>TurismoTierraMedia</title>

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
	height: 33, 3px;
}

h1 {
	text-align: center;
	font-size: 4rem;
	font-family: 'Staatliches', cursive;
}

h2 {
	text-align: center;
	font-family: 'Staatliches', cursive;
	padding-top: 50px;
}

.xp1 {
	padding-top: 55px;
}

.container1 {
	display: flex;
	flex-direction: column;
	min-height: 100%;
}

.container1>.div1 {
	flex: 1;
	display: flex;
}

.sidenav {
	height: 100%; /* 100% Full-height */
	width: 0; /* 0 width - change this with JavaScript */
	position: fixed; /* Stay in place */
	z-index: 1; /* Stay on top */
	top: 0; /* Stay at the top */
	left: 0;
	background-color: #111; /* Black*/
	overflow-x: hidden; /* Disable horizontal scroll */
	padding-top: 60px; /* Place content 60px from the top */
	transition: 0.5s;
	/* 0.5 second transition effect to slide in the sidenav */
}

/* The navigation menu links */
.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

/* When you mouse over the navigation links, change their color */
.sidenav a:hover {
	color: #f1f1f1;
}

/* Position and style the close button (top right corner) */
.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

/* Style page content - use this if you want to push the page content to the right when you open the side navigation */
#main {
	transition: margin-left .5s;
	padding: 20px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}

.me-auto {
	background-color: blue;
	border-radius: 15px;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	font-size: 18px;
	color: white;
}
</style>

<script>
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
		document.getElementById("main").style.marginLeft = "250px";
		document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
		document.getElementById("main").style.marginLeft = "0";
		document.body.style.backgroundColor = "white";
	}
</script>


<jsp:include page="/ini.jsp"></jsp:include>

</head>


<body background="img/paisaje2.jpg">





	<div id="mySidenav" class="sidenav">


		<hr class="dropdown-divider">
		<a class="nav-link active" aria-current="page"
			href="/TierraMedia/atracciones/atracciones.do">Atracciones</a> <a
			class="nav-link active" aria-current="page"
			href="/TierraMedia/promociones/index.do">Promociones</a> <a
			class="nav-link active" aria-current="page"
			href="/TierraMedia/itinerarios/index.do">Itinerario</a>
		<c:if test="${user.isAdmin()}">
			<a class="nav-link active" aria-current="page"
				href="/TierraMedia/users/indexu.do">Usuarios</a>
		</c:if>

		<hr class="dropdown-divider">

		<a class="item" href="#">Contacto</a> <a class="item" href="#">Quienes
			somos</a> <a class="item" href="#">Redes sociales</a> <a class="item"
			href="#">Como llegar</a>


		<hr class="dropdown-divider">
		<a href="/TierraMedia/logout" class="dropdown-item"><i
			style="color: red" class="bi bi-power"></i>Salir</a> <a
			href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	</div>

	<div id="main">
		<button type="button" class="btn btn-primary btn btn-dark"
			onclick="openNav()">Menu</button>

		<div class="me-auto" role="group" style="float: right;">
			<button id="btnGroupDrop1" type="button"
				class="btn btn-primary btn btn-dark dropdown-toggle"
				data-bs-toggle="dropdown" aria-expanded="false">
				¡Bienvenido
				<c:out value="${user.username}"></c:out>
				!
			</button>
			<ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				<li><a class="dropdown-item disabled" style="color: black;">
						<i title="monedas" style="color: green;" class="bi bi-cash-coin"></i>
						<c:out value="${user.presupuesto}"></c:out>
				</a></li>
				<li><a class="dropdown-item disabled" style="color: black;">
						<i title="tiempo" style="color: gold;"
						class="bi bi-hourglass-split"></i> <c:out
							value="${user.tiempoDisponible}"></c:out>

				</a></li>
				<li><hr class="dropdown-divider"></li>

				<li><a href="/TierraMedia/itinerarios/index.do"
					class="dropdown-item">Mi itinerario</a></li>

				<li><hr class="dropdown-divider"></li>
				<li><c:if test="${user.isAdmin()}">

						<a href="/TierraMedia/atracciones/crear.do" class="dropdown-item"
							role="button"> <i style="color: blue;"
							class="bi bi-file-arrow-up"></i> Nueva Atraccion
						</a>

					</c:if></li>
				<li><c:if test="${user.isAdmin()}">

						<a href="/TierraMedia/users/create.do" class="dropdown-item"
							role="button"> <i style="color: blue;"
							class="bi bi-person-plus-fill"></i> Nuevo Usuario
						</a>

					</c:if></li>
			</ul>
		</div>

	</div>
	<main>
		<div>

			<h1 class="divWelcome">
				¡Bienvenido
				<c:out value="${user.username}"></c:out>
				a la Tierra Media!
			</h1>

		</div>



		<div class="container">



			<div class="row align-items-start xp1">

				<div class="divSub">

					<h2 style="color: #292828; font-family: 'Staatliches', cursive;">
						Estas son algunas de nuestras atracciones:</h2>

				</div>

				<div class="col">

					<div class="card text-center text-white bg-dark mb-3"
						style="width: 18rem;">
						<img src="/TierraMedia/img/tierramedia.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Far West</h5>
							<p class="card-text text-white">Some quick example text to
								build on the card title and make up the bulk of the card's
								content.</p>
							<a href="/TierraMedia/atracciones/index.do"
								class="btn btn-primary">Comprar</a>
						</div>
					</div>



				</div>
				<div class="col">

					<div class="card text-center text-white bg-dark mb-3"
						style="width: 18rem;">
						<img src="/TierraMedia/img/lothlorien.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Lothlorien</h5>
							<p class="card-text text-white">Some quick example text to
								build on the card title and make up the bulk of the card's
								content.</p>
							<a href="/TierraMedia/atracciones/index.do"
								class="btn btn-primary">Comprar</a>
						</div>
					</div>


				</div>
				<div class="col">

					<div class="card text-center text-white bg-dark mb-3"
						style="width: 18rem;">
						<img src="/TierraMedia/img/mordor.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Mordor</h5>
							<p class="card-text text-white">Some quick example text to
								build on the card title and make up the bulk of the card's
								content.</p>
							<a href="/TierraMedia/atracciones/index.do"
								class="btn btn-primary">Comprar</a>
						</div>
					</div>


				</div>
			</div>

			<div class="row align-items-center">


				<div class="divSub">

					<h2 style="color: #292828; font-family: 'Staatliches', cursive;">
						Estas son algunas de nuestras promociones:</h2>

				</div>

				<div class="col">
					<div class="card text-center text-white bg-dark mb-3"
						style="width: 18rem;">
						<img src="/TierraMedia/img/psg.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Paisaje</h5>
							<p class="card-text text-white">Some quick example text to
								build on the card title and make up the bulk of the card's
								content.</p>
							<a href="/TierraMedia/atracciones/index.do"
								class="btn btn-primary">Comprar</a>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card text-center text-white bg-dark mb-3"
						style="width: 18rem;">
						<img src="/TierraMedia/img/degustacion.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Degustacion</h5>
							<p class="card-text text-white">Some quick example text to
								build on the card title and make up the bulk of the card's
								content.</p>
							<a href="/TierraMedia/atracciones/index.do"
								class="btn btn-primary">Comprar</a>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card text-center text-white bg-dark mb-3"
						style="width: 18rem;">
						<img src="/TierraMedia/img/paisaje.jpg" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Aventura</h5>
							<p class="card-text text-white">Some quick example text to
								build on the card title and make up the bulk of the card's
								content.</p>
							<a href="/TierraMedia/atracciones/index.do"
								class="btn btn-primary">Comprar</a>
						</div>
					</div>
				</div>
			</div>


		</div>




	</main>


</body>
</html>