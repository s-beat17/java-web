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
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    if (name == null || name.isBlank())
        throw new IllegalArgumentException("name_expected");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=bundle.getString("todo_list")%></title>
</head>
<body>
<h1> <%=bundle.getString("todo_list_student")%> <%=name%>
</h1>
<%@include file="list.jsp" %>
</body>
</html>
