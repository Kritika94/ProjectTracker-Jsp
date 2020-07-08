<%-- 
    Document   : CreateStory
    Created on : 17 Feb, 2020, 9:22:57 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header2.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function myFunction() {
   var element = document.getElementById("story");
   element.classList.add("active");
   document.getElementById("dashboard").classList.remove("active");
   document.getElementById("viewTicket").classList.remove("active");
   document.getElementById("ProjectStatus").classList.remove("active");
}
myFunction();
            
        </script>
    </head>
    <body>
        <center>
            <%String name=(String)session.getAttribute("user");%>
        <div style="text-align: center; color:black; margin-top:1%; ">
            <form action="Createstory" method="post">
               Title:<input type="text" name="storyTitle" style="margin-left:12%;width:300px " /><br><br>
               Developer Understanding: <textarea row="4"  style="margin-left:2%;width:300px;height:200px"  name="Developer Understanding"></textarea><br><br>
               Date:<input type="date"style="margin-left:12%;width:300px" name="datefield"/><br><br>
                <span style="margin-left:-13.2%;position: absolute">Estimated Time:</span><input type="number" name="estimatedTime" style="margin-left: 1%;width:60px "/> (hrs) <br><br>
                <span style="margin-left:-13%;position: absolute">Remaining Time:</span>  <input type="number" name="remainingTime" style="margin-left:1%;width:60px "/> (hrs)
                <input type="hidden" value="<%=name%>" name="Reporter"/>
                <br><br><button style="background:linear-gradient(#66ccff,#eefefe);
                                             color:Black;margin-left:0px; margin-top:2px; 
                                             width: 205px;font-family:initial; font-weight:bold; font-size:100%">Create Story</button>  
                
                
               
            </form>
            
            
            
        </div>
        </center>
    </body>
</html>
