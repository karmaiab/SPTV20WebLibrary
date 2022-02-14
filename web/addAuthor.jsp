<%-- 
    Document   : addAuthor
    Created on : 11.02.2022, 9:15:32
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Author</h1>
        <form action="createAuthor" method="POST">
            Name <input type="text" name="firstName"><br>
            Last Name <input type="text" name="lastName"><br>
            Year of birth <input type="text" name="birthYear"><br>
            <input type="submit" value="Remember">
        </form>
    </body>
</html>
