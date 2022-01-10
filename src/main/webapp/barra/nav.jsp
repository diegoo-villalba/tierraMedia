<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	
<!--
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container-fluid">
	
	<a class="navbar-brand" href="/TierraMedia/rindex.jsp">
      <img src="" alt="" width="30" height="24" class="d-inline-block align-text-top">
		 Tierra Media
		</a>
	</div>

 
	<div class="collapse navbar-collapse" id="navbarCollapse">
	
	<ul class="navbar-nav me-auto mb-2 mb-md-0" >

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/atracciones/atracciones.do">Atracciones</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/promociones/index.do">Promociones</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/itinerarios/index.do">Itinerario</a></li>
				<c:if test="${user.isAdmin()}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/TierraMedia/users/indexu.do">Usuarios</a></li>
				</c:if>
			</ul>
	
		<ul class="navbar-nav">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"> <i
					class="bi bi-person-check-fill"></i> <c:out
						value="${user.username}"></c:out>
			</a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">

					<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: green;" class="bi bi-cash-coin"></i>
							<c:out value="${user.presupuesto}"></c:out>
					</a></li>
					<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: gold;"
							class="bi bi-hourglass-split"></i> <c:out
								value="${user.tiempoDisponible}"></c:out>
					</a></li>
					<li><hr class="dropdown-divider"></li>

					<li><a href="/TierraMedia/itinerarios/index.do"
						class="dropdown-item">Mi itinerario</a></li>

					<li><hr class="dropdown-divider"></li>
					<li><c:if test="${user.isAdmin()}">

							<a href="/TierraMedia/atracciones/crear.do" class="dropdown-item"
								role="button"> <i style="color: blue;"
								class="bi bi-file-arrow-up"></i> Nueva Atraccion
							</a>

						</c:if></li>
					<li><c:if test="${user.isAdmin()}">

							<a href="/TierraMedia/users/create.do" class="dropdown-item"
								role="button"> <i style="color: blue;"
								class="bi bi-person-plus-fill"></i> Nuevo Usuario
							</a>

						</c:if></li>

					<li><a href="/TierraMedia/logout" class="dropdown-item"><i
							style="color: red" class="bi bi-power"></i>Salir</a></li>
				</ul></li>
		</ul>
	</div>
</nav>
 -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  
    <a class="navbar-brand" href="/TierraMedia/rindex.jsp"><img src="/TierraMedia/shield.svg" >Tierra Media</a>
    <div class="collapse navbar-collapse" id="navbarText">
    
    <ul class="navbar-nav me-auto mb-2 mb-md-0" >

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/atracciones/atracciones.do">Atracciones</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/promociones/index.do">Promociones</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/itinerarios/index.do">Itinerario</a></li>
				<c:if test="${user.isAdmin()}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/TierraMedia/users/indexu.do">Usuarios</a></li>
				</c:if>
			</ul>
    
    
     
       <ul class="navbar-nav">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"> <i
					class="bi bi-person-check-fill"></i> <c:out
						value="${user.username}"></c:out>
			</a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">

					<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: green;" class="bi bi-cash-coin"></i>
							<c:out value="${user.presupuesto}"></c:out>
					</a></li>
					<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: gold;"
							class="bi bi-hourglass-split"></i> <c:out
								value="${user.tiempoDisponible}"></c:out>
					</a></li>
					<li><hr class="dropdown-divider"></li>

					<li><a href="/TierraMedia/itinerarios/index.do"
						class="dropdown-item">Mi itinerario</a></li>

					<li><hr class="dropdown-divider"></li>
					<li><c:if test="${user.isAdmin()}">

							<a href="/TierraMedia/atracciones/crear.do" class="dropdown-item"
								role="button"> <i style="color: blue;"
								class="bi bi-file-arrow-up"></i> Nueva Atraccion
							</a>

						</c:if></li>
					<li><c:if test="${user.isAdmin()}">

							<a href="/TierraMedia/users/create.do" class="dropdown-item"
								role="button"> <i style="color: blue;"
								class="bi bi-person-plus-fill"></i> Nuevo Usuario
							</a>

						</c:if></li>

					<li><a href="/TierraMedia/logout" class="dropdown-item"><i
							style="color: red" class="bi bi-power"></i>Salir</a></li>
				</ul></li>
		</ul>
    </div>
  </div>
</nav>
