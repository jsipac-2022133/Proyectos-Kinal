<%-- 
   Document   : Principal
   Created on : 22/08/2023, 04:02:55 PM
   Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="img/Movieshop.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Principal - MovieShop</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="CSS/Principal.css">
    </head>
    <body>
        <header class="header" style="background-image: url('img/BannerMovieShop.gif');     min-height: 100vh;">
            <div class="menu container">
                <a href="Controlador?menu=Principal" class="logo" style="color: black">MovieShop</a>
                <input type="checkbox" id="menu" />
                <label for="menu">
                    <img src="img/imgPeliculas/menu.png" class="menu-icono" alt="menu">
                </label>
                <nav class="navbar" >
                    <ul>
                        <li><a  href="Controlador?menu=Peliculas&accion=Listar" style="color: black">Peliculas</a></li>
                        <li><a href="Controlador?menu=Programadores" style="color: black">Nosotros</a></li>
                        <li><a href="Controlador?menu=Promociones&accion=ListarPromosVigentes" style="color: black">Promoción</a></li>
                        <li><a href="Controlador?menu=Cestas&accion=listarId" style="color: black">Cesta</a></li>
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

                        <a class="dropdown-item" href="#" style="text-align: center; font-size: 40px; color: black"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"/></svg>  ${usuario.getUsuario()}</a>
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
        <img src="img/FondoLogin.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1; ">

        <span>|BIENVENIDO A MOVIESHOP|</span>

        <style>
            span{          
                margin-left: 60px;
                font-size: 200px;
                margin-top: 350px;
                margin-bottom: 350px;
                display: block;
                white-space: nowrap;
                border-right: 4px solid;
                width: 22ch;

                animation: typing 2s steps(12),
                    blink .5s infinite step-end alternate;
                overflow: hidden;
            }
            @keyframes typing{
                from{width:0}
            }
            @keyframes blink{
                50%{border-color: transparent}
            }
        </style>

        <div style="display: flex">

            <div style="display: flex;clear: none; margin-right: 2.5rem;">
                <img src="img/imgPromocion/Promocion2.gif" width="500" style="margin-top:  100px; margin-left: 150px; display: flex;margin-bottom: 100px">
            </div>
            <div class="descripcion">
                <p style="text-align: center;margin-top: 200px">En MovieSHop, estamos apasionados por el mundo del cine y la magia que solo una buena película puede ofrecer. Somos mucho más que una simple tienda en línea; somos tu destino cinematográfico definitivo. Si eres un amante del cine como nosotros, has llegado al lugar adecuado.</p>

                <p>Nuestra misión es brindarte acceso a una amplia y cuidadosamente seleccionada colección de películas, desde los clásicos inolvidables hasta los éxitos de taquilla más recientes. Ya sea que busques aventuras épicas, dramas conmovedores, comedias hilarantes o emocionantes películas de terror, MovieSHop tiene algo para cada cinéfilo.</p>
                <p >Lo que nos distingue es nuestro compromiso con la calidad y la autenticidad. Cada película que encontrarás en nuestro catálogo ha sido elegida con atención, y trabajamos incansablemente para ofrecerte una experiencia de compra excepcional. Además, estamos aquí para ayudarte a explorar el mundo del cine, proporcionándote reseñas, recomendaciones y contenido exclusivo relacionado con tus películas favoritas.</p>
            </div>
        </div>

        <style>
            .descripcion p{
                text-align: center;
                font-size: 35px;
                margin-right: 10px;
                margin: 30px;
                line-height: 1.5;
            }
            .section{
                display: flex;
                width: 900px;
                height: 530px
            }
            .section img{
                width: 190px;
                flex-grow: 1;
                object-fit: cover;
                opacity: .8;
                transition: .5s ease;
            }
            .section img:hover{
                cursor: crosshair;
                width: 400px;
                height: 600px;
                opacity: 1;
                filter: constrast(120%);
            }
        </style>
        <nav style="background-color: #E3DAC9; margin-bottom: 50px; display: flex" width="100%" height="100%" >

            <img src="img/imgPromocion/Promocion3.png" >
            <h2 style="margin-left: 220px; margin-top:  500px">APROVECHA NUESTRAS INCREIBLES OFERTAS</h2>


        </nav>
        <div>
            <section class="section" style="margin-bottom: -150px;z-index: 1">
                <c:forEach var="producto" items="${productos}" varStatus="status">
                    <c:if test="${status.index < 10}">
                        <a href="Controlador?menu=InformacionPelicula&accion=Editar&idProducto=${producto.getIdProducto()}"style="z-index: 1">
                            <img loading="lazy" src="img/imgPeliculas/${producto.getPortada()}" width="200" height="270">
                        </a>
                    </c:if>
                </c:forEach>
            </section>
            <section class="section" >
                <c:forEach var="producto" items="${productos}" varStatus="status">
                    <c:if test="${status.index >= 10 && status.index < 20}">
                        <a href="Controlador?menu=InformacionPelicula&accion=Editar&idProducto=${producto.getIdProducto()}"  >
                            <img loading="lazy" src="img/imgPeliculas/${producto.getPortada()}" width="200" height="270">
                        </a>
                    </c:if>
                </c:forEach>
            </section>
        </div>



        <footer class="footer" style="background-color: black ;">

            <h3 style="padding-left: 350px;">MovieShop</h3>
            <ul>
                <li><a href="#" style="padding-right: 20px">Inicio</a></li>
                <li><a href="#" style="padding-right: 20px">Nosotros</a></li>
                <li><a href="#" style="padding-right: 20px">Películas</a></li>
                <li><a href="#" style="padding-right: 350px">Contacto</a></li>
            </ul>
        </footer>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script src="//code.tidio.co/zsd5io1qpp2eqcfntesfezgbrfomvnpm.js" async></script>
    </body>
</html>
