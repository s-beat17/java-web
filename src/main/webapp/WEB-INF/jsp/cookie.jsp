<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
<h1>Посещений: <%=session.getAttribute("visits")%></h1>
<form action="setcookie" method="get">
    <input type = "text" name = "name" value="введите имя"/>
    <input type = "text" name = "colour" value="введите цвет"/>
    <input type = "submit" value = "подтвердить" />
</form>
</body>
