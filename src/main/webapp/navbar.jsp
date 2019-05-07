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

<header id="header" class="header-fixed">
    <div class="container">

        <div id="logo" class="pull-left">
            <%--<a href="#hero"><img src="img/logo.png" alt="" title="" /></a>--%>
            <!-- Uncomment below if you prefer to use a text logo -->
            <h1><a href="index.jsp">what's happening</a></h1>
        </div>
        <%--
                <nav id="nav-menu-container">
                    <ul class="nav-menu">
                        <li class="menu-active"><a href="#hero">Home</a></li>
                        <li><a href="#about">About Us</a></li>
                        <li><a href="signUp">Sign Up</a></li>
                        <li><a href="redirect">Log In</a></li>
                        <li><a href="#team">Team</a></li>

                        <li><a href="#contact">Contact Us</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->--%>

    <nav id="nav-menu-container">

            <ul class="nav-menu">
                <li><a href="search.jsp">Search</a></li>
                <c:choose>
                    <c:when test="${sessionScope.user != null}">

                        <li><a href="myAccount">My Account</a></li>

                        <li><a href="logout.jsp">Log Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="signUp.jsp">Sign Up</a></li>

                        <li><a href="redirect">Log In</a></li>

                    </c:otherwise>
                </c:choose>
               <%-- <li><form id="searchForm" action="search" method="post">
                    <div class="input-field">
                        <input id="search" type="search" required>
                        <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                        <i class="material-icons">close</i>
                    </div>
                </form></li>--%>
            </ul>
    </nav>
    </div>
</header>
<%--</div>
</header>--%>


<%--
<nav id="nav-menu-container">
    <ul class="nav-menu">
        <li class="menu-active"><a href="#hero">Home</a></li>
        <li><a href="#about">About Us</a></li>
        <li><a href="signUp">Sign Up</a></li>
        <li><a href="redirect">Log In</a></li>
        <li><a href="#team">Team</a></li>

        <li><a href="#contact">Contact Us</a></li>
    </ul>
</nav><!-- #nav-menu-container -->--%>
