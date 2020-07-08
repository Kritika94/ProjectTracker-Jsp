/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProjectHome.JDBCConnectivity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ProjectHome.JDBCConnectivity;
/**
 *
 * @author Kritika
 */
@WebServlet(urlPatterns = {"/AboutProject"})
public class AboutProject extends HttpServlet {

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
       String project_title=request.getParameter("project_title");
       String project_id=request.getParameter("project_id");
       String manager_id=request.getParameter("manager_id");
       String durationyear=request.getParameter("durationyear");
       String durationMonth=request.getParameter("durationMonth");
       String technology=request.getParameter("technology");
       String description=request.getParameter("description");
        try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("Select * from project where manager_ID=?");
            JDBCConnectivity.ps.setInt(1,Integer.parseInt(manager_id));
            ResultSet rs=JDBCConnectivity.ps.executeQuery();
            if(rs.next()){
                request.setAttribute("msg", "Not more than one project is allowed to be handled on your ID");
            RequestDispatcher rd=request.getRequestDispatcher("/ProjectRegister.jsp");
            rd.include(request, response);
            
            }
            
            JDBCConnectivity.ps.setString(1,project_title);
            
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("insert into project values(?,?,?,?,?,?,?)") ;
            JDBCConnectivity.ps.setString(1,project_title);
            JDBCConnectivity.ps.setString(2,project_id);
            JDBCConnectivity.ps.setString(3,manager_id);
            JDBCConnectivity.ps.setString(4,durationMonth);
            JDBCConnectivity.ps.setString(5,durationyear);
            JDBCConnectivity.ps.setString(6,technology);
            JDBCConnectivity.ps.setString(7,description);
            JDBCConnectivity.ps.executeUpdate();
            JDBCConnectivity.ps.close();
            JDBCConnectivity.cn1.close();
            HttpSession session=request.getSession();
            
            RequestDispatcher rd=request.getRequestDispatcher("ProjectHome.jsp");
            rd.include(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
      JDBCConnectivity.cn1=null;
        }
    }
}
    
   
       
       