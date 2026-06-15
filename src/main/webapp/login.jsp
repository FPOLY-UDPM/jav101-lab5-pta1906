<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 3 & 4 - Đăng nhập (Cookie & Session)</title>
</head>
<body>
    <h2>Đăng nhập</h2>

    <c:if test="${not empty message}">
        <p style="color: ${message == 'Login successfully!' ? 'green' : 'red'};"><b>${message}</b></p>
    </c:if>

    <c:if test="${not empty sessionScope.username}">
        <p>Xin chào, <b>${sessionScope.username}</b>!
           (<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>)</p>
    </c:if>

    <c:url value="/login" var="url"/>
    <form action="${url}" method="post">
        Username: <input name="username" value="${username}"> <br><br>
        Password: <input type="password" name="password" value="${password}"> <br><br>
        <input type="checkbox" name="remember-me"> Remember me?
        <hr>
        <button>Login</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a></p>
</body>
</html>
