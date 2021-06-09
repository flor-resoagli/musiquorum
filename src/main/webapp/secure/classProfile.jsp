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

<div class="jumbotron-fluid"
     style="background-color: cornflowerblue; color: white; margin-bottom: 20px; padding: 20px" >
    <h2> Musiquorum </h2>
</div>

<form method="get" action="${pageContext.request.contextPath}/secure/classes/*">
    <div class="container">
        <h1>${classs.className}</h1>
        <p> <b> Duration: </b> ${classs.duration} hours</p>
        <div>
            <a href="${pageContext.request.contextPath}/secure/class.do?classID=${classs.classID}" class="btn btn-primary"> Edit </a>
        </div>

                <h4>Material</h4>
                <div>
                <c:forEach var="material" items="${materials}">
                    <a href="${pageContext.request.contextPath}/secure/classResources.do?classID=${classs.classID}&materialID=${material.materialID}"> Download material  </a>
                </c:forEach>
                </div>


                <h4>Assignments</h4>

                <div>
                    <a href="${pageContext.request.contextPath}/secure/createAssignment.do?classID=${classs.classID}" class="btn btn-primary"> Create a New Assignment</a>
                    <a href="${pageContext.request.contextPath}/secure/assignments-list?classID=${classs.classID}" class="btn btn-primary">View Assignments</a>
                </div>
            </div>
    </div>
</form>
</body>


</html>
