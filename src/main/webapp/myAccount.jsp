<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/11/19
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Account</title>
    <c:import url="header.jsp"/>
</head>
<c:import url="banner.jsp"/>
<body>
<div class="container">
    <h3 class="center-align">Update Your Account</h3>
    <br/>
    <form id="updateUser" class="col s12 center-align" action="myAccount" method="post">
        <div class="row">
            <div class="input-field col s5 offset-s1">
            <label class="control-label" for="firstName">First Name</label>
            <input type="text" id="firstName" name="firstName" required="required" value="${user.firstName}">
            </div>
            <div class="input-field col s5 offset-s1">
                <label class="control-label" for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" required="required" value="${user.lastName}">
            </div>
            <div class="row">
                <div class="input-field col s5 offset-s1">
                    <label class="control-label" for="email">Email</label>
                    <input type="text" id="email" name="email" required="required" value="${user.email}">
                </div>
            </div>
            <div class="row">
                <div class="input-field col s5 offset-s1">
                    <label class="control-label" for="zipcode">Zipcode</label>
                    <input type="text" id="zipcode" name="zipcode" required="required" value="${user.zipcode}">
                </div>
            </div>

            <div class="row">
                <div class="input-field col s7 offset-s1">
                    <label class="control-label" for="password">Password</label>
                    <input type="password" id="password" name="password" required="required" value="${user.password}">
                </div>
            </div>
            <div class="row">
                <div class="input-field col s7 offset-s1">
                    <label class="control-label" for="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required="required">
                </div>
            </div>
        </div>
        <br/>
        <input type="hidden" id="id" name="id" value="${user.id}"/>
        <input type="hidden" id="username" name="username" value="${user.username}"/>

        <button type="submit" class="btn btn-default ">Update</button>
    </form>



</div>
</body>

</html>
