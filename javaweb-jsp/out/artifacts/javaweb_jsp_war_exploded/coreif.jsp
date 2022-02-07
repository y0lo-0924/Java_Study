<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/3
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库，我们才能使用JSTL标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if测试</h4>
<hr>
<form action="coreif.jsp" method="get">
    <%--
    EL表达式获取表单中的数据
    ${param.参数名}
    --%>
    <input type="text" name="username" id="${param.username}">
    <input type="submit" value="登录">
</form>

<%--判断如果提交的用户名是管理员，则登录成功--%>
<%--<%
    if(request.getParameter("username").equals("y0lo"))
    out.print("登录成功");
%>--%>

<c:if test="${param.username=='y0lo'}" var="isAdmin">
    <c:out value="登录成功！"/>
</c:if>

<c:out value="${isAdmin}"/>

</body>
</html>
