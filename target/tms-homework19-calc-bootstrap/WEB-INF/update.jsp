<%--
  Created by IntelliJ IDEA.
  User: 97mus
  Date: 20.04.2021
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/update" method="post">
    <div class="mb-3">
        <label for="password1" class="form-label">New password</label>
        <input type="password" class="form-control" id="password1" aria-describedby="emailHelp" name = "new_password">
    </div>
    <div class="mb-3">
        <label for="password2" class="form-label">Repeated new password</label>
        <input type="password" class="form-control" id="password2" name = "repeated_new_password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<c:if test="${requestScope.upmessage != null}">
    <div class="alert alert-primary" role="alert">
            ${requestScope.upmessage}
    </div>
</c:if>
</body>
</html>
