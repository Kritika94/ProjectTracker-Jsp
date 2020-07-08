<%-- 
    Document   : ViewTicket
    Created on : 17 Feb, 2020, 9:28:49 PM
    Author     : Kritika
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header2.jsp" %>
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
        <%  String CuminNumber = request.getParameter("value");%>
        <script>

            function unloadEvt() {

                document.location.href = 'statusChange?value=<%=CuminNumber%>';

            }
            function WorkLogEdit() {


                var Log = document.getElementById("Log").innerHTML;
                document.location.href = 'Save?value=<%=CuminNumber%>&id=' + Log;


            }
            function DevUnderstanding() {


                var Dev = document.getElementById("dev").innerHTML;
                document.location.href = 'SaveDev?value=<%=CuminNumber%>&id=' + Dev;


            }

            function editable() {
                document.getElementById("dev").setAttribute("contenteditable", true);
                document.getElementById("devedit").hidden = false;
            }

            function editable3() {
                document.getElementById("Log").setAttribute("contenteditable", true);
                document.getElementById("workLog").hidden = false;
            }


            function editables() {
                document.getElementById("editAssignee").setAttribute("contenteditable", true);
                document.getElementById("devedit2").hidden = false;
            }

            function Assigned() {
                var Dev = document.getElementById("editAssignee").innerHTML;
                document.location.href = 'SaveAssignee?value=<%=CuminNumber%>&id=' + Dev;

            }





        </script>
    </head>
    <%
        String Title = null;
        double TimePercentage = 0;
        String LogWork = null;
        String Date = null;
        String Status = null;
        String DevUnderStanding = null;
        String Estimatedhrs = null;
        String Remaininghrs = null;
        String Assignee = null;
        try {
            request.setAttribute("cumin_Number", CuminNumber);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
            PreparedStatement ps = con.prepareStatement("select * from cumin_ticket where cumin_number=?");
            ps.setString(1, CuminNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Title = rs.getString(4);
                Status = rs.getString(5);
                DevUnderStanding = rs.getString(6);
                Estimatedhrs = rs.getString(7);
                Remaininghrs = rs.getString(8);
                String substr = Estimatedhrs.replace("hrs", "");
                String substr2 = Remaininghrs.replace("hrs", "");
                Assignee = rs.getString(10);
                int x = Integer.parseInt(substr);
                int y = Integer.parseInt(substr2);
                TimePercentage = ((double) y / (double) x) * 100;
                LogWork = rs.getString(9);
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

                <div class="col-sm-4" style="background-color:lavender;"><button class=" btn btn-primary" data-toggle="modal" data-target="#myModal">Create Subtask:</button>
                    <div class="modal" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Create Subtask</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <form class="form-horizontal" action="Subtask?value=<%=CuminNumber%>" method="post">
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label"
                                                    for="title">Title</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" 
                                                       id="inputEmail3" name="Title" placeholder="Title"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"
                                                   for="description" >Description</label>
                                            <div class="col-sm-10">
                                                <textarea row="4"  class="form-control" name="Description"
                                                          id="description" placeholder=" Enter Description"></textarea>
                                            </div>
                                        </div>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button  class="btn btn-primary">OK</button>
                                    <button  class="btn" style="background-color:#cccccc" data-dismiss="modal">cancel</button>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="cumin"  value="<%=CuminNumber%>"  >
                <div class="col-sm-4" style="background-color:lavenderblush;"><button class="btn btn-success" onclick='unloadEvt()' style="width:105px"><%=Status%></button></div>
                <div class="col-sm-4" style="background-color:lavender;">Estimated Time:  <%=Estimatedhrs%>

                </div>
            </div>
            <p></p>
            <div class="row"> 
                <div class="col-sm-4" style="background-color:lavenderblush;">

                    <span style="padding :0px 14px 14px 14px;color:white;font-weight: bold;background-color:#5b86e5">Assignee : <span id='editAssignee'><%=Assignee%></span><button onclick="editables()"  class="btn" style="font-size:20px; background-color: transparent"><i class="fa fa-pencil"></i></button><button id="devedit2" onclick="Assigned()" title="save" class="btn" style="font-size:20px; background-color: transparent" hidden><i class="fa fa-floppy-o"></i></button></span>



                </div>
                <div class="col-sm-4" ><button class=" btn btn-primary" data-toggle="modal" data-target="#myModalNew">Log Work:</button>
                    <!-- The Modal -->
                    <div class="modal" id="myModalNew">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Log Work</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <form class="form-horizontal" action="LogWork?value=<%=CuminNumber%>" method="post">

                                        <div class="form-group">

                                            <div class="col-sm-10">
                                                <textarea row="4"  class="form-control"
                                                          id="description"  name ="WorkDesc" placeholder=" Enter Description"></textarea>
                                            </div>
                                            <div class="form-group">
                                                <br>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" name="RemainingTime" 
                                                           id="inputEmail3" placeholder="Remaining Time"/>
                                                </div>
                                            </div>
                                        </div>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button  class="btn btn-primary">OK</button>
                                    <button  class="btn" style="background-color:#cccccc" data-dismiss="modal">cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4" style="background-color:lavender;">Remaining Time :
                    <div class="container">
                        <div class="progress" style="width:20%">
                            <div class="progress-bar" role="progressbar"  aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:<%=TimePercentage%>%">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <p></p>
            <div class="row">
                <div class="container" height="50px">

                    <div class="jumbotron" style="height:40px">
                        <h3 style="margin-top:-54px">Developer Understanding: <button onclick="editable()"  class="btn" style="font-size:20px; background-color: transparent"><i class="fa fa-pencil"></i></button><button id="devedit" onclick="DevUnderstanding()" title="save" class="btn" style="font-size:20px; background-color: transparent" hidden><i class="fa fa-floppy-o"></i></button></h3>
                        <p id="dev"> <%=DevUnderStanding%></p>


                    </div>

                </div>
            </div>
            <div class="row">
                <div class="container" height="50px">

                    <div class="jumbotron" style="height:40px">
                        <h3 style="margin-top:-54px">Subtask:<button  class="btn" style="font-size:20px; background-color: transparent"></h3>

                        <p id="sub">
                            <%
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
                                    PreparedStatement ps = con.prepareStatement("select title,subtask_id from subtask where cumin_number=?");
                                    ps.setString(1, CuminNumber);
                                    ResultSet rs = ps.executeQuery();
                                    int i = 1;
                                    while (rs.next()) {
                                        String task = rs.getString(1);
                                        String subId = rs.getString(2);
                                        out.println("<b style='font-weight:bold'>" + i + " " + task + "</b>");
                                        i++;
                                    }
                                } catch (Exception e) {
                                    System.out.println();
                                }

                            %>     


                        </p>
                    </div>
                    <div class="jumbotron" style="height:40px">
                        <h3 style="margin-top:-54px">Work Log:<button  class="btn" onclick="editable3()" style="font-size:20px; background-color: transparent"><i class="fa fa-pencil"></i></button><button id="workLog" title="save" onclick="WorkLogEdit();" class="btn" style="font-size:20px; background-color: transparent" hidden><i class="fa fa-floppy-o"></i></button></h3>
                                <%if (LogWork != null) {%>

                        <p id="Log"><%=LogWork%></p>



                        <%}
                        %>


                    </div>

                </div>
            </div>


    </body>
</html>
