<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4 fixed top">
	<div class="container">
		<a class="btn btn-outline-success" href="/TierraMedia/index.jsp">Turismo
			en la Tierra Media</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">

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

			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>

			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<i class="bi bi-person-check-fill"></i> <c:out
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

								<a href="/TierraMedia/atracciones/crear.do"
									class="dropdown-item" role="button"> <i
									style="color: blue;" class="bi bi-file-arrow-up"></i> Nueva
									Atraccion
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
		
		<div class="collapse" id="navbarToggleExternalContent">
  <div class="bg-dark p-4">
    <h5 class="text-white h4">Collapsed content</h5>
    <span class="text-muted">Toggleable via the navbar brand.</span>
  </div>
</div>


<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</nav>

	</div>
</nav>

