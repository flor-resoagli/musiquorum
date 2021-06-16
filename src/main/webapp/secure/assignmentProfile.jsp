<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: isabelaceriani
  Date: 09/06/2021
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignment Profile</title>
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
            <a href="${pageContext.request.contextPath}/secure/home.html" class="navbar-brand d-flex align-items-left" style="font-size: 30px"> Musiquorum </a>
        </div>
    </div>
</header>

<form method="post" action="/secure/assignments/${assignment.assignmentID}" enctype='multipart/form-data'>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">${assignment.title}</h1>
                <p class="lead text-muted"> <b> Consigna: </b> ${assignment.instructions} </p>
                <p>
                    <!-- <a href="${pageContext.request.contextPath}/secure/assignment.do?classID=${assignment.assignmentID}" class="btn btn-primary my-2"> Edit </a> -->
                </p>
                <div>
                    <a href="${pageContext.request.contextPath}/secure/assignmentResources.do?assignmentID=${assignment.assignmentID}"> Download material  </a>
                </div>
            </div>
        </div>
    </section>

    <section class="py-5 text-center container">
        <form method="post" action="${pageContext.request.contextPath}/secure/homeworkList?assignmentID=${assignment.assignmentID}" enctype="multipart/form-data">
            <ul>
                <c:forEach var="homework" items="${homeworks}">
                    <li style="float: left; list-style-type:none;">
                        <div class="container align-content-center">
                        <div class="card shadow-sm" style="border-color: cornflowerblue; border-width: 2px; width: 500px; padding-bottom: 20px;">
                            <div class="card-body">
                                <p> <b> Submitted by: </b> ${homework.studentEmail} </p>
                            </div>
                            <a href="${pageContext.request.contextPath}/secure/homeworkResources.do?assignmentID=${assignment.assignmentID}&studentEmail=${homework.studentEmail}"> See Submission  </a>
                            </div>
                            <div class="card-footer">
                                <p> ${homework.status}</p>
                                <a href="${pageContext.request.contextPath}/secure/markHomeworkAsComplete.do?assignmentID=${assignment.assignmentID}&studentEmail=${homework.studentEmail}" class="btn btn-outline-success">  Mark as Completed </a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </form>
    </section>


</form>
</body>


</html>