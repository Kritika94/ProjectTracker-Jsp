/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kritika
 */
public class Createstory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private int hitCount; 

   public void init() { 
      // Reset hit counter.
      hitCount = 0;
   } 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
             hitCount++;
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       int x=(int)(Math.random()*6);
       
       String CuminTicket="EMMGDCX"+x+hitCount;
       String title=request.getParameter("storyTitle");
       String DevUnderstanding=request.getParameter("Developer Understanding");
       String datefield=request.getParameter("datefield");
       Date date ;
       String status="open";
        String EstimatedTime=request.getParameter("estimatedTime")+"hrs";
       String RemainingTime=request.getParameter("remainingTime")+"hrs";
       String Reporter=request.getParameter("Reporter");
           
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
           PreparedStatement ps=con.prepareStatement("insert into cumin_ticket values (?,?,?,?,?,?,?,?,?)");
           ps.setString(1, CuminTicket);
           ps.setString(2, Reporter);
           ps.setString(3, datefield);
           ps.setString(4, title);
           ps.setString(5, status);
           ps.setString(6, DevUnderstanding);
           ps.setString(7, EstimatedTime);
           ps.setString(8, RemainingTime);
           ps.setString(9,null);
           ps.executeUpdate();
           response.sendRedirect("CuminDashboard.jsp");
           
           ps.close();
           con.close();
       
       }
       catch(Exception e){out.println(e);}
    }
    }

