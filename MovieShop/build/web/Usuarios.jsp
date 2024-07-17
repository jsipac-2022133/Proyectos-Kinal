<%-- 
    Document   : Usuarios
    Created on : 13/07/2023, 09:44:49 PM
    Author     : frede
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Usuarios - MovieShop</title>
    </head>
    <body style="margin: 0; ; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">

        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded">
                    <table class="table table-bordered border-primary">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Usuario</th>
                                <th>Contraseña</th>
                                <th>Email</th>
                                <th>Foto Perfil</th>
                            </tr>
                        </thead>
                        <tbody>     
                            <c:forEach var="usuario" items="${usuarios}">
                                <tr oncontextmenu="showPopup(event)">
                                    <td>${usuario.getIdUsuario()}</td>
                                    <td>${usuario.getNombreUsuario()}</td>
                                    <td>${usuario.getApellidoUsuario()}</td>
                                    <td>${usuario.getUsuario()}</td>
                                    <td>${usuario.getPass()}</td>
                                    <td>${usuario.getEmail()}</td>
                                    <td>${usuario.getFotoPerfil()}</td>
                            </c:forEach>
                        </tbody>
                    </table>              
                </div>

                <div style="margin-top: 1px" class="col bg-white col-sm-4 rounded-end float-end">
                    <div class="text-end">
                        <img src="img/MovieshopLogo.png" width="48" alt="">
                    </div>
                    <h2 class="fw-bold text-center py-5">USUARIOS</h2>


                    <form action="Controlador?menu=Usuario" method="POST">
                        <div class="mb-4">
                            <label class="form-label">ID Usuario</label>
                            <input class="form-control" name="txtIdUsuario">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Nombres</label>
                            <input class="form-control" name="txtNombreUsuario">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Apellidos</label>
                            <input class="form-control" name="txtApellidoUsuario">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Usuario</label>
                            <input class="form-control" name="txtUsuario">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Contraseña</label>
                            <input class="form-control" name="txtContrasena">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Email</label>
                            <input class="form-control" name="txtEmail">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Foto de Perfil</label>
                            <br>                            
                            <img src="img/Vacio.png" class="rounded float-left" width="100px" height="125" style="margin-bottom: 3px">
                            <br>
                            <button type="submit" class="btn btn-primary">Seleccionar</button>
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
