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
        <li><a href="${member.url}" target="_blank">Website</a></li>
        <li><a href="http://twitter.com/${member.twitterAccount}" target="_blank">Twitter</a></li>
    </ul>
    <c:if test = "${user != null}">
        <c:choose>
        <c:when  test = "${onList == 'yes'}">
            <p><a href="remove?id=${member.crpId}" role="button" class="btn btn-danger">Delete from My Watch List</a></p>
        </c:when>
        <c:otherwise>
            <p><a href="add?id=${member.crpId}&firstName=${member.firstName}&lastName=${member.lastName}" role="button" class="btn btn-primary">Add to My Watch List</a></p>
        </c:otherwise>
        </c:choose>

        <%--<p><a href="add?id=${member.crpId}&firstName=${member.firstName}&lastName=${member.lastName}" role="button" class="btn btn-primary">Add to My Watch List</a></p>--%>
    <%--</c:if>--%>
    <%--<c:if test = "${onList == 'yes'}">--%>
        <%--<p><a href="delete?id=${member.crpId}&firstName=${member.firstName}&lastName=${member.lastName}" role="button" class="btn btn-primary">Delete from My Watch List</a></p>--%>
    </c:if>



<c:choose>
    <c:when test="${contributors == null}">
    <h5>Unfortunately, the finance service is unavailable at the moment or your chosen candidate has no financial data. Check back soon!</h5>
</c:when>
<c:otherwise>

    <table class="table-striped">
        <tr><th class="p-4 m-2">Contributor</th><th class="p-4 m-2">PACs</th><th class="p-4 m-2">Individuals</th><th class="p-4 m-2">Total Amount</th></tr>
        <c:forEach items="${contributors}" var="contributor">
            <%--<c:forEach items="${contributor.getAttributes()}" var="org">&ndash;%&gt;--%>
                <tr class="">
                    <td class="p-4 m-4">${contributor.getAttributes().orgName}</td>
                    <td class="p-4 m-4">$${contributor.getAttributes().pacs}</td>
                    <td class="p-4 m-4">$${contributor.getAttributes().indivs}</td>
                    <td class="p-4 m-4">$${contributor.getAttributes().total}</td>
                </tr>
            <%--</c:forEach>--%>

        </c:forEach>
    </table>


    </c:otherwise>
   </c:choose>
<%--<h3>${contributors.notice}</h3>--%>
<br/>
<br/>
</div>
</body>
</html>
