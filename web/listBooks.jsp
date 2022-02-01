<%-- 
    Document   : listBooks
    Created on : Feb 1, 2022, 2:25:06 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <h1>Список книг</h1>
        <select name="listBooks" multiple="true">
            <c:forEach var="book" items="${books}">
                <option value="${book.id}">${book.bookName}. ${book.releaseYear}. 
                    <c:forEach var="author" items="${book.authors}">
                        ${author.firstName} ${author.lastName}.
                    </c:forEach>
                </option>
            </c:forEach>
        </select>
    </body>
</html>
