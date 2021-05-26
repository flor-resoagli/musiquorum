<%@ page import="static austral.ing.lab1.util.LangUtils.notEmpty" %>
<%@ page import="static austral.ing.lab1.util.LangUtils.notEmpty" %>
<%@ page import="static austral.ing.lab1.util.LangUtils.*" %>
<%@ page import="static austral.ing.lab1.util.LangUtils.*" %>
<%@ page import="austral.ing.lab1.model.User" %>
<%@ page import="java.util.Optional" %>
<%@ page import="austral.ing.lab1.entity.Users" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="austral.ing.lab1.util.EntityManagers" %>
<%@ page import="austral.ing.lab1.util.Servlets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
<h1>Perfil</h1>
<nav>
    <a href="${pageContext.request.contextPath}/secure/seeProfile">Perfil</a>

    <form method="get" action="/secure/seeProfile.do">

        <style>
            body{
    out.println("           font-family: 'Century Gothic';");
    out.println("       }");
    out.println("  </style>");
    out.println("  <body>");
    out.println("       <div class=\"card\" style=\"width:400px\" align= \"center\">");
        out.println("               <img class=\"card-img-top\" src=\"../images/img_avatar1.png\" style=\"width:100%\" alt=\"Profile Picture\">");
        out.println("               <div class=\"card-body\">");
            out.println("                   <h4 class=\"card-title\"> <b>" + notEmpty(user.getFirstName(), "None") + " " + notEmpty(user.getLastName(), "None") +  "</b> </h4>");
            out.println("                   <p class=\"card-text\" style=\"font-size:15px\"> **User Bio** </p>");
            out.println("                   <p> <b> Email: </b>" +  notEmpty(user.getEmail(), "None") + "</p>");
            out.println("       </div");
                out.println("  </body>");
    out.println("</html>");



    </form>

</nav>
</body>
</html>