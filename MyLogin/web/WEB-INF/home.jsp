<%-- 
    Document   : Home
    Created on : Oct 8, 2020, 12:53:24 PM
    Author     : Nykke
--%>
<%@page import="Servlets.LoginServlet"%>
<%@page import="Servlets.HomeServlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="logout" class="Servlets.LoginServlet"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <form action="home" method="get">
        <h1>Home Page</h1>
        <h4><%="Hello " +  session.getAttribute("userloginname")%></h4>
        <a href name ="logout" value="logout">Logout</a>
        </form>
    </body>
</html>
