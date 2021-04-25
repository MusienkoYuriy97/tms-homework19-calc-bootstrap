<%--
  Created by IntelliJ IDEA.
  User: 97mus
  Date: 19.04.2021
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Calc</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<form action="/calc" method="post">
    <div class="mb-3">
        <label for="num1" class="form-label">Number 1</label>
        <input type="text" class="form-control" id="num1" aria-describedby="emailHelp" name = "num1">
    </div>
    <div class="mb-3">
        <label for="num2" class="form-label">Number 2</label>
        <input type="text" class="form-control" id="num2" aria-describedby="emailHelp" name = "num2">
    </div>
    <div class="mb-3">
        <label for="command" class="form-label">Command</label>
        <input type="text" class="form-control" id="command" aria-describedby="emailHelp" name = "command">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

    <c:if test="${requestScope.result != null}">
        <div class="alert alert-primary" role="alert">
                ${requestScope.result}
        </div>
    </c:if>

</form>
</body>
</html>
