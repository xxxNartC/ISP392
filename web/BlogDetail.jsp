<%-- 
    Document   : BlogDetail
    Created on : Jun 16, 2024, 7:56:35 PM
    Author     : ACER
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    </head>
    <body>
        <form action="UpdateBlog" method="post" enctype="multipart/form-data">
            <img src="./images/${blog.image}" alt="alt"/>
            <input type="hidden" name="id" value="${blog.blogid}">
            <<div class="form-row">
                <div class="form-group col-md-12">
                    <label for="Description" style="font-weight: bold">Title:</label>
                    <input type="text" class="form-control" id="title" placeholder="title"  name="title" required="">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="description" style="font-weight: bold">Description</label>
                    <textarea class="form-control" id="description" name="description" placeholder="description" required=""></textarea>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="image" style="font-weight: bold">Image</label>
                    <input type="file" class="form-control" id="image" placeholder="image" accept="image/*" name="image" required="" >
                </div>
            </div>
            <h3>Date : </h3> <input type="date" name="date" value="${blog.date}" disabled />
            <button type="submit" value="update">Save change</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
