<%--
  Created by IntelliJ IDEA.
  User: isabelaceriani
  Date: 09/05/2021
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
    body{
        background-color: white;
        font-family: 'Century Gothic';
    }

    button {

        background-color: transparent;
        color: cornflowerblue;
        padding: 10px 10px;
        text-align: center;
        display: inline-block;
        font-size: 20px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
    }

    button:hover {
        color: #294983;
    }

    h1{
        color: black;
        padding-bottom: 10px;
        font-size: 30px;
    }

    p{
        font-size: 15px;
    }

</style>

<body>
<div class="jumbotron-fluid"
     style="background-color: cornflowerblue; color: white; margin-bottom: 40px; padding: 20px" >
    <i class='fas fa-home' style="color: white;font-size:30px "></i> <button style="font-size:30px;cursor:pointer;color:white" onclick="document.location = '/secure/listCourses'"> Musiquorum </button>
</div>


<form method="get" action="/secure/courses/*">
    <div class="container" align="center">
        <h1>${course.name}</h1>
        <h5> ${course.description}</h5>
        <p> CONTENIDO DEL CURSO (CLASES) </p>
        <a href="${pageContext.request.contextPath}/secure/editCourse.do?courseID=${course.courseID}" class="btn btn-primary"> Edit </a>
        <a href="${pageContext.request.contextPath}/secure/listClasses" class="btn btn-primary">View classes</a>
        <a href="/secure/createClass" class="btn btn-primary"> New Class</a>
    </div>
</form>
</body>
</html>
