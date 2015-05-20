<%-- 
    Document   : products
    Created on : May 19, 2015, 2:12:27 PM
    Author     : 984150
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.group5.designpatters.ebazaar.controller.model.OrderDto"%>
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

        <%
            Object _b = session.getAttribute("basket");
            List<OrderDto> orders = new ArrayList<OrderDto>();
            if (_b != null) {
                orders = (List<OrderDto>) _b;
            }
            int quants = 0;
            for (int i = 0; i < orders.size(); i++) {
                quants += orders.get(i).getQuantity();
            }
        %>

        <header>
            <div style="height:15px;"></div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-3 hidden-sm hidden-xs">
                        <div class="well logo">
                            <% if (user != null) {   %>
                            <a href="MyProducts"><button class="btn btn-primary" type="button">My products</button></a> 
                            <a href="EditUserInfo"><button class="btn btn-info" type="button">Edit user info</button></a> 
                            <a href="LogoutController"><button class="btn btn-danger" type="button">Logout</button></a> 
                            <% } else { %>
                            <a href="login.jsp"><button class="btn btn-success" type="button">Login</button></a> 
                            <a href="registration.jsp"><button class="btn btn-info" type="button">Registration</button></a> 
                            <% }%> 

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
                            <span class="" style="font-weight: bold;" >  Order Box (<%=orders.size()%> items, <%=quants%> quantity) </span>
                        </div>
                    </div>
                </div>
            </div>
        </header>




        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
        %>

        <div class="container">
            <table class="table table-striped">
                <thead class="well" style="font-weight:bold;"><tr>
                        <td>Product ID</td>
                        <td>Product name</td>
                        <td>Category</td>
                        <td>Price</td>
                        <td>Stock quantity</td>
                        <td>Seller</td>
                        <td>Description</td>
                        <td>Add to basket</td>
                    </tr>
                </thead> 
                <%
                    for (int i = 0; i < products.size(); i++) {
                        Product p = products.get(i);
                %>
                <tr>
                    <td><%=p.getId()%></td> 
                    <td><%=p.getTitle()%></td>
                    <td><%=p.getCategory().getName()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><%=p.getQuantity()%></td>
                    <td><%=p.getUser().getRealName()%></td>
                    <td><%=p.getDescription()%></td>
                    <td><a href="BasketProduct?product_id=<%=p.getId()%>"><button class="btn btn-info" type="button">buy</button></a></td>
                </tr>
                <%   }%>
            </table>
        </div>








    </body> 
</html>
