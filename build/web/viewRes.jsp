<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Reservation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
                        <p><strong>Email:</strong> <%= request.getAttribute("email") %></p>
                        <p><strong>Phone:</strong> <%= request.getAttribute("phone") %></p>
                        <p><strong>Date:</strong> <%= request.getAttribute("bookDate") %></p>
                        <p><strong>Table Number:</strong> <%= request.getAttribute("tableNumber") %></p>
                        <p><strong>Time:</strong> <%= request.getAttribute("bookTime") %></p>
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
