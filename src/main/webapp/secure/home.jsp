<%--
  Created by IntelliJ IDEA.
  User: flopy
  Date: 13/6/2021
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
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
        font-size: 40px;
    }

    p{
        font-size: 15px;
    }

    .sidenav {
        height: 100%;
        width: 0;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: cornflowerblue;
        overflow-x: hidden;
        transition: 0.5s;
        padding-top: 60px;
    }

    .sidenav a {
        padding: 8px 8px 8px 32px;
        text-decoration: none;
        font-size: 25px;
        color: #ffffff;
        display: block;
        transition: 0.3s;
    }

    .sidenav a:hover {
        color: #294983;
        background-color: #e1ebfe;
    }

    .sidenav .closebtn {
        position: absolute;
        top: 0;
        right: 25px;
        font-size: 36px;
        margin-left: 50px;
    }

    #main {
        transition: margin-left .5s;
        padding: 16px;
    }

    #logout:hover{
        color: #bb2d3b;
        background-color: #f3b9be;
    }

    #close:hover{
        background-color: transparent;
    }


</style>
<body>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()" id="close">&times;</a>
    <a href="${pageContext.request.contextPath}/secure/enrolledCoursesList">Enrolled In Courses</a>
    <a href="${pageContext.request.contextPath}/secure/courses-list">My Courses</a>
    <a href="${pageContext.request.contextPath}/secure/searchForCourse.html"> Search for Course</a>
    <a href="${pageContext.request.contextPath}/logout.do" id="logout">Logout </a>
</div>

<div class="navbar navbar-dark shadow-sm" style="background-color: cornflowerblue">
    <div class="container">
        <span style="font-size:30px;cursor:pointer; color:white" onclick="openNav()">&#9776;  Musiquorum  </span>
    </div>
</div>

<div id="main">
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light"> Welcome! </h1>
                <p class="lead text-muted"> </p>
            </div>
        </div>
    </section>

    <div class="row">
        <div class="col-sm-1">
        </div>
        <div class="col-sm-4">
            <iframe src="${pageContext.request.contextPath}/seeProfile.do" width="425px" height="570p"  style="border-color: transparent"> </iframe>
            <button onclick=" document.location = 'modifyProfile.html'">Edit Profile</button>
        </div>
        <div class="col-sm-2"> </div>
        <div class="col-sm-4">
            <div class="container" style="background-color: #e5edfb">
                <h3> Pending Homework </h3>
                <p> ** falta implementacion ** </p>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "400px";
        document.getElementById("main").style.marginLeft = "400px";
    }
    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
    }
</script>

</html>
