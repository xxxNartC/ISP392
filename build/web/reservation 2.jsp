<%-- 
    Document   : reservation
    Created on : 18 thg 5, 2024, 23:13:47
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FBranché Restaurant</title>
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
                        <h1 class="mb-2 bread">Book a Table</h1>
                        <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Reservation <i class="ion-ios-arrow-forward"></i></span></p>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-no-pt ftco-no-pb">
            <div class="container-fluid px-0">
                <div class="row d-flex no-gutters">
                    <div class="col-md-12 ftco-animate makereservation p-4 p-md-5 pt-5">
                        <div class="py-md-5">
                            <div class="heading-section ftco-animate mb-5">
                                <span class="subheading">Book a table</span>
                            </div>
                            <form action="ResControllers" method="POST">
                                <div class="row">
                                    <!-- Name Field -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="name">Name</label>
                                            <input type="text" id="name" name="name" class="form-control" placeholder="Your Name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>">
                                        </div>
                                    </div>

                                    <!-- Email Field -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="email" id="email" name="email" class="form-control" placeholder="Your Email" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
                                        </div>
                                    </div>

                                    <!-- Phone Field -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="phone">Phone</label>
                                            <input type="tel" id="phone" name="phone" class="form-control" placeholder="Phone" value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : "" %>">
                                        </div>
                                    </div>

                                    <!-- Date Field -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="book_date">Date</label>
                                            <input type="date" id="book_date" name="book_date" class="form-control" placeholder="Date">
                                        </div>
                                    </div>





                                    <!-- Trường chọn bàn -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="table_number">Table Number</label>
                                            <select id="table_number" name="table_number" class="form-control">
                                                <option value="">Select Table Number</option>
                                                <option value="1">Table 1</option>
                                                <option value="2">Table 2</option>
                                                <option value="3">Table 3</option>
                                                <option value="4">Table 4</option>
                                                <option value="5">Table 5</option>
                                                <option value="6">Table 6</option>
                                                <option value="7">Table 7</option>
                                                <option value="8">Table 8</option>
                                                <option value="9">Table 9</option>
                                                <option value="10">Table 10</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="book_time">Time</label>
                                            <div class="select-wrap one-third">
                                                <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                <select id="book_time" name="book_time" class="form-control">
                                                    <option value="">Select Time</option>
                                                    <option value="12:00 PM">12:00 PM</option>
                                                    <option value="12:30 PM">12:30 PM</option>
                                                    <option value="1:00 PM">1:00 PM</option>
                                                    <option value="6:00 PM">6:00 PM</option>
                                                    <option value="6:30 PM">6:30 PM</option>
                                                    <option value="7:00 PM">7:00 PM</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Submit Button -->
                                    <div class="col-md-12 mt-3">
                                        <div class="form-group">
                                            <input type="submit" value="Make a Reservation" class="btn btn-primary py-3 px-5">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-6 d-flex align-items-stretch pb-5 pb-md-0">
                        <div id="map"></div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="close.jsp" %>
    </body>
</html> 
