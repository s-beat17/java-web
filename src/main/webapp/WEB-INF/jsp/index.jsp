<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<%
    ResourceBundle bundle = Optional.ofNullable(request.getParameter("lang"))
            .filter("en"::equalsIgnoreCase)
            .map(en -> ResourceBundle.getBundle("todo", Locale.ENGLISH))
            .orElseGet(() -> ResourceBundle.getBundle("todo"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
<form action="todo" method="get">
    <input type = "text" name = "name" value="<%=bundle.getString("enter_name")%>"/>
    <input type = "submit" value = "<%=bundle.getString("submit")%>" />
</form>
</body>
