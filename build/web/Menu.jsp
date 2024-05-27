<%-- 
    Document   : Menu
    Created on : 18 thg 5, 2024, 23:27:13
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Barenché - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <!-- END nav -->

        <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_3.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-end justify-content-center">
                    <div class="col-md-9 ftco-animate text-center mb-4">
                        <h1 class="mb-2 bread">Specialties</h1>
                        <p class="breadcrumbs"><span class="mr-2"><a href="Home.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Menu <i class="ion-ios-arrow-forward"></i></span></p>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-section">
            <div class="container">
                <div class="ftco-search">
                    <div class="row">
                        <div class="col-md-12 nav-link-wrap">
<<<<<<< HEAD

=======
                            
>>>>>>> d6537f1ce5a6d39b10d80028a578a2ea52e706f9
                            <div class="col-md-12 text-center heading-section ftco-animate">
                                <span class="subheading">Plats</span>

                            </div>

                        </div>
                        <div class="col-md-12 tab-wrap">

                            <div class="tab-content" id="v-pills-tabContent">

                                <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                                    <div class="row no-gutters d-flex align-items-stretch">
                                        <c:set var="list" value="${requestScope.plats}"/>
                                        <c:forEach items="${plats}" var="dish">
                                            <div class="col-md-12 col-lg-6 d-flex align-self-stretch">
                                                <div class="menus d-sm-flex ftco-animate align-items-stretch">

                                                    <div class="menu-img img" style="background-image: url('images/${dish.image}');"></div>
                                                    <div class="text d-flex align-items-center">
                                                        <div>
                                                            <div class="d-flex">
                                                                <div class="one-half">
                                                                    <h3>${dish.getName()}</h3>
                                                                </div>
                                                                <div class="one-forth">
                                                                    <span class="price">€${dish.getPrice()}</span>
                                                                </div>
                                                            </div>
                                                            <p>${dish.getDescription()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>


                            </div>



                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="ftco-search">
                    <div class="row">
                        <div class="col-md-12 nav-link-wrap">
<<<<<<< HEAD

=======
                           
>>>>>>> d6537f1ce5a6d39b10d80028a578a2ea52e706f9
                            <div class="col-md-12 text-center heading-section ftco-animate">
                                <span class="subheading" style="margin-top: 200px">Desserts</span>

                            </div>

                        </div>
                        <div class="col-md-12 tab-wrap" style="margin-top: 200px">

                            <div class="tab-content" id="v-pills-tabContent">

                                <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                                    <div class="row no-gutters d-flex align-items-stretch">
                                        <c:set var="list" value="${requestScope.desserts}"/>
                                        <c:forEach items="${desserts}" var="dish">
                                            <div class="col-md-12 col-lg-6 d-flex align-self-stretch">
                                                <div class="menus d-sm-flex ftco-animate align-items-stretch">

                                                    <div class="menu-img img" style="background-image: url('images/${dish.image}');"></div>
                                                    <div class="text d-flex align-items-center">
                                                        <div>
                                                            <div class="d-flex">
                                                                <div class="one-half">
                                                                    <h3>${dish.getName()}</h3>
                                                                </div>
                                                                <div class="one-forth">
                                                                    <span class="price">€${dish.getPrice()}</span>
                                                                </div>
                                                            </div>
                                                            <p>${dish.getDescription()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>


                            </div>



                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="ftco-search">
                    <div class="row">
                        <div class="col-md-12 nav-link-wrap">
<<<<<<< HEAD

=======
                           
>>>>>>> d6537f1ce5a6d39b10d80028a578a2ea52e706f9
                            <div class="col-md-12 text-center heading-section ftco-animate">
                                <span class="subheading" style="margin-top: 200px">Cocktails</span>

                            </div>

                        </div>
                        <div class="col-md-12 tab-wrap" style="margin-top: 200px">

                            <div class="tab-content" id="v-pills-tabContent">

                                <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                                    <div class="row no-gutters d-flex align-items-stretch">
                                        <c:set var="list" value="${requestScope.cocktails}"/>
                                        <c:forEach items="${cocktails}" var="dish">
                                            <div class="col-md-12 col-lg-6 d-flex align-self-stretch">
                                                <div class="menus d-sm-flex ftco-animate align-items-stretch">

                                                    <div class="menu-img img" style="background-image: url('images/${dish.image}');"></div>
                                                    <div class="text d-flex align-items-center">
                                                        <div>
                                                            <div class="d-flex">
                                                                <div class="one-half">
                                                                    <h3>${dish.getName()}</h3>
                                                                </div>
                                                                <div class="one-forth">
                                                                    <span class="price">€${dish.getPrice()}</span>
                                                                </div>
                                                            </div>
                                                            <p>${dish.getDescription()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
<<<<<<< HEAD
                            </div>
=======


                            </div>



>>>>>>> d6537f1ce5a6d39b10d80028a578a2ea52e706f9
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="ftco-search">
                    <div class="row">
                        <div class="col-md-12 nav-link-wrap">
<<<<<<< HEAD

=======
                            
>>>>>>> d6537f1ce5a6d39b10d80028a578a2ea52e706f9
                            <div class="col-md-12 text-center heading-section ftco-animate">
                                <span class="subheading" style="margin-top: 200px">Wine</span>

                            </div>

                        </div>
                        <div class="col-md-12 tab-wrap" style="margin-top: 200px">

                            <div class="tab-content" id="v-pills-tabContent">

                                <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                                    <div class="row no-gutters d-flex align-items-stretch">
                                        <c:set var="list" value="${requestScope.wine}"/>
                                        <c:forEach items="${wine}" var="dish">
                                            <div class="col-md-12 col-lg-6 d-flex align-self-stretch">
                                                <div class="menus d-sm-flex ftco-animate align-items-stretch">

                                                    <div class="menu-img img" style="background-image: url('images/${dish.image}');"></div>
                                                    <div class="text d-flex align-items-center">
                                                        <div>
                                                            <div class="d-flex">
                                                                <div class="one-half">
                                                                    <h3>${dish.getName()}</h3>
                                                                </div>
                                                                <div class="one-forth">
                                                                    <span class="price">€${dish.getPrice()}</span>
                                                                </div>
                                                            </div>
                                                            <p>${dish.getDescription()}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>


                            </div>



                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer class="ftco-footer ftco-bg-dark ftco-section">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-6 col-lg-3">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Barenché</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Open Hours</h2>
                            <ul class="list-unstyled open-hours">
                                <li class="d-flex"><span>Monday</span><span>9:00 - 24:00</span></li>
                                <li class="d-flex"><span>Tuesday</span><span>9:00 - 24:00</span></li>
                                <li class="d-flex"><span>Wednesday</span><span>9:00 - 24:00</span></li>
                                <li class="d-flex"><span>Thursday</span><span>9:00 - 24:00</span></li>
                                <li class="d-flex"><span>Friday</span><span>9:00 - 02:00</span></li>
                                <li class="d-flex"><span>Saturday</span><span>9:00 - 02:00</span></li>
                                <li class="d-flex"><span>Sunday</span><span> 9:00 - 02:00</span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Instagram</h2>
                            <div class="thumb d-sm-flex">
                                <a href="#" class="thumb-menu img" style="background-image: url(images/insta-1.jpg);">
                                </a>
                                <a href="#" class="thumb-menu img" style="background-image: url(images/insta-2.jpg);">
                                </a>
                                <a href="#" class="thumb-menu img" style="background-image: url(images/insta-3.jpg);">
                                </a>
                            </div>
                            <div class="thumb d-flex">
                                <a href="#" class="thumb-menu img" style="background-image: url(images/insta-4.jpg);">
                                </a>
                                <a href="#" class="thumb-menu img" style="background-image: url(images/insta-5.jpg);">
                                </a>
                                <a href="#" class="thumb-menu img" style="background-image: url(images/insta-6.jpg);">
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Newsletter</h2>
                            <p>Far far away, behind the word mountains, far from the countries.</p>
                            <form action="#" class="subscribe-form">
                                <div class="form-group">
                                    <input type="text" class="form-control mb-2 text-center" placeholder="Enter email address">
                                    <input type="submit" value="Subscribe" class="form-control submit px-3">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

<<<<<<< HEAD

=======
                        
>>>>>>> d6537f1ce5a6d39b10d80028a578a2ea52e706f9
                    </div>
                </div>
            </div>
        </footer>


        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>


    </body>
</html>
