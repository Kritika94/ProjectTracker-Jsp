<%-- 
    Document   : Header4
    Created on : 7 Mar, 2020, 1:53:36 PM
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
            <a class="active" onclick="" id="tester" href="Tester.jsp">Tester Dashboard</a>
            <a href="CreateBugs.jsp"  id="createBugs">Create Bugs</a>
            <a href="ProjectStatusManage.jsp" id="statPro">Project Status</a>
            <a href="AboutProjectTester.jsp" id="abtPro">About Project</a>
        </div>
            
        
    </body>
</html>
