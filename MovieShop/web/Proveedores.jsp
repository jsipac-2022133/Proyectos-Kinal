 <%-- 
    Document   : Proveedores
    Created on : 19/07/2023, 01:44:31 AM
    Author     : santiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="icon" href="img/Movieshop.png" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop -  Proveedores</title>
    </head>
    <body style="margin: 0; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">
        
        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded">
                    <table class="table table-bordered border-primary">
                        <thead class="table-dark">
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Email</th>
                                <th>Opciones</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>     
                            <c:forEach var="proveedores" items="${proveedores}">
                                <tr>
                                    <td>${proveedores.getIdProveedor()}</td>
                                    <td>${proveedores.getNombreProveedor()}</td>
                                    <td>${proveedores.getTelefonoProveedor()}</td>
                                    <td>${proveedores.getEmail()}</td>
                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=Proveedores&accion=Editar&codigoProveedor=${proveedores.getIdProveedor()}">Editar</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger" href="Controlador?menu=Proveedores&accion=Eliminar&codigoDeProveedor=${proveedores.getIdProveedor()}">Eliminar</a>
                                    </td>
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
                    <h2 class="fw-bold text-center py-5">PROVEEDORES</h2>
                    <form action="Controlador?menu=Proveedores" method="POST">
                        <div class="mb-4">
                            <label class="form-label">Nombre</label>
                            <input type="text" value="${proveedorEncontrado.getNombreProveedor()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Teléfono</label>
                            <input type="text" value="${proveedorEncontrado.getTelefonoProveedor()}" name="txtTelefono" class="form-control" >
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Email</label>
                            <input type="text" value="${proveedorEncontrado.getEmail()}" name="txtEmail" class="form-control" >
                            <c:if test="${not empty errorEmail}">
                                <div class="error-message">${errorEmail}</div>
                            </c:if>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-danger">
                        <input type="submit" name="accion" value="Limpiar" class="btn btn-outline-secondary">
                    </form>
                    <div class="container w-100 my-5">
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>