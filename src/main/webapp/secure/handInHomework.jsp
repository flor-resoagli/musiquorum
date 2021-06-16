<jsp:useBean id="assignment" scope="request" type="austral.ing.lab1.model.Assignment"/>
<%--
  Created by IntelliJ IDEA.
  User: flopy
  Date: 15/6/2021
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hand In Homework</title>
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

<form method="post" action="${pageContext.request.contextPath}/secure/assignmentHandIn.do?assignmentID=${assignment.assignmentID}" enctype='multipart/form-data'>
    <div class="container">


        <div class="shadow-sm p-3 mb-5 bg-white rounded">

            <h1>Hand in your work!</h1>

            <div class="form-group">
                <label for="file">Hand in</label>
                <input type="file" name="file" class = "form-control" id= "file" placeholder="Your work" required/>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <button type="Hand In" class="btn btn-success btn-block">Submit</button>

        </div>
    </div>
</form>
</body>
</html>
