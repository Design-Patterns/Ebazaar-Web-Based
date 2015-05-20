<%-- 
    Document   : products
    Created on : May 19, 2015, 2:12:27 PM
    Author     : 984150
--%>

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


        <header>
            <div style="height:15px;"></div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3 hidden-sm hidden-xs">
                        <div class="well logo">
                            <a href="login.jsp">Login</a> 
                            <a href="index.html">Registration</a> 
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
                %><td><%=p.getId()%></td><%
                %><td><%=p.getTitle()%></td><%
                %><td><%=p.getDescription()%></td><%
                %></tr><%   }
                %>
        </table>



    </body> 
</html>
