<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
​
<div class="mb-3">
	<label for="nombre" class='col-form-label ${tmp_user.errors.get("name") != null ? "is-invalid" : "" }'>Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value='${user.nombre}'>
</div>
​
<div class="mb-3">
	<label for="name" class='col-form-label ${tmp_user.errors.get("username") != null ? "is-invalid" : "" }'> Username:</label> <input
		type="text" class="form-control" id="name" name="username"
		required value="${user.username}">
</div>
<div class="mb-3">
	<label for="coins"
		class='col-form-label ${tmp_user.errors.get("coins") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="coins" name="coins"
		required value="${user.presupuesto}"></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("coins")}'></c:out>
	</div>
</div>
​
<div class="mb-3">
	<label for="time"
		class='col-form-label ${tmp_user.errors.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="time" name="time"
		required value="${user.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("time")}'></c:out>
	</div>
</div>
​
<div class="mb-3">
	<label for="password"
		class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input class="form-control" id="password" name="password"
		required value="${user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("password")}'></c:out>
	</div>
</div>
​
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
