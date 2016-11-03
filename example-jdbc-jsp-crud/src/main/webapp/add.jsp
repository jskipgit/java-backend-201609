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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
Please input your movie data and click 'Save'!
<div><a href="/movies/logout">Logout</a>

<form action="/movies/create" method="post">
    <table>
       <tr> <td>Name:</td>              <td><input type="text" name="mName"></td></tr>
        <tr><td>Category:</td>          <td><input type="text" name="mCat"></td></tr>
        <tr> <td>Sales (in millions):</td><td><input type="text" name="mSales"></td></tr>

    </table>
    <input type="submit" name="Save" />
</form>
</body>
</html>
