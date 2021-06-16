<%--
  Created by IntelliJ IDEA.
  User: flopy
  Date: 13/6/2021
  Time: 22:09
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

<form method="post" action="/secure/assignments-student/${assignment.assignmentID}" enctype='multipart/form-data'>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">${assignment.title}</h1>
                <p class="lead text-muted"> <b> Instructions: </b> ${assignment.instructions} </p>
                <h3 class="fw-light">Material</h3>
                <div>
                    <a href="${pageContext.request.contextPath}/secure/assignmentResources.do?assignmentID=${assignment.assignmentID}"> Download material  </a>
                </div>

                <%
                    if ("pending".equals(request.getParameter("homeworkStatus"))) {
                %>
                <h2> pending </h2>
                <%
                }
                else if ("completed".equals(request.getParameter("homeworkStatus"))){
                %>
                <h2> completed </h2>
                <%
                } else if("completed".equals(request.getParameter("homeworkStatus"))){
                %>
                <h2> delivered </h2>
                <%
                    }
                %>


                <p>
                    <a href="${pageContext.request.contextPath}/secure/assignmentHandIn.do?assignmentID=${assignment.assignmentID}" class="btn btn-primary my-2"> Hand In </a>
                </p>
            </div>
        </div>
    </section>
</form>

</body>
</html>
