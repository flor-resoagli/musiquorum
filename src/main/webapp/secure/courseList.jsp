<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Lista de cursos</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
</head>
<body>
<nav>
    <a href="${pageContext.request.contextPath}/secure/course-list">Listar Cursos</a>
    <a href="${pageContext.request.contextPath}/logout.do">Logout</a>
</nav>

<h1>Cursos</h1>
<ul>
    <c:forEach var="course" items="${courses}">
        <li>${course.name}, ${course.description}</li>
        <a href="${pageContext.request.contextPath}/secure/courses/${course.courseID}">Ver cursos</a>
    </c:forEach>
</ul>
</body>
</html>