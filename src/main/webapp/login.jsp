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

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
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
						<li><a href="/turismo/logout" class="dropdown-item">Atracciones</a></li>
						</ul>
				</li>
			</ul>
		</div>
		</form>
	</div>
</nav>

<table align="center">
<tr>
<td width="500">
 <div class="col-lg-5 mx-auto p-3 py-md-5">
      
      		<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

			<form action="loging" method="post">
				<h3 align="center">¡Bienvenido!</h3>
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
   </td>
   <td>
   
   </td>
   <td width="700">
      

    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" align="right">
        <div class="carousel-indicators" align="right">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>        
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="5" aria-label="Slide 6"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="6" aria-label="Slide 7"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="7" aria-label="Slide 8"></button>
          
        </div>
        <div class="carousel-inner" align="right">
        
          <div class="carousel-item active" align="right">
          
            <img src="img/abismoDeHelm.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right" >
              <h5>El Abismo de Helm</h5>
              <p>Paisaje</p>
            </div>
          </div>
          <div class="carousel-item" align="right">
            <img src="img/bosqueNegro.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>El Bosque Negro</h5>
              <p>Aventura</p>
            </div>
          </div>
          <div class="carousel-item" align="right">
            <img src="img/comarca.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>La Comarca</h5>
              <p>Degustacion</p>
            </div>
          </div>
          
          <div class="carousel-item" align="right">
            <img src="img/erebor.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>Erebor</h5>
              <p>Paisaje</p>
            </div>
          </div>
          
          <div class="carousel-item" align="right">
            <img src="img/moria.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>Moria</h5>
              <p>Aventura</p>
            </div>
          </div>
          
          <div class="carousel-item" align="right">
            <img src="img/mordor.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>Mordor</h5>
              <p>Aventura</p>
            </div>
          </div>
          
          <div class="carousel-item" align="right">
            <img src="img/minasTirith.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>Minas Tirith</h5>
              <p>Paisaje</p>
            </div>
          </div>
          
          <div class="carousel-item" align="right">
            <img src="img/lothlorien.jpg" width="500" height= "500" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" align="right">
              <h5>Lothlorien</h5>
              <p>Degustacion</p>
            </div>
          </div>
          
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div> 
      
	</td>
	</tr>
</table> 
 <jsp:include page="Promociones.jsp"></jsp:include>    

</body>
</html>