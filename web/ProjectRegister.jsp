<%-- 
    Document   : ProjectRegister
    Created on : 27 Feb, 2020, 9:48:19 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header3.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <title>Manager Portal</title>



    </head>
    <body>
        <div  style=" text-align: center;margin-top:2%" class="container-fluid">
            <form action="AboutProject" method="post" class="form-horizontal">
                <div class="form-group">
                    <label  class="col-md-2">Project Title</label>
                    <input type="text" class="col-sm-4" name="project_title" required placeholder="Project Title">

                </div>
                <div class="form-group">
                    <label  class="col-md-2">Project Id:</label>
                    <input type="Text" class="col-sm-4"  name="project_id" required  placeholder="Project Id">
                </div>

                <div class="form-group">
                    <label  class="col-md-2">Manager Id:</label>
                    <input type="text" class="col-sm-4" name="manager_id" required  placeholder="Manager ID">
                </div>

                <div class="form-group">

                    <label class="col-md-2">Duration:</label>
                    <input type="number" class="col-sm-2" name="durationyear" required  placeholder="Years"><input type="number" name="durationMonth"class="col-sm-2"  placeholder="Months">
                </div>         
                <div class="form-group">
                    <label  class="col-md-2">Technology:</label>
                    <input type="text" class="col-sm-4" name="technology" required  placeholder="Technology">

                </div>           
                <div class="form-group">
                    <label style="vertical-align: top"  class="col-md-2">Description:</label>
                    <textarea type="text" minlength="50" maxlength="120" class="col-sm-4"  required name="description" rows="4" cols="2"  placeholder="description"></textarea>

                </div>         
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <%String msg = (String) request.getAttribute("msg");
           if (msg != null) {%>
    <center> <p style="color:red"><%=msg%></p></center>
        <%}%>
</body>
</html>
