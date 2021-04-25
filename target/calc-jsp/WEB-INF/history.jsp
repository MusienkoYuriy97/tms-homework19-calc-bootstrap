<%--
  Created by IntelliJ IDEA.
  User: 97mus
  Date: 19.04.2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/history" method="get">
    <c:forEach items="${requestScope.operations}" var="operation">
        <div class="alert alert-primary" role="alert">
            x:${operation.x} operation:${operation.operationType} y:${operation.y} result:${operation.result}  username:${operation.userName}
        </div>
    </c:forEach>
</form>

</body>
</html>
