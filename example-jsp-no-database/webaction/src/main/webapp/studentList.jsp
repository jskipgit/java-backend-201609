<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h1>Student Information</h1>
<table border="1" cellpadding="2">
    <tr><th>Last Name</th><th>First Name</th><th>GPA</th></tr>
<c:forEach items="${students}" var="aSingleStudent">

<tr><td align="center"><c:out value="${aSingleStudent.lastName}"/></td><td align="center"><c:out value="${aSingleStudent.firstName}"/></td><td align="center"><a href="/myweb/student?nav=detail&stu=<c:out value="${aSingleStudent.id}"/>"><c:out value="${aSingleStudent.gpa}"/></a></td></tr>
</c:forEach>
</table>
</body>
</html>
