<%-- 
    Document   : EnviarPeliculas
    Created on : 12/09/2023, 07:34:52 AM
    Author     : SIPAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Verificación de Compras</title>
    </head>
    <body style="margin: 0; background-size: cover">






        <img src="img/FONDOs.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">

        <div class="container w-75 bg-danger mt-5 rounded shadow">
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded">
                    <img src="img/MovieshopLogo.png" width="680">                 
                </div>

                <div class="col bg-white p-5 rounded-end">
                    <div class="text-end">
                        <img src="img/MovieshopLogo.png" width="48" alt="">
                    </div>
                    <h2 class="fw-bold text-center py-5">VERICIACIÓN DE COMPRAS</h2>


                    <div>

                        <c:forEach var="cesta" items="${cestas}">
                            <c:forEach var="usuario" items="${usuarios}">
                                <c:forEach var="producto" items="${productos}">
                                    <c:if test="${producto.getIdProducto() == cesta.getIdProducto() && cesta.getIdUsuario() == usuario.getIdUsuario()}">
                                        <form action="https://formsubmit.co/${usuario.getEmail()}" target="_blank" method="POST" enctype="multipart/form-data">
                                            <div class="mb-4">
                                                <input type="text" name="Bienvenida" value="Hola ${usuario.getNombreUsuario()}, te saludamos desde MovieShop. Te Enviamos este correo para enviarte la película que has comprado, ahora DISFÚTALA!!! 🎬 🍿 🎥." style="display: none;">
                                            </div>

                                            <ul style="margin-left: 40px">
                                                <li>
                                                    <input type="hidden" name="${producto.getNombreProducto()}" value="${producto.getTrailer()}">
                                                    <a>${producto.getNombreProducto()}</a>
                                                </li>
                                            </ul>
                                            <div class="d-grid">
                                                <button type="submit" class="btn btn-primary">Verificar ${producto.getNombreProducto()}</button>
                                            </div>
                                        </form>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                        <br>
                        <br>
                        <a href="Controlador?menu=EnviarPeliculas&accion=Listar" target="_blank">
                            <button type="submit" class="btn btn-success">Factura</button>
                        </a>

                    </div>
                </div>
            </div>
        </div>





        <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>

</html>

