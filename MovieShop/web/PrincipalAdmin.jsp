<%-- 
    Document   : Index
    Created on : 17/07/2023, 08:06:00 PM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>MovieShop - Administrador</title>
        <style>
            #imagenUsuario {
                width: 100px;
                height: 100px; /* Haz que la altura sea igual al ancho para que la imagen sea un círculo perfecto */
                border-radius: 50%; /* Esto hace que la imagen sea redonda */
                overflow: hidden; /* Esto recorta cualquier parte de la imagen que esté fuera del círculo */
            }

        </style>
    </head>
    <body style="margin: 0; background-size: cover">
        <img src="img/FondoNegroLogin.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0;">

        <nav class="navbar navbar-expand-lg nvabar-light bg-danger">

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Principal">
                            <img src="img/Movieshop.png" alt="60" width="60">
                        </a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style="border: none; width: 215px; height: 50px" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">                    
                    ${usuario.getNombreUsuario()}
                </button>
                <div class="dropdown-menu text-center" arial labellebdy="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        <img  src="img/${usuario.getFotoPerfil()}" width="100" height="120">
                    </a>
                    <div class="dropdown-divider"></div>
                     <a class="dropdown-item" href="#">${usuario.getNombreUsuario() }</a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                    <a class="dropdown-item" href="#">${usuario.getEmail()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" name="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </nav>        

        <div class="m-4"  style="height: 640px">
            <div class="position-absolute top-0 start-50 translate-middle container overflow-hidden">
                <div class="card" style="width: 28rem;height: 430px;">
                    <img src="img/DetallePago.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">DETALLES DE PAGOS</h5>
                        <p class="card-text">Llevamos el control de los Pagos, nos guiamos por medio de su ID</p>
                        <a class="btn btn-primary" href="Controlador?menu=DetallePago&accion=Listar">VER</a>
                    </div>
                </div>
            </div>
            <div class="position-absolute top-0 start-50 translate-middle col-md-4 offset-md-4">
                <div class="card" style="width: 450px; height: 430px;">
                    <img src="img/Peliculas.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">PRODUCTOS</h5>
                        <p class="card-text">Llevamos el control de nuestras películas.</p>
                        <a href="Controlador?menu=Producto&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4 offset-md-8">
                <div class="card" style="width: 450px;  margin-bottom: 50px; height: 430px">
                    <img src="img/Proveedores.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">PROVEEDORES</h5>
                        <p class="card-text">Podemos ver los proveedores que trabajan para nosotros.</p>
                        <a href="Controlador?menu=Proveedores&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="position-absolute top-0 start-50 translate-middle col-md-4 offset-md-0">
                <div class="card" style="width: 450px; margin-bottom: 50px">
                    <img src="img/CarroDeCompras.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">CESTA</h5>
                        <p class="card-text">Vemos los articulos que los clientes compran.</p>
                        <a href="Controlador?menu=Cesta&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="position-absolute top-0 start-50 translate-middle col-md-4 offset-md-4">
                <div class="card" style="width: 450px; height: 375px">
                    <img src="img/Resena.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">RESEÑA</h5>
                        <p class="card-text">Podemos ver los comentarios de nuestros clientes.</p>
                        <a href="Controlador?menu=Resena&accion=Listar"  class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 offset-md-8">
                <div class="card" style="width: 450px; margin-bottom: 50px; height: 375px">
                    <img src="img/ServicioCliente.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">SERVICIO AL CLIENTE</h5>
                        <p class="card-text">Ayudamos a nuestros clientes con sus problemas</p>
                        <a href="Controlador?menu=ServicioCliente&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="position-absolute top-0 start-50 translate-middle col-md-4 offset-md-4">
                <div class="card" style="width: 450px; margin-bottom: 10px; height: 420px">
                    <img src="img/Pago.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">PAGOS</h5>
                        <p class="card-text">Llevamos el control de los Pagos realizados en nuestra pagina</p>
                        <a class="btn btn-primary" href="Controlador?menu=Pago&accion=Listar">VER</a>
                    </div>
                </div>
            </div>
            <div class="position-absolute top-0 start-50 translate-middle col-md-4 offset-md-8">
                <div class="card" style="width: 450px; height: 419px; width: 417px">
                    <img src="img/Promocion.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">PROMOCIONES</h5>
                        <p class="card-text">Podemos ver los diferentes tipos de promociones</p>
                        <a href="Controlador?menu=Promocion&accion=Listar"  class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 offset-md-0">
                <div class="card" style="width: 450px; margin-bottom: 50px; height: 425px">
                    <img src="img/TipoTarjeta.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">TIPOS DE TARJETAS</h5>
                        <p class="card-text">Se puede ver los tipos de targetas que aceptamos .</p>
                        <a href="Controlador?menu=TipoTarjeta&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="position-absolute top-0 start-50 translate-middle col-md-4 offset-md-4" >
                <div class="card" style="width: 450px; margin-bottom: 50px; height: 425px">
                    <img src="img/DetallePromocion.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">DETALLE DE PROMOCIONES</h5>
                        <p class="card-text">Llevamos el control de las promociones</p>
                        <a href="Controlador?menu=DetallePromocion&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 offset-md-0">
                <div class="card" style="width: 450px; margin-bottom: 50px; height: 425px">
                    <img src="img/PortadaCategorias.jpeg" class="card-img-top" alt="..." style="width: 450px; height: 275px">
                    <div class="card-body">
                        <h5 class="card-title">CATEGORIAS</h5>
                        <p class="card-text">Puede ver las categorias de películas que manejamos</p>
                        <a href="Controlador?menu=Categoria&accion=Listar" class="btn btn-primary">VER</a>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>