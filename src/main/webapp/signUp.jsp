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
<head>
    <title>Sign Up</title>
</head>
<c:import url="navbar.jsp"/>
<body>
<div class="container after-heading">
    <br/>
<h3 class="text-center">Register</h3>
<%--<br/>--%>
<%--<div class="col-sm-8>">--%>
    <%--<form id="signUpForm" class="form-inline" action="signUp" method="post">--%>
        <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
            <%--<div class="form-group col-sm-4 pull-right">--%>
                         <%--<label class="control-label" for="firstName">First Name</label>--%>
            <%--</div>--%>

            <%--<div class="form-group col-sm-4">--%>
                <%--<input class="form-control" type="text" id="firstName" name="firstName" required="required">--%>
            <%--</div>--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
             <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
                        <%--<div class="form-group col-sm-4">--%>
                              <%--<label class="control-label pull-right" for="lastName">Last Name</label>--%>
                        <%--</div>--%>
                        <%--<div class="form-group col-sm-4 pull-right">--%>
                            <%--<input class="form-control" type="text" id="lastName" name="lastName" required="required">--%>
                        <%--</div>--%>
             <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                      <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--<div class="row">--%>
            <%--&lt;%&ndash;<div class="input-field">&ndash;%&gt;--%>
            <%--<div class="form-group col-sm-4">--%>
                <%--<label class="control-label"  for="username">Username</label>--%>
            <%--</div>--%>
            <%--<div class="form-group col-sm-4">--%>
                <%--<input  class="form-control" type="text" id="username" name="username" required="required">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-4">--%>
                <%--<label class="control-label pull-right" for="email">Email</label>--%>
            <%--</div>--%>
            <%--<div class="for-group col-sm-4">--%>
                <%--<input  class="form-control" type="text" id="email" name="email" required="required">--%>
            <%--</div>--%>

        <%--</div>--%>



        <%--<div class="row">--%>
            <%--<div class="form-group col-sm-4">--%>
                    <%--<label class="control-label" for="password">Password</label>--%>
                    <%--<input class="form-control" type="password" id="password" name="password" required="required">--%>
             <%--</div>--%>
            <%--<div class="form-group col-sm-4">--%>

                    <%--<label class="control-label" for="confirmPassword">Confirm Password</label>--%>
                    <%--<input class="form-control" type="password" id="confirmPassword" name="confirmPassword" required="required">--%>
                    <%--<span id="message"></span>--%>

            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="col-sm-4">--%>
                <%--<div class="input-field">--%>
                    <%--<label class="control-label" for="zipcode">Zipcode</label>--%>
                    <%--<input class="form-control" type="number" id="zipcode" name="zipcode">--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<br/>--%>

        <%--<button type="submit" class="btn btn-default ">Sign Up</button>--%>
    <%--</form>--%>
<%--</div>--%>
    <form id="signUpForm" action="signUp" method="post">
        <div class="row">
            <div class="col-6"><!--left side -->
                <div class="form-group row">
                    <label for="firstName" class="col-sm-4 col-form-label text-right">First Name:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="firstName" name="firstName" required="required">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastName" class="col-sm-4 col-form-label text-right">Last Name:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="lastName" name="lastName" required="required">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="username" class="col-sm-4 col-form-label text-right">Username:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" name="username" required="required">
                    </div>
                </div>



                <div class="form-group row">
                    <label for="email" class="col-sm-4 col-form-label text-right">Email:</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" id="email" name="email" required="required">
                    </div>

                </div>
            </div>
            <div class="col-6">
                <div class="form-group row">
                    <label for="password" class="col-sm-4 col-form-label text-right">Password:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" name="password" required="required">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="confirmPassword" class="col-sm-4 col-form-label text-right">Confirm Password:</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required="required">
                        <div class="text-center">
                            <span id="message"></span>
                        </div>
                    </div>
                </div>

                    <div class="form-group row">
                        <label for="zipcode" class="col-sm-4 col-form-label text-right">Zipcode:</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" name="zipcode" id="zipcode">
                        </div>
                    </div>

            </div>





        </div>
        <br/>

            <div class="text-center">
                <button type="submit" class="btn btn-default align-content-center">Sign Up</button>
            </div>
    </form>
</div>
<br/><br/>
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
