package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Barang_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <title>Data Barang</title>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("\n");
      out.write("        body{\n");
      out.write("            font-family: Arial;\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            flex-direction: column;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2{\n");
      out.write("            color: darkblue;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form{\n");
      out.write("            background: white;\n");
      out.write("            padding: 25px;\n");
      out.write("            width: 350px;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            box-shadow: 0px 0px 15px gray;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label{\n");
      out.write("            font-size: 18px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=text]{\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 8px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=submit]{\n");
      out.write("            background: blue;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px;\n");
      out.write("            border: none;\n");
      out.write("            width: 100%;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 16px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=submit]:hover{\n");
      out.write("            background: darkblue;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <h2>FORM DATA BARANG</h2>\n");
      out.write("\n");
      out.write("    <form>\n");
      out.write("\n");
      out.write("        <label>Kode Barang :</label>\n");
      out.write("        <input type=\"text\" name=\"kodeBarang\">\n");
      out.write("\n");
      out.write("        <label>Nama Barang :</label>\n");
      out.write("        <input type=\"text\" name=\"namaBarang\">\n");
      out.write("\n");
      out.write("        <label>Harga :</label>\n");
      out.write("        <input type=\"text\" name=\"harga\">\n");
      out.write("\n");
      out.write("        <label>Stok :</label>\n");
      out.write("        <input type=\"text\" name=\"stok\">\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Simpan\">\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Update\">\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Delete\">\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
