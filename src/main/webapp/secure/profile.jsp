
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
<h1>Perfil</h1>

    <form method="get" action="/seeProfile.do">

        <style>
            body{
                font-family: 'Century Gothic';");
                }
        </style>

            <div class="card" style=\"width:400px\" align= "center">
                <img class="card-img-top" src="../images/img_avatar1.png" style="width:100%" alt="Profile Picture">
                       <div class="card-body">
                               <h4 class="card-title"> <b> ${user.firstName} ${user.lastName} </b> </h4>
                               <p> <b> Email: </b> ${user.email}  </p>
                       </div>
            </div>
    </form>

</body>
</html>