<jsp:useBean id="classs" scope="request" type="austral.ing.lab1.model.Class"/>
<%--
  Created by IntelliJ IDEA.
  User: flopy
  Date: 26/5/2021
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Class Material</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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

<div class="jumbotron-fluid"
     style="background-color: cornflowerblue; color: white; margin-bottom: 20px; padding: 20px" >
    <h2> Musiquorum </h2>
</div>

<form method="post" action="${pageContext.request.contextPath}/secure/classMaterial.do?classID=${classs.classID}" enctype='multipart/form-data'>
    <div class="container">


        <div class="shadow-sm p-3 mb-5 bg-white rounded">

            <h1>Add new material to the class</h1>

            <div class="form-group">
                <label for="file">Material</label>
                <input type="file" name="file" class = "form-control" id= "file" placeholder="Material" required/>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <button type="Submit" class="btn btn-success btn-block">Submit</button>
            <button class="btn-light btn-block" onclick="document.location = '/secure/classes/${classs.classID}'"> Cancel</button>
        </div>
    </div>


</form>

</body>
</html>
