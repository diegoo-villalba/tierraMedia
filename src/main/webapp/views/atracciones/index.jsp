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
<title>Compra</title>
</head>
<body>
	<c:out value="${flash}" />
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

	<h1>Estas son las atracciones de la Tierra Media</h1>

	<table class="table">
  <thead>
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Costo</th>
      <th scope="col">Duracion (horas)</th>
      <th scope="col">Cupo</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Moria</th>
      <td>10</td>
      <td>2</td>
      <td>9</td>
      <td><a class="btn btn-success rounded" role="button">Comprar</a></td>
    </tr>
    <tr>
      <th scope="row">Minas Tirith</th>
      <td>5</td>
      <td>2.5</td>
      <td>8</td>
      <td><a class="btn btn-success rounded" role="button">Comprar</a></td>
    </tr>
    <tr>
      <th scope="row">La Comarca</th>
      <td>3</td>
      <td>6.5</td>
      <td>9</td>
      <td><a class="btn btn-success rounded" role="button">Comprar</a></td>
    </tr>
  </tbody>
</table>
</body>
</html>