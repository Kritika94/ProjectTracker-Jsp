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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kritika
 */
@WebServlet(urlPatterns = {"/CreateBug"})
public class CreateBug extends HttpServlet {

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

        hitCount++;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int x = (int) (Math.random() * 6);
        String Bug_Id = "EMMGDCXBug" + x + hitCount;
        String title = request.getParameter("bug_name");
        String Ticket = request.getParameter("Cumin");
        String Bug_Type = request.getParameter("bug_type");
        String status = "open";
        String Assignee = request.getParameter("Assignee");
        String Description = request.getParameter("description");
        String Reporter = request.getParameter("Reporter");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
            PreparedStatement ps = con.prepareStatement("insert into bugs values (?,?,?,?,?,?,?,?)");
            ps.setString(1, Reporter);
            ps.setString(2, Bug_Type);
            ps.setString(3, status);
            ps.setString(4, Bug_Id);
            ps.setString(5, Assignee);
            ps.setString(6, title);
            ps.setString(7, Description);
            ps.setString(8, Ticket);
            ps.executeUpdate();
            response.sendRedirect("Tester.jsp");
            ps.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}
