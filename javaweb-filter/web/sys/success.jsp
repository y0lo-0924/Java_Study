<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/3
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Object user_session = request.getSession().getAttribute("USER_SESSION");
    if(user_session==null){
     response.sendRedirect("/login.jsp");
    }

%>


<h1>主页</h1>

<p><a href="/servlet/logout">注销</a></p>




</body>
</html>
