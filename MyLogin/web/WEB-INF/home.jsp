<%-- 
    Document   : Home
    Created on : Oct 8, 2020, 12:53:24 PM
    Author     : Nykke
--%>
<%@page import="Servlets.LoginServlet"%>
<%@page import="Servlets.HomeServlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <form action="" method="POST">
            <h1>Home Page</h1>
            <h4><%="Hello " + session.getAttribute("userloginname")%></h4>
            <button type="submit" name ="logout" value="logout" 
                    style="background:none!important;border:none; padding:0!important;font-family:arial,
                    sans-serif;color:#069;cursor:pointer;">Logout</button>
        </form>
    </body>
</html>
