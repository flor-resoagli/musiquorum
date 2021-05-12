<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de cursos</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
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
        <i class='fas fa-home' style="color: white;font-size:30px "></i> <button style="font-size:30px;cursor:pointer;color:white" onclick="document.location = 'home.html'"> Musiquorum </button>
    </div>

    <div align="center">
        <h1> My Courses </h1>

        <ul>
            <c:forEach var="course" items="${courses}">
                <div style="padding-bottom: 20px" >
                <div class="card" style="width:400px; border-color: cornflowerblue">
                    <div class="card-header" style="background-color: cornflowerblue; color: #ffffff">
                        <h5> ${course.name} </h5>
                    </div>
                    <div class="card-body" style="background-color: #ffffff">
                        <p> ${course.description} </p>

                        <a href="${pageContext.request.contextPath}/secure/courses/${course.courseID}" class="btn btn-primary">Ver</a>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/secure/modifyCourse.html?courseId=${course.courseID}">Editar</a>
                    </div>
                </div>
                </div>
            </c:forEach>
        </ul>

    </div>
</body>


</html>