<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 5/1/19
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="header.jsp"/>

<c:import url="navbar.jsp"/>
<br/>
<br/>
<br/>
<br/>
<body>
<div class="container">
    <h3 class="center-align after-heading">Uh oh...</h3>
    <br/>
    <p>It looks like the username you wanted has already been snatched up. Please try again.</p><br/><br/>
    <a href="signUp.jsp" role="button" class="btn btn-danger">Okay, I'll try again!</a><br/><br/>
<img src="images/sorry.gif" alt="sorry">

</div>
</body>
</html>
