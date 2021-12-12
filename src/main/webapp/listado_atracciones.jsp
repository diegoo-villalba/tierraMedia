<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>HOla</h1>

<table class="table">

		<tbody>

			<c:forEach items="${atracciones}" var="atracciones">
				<tr>
					<td><strong><c:out value="${atracciones.nombre}"></c:out></strong>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Cras pretium eros urna. Sed quis erat congue, bibendum tortor
							malesuada, iaculis diam. Ut ut imperdiet sapien.</p></td>
					

				</tr>

			</c:forEach>
		</tbody>
	</table>

</body>
</html>