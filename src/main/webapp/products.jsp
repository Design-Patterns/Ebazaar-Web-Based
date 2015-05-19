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
