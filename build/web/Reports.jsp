<%-- 
    Document   : Reports
    Created on : 8 Mar, 2020, 5:08:13 PM
    Author     : Kritika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <% String value = request.getParameter("value");%>
        <%@include file="ProjectStatusManage.jsp" %>
        <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost:3306/cumin" user="root" password="123456"/>
        <div class="div2"> 
            <%if (value.equals("BugReport")) {%>
            <sql:query dataSource = "${snapshot}" var = "result">
                select * from Bugs;
            </sql:query>
            <table class="table col-lg-12">
                <thead>
                    <tr>
                        <th scope="col">Bug Reporter</th>
                        <th scope="col">Bug Type</th>
                        <th scope="col">Bug Status</th>
                        <th scope="col">Bug Id</th>
                        <th scope="col">Assignee</th>
                        <th scope="col">Bug Header</th>
                        <th scope="col">Cumin Ticket</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach var = "row" items = "${result.rows}">
                        <tr>
                            <td> <c:out value = "${row.bug_reorter}"/></td>
                            <td> <c:out value = "${row.bug_type}"/></td>
                            <td> <c:out value = "${row.bug_status}"/></td>
                            <td> <c:out value = "${row.bug_Id}"/></td>
                            <td> <c:out value = "${row.Assignee}"/></td>
                            <td> <c:out value = "${row.Bugs_header}"/></td>
                            <td> <c:out value = "${row.Cumin_ticket}"/></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <% }%>

            <%if (value.equals("CuminStatus")) {%>
            <sql:query dataSource = "${snapshot}" var = "result">
                select cumin_number,reporter_name, status,Assignee from cumin_ticket;
            </sql:query>
            <table class="table col-lg-12">
                <thead>
                    <tr>
                        <td scope="col">Cumin Number</td>
                        <td scope="col">Reporter Name</td>
                        <td scope="col"> Status</td>
                        <td scope="col"> Assignee</td>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach var = "row" items = "${result.rows}">
                        <tr>
                            <td> <c:out value = "${row.cumin_number}"/></td>
                            <td> <c:out value = "${row.reporter_name}"/></td>
                            <td> <c:out value = "${row.status}"/></td>
                            <td> <c:out value = "${row.Assignee}"/></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <% }%>
            <%if (value.equals("ProjectReport")) {%>       
            <sql:query dataSource = "${snapshot}" var = "resultclosed">
                select count(*) from cumin_ticket where status=?;
                <sql:param value = "Closed"  />
            </sql:query>
            <sql:query dataSource = "${snapshot}" var = "result2">
                select count(*) from cumin_ticket;

            </sql:query>

            <center>
                <div class="col-sm-4" style="background-color:lavender;">Project Status :
                    <div class="container">
                        <div class="progress" style="width:100%">
                            <div class="progress-bar" role="progressbar" id="progress"  aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">

                            </div>

                        </div>
                    </div>
                    <p id="progressStat"></p>
                </div>
            </center>
            <%}%>
        </div>
        <script>

            function foo() {
                 //var foo=${result2.rowsByIndex[0][0]}*100;
                var foo = ${resultclosed.rowsByIndex[0][0]/result2.rowsByIndex[0][0]*100};
                document.getElementById("progress").style.width = foo + '%';
                document.getElementById("progressStat").innerHTML = "The status of your project is " + foo + "%. Kindly increase the number of closed tickets over total number of tickets, to improvise the Project status";
            }
            foo();

        </script>

    </body>
</html>
