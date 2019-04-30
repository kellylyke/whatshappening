<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 4/29/19
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Results</title>

    <c:import url="header.jsp"/>

    <c:import url="navbar.jsp"/>
</head>
<body>
<div class="container after-heading">
    <h3>Search Results</h3>
<c:forEach items="${members}" var="member">
    <a href="/members/?lastName=${member.lastName}">${member.firstName} ${member.lastName} </a><br/><br/>
</c:forEach>
</div>
</body>
</html>
