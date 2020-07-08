/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProjectHome.JDBCConnectivity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/SaveDev"})
public class SaveDev extends HttpServlet {

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
        String DevUnderstanding=request.getParameter("id");
        try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("update cumin_ticket set DevUnderstanding=? where cumin_number=?");
         JDBCConnectivity.ps.setString(1, DevUnderstanding);
          JDBCConnectivity.ps.setString(2,Cumin );
           
         JDBCConnectivity.ps.executeUpdate();
          
           
          
            RequestDispatcher rd=request.getRequestDispatcher("ViewTicket.jsp");
           rd.forward(request, response);
           JDBCConnectivity.ps.close();
           JDBCConnectivity.cn1.close();
           
           
       }catch(Exception e){out.print(e);}
        
        
        
    }

}
      
   
