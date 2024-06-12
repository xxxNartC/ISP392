<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.PreOrder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Branché Restaurant</title>
    <!-- Include CSS stylesheets -->
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
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_3.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row no-gutters slider-text align-items-end justify-content-center">
                <div class="col-md-9 ftco-animate text-center mb-4">
                    <h1 class="mb-2 bread">Search Reservation</h1>
                    <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Reservation <i class="ion-ios-arrow-forward"></i></span></p>
                </div>
            </div>
        </div>
    </section>

    <section class="ftco-section ftco-no-pt ftco-no-pb">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <!-- Form for searching reservations -->
                    <div class="row">
                        <div class="col-md-12">
                            <form action="SearchResController" method="POST">
                                <div class="form-group">
                                    <label for="phone">Phone Number:</label>
                                    <input type="tel" id="phone" name="phone" class="form-control" placeholder="Enter Phone Number" required>
                                </div>
                                <button type="submit" class="btn btn-primary">Search</button>
                            </form>
                        </div>
                    </div>
                    <!-- Display search results -->
                    <div class="row mt-4">
                        <div class="col-md-12">
                            <%
                                // Get list of PreOrders from request attribute
                                List<PreOrder> preOrders = (List<PreOrder>) request.getAttribute("preOrders");
                                // Check if list exists and is not empty
                                if (preOrders != null && !preOrders.isEmpty()) {
                                    // Iterate over each PreOrder and display information
                                    for (PreOrder preOrder : preOrders) {
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                            %>
                            <!-- Display information for each PreOrder in a card -->
                            <div class="card mt-2">
                                <div class="card-body">
                                    <h5 class="card-title">Reservation ID: <%= preOrder.getPreOrderID() %></h5>
                                    <p class="card-text">Name: <%= preOrder.getName() %></p>
                                    <p class="card-text">Phone: <%= preOrder.getPhone() %></p>
                                    <p class="card-text">Book Date: <%= dateFormat.format(preOrder.getBookDate()) %></p>
                                    <p class="card-text">Number of People: <%= preOrder.getNumberOfPeople() %></p>
                                    <p class="card-text">Time: <%= timeFormat.format(preOrder.getTime()) %></p>
                                </div>
                            </div>
                            <%  
                                    }
                                } else {
                            %>
                            <!-- Display a message if no reservations are found -->
                            <div class="alert alert-warning mt-2" role="alert">
                                No reservations found for the provided phone number.
                            </div>
                            <%  
                                }
                            %>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>

    <%@include file="close.jsp" %>
</body>
</html>
