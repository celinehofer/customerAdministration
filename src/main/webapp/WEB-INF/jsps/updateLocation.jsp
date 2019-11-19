<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <title>Update Location</title>
</head>
<body>

<form action="saveLoc" method="post">
    <pre>
        Id: <input type="text" name="id" value="${location.id}" readonly/>
        Code: <input type="text" name="code" value="${location.code}"/>
        Name: <input type="text" name="name" value="${location.name}"/>
        Type: Urban <input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''}/>
              Rural <input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/>
        <input type="submit" value="save"/>
    </pre>
</form>

</body>
</html>