<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Course Profile</title>
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
        font-size: 12px;
    }
</style>
<body>
<header>

    <div class="navbar navbar-dark shadow-sm" style="background-color: cornflowerblue">
        <div class="container">
            <a href="${pageContext.request.contextPath}/secure/home.html" class="navbar-brand d-flex align-items-left" style="font-size: 30px"> Musiquorum </a>

        </div>
    </div>
</header>
<section class="py-5 text-center container">
    <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">${course.name}</h1>
            <p class="lead text-muted"> ${course.description} </p>
            <p>
                <a href="${pageContext.request.contextPath}/secure/createClass.do?courseID=${course.courseID}" class="btn btn-primary my-2">New Class</a>
                <a href="${pageContext.request.contextPath}/secure/editCourse.do?courseID=${course.courseID}" class="btn btn-secondary my-2"> Edit Course </a>
            </p>
        </div>
    </div>
</section>

</form>

<form method="post" action="${pageContext.request.contextPath}/secure/classes-list?courseID=${course.courseID}">
    <ul>
        <div class="row">
            <div class="album bg-light" >
                <c:forEach var="classs" items="${classList}">
                    <li style="float: left; list-style-type:none; padding-bottom: 20px">
                        <div class="container">
                            <div class="card shadow-sm" style="border-color: cornflowerblue; border-width: 3px; background-color: white">
                                <div class="card-body">
                                    <h5> ${classs.className} </h5>
                                    <p class="card-text"> <p> <b> Duration: </b> ${classs.duration} hours</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath}/secure/assignments-list?classID=${classs.classID}" class="btn btn-primary">View class</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </div>
        </div>
    </ul>
</form>
</body>
</html>
