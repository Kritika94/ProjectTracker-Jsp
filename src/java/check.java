/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Kritika
 */
@WebServlet(name = "check", urlPatterns = {"/check"})
public class check extends HttpServlet {

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
        String uname = request.getParameter("usertxb");
        String pass = request.getParameter("passt");
        out.println(uname);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
            PreparedStatement ps = con.prepareStatement("select * from log_in where username=? and password=?");
            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String Designation = rs.getString(3);
                int Project_id = rs.getInt(4);
                HttpSession session = request.getSession(false);
                session.setAttribute("user", uname);
                session.setAttribute("Project_id", Project_id);
                session.setAttribute("Designation", Designation);
                if (Designation.equals("Manager")) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProjectHome.jsp");
                    rd.forward(request, response);
                }
                if (Designation.equals("Tester")) {

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Tester.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/CuminDashboard.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("msg", "Check username password");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/CuminLogin.jsp");
                rd.include(request, response);

            }

        } catch (Exception e) {
            out.println(e);
        }

    }
}
