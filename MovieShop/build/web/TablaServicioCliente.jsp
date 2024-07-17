<%-- 
    Document   : TablaServicioCliente
    Created on : 17-jul-2023, 18:58:08
    Author     : Joshua
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop - Servicio Cliente</title>
    </head>
   <body style="margin: 0; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">
       <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded">
                    <table class="table table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>IdServicio</th>
                                <th>Descripcion</th>
                                <th>idUsuario</th>
                                <th>idProducto</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach var="ServicioCl" items="${servicioClientes}">
                               <tr>
                                <td>${ServicioCl.getIdServicio()}</td>
                                <td>${ServicioCl.getDescripcion()}</td>
                                <td>${ServicioCl.getIdUsuario()}</td>
                                <td>${ServicioCl.getIdProducto()}</td>
                               
                            </tr> 
                            </c:forEach>
                            
                       
                            
                        
                        </tbody>
                    </table>              
                </div>

                <div style="margin-top: 1px" class="col bg-white col-sm-4 rounded-end float-end">
                    <div class="text-end">
                        <a href="Controlador?menu=PrincipalAdmin"><button type="button" class="btn btn-outline-secondary">Regresar</button></a>
                        <img src="img/MovieshopLogo.png" width="48" alt="">
                    </div>
                    <h2 class="fw-bold text-center py-5">Servicio Cliente</h2>


                    <form action="Controlador?menu=ServicioCliente" method="POST">
                        <div class="mb-4">
                            <label class="form-label">Descripcion</label>
                            <input class="form-control"  name="txtDescripcion">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">idUsuario</label>
                            <br>
                            <select  name="cmbIdUsuario" class="form-control">
                                <c:forEach var="usuario" items="${usuarios}">
                                    <option value="${usuario.getIdUsuario()}">${usuario.getIdUsuario()}| ${usuario.getNombreUsuario()}</option>
                                </c:forEach>
                                
                            </select>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">idProducto</label>
                            <br>
                            <select name="cmbProducto" class="form-control">
                                <c:forEach var="producto" items="${productos}">
                                    <option value="${producto.getIdProducto()}">${producto.getIdProveedor()}| ${producto.getNombreProducto()}</option>
                                    
                                </c:forEach>
                            </select>
                            <br>
                            
                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary dropdown-toggle" >
                           
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
   </body>
</html>
