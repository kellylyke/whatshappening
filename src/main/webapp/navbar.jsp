<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/26/19
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>

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
<header id="header">
    <div class="container">

        <div id="logo" class="pull-left">
            <a href="#hero"><img src="img/logo.png" alt="" title="" /></img></a>
            <!-- Uncomment below if you prefer to use a text logo -->
            <!--<h1><a href="#hero">Regna</a></h1>-->
        </div>

    <nav id="nav-menu-container">

            <ul class="nav-menu">

                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <li><a href="myAccount">My Account</a></li>
                        <li><a href="allUsers">View Users</a></li>
                        <li><a href="logout.jsp">Log Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="signUp.jsp">Sign Up</a></li>
                        <li><a href="redirect">Log In</a></li>

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
    </nav>
</div>
</header>