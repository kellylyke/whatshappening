<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 2/28/19
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.setAttribute("user", request.getRemoteUser());
%>
<div class="container">
<div class="center-align banner">
    <img src="images/banner.jpg" class="responsive-img" alt="banner"/>
</div>
<nav>
    <div class="nav-wrapper">
        <a href="index.jsp">Home</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">

            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li><a href="allUsers">View Users</a></li>
                    <li><a href="logout.jsp">Log Out</a></li>
                    <br />
                </c:when>
                <c:otherwise>
                    <li><a href="signUp.jsp">Sign Up</a></li>
                    <li><a href="">Log In</a></li>
                    <br />
                </c:otherwise>
            </c:choose>

       </ul>
    </div>
<!--
    <div class="nav-wrapper">
        <form>
            <div class="input-field right">
                <input id="search" type="search" required>
                <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                <i class="material-icons">close</i>
            </div>
        </form>
    </div> -->
</nav>
</div>