<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/9/19
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <c:import url="header.jsp"/>
</head>
<c:import url="banner.jsp"/>
<body>
<h3 class="center-align">Log In</h3>
<div class="row">
    <div class="col s4 offset-s4">
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>Username: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
    </div>
</div>
</body>
</html>



