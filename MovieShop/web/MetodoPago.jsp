<%-- 
    Document   : MetodoPago
    Created on : 9/09/2023, 01:26:38 PM
    Author     : frede
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="img/Movieshop.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Metodo Pago - MovieShop</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>        <link rel="stylesheet" href="CSS/Cesta.css">
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <style>
            #h2{
                color: black;
                text-align: right;
            }
            #h3{
                color: black;
                text-align: right;
            }
        </style>
    </head>
    <body>
        <header class="header">
            <div class="menu container">

                <a href="Controlador?menu=Principal" class="logo">MovieShop</a>
                <input type="checkbox" id="menu" />
                <label for="menu">
                    <img src="img/imgPeliculas/menu.png" class="menu-icono" alt="menu">
                </label>
                <nav class="navbar">
                    <ul>
                        <li><a  href="Controlador?menu=Peliculas&accion=Listar">Peliculas</a></li>
                        <li><a href="Controlador?menu=Programadores">Nosotros</a></li>
                        <li><a href="Controlador?menu=Promociones&accion=Listar">Promoción</a></li>
                        <li><a href="Controlador?menu=Cestas&accion=listarId">Cesta</a></li>
                    </ul>
                </nav>
                <button class="btn btn-success " data-bs-toggle="offcanvas" data-bs-target="#intro" style="width: 250px; height:70px; font-size: 25px; background-color: black; color: white ">${usuario.getNombreUsuario()}</button>

                <div class="offcanvas offcanvas-end" id="intro" style="background: rgba(243,236,227,255);">
                    <div class="offcanvas-header">
                        <div class="offcanvas-title">
                            <button class="btn" data-bs-dismiss="offcanvas"><svg xmlns="http://www.w3.org/2000/svg" height="30" viewBox="0 0 448 512"><path d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zm79 143c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z"/></svg></button>
                        </div>
                    </div>
                    <div class="offcanvas-body">
                        <a class="dropdown-item" href="#">
                            <img id="imagenUsuario" src="img/imgPeliculas/${usuario.getFotoPerfil()}" width="300" height="390" style="position: relative; left: 35px; width: 300px; height: 390px; border-radius: 50%; object-fit: cover; box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);" onmouseover="this.style.transform = 'scale(1.1)';" onmouseout="this.style.transform = 'scale(1)';">
                        </a>

                        <a class="dropdown-item" href="#" style="text-align: center; margin-top: 30px; font-size: 40px; color: black"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"/></svg>  ${usuario.getUsuario()}</a>
                        <a class="dropdown-item" href="#" style="text-align: center; font-size: 30px;color: black"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M48 64C21.5 64 0 85.5 0 112c0 15.1 7.1 29.3 19.2 38.4L236.8 313.6c11.4 8.5 27 8.5 38.4 0L492.8 150.4c12.1-9.1 19.2-23.3 19.2-38.4c0-26.5-21.5-48-48-48H48zM0 176V384c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V176L294.4 339.2c-22.8 17.1-54 17.1-76.8 0L0 176z"/></svg>  ${usuario.getEmail()}</a>
                        <a href="Controlador?menu=Config&accion=DatosUsuario&codigoUsuario=${usuario.getIdUsuario()}" class="dropdown-item" style="color: black;text-align: center; font-size: 25px;margin-top: 70px">
                          <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                            <path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"/>
                          </svg> Configuración De Perfíl
                        </a>

                        <form action="Validar" method="POST">
                            <button name="accion" name="Salir" class="dropdown-item" href="#" style="color: black;text-align: center; font-size: 25px;margin-top: 30px" ><svg xmlns="http://www.w3.org/2000/svg" height="50" viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></svg>  Cerrar Sesion</button>
                        </form>

                    </div>
                </div>

            </div>
        </header>
        <img src="img/BannerMovieShop.gif" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1; opacity: 0.7">
        <h1 style="text-align: center; font-size: 50px; ">METODO DE PAGO</h1>
        <form action="Controlador?menu=MetodoPago" method="POST">
            <div class="d-flex" >
                <div class="col-md-7"  style="margin-left: 100px">
                    <div class="card" >
                        <div class="card-body" style=" height: 650px;">
                            <div class="form-group" style="font-size: 50px; background-color: black;" ></div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" style="margin-bottom: 100px">
                                    <div class="box-container-2">
                                        <div class="box-2">
                                            <div class="mb-4">
                                                <label class="form-label" style="text-align: left;font-size:40px; color: black; padding: 10px">Tipo De Tarjeta</label>
                                                <img src="img/imgTipoTargetas/TargetaRegalo.png" width="80" height="50">
                                                <img src="img/imgTipoTargetas/Visa.png" width="80" height="50">
                                                <select name="cmbIdTarjeta" class="form-control">
                                                    <c:forEach var="tarjeta" items="${tarjetas}">
                                                        <option value="${tarjeta.getIdTipoTarjeta()}">${tarjeta.getTipoTarjeta()}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div>
                                                <label style="text-align: left;font-size:35px; color: black; padding: 10px">Cantidad a Pagar</label>
                                                <input type="text" class="form-control" style="margin-bottom: 10px;" value="${subtotal}" name="txtSubtotal">
                                            </div>
                                            <div>
                                                <label style="text-align: left;font-size:35px; color: black; padding: 10px">Fecha de Pago</label>
                                                <input type="date" class="form-control" style="margin-bottom: 10px;" id="fechaPago" name="txtDate">
                                            </div>
                                            <div class="mb-4">
                                                <label class="form-label" style="text-align: left;font-size:35px; color: black; padding: 10px">Usuario</label>
                                                <select name="cmbIdUsuario" class="form-control" id="combox">
                                                    <option value="${usuario.getIdUsuario()}">${usuario.getNombreUsuario()}</option>    
                                                </select>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3"style="margin-left: 10px">
                    <div class="card" >
                        <div class="card-body" style="height: 450px">
                            <div class="box-container-2">
                                <div class="box-2">
                                    <div class="Cont">
                                        <h2 id="h2" style="text-align: left;font-size:60px; color: mistyrose ">Subtotal: Q ${subtotal}</h2>
                                        <h3 id="h3" style="text-align: left; margin-top: -30px;">Total: Q ${subtotal}</h3>
                                        <br>                                   
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        <br>

                                        <hr/>
                                        <br>
                                        <br>
                                        <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">PAGAR</button>
                                        <br>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </form>



        <script>
            // Esto sirve para asginar la fecha actual 
            var fechaActual = new Date().toISOString().slice(0, 10);

            //Aquí se asigna
            document.getElementById("fechaPago").value = fechaActual;
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script src="//code.tidio.co/zsd5io1qpp2eqcfntesfezgbrfomvnpm.js" async></script>
    </body>
</html>
