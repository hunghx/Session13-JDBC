<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 3/19/2024
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sinh viên</h1>
<form action="/StudentController" method="post">
<table>
    <tr>
        <th><label for="name"></label></th>
        <td><input type="text" name="name" id="name"></td>
    </tr>
    <tr>
        <th><label for="age"></label></th>
        <td><input type="number" name="age" id="age"></td>
    </tr>
    <tr>
        <th><label ></label></th>
        <td><input type="radio" name="sex" value="true"> Nam
            <input type="radio" name="sex" value="false"> Nữ
        </td>
    </tr>
    <tr><td colspan="2"><input type="submit" value="ADD" name="action"></td></tr>
</table>
</form>
</body>
</html>
