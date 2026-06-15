<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
    <h2>Kết quả đọc dữ liệu form (BeanUtils)</h2>

    <table border="1" cellpadding="6">
        <tr><td>Họ tên</td><td>${staff.fullname}</td></tr>
        <tr><td>Ngày sinh</td><td>${staff.birthday}</td></tr>
        <tr><td>Giới tính</td><td>${staff.gender ? "Male" : "Female"}</td></tr>
        <tr><td>Sở thích</td>
            <td>
                <c:forEach var="h" items="${staff.hobbies}">
                    ${h}&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr><td>Quốc gia</td><td>${staff.country}</td></tr>
        <tr><td>Lương</td><td>${staff.salary}</td></tr>
    </table>

    <p><a href="${pageContext.request.contextPath}/save">Quay lại form</a> |
       <a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a></p>
</body>
</html>
