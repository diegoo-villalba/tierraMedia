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
	
	<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/TierraMedia/atracciones/crear.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>
			</div>
		</c:if>

	<table class="table">
		<thead class="thead-dark">
			<tr bgcolor="#ccccff">
				<th scope="col">Atracci&oacute;n</th>
				<th scope="col">Costo</th>
				<th scope="col">Duraci&oacute;n</th>
				<th scope="col">Cupo</th>
				<th scope="col">Acciones</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${attractions}" var="attraction">
				<tr>


					<td> <a href="#"
						class="btn btn-dark btn-lg" role="button"><i class="bi bi-signpost-fill"></i><c:out
								value="${attraction.nombre}"></c:out></a></td>
								
					<td><button type="button" class="btn btn-secondary btn-sm"><i class="bi bi-currency-dollar"></i>
					<c:out value="${attraction.costo}"></c:out></button>
					</td>
					
					<td><button type="button" class="btn btn-secondary btn-sm"><i class="bi bi-clock-history"></i>
					<c:out value="${attraction.tiempoRecorrido}"></c:out></button>
					</td>
					
					<td><button type="button" class="btn btn-secondary btn-sm"><i class="bi bi-sticky-fill"></i>
					<c:out value="${attraction.cupo}"></c:out></button>
					</td>

					<td><c:if test="${user.admin}">
							<a href="/TierraMedia/atracciones/editar.do?id=${attraction.id}"
								class="btn btn-dark" role="button"><i
								class="bi bi-gear-fill"></i></a>
							<a href="/TierraMedia/atracciones/borrar.do?id=${attraction.id}"
								class="btn btn-danger rounded" role="button"><i
								class="bi bi-trash-fill"></i></a>
						</c:if> <c:choose>
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
	<c:if test="${flash != null}">
		<div class="alert alert-danger">
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
</body>
</html>