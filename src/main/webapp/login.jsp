<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TurismoTierraMedia</title>
    <jsp:include page="ini.jsp"></jsp:include>
    
</head>

<body background= "img/tierramedia.jpg">
<jsp:include page="banner.jsp"></jsp:include>

 	<div class="col-lg-5 mx-auto p-3 py-md-5">
      
      		<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">
				<h3 align="center">Login</h3>
				<div class="mb-3">
					<label for="username" class="form-label">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
				</div>
			</form>
      </div>
      <jsp:include page="/foot.jsp"></jsp:include>

</body>
</html>