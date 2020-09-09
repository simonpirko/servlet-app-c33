<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

Hello ${sessionScope.user}

<c:if test="${sessionScope.user != null}">
    <a href="/logout">Logout</a>
    <a href="/calc">Calculator</a>
    <a href="/history">History</a>
</c:if>
<c:if test="${sessionScope.user == null}">
    <a href="/reg">Registration</a>
    <a href="/auth">Authorization</a>
</c:if>

<%--<c:if test="${requestScope.flag}">--%>
<%--    Hello World!--%>
<%--</c:if>--%>

<%--<c:forEach items="${requestScope.list}" var="item">--%>
<%--    <p>${item}</p>--%>
<%--</c:forEach>--%>


<%--<%=request.getParameter("name")%>--%>

<%--<%--%>

<%--    int a = 2;--%>

<%--    for (int i = 0; i < ; i++) {--%>

<%--    }--%>

<%--%>--%>

<%--<%--%>



<%--%>--%>

<%--<%=request.getAttribute("data")%>--%>

<%--<%! int a = 2;%>--%>

<%--<%--%>

<%--int a = 2;--%>

<%--%>--%>
</body>
</html>
