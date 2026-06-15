<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 2 - Gửi Email</title>
</head>
<body>
    <h2>Bài 2: Gửi Email</h2>

    <c:if test="${not empty message}">
        <p style="color: blue;"><b>${message}</b></p>
    </c:if>

    <c:url value="/send-mail" var="url"/>
    <form action="${url}" method="post">
        From: <input type="email" name="from" required> <br><br>
        To: <input type="email" name="to" required> <br><br>
        Subject: <input type="text" name="subject"> <br><br>
        Body: <br>
        <textarea name="body" rows="6" cols="40"></textarea> <br><br>
        <hr>
        <button>Gửi</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a></p>
</body>
</html>
