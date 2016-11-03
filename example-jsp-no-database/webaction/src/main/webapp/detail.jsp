<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date,java.util.List,java.io.*" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
Hello
<h3>To-Do Details </h3>
<table border="1">
        <tr>
            <td>Name:</td>
            <td> <c:out value="${detailToDo.name}"/></td>
        </tr>
        <tr>
            <td>Detail:</td>
            <td> <c:out value="${detailToDo.detail}"/></td>
        </tr>
        <tr>
            <td>Id:</td>
            <td> <c:out value="${detailToDo.id}"/></td>
        </tr>
</table>
</body>
</html>
