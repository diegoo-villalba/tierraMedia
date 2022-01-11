<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/ini.jsp"></jsp:include>
<style type="text/css">

.form {
padding-top: 20px;
}

</style>

</head>
<body background="/TierraMedia/img/ecole.jpg">
    <jsp:include page="/barra/nav.jsp"></jsp:include>
    <main class="container">
        <c:if test="${user != null && !user.isValid()}">
            <div class="alert alert-danger">
                <p>Se encontraron errores al crear el usuario.</p>
            </div>
        </c:if>
        <form action="/TierraMedia/users/create.do" method="post" class="form">
            <jsp:include page="/views/users/form.jsp"></jsp:include>
        </form>
    </main>
</body>
</html>