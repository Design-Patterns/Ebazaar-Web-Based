<%-- 
    Document   : products
    Created on : May 19, 2015, 2:12:27 PM
    Author     : 984150
--%>

<%@page import="com.group5.designpatters.ebazaar.entities.User"%>
<%@page import="java.util.List"%>
<%@page import="com.group5.designpatters.ebazaar.entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-theme.css" />
        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/bootstrap.js"></script>

        <title>JSP Page</title>
    </head>
    <body>

        <% User user = (User) session.getAttribute("user"); %>



        <header>
            <div style="height:15px;"></div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-3 hidden-sm hidden-xs">
                        <div class="well logo">
                            <% if (user != null) {   %>
                            <a href="myproducts.jsp"><button class="btn btn-primary" type="button">My products</button></a> 
                            <a href="EditUserInfo"><button class="btn btn-info" type="button">Edit user info</button></a> 
                            <a href="LogoutController"><button class="btn btn-danger" type="button">Logout</button></a> 
                            <% } else { %>
                            <a href="login.jsp"><button class="btn btn-success" type="button">Login</button></a> 
                            <a href="registration.jsp"><button class="btn btn-info" type="button">Registration</button></a> 
                            <% } %> 

                        </div>
                    </div>
                    <div class="col-lg-5 col-md-5 col-sm-7 col-xs-12">
                        <div class="well">
                            <form action="">
                                <div class="input-group">
                                    <input type="text" class="form-control input-search" placeholder="Enter something to search">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default no-border-left" type="submit">Search
                                        </button>
                                    </span>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 hidden-sm hidden-xs">
                        <div class="well logo">
                            Order Box
                        </div>
                    </div>
                </div>
            </div>
        </header>




        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
        %>

        <table class="table">
            <thead class="danger"><tr>
                    <td>Product ID</td>
                    <td>Product name</td>
                    <td>Description</td></tr>
            </thead> 
            <%
                for (int i = 0; i < products.size(); i++) {
                    Product p = products.get(i);
            %><tr><%
                %><td><%=p.getId()%></td><%%><td><%=p.getTitle()%></td><%%><td><%=p.getDescription()%></td><%
                %></tr><%   }
                %>
        </table>



    </body> 
</html>
