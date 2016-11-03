<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Input Examples</title>
</head>
<body>
<form method="post" action="/myweb/inputreader">
    First name:<br>
    <input type="text" name="firstname" >
    <br>
    Last name:<br>
    <input type="text" name="lastname" value="Mouse">
    <br><br>
    <input type="radio" name="gender" value="male" checked> Male<br>
    <input type="radio" name="gender" value="female" > Female<br>
    <input type="radio" name="gender" value="other"> Other
    <br>
    <input type="number" name="quantity" min="1" max="5">
<br>
    <input type="checkbox" name="vehicle1" value="Bike"> I have a bike<br>
    <input type="checkbox" name="vehicle2" value="Car"> I have a car
    <br>
    <input type="reset">

    <br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
