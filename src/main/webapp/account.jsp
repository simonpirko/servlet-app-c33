<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 9/8/20
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>account</title>
</head>
<body>
    <form action="/account" method="post">
        <input name="value" type="text" placeholder="login" required maxlength="50" minlength="3">
        <select name="field" >
            <option value="name">update name</option>
            <option value="password">update password</option>
        </select>
        <button>update</button>
    </form>
    ${requestScope.message}
    <a href="/calc">calc</a>
</body>
</html>
