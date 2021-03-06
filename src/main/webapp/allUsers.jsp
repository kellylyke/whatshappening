<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/3/19
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="header.jsp"/>

<c:import url="navbar.jsp"/>
<body>

<div class="container after-heading">

<h3>All Registered Users</h3>

     <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Zipcode</th>

        </tr>
        </thead>

        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a href="delete?id=${user.id}"  onclick="return confirm('Are you sure you want to delete ${user.username}?')">Delete User</a></td>

        </tr>
        </c:forEach>
     </table>

</div>

</body>
<footer>
<br/><br/>
</footer>
</html>

