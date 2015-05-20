<%-- 
    Document   : login
    Created on : May 19, 2015, 11:46:54 PM
    Author     : Rustam
--%>

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
        <title>New User Registration Page</title>

    </head>
    <body>
        <div class="row" style="padding-top: 100px;"> 

            <%
                User u = (User) request.getAttribute("user");
            %>

            <div class="hidden-sm hidden-xs well center-block" style="width:500px"> 
                <form action="UserRegistration" method="post">
                    <input type="hidden" name="id" <% if (u != null) {%> value="<%=u.getId()%>" <%}%>/>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input class="form-control" id="name" name="name" placeholder="First name and Last name" <% if (u != null) {%> value="<%=u.getRealName()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input class="form-control" type="email" id="email" name="email" placeholder="Email" <% if (u != null) {%> value="<%=u.getEmail()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input class="form-control" id="username" name="username" placeholder="Enter username" <% if (u != null) {%> value="<%=u.getUserName()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password" <% if (u != null) {%> value="<%=u.getPassword()%>" <%}%> >
                    </div>
                    <div class="form-group">
                        <label for="info">Information</label>
                        <input class="form-control" id="info" name="info" <% if (u != null) {%> value="<%=u.getInfo()%>" <%}%> >
                    </div>

                    <%
                        if (request.getAttribute("info") != null) {
                            String info = String.valueOf(request.getAttribute("info"));
                            out.print("<div class=\"form-group\"><span class=\"label label-primary\">" + info + "</span></div>");
                        }%>
                    <button type="submit" class="btn btn-default">Save user</button>
                    <a href="index.html">back</a>
                </form>
            </div> </div>  
    </body>
</html>
