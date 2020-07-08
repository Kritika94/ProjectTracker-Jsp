<%-- 
    Document   : viewBug
    Created on : 7 Mar, 2020, 4:18:58 PM
    Author     : Kritika
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name = session.getAttribute("Designation").toString();
    if (name.equals("Tester")) {
%>
<%@include file="Header4.jsp" %>
<%} else {%>

<%@include file="Header2.jsp" %>

<%}%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%  String bug_id = request.getParameter("value");%>
        <script>

            function unloadEvt() {

                document.location.href = 'StatusTestChange?value=<%=bug_id%>';

            }

            function DevUnderstanding() {


                var Dev = document.getElementById("edit").innerHTML;
                document.location.href = 'SaveTest?value=<%=bug_id%>&id=' + Dev;


            }

            function editable() {
                document.getElementById("edit").setAttribute("contenteditable", true);
                document.getElementById("devedit").hidden = false;
            }


        </script>
    </head>
    <%
        String Title = null;
        String Bug_type = null;
        String Assignee = null;
        String cumin_ticket = null;
        String Status = null;
        String Description = null;
        String Reporter = null;

        try {
            request.setAttribute("cumin_Number", bug_id);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
            PreparedStatement ps = con.prepareStatement("select * from Bugs where bug_id=?");
            ps.setString(1, bug_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Title = rs.getString(6);
                Status = rs.getString(3);
                Description = rs.getString(7);
                Assignee = rs.getString(5);
                Bug_type = rs.getString(2);
                cumin_ticket = rs.getString(8);
                Reporter = rs.getString(1).toUpperCase();
                rs.close();
                ps.close();
                con.close();
            }
        } catch (Exception e) {
            out.println(e);
        }


    %>





    <body><br>
        <div class="container-fluid">
            <h2><%=Title%></h2> 
            <div class="row">

                <div class="col-sm-4" style="background-color:lavender;"><span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Bug Type:<%=Bug_type%></span>

                </div>
                <input type="hidden" name="cumin"  value="<%=bug_id%>"  >
                <div class="col-sm-4" style="background-color:lavenderblush;"><button class="btn btn-success" onclick='unloadEvt()' style="width:105px"><%=Status%></button></div>
                <div class="col-sm-4" style="background-color:lavender;">
                    <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Cumin-Ticket:<%=cumin_ticket%></span>

                </div>
            </div>
            <p></p>
            <div class="row"> 
                <div class="col-sm-4" style="background-color:white;"></div>
                <div class="col-sm-4" > <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Assignee : <span id='edit'><%=Assignee%> </span><button onclick="editable()"  class="btn" style="font-size:20px; background-color: transparent"><i class="fa fa-pencil"></i></button><button id="devedit" onclick="DevUnderstanding()" title="save" class="btn" style="font-size:20px; background-color: transparent" hidden><i class="fa fa-floppy-o"></i></button></span>


                </div>
                <div class="col-sm-4" style="background-color:lavender;">
                    <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Reporter : <%=Reporter%></span>

                </div>
            </div>
            <p></p>
            <div class="row">
                <div class="container" height="50px">

                    <div class="jumbotron" style="height:40px">
                        <h3 style="margin-top:-54px">Description:</h3>
                        <%=Description%> 
                    </div>

                </div>
            </div>



    </body>
</html>
