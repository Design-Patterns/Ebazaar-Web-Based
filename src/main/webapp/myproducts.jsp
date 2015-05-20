<%-- 
    Document   : myproducts
    Created on : May 20, 2015, 1:52:46 PM
    Author     : 984150
--%>

<%@page import="com.group5.designpatters.ebazaar.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-theme.css" />
        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/bootstrap.js"></script>
        <title>My Products</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user");%>

        <div style="height:15px;"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-3 hidden-sm hidden-xs">
                    <div class="well logo"> 
                        <a href="NewProductModel"><button class="btn btn-primary" type="button">New product</button></a> 
                    </div>
                </div>
            </div>
        </div>



    </body>
</html>
