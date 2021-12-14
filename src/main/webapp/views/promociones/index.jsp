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
	
	

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Promoci&oacute;n</th>
				<th>Costo</th>
				<th>Duraci&oacute;n</th>
				<th>Atracciones</th>
				<th>Acciones</th>
				<th>AUNOMASSSs</th>
			</tr>

		</thead>
		<tbody>
		
		<td><h1>HOLA JUAN CARLOS</h1></td>
			<c:forEach items="${promociones}" var="promo">
				<tr>
					<td><h4>
							<c:out value="${promo.nombrePromo}">
						</h4> </c:out></td>
					<td><c:out value="${promo.getCostoTotalPromo()}"></c:out></td>
					<td><c:out value="${promo.getAtracciones()}"></c:out></td>
					<td><c:out value="${promo.getTiempoDeRecorrido()}"></c:out></td>

					<td><c:choose>
							<c:when test="${promocion.puedoOfrecer(turista)}">
								<a
									href="/TierraMedia/promociones/comprar.do?id=${promocion.getNombre()}"
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