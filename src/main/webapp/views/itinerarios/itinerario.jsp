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
		
		<div class="headercentrado">
			<h3>Mi Itinerario</h3>
		</div>

		
		<div class="contenido">
			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th class="col-2">Atracciones</th>
						<th class="col-2">Tiempo</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${attractions}" var="attraction">
						<tr>
							<td><c:out value="${atraccion.nombre}"></c:out>
							<td><c:out value="${atraccion.getTiempoRecorrido()}"></c:out> hora/s</td>
						</tr>
					</c:forEach>	

				</tbody>
				<tfoot class="table-light">
					<tr>
						<td><b>Total</b></td>
						<td><c:out value="${tiempoTotal}"></c:out> hora/s</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	
	
</body>
</html>