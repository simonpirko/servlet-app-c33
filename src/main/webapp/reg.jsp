<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<%--POST /reg?login=test&password=test&name=test--%>
<form action="/reg" method="post">
    <input type="text" name="login" maxlength="16" minlength="4" required>
    <input type="text" name="password">
    <input type="text" name="name">
    <button>Registration</button>
</form>
${requestScope.message}
</body>
</html>
