<%-- 
    Document   : Login
    Created on : Oct 8, 2020, 12:06:00 PM
    Author     : Nykke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1> Login</h1>
        <form action ="login" method="POST" autocomplete="off">
            <label>Username: </label>
            <input type="text" name ="username"><br>
            <label>Password: </label>
            <input type="password" name ="password"><br>
            <button type ="submit" >Login</button>
        </form>
    </body>
</html>
