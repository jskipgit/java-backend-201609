<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Instructions</h2>
<div>
    Input two words and press 'GO!' to see if they are an anagram!
</div>
<form method="post" action="/anagram/tellmeisthisananagramornot">
    One Word: <input type="text" name="oneWord"/>
    Another Word: <input type="text" name="anotherWord"/>
    <div>
        <input type="submit" name="GO!"/>
    </div>

    <div>
        Results: <c:out value="${isAnagram}"/>
    </div>
</form>
</body>
</html>
