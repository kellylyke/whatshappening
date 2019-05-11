<%--
  Created by IntelliJ IDEA.
  User: klyke
  Date: 3/24/19
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="header.jsp"/>

<body>


<c:import url="navbar.jsp"/>


<!--==========================
  Hero Section
============================-->
<section id="hero">
    <div class="hero-container">
        <h1>what's happening</h1>
        <h2>Keeping you up to date about the doings of Congress</h2>
        <a href="signUp.jsp" class="btn-get-started">Get Started</a>
    </div>
</section><!-- #hero -->

<main id="main">
    <%--<div class="container">
        <c:import url="login.jsp"/>
    </div>
--%>

    <!--==========================
      About Us Section
    ============================-->
    <section id="about">
        <div class="container">
            <div class="row about-container">

                <div class="col-lg-6 content order-lg-1 order-2">
                    <h2 class="title">Few Words About Us</h2>

                        <p><span class="navy">If everyone who took money in return for promising to do something if they were
                            re-elected [was prosecuted], we wouldn’t have anyone left in Congress."</span><br/>

                       &nbsp;&nbsp;&nbsp;– Brigid Harrison,
                        Professor of Political Science and Law at Montclair State University</p>



                    <div class="icon-box wow fadeInUp">
                        <div class="icon"><i class="fa fa-money"></i></div>
                        <h4 class="title"><a href="">Money</a></h4>
                        <p class="description">Our goal is to keep you informed about candidates and who/what is putting money in to them.</p>
                    </div>

                    <div class="icon-box wow fadeInUp" data-wow-delay="0.2s">
                        <div class="icon"><i class="fa fa-check-square-o"></i></div>
                        <h4 class="title"><a href="">Influence</a></h4>
                        <p class="description">Does it sway their votes? Do they take business dollars? We give you the facts. You be the judge.</p>
                    </div>
                    <div class="icon-box wow fadeInUp" data-wow-delay="0.4s">
                        <div class="icon"><i class="fa fa-university"></i></div>
                        <h4 class="title">Shameless Plug ¯\_(ツ)_/¯</h4>
                        <p class="description"><a href="https://www.opensecrets.org/2020-presidential-race/candidate?id=N00044183"><img src="images/fish.gif" alt="pete"/></a></p>
                    </div>

                </div>

                <div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight"></div>
            </div>

        </div>


    </section><!-- #about -->

    <!--==========================
      Facts Section
    ============================-->
    <section id="facts">
        <div class="container wow fadeIn">
            <div class="section-header">
                <h3 class="section-title">Facts</h3>
                <p class="section-description">These are facts</p>
            </div>
            <div class="row counters">

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">535</span>
                    <p>Members of Congress</p>
                </div>

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">99</span>
                    <p>Percent of donors who gave less than $200</p>
                </div>

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">29</span>
                    <p>Percent of total from donors who gave less than $200</p>
                </div>

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">1</span>
                    <p>People it takes to make a difference (it's you!)</p>
                </div>

            </div>

        </div>
    </section><!-- #facts -->


    <!--==========================
    Call To Action Section
    ============================-->
    <section id="call-to-action">
        <div class="container wow fadeIn">
            <div class="row">
                <div class="col-lg-9 text-center text-lg-left">
                    <h3 class="cta-title">Call To Action</h3>
                    <p class="cta-text"> Don't take it from me. Investigate yourself. Keep politicians accountable.</p>
                </div>
                <div class="col-lg-3 cta-btn-container text-center">
                    <a class="cta-btn align-middle" href="https://www.google.com/search?q=money+in+politics" target="blank">Call To Action</a>
                </div>
            </div>

        </div>
    </section><!-- #call-to-action -->



    <!--==========================
      Team Section
    ============================-->
    <section id="team">
        <div class="container wow fadeInUp">
            <div class="section-header">
                <h3 class="section-title">Featured</h3>
                <p class="section-description">Check out some popular members of congress</p>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="member">
                        <div class="pic"><img src="images/aoc.jpg" alt=""></div>
                        <a href="https://www.opensecrets.org/members-of-congress/summary?cid=N00041162&cycle=2018" target="blank"><h4>Alexandria Ocasio-Cortez</h4></a>
                        <span>House of Representatives - New York 14th District</span>
                        <div class="social">
                            <a href="https://twitter.com/AOC" target="blank"><i class="fa fa-twitter"></i></a>

                            <br/>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="member">
                        <div class="pic"><img src="images/harris.jpeg" alt=""></div>
                       <a href="members?id=N00036915"><h4>Kamala Harris</h4></a>
                        <span>Senator - California</span>
                        <div class="social">
                            <a href="https://twitter.com/KamalaHarris" target="blank"><i class="fa fa-twitter"></i></a>
                            <br/>

                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="member">
                        <div class="pic"><img src="images/portman.jpg" alt=""></div>
                        <a href="members?id=N00003682"><h4>Rob Portman</h4></a>
                        <span>Senator - Ohio</span>

                        <div class="social">
                            <a href="https://twitter.com/senrobportman" target="blank"><i class="fa fa-twitter"></i></a>
                            <br/>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="member">
                        <div class="pic"><img src="images/mark.jpg" alt=""></div>
                        <a href="members?id=N00033549"><h4>Mark Pocan</h4></a>
                        <span>House of Representatives - Wisconsin 2nd District </span>
                        <div class="social">
                            <a href="https://twitter.com/repmarkpocan" target="blank"><i class="fa fa-twitter"></i></a>
                            <br/>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section><!-- #team -->

    <!--==========================
      Contact Section
    ============================-->
    <section id="contact">
        <div class="container wow fadeInUp">
            <div class="section-header">
                <h3 class="section-title">Contact</h3>
                <p class="section-description">We suggest the old ding dong ditch but you do you.</p>
            </div>
        </div>

        <!-- Uncomment below if you wan to use dynamic maps -->
        <iframe src="https://www.google.com/maps/d/embed?mid=1Diz3RFbrt9DDRsLcakSDaLOT61g&hl=en" width="100%" height="380" frameborder="0" style="border:0" allowfullscreen></iframe>

        <div class="container wow fadeInUp mt-5">
            <section class="row justify-content-center">

                <div class="col-lg-3 col-md-4">

                    <div class="info">
                        <div>
                            <i class="fa fa-map-marker"></i>
                            <p>1600 Pennsylvania Avenue NW<br>Washington, DC 20500</p>
                        </div>

                        <div>
                            <i class="fa fa-envelope"></i>
                            <p>president@whitehouse.gov</p>
                        </div>

                        <div>
                            <i class="fa fa-phone"></i>
                            <p>202-456-1111</p>
                        </div>
                    </div>

                    <div class="social-links">
                        <a href="https://twitter.com/fanniepacker" class="twitter"><i class="fa fa-twitter"></i></a>
                        <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                        <a href="https://www.instagram.com/kelly.lyke/" class="instagram"><i class="fa fa-instagram"></i></a>
                        <a href="https://www.linkedin.com/in/kelly-lyke" class="linkedin"><i class="fa fa-linkedin"></i></a>
                        <a href="https://www.github.com/kellylyke" class="github"><i class="fa fa-github"></i></a>

                    </div>

                </div>

            </section>

<!--==========================
  Footer
============================-->
<footer id="footer">
    <div class="footer-top">
        <div class="container">

        </div>
    </div>

    <div class="container">
        <div class="copyright">
            &copy; Copyright <strong>2019</strong>. All Rights Reserved
        </div>
        <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Regna
            -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
    </div>

</footer><!-- #footer -->

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/jquery/jquery-migrate.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/superfish/hoverIntent.js"></script>
<script src="lib/superfish/superfish.min.js"></script>

<!-- Contact Form JavaScript File -->
<script src="contactform/contactform.js"></script>

<!-- Template Main Javascript File -->
<script src="js/main.js"></script>

</div>
    </section>
</main>

</body>
</html>
