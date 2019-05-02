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

<c:import url="header.jsp"/>

<c:import url="navbar.jsp"/>
<br/>
<br/>

<body>
<div class="container">
    <h3 class="center-align after-heading">Update Your Account</h3>
    <br/>
   <%-- <div class="d-flex justify-content-center h-100">
        <div class="card-form">

            <div class="card-body">--%>
    <div class="row">
        <div class="col-md-8">

        <form id="updateUser" action="myAccount" method="post">
        <%--<div class="col-md-8">--%>
        <div class="row">
            <div class="col-3">
                <label class="control-label" for="firstName">First Name</label>&nbsp;&nbsp;
            </div>
            <div class="col-5">
                <input class="form-control"  type="text" id="firstName" name="firstName" required="required" value="${user.firstName}">
            </div>

        </div>
        <%--<div class="col-md-8">--%>
            <div class="row">
                <div class="col-3">
                     <label class="control-label" for="lastName">Last Name</label>&nbsp;&nbsp;
                </div>
                <div class="col-5">
                    <input class="form-control" type="text" id="lastName" name="lastName" required="required" value="${user.lastName}">
                 </div>
            </div>
        <div class="row">
                   <div class="col-3">
                    <label class="control-label" for="email">Email</label>&nbsp;&nbsp;
                   </div>
                  <div class="col-5">
                    <input class="form-control"  type="text" id="email" name="email" required="required" value="${user.email}">
                </div>

            </div>
         <div class="row">
                <div class="col-3">
                    <label class="form-check-label" for="zipcode">Zipcode</label>&nbsp;&nbsp;
                </div>
                <div class="col-5">
                    <input class="form-control"  type="text" id="zipcode" name="zipcode" required="required" value="${user.zipcode}">
                </div>
            </div>


            <div class="row">
                <div class="col-3">
                    <label class="form-check-label" for="password"> New Password</label>&nbsp;&nbsp;
                </div>
                <div class="col-5">
                    <input class="form-control"  type="password" id="password" name="password" required="required">
                </div>
            </div>


        <div class="row">
                <div class="col-3">
                    <label class="control-label" for="confirmPassword">Confirm Password</label>&nbsp;&nbsp;
                    <span id='message'></span>
                </div>
            <div class="col-5">
                    <input class="form-control" type="password" id="confirmPassword" name="confirmPassword" required="required">
                </div>
        </div>


        <br/>
        <input type="hidden" id="id" name="id" value="${user.id}"/>
        <input type="hidden" id="username" name="username" value="${user.username}"/>

        <button type="submit" class="btn btn-default">Update</button>
        </form>
    </div>

        <div class="col-md-4">
        <ul>
            <c:forEach items="${preferences}" var="member">
                <li>${member.show}</li>

            </c:forEach>
            </ul>
        </div>
    </div>

   <%--     </div>

</div>
<a href="members?id=${member.crpId}">
</div>--%>

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
</script>
</html>
