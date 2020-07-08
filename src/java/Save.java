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
@WebServlet(urlPatterns = {"/Save"})
public class Save extends HttpServlet {

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
        String Cumin=request.getParameter("value");
        String LogWork=request.getParameter("id");
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
           PreparedStatement ps=con.prepareStatement("update cumin_ticket set LogWork=? where cumin_number=?");
          ps.setString(1, LogWork);
           ps.setString(2,Cumin );
           
         ps.executeUpdate();
          
           ps.close();
           con.close();
          
            RequestDispatcher rd=request.getRequestDispatcher("ViewTicket.jsp");
           rd.forward(request, response);
           
           
           
       }catch(Exception e){out.print(e);}
        
        
        
    }

}