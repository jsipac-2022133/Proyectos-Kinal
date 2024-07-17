<%-- 
    Document   : Resena
    Created on : 18/07/2023, 11:01:22 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>MovieShop - Reseñas</title>
        <style>
            .container{
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                gap: 40px
            }
            .rating{
                position: relative;
                display: flex;
                flex-direction: row-reverse;
                padding: 40px 40px;
                gap: 4px;
            }
            .rating input{
                position: relative;
                width: 20px;
                height: 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                cursor: pointer;
                appearance: none;
                -webkit-appearance: none;
            }

            .rating input::before{
                content: '\f005';
                position: absolute;
                font-family: fontAwesome;
                font-size: 25px;
                color: #111;
                transition: .5s;
            }

            .rating input:hover ~ input::before,
            .rating input:hover::before,
            .rating input:checked ~ input::before,
            .rating input:checked::before {
                color: var(--c);
            }
        </style>
    </head>
    <body style="margin: 0; ; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">

        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded" style="padding-top: 20px; padding-left: 5px" align center>
                    <table class="table table-bordered border-primary">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Fecha</th>
                                <th>Calificación</th>
                                <th>Reseña</th>
                                <th>Id Usuario</th>
                                <th>Id Producto</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="resena" items="${resenas}">
                                <tr oncontextmenu = "showPopup(event);">
                                    <td>${resena.getIdResena()}</td>
                                    <td>${resena.getFechaValoracion()}</td>
                                    <td>${resena.getCalificacion()}</td>
                                    <td>${resena.getResena()}}</td>
                                    <td>${resena.getIdUsuario()}</td>
                                    <td>${resena.getIdProducto()}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>              
                </div>




                <a href="Controlador?menu=PrincipalAdmin"><button type="button" class="btn btn-outline-secondary">Regresar</button></a>








            </div>

            <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
