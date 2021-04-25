<%--
  Created by IntelliJ IDEA.
  User: 97mus
  Date: 19.04.2021
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/users" method="get">
    <c:forEach items="${requestScope.users}" var="user">
        <div class="alert alert-primary" role="alert">
            Username:${user.username}; First name:${user.fname}; Last name:${user.lname}
    </c:forEach>
</form>
</body>
</html>
