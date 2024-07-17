<%-- 
    Document   : ProductosCesta
    Created on : 5/09/2023, 08:56:50 PM
    Author     : frede
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cesta - MovieShop</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="icon" href="img/Movieshop.png" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="CSS/Cesta.css">
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
                        <li><a href="Controlador?menu=Promociones&accion=ListarPromosVigentes" >Promoción</a></li>
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

        <h1 style="text-align: center; font-size: 50px; ">CESTA</h1>
        <div class="d-flex" >
            <div class="col-md-7"  style="margin-left: 100px">
                <div class="card" style="height: auto; background-color: black; " >
                    <div class="card-body">
                        <div class="form-group" style="font-size: 50px; background-color: black;" >
                            <label>
                                Productos
                            </label>
                        </div>
                        <div class="form-group d-flex flex-wrap">
                            <c:forEach var="cesta" items="${cestas}">
                                <c:forEach var="usuario" items="${usuarios}">
                                    <c:forEach var="producto" items="${productos}">
                                        <c:if test="${producto.getIdProducto() == cesta.getIdProducto() && cesta.getIdUsuario() == usuario.getIdUsuario()}">

                                            <div class="col-sm-6" style="margin-bottom: 20px;">
                                                <div class="box-container-2">
                                                    <div class="box-2" style="background-color:white ; border: 1px solid graytext; padding: 10px;display: flex">
                                                        <img src="img/imgPeliculas/${producto.getPortada()}" width="200" height=270" style="margin-right:  10px">
                                                        <div class="Cont">
                                                            <h2 id="h2" style="text-align: left;font-size:60px; color: brown ">${producto.getNombreProducto()}</h2>
                                                            <h3 id="h3" style="text-align: left; margin-top: -30px;">${usuario.getNombreUsuario()}</h3>
                                                            <br>
                                                            <br>
                                                            <h2 id="h2" style="text-align: left;font-size: 20px;margin-top: -39px;">${cesta.getCantidad()}</h2>
                                                            <br>
                                                            <h2  id="h2" style="text-align: left;font-size: 20px;margin-top: -39px;">${cesta.getFechaProducto()}</h2>
                                                            <br>
                                                            <h2 id="h2" style="text-align: left; font-size: 30px;margin-top: -30px; ">Q.${producto.getPrecio()}0</h2>
                                                            <br>
                                                            <div>
                                                                <style>
                                                                    .custom-btn {
                                                                        background-color: transparent;
                                                                        border: 2px solid black;
                                                                        color: black;
                                                                        margin: 5px;
                                                                        text-decoration: none;
                                                                        display: inline-block;
                                                                        padding: 5px 10px;
                                                                        transition: background-color 0.3s; /* Agregamos una transición suave para el cambio de color */
                                                                    }

                                                                    .custom-btn:hover {
                                                                        background-color: #333; /* Cambiamos el color de fondo cuando se pasa el mouse */
                                                                        color: white; /* Cambiamos el color del texto */
                                                                    }
                                                                </style>
                                                                <a class="btn btn-warning btn-sm rounded-circle custom-btn" href="Controlador?menu=Cestas&accion=ActualizarId&idCesta=${cesta.getIdCesta()}&cantidad=${cesta.getCantidad()}&idP=${producto.getIdProducto()}">+</a>
                                                                <a class="btn btn-danger btn-sm rounded-circle custom-btn" href="Controlador?menu=Cestas&accion=EliminarId&idCesta=${cesta.getIdCesta()}">X</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3"style="margin-left: 10px">
                <div class="card" style="height: auto;" >
                    <div class="card-body">
                        <div class="box-container-2">
                            <div class="box-2">
                                <div class="Cont">
                                    <h2 id="h2" style="text-align: left;font-size:60px; color: mistyrose ">Subtotal: Q.${subtotal}</h2>
                                    <h3 id="h3" style="text-align: left; margin-top: -30px;">Total: Q.${subtotal}</h3>
                                    <br>

                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <hr/>
                                    <div class="center">
                                        <div class="btn-1">
                                            <a href="Controlador?menu=MetodoPago&accion=Listar"><span>Metodo de pago</span></a>
                                        </div>
                                        <div class="btn-1">
                                            <a href="Controlador?menu=Peliculas&accion=Listar" style="width: 200px;"><span>Volver a Peliculas</span></a>
                                        </div>
                                    </div>
                                    <style>
                                        .center {
                                            display: flex;
                                            justify-content: center;
                                            font-size: 24px;
                                            margin-bottom: 20px;
                                        }
                                        .btn-1 {
                                            margin-bottom: 20px;
                                            background-color: white;
                                            width: 230px;
                                            height: 50px;
                                            display: flex;
                                            justify-content: flex-start;
                                            flex-direction: column;
                                        }
                                        span {
                                            position: relative;
                                            z-index: 3;
                                        }
                                        .btn-1 a::before {
                                            text-align: center;
                                            content: "";
                                            position: absolute;
                                            top: 5px;
                                            left: -2px;
                                            width: calc(100% + 6px);
                                            height: calc(100% - 10px);
                                            background-color: #ffffff;
                                            transition: all 0.5s ease-in-out;
                                            transform: scaleY(1);
                                        }
                                        .btn-1 a:hover::before {
                                            text-align: center;
                                            transform: scaleY(0);
                                        }
                                        .btn-1 a::after {
                                            text-align: center;
                                            content: "";
                                            position: absolute;
                                            left: 5px;
                                            top: -5px;
                                            width: calc(100% - 10px);
                                            height: calc(100% + 10px);
                                            background-color: #ffffff;
                                            transition: all 0.5s ease-in-out;
                                            transform: scaleX(1);
                                        }
                                        .btn-1 a:hover::after {
                                            text-align: center;
                                            transform: scaleX(0);
                                        }
                                        .btn-1 a {
                                            text-align: center;
                                            text-decoration: none;
                                            border: 2px solid #010100;
                                            padding: 15px;
                                            color: #000;
                                            text-transform: uppercase;
                                            letter-spacing: 2px;
                                            position: relative;
                                            display: inline-block;
                                        }
                                    </style>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script src="//code.tidio.co/zsd5io1qpp2eqcfntesfezgbrfomvnpm.js" async></script>
    </body>
</html>