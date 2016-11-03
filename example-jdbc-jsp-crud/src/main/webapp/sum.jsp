<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum Of Movie Info</title>
</head>
<body>
<div><a href="/movies/logout">Logout</a>
</div>
Go back to detail data <a href="/movies/list">HERE</a>

<table border="1">
    <tr><th>Movie Cat.</th><th>Gross Movie Sales</th></tr>
    <c:forEach items="${moviestats}" var="aStat">
        <tr><td><c:out value="${aStat.cat}"/></td>
            <td><c:out value="${aStat.salesAmountMill}"/></td></tr>
    </c:forEach>
</table>
</body>
</html>
