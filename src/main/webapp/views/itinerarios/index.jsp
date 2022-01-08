<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<jsp:include page="/ini.jsp"></jsp:include>

<title>Turismo en la Tierra Media</title>
</head>


<body background="/TierraMedia/img/regul.jpg">
<jsp:include page="/barra/navi.jsp"></jsp:include>
	
	<div class="container button">
		<button class="btn btn-secondary hidden-print btn-sm" onclick="window.print()">
		<span class="glyphicon glyphicon-print" aria-hidden="true"></span> Imprimir itinerario</button>
	</div>
	
	<main class="container print-container">
		
		<div class="bg-light p-4 mb-3 rounded">
			<h1>Itinerario - Turismo en la Tierra Media</h1>
		</div>
		<hr>
		
		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son sus Atracciones</h1>
		</div>


		<table class="table table-stripped table-hover">
			<thead>
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
		</table>
		
	</main>
	
	<footer class="page-footer font-small teal pt-4 bg-dark text-white"
		style="background-color: rgba(0, 0, 0, 0.2);">
	<jsp:include page="/foot.jsp"></jsp:include>
	</footer>
	
</body>
</html>