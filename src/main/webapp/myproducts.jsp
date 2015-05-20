<%-- 
    Document   : myproducts
    Created on : May 20, 2015, 1:52:46 PM
    Author     : 984150
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.group5.designpatters.ebazaar.entities.Product"%>
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

        <div style="height:15px;"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-3 hidden-sm hidden-xs">
                    <div class="well logo"> 
                        <a href="NewProductModel"><button class="btn btn-primary" type="button">New product</button></a>
                        <a href="index.html">back</a>
                    </div>
                </div>
            </div>
        </div>

        
        
          <%
            Iterator<Product> i = (Iterator<Product>) request.getAttribute("iterator");
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
                    while(i.hasNext()) {
                        Product p = i.next();
                %>
                <tr>
                    <td><%=p.getId()%></td> 
                    <td><%=p.getTitle()%></td>
                    <td><%=p.getCategory().getName()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><%=p.getQuantity()%></td>
                    <td><%=p.getUser().getRealName()%></td>
                    <td><%=p.getDescription()%></td>
                    <td><a href="NewProductModel?product_id=<%=p.getId()%>"><button class="btn btn-info" type="button">edit</button></a></td>
                </tr>
                <%   }%>
            </table>
        </div>

        


    </body>
</html>
