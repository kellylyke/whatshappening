<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/11/19
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
    <c:import url="header.jsp"/>
</head>
<c:import url="navbar.jsp"/>
<body>
<div class="container after-heading">

<br/>
<h3 class="center-align">Track candidates by searching below</h3>

<form id="searchForm" class="col s10 center-align" action="search" method="post">
    <div class="row">
        <div class="input-field col s4 offset-s4">
            <input type="text" id="searchTerm" name="searchTerm" required="required">
        </div>
    </div>
       <button type="submit" class="btn blue darken-4">Search<i class="material-icons">search</i></button>

</form>
</div>
</body>

</html>
