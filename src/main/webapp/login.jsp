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
    
    <style>
    
	.titulo {
	font-size: 90px;
    font-family: 'MedievalSharp', cursive;
    justify-content: center;
    text-align: center;
    color: #b14f42;
   	-webkit-text-stroke: 2px black;
}
    
    .loginText {
     color: black;
    font-size: 20px;
    font-family: Arial, Helvetica, sans-serif;
    -webkit-text-stroke: 2px;
    }
    
    
    
    </style>
    
</head>

<body background= "img/wall.jpg">
<!-- <jsp:include page="banner.jsp"></jsp:include> -->

<h1 class = "titulo" > Turismo en la tierra Media</h1>

 	<div class="col-lg-5 mx-auto p-3 py-md-5">
      
      		<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			

			<form action="login" method="post">
				<div class="mb-3">
					<label for="username" class="form-label loginText">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label loginText">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-primary bg-dark">Ingresar</button>
				</div>
			</form>
      </div>

</body>
</html>