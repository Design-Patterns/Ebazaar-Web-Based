<%-- 
    Document   : login
    Created on : May 19, 2015, 11:46:54 PM
    Author     : Rustam
--%>

<%@page import="java.util.List"%>
<%@page import="com.group5.designpatters.ebazaar.entities.Category"%>
<%@page import="com.group5.designpatters.ebazaar.entities.Product"%>
<%@page import="com.group5.designpatters.ebazaar.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-theme.css" />
        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/bootstrap.js"></script>
        <title>Add/Edit product</title>

    </head>
    <body>
        <div class="row" style="padding-top: 100px;"> 

            <%
                User user = (User) session.getAttribute("user");
                Product p = (Product) request.getAttribute("product");
                List<Category> categories = (List<Category>)request.getAttribute("categories");
            %>

            <div class="hidden-sm hidden-xs well center-block" style="width:500px"> 
                <form action="SaveProduct" method="post">
                    <input type="hidden" name="id" <% if (p != null) {%> value="<%=p.getId()%>" <%}%>/>
                    <div class="form-group">
                        <label for="category_id">Category</label>
                        <select class="form-control" name="category_id" id="category_id">
                            <% for(Category c: categories) { %>
                            <option value="<%=c.getId()%>" <% if(p!=null && p.getCategory().getId()==c.getId()) {%>selected="true"<%} %>><%=c.getName()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="title">Product title</label>
                        <input class="form-control" id="title" name="title" placeholder="Product title" <% if (p != null) {%> value="<%=p.getTitle()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input class="form-control" type="number" id="price" name="price" placeholder="Price" <% if (p != null) {%> value="<%=p.getPrice()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity</label>
                        <input class="form-control" type="number" id="quantity" name="quantity" placeholder="Quantity" <% if (p != null) {%> value="<%=p.getQuantity()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="description">Product description</label>
                        <input class="form-control" id="description" name="description" placeholder="Product description" <% if (p != null) {%> value="<%=p.getDescription()%>" <%}%> >
                    </div>

                    <%
                        if (request.getAttribute("info") != null) {
                            String info = String.valueOf(request.getAttribute("info"));
                            out.print("<div class=\"form-group\"><span class=\"label label-primary\">" + info + "</span></div>");
                        }%>
                    <button type="submit" class="btn btn-default">Save product</button>
                    <a href="myproducts.jsp">back</a>
                </form>
            </div> </div>  
    </body>
</html>
