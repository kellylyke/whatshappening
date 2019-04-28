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
    <h3>${member.shortTitle} ${member.firstName}  ${member.lastName} - ${member.party}  </h3>
    <ul>
        <li>State: ${member.state} </li>
        <li>Votes with Party: ${member.votesWithPartyPct}% </li>
        <li>Next Election: ${member.nextElection} </li>
        <li><a href="http://twitter.com/${member.twitterAccount}" alt="twitter" target="_blank">Twitter</a></li>
    </ul>

</div>
</body>
</html>
