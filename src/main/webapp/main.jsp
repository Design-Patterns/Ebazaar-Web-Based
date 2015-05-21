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
                            <form action="index.html" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control input-search" name="question" placeholder="Enter something to search"
                                           <% if (request.getAttribute("question") != null) {%>value="<%=request.getAttribute("question")%>" <%}%> >
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
                            <button type="button" class="" data-toggle="modal" data-target="#myModal">
                                <span class="" style="font-weight: bold;" >  Order Box (<%=orders.size()%> items, <%=quants%> quantity) </span>
                            </button> 
                        </div>
                            <%
                        if (request.getAttribute("info") != null) {
                            String info = String.valueOf(request.getAttribute("info"));
                            out.print("<div class=\"form-group\"><span class=\"label label-primary\">" + info + "</span></div>");
                        }%>
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




        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Order Card</h4>
                    </div>
                    <div class="modal-body">
                        <div class="">
                            <table class="table table-striped">
                                <thead style="font-weight: bolder">
                                    <tr><td>Product</td>
                                        <td>Quantity</td>
                                    </tr>
                                </thead>
                                <% for (int i = 0; i < orders.size(); i++) {
                                        OrderDto c = orders.get(i);%>
                                <tr>
                                    <td><%=c.getProduct().getTitle()%></td>
                                    <td><%=c.getQuantity()%></td>
                                </tr>
                                <%}%> 
                            </table>
                        </div>
                    </div> 
                    <form action="Checkout" method="post">
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                            <button type="submit" class="btn btn-primary">Checkout</button>

                        </div>  
                    </form>
                </div>
            </div>
        </div>



    </body> 
</html>
