<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Movie List</title>
</head>
<body>
<div><a href="/movies/logout">Logout</a>

Go see category data <a href="/movies/stats">HERE</a>
<p/>
Create New Movies <a href="/movies/add.jsp">HERE</a>
<p></p>
<form action="/movies/search" method="post">
    Search <input type="text" name="searchtext"/>
    <br>
    <input type="submit" name="Filter Results"/>
</form>
<table border="1">
    <tr><th>Actions</th><th>Title</th><th>Category</th><th>Gross Sales ($M)</th></tr>
    <c:forEach items="${movielist}" var="aMovie">
        <tr>
            <td><a href="/movies/select?id=<c:out value="${aMovie.id}"/>">EDIT</a>
                <br>
                <a href="/movies/delete?id=<c:out value="${aMovie.id}"/>">DELETE</a></td>
            <td><c:out value="${aMovie.name}"/></td>
            <td><c:out value="${aMovie.cat}"/></td>
            <td><c:out value="${aMovie.salesAmountMillions}"/></td></tr>
    </c:forEach>
</table>
</body>
</html>
