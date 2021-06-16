<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: isabelaceriani
  Date: 18/05/2021
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class Profile</title>
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
    body {
        background-color: white;
        font-family: 'Century Gothic';
    }

    button {

        background-color: white;
        color: cornflowerblue;
        padding: 5px 5px;
        text-align: center;
        display: inline-block;
        font-size: 17px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        margin: 5px;
    }

    button:hover {
        background-color: cornflowerblue; /* Green */
        color: white;
    }

    button:active {
        background-color: cornflowerblue;
        box-shadow: 0 5px #666;
        transform: translateY(4px);
    }

    h1{
        color: black;
        padding-top: 30px;
        font-size: 35px;
        padding-bottom: 20px;

    }

    label{
        color: #2c3034;
        font-size: 20px;
    }

    p{
        font-size: 17px;
    }
</style>
<body>
<header>

    <div class="navbar navbar-dark shadow-sm" style="background-color: cornflowerblue">
        <div class="container">
            <a href="/secure/home.html" class="navbar-brand d-flex align-items-left" style="font-size: 30px"> Musiquorum </a>

        </div>
    </div>
</header>

<form method="get" action="${pageContext.request.contextPath}/secure/classes/*">
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">${classs.className}</h1>
                <p class="lead text-muted"> <b> Duration: </b> ${classs.duration} hours </p>
                <p>
                    <a href="${pageContext.request.contextPath}/secure/class.do?classID=${classs.classID}" class="btn btn-primary my-2"> Edit Class </a>
                    <!--<a href="${pageContext.request.contextPath}/secure/courses/${course.courseID}" class="btn btn-secondary my-2">Back to Course</a> -->
                </p>
                <div class="text-center container">
                <h3 class="fw-light">Material</h3>
                    <ul>
                        <c:forEach var="material" items="${materials}">
                            <div>
                            <li style="float: none; list-style-type:none; padding-bottom: 20px">
                                <a href="${pageContext.request.contextPath}/secure/classResources.do?classID=${classs.classID}&materialID=${material.materialID}"> Download material  </a>
                            </li>
                            </div>
                        </c:forEach>
                    </ul>
                </div>
                <div class="text-center container">
                    <h3 class="fw-light">Assignments</h3>
                    <p class="lead text-muted"> </p>
                    <p>
                        <a href="${pageContext.request.contextPath}/secure/createAssignment.do?classID=${classs.classID}" class="btn btn-primary my-2"> Create Assignment</a>
                    </p>
                </div>
            </div>
        </div>
    </section>

    <form method="post" action="${pageContext.request.contextPath}/secure/assignments-list?classID=${classs.classID}">
        <ul>
            <c:forEach var="assignment" items="${assignments}">
                <li style="float: left; list-style-type:none; padding-bottom: 20px">
                    <div class="container">
                        <div class="card shadow-sm" style="border-color: cornflowerblue; border-width: 3px; background-color: white">
                            <div class="card-body">
                                <h5> ${assignment.title} </h5>
                                <p> <b> Instructions: </b> ${assignment.instructions} </p>
                                <a href="${pageContext.request.contextPath}/secure/homeworkList?assignmentID=${assignment.assignmentID}" class="btn btn-primary"> View assignment</a>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </form>
</form>
</body>


</html>
