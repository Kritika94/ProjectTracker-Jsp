<%-- 
    Document   : Header3
    Created on : 29 Feb, 2020, 11:43:56 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
   <head>
        <link href="css/NavigationHeader.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .active {
  background-color: dodgerblue;
  color: white;
}
        </style>
    </head>
    <body>
        <center>
        <div class="pill-nav" style="margin-top: 220px">
            <a class="active" onclick="" id="addPro" href="ProjectRegister.jsp">Add Project</a>
            <a href="AboutProjectManage.jsp"  id="aboutPro">About Project</a>
            <a href="ProjectStatusManage.jsp" id="statPro">Project Status</a>
            <a href="AddDeveloper.jsp" id="adddev">Add Developer</a>
        </div>
        </center>
</body>
</html>
