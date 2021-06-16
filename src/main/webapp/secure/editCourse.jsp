<jsp:useBean id="course" scope="request" type="austral.ing.lab1.model.Course"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Course</title>
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

<header>
    <div class="navbar navbar-dark shadow-sm" style="background-color: cornflowerblue">
        <div class="container">
            <a href="${pageContext.request.contextPath}/secure/home.html" class="navbar-brand d-flex align-items-left" style="font-size: 30px"> Musiquorum </a>
        </div>
    </div>
</header>

<form method="post"  action="${pageContext.request.contextPath}/secure/editCourse.do?courseID=${course.courseID}" >
    <div class="container">
        <div class="shadow-sm p-3 mb-5 bg-white rounded">
            <h1>Edit your course</h1>
            <div class="form-group">
                <label for="name">New Name</label>
                <input type="text" name="name" class = "form-control" id= "name" placeholder="Name" />
            </div>
            <!--
            <div class="form-group">
                <label for="tags">New tags</label>
                <input type="text" class="form-control" id="tags" name="tags" placeholder="Enter tags" />
            </div>
            -->
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" placeholder="Description" />
            </div>
            <button type="submit" class="btn btn-success btn-block" >Submit</button>
        </div>
    </div>
</form>
</body>

</html>
