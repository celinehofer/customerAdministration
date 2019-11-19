<%@page language="java" contentType="text/html; chatset=UTF-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h2>Locations:</h2>
<table>
    <tr>
        <th>id</th>
        <th>postalCode</th>
        <th>city</th>
        <th>country</th>
    </tr>

    <c:forEach items="${locations}" var="location">
        <tr>
            <td>${location.idLocation} |</td>
            <td>${location.postalCode} |</td>
            <td>${location.city} |</td>
            <td>${location.country} |</td>
            <td><a href="showUpdate?id=${location.idLocation}">update |</a></td>
            <td><a href="deleteLocations?id=${location.idLocation}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="showCreate">Add Location</a>
</body>
</html>