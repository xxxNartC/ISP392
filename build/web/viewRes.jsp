<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

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
    <div class="container mt-5">
        <div class="modal" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="reviewModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="reviewModalLabel">Review Your Reservation</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p><strong>Name:</strong> <%= request.getAttribute("name") %></p>
                        <p><strong>Phone:</strong> <%= request.getAttribute("phone") %></p>
                        <p><strong>Date:</strong> <%= request.getAttribute("bookDate") %></p>
                        <p><strong>Time:</strong> <%= request.getAttribute("bookTime") %></p>
                        <p><strong>Number of People:</strong> <%= request.getAttribute("numberOfPeople") %></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="window.history.back();">Go Back</button>
                        <button type="button" class="btn btn-primary" onclick="confirmReservation();">Confirm</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('#reviewModal').modal('show');
        });

        function confirmReservation() {
            // You can submit a confirmation request to the server here if needed
            alert('Reservation confirmed!');
            window.location.href = 'Home.jsp';
        }
    </script>
</body>
</html>
