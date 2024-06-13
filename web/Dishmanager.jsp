<%-- 
    Document   : ListMovie
    Created on : Mar 2, 2024, 9:22:58 PM
    Author     : maingocdat
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
        <style>
            .nav-link {
                color: white
            }
            .nav-link:hover {
                background-color: #ccc;
                color: #17a2b8
            }
        </style>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("are you sure to delete id = " + id)) {
                    window.location = "DeleteMovie?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="d-flex">
            <div>
                <%@include file="SideBarAdmin.jsp" %>
            </div>
            <div class="container" style="margin-top: -20px">
                <div>
                    <div class="container">
                        <a href="AddDish" class="btn  p-2" style="background: #58abff; color: white; margin-bottom: 45px;margin-top: 30px "  >Add New Dish</a>
                    </div>
                    
                    
                </div>
                <div class="container" style="margin-top: -30px">
                    <a href="" style="text-decoration: none; color: #58abff"><h2 style="color: white">List Dish</h2></a>
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">Dish ID</th>
                                <th scope="col">Name</th>    
                                <th scope="col">Price</th>                                                         
                                <th scope="col">Description</th>
                                <th scope="col">DishType</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items = "${list}" var="dish">
                                <c:set var="list" value="${requestScope.list}"/> 
                                <tr>
                                    <td>${dish.getDishID()}</td>

                                    <td>${dish.getName()}</td>
                                    <td>€${dish.getPrice()}</td>
                                    <td>${dish.getDescription()}</td>
                                    <td>${dish.getDishType()}</td>
                                    <td>
                                        <a href="UpdateMovie?id=${id}" class="btn btn-warning mr-2">Update</a>
                                        <a href="#" onclick="doDelete('${dish.getDishID()}')" class="btn btn-danger">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
               
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>

