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
<c:if test = "${members.size() < 1}">
    <p>No members found</p>
</c:if>

    <c:if test = "${members.get(0).lastName == null}">
        <p>Service currently unavailable</p>
    </c:if>
<c:choose>
    <c:when test = "${members.get(0).lastName == 'Dummy'}">
        <p>No members found. (Remember, it's case-sensitive.)</p>
    </c:when>
    <c:otherwise>

        <c:forEach items="${members}" var="member">
            <a href="members?id=${member.crpId}">${member.firstName} ${member.lastName} </a><br/><br/>
            <%--this will need to be id--%>
        </c:forEach>
    </c:otherwise>
</c:choose>
</div>
</body>
</html>
