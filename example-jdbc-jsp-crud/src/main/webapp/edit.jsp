<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jasonskipper
  Date: 10/4/16
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
    private String name;
    private String cat;
    private int salesAmountMillions;
    private long id;

--%>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
Please edit your movie data and click 'Update'!
<div><a href="/movies/logout">Logout</a>

<form action="/movies/update" method="post">
    <table>
        <tr> <td>Name:</td>              <td><input type="text" name="mName" value="<c:out value="${myEdit.name}"/>"></td></tr>
        <tr><td>Category:</td>          <td><input type="text" name="mCat" value="<c:out value="${myEdit.cat}"/>"></td></tr>
        <tr> <td>Sales (in millions):</td><td><input type="text" name="mSales" value="<c:out value="${myEdit.salesAmountMillions}"/>"></td></tr>

    </table>
    <input type="submit" name="Update" />
    <input type="hidden" name="mId" value="<c:out value="${myEdit.id}"/>"/>
</form>
</body>
</html>
