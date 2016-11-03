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
<h3>To-Do List </h3>
<table border="1">
    <c:forEach items="${stufftodo}" var="aToDo">
        <tr>
            <td>Do This!:</td>
            <td> <c:out value="${aToDo.name}"/></td>
            <td><a href="/myweb/hello?action=detail&id=<c:out value="${aToDo.id}"/>"> View Detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
