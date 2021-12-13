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


<body background="/TierraMedia/img/tm3.jpg">
	<jsp:include page="/barra/navi.jsp"></jsp:include>

	<div class="bg-light p-4 mb-3 rounded">
		<h1>Estas son las atracciones de la Tierra Media</h1>
	</div>

	<table class="table table-stripped table-hover">
		<thead>
			<tr>
				<th>Atracci&oacute;n</th>
				<th>Costo</th>
				<th>Duraci&oacute;n</th>
				<th>Cupo</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${attractions}" var="attraction">
				<tr>
					<td><h4>
							<c:out value="${attraction.nombre}">
						</h4>
						</c:out></td>
					<td><c:out value="${attraction.costo}"></c:out></td>
					<td><c:out value="${attraction.tiempoRecorrido}"></c:out></td>
					<td><c:out value="${attraction.cupo}"></c:out></td>
					
					<td><c:choose>
						<c:when
							test="${user.puedeComprar(attraction) && user.puedeSubir(attraction) && attraction.tieneCupo(1)}">
							<a
						href="/TierraMedia/atracciones/comprar.do?id=${attraction.id}"
						class="btn btn-primary rounded" role="button">Comprar</a>
						</c:when>
						<c:otherwise>
							<a href="#" class="btn btn-secondary rounded disabled"
								role="button">No se puede comprar</a>
						</c:otherwise>
					</c:choose></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>