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


<body background="/TierraMedia/img/tm1.jpg">
	<jsp:include page="/barra/navi.jsp"></jsp:include>



	<table class="table">
		<thead class="thead-dark">
			<tr bgcolor="#ccccff">
				<th scope="col">Promoci&oacute;n</th>
				<th scope="col">Costo</th>
				<th scope="col">Duraci&oacute;n</th>
				<th scope="col">Atracciones</th>
				<th scope="col">Acciones</th>
			</tr>

		</thead>
		<tbody>


			<c:forEach items="${promociones}" var="promo">
				<tr>

					<td> <a href="#"
						class="btn btn-dark btn-lg" role="button"><i class="bi bi-signpost-fill"></i><c:out
								value="${promo.nombrePromo}"></c:out></a></td>

					<td><button type="button" class="btn btn-secondary btn-sm">
							<i class="bi bi-currency-dollar"></i>
							<c:out value="${promo.getCostoTotalPromo()}"></c:out>
						</button></td>


					<td><button type="button" class="btn btn-secondary btn-sm">
							<i class="bi bi-clock-history"></i>
							<c:out value="${promo.getTiempoDeRecorrido()}"></c:out>
						</button></td>



					<td><button type="button" class="btn btn-secondary btn-sm">
							<i class="bi bi-boxes"></i>
							<c:out value="${promo.getAtracciones()}"></c:out>
						</button></td>



					<td><c:choose>
							<c:when test="${promo.puedoOfrecer(user)}">
								<a
									href="/TierraMedia/promociones/comprar.do?id=${promo.getIdPromo()}"
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