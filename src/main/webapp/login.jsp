<%-- 
    Document   : login
    Created on : May 19, 2015, 11:46:54 PM
    Author     : Rustam
--%>

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
        <div class="row" style="padding-top: 100px;"> 
            <div class="hidden-sm hidden-xs well center-block" style="width:300px">
                <form action="LoginControl" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="login" class="form-control" id="username" name="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div> 
                     <%
                        if (request.getAttribute("info") != null) {
                            String info = String.valueOf(request.getAttribute("info"));
                            out.print("<div class=\"form-group\"><span class=\"label label-danger\">" + info + "</span></div>");
                        }%>
                    <button type="submit" class="btn btn-default">Login</button>
                    <a href="index.html">back</a>
                </form>
            </div> </div>  
    </body>
</html>
