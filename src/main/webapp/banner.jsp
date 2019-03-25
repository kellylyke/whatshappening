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
    <%--<img src="images/banner.jpg" class="responsive-img" alt="banner"/>--%>
    <img src="images/banner2.png" class="responsive-img" alt="banner"/>

</div>
<nav class="">
    <div class="nav-wrapper">
        <a href="index.jsp">&nbsp;Home</a>
<%--
        <ul id="nav-mobile" class="right hide-on-med-and-down">
--%>
        <ul class="right">

           <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li><a href="myAccount">My Account</a></li>
                    <li><a href="allUsers">View Users</a></li>
                    <li><a href="logout.jsp">Log Out</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="signUp.jsp">Sign Up</a></li>
                    <li><a href="login.jsp">Log In</a></li>

                </c:otherwise>
            </c:choose>
            <li><form id="searchForm" action="search" method="post">
                <div class="input-field">
                    <input id="search" type="search" required>
                    <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                    <i class="material-icons">close</i>
                </div>
            </form></li>
       </ul>
    </div>
</nav>
</div>