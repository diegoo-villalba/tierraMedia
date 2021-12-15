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

 <!--   <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		<a class="btn btn-outline-success my-2 my-sm-0" href="bienvenida.jsp">Turismo en la Tierra Media</a>
		
		<form class="form-inline my-2 my-lg-0">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarCollapse" align="right">
			
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Menu</a>
						<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">								
						<li><hr class="dropdown-divider"></li>
						<li><a href="/TierraMedia/atracciones/index.do" class="dropdown-item">Atracciones</a></li>
						</ul>
				</li>
			</ul>
		</div>
		</form>
	</div>
</nav>
-->  
 	<div class="col-lg-5 mx-auto p-3 py-md-5">
      
      		<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">
				<h3 align="center">Tierra Media</h3>
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

</body>
</html>