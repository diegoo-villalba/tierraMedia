<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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

@media (min-width: 768px) {
    .grid{
        grid-template-columns: repeat(3, 1fr); /* Si quiero CENTRAR cotenido lo HAGO CON FLEXBOX, SI VOY A POSICIONAR ELEMENTOs lo HAGO CON GRID*/
    }
}

.ctri {

	padding-top: 10px;
}

.botonCrear {
	padding-top: 30px;
}


</style>



</head>
<body background="/TierraMedia/img/ecole.jpg">

	<main >
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
		<div class="botonCrear">
		<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a class="btn btn-primary btn-dark" href="/TierraMedia/users/create.do"
					role="button"> <i class="bi bi-people-fill"></i> Crear usuario
				</a>
			</div>
		</c:if>
		</div>
		<div class="ctri">
		<table class="table table-stripped table-hover">
			<thead>
				<tr bgcolor="#00dddd">
					<th>Nombre</th>
					<th>Monedas</th>
					<th>Tiempo</th>
					<th>Rol</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="tmp_user">
					<tr>
						<td style="background: rgba(76, 175, 180, 0.3);">
							<button type="button" class="btn btn-primary btn-dark">
								<i class="bi bi-person-lines-fill"></i> <a
									style="text-transform: uppercase;"><c:out
										value="${tmp_user.username}"></c:out> </a>
							</button>
						</td>
						<td style="background: rgba(76, 175, 180, 0.3);">
							<button type="button" class="btn btn-primary btn-dark">
							<i class="bi bi-coin"></i>
								<c:out value="${tmp_user.presupuesto}"></c:out>
							</button>

						</td>
						<td style="background: rgba(76, 175, 180, 0.3);">
							<button type="button" class="btn btn-primary btn-dark">
								<i class="bi bi-clock-fill"></i>
								<c:out value="${tmp_user.tiempoDisponible}"></c:out>
							</button>
						</td>
						<td style="background: rgba(76, 175, 180, 0.3);">
							<button type="button" class="btn btn-primary btn-dark">
							
								<c:choose>
									<c:when test="${tmp_user.admin}">
									<i class="bi bi-house-door"></i>
									Admin
								</c:when>
									<c:otherwise>
									<i class="bi bi-house-fill"></i>
									Normal
								</c:otherwise>
								</c:choose>
							</button>
						</td>

						<td style="background: rgba(76, 175, 180, 0.3);">
						<c:if
								test="${user.admin && (!tmp_user.admin || tmp_user.id == user.id)}">
								<a href="/TierraMedia/users/editar.do?id=${tmp_user.id}"
									class="btn btn-dark" role="button"><i
									class="bi bi-gear-fill"></i></a>
								<a href="/TierraMedia/users/borrar.do?id=${tmp_user.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-trash-fill"></i></a>
							</c:if></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</main>
	
<footer class="page-footer font-small teal pt-4 bg-dark text-white fixed-bottom"
		style="background-color: rgba(0, 0, 0, 0.2);">
		<jsp:include page="/foot.jsp"></jsp:include>
	</footer>

</body>
</html>