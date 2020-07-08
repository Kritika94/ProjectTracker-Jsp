<%-- 
    Document   : AboutProjectTester
    Created on : 8 Mar, 2020, 4:06:02 PM
    Author     : Kritika
--%><%@page import="java.sql.ResultSet"%>


%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ProjectHome.JDBCConnectivity"%>
<%@include file="Header4.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script>
                 function myFunction() {
   var element = document.getElementById("createBugs");
   element.classList.remove("active");
   document.getElementById("tester").classList.remove("active");
   document.getElementById("statPro").classList.remove("active");
   document.getElementById("abtPro").classList.add("active");
}
myFunction();
            
        </script>
          
        
    </head>
    <body>
      
         
         <div class="container-fluid" >
              <div style="margin-right:30%; width:50%; color:white; margin-top:1%; "><img src="images/projectTracker.gif"></div>
             <% 
                 
                 String str=session.getAttribute("user").toString();
             int Id=0;
            
                 String project_title;
                 String project_id;
                 String manager_id;
                 String durationyear;
                 String durationMonth;
                 String technology;
                 String description;
                 
                 
                 try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("Select project_id from Developer where name=?") ;
            JDBCConnectivity.ps.setString(1,str);
            ResultSet rs=JDBCConnectivity.ps.executeQuery();
            if(rs.next()){
            Id=rs.getInt(1);
            }
            
            
            
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("Select * from project where project_id=?") ;
            JDBCConnectivity.ps.setInt(1,Id);
             rs=JDBCConnectivity.ps.executeQuery();
            if(rs.next()){
            project_title=rs.getString(1);
            project_id=rs.getString(2);
            durationyear=rs.getString(4);
            durationMonth=rs.getString(5);
            technology=rs.getString(6);
            description=rs.getString(7);%>
            
            <div style="text-align:left;width:30%;color:#5b86e5;padding-bottom: 2px; margin-left:65%;margin-top:-28%;">
             <h4>Project Title:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             <%=project_title%>
             </div>
             
             <h4>Description:</h4>
             <div class="col-sm-12" style="background-color:lavenderblush;">
             <p><%=description%>
             </div>
             <h4>Project ID:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             <p><%=project_id%>
             </div>
             <h4>Duration:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             <%=durationyear%> years <%=durationMonth%> Months
             </div>
             <h4>Technology:</h4>
             <div class="col-sm-12" style="background-color:lavender;">
             <%=technology%>
             </div>
             
            </div>
 



            <%}
            else{%>
            <div style="text-align:left;width:30%;color:#5b86e5;padding-bottom: 2px; margin-left:65%;margin-top:-28%;">
                <div class="col-sm-12" style="background-color:lavender;">
                  Add Project Here
                </div>
            </div>       
            <%}
            JDBCConnectivity.ps.close();
            JDBCConnectivity.cn1.close();
          
        } catch (Exception e) {
            out.println(e);
        }
        finally{
      JDBCConnectivity.cn1=null;
        }
             
             
             
             %>
             
      
    </body>
    
</html>