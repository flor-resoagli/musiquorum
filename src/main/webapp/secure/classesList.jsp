<%--
  Created by IntelliJ IDEA.
  User: isabelaceriani
  Date: 11/05/2021
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Classes list</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>
<body>
<nav>
    <a href="${pageContext.request.contextPath}/secure/classes-list">Listar clases</a>
</nav>

<h1>Clases de curso</h1>
<ul>
    <c:forEach var="class" items="${classes}">
        <li>${class.name}, ${class.description}</li>

    </c:forEach>
</ul>
</body>
</html>