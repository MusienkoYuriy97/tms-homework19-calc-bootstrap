<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<form action="/signin" method="get">
    <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" aria-describedby="emailHelp" name = "username">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name = "password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<c:if test="${requestScope.smessage != null}">
    <div class="alert alert-primary" role="alert">
            ${requestScope.smessage}
    </div>
</c:if>
</body>
</html>
