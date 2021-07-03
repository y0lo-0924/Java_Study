<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/1
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定制错误页面--%>

<%@ page errorPage="error/500.jsp" %>

<%--显示的声明这是一个错误的页面--%>
<%--<%@page isErrorPage="true" %>--%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int x = 1/0;
%>
</body>
</html>
