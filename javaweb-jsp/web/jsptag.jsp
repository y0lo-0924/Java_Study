<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/3
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1</h1>
<%--<jsp:include page=""--%>

<%--
http://localhost:8080/jsptag2.jsp?name=y0lo&age=3
--%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="y0lo"></jsp:param>
    <jsp:param name="age" value="2"></jsp:param>

</jsp:forward>
</body>
</html>
