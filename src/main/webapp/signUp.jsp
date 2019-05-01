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

    <title>Sign Up</title>
    <c:import url="header.jsp"/>

<c:import url="navbar.jsp"/>
<body>
<div class="container after-heading">
<h3 class="center-align">Register</h3>
<br/>

    <form id="signUpForm" class="col s12 center-align" action="signUp" method="post">
        <div class="row center-align">
            <div class="input-field col s5 offset-s1">
            <label class="control-label" for="firstName">First Name</label>
            <input type="text" id="firstName" name="firstName" required="required">
            </div>
            <div class="input-field col s5">
                <label class="control-label" for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" required="required">
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
                <span id='message'></span>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s7 offset-s1">
                <label class="control-label" for="zipcode">Zipcode</label>
                <input type="text" id="zipcode" name="zipcode">
            </div>
        </div>
        <br/>

        <button type="submit" class="btn btn-default ">Sign Up</button>
    </form>
</div>
</body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script>
        $('#password, #confirmPassword').on('keyup', function () {
            if ($('#password').val() === $('#confirmPassword').val()) {
                $('#message').html('Passwords match').css('color', 'green');
            }
            else {
                $('#message').html('Passwords do not match').css('color', 'red');
            }
        });
        // https://stackoverflow.com/questions/27498084/check-if-passwords-match
    </script>
</html>
