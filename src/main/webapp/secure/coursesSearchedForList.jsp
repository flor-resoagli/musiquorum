<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: isabelaceriani
  Date: 02/06/2021
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses Seacrch List</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
<%--    <script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>--%>
</head>

<style>
    body{
        background-color: white;
        font-family: 'Century Gothic';
    }

    h1{
        color: black;
        padding-bottom: 10px;
        font-size: 40px;
    }

    p{
        font-size: 15px;
    }

</style>

<header>
    <div class="navbar navbar-dark shadow-sm" style="background-color: cornflowerblue">
        <div class="container">
            <a href="${pageContext.request.contextPath}/secure/home.html" class="navbar-brand d-flex align-items-left" style="font-size: 30px"> Musiquorum </a>
        </div>
    </div>
</header>
<main id="main">
    <form method="post" action="${pageContext.request.contextPath}/searchForCourse.do">
        <section class="py-5 text-center container">
            <div class="row py-lg-5">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <h1 class="fw-light">Course Search</h1>
                    <p class="lead text-muted"> Courses found that match your search! </p>
                    <p>
                        <a href="${pageContext.request.contextPath}/secure/searchForCourse.html" class="btn btn-primary my-2"> Back to search</a>
                        <a href="${pageContext.request.contextPath}/secure/home.html" class="btn btn-secondary my-2"> Back to home</a>
                    </p>
                </div>
            </div>
        </section>
        <ul>
            <c:forEach var="course" items="${courses}">
            <div class="album py-5 bg-light">
                <div class="container">
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                        <div class="col">
                            <div class="card shadow-sm" style="border-color: cornflowerblue; border-width: 3px; background-color: white">
                                <div class="card-body">
                                    <h5> ${course.name} </h5>
                                    <p class="card-text">${course.description}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath}/secure/enrollToCourse/${course.courseID}" class="btn btn-primary">Enroll for free</a>
                                        </div>
                                        <small class="text-muted">Professor: ${course.professor}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </ul>
    </form>
</main>


</html>
