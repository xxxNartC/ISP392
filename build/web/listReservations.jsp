<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Search Reservation Results</title>
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
                        <h1 class="mb-2 bread">List of Reservations</h1>
                        <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Reservation <i class="ion-ios-arrow-forward"></i></span></p>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-no-pt ftco-no-pb">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="row">
                            <div class="col-md-12">
                                <h2>All Reservations</h2>
                                <c:if test="${not empty preOrders}">
                                    <c:forEach var="preOrder" items="${preOrders}">
                                        <div class="card mt-4">
                                            <div class="card-body">
                                                <h5 class="card-title">Reservation ID: ${preOrder.preOrderID}</h5>
                                                <p class="card-text">Name: ${preOrder.name}</p>
                                                <p class="card-text">Phone: ${preOrder.phone}</p>
                                                <p class="card-text">Book Date: ${preOrder.bookDate}</p>
                                                <p class="card-text">Number of People: ${preOrder.numberOfPeople}</p>
                                                <p class="card-text">Time: ${preOrder.time}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty preOrders}">
                                    <div class="alert alert-warning mt-4" role="alert">
                                        No reservations found.
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="close.jsp" %>
    </body>
</html>
