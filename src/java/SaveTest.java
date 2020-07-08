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

/**
 *
 * @author Kritika
 */
@WebServlet(urlPatterns = {"/SaveTest"})
public class SaveTest extends HttpServlet {

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
            String bug_id=request.getParameter("value");
        String Assignee=request.getParameter("id");
        try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("update bugs set Assignee=? where bug_id=?");
         JDBCConnectivity.ps.setString(1, Assignee);
          JDBCConnectivity.ps.setString(2,bug_id );
           
         JDBCConnectivity.ps.executeUpdate();
          
           JDBCConnectivity.ps.close();
           JDBCConnectivity.cn1.close();
          
            RequestDispatcher rd=request.getRequestDispatcher("viewBug.jsp");
           rd.forward(request, response);
           
           
           
       }catch(Exception e){out.print(e);}
        
        
        
    }

}
      
   

