<%--
  Created by IntelliJ IDEA.
  User: isabelaceriani
  Date: 09/05/2021
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form method="get" action="/secure/courses/*">
    <div class="container">
        <h1><li>${course.name}</li></h1>
        <a href="${pageContext.request.contextPath}/secure/editCourse.do?courseID=${course.courseID}"> Edit </a>
        <a href="${pageContext.request.contextPath}/secure/classes-list">View classes</a>
        <a href="/secure/createClass"> Create New Class</a>
    </div>
</form>
</body>
</html>
