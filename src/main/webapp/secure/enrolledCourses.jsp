
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Enrolled courses</title>
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

<header>
    <div class="navbar navbar-dark shadow-sm" style="background-color: cornflowerblue">
        <div class="container">
            <a href="${pageContext.request.contextPath}/secure/home.html" class="navbar-brand d-flex align-items-left" style="font-size: 30px"> Musiquorum </a>
        </div>
    </div>
</header>

<main id="main">
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">My Learning</h1>
                <p class="lead text-muted"> Courses you are currently enrolled in! </p>
                <p>
                    <a href="${pageContext.request.contextPath}/secure/searchForCourse.html" class="btn btn-primary my-2"> Search for a course </a>
                    <a href="${pageContext.request.contextPath}/secure/home.html" class="btn btn-secondary my-2"> Back to home</a>
                </p>
            </div>
        </div>
    </section>
    <ul>

        <div class="row">
            <div class="album bg-light" >
                <c:forEach var="course" items="${courses}">
                    <li style="float: left; list-style-type:none; padding-bottom: 20px">
                        <div class="container">
                            <div class="card shadow-sm" style="border-color: cornflowerblue; border-width: 3px; background-color: white">
                                <div class="card-body">
                                    <h5> ${course.name} </h5>
                                    <p class="card-text">${course.description}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath}/secure/studentClasses-list?courseID=${course.courseID}" class="btn btn-primary">View course</a>
                                        </div>
                                        <small class="text-muted">Professor: ${course.professor}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>

            </div>
        </div>
    </ul>
</main>
</body>

<script>
    /*
    var id = parseInt(courseid);
    var color;
    var num = id%4;
    if(num === 0) {color = "#519358";}
    else if(num === 0.25) {color = "#e5c959";}
    else if(num === 0.5) {color = "#c95a5d";}
    else {color = "#6f86ba"}

    document.getElementById("card-header").style.setProperty("background-color", color);
    */
</script>


</html>
