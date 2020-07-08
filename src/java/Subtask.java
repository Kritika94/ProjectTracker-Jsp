/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProjectHome.JDBCConnectivity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ProjectHome.JDBCConnectivity;
/**
 *
 * @author Kritika
 */
@WebServlet(urlPatterns = {"/Subtask"})
public class Subtask extends HttpServlet {
 private int hitCount; 

   public void init() { 
      // Reset hit counter.
      hitCount = 0;
   } 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       hitCount++;
        String Title = request.getParameter("Title");
        String Description = request.getParameter("Description");
        String cumin= request.getParameter("value");
        int x=(int)(Math.random()*7);
        int y=(int)(Math.random()*7);
        int z=x*y;
        String subtask_number=cumin.substring(0,7)+z+"ST"+hitCount;
       out.println(subtask_number);
       out.println(Description);
           out.println(cumin);
               out.println(Title);
        try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("insert into subtask values(?,?,?,?)") ;
            JDBCConnectivity.ps.setString(1,cumin);
            JDBCConnectivity.ps.setString(2,Title);
            JDBCConnectivity.ps.setString(3,Description);
            JDBCConnectivity.ps.setString(4,subtask_number);
            JDBCConnectivity.ps.executeUpdate();
            response.sendRedirect("ViewTicket.jsp?value="+cumin);
            
              JDBCConnectivity.ps.close();
              JDBCConnectivity.cn1.close();
              

        } catch (Exception e) {
            out.println(e);
        }
        finally{
      JDBCConnectivity.cn1=null;
        }
    }

}
