<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 4/22/19
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Congress Members</title>
</head>

<c:import url="header.jsp"/>

<c:import url="navbar.jsp"/>
<body>

<div class="container after-heading">
    <h3>${member.shortTitle} ${member.firstName}  ${member.lastName} - ${member.party}


<%--<c:choose>--%>
    <%--<c:when test="${member.party == 'D'}">--%>
        <%--<span class="blue">${member.party}</span>--%>
    <%--</c:when>--%>
    <%--<c:when test="${member.party.equals('R')}">--%>
        <%--<span class="red">${member.party}</span>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--${member.party}--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>
    </h3>
    <ul>
        <li>State: ${member.state} </li>
        <li>Votes with Party: ${member.votesWithPartyPct}% </li>
        <li>Next Election: ${member.nextElection} </li>
        <li><a href="http://twitter.com/${member.twitterAccount}" target="_blank">Twitter</a></li>
    </ul>
    <c:if test = "${user != null}">
        <p><a href="#" role="button" class="btn btn-primary">Add to My Watch List</a></p>
    </c:if>

    <table class="table-striped">
        <tr><th class="p-4 m-4">Contributor</th><th class="p-4 m-4" >PACs</th><th class="p-4 m-4">Individuals</th><th class="p-4 m-4">Total Amount</th></tr>
        <c:forEach items="${contributors}" var="contributor">
            <%--<c:forEach items="${contributor.getAttributes()}" var="org">&ndash;%&gt;--%>
                <tr class="p-3 m-3">
                    <td class="p-4 m-4">${contributor.getAttributes().orgName}</td>
                    <td class="p-4 m-4">$${contributor.getAttributes().pacs}</td>
                    <td class="p-4 m-4">$${contributor.getAttributes().indivs}</td>
                    <td class="p-4 m-4">$${contributor.getAttributes().total}</td>
                </tr>
            <%--</c:forEach>--%>

        </c:forEach>
    </table>
<%--<h3>${contributors.notice}</h3>--%>
<br/>
<br/>
</div>
</body>
</html>
