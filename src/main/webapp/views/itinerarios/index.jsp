<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<jsp:include page="/ini.jsp"></jsp:include>
<jsp:include page="/barra/nav.jsp"></jsp:include>

<style>
html {
	box-sizing: border-box;
	font-size: 100.0%;
}

h1 {
	text-align: center;
	font-size: 2rem;
	font-family: 'Staatliches', cursive;
}

.itiTitle {
	padding-top: 20px;
}

.itiSubtitle {
	padding-top: 30px;
}

.printButton {
	padding: 5px;
}

*, *:before, *:after {
	box-sizing: inherit;
}

.grid {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 1rem; /*Column-gap y row-gap todo en 1 */
}

@media ( min-width : 768px) {
	.grid {
		grid-template-columns: repeat(3, 1fr);
		/* Si quiero CENTRAR cotenido lo HAGO CON FLEXBOX, SI VOY A POSICIONAR ELEMENTOs lo HAGO CON GRID*/
	}
}
</style>

<title>Turismo en la Tierra Media</title>
</head>


<body background="/TierraMedia/img/ecole.jpg">


	<main class="container print-container">

		<div class="itiTitle">
			<h1>Mi Itinerario</h1>
		</div>

		<div class="itiSubtitle">
			<h1>
				<c:out value="${user.username}"></c:out>
				, estas son sus compras:
			</h1>
		</div>


		<table class="table table-hover">
				<thead class="thead-dark">
				<tr>
					<th>Atracciones</th>
					<th>Tipo de Atraccion</th>
					<th>Costo</th>
					<th>Duracion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${attractions}" var="attraction">
					<tr>
						<td><strong><c:out value="${attraction.nombre}"></c:out></strong>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Cras pretium eros urna. Sed quis erat congue, bibendum tortor
								malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
						<td><c:out value="${attraction.tipo}"></c:out></td>
						<td><c:out value="${attraction.costo}"></c:out></td>
						<td><c:out value="${attraction.tiempoRecorrido}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr style="border: hidden">
					<td></td>
					<td></td>
					<td></td>
					<td>
						<div class="printButton" style="float: right;">
							<button type="button" class="btn btn-primary btn-dark"
								data-bs-toggle="modal" data-bs-target="#staticBackdrop">Imprimir
								itinerario</button>
						</div>
						<div class="modal fade" id="staticBackdrop"
							data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
							aria-labelledby="staticBackdropLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="staticBackdropLabel">¡Atencion!</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">¡Atencion, está a punto de
										imprimir su itinerario!</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Regresar</button>
										<button type="button" class="btn btn-primary">Imprimir</button>
									</div>
								</div>
							</div>
						</div>

					</td>
				</tr>
			</tfoot>
		</table>

	</main>

	<footer class="page-footer font-small teal pt-4 bg-dark text-white"
		style="background-color: rgba(0, 0, 0, 0.2);">
		<jsp:include page="/foot.jsp"></jsp:include>
	</footer>
</body>
</html>