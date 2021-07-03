<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/1
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@include会将两个页面合二为一--%>
<%--    <%@ include file="common/header.jsp"%>

    <h1>网页主体</h1>
    <%@ include file="common/footer.jsp"%>

    <hr>--%>

<%--jsp标签--%>
<%--jsp:include 拼接页面，本质还是三个--%>
<jsp:include page="/common/header.jsp"/>
<h1>网页主体</h1>
<%
<%--    把三个网页拼在一起，也不会影响定义的相同的变量--%>
    int i =0;
%>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
