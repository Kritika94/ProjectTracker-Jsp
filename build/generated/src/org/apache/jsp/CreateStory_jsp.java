package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CreateStory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header2.jsp");
    _jspx_dependants.add("/Header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/LoginCss.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cumin Ticket</title>\n");
      out.write("    </head>\n");
      out.write("    <body>  \n");
      out.write("     <div class=\"header__bg\"><img src='images/logo.png' style=\"margin-top:12px;transform:skewY(6deg)\" width=\"20%\" height=\"55%\"><h2 style=\"color:white;transform:skewY(6deg);margin-left:20%; font-size: 40px\"> Project Tracker</h2>\n");
      out.write("    </div>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/NavigationHeader.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            .active {\n");
      out.write("  background-color: dodgerblue;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("        <div class=\"pill-nav\" style=\"margin-top: 220px\">\n");
      out.write("            <a class=\"active\" onclick=\"\" id=\"dashboard\" href=\"CuminDashboard.jsp\"> Dashboard</a>\n");
      out.write("            <a href=\"CreateStory.jsp\"  id=\"story\">Create Story</a>\n");
      out.write("            <a href=\"ViewTicket.jsp\" id=\"viewTicket\">View Ticket</a>\n");
      out.write("            <a href=\"ProjectStatus.jsp\" id=\"ProjectStatus\">Project Status</a>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("   var element = document.getElementById(\"story\");\n");
      out.write("   element.classList.add(\"active\");\n");
      out.write("   document.getElementById(\"dashboard\").classList.remove(\"active\");\n");
      out.write("   document.getElementById(\"viewTicket\").classList.remove(\"active\");\n");
      out.write("   document.getElementById(\"ProjectStatus\").classList.remove(\"active\");\n");
      out.write("}\n");
      out.write("myFunction();\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            ");
String name=(String)session.getAttribute("user");
      out.write("\n");
      out.write("        <div style=\"text-align: center; color:white; margin-top:1%; \">\n");
      out.write("            <form action=\"Createstory\" method=\"post\">\n");
      out.write("               Title:<input type=\"text\" name=\"storyTitle\" style=\"margin-left:12%;width:300px \" /><br><br>\n");
      out.write("               Developer Understanding:<input type=\"textarea\" style=\"margin-left:2%;width:300px;height:200px\"  name=\"Developer Understanding\"/><br><br>\n");
      out.write("               Date:<input type=\"date\"style=\"margin-left:12%;width:300px\" name=\"datefield\"/><br><br>\n");
      out.write("                <span style=\"margin-left:-13%;position: absolute\">Estimated Time:</span><input type=\"text\" name=\"estimatedTime\" style=\"margin-left: 1%;width:60px \"/> (hrs) <br><br>\n");
      out.write("                <span style=\"margin-left:-13%;position: absolute\">Remaining Time:</span>  <input type=\"text\" name=\"remainingTime\" style=\"margin-left:1%;width:60px \"/> (hrs)\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(name);
      out.write("\" name=\"Reporter\"/>\n");
      out.write("                <br><br><button style=\"background:linear-gradient(#66ccff,#eefefe);\n");
      out.write("                                             color:Black;margin-left:0px; margin-top:2px; \n");
      out.write("                                             width: 205px;font-family:initial; font-weight:bold; font-size:100%\">Create Story</button>  \n");
      out.write("                \n");
      out.write("                \n");
      out.write("               \n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
