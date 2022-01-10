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
	color: var(- -secundario);
	font-size: 4rem;
	font-family: 'Staatliches', cursive;
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

.ctir{
    display: grid; /* Nos permite posicionarlo en la grilla*/
    grid-template-rows: repeat(2, auto);
}

@media (min-width: 768px) {
    .ctir {
        grid-template-columns: repeat(2, 1fr); /*Creamos 2 columnas */
        column-gap: 2rem;
    }
}

.ctir__img {
    grid-row: 1 / 2; /* Para que al achicar la pantalla se posicione la imagen por debajo del texto */
}

@media (min-width: 768px) {
    .ctir__img {
        grid-column: 2 / 3;
    }
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


<body background="img/regul.jpg">





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
	<div>

		<h1>
			¡Bienvenido
			<c:out value="${user.username}"></c:out>
			a la Tierra Media!
		</h1>

	</div>
	
	<main>
	
	<div>
		<table align="center">


			<tr>
				<td width="700">


					<div id="carouselExampleCaptions" class="carousel slide"
						data-bs-ride="carousel" align="right">
						<div class="carousel-indicators" align="right">
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="3" aria-label="Slide 4"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="4" aria-label="Slide 5"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="5" aria-label="Slide 6"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="6" aria-label="Slide 7"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="7" aria-label="Slide 8"></button>

						</div>
						<div class="carousel-inner" align="right">

							<div class="carousel-item active" align="right">

								<img src="img/abismoDeHelm.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>El Abismo de Helm</h5>
									<p>Paisaje</p>
								</div>
							</div>
							<div class="carousel-item" align="right">
								<img src="img/bosqueNegro.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>El Bosque Negro</h5>
									<p>Aventura</p>
								</div>
							</div>
							<div class="carousel-item" align="right">
								<img src="img/comarca.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>La Comarca</h5>
									<p>Degustacion</p>
								</div>
							</div>

							<div class="carousel-item" align="right">
								<img src="img/erebor.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>Erebor</h5>
									<p>Paisaje</p>
								</div>
							</div>

							<div class="carousel-item" align="right">
								<img src="img/moria.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>Moria</h5>
									<p>Aventura</p>
								</div>
							</div>

							<div class="carousel-item" align="right">
								<img src="img/mordor.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>Mordor</h5>
									<p>Aventura</p>
								</div>
							</div>

							<div class="carousel-item" align="right">
								<img src="img/minasTirith.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>Minas Tirith</h5>
									<p>Paisaje</p>
								</div>
							</div>

							<div class="carousel-item" align="right">
								<img src="img/lothlorien.jpg" width="500" height="500"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block" align="right">
									<h5>Lothlorien</h5>
									<p>Degustacion</p>
								</div>
							</div>

						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>

				</td>
			</tr>
		</table>

	</div>

	

		<div class="container">
			<h2>¿Que es Tierra Media?</h2>

			<p></p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu
			euismod mauris. Nulla facilisi. Vestibulum ante ipsum primis in
			faucibus orci luctus et ultrices posuere cubilia curae; Sed eget
			tempus neque. Class aptent taciti sociosqu ad litora torquent per
			conubia nostra, per inceptos himenaeos. Integer facilisis venenatis
			mi non luctus. Nam accumsan dignissim libero. Praesent eget enim
			rutrum, vestibulum purus sed, cursus nibh. Nulla ultricies in mi in
			mattis. Sed nulla orci, venenatis in aliquet at, maximus in lorem.
			Aenean eget posuere felis.
			</p>

		</div>
		
				<div class="container">
			<h2>¿Que es Tierra Media?</h2>

			<p></p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu
			euismod mauris. Nulla facilisi. Vestibulum ante ipsum primis in
			faucibus orci luctus et ultrices posuere cubilia curae; Sed eget
			tempus neque. Class aptent taciti sociosqu ad litora torquent per
			conubia nostra, per inceptos himenaeos. Integer facilisis venenatis
			mi non luctus. Nam accumsan dignissim libero. Praesent eget enim
			rutrum, vestibulum purus sed, cursus nibh. Nulla ultricies in mi in
			mattis. Sed nulla orci, venenatis in aliquet at, maximus in lorem.
			Aenean eget posuere felis.
			</p>

		</div>
		
		
				<div class="container">
			<h2>¿Que es Tierra Media?</h2>

			<p></p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu
			euismod mauris. Nulla facilisi. Vestibulum ante ipsum primis in
			faucibus orci luctus et ultrices posuere cubilia curae; Sed eget
			tempus neque. Class aptent taciti sociosqu ad litora torquent per
			conubia nostra, per inceptos himenaeos. Integer facilisis venenatis
			mi non luctus. Nam accumsan dignissim libero. Praesent eget enim
			rutrum, vestibulum purus sed, cursus nibh. Nulla ultricies in mi in
			mattis. Sed nulla orci, venenatis in aliquet at, maximus in lorem.
			Aenean eget posuere felis.
			</p>

		</div>

	</main>
	<!--  

	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<div class="container">
			<a class="btn btn-outline-success" href="/TierraMedia/index.jsp">Turismo
				en la Tierra Media</a>
			<div class="btn btn-outline-success" align="right">
				¡Bienvenido,
				<c:out value="${user.username}" />
				!
			</div>

		</div>

	</nav>
 -->


</body>
</html>