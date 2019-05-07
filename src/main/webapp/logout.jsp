<%-------------------------------------------------------------------%>
<%-- Copyright 2013 Code Strategies                                --%>
<%-- This code may be freely used and distributed in any project.  --%>
<%-- However, please do not remove this credit if you publish this --%>
<%-- code in paper or electronic form, such as on a web site.      --%>
<%-------------------------------------------------------------------%>
<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/10/19
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<c:import url="header.jsp"/>

<c:import url="navbar.jsp"/>
<body>
<br/>
<br/>
<div class="container">
    <h5 class="center-align after-heading">User <%=request.getRemoteUser() %> has been logged out. </h5>
<br/><br/>
<img src="images/bye.gif" alt="bye"><br/><br/>
<a href="index.jsp" role="button" class="btn btn-dark">Home</a>


<% session.invalidate(); %>
</body>
</html>