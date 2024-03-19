<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${action==null}">
    <%response.sendRedirect("/StudentController?action=GETALL");%>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Danh sách sinh viên
</h1>
<br/>
<a href="/StudentController?action=ADD">Thêm mới sinh viên</a>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Sex</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.sex?'Nam':'Nữ'}</td>
            <td><a href="">EDIT</a></td>
            <td><a href="">DELETE</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>