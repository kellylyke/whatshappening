<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/9/19
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%><%--
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
</html
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"/>
<c:import url="navbar.jsp"/>
<div class="container after-heading">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Sign In</h3>
            </div>
            <div class="card-body">
                <FORM ACTION="j_security_check" METHOD="POST">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                        </div>
                        <INPUT TYPE="TEXT" NAME="j_username" class="form-control" placeholder="username">

                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-key"></i></span>
                        </div>
                        <INPUT TYPE="PASSWORD" NAME="j_password" class="form-control" placeholder="password">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Login" class="btn float-right login_btn">
                    </div>
                </form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    Don't have an account?<a href="signUp.jsp">Sign Up</a>
                </div>
                <div class="d-flex justify-content-center">
                    <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">Forgot your password?</a>
                </div>
            </div>
        </div>
    </div>
</div>