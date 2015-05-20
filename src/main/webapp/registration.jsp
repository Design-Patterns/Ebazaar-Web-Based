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
        <title>New User Registration Page</title>

    </head>
    <body>
        <div class="row" style="padding-top: 100px;"> 
            <div class="hidden-sm hidden-xs well center-block" style="width:500px">
                <form action="UserRegistration">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input class="form-control" id="name" placeholder="First name and Last name">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input class="form-control" type="email" id="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input class="form-control" id="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="info">Information</label>
                        <input class="form-control" id="info">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div> </div>  
    </body>
</html>
