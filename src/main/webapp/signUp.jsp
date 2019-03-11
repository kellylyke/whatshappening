<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/10/19
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign Up</title>
    <c:import url="header.jsp"/>
</head>
<c:import url="banner.jsp"/>
<body>
<div class="container">
<h3 class="center-align">Register</h3>
<br/>

    <form id="signUpForm" class="col s12 center-align" action="signUpUser" method="post">
        <div class="row center-align">
            <div class="input-field col s5 offset-s1">
            <label class="control-label" for="firstName">First Name</label>
            <input type="text" id="firstName" name="first_name" required="required">
            </div>
            <div class="input-field col s5">
                <label class="control-label" for="lastName">Last Name</label>
                <input type="text" id="lastName" name="last_name" required="required">
            </div>
        </div>
        <div class="row">
            <div class="input-field col s5 offset-s1">
                <label class="control-label" for="username">Username</label>
                <input type="text" id="username" name="username" required="required">
            </div>

            <div class="input-field col s5">
                <label class="control-label" for="email">Email</label>
                <input type="text" id="email" name="email" required="required">
            </div>
        </div>

        <div class="row">
            <div class="input-field col s7 offset-s1">
                <label class="control-label" for="password">Password</label>
                <input type="password" id="password" name="password" required="required">
            </div>
        </div>
        <div class="row">
            <div class="input-field col s7 offset-s1">
                <label class="control-label" for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required="required">
            </div>
        </div>
        <br/>

        <button type="submit" class="btn btn-default ">Sign Up</button>
    </form>
</div>
</body>

</html>
