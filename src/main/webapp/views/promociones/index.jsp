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
<jsp:include page="/barra/nav.jsp"></jsp:include>

<style>
html {
	box-sizing: border-box;
	font-size: 100.0%;
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

.ctri {
	max-width: 120rem;
	margin: 0 auto; /* Para centrar el contenido */
	padding-top: 30px;
}
}
</style>



<title>Turismo en la Tierra Media</title>
</head>


<body background="/TierraMedia/img/ecole.jpg">

	<main>
	<div class="alerta" style = "padding-top: 20px">
			<c:if test="${flash != null}">
				<div class="alert alert-dark">
					<p>
						<c:out value="${flash}" />
						<c:if test="${errors != null}">
							<ul>
								<c:forEach items="${errors}" var="entry">
									<li><c:out value="${entry.getValue()}"></c:out></li>
								</c:forEach>
							</ul>
						</c:if>
					</p>
				</div>
			</c:if>

		</div>
	
		<div class="ctri">
			<table class="table table-hover">
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

							<td><a href="#" class="btn btn-dark btn-lg" role="button"><i
									class="bi bi-signpost-fill"></i> <c:out
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
											class="btn btn-primary btn-dark rounded" role="button">Comprar</a>
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
		</div>
	</main>
	<footer
		class="page-footer font-small teal pt-4 bg-dark text-white fixed-bottom"
		style="background-color: rgba(0, 0, 0, 0.2);">
		<jsp:include page="/foot.jsp"></jsp:include>
	</footer>
</body>
</html>