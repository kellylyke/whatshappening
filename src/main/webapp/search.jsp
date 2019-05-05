<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/11/19
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<html>
<head>
    <title>Search</title>
    <c:import url="header.jsp"/>
</head>
<c:import url="navbar.jsp"/>
<body>
<div class="container after-heading">

<br/>
<h3 class="center-align">Track Candidates by Searching Below</h3>

<form id="searchForm" class="col-s10 center-align form-inline" action="search" method="post">
    <div class="row">
        <div class="col-s6 offset-2">
            <input type="text" class="form-control" id="searchTerm" name="searchTerm" required="required" placeholder="Last Name">

        <button type="submit" class="btn blue darken-4 m-3">Search<i class="material-icons">search</i></button>
        </div>
    </div>

</form>
</div>
</body>

</html>
