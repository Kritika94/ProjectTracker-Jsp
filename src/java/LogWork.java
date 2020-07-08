/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProjectHome.JDBCConnectivity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(urlPatterns = {"/LogWork"})
public class LogWork extends HttpServlet {

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
        String Work = request.getParameter("WorkDesc");
        String RemainingTime = request.getParameter("RemainingTime") + "hrs";
        String cumin = request.getParameter("value");
        out.println(Work);
        out.println(RemainingTime);
        try {
            if (JDBCConnectivity.cn1 == null) {
                JDBCConnectivity.Connect();
            }
            JDBCConnectivity.ps = JDBCConnectivity.cn1.prepareStatement("update cumin_ticket set LogWork=? , remaining_hrs=? where cumin_number=?");
            JDBCConnectivity.ps.setString(1, Work);
            JDBCConnectivity.ps.setString(2, RemainingTime);
            JDBCConnectivity.ps.setString(3, cumin);
            JDBCConnectivity.ps.executeUpdate();
            RequestDispatcher rd = request.getRequestDispatcher("ViewTicket.jsp");
            rd.forward(request, response);

            JDBCConnectivity.ps.close();
            JDBCConnectivity.cn1.close();

        } catch (Exception e) {
            out.println(e);
        } finally {
            JDBCConnectivity.cn1 = null;
        }
    }

}
