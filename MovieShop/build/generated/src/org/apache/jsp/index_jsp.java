package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"icon\" href=\"img/Movieshop.png\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\n");
      out.write("        <title>MovieShop - Iniciar Sesión </title>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function togglePasswordVisibility() {\n");
      out.write("                var passwordInput = document.getElementById(\"txtContra\");\n");
      out.write("                var eyeIcon = document.getElementById(\"eyeIcon\");\n");
      out.write("\n");
      out.write("                if (passwordInput.type === \"password\") {\n");
      out.write("                    passwordInput.type = \"text\";\n");
      out.write("                    eyeIcon.src = \"img/imgPeliculas/Ocultar5.png\"; // Ruta de la imagen para ocultar\n");
      out.write("                } else {\n");
      out.write("                    passwordInput.type = \"password\";\n");
      out.write("                    eyeIcon.src = \"img/imgPeliculas/Mostrar.png\"; // Ruta de la imagen para mostrar\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin: 0; overflow: hidden; background-size: cover\">\n");
      out.write("        <img src=\"img/FONDOs.gif\" alt=\"\" style=\"width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1\">\n");
      out.write("\n");
      out.write("        <div class=\"container w-75 bg-danger mt-5 rounded shadow\">\n");
      out.write("            <div class=\"row align-items-stretch\">\n");
      out.write("                <div class=\"col d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded\">\n");
      out.write("                    <img src=\"img/MovieshopLogo.png\" width=\"680\">                 \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col bg-white p-5 rounded-end\">\n");
      out.write("                    <div class=\"text-end\">\n");
      out.write("                        <img src=\"img/MovieshopLogo.png\" width=\"48\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <h2 class=\"fw-bold text-center py-5\">BIENVENIDO</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <form action=\"Validar\" method=\"POST\">\n");
      out.write("                        <div class=\"mb-4\">\n");
      out.write("                            <label class=\"form-label\"></label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtUser\" placeholder=\"Usuario\" >\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"mb-4\" style=\"font-size: 35px\">\n");
      out.write("\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <input type=\"password\" id=\"txtContra\" name=\"txtPass\" class=\"form-control\" placeholder=\"Contraseña\" />\n");
      out.write("                                <div class=\"input-group-append\">\n");
      out.write("                                    <button type=\"button\" onclick=\"togglePasswordVisibility()\" id=\"toggleBtn\" style=\"margin-left: 10px\">\n");
      out.write("                                        <img id=\"eyeIcon\" src=\"img/imgPeliculas/Mostrar.png\" alt=\"Mostrar\" height=\"25px\" width=\"50px\">\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-4\">\n");
      out.write("                            <input type=\"checkbox\" name=\"connected\" class=\"form-check-input\">\n");
      out.write("                            <label for=\"connecter\" class=\"form-check-label\">Mantenerme Conectado</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"d-grid\">\n");
      out.write("                            <button type=\"submit\" name=\"accion\" value=\"Ingresar\" class=\"btn btn-primary\">Iniciar Sesión</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <br> \n");
      out.write("                            <p>No tienes cuenta? <a href=\"Controlador?menu=AgregarUsuarios\">Registrate</a></p> <br> <br> \n");
      out.write("                        </div> \n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"container w-100 my-5\">\n");
      out.write("                        <div class=\"row text-center\">\n");
      out.write("                            <div class=\"col-12\">Iniciar Sesión</div>    \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\" >\n");
      out.write("                            <div class=\"col\" >\n");
      out.write("                                <button class=\"btn btn-outline-primary w-100 my-1\" >\n");
      out.write("                                    <a href=\"Controlador?menu=Facebook\">\n");
      out.write("                                        <div class=\"row align-items-center\">\n");
      out.write("                                            <div class=\"col-2 d-none d-md-block\">\n");
      out.write("                                                <img src=\"img/FacebookLogin.png\" width=\"32\" alt=\"\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-10 text-center\" hr >\n");
      out.write("                                                Facebook\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <button class=\"btn btn-outline-danger w-100 my-1\">\n");
      out.write("                                    <a href=\"Controlador?menu=Google\">\n");
      out.write("                                        <div class=\"row align-items-center\">\n");
      out.write("                                            <div class=\"col-2 d-none d-md-block\">\n");
      out.write("                                                <img src=\"img/LogoGoogle.png\" width=\"32\" alt=\"\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-10 text-center\">\n");
      out.write("                                                Google\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>   \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-5.3.0.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
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
