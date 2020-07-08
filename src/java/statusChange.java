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
@WebServlet(urlPatterns = {"/statusChange"})
public class statusChange extends HttpServlet {

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

        String cumin = request.getParameter("value");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
            PreparedStatement ps = con.prepareStatement("select status from cumin_ticket where cumin_number=?");
            String status = null;
            ps.setString(1, cumin);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = rs.getString(1);
                out.print(status);

                if (status.equals("open")) {
                    ps = con.prepareStatement("update cumin_ticket set status='assigned' where cumin_number=?");
                    ps.setString(1, cumin);
                    ps.executeUpdate();

                }
                if (status.equals("assigned")) {
                    ps = con.prepareStatement("update cumin_ticket set status='In progress' where cumin_number=?");
                    ps.setString(1, cumin);
                    ps.executeUpdate();

                }
                if (status.equals("In progress")) {
                    ps = con.prepareStatement("update cumin_ticket set status='closed' where cumin_number=?");
                    ps.setString(1, cumin);
                    ps.executeUpdate();

                }
                if (status.equals("closed")) {
                    ps = con.prepareStatement("update cumin_ticket set status='open' where cumin_number=?");
                    ps.setString(1, cumin);
                    ps.executeUpdate();

                }
            }
            ps.close();
            con.close();

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewTicket.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            out.print(e);
        }

    }

}
