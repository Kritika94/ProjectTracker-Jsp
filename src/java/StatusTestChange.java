/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kritika
 */
@WebServlet(urlPatterns = {"/StatusTestChange"})
public class StatusTestChange extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        
        String Bug= request.getParameter("value");
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
           PreparedStatement ps=con.prepareStatement("select bug_status from bugs where bug_id=?");
          String status=null; 
           ps.setString(1,Bug );
         ResultSet rs= ps.executeQuery();
           if(rs.next()){
          status= rs.getString(1);
        
          
           if(status.equals("open")){
               ps=con.prepareStatement("update bugs set bug_status='assigned' where bug_id=?");
                ps.setString(1,Bug);
               ps.executeUpdate();
           
           } 
          if(status.equals("assigned")){
               ps=con.prepareStatement("update bugs set bug_status='In Progress' where bug_id=?");
               ps.setString(1,Bug);
                ps.executeUpdate();
           
           } 
          if(status.equals("In Progress")){
               ps=con.prepareStatement("update bugs set bug_status='closed' where bug_id=?");
               ps.setString(1,Bug);
                ps.executeUpdate();
           
           } 
          if(status.equals("closed")){
           ps= con.prepareStatement("update bugs set bug_status='open' where bug_id=?");
           ps.setString(1,Bug);   
           ps.executeUpdate();
           
          } } 
           rs.close();
           ps.close();
           con.close();
          
            RequestDispatcher rd=request.getRequestDispatcher("viewBug.jsp");
           rd.include(request, response);
           
           
           
       }catch(Exception e){out.print(e);}
        
        
        
    }

}