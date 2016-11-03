<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: jasonskipper
  Date: 9/20/16
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
We did it!
<p/>
<%
    Enumeration e = request.getParameterNames();
    while(e.hasMoreElements()){
        String key = e.nextElement().toString();
%>
        <%=key%> : <%=request.getParameter(key)%> <br>
<%
    }
%>
</body>
</html>
