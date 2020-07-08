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

/**
 *
 * @author Kritika
 */
@WebServlet(urlPatterns = {"/AddDev"})
public class AddDev extends HttpServlet {

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
        String Developer = request.getParameter("Developer");
        int Employee_id = Integer.parseInt(request.getParameter("Employee_id"));
        String Emp_password = request.getParameter("Emp_password");
        String Experience = request.getParameter("durationyear") + "yrs";
        String skills = request.getParameter("skills");
        String DevType = request.getParameter("DevType");
        int projectid = Integer.parseInt(request.getParameter("projectid"));
        try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            if (DevType.equals("Developer")) {
                JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("insert into developer values(?,?,?,?,?,?)");
                JDBCConnectivity.ps.setInt(1, Employee_id);
                JDBCConnectivity.ps.setString(2, Developer);
                JDBCConnectivity.ps.setString(3, Emp_password);
                JDBCConnectivity.ps.setString(4, Experience);
                JDBCConnectivity.ps.setString(5, skills);
                JDBCConnectivity.ps.setInt(6, projectid);

                JDBCConnectivity.ps.executeUpdate();
                JDBCConnectivity.ps.close();
                JDBCConnectivity.cn1.close();

                response.sendRedirect("ProjectHome.jsp");
            } else {

                JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("insert into Tester values(?,?,?,?,?,?)");
                JDBCConnectivity.ps.setInt(1, Employee_id);
                JDBCConnectivity.ps.setString(2, Developer);
                JDBCConnectivity.ps.setString(3, Emp_password);
                JDBCConnectivity.ps.setString(4, Experience);
                JDBCConnectivity.ps.setString(5, skills);
                JDBCConnectivity.ps.setInt(6, projectid);

                JDBCConnectivity.ps.executeUpdate();
                JDBCConnectivity.ps.close();
                JDBCConnectivity.cn1.close();

                response.sendRedirect("ProjectHome.jsp");
            }

        } catch (Exception e) {

            request.setAttribute("msg", e.toString());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddDeveloper.jsp");
            rd.forward(request, response);
        } finally {
            JDBCConnectivity.cn1 = null;
        }
    }

}
