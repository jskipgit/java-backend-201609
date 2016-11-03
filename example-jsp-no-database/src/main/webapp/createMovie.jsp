<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Your Movie Entry</h1>
<form method="post" action="/myweb/createmovie">
    <table>
        <tr><td>Movie Title:</td> <td><input type="text" name="title" value="<c:out value="${selectedmovie.title}"/>"></td></tr>
        <tr><td>Movie Category:</td> <td><input type="text" name="cat" value="<c:out value="${selectedmovie.category}"/>"></td></tr>
        <tr><td>Movie ImgUrl:</td> <td><input type="text" name="imgurl" value="<c:out value="${selectedmovie.imgUrl}"/>"></td></tr>
        <tr><td>Movie ID:</td> <td><input type="text" name="id" value="<c:out value="${selectedmovie.id}"/>"></td></tr>
    </table>
    <input type="submit" value="Save">
</form>

Your session new movie looks like this:
<table border="1">
    <tr><th>Edit</th><th>TITLE</th><th>CATEGORY</th><th>IMAGE</th><th>Nuke</th></tr>
<c:forEach items="${themovielist}" var="themovie">
    <tr><td><a href="/myweb/selectmovie?id=<c:out value="${themovie.id}"/>">EDIT</a> </td><td><c:out value="${themovie.title}"/></td><td><c:out value="${themovie.category}"/></td><td><c:out value="${themovie.imgUrl}"/></td><td><a href="/myweb/deletemovie?nuke=<c:out value="${themovie.id}"/>">Nuke IT!</a> </td></tr>
</c:forEach>
</table>

</body>
</html>
