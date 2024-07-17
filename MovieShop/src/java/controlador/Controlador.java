 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Cesta;
import modelo.CestaDAO;
import modelo.DetallePago;
import modelo.DetallePagoDAO;
import modelo.DetallePromocion;
import modelo.DetallePromocionDAO;
import modelo.Pago;
import modelo.PagoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Promocion;
import modelo.PromocionDAO;
import modelo.Proveedores;
import modelo.ProveedoresDAO;
import modelo.Resena;
import modelo.ResenaDAO;
import modelo.ServicioCliente;
import modelo.ServicioClienteDAO;
import modelo.TipoTarjeta;
import modelo.TipoTarjetaDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Historial;
import modelo.HistorialDAO;
import modelo.Objeto;

/**
 *
 * @author 50242
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
@MultipartConfig
public class Controlador extends HttpServlet {

    int idProducto;
    int codProveedor;
    int idCesta;
    int codUsuario;
    int codigoUser;
    int idResena;
    int idDetallePromocion;
    int codPago;
    int idCategoria;
    int usoCategoria;
    int codTipoTarjeta;
    int idPromo;
    int idDe;
    double totalPagar;
    String nombres;
    int idUsuario;
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Promocion promocion = new Promocion();
    PromocionDAO promocionDao = new PromocionDAO();
    Categoria categoria = new Categoria();
    CategoriaDAO categoriaDao = new CategoriaDAO();
    Cesta cesta = new Cesta();
    CestaDAO cestaDAO = new CestaDAO();
    Resena resena = new Resena();
    ResenaDAO resenaDAO = new ResenaDAO();
    DetallePromocion detallePromocion = new DetallePromocion();
    DetallePromocionDAO detallePromocionDAO = new DetallePromocionDAO();
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    HistorialDAO historialDao = new HistorialDAO();
    Pago pago = new Pago();
    PagoDAO pagoDao = new PagoDAO();
    TipoTarjeta tipoTarjeta = new TipoTarjeta();
    TipoTarjetaDAO tipoTarjetaDao = new TipoTarjetaDAO();
    DetallePago detallePago = new DetallePago();
    DetallePagoDAO detallePagoDao = new DetallePagoDAO();
    ServicioCliente servicioCliente = new ServicioCliente();
    ServicioClienteDAO servicioClienteDAO = new ServicioClienteDAO();
    Proveedores proveedores = new Proveedores();
    ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
    String emailUsuario;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        // Obtén la sesión existente o crea una nueva si no existe
        HttpSession session = request.getSession(false);

        Usuario usuarioEnSesion = (Usuario) session.getAttribute("usuario");

        int ids = usuarioEnSesion.getIdUsuario();
        String nombre = usuarioEnSesion.getNombreUsuario();

        nombres = nombre;
        idDe = ids;

        if (menu.equals("PrincipalAdmin")) {
            request.getRequestDispatcher("PrincipalAdmin.jsp").forward(request, response);
        } else if (menu.equals("Factura")) {
            switch (accion) {
                case "Listar":
                    Objeto objeto1 = cestaDAO.listaIdUsuario(idDe);
                    List listaTajgeta1 = tipoTarjetaDao.listar();
                    request.setAttribute("tarjetas", listaTajgeta1);
                    double sumaSubtotales1 = objeto1.getSumaSubtotales();
                    request.setAttribute("subtotal", sumaSubtotales1);
                    List listaCestas1 = objeto1.getListaCesta();
                    request.setAttribute("cestas", listaCestas1);
                    List listaUsuario1 = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario1);
                    List listaProductos1 = productoDAO.listar();
                    request.setAttribute("productos", listaProductos1);
                    System.out.println("holadasfdeERSA");

                    break;
            }

            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        } else if (menu.equals("EnviarPeliculas")) {
            switch (accion) {
                case "Listar":
                    Objeto objeto1 = cestaDAO.listaIdUsuario(idDe);
                    List listaTajgeta1 = tipoTarjetaDao.listar();
                    request.setAttribute("tarjetas", listaTajgeta1);
                    double sumaSubtotales1 = objeto1.getSumaSubtotales();
                    request.setAttribute("subtotal", sumaSubtotales1);
                    List listaCestas1 = objeto1.getListaCesta();
                    request.setAttribute("cestas", listaCestas1);
                    List listaUsuario1 = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario1);
                    List listaProductos1 = productoDAO.listar();
                    request.setAttribute("productos", listaProductos1);
                    System.out.println("holadasfdeERSA");

                    request.getRequestDispatcher("Factura.jsp").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("EnviarPeliculas.jsp").forward(request, response);
        } else if (menu.equals("Index")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (menu.equals("AgregarUsuarios")) {
            request.getRequestDispatcher("AgregarUsuarios.jsp").forward(request, response);
        } else if (menu.equals("Facebook")) {
            request.getRequestDispatcher("Facebook.jsp").forward(request, response);
        } else if (menu.equals("Google")) {
            request.getRequestDispatcher("Google.jsp").forward(request, response);
        } else if (menu.equals("Principal")) {
            List<Producto> listaProducto = productoDAO.listar();
            request.setAttribute("productos", listaProducto);
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equals("Programadores")) {
            request.getRequestDispatcher("Programadores.jsp").forward(request, response);
        } else if (menu.equals("Promociones")) {
            switch (accion) {
                case "Listar":
                    List listaPromocion = promocionDao.listar();
                    request.setAttribute("promociones", listaPromocion);
                    break;
                case "ListarPromosVigentes":
                    System.out.println("Llegamos al metodo de promos vigentes");
                    List listarPromosActivas = promocionDao.listarPromocionesVigentes();
                    System.out.println("La lista de promocion ha sido usada");
                    request.setAttribute("promocionesActivas", listarPromosActivas);
                    break; 
            }
            request.getRequestDispatcher("Promociones.jsp").forward(request, response);
        } else if(menu.equals("PeliculasPromo")){
            switch (accion) {
                case "Listar":
                    break;
            }
            request.getRequestDispatcher("PeliculasPromo.jsp");
        } else if (menu.equals("Cestas")) {
            switch (accion) {
                case "listarId":
                    Objeto objeto = cestaDAO.listaIdUsuario(idDe);
                    List listaCestas = objeto.getListaCesta();
                    request.setAttribute("cestas", listaCestas);
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    List listaProductos = productoDAO.listar();
                    request.setAttribute("productos", listaProductos);
                    double sumaSubtotales = objeto.getSumaSubtotales();
                    request.setAttribute("subtotal", sumaSubtotales);
                    break;
                case "ActualizarId":
                    int cantidad;
                    idCesta = Integer.parseInt(request.getParameter("idCesta"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    int cantidadA = cantidad + 1;
                    LocalDate localDate = LocalDate.now();

                    java.sql.Date sqlDateC = java.sql.Date.valueOf(localDate);

                    int idPr;
                    idPr = Integer.parseInt(request.getParameter("idP"));
                    double precio1 = productoDAO.listarIdProducto(idPr).getPrecio();

                    detallePromocionDAO.calcularYActualizarPrecioFinal(idPr);
                    DetallePromocion dp = detallePromocionDAO.listarIdProducto(idPr);

                    int promo = dp.getIdPromocion();
                    Promocion pro = promocionDao.listarCodigoPromocion(promo);

                    int valorPro = pro.getPorcentajePromocion();
                    Date fechaInicio = pro.getFechaInicio();
                    Date fechaFinal = pro.getFechaFinal();
                    request.setAttribute("porcentaje", valorPro);

                    double subT = 0;

                    if (pro != null && pro.getFechaInicio() != null && pro.getFechaFinal() != null) {
                        if (localDate.isAfter(pro.getFechaInicio().toLocalDate()) && localDate.isBefore(pro.getFechaFinal().toLocalDate())) {
                            if (dp.getPrecioFinal() == 0.0) {
                                subT = precio1 * cantidadA;
                            } else {
                                subT = dp.getPrecioFinal() * cantidadA;
                            }
                        } else if (localDate.equals(pro.getFechaInicio().toLocalDate()) || localDate.equals(pro.getFechaFinal().toLocalDate())) {
                            if (dp.getPrecioFinal() == 0.0) {
                                subT = precio1 * cantidadA;
                            } else {
                                subT = dp.getPrecioFinal() * cantidadA;
                            }
                        } else {
                            if (dp.getPrecioFinal() != 0.0) {
                                subT = precio1 * cantidadA;
                            }

                        }
                    } else {
                        if (dp.getPrecioFinal() == 0.0) {
                            subT = precio1 * cantidadA;
                        } else {
                            subT = dp.getPrecioFinal() * cantidadA;
                        }

                    }
                    cesta.setCantidad(cantidadA);
                    cesta.setFechaProducto(sqlDateC);
                    cesta.setSubTotal(subT);
                    cesta.setIdCesta(idCesta);
                    cestaDAO.actualizarId(cesta);
                    request.getRequestDispatcher("Controlador?menu=Cestas&accion=listarId").forward(request, response);
                    break;
                case "EliminarId":
                    idCesta = Integer.parseInt(request.getParameter("idCesta"));
                    cestaDAO.eliminar(idCesta);
                    request.getRequestDispatcher("Controlador?menu=Cestas&accion=listarId").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("ProductosCesta.jsp").forward(request, response);
        } else if (menu.equals("Config")) {
            switch (accion) {
                case "DatosUsuario":
                    codUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
                    Usuario u = usuarioDAO.listarIdUsuario(codUsuario);
                    request.setAttribute("usuarioEncontrado", u);
                    System.out.println("El codigo de usuario es " + codUsuario);
                    break;
                case "ActualizarUsuario":
                    String usua = request.getParameter("txtUsuario");
                    usuario.setUsuario(usua);
                    usuario.setIdUsuario(codUsuario);
                    codigoUser = ids;
                    usuarioDAO.actualizarUsuario(usuario);
                    request.getRequestDispatcher("Controlador?menu&accion=DatosUsuario&codigoUsuario=" + codigoUser).forward(request, response);
                    break;
                case "ActualizarFoto":
                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativaProd = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestinoProd = getServletContext().getRealPath(carpetaDestinoRelativaProd);
                    System.out.println(carpetaDestinoProd);

                    Usuario productoActual = usuarioDAO.listarIdUsuario(codUsuario);
                    System.out.println(productoActual.getFotoPerfil());
                    Part archivoPartProd = request.getPart("imgPerfil");
                    String nombreArchivo1Prod = null;

                    if (archivoPartProd.getSize() > 0) {
                        // Si se proporcionó un nuevo archivo, copia y actualiza
                        nombreArchivo1Prod = getNombreArchivo(archivoPartProd);
                        InputStream inputStreamProd = archivoPartProd.getInputStream();
                        OutputStream outputStreamProd = new FileOutputStream(new File(carpetaDestinoProd, nombreArchivo1Prod));
                        int readProd;
                        byte[] bufferProd = new byte[1024];
                        while ((readProd = inputStreamProd.read(bufferProd)) != -1) {
                            outputStreamProd.write(bufferProd, 0, readProd);
                        }
                        outputStreamProd.close();
                        inputStreamProd.close();
                    } else {

                        System.out.println("HOLA");
                        System.out.println(productoActual.getFotoPerfil());
                        System.out.println("Adios");
                        nombreArchivo1Prod = productoActual.getFotoPerfil();
                    }

                    usuario.setFotoPerfil(nombreArchivo1Prod);
                    usuario.setIdUsuario(codUsuario);
                    codigoUser = ids;
                    usuarioDAO.actualizarFotoPerfil(usuario);

                    /*producto.setIdProducto(idProducto);
                    productoDAO.actualizar(producto);*/
                    request.getRequestDispatcher("Controlador?menu&accion=DatosUsuario&codigoUsuario=" + codigoUser).forward(request, response);
                    break;
                case "ActualizarPass":
                    String pass = request.getParameter("txtContra");
                    usuario.setPass(pass);
                    usuario.setIdUsuario(codUsuario);
                    codigoUser = ids;
                    usuarioDAO.actualizarContra(usuario);
                    request.getRequestDispatcher("Controlador?menu&accion=DatosUsuario&codigoUsuario=" + codigoUser).forward(request, response);
                    break;
                case "ActualizarEmail":
                    String correoUser = request.getParameter("txtEmail");
                    usuario.setEmail(correoUser);
                    usuario.setIdUsuario(codUsuario);
                    codigoUser = ids;
                    usuarioDAO.actualizarEmail(usuario);
                    request.getRequestDispatcher("Controlador?menu&accion=DatosUsuario&codigoUsuario=" + codigoUser).forward(request, response);
                    break;
                case "ActualizarNombre":
                    String nombreUser = request.getParameter("txtNombreUser");
                    usuario.setNombreUsuario(nombreUser);
                    usuario.setIdUsuario(codUsuario);
                    codigoUser = ids;
                    usuarioDAO.actualizarNombre(usuario);
                    request.getRequestDispatcher("Controlador?menu&accion=DatosUsuario&codigoUsuario=" + codigoUser).forward(request, response);
                    break;
                case "ActualizarApellido":
                    String apellidoUser = request.getParameter("txtApellidoUser");
                    usuario.setApellidoUsuario(apellidoUser);
                    usuario.setIdUsuario(codUsuario);
                    codigoUser = ids;
                    usuarioDAO.actualizarApellido(usuario);
                    request.getRequestDispatcher("Controlador?menu&accion=DatosUsuario&codigoUsuario=" + codigoUser).forward(request, response);
                    break;
                case "EliminarUsuario":
                    System.out.println("Llegamos al metodo eliminar");
                    usuarioDAO.eliminarUsuario(codUsuario);
                    request.getRequestDispatcher("Controlador?menu=Index").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Config.jsp").forward(request, response);
        } else if (menu.equals("MetodoPago")) {
            switch (accion) {
                case "Agregar":
                    Double cantidadPagar = Double.parseDouble(request.getParameter("txtSubtotal"));
                    int idTipoTarjeta = Integer.parseInt(request.getParameter("cmbIdTarjeta"));
                    Date fechaPago = Date.valueOf(request.getParameter("txtDate"));
                    int idUsuarios = Integer.parseInt(request.getParameter("cmbIdUsuario"));

                    String email = request.getParameter("txtEmail");

                    pago.setCantidadAPagar(cantidadPagar);
                    pago.setIdTipoTarjeta(idTipoTarjeta);
                    pago.setFechaPago(fechaPago);
                    pago.setIdUsuario(idUsuarios);
                    pagoDao.agregar(pago);
                    System.out.println(cantidadPagar);
                    System.out.println("hola");

                    Objeto objeto1 = cestaDAO.listaIdUsuario(idDe);
                    List listaTajgeta1 = tipoTarjetaDao.listar();
                    request.setAttribute("tarjetas", listaTajgeta1);
                    double sumaSubtotales1 = objeto1.getSumaSubtotales();
                    request.setAttribute("subtotal", sumaSubtotales1);
                    List listaCestas1 = objeto1.getListaCesta();
                    request.setAttribute("cestas", listaCestas1);
                    List listaUsuario1 = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario1);
                    List listaProductos1 = productoDAO.listar();
                    request.setAttribute("productos", listaProductos1);

                    request.getRequestDispatcher("EnviarPeliculas.jsp").forward(request, response);
                    break;
                case "Listar":
                    Objeto objeto = cestaDAO.listaIdUsuario(idDe);
                    List listaTajgeta = tipoTarjetaDao.listar();
                    request.setAttribute("tarjetas", listaTajgeta);
                    double sumaSubtotales = objeto.getSumaSubtotales();
                    request.setAttribute("subtotal", sumaSubtotales);
                    List listaCestas = objeto.getListaCesta();
                    request.setAttribute("cestas", listaCestas);
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    List listaProductos = productoDAO.listar();
                    request.setAttribute("productos", listaProductos);
                    break;
            }

            request.getRequestDispatcher("MetodoPago.jsp").forward(request, response);
        } else if (menu.equals("Promociones")) {
            switch (accion) {
                case "Listar":
                    List listaPromocion = promocionDao.listar();
                    request.setAttribute("promociones", listaPromocion);

                    break;
            }
        } else if (menu.equals("Peliculas")) {
            switch (accion) {
                case "Listar":
                    List<Producto> listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    List listaDeProveedores = proveedoresDAO.listar();
                    request.setAttribute("proveedores", listaDeProveedores);
                    break;
                case "Editar":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    Producto p = productoDAO.listarIdProducto(idProducto);
                    request.setAttribute("productoEncontrado", p);
                    break;

            }
            request.getRequestDispatcher("Peliculas.jsp").forward(request, response);
        } else if (menu.equals("Historial")) {
            switch (accion) {
                case "Listar":
                    List<Producto> listaProducto = historialDao.listar(idDe);
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Editar":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    Producto p = productoDAO.listarIdProducto(idProducto);
                    request.setAttribute("productoEncontrado", p);
                    break;
                case "Eliminar":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    historialDao.eliminar(idDe, idProducto);
                    request.getRequestDispatcher("Controlador?menu=Historial&accion=Listar").forward(request, response);
                    System.out.println("Historial incorrecto");
                    break;

            }
            request.getRequestDispatcher("Historial.jsp").forward(request, response);
        } else if (menu.equals("InformacionPelicula")) {
            switch (accion) {
                case "Editar":
                    List listaResena = resenaDAO.listar();
                    request.setAttribute("resenas", listaResena);
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    Producto p = productoDAO.listarIdProducto(idProducto);
                    request.setAttribute("productoEncontrado", p);
                    Resena r = resenaDAO.listarIdProductoResena(idProducto);
                    request.setAttribute("resenaEncontrada", r);
                    System.out.println("Usuario " + idDe);
                    System.out.println("Película " + idProducto);

                    HistorialDAO historialDao = new HistorialDAO();
                    historialDao.agregar(idDe, idProducto);

                    System.out.println("FUNCIONAAAA");
                    break;
                case "AgregarCesta":
                    int cantidadP;
                    cantidadP = 1;

                    LocalDate localDate = LocalDate.now();

                    java.sql.Date sqlDateC = java.sql.Date.valueOf(localDate);

                    int idC;
                    idC = idDe;
                    int idP;
                    idP = Integer.parseInt(request.getParameter("id"));
                    double precio = productoDAO.listarIdProducto(idP).getPrecio();
                    detallePromocionDAO.calcularYActualizarPrecioFinal(idP);
                    DetallePromocion dp = detallePromocionDAO.listarIdProducto(idP);
                    int promo = dp.getIdPromocion();
                    Promocion pro = promocionDao.listarCodigoPromocion(promo);

                    int valorPro = pro.getPorcentajePromocion();
                    Date fechaInicio = pro.getFechaInicio();
                    Date fechaFinal = pro.getFechaFinal();
                    request.setAttribute("porcentaje", valorPro);

                    double subT = 0;

                    if (pro != null && pro.getFechaInicio() != null && pro.getFechaFinal() != null) {
                        if (localDate.isAfter(pro.getFechaInicio().toLocalDate()) && localDate.isBefore(pro.getFechaFinal().toLocalDate())) {
                            if (dp.getPrecioFinal() == 0.0) {
                                subT = precio * cantidadP;
                            } else {
                                subT = dp.getPrecioFinal() * cantidadP;
                            }
                        } else if (localDate.equals(pro.getFechaInicio().toLocalDate()) || localDate.equals(pro.getFechaFinal().toLocalDate())) {
                            if (dp.getPrecioFinal() == 0.0) {
                                subT = precio * cantidadP;
                            } else {
                                subT = dp.getPrecioFinal() * cantidadP;
                            }
                        } else {
                            if (dp.getPrecioFinal() != 0.0) {
                                subT = precio * cantidadP;
                            }

                        }
                    } else {
                        if (dp.getPrecioFinal() == 0.0) {
                            subT = precio * cantidadP;
                        } else {
                            subT = dp.getPrecioFinal() * cantidadP;
                        }

                    }
                    cesta.setCantidad(cantidadP);
                    cesta.setFechaProducto(sqlDateC);
                    cesta.setSubTotal(subT);
                    cesta.setIdUsuario(idC);
                    cesta.setIdProducto(idP);
                    cestaDAO.Agregar(cesta);
                    request.getRequestDispatcher("Controlador?menu=InformacionPelicula&accion=Editar&idProducto=" + idP).forward(request, response);
                    break;
                case "Enviar":
                    idP = Integer.parseInt(request.getParameter("id"));
                    LocalDate localDate2 = LocalDate.now();
                    java.sql.Date fechaLocal = java.sql.Date.valueOf(localDate2);

                    Integer cali = Integer.parseInt(request.getParameter("txtCali"));
                    String resenaRe = request.getParameter("txtRes");
                    int idProduc;
                    idProduc = Integer.parseInt(request.getParameter("txtidProduc"));
                    int idUsua;
                    idUsua = Integer.parseInt(request.getParameter("txtidUsua"));

                    resena.setFechaValoracion(fechaLocal);
                    resena.setCalificacion(cali);
                    resena.setResena(resenaRe);
                    resena.setIdUsuario(idUsua);
                    resena.setIdProducto(idProduc);
                    resenaDAO.agregar(resena);
                    request.getRequestDispatcher("Controlador?menu=InformacionPelicula&accion=Editar&idProducto=" + idP).forward(request, response);
                    break;
            }
            request.getRequestDispatcher("InformacionPelicula.jsp").forward(request, response);
        } else if (menu.equals("CuentaGoogle")) {
            request.getRequestDispatcher("GoogleNuevaCuenta.jsp").forward(request, response);
        } else if (menu.equals("CuentaFacebook")) {
            request.getRequestDispatcher("FacebookNuevaCuenta.jsp").forward(request, response);
        } else if (menu.equals("Usuario")) {
            switch (accion) {
                case "Listar":
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    break;
                case "Agregar":
                    String nombreUsuario = request.getParameter("txtNombres");
                    String apellidoUsuario = request.getParameter("txtApellidos");
                    String usua = request.getParameter("txtUsuario");
                    String pass = request.getParameter("txtPass");
                    String email = request.getParameter("txtEmail");

                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativa = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestino = getServletContext().getRealPath(carpetaDestinoRelativa);
                    System.out.println(carpetaDestino);

                    Part archivoPart = request.getPart("imgFotoPerfil");
                    String nombreArchivo1;

                    if (archivoPart.getSize() > 0) {
                        // Si se proporcionó un nuevo archivo, copia y actualiza
                        nombreArchivo1 = getNombreArchivo(archivoPart);
                        InputStream inputStream = archivoPart.getInputStream();
                        OutputStream outputStream = new FileOutputStream(new File(carpetaDestino, nombreArchivo1));
                        int read;
                        byte[] buffer = new byte[1024];
                        while ((read = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, read);
                        }
                        outputStream.close();
                        inputStream.close();
                    } else {
                        // Si no se selecciona una imagen nueva, asigna la imagen por defecto
                        nombreArchivo1 = "UsuarioPorDefecto.png";
                    }

                    usuario.setNombreUsuario(nombreUsuario);
                    usuario.setApellidoUsuario(apellidoUsuario);
                    usuario.setUsuario(usua);
                    usuario.setPass(pass);
                    usuario.setEmail(email);
                    usuario.setFotoPerfil(nombreArchivo1);
                    usuarioDAO.Agregar(usuario);
                    emailUsuario = "https://formsubmit.co/" + email;
                    request.setAttribute("emailUsuario", emailUsuario);
                    request.setAttribute("nombreUsuario", nombreUsuario);

                    System.out.println(emailUsuario);
                    request.getRequestDispatcher("Correo.jsp").forward(request, response);

                    break;
                case "Eliminar":
                    break;
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (menu.equals("UsuarioGoogle")) {
            switch (accion) {
                case "Agregar":
                    String nombreUsuario = request.getParameter("txtNombres");
                    String apellidoUsuario = request.getParameter("txtApellidos");
                    String usua = request.getParameter("txtUsuario");
                    String pass = request.getParameter("txtPass");
                    String email = request.getParameter("txtEmail");

                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativa = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestino = getServletContext().getRealPath(carpetaDestinoRelativa);
                    System.out.println(carpetaDestino);

                    Part archivoPart = request.getPart("imgFotoPerfil");
                    String nombreArchivo1;

                    if (archivoPart.getSize() > 0) {
                        // Si se proporcionó un nuevo archivo, copia y actualiza
                        nombreArchivo1 = getNombreArchivo(archivoPart);
                        InputStream inputStream = archivoPart.getInputStream();
                        OutputStream outputStream = new FileOutputStream(new File(carpetaDestino, nombreArchivo1));
                        int read;
                        byte[] buffer = new byte[1024];
                        while ((read = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, read);
                        }
                        outputStream.close();
                        inputStream.close();
                    } else {
                        // Si no se selecciona una imagen nueva, asigna la imagen por defecto
                        nombreArchivo1 = "UsuarioPorDefecto.png";
                    }

                    usuario.setNombreUsuario(nombreUsuario);
                    usuario.setApellidoUsuario(apellidoUsuario);
                    usuario.setUsuario(usua);
                    usuario.setPass(pass);
                    usuario.setEmail(email);
                    usuario.setFotoPerfil(nombreArchivo1);
                    usuarioDAO.Agregar(usuario);
                    emailUsuario = "https://formsubmit.co/" + email;
                    request.setAttribute("emailUsuario", emailUsuario);
                    request.setAttribute("nombreUsuario", nombreUsuario);

                    System.out.println(emailUsuario);
                    request.getRequestDispatcher("Correo.jsp").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Google.jsp").forward(request, response);

        } else if (menu.equals("Categoria")){
            switch(accion) {
                case "Listar":
                    List listaCategorias = categoriaDao.listar();
                    request.setAttribute("categorias", listaCategorias);
                    break;
                case "Agregar":
                    String nombreCategoria = request.getParameter("txtCategoria");
                    categoria.setNombreCategoria(nombreCategoria);
                    categoriaDao.agregar(categoria);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
                    Categoria cat = categoriaDao.listarCategoriaId(idCategoria);
                    request.setAttribute("categoriaEncontrada", cat);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreCateg = request.getParameter("txtCategoria");
                    categoria.setNombreCategoria(nombreCateg);
                    categoria.setIdCategoria(idCategoria);
                    categoriaDao.Actualizar(categoria);
                    request.getRequestDispatcher("controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "PeliculasPromo":
                    
                    break;
                case "Eliminar":
                    idCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
                    usoCategoria = categoriaDao.categoriaEnUso(idCategoria);
                    System.out.println("El número de veces que se repite categoria es "+ usoCategoria);
                    if(usoCategoria > 0){
                        System.out.println("La categoria no puede ser eliminada");
                        request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                        request.setAttribute("mostrarDiv", true);
                    }else{
                        idCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
                        categoriaDao.Eliminar(idCategoria);
                        request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                        break;
                    }
            }
            request.getRequestDispatcher("CategoriaPeliculas.jsp").forward(request, response);
        }else if (menu.equals("UsuarioFacebook")) {
            switch (accion) {
                case "Agregar":
                    String nombreUsuario = request.getParameter("txtNombres");
                    String apellidoUsuario = request.getParameter("txtApellidos");
                    String usua = request.getParameter("txtUsuario");
                    String pass = request.getParameter("txtPass");
                    String email = request.getParameter("txtEmail");

                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativa = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestino = getServletContext().getRealPath(carpetaDestinoRelativa);
                    System.out.println(carpetaDestino);

                    Part archivoPart = request.getPart("imgFotoPerfil");
                    String nombreArchivo1;

                    if (archivoPart.getSize() > 0) {
                        // Si se proporcionó un nuevo archivo, copia y actualiza
                        nombreArchivo1 = getNombreArchivo(archivoPart);
                        InputStream inputStream = archivoPart.getInputStream();
                        OutputStream outputStream = new FileOutputStream(new File(carpetaDestino, nombreArchivo1));
                        int read;
                        byte[] buffer = new byte[1024];
                        while ((read = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, read);
                        }
                        outputStream.close();
                        inputStream.close();
                    } else {
                        // Si no se selecciona una imagen nueva, asigna la imagen por defecto
                        nombreArchivo1 = "UsuarioPorDefecto.png";
                    }

                    usuario.setNombreUsuario(nombreUsuario);
                    usuario.setApellidoUsuario(apellidoUsuario);
                    usuario.setUsuario(usua);
                    usuario.setPass(pass);
                    usuario.setEmail(email);
                    usuario.setFotoPerfil(nombreArchivo1);
                    usuarioDAO.Agregar(usuario);
                    emailUsuario = "https://formsubmit.co/" + email;
                    request.setAttribute("emailUsuario", emailUsuario);
                    request.setAttribute("nombreUsuario", nombreUsuario);

                    System.out.println(emailUsuario);
                    request.getRequestDispatcher("Correo.jsp").forward(request, response);

                    break;

            }
            request.getRequestDispatcher("Facebook.jsp").forward(request, response);

        } else if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List<Producto> listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    List listaDeProveedores = proveedoresDAO.listar();
                    request.setAttribute("proveedores", listaDeProveedores);
                    List listaCategorias = categoriaDao.listar();
                    request.setAttribute("categorias", listaCategorias);
                    /*List listaProveedor=productoDAO.listarProveedores();
                    request.setAttribute("proveedores", listaProveedor);*/
                    break;
                case "Agregar":
                    //System.out.println("Hola James");                    
                    String nombreProducto = request.getParameter("txtNombreProducto");
                    String genero = request.getParameter("txtGenero");
                    int codigoCategoria;
                    codigoCategoria = Integer.parseInt(request.getParameter("cmbIdCategoria"));
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    String duracion = request.getParameter("txtDuracion");
                    String sinopsis = request.getParameter("txtSinopsis");

                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativa = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestino = getServletContext().getRealPath(carpetaDestinoRelativa);
                    System.out.println(carpetaDestino);
                    // Obtener la parte del archivo (la imagen) del formulario
                    Part archivoPart = request.getPart("imgPortada");

                    // Obtener el nombre original del archivo
                    String nombreArchivo1 = getNombreArchivo(archivoPart);

                    // Copiar el archivo a la carpeta de destino
                    InputStream inputStream = archivoPart.getInputStream();
                    OutputStream outputStream = new FileOutputStream(new File(carpetaDestino, nombreArchivo1));
                    System.out.println(outputStream);
                    int read;
                    byte[] buffer = new byte[1024];
                    while ((read = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, read);
                    }

                    outputStream.close();
                    inputStream.close();

                    String trailer = request.getParameter("txtTrailer");

                    int idProveedor;
                    idProveedor = Integer.parseInt(request.getParameter("cmbIdProveedor"));

                    producto.setNombreProducto(nombreProducto);
                    producto.setGenero(genero);
                    producto.setIdCategoria(codigoCategoria);
                    producto.setPrecio(precio);
                    producto.setDuracion(duracion);
                    producto.setSinopsis(sinopsis);
                    producto.setPortada(nombreArchivo1);
                    producto.setTrailer(trailer);
                    producto.setIdProveedor(idProveedor);
                    productoDAO.agregar(producto);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    Producto p = productoDAO.listarIdProducto(idProducto);
                    request.setAttribute("productoEncontrado", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreProd = request.getParameter("txtNombreProducto");
                    String generoProd = request.getParameter("txtGenero");
                    int IdCategoriaProd = Integer.parseInt(request.getParameter("cmbIdCategoria"));
                    Double precioProd = Double.parseDouble(request.getParameter("txtPrecio"));
                    String duracionProd = request.getParameter("txtDuracion");
                    String sinopsisProd = request.getParameter("txtSinopsis");
                    String trailerProd = request.getParameter("txtTrailer");
                    int idProveedorProd = Integer.parseInt(request.getParameter("cmbIdProveedor"));

                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativaProd = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestinoProd = getServletContext().getRealPath(carpetaDestinoRelativaProd);
                    System.out.println(carpetaDestinoProd);

                    Producto productoActual = productoDAO.listarIdProducto(idProducto);
                    System.out.println(productoActual.getPortada());
                    Part archivoPartProd = request.getPart("imgPortada");
                    String nombreArchivo1Prod = null;

                    if (archivoPartProd.getSize() > 0) {
                        // Si se proporcionó un nuevo archivo, copia y actualiza
                        nombreArchivo1Prod = getNombreArchivo(archivoPartProd);
                        InputStream inputStreamProd = archivoPartProd.getInputStream();
                        OutputStream outputStreamProd = new FileOutputStream(new File(carpetaDestinoProd, nombreArchivo1Prod));
                        int readProd;
                        byte[] bufferProd = new byte[1024];
                        while ((readProd = inputStreamProd.read(bufferProd)) != -1) {
                            outputStreamProd.write(bufferProd, 0, readProd);
                        }
                        outputStreamProd.close();
                        inputStreamProd.close();
                    } else {

                        System.out.println("HOLA");
                        System.out.println(productoActual.getPortada());
                        System.out.println("Adios");
                        nombreArchivo1Prod = productoActual.getPortada();
                    }

                    producto.setNombreProducto(nombreProd);
                    producto.setGenero(generoProd);
                    producto.setIdCategoria(IdCategoriaProd);
                    producto.setPrecio(precioProd);
                    producto.setDuracion(duracionProd);
                    producto.setSinopsis(sinopsisProd);
                    producto.setPortada(nombreArchivo1Prod);
                    producto.setTrailer(trailerProd);
                    producto.setIdProveedor(idProveedorProd);
                    producto.setIdProducto(idProducto);
                    productoDAO.actualizar(producto);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    productoDAO.eliminar(idProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);

        } else if (menu.equals("DetallePago")) {
            switch (accion) {
                case "Listar":
                    List listaPago = pagoDao.listar();
                    request.setAttribute("pagos", listaPago);
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    List litaDetallePagos = detallePagoDao.listar();
                    request.setAttribute("detallePagos", litaDetallePagos);
                    List listaCesta = cestaDAO.listar();
                    request.setAttribute("cestas", listaCesta);
                    break;
                case "Agregar":
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));

                    int idPago = Integer.parseInt(request.getParameter("cmbIdPago"));
                    int idCesta = Integer.parseInt(request.getParameter("cmbIdCesta"));
                    detallePago.setCantidad(cantidad);

                    detallePago.setIdPago(idPago);
                    detallePago.setIdCesta(idCesta);
                    detallePagoDao.agregar(detallePago);
                    request.getRequestDispatcher("Controlador?menu=DetallePago&accion=Listar").forward(request, response);
                    break;

            }

            request.getRequestDispatcher("DetallePago.jsp").forward(request, response);

        } else if (menu.equals("Pago")) {
            switch (accion) {
                case "Listar":
                    List listaPagos = pagoDao.listar();
                    request.setAttribute("pagos", listaPagos);
                    List listaTipoTarjetas = tipoTarjetaDao.listar();
                    request.setAttribute("tipoTarjetas", listaTipoTarjetas);
                    break;
                case "Agregar":
                    double cantidadAPag = Double.parseDouble(request.getParameter("txtCantidadAPagar"));
                    int idTipoTarj = Integer.parseInt(request.getParameter("slTipoTarjeta"));
                    Date fechaPag = Date.valueOf(request.getParameter("clnFechaPago"));
                    //int idUsu = Integer.parseInt(request.getParameter("txtIdUsuario"));
                    pago.setCantidadAPagar(cantidadAPag);
                    pago.setIdTipoTarjeta(idTipoTarj);
                    pago.setFechaPago(fechaPag);
                    pago.setIdUsuario(idDe);
                    pagoDao.agregar(pago);
                    request.getRequestDispatcher("Controlador?menu=Pago&accion=Listar").forward(request, response);
                    break;
                /*
                case "Editar":
                    codPago = Integer.parseInt(request.getParameter("codigoPago"));
                    Pago pag = pagoDao.listarCodigoPago(codPago);
                    request.setAttribute("pagoEncontrado", pag);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    double cantidadAPa = Double.parseDouble(request.getParameter("txtCantidadAPagar"));
                    int idTipoTar = Integer.parseInt(request.getParameter("slTipoTarjeta"));
                    Date fechaPa = Date.valueOf(request.getParameter("clnFechaPago"));
                    int idUs = Integer.parseInt(request.getParameter("txtIdUsuario"));
                    request.getRequestDispatcher("Controlador?menu=Pago&accion=Listar").forward(request, response);
                    pago.setCantidadAPagar(cantidadAPa);
                    pago.setIdTipoTarjeta(idTipoTar);
                    pago.setFechaPago(fechaPa);
                    pago.setIdUsuario(idUs);
                    pagoDao
                    break;
                case "Eliminar":
                  
                    break;
                 */
            }
            request.getRequestDispatcher("Pago.jsp").forward(request, response);

        } else if (menu.equals("TipoTarjeta")) {
            switch (accion) {
                case "Listar":
                    List listaTipoTarjetas = tipoTarjetaDao.listar();
                    request.setAttribute("tipoTarjetas", listaTipoTarjetas);
                    break;
                case "Agregar":
                    String tipoTarje = request.getParameter("txtTipoTarjeta");
                    tipoTarjeta.setTipoTarjeta(tipoTarje);
                    tipoTarjetaDao.agregar(tipoTarjeta);
                    request.getRequestDispatcher("Controlador?menu=TipoTarjeta&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codTipoTarjeta = Integer.parseInt(request.getParameter("idTipoTarjeta"));
                    TipoTarjeta tT = tipoTarjetaDao.listaTipoTarjeta(codTipoTarjeta);
                    request.setAttribute("tipoTarjetaEncontrado", tT);
                    request.getRequestDispatcher("Controlador?menu=TipoTarjeta&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    //codTipoTarjeta = Integer.parseInt(request.getParameter("idTipoTarjeta"));
                    String tipoTarj = request.getParameter("txtTipoTarjeta");
                    tipoTarjeta.setTipoTarjeta(tipoTarj);
                    tipoTarjeta.setIdTipoTarjeta(codTipoTarjeta);
                    tipoTarjetaDao.actualizar(tipoTarjeta);
                    request.getRequestDispatcher("Controlador?menu=TipoTarjeta&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTipoTarjeta = Integer.parseInt(request.getParameter("idTipoTarjeta"));
                    tipoTarjetaDao.eliminar(codTipoTarjeta);
                    request.getRequestDispatcher("Controlador?menu=TipoTarjeta&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoTarjeta.jsp").forward(request, response);

        } else if (menu.equals("ServicioCliente")) {
            switch (accion) {
                case "Listar":
                    List listarServicioCliente = servicioClienteDAO.listar();
                    request.setAttribute("servicioClientes", listarServicioCliente);
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    break;
                case "Agregar":
                    String descripcion = request.getParameter("txtDescripcion");
                    int idUsuario;
                    idUsuario = Integer.parseInt(request.getParameter("cmbIdUsuario"));
                    int idProducto;
                    idProducto = Integer.parseInt(request.getParameter("cmbProducto"));

                    servicioCliente.setDescripcion(descripcion);
                    servicioCliente.setIdUsuario(idUsuario);
                    servicioCliente.setIdProducto(idProducto);
                    servicioClienteDAO.agregar(servicioCliente);

                    request.getRequestDispatcher("Controlador?menu=ServicioCliente&accion=Listar").forward(request, response);
                    break;
//              case "Editar":
//                  idServicio = Integer.parseInt(request.getParameter("idServicio"));
//                  ServicioCliente scl = servicioClienteDAO.listarServicioCliente(idServicio);
//                  request.setAttribute("servicioEncontrado", scl);
//                  request.getRequestDispatcher("Controlador?menu=ServicioCliente&accion=Listar").forward(request, response);
//                  break;
                /*case "Actualizar":
                  String descrip= request.getParameter("txtDescripcion");
                  int idUsua;
                  idUsua = Integer.parseInt(request.getParameter("cmbIdUsuario"));
                  int idProdu;
                  idProdu = Integer.parseInt(request.getParameter("cmbProducto"));
                  
                  servicioCliente.setDescripcion(descrip);
                  servicioCliente.setIdUsuario(idUsua);
                  servicioCliente.setIdProducto(idProdu);
                  servicioClienteDAO.actualizar(servicioCliente);
                  request.getRequestDispatcher("Controlador?menu=ServicioCliente&accion=Listar").forward(request, response);
                  
                  break;
              case "Eliminar":
                  idServicio = Integer.parseInt(request.getParameter("idServicio"));
                  servicioClienteDAO.eliminar(idServicio);
                  request.getRequestDispatcher("Controlador?menu=ServicioCliente&accion=Listar").forward(request, response);
                  
                  break;*/
            }
            request.getRequestDispatcher("TablaServicioCliente.jsp").forward(request, response);

        } else if (menu.equals("Proveedores")) {
            switch (accion) {
                case "Listar":
                    List listaDeProveedores = proveedoresDAO.listar();
                    request.setAttribute("proveedores", listaDeProveedores);
                    break;
                case "Agregar":
                    String email = request.getParameter("txtEmail");
                    if (verificar(email)) {
                        String nombres = request.getParameter("txtNombres");
                        String telefono = request.getParameter("txtTelefono");
                        proveedores.setNombreProveedor(nombres);
                        proveedores.setTelefonoProveedor(telefono);
                        proveedores.setEmail(email);
                        System.out.println(proveedores.getNombreProveedor());
                        System.out.println(proveedores.getTelefonoProveedor());
                        System.out.println(proveedores.getEmail());
                        proveedoresDAO.agregar(proveedores);
                        request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("errorEmail", "Por favor, ingresa un correo valido");
                        request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                        return;
                    }
                    break;
                case "Editar":
                    codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                    Proveedores p = proveedoresDAO.listarCodigoProveedor(codProveedor);
                    request.setAttribute("proveedorEncontrado", p);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String emailProv = request.getParameter("txtEmail");
                    if (verificar(emailProv)) {
                        String nombreProv = request.getParameter("txtNombres");
                        String telefonoProv = request.getParameter("txtTelefono");
                        proveedores.setNombreProveedor(nombreProv);
                        proveedores.setTelefonoProveedor(telefonoProv);
                        proveedores.setEmail(emailProv);
                        proveedores.setIdProveedor(codProveedor);
                        proveedoresDAO.actualizar(proveedores);
                        request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("errorEmail", "Por favor, ingresa un correo valido");
                        request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                        return;
                    }
                    break;
                case "Eliminar":
                    codProveedor = Integer.parseInt(request.getParameter("codigoDeProveedor"));
                    proveedoresDAO.eliminar(codProveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Limpiar":
                    limpiarCampos(request);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
        } else if (menu.equals("Cesta")) {
            switch (accion) {
                case "Listar":
                    List listaCesta = cestaDAO.listar();
                    request.setAttribute("cestas", listaCesta);
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    break;
                case "Agregar":
                    int cantidadP;
                    cantidadP = Integer.parseInt(request.getParameter("txtCantidad"));
                    String fechaC;
                    fechaC = request.getParameter("txtFecha");
                    java.sql.Date sqlDateC = java.sql.Date.valueOf(fechaC);
                    double subT;
                    subT = Double.parseDouble(request.getParameter("txtSubTotal"));
                    int idC;
                    idC = Integer.parseInt(request.getParameter("cmbIdUsuario"));

                    cesta.setCantidad(cantidadP);
                    cesta.setFechaProducto(sqlDateC);
                    cesta.setSubTotal(subT);
                    cesta.setIdUsuario(idC);
                    cestaDAO.Agregar(cesta);
                    request.getRequestDispatcher("Controlador?menu=Cesta&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idCesta = Integer.parseInt(request.getParameter("idCesta"));
                    Cesta c = cestaDAO.listarIdCesta(idCesta);
                    request.setAttribute("cestaEncontrada", c);
                    request.getRequestDispatcher("Controlador?menu=Cesta&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int cantidad;
                    cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    String fecha;
                    fecha = request.getParameter("txtFecha");
                    java.sql.Date sqlDate = java.sql.Date.valueOf(fecha);
                    double sub;
                    sub = Double.parseDouble(request.getParameter("txtSubTotal"));
                    int id;
                    id = Integer.parseInt(request.getParameter("cmbIdUsuario"));

                    cesta.setCantidad(cantidad);
                    cesta.setFechaProducto(sqlDate);
                    cesta.setSubTotal(sub);
                    cesta.setIdUsuario(id);
                    cesta.setIdCesta(idCesta);
                    cestaDAO.actualizar(cesta);
                    request.getRequestDispatcher("Controlador?menu=Cesta&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idCesta = Integer.parseInt(request.getParameter("idCesta"));
                    cestaDAO.eliminar(idCesta);
                    request.getRequestDispatcher("Controlador?menu=Cesta&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Cesta.jsp").forward(request, response);
        } else if (menu.equals("Resena")) {
            switch (accion) {
                case "Listar":
                    List listaResena = resenaDAO.listar();
                    request.setAttribute("resenas", listaResena);
                    List listaUsuario = usuarioDAO.listar();
                    request.setAttribute("usuarios", listaUsuario);
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Agregar":
                    Date fecha = (java.sql.Date.valueOf(request.getParameter("txtFecha")));
                    Integer calificacion = Integer.parseInt(request.getParameter("txtCalificacion"));
                    String resenaR = request.getParameter("txtResena");
                    int idUsuario;
                    idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
                    int idProducto;
                    idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));

                    resena.setFechaValoracion(new java.sql.Date(fecha.getTime()));
                    resena.setCalificacion(calificacion);
                    resena.setResena(resenaR);
                    resena.setIdUsuario(idUsuario);
                    resena.setIdProducto(idProducto);
                    resenaDAO.agregar(resena);
                    request.getRequestDispatcher("Controlador?menu=Resena&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idResena = Integer.parseInt(request.getParameter("idResena"));
                    Resena r = resenaDAO.listarIdResena(idResena);
                    request.setAttribute("resenaEncontrada", r);
                    request.getRequestDispatcher("Controlador?menu=Resena&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Date fechaRes = (java.sql.Date.valueOf(request.getParameter("txtFecha")));
                    Integer calificacionRes = Integer.parseInt(request.getParameter("txtCalificacion"));
                    String resenaRes = request.getParameter("txtResena");
                    resena.setFechaValoracion(new java.sql.Date(fechaRes.getTime()));
                    resena.setCalificacion(calificacionRes);
                    resena.setResena(resenaRes);
                    resena.setIdResena(idResena);
                    resenaDAO.actualizar(resena);
                    request.getRequestDispatcher("Controlador?menu=Resena&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idResena;
                    idResena = Integer.parseInt(request.getParameter("idResena"));
                    resenaDAO.eliminar(idResena);
                    request.getRequestDispatcher("Controlador?menu=Resena&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Resena.jsp").forward(request, response);
        } else if (menu.equals("DetallePromocion")) {
            switch (accion) {
                case "Listar":
                    List listaDetallePromocioh = detallePromocionDAO.listar();
                    request.setAttribute("detallePromociones", listaDetallePromocioh);
                    List listaPromocion = promocionDao.listar();
                    request.setAttribute("promociones", listaPromocion);
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Agregar":
                    Double precioFinal = Double.parseDouble(request.getParameter("txtPrecioFinal"));
                    int idPromocion;
                    idPromocion = Integer.parseInt(request.getParameter("txtIdPromocion"));
                    int idProducto;
                    idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));

                    detallePromocion.setPrecioFinal(precioFinal);
                    detallePromocion.setIdPromocion(idPromocion);
                    detallePromocion.setIdProducto(idProducto);
                    detallePromocionDAO.agregar(detallePromocion);
                    request.getRequestDispatcher("Controlador?menu=DetallePromocion&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idDetallePromocion = Integer.parseInt(request.getParameter("idDetallePromocion"));
                    DetallePromocion dp = detallePromocionDAO.listarIdDetallePromocion(idDetallePromocion);
                    request.setAttribute("detallePromocionEncontrado", dp);
                    request.getRequestDispatcher("Controlador?menu=DetallePromocion&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Double precioFinalDP = Double.parseDouble(request.getParameter("txtPrecioFinal"));
                    detallePromocion.setPrecioFinal(precioFinalDP);
                    detallePromocion.setIdDetallePromocion(idDetallePromocion);

                    break;
                case "Eliminar":
                    break;
            }
            request.getRequestDispatcher("DetallePromocion.jsp").forward(request, response);
        } else if (menu.equals("Promocion")) {
            switch (accion) {
                case "Listar":
                    List listaPromocion = promocionDao.listar();
                    request.setAttribute("promociones", listaPromocion);
                    List listaCategoria = categoriaDao.listar();
                    request.setAttribute("categorias", listaCategoria);
                    break;               
                case "Agregar":
                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativa = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestino = getServletContext().getRealPath(carpetaDestinoRelativa);
                    System.out.println(carpetaDestino);
                    // Obtener la parte del archivo (la imagen) del formulario
                    Part archivoPart = request.getPart("imgCartel");

                    // Obtener el nombre original del archivo
                    String nombreArchivo1 = getNombreArchivo(archivoPart);

                    // Copiar el archivo a la carpeta de destino
                    InputStream inputStream = archivoPart.getInputStream();
                    OutputStream outputStream = new FileOutputStream(new File(carpetaDestino, nombreArchivo1));
                    System.out.println(outputStream);
                    int read;
                    byte[] buffer = new byte[1024];
                    while ((read = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, read);
                    }

                    outputStream.close();
                    inputStream.close();
                    //Fin del metodo para guardar imagen
                    
                    int idCategoria;
                    idCategoria = Integer.parseInt(request.getParameter("cmbIdCategoria"));
                    int porcentajeDescuento = Integer.valueOf(request.getParameter("txtDescuento"));
                    Date fechaInicio = java.sql.Date.valueOf(request.getParameter("dateInicio"));
                    Date fechaFinal = java.sql.Date.valueOf(request.getParameter("dateFinal"));
                    promocion.setCartelPromocion(nombreArchivo1);
                    promocion.setIdCategoria(idCategoria);
                    promocion.setPorcentajePromocion(porcentajeDescuento);
                    promocion.setFechaInicio(fechaInicio);
                    promocion.setFechaFinal(fechaFinal);
                    promocionDao.agregar(promocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idPromo = Integer.parseInt(request.getParameter("idPromocion"));
                    Promocion p = promocionDao.listarCodigoPromocion(idPromo);
                    request.setAttribute("promocionEncontrada", p);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    // Inicia el método actualizar promocion
                    // Obtener la carpeta de destino en el servidor donde se copiará la imagen
                    String carpetaDestinoRelativaProd = "/img/imgPeliculas//"; // Ruta relativa dentro de tu proyecto web
                    String carpetaDestinoProd = getServletContext().getRealPath(carpetaDestinoRelativaProd);
                    System.out.println(carpetaDestinoProd);

                    Promocion promoActual = promocionDao.listarCodigoPromocion(idPromo);
                    System.out.println(promoActual.getCartelPromocion());
                    Part archivoPartProd = request.getPart("imgCartel");
                    String nombreArchivo1Prod = null;

                    if (archivoPartProd.getSize() > 0) {
                        // Si se proporcionó un nuevo archivo, copia y actualiza
                        nombreArchivo1Prod = getNombreArchivo(archivoPartProd);
                        InputStream inputStreamProd = archivoPartProd.getInputStream();
                        OutputStream outputStreamProd = new FileOutputStream(new File(carpetaDestinoProd, nombreArchivo1Prod));
                        int readProd;
                        byte[] bufferProd = new byte[1024];
                        while ((readProd = inputStreamProd.read(bufferProd)) != -1) {
                            outputStreamProd.write(bufferProd, 0, readProd);
                        }
                        outputStreamProd.close();
                        inputStreamProd.close();
                    } else {

                        System.out.println("HOLA");
                        System.out.println(promoActual.getCartelPromocion());
                        System.out.println("Adios");
                        nombreArchivo1Prod = promoActual.getCartelPromocion();
                    }
                    // Termina el método actualizar la promoción
                    
                    int idCategoriaPromo = Integer.parseInt(request.getParameter("cmbIdCategoria"));
                    int descuentoPromo = Integer.valueOf(request.getParameter("txtDescuento"));
                    Date fechaInicioPromo = java.sql.Date.valueOf(request.getParameter("dateInicio"));
                    Date fechaFinalPromo = java.sql.Date.valueOf(request.getParameter("dateFinal"));
                    promocion.setCartelPromocion(nombreArchivo1Prod);
                    promocion.setIdCategoria(idCategoriaPromo);
                    promocion.setPorcentajePromocion(descuentoPromo);
                    promocion.setFechaInicio(fechaInicioPromo);
                    promocion.setFechaFinal(fechaFinalPromo);
                    promocion.setIdPromocion(idPromo);
                    promocionDao.actualizar(promocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idPromo = Integer.parseInt(request.getParameter("idPromocion"));
                    promocionDao.eliminar(idPromo);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
            }

            request.getRequestDispatcher("Promocion.jsp").forward(request, response);   
        }
    }

    private boolean verificar(String email) {
        String emailPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return email.matches(emailPattern);
    }

    private void limpiarCampos(HttpServletRequest request) {
        request.setAttribute("txtNombres", "");
        request.setAttribute("txtTelefono", "");
        request.setAttribute("txtEmail", "");
    }
    // Método para obtener el nombre original del archivo

    private String getNombreArchivo(Part part) {
        String contenidoHeader = part.getHeader("content-disposition");
        String[] elementos = contenidoHeader.split(";");
        for (String elemento : elementos) {
            if (elemento.trim().startsWith("filename")) {
                return elemento.substring(elemento.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
