<%-- 
    Document   : CategoriaPeliculas
    Created on : 20/12/2023, 11:42:20 PM
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
        <title>Movieshop - Categorias</title>
        <style>
            #miDiv{
                background-color: #FFFFFF;
                width: 400px;
                height: 300px;
            }
            #textoDiv{
                color: #000000;
            }
        </style>
    </head>
    <body>
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">
        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounden shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded">
                    <table class="table table-bordered border-primary">
                        <thead class="table-dark">
                            <tr>
                                <th>Código</th>
                                <th>Categoría</th>
                                <th>Opciones</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>     
                            <c:forEach var="categorias" items="${categorias}">
                                <tr>
                                    <td>${categorias.getIdCategoria()}</td>
                                    <td>${categorias.getNombreCategoria()}</td>
                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=Categoria&accion=Editar&codigoCategoria=${categorias.getIdCategoria()}">Editar</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger" href="Controlador?menu=Categoria&accion=Eliminar&codigoCategoria=${categorias.getIdCategoria()}">Eliminar</a>
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
                    <h2 class="fw-bold text-center py-5">CATEGORÍAS</h2>
                    <form action="Controlador?menu=Categoria" method="POST">
                        <div class="mb-4">
                            <label class="form-label">Categoría</label>
                            <input type="text" value="${categoriaEncontrada.getNombreCategoria()}" name="txtCategoria" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-danger">
                    </form>
                    <div class="container w-100 my-5">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
