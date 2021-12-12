<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promociones</title>
</head>
<body>
	<h1>Estas son las Promos que hay disponibles</h1>

	<c:forEach items="${promociones}" var="entry">	
	<li><c:out value="${entry}"></c:out></li>
	</c:forEach>

	
</body>
</html>