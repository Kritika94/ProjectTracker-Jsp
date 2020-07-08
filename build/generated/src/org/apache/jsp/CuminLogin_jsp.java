package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CuminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/LoginCss.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cumin Ticket</title>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        input{\n");
      out.write("            -moz-border-radius: 15px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            border:solid 1px grey;\n");
      out.write("            padding:5px;\n");
      out.write("            background-color:white;\n");
      out.write("            color:Black;\n");
      out.write("            width: 200px;font-family:initial; font-weight:bolder; font-size:100%;\n");
      out.write("        }\n");
      out.write("        ::placeholder {\n");
      out.write("            color: #5b86e5;\n");
      out.write("            opacity: 1;  \n");
      out.write("            font-family: sans-serif;\n");
      out.write("        } \n");
      out.write("        i{\n");
      out.write("            color:#5b86e5;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <div class=\"divLogin\">\n");
      out.write("            <h2 style=\"font-family:sans-serif;color:#5b86e5;font-size:40px  \"><img src=\"images/Staff.png\" width=20% height=\"20%\">Login</h2>\n");
      out.write("            <form action=\"check\" method=\"post\">\n");
      out.write("                <i class=\"fa fa-user\" style=\"font-size:130%\"></i> <input id=\"username\" name=\"usertxb\" placeholder=\"User Name\"  required=\"true\">\n");
      out.write("                <br>\n");
      out.write("                <i class=\"fa fa-lock\" style=\"font-size:130%\"></i>&nbsp;<input id=\"passtxb\" style=\"margin-top:4px\"  name=\"passt\" class=\"img\" placeholder=\"Password\" type=\"password\" required/>\n");
      out.write("                <br> <button style=\"background:linear-gradient(#66ccff,#eefefe);\n");
      out.write("                             color:Black;margin-left:15px; margin-top:2px; \n");
      out.write("                             width: 205px;font-family:initial; font-weight:bolder; font-size:100%\">Submit</button>\n");
      out.write("            </form>\n");
      out.write("            ");
String msg = (String) request.getAttribute("msg");
                                if (msg != null) {
      out.write("\n");
      out.write("            <p style=\"color:red\">");
      out.print(msg);
      out.write("</p>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
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
