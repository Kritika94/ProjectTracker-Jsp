<%-- 
    Document   : Tester.jsp
    Created on : 7 Mar, 2020, 12:47:43 PM
    Author     : Kritika
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header4.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Dashboard</title>
    </head>
    <body>

        <div style="text-align: center; color:white;float:left;padding-left:6%; margin-top:1%; "><img src="images/projectTracker.gif"></div>
        <div style="text-align: center; color:white;margin-right:-70%; margin-top:1%;  background-color: #5b86e5;border:2px solid #36d1dc;height:200px; width:30%">
            <%String msgs = (String) session.getAttribute("user");%>
            Welcome <%=msgs%>
            <h3>Assigned to you</h3>
            <%
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
                    PreparedStatement ps = con.prepareStatement("select bug_id from bugs where assignee=? and (bug_status='assigned'or bug_status='In Progress')");
                    ps.setString(1, msgs);
                    ResultSet rs = ps.executeQuery();

                    out.println("<ol>");
                    int i = 1;
                    while (rs.next()) {

                         String number = rs.getString(1);%>
            <li><a style="font-weight: bold; color: white;text-decoration:none " title="click here" href='viewBug.jsp?value=<%=number%>'><%=number%></a></li>
            <%
                        i++;
                    }
                    if (i == 1) {
                        out.println("Enjoy your day! No Issues Assigned to you");
                    }
                    out.println("</ol>");

                } catch (Exception e) {
                    out.println(e);
                }

            %>
        </div>
        <div style="text-align: center; color:white;margin-right:-70%; margin-top:1%;  background-color: #5b86e5;border:2px solid #36d1dc;height:200px; width:30%">
            <h3>Reported By you</h3>
            <%               try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
                    PreparedStatement ps = con.prepareStatement("select bug_id from bugs where bug_reorter=?");
                    ps.setString(1, msgs);
                    ResultSet rs = ps.executeQuery();

                    out.println("<ol>");
                    int i = 1;
                    while (rs.next()) {

                       String number = rs.getString(1);%>

            <li><a style="font-weight: bold; color: white;text-decoration:none " title="click here" href='viewBug.jsp?value=<%=number%>'><%=number%></a></li>

            <%
                        i++;
                    }
                    if (i == 1) {
                        out.println("No Issues Reported By You");
                    }
                    out.println("</ol>");

                } catch (Exception e) {
                    out.println(e);
                }

            %>
        </div>
    </body>
</html>