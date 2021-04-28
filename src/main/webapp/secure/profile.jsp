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

</nav>
</body>
</html>