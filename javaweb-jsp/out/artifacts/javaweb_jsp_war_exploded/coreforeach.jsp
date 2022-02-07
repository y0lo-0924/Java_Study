<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/3
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<String> people = new ArrayList<>();
    people.add(0,"1");
    people.add(1,"2");
    people.add(2,"3");
    people.add(3,"4");
    people.add(4,"5");
    request.setAttribute("list",people);
%>
<c:forEach var="people" items="${list}">
    <c:out value="${people}"/><br>
</c:forEach>
<c:out value="------------------"/><br>
<c:forEach var="people" items="${list}" begin="0" end="2" step="1">
    <c:out value="${people}"/><br>
</c:forEach>
</body>
</html>
