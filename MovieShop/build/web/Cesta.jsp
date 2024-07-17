<%-- 
    Document   : Cesta
    Created on : 18/07/2023, 01:58:22 PM
    Author     : ROQUEL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop - Cesta</title>
        <style>
            .link-button {
                text-align: right; /* Alinea el enlace a la derecha */
                display: block; /* Hace que el enlace ocupe todo el ancho disponible */
            }

            .link-button button {
                background-color: white; /* Establece el fondo blanco para el botón */
            }

        </style>
    </head>
    <body style="margin: 0; ; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">

        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded" style="padding-top: 50px; padding-left: 50px" align center>
                    <a href="Controlador?menu=PrincipalAdmin" class="link-button">
                        <button type="button" class="btn btn-outline-secondary">Regresar</button>
                    </a>

                    <table class="table table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>Id Cesta</th>
                                <th>Cantidad</th>
                                <th>Fecha</th>
                                <th>Subtotal</th>
                                <th>Usuario</th>
                                <th>Producto</th>
                                <!-- <th>Acciones</th>-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cesta" items="${cestas}">
                                <tr oncontextmenu="showPopup(event);">
                                    <td>${cesta.getIdCesta()}</td>
                                    <td>${cesta.getCantidad()}</td>
                                    <td>${cesta.getFechaProducto()}</td>
                                    <td>Q.${cesta.getSubTotal()}0</td>
                                    <td>${cesta.getIdUsuario()}</td>
                                    <td>${cesta.getIdProducto()}</td>
                                    <!-- <td>
                                       <a class="btn btn-warning" href="Controlador?menu=Cesta&accion=Editar&idCesta=${cesta.getIdCesta()}">Editar</a>
                                       <a class="btn btn-danger" href="Controlador?menu=Cesta&accion=Eliminar&idCesta=${cesta.getIdCesta()}">Eliminar</a>
                                   </td>-->
                                <tr/>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>



                <!--  <div style="margin-top: 1px" class="col bg-white col-sm-4 rounded-end float-end">
                    <div class="text-end">
                        <a href="Controlador?menu=PrincipalAdmin"><button type="button" class="btn btn-outline-secondary">Regresar</button></a>
                        <img src="img/MovieshopLogo.png" width="48" alt="">
                    </div>
                    <form action="Controlador?menu=Cesta" method="POST">
                        <h2 class="fw-bold text-center py-5">CESTA</h2>
                        <div class="mb-4" align="center">
                            <br>                            
                            <img src="img/Carrito.png" class="rounded float-left" width="100px" height="125" style="margin-bottom: 3px" margin-widht>
                            <br>
                        </div>
                        
                        <div class="mb-4">
                            <label class="form-label">Cantidad</label>
                            <input type="text" value="${cestaEncontrada.getCantidad()}" class="form-control" name="txtCantidad">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Fecha</label>
                            <input type="date" value="${cestaEncontrada.getFechaProducto()}" class="form-control" name="txtFecha">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">SubTotal</label>
                            <input type="text" value="${cestaEncontrada.getSubTotal()}" class="form-control" name="txtSubTotal">
                        </div>
                        
                        <div class="mb-4">
                            <label class="form-label">Usuario </label>
                            <br>
                            <select name="cmbIdUsuario" class="form-control">
                <c:forEach var="usuario" items="${usuarios}">

                    <option value="${usuario.getIdUsuario()}"> ${usuario.getIdUsuario()} | ${usuario.getNombreUsuario()}</option>          

                </c:forEach>
            </select>
            <br>
            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
        </div>
        
    </form>
</div>
</div>-->
            </div>





            <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>

</html>