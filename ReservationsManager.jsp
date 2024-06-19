<%-- 
    Document   : reservation
    Created on : 18 thg 5, 2024, 23:13:47
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Branché Restaurant</title>
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
                                <span class="subheading">Pre Order Detail</span>
                            </div>
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger" role="alert">
                                    ${param.error}
                                </div>
                            </c:if>
                            <c:if test="${param.success != null}">
                                <div class="alert alert-success" role="alert">
                                    ${param.success}
                                </div>
                            </c:if>
                            <c:if test="${errorMessage != null}">
                                <div class="alert alert-danger" role="alert">
                                    ${errorMessage}
                                </div>
                            </c:if>
                            <h2 class="mb-4">Pre Order Detail</h2>
                            <form action="ReservationManager?action=edit" method="POST">
                                <input type="hidden" name="preOrderID" value="${preOrder.preOrderID}">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" id="name" name="name" class="form-control" value="${preOrder.name}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" id="email" name="email" class="form-control" value="${preOrder.email}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="phone">Phone</label>
                                    <input type="tel" id="phone" name="phone" class="form-control" value="${preOrder.phone}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="book_date">Book Date</label>
                                    <input type="datetime-local" id="book_date" name="book_date" class="form-control" value="${preOrder.bookDate}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="number_of_people">Number of People</label>
                                    <input type="number" id="number_of_people" name="number_of_people" class="form-control" value="${preOrder.numberOfPeople}" min="1" max="20" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="status">Status</label>
                                    <select name="status" class="form-control">
                                        <option value="0" ${preOrder.status == 0 ? "seletect" : ""}>New</option>
                                        <option value="1" ${preOrder.status == 1 ? "seletect" : ""}>Accept</option>
                                        <option value="2" ${preOrder.status == 2 ? "seletect" : ""}>Reject</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
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