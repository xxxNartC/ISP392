<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reservations Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
    <style>
        .nav-link {
            color: white;
        }
        .nav-link:hover {
            background-color: #ccc;
            color: #17a2b8;
        }
        .container {
            margin-top: 30px;
        }
        .alert {
            margin-top: 20px;
        }
        .form-label {
            font-weight: bold;
        }
    </style>
    <script type="text/javascript">
        function doDelete(id) {
            if (confirm("Are you sure to delete id = " + id)) {
                window.location = "DeleteReservation?id=" + id; // Assuming this is your delete URL
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <c:if test="${not empty param.msg}">
            <div class="alert alert-success" role="alert">
                ${param.msg}
            </div>
        </c:if>
        <c:if test="${not empty param.err}">
            <div class="alert alert-danger" role="alert">
                ${param.err}
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>
        <h3>Table Information</h3>
        <form action="ReservationsManager" method="post" class="row g-3">
            <div class="col-md-6">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" value="${Users.name}" disabled>
                <input type="hidden" name="userId" value="${Users.userId}">
            </div>

            <div class="col-md-6">
                <label for="dob" class="form-label">Date of Birth</label>
                <input type="text" class="form-control" value="${Users.bod}" disabled>
            </div>
            
            <div class="col-md-6">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" value="${Users.address}" disabled>
            </div>

            <div class="col-md-6">
                <label for="phone" class="form-label">Phone Number</label>
                <input type="text" class="form-control" value="${Users.phone}" disabled>
            </div>
            
            <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" value="${Users.email}" disabled>
            </div>
            
            <div class="col-md-6">
                <label for="table" class="form-label">Table</label>
                <input type="text" class="form-control" value="${preOrder.getTableID()}" disabled>
            </div>
            
            <div class="col-md-6">
                <label for="people" class="form-label">Number of People</label>
                <input type="text" class="form-control" value="${preOrders.numberOfPeople}" disabled>
            </div>
            
            <div class="col-md-6">
                <label for="time" class="form-label">Time</label>
                <input type="text" class="form-control" value="${preOrders.time}" disabled>
            </div>
            
            <div class="col-md-6">
                <label for="status" class="form-label">Status</label>
                <select class="form-control" name="status" required>
                    <option value="">Choose status</option>
                    <option value="reject">Reject</option>
                    <option value="approve">Approve</option>
                </select>
            </div>
            
            <div class="col-md-12">
                <label for="comment" class="form-label">Comment</label>
                <textarea class="form-control" name="comment" rows="5" placeholder="Comment" required></textarea>
            </div>

            <div class="col-md-12">
                <button type="submit" class="btn btn-primary mt-3">Submit</button>
            </div>
        </form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>