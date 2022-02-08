<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Optional" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<%
    ResourceBundle bundle = Optional.ofNullable(request.getParameter("lang"))
            .filter("en"::equalsIgnoreCase)
            .map(en -> ResourceBundle.getBundle("todo", Locale.ENGLISH))
            .orElseGet(() -> ResourceBundle.getBundle("todo"));
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=bundle.getString("error_page_title")%></title>
</head>
<body>
<h3><%=bundle.getString("error")%></h3>
  <%=bundle.getString(exception.getMessage())%>
</body>
</html>
