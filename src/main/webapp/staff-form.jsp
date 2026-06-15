<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 1 - BeanUtils Form</title>
</head>
<body>
    <h2>Bài 1: Sử dụng BeanUtils để đọc tham số</h2>

    <c:url value="/save" var="url"/>
    <form action="${url}" method="post">
        Họ tên: <input name="fullname"> <br><br>
        Ngày sinh (MM/dd/yyyy): <input name="birthday" placeholder="MM/dd/yyyy"> <br><br>

        Giới tính:
        <input type="radio" name="gender" value="true"> Male
        <input type="radio" name="gender" value="false"> Female <br><br>

        Sở thích:
        <input type="checkbox" name="hobbies" value="R"> Reading
        <input type="checkbox" name="hobbies" value="Traveling"> Traveling
        <input type="checkbox" name="hobbies" value="M"> Music <br><br>

        Quốc gia:
        <select name="country">
            <option value="VN">Việt Nam</option>
            <option value="US" selected>United States</option>
        </select> <br><br>

        Lương: <input name="salary"> <br><br>
        <hr>
        <button>Submit</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a></p>
</body>
</html>
