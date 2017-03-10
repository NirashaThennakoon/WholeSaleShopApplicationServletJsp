package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.business.custom.impl.CustomerBOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public final class customerNew_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <title>title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">        \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway:400,700\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/animate.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/media-queries.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/ico/favicon.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"assets/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"assets/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"assets/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"assets/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            .selectbox{\n");
      out.write("                width: 100% ; \n");
      out.write("                height: 50px; \n");
      out.write("                margin: 0; \n");
      out.write("                padding: 0 20px; \n");
      out.write("                vertical-align: middle; \n");
      out.write("                background: #fff; \n");
      out.write("                border: 3px solid #fff; \n");
      out.write("                font-family: 'Raleway', sans-serif; \n");
      out.write("                font-size: 15px; \n");
      out.write("                font-weight: 400; \n");
      out.write("                line-height: 50px; \n");
      out.write("                color: #888;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"top-content\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                \n");
      out.write("                <div class=\"row\" style=\"height: 100px\"></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-1\"></div>\n");
      out.write("                    <div class=\"col-md-10\">\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"img_icon icon1\"></span>\n");
      out.write("                                <span class=\"link_title\" style=\"color: white\">Home</span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"img_icon icon2\"></span>\n");
      out.write("                                <span class=\"link_title\" style=\"color: white\">Add Customer</span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"img_icon icon3\"></span>\n");
      out.write("                                <span class=\"link_title\" style=\"color: white\">All Customers</span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <span class=\"img_icon icon4\"></span>\n");
      out.write("                                <span class=\"link_title\" style=\"color: white\">Other</span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-1\"></div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"row\" style=\"height: 50px\"></div>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-8 col-sm-offset-2 text\">\n");
      out.write("                        <h1 class=\"wow fadeInLeftBig\" style=\"color: #e36da1\">Customer</h1>\n");
      out.write("                        <!--<div class=\"description wow fadeInLeftBig\">-->\n");
      out.write("                        <!--<p>-->\n");
      out.write("                        <!--We have been working very hard to create the new version of our app. It comes with a lot of new features. Check it out now!-->\n");
      out.write("                        <!--</p>-->\n");
      out.write("                        <!--</div>-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\" style=\"height: 10px\"></div>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp\">\n");
      out.write("                        <div class=\"r-form-1-top\">\n");
      out.write("                            <div class=\"r-form-1-top-left\">\n");
      out.write("                                <h3>Search First!!!</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <!--<div class=\"r-form-1-top-right\">-->\n");
      out.write("                            <!--<i class=\"fa fa-pencil\"></i>-->\n");
      out.write("                            <!--</div>-->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"r-form-1-bottom\">\n");
      out.write("                            <form role=\"form\" id=\"frm\" enctype=\"application/x-www-form-urlencoded\" method=\"POST\" action=\"Servelet\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Id</label>\n");
      out.write("                                    <select class=\"selectbox\" name=\"txtCustomerId\" id=\"txtCustomerId\" onchange=\"loadCustomerDetails(this)\">\n");
      out.write("                                        <option selected disabled hidden>Select Customer ID</option>\n");
      out.write("                                        ");

                                          ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
                                          CustomerBOImpl customerBO = (CustomerBOImpl) ctx.getBean("customerBOImpl");
                                          ArrayList<CustomerDTO> customers = customerBO.getAll();
                                          for(CustomerDTO customer : customers){ 
      out.write("\n");
      out.write("                                              <option value=\"");
      out.print( customer.getId() );
      out.write('"');
      out.write('>');
      out.print( customer.getId() );
      out.write("</option>\n");
      out.write("                                        ");

                                          }
                                        
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Name</label>\n");
      out.write("                                    <input type=\"text\" name=\"txtCustomerName\" class=\"r-form-1-last-name form-control\" id=\"txtCustomerName\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Address</label>\n");
      out.write("                                    <input type=\"text\" name=\"txtCustomerAddress\" class=\"r-form-1-email form-control\" id=\"txtCustomerAddress\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Salary</label>\n");
      out.write("                                    <input type=\"text\" name=\"txtCustomerSalary\" class=\"r-form-1-email form-control\" id=\"txtCustomerSalary\">\n");
      out.write("                                </div>\n");
      out.write("                                <div><button id=\"btnUpdate\" type=\"button\" class=\"btn\">Update</button></div>\n");
      out.write("                                <br>\n");
      out.write("                                <div><button id=\"btnDelete\" type=\"button\" class=\"btn\">Delete</button></div>\n");
      out.write("                                <br>\n");
      out.write("                                <div><button id=\"btnSearch\" type=\"button\" class=\"btn\">Search</button></div>\n");
      out.write("                                <br>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(\"#btnUpdate\").click(function () {\n");
      out.write("                $(\"#frm\").attr(\"action\", \"Servelet?action=update\");\n");
      out.write("                $(\"#frm\").submit();\n");
      out.write("\n");
      out.write("                alert(\"ddd\");\n");
      out.write("            });\n");
      out.write("            $(\"#btnDelete\").click(function () {\n");
      out.write("                $(\"#frm\").attr(\"action\", \"Servelet?action=delete\");\n");
      out.write("                $(\"#frm\").submit();\n");
      out.write("\n");
      out.write("                alert(\"ddd\");\n");
      out.write("            });\n");
      out.write("            $(\"#btnSearch\").click(function () {\n");
      out.write("                $(\"#frm\").attr(\"action\", \"Servelet?action=search\");\n");
      out.write("                $(\"#frm\").submit();\n");
      out.write("\n");
      out.write("                alert(\"ddd\");\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.backstretch.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/wow.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/retina-1.1.0.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/scripts.js\"></script>\n");
      out.write("        <script src=\"assets/js/placeholder.js\"></script>\n");
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
