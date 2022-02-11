<%-- 
    Document   : addAuthor
    Created on : Feb 11, 2022, 9:13:46 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление книги</title>
    </head>
    <body>
        <h1>Добавить книгу</h1>
        <p>${info}</p>
        <form action="createBook" method="POST">
            Название книги <input type="text" name="bookName" value="${bookName}"><br>
            Авторы 
            <select name="authorsId" multiple="true">
                <c:forEach var="author" items="${authors}">
                    <option value="${author.id}">${author.firstName} ${author.lastName}</option>
                </c:forEach>
            </select>
            Год публикации <input type="text" name="releaseYear"  value="${releaseYear}"><br>
            Количество книг <input type="text" name="quantity" value="${quantity}"><br>
            <input type="submit" value="Запомнить">
        </form>
    </body>
</html>
