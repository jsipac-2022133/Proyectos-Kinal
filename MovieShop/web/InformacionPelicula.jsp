<%-- 
    Document   : InformacionPelicula
    Created on : 3/09/2023, 05:57:11 AM
    Author     : SIPAC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/Movieshop.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <title>${productoEncontrado.getNombreProducto()} - MovieShop</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Lobster&family=Montserrat:ital,wght@0,700;1,400&display=swap');
            * {
                box-sizing: border-box; 
            }
            #h2{
                color: white;
                text-align: right;
            }
            #h3{
                color: white;
                text-align: right;
            }
            .Cont{
                margin-bottom: 100px;
            }
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                text-decoration: none;
                list-style: none;
            }
            body{
                font-family: 'Bebas Neue', cursive;
                background-color: #030303;
                color: #ffffff;
            }


            .container{
                max-width: 1200px;
                margin: 0 auto;

            }
            .contenedor{
                display: flex;
            }

            .header{
                background-position: center center;
                background-repeat: none;
                background-size: cover;
                min-height: 10vh;
                display: flex;
                align-items: center;
            }

            .menu{
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .logo{
                font-size: 35px;
                color: #ffffff;

            }

            .menu .navbar ul li{
                position: relative;
                float: left;
            }

            .menu .navbar ul li a{
                font-size: 22px;
                padding: 20px;
                color: #ffffff;
                display: block;
            }

            .menu .navbar ul li a:hover{
                color: #ff2f28;

            }

            #menu{
                display: none;
            }

            .menu-icono{
                width: 25px;

            }

            .menu label{
                cursor: pointer;
                display: none;
            }

            .header-content{
                display: flex;
                width: 100px;

            }

            .header-1{
                display: flex;
                flex-direction: column;
                width: 50%;
                align-self: flex-end;
                margin-left: 100px;
            }

            .header-1 img{
                width: 300px;
            }



            .btn-1{
                display: inline-block;
                padding: 7px 20px;
                background-color: #ff2f28;
                color: #ffffff;
                font-size: 20px;
            }

            .btn-2{
                width: 110px;
                display: inline-block;
                padding: 7px 20px;
                background-color: #ff2f28;
                font-size: 20px;
                margin-top: 30px;
                color: #ffffff;
            }

            .movies{
                padding: 50px 0 0 0;
                display: flex;
                flex-direction: column;
                margin-bottom: 100px;
            }

            h2{
                font-size: 35px;
                margin-bottom: 20px;
            }

            hr{
                border: 1px solid #ff2f28;
                width: 50%;
                margin-bottom: 40px;
            }
            .header{
                background-image: url(../img/imgPeliculas/Spidermangif.gif);
                background-position: center center;
                background-repeat: none;
                background-size: cover;
                min-height: 20vh;
                display: flex;
                align-items: center;
            }
            .menu{
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .menu .navbar ul li{
                position: relative;
                float: left;
            }

            .menu .navbar ul li a{
                font-size: 22px;
                padding: 20px;
                color: #ffffff;
                display: block;
            }

            .menu .navbar ul li a:hover{
                color: #ff2f28;

            }
            #menu{
                display: none;
            }

            .menu-icono{
                width: 25px;

            }

            .menu label{
                cursor: pointer;
                display: none;
            }

            .header-content{
                display: flex;
                width: 100px;

            }

            .header-1{
                display: flex;
                flex-direction: column;
                width: 50%;
                align-self: flex-end;
                margin-left: 100px;
            }

            .header-1 img{
                width: 300px;
            }
            .footer a{
                color: #ffffff;
                font-size: 20px;
                margin-right: 20px;
                display: block;
            }
            * {
                box-sizing: border-box;
            }
            .play-overlay {
                position: relative;
                display: inline-block;
                align-items: center;
            }

            #myModal {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
                text-align: center;
                z-index: 999; /* Asegura que la ventana emergente esté en la parte superior */
            }

            .modal-content {
                position: relative;
                color: black;
                background-color: white;
                background-image: url(img/Movieshop.png);
                padding: 20px;
                border-radius: 5px;
                width: 500px; /* Ancho deseado de la ventana emergente */
                height: 500px; /* Alto deseado de la ventana emergente */
                margin: 0 auto; /* Centra la ventana emergente horizontalmente */
                top: 50%; /* Centra verticalmente */
                left: 20%;
                transform: translate(-50%, -50%); /* Centra verticalmente */
                box-sizing: border-box;
            }
            .footer{
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 100px 0;

                border-top: 1px solid #ff2f283d;
            }

            .footer ul{
                display: flex;
            }

            .footer h3{
                font-size: 30px;

            }

            .footer a{
                color: #ffffff;
                font-size: 20px;
                margin-right: 20px;
                display: block;
            }

            .footer a:hover{
                color: #ff2f28;
            }

            @media (max-width:991px){
                .menu{
                    padding: 20px;
                }

                .menu label{
                    display: initial;
                }

                .menu .navbar{
                    position: absolute;
                    top: 100%;
                    left: 0;
                    right: 0;
                    background-color: #030303;
                    display: none;
                }

                .menu .navbar ul li{
                    width: 100%;
                }

                .btn-1{
                    display: none;
                }

                #menu:checked ~ .navbar{
                    display: initial;
                }

                .header-content{
                    flex-direction: column;
                    padding: 180px 30px 30px 30px;
                }

                .header-1{
                    width: 100%;
                    align-items: center;
                }

                .header-2{
                    width: 100%;
                    text-align: center;        
                }

                .movies{
                    padding: 30px;        
                }

                .footer {
                    margin-top: 30px;
                    padding: 300px;
                    flex-direction: column;
                    text-align: center;
                }

                .footer ul{
                    margin-top: 15px;
                    justify-content: center;

                }

            }

            .rating{
                position: absolute;
                display: flex;
                flex-direction: row-reverse;
                padding: 40px 40px;
                gap: 15px;
                margin-top: 10px;
                margin-right: 2000px;
                margin-left: -150px;
            }
            .rating input{
                position: relative;
                width: 25px;
                height: 25px;
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
                color: white;
                transition: .5s;
            }

            .rating input:hover ~ input::before,
            .rating input:hover::before,
            .rating input:checked ~ input::before,
            .rating input:checked::before {
                color: var(--c);
            }
            
            .rate {
            position: absolute;
            display: flex;
            flex-direction: row-reverse;
            padding: 40px 40px;
            gap: 4px;
            font-size: 30px; /* Tamaño de la fuente de las estrellas */
            color: white; /* Color de las estrellas */
            margin-top: -44px;
            margin-right: 100px;
            margin-left: 10px;
            }
            
            .rate input {
            position: relative;
            width: 30px; /* Tamaño de cada radio button */
            height: 30px; /* Altura de cada radio button */
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
            appearance: none;
            -webkit-appearance: none;
            }

        </style>
    </head>
    <body style="color: black">
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


                        <form action="Validar" method="POST">
                            <button name="accion" name="Salir" class="dropdown-item" href="#" style="color: black;text-align: center; font-size: 25px;margin-top: 100px" ><svg xmlns="http://www.w3.org/2000/svg" height="50" viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></svg>  Cerrar Sesión</button>

                        </form>

                    </div>
                </div>
            </div>
            <div class="header-2">
                <a href="Controlador?menu=InformacionPelicula&accion=AgregarCesta&id=${productoEncontrado.getIdProducto()}" class="btn-2" style="text-decoration: none; color:#FFFFFF;">Añadir al Carrito</a>
            </div>
        </header>
        <section class="movies container" >            
            <div class="box-container-2">
                <div class="box-2">
                    <div class="content">
                        <a class="play-overlay" href="${productoEncontrado.getTrailer()}" style="margin-right: 500px;float: left; clear: none; margin-right: 2.5rem;">

                            <img src="img/imgPeliculas/${productoEncontrado.getPortada()}" width="500" height="700">
                        </a>
                        <div class="Cont">
                            <h2 id="h2" style="text-align: left;font-size:100px; color: burlywood ">${productoEncontrado.getNombreProducto()}</h2>
                            <h3 id="h3" style="text-align: left; margin-top: -20px;">${productoEncontrado.getNombreProducto()}</h3>
                            <br>
                            <h2 id="h2" style="text-align: left;font-size: 20px;">Género: ${productoEncontrado.getGenero()}</h2>
                            <br>
                            <h2  id="h2" style="text-align: left;font-size: 20px;margin-top: -39px;">Categoría: ${productoEncontrado.getNombreCategoria()}</h2>
                            <br>
                            <h2 id="h2" style="text-align: left; font-size: 30px;margin-top: -30px; ">Duración: ${productoEncontrado.getDuracion()}</h2>
                            <br>
                            <h2 id="h2" style="text-align: left; font-size: 40px;margin-top: -30px; ">Precio: Q${productoEncontrado.getPrecio()}</h2>
                            <br>
                            <h2 id="h2">Sinopsis:</h2>
                            <h3  id="h3">${productoEncontrado.getSinopsis()}</h3>      
                        </div>
                        <br>

                    </div>
                    <div id="video-container" style="margin-top: 250px;margin-right: 500px; height: 750px; width: 1200px"></div>
                    <div id="myModal">
                        <div class="modal-content">       
                            <a href="Controlador?menu=Peliculas&accion=Listar" class="btn btn-primary">Comprar Película</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <form action="Controlador?menu=InformacionPelicula&id=${productoEncontrado.getIdProducto()}" method="POST">              
            <div class="p-2 g-col-6">
                <label class="form-label" style="color: white; font-size: 50px;margin-top: 50px; margin-left: 20px">Calificar Película</label>
                <br>
                <div class="container">
                    <div class="rating">                                
                        <input type="radio" name="clr1" id="est5" value="5" style="--c:#ff9933">
                        <input type="radio" name="clr1" id="est4" value="4" style="--c:#ff9933">
                        <input type="radio" name="clr1" id="est3" value="3" style="--c:#ff9933">
                        <input type="radio" name="clr1" id="est2" value="2" style="--c:#ff9933">
                        <input type="radio" name="clr1" id="est1" value="1" style="--c:#ff9933">    
                    </div>
                </div>
            </div>    
            <div class="p-2 g-col-6">
                <script>
                    const radioButtons = document.querySelectorAll('input[type="radio"]');
                    const calificacion = document.getElementById('calificacion');

                    radioButtons.forEach(radio => {
                        radio.addEventListener('click', function () {
                            switch (radio.value) {
                                case '1':
                                    document.getElementById('calificacion').value = `1`;
                                    calificacion.value = `1`;
                                    break;
                                case '2':
                                    document.getElementById('calificacion').value = `2`;
                                    calificacion.value = `2`;
                                    break;
                                case '3':
                                    document.getElementById('calificacion').value = `3`;
                                    calificacion.value = `3`;
                                    break;
                                case '4':
                                    document.getElementById('calificacion').value = `4`;
                                    calificacion.value = `4`;
                                    break;
                                case '5':
                                    document.getElementById('calificacion').value = `5`;
                                    calificacion.value = `5`;
                                    break;
                                default:
                                    calificacion.value = 'Sin calificación';
                                    break;
                            }
                        });
                    });
                </script>
                <br>
                <br>
                <br>
            </div>
            <input type="text" style=" display: none" class="form-control" id="calificacion" name="txtCali">
            <input type="text" style="display: none" value="${usuario.getIdUsuario()}" class="form-control" name="txtidUsua">
            <input type="text" style=" display: none" value="${productoEncontrado.getIdProducto()}" class="form-control" name="txtidProduc">
            <br>
            <label class="form-label" style="color: white; font-size: 30px;margin-top: 10px; margin-left: 30px">Comentario</label>
            <textarea class="form-control" style=" margin-left: 30px; width: 1545px" name="txtRes" rows="5"></textarea>
            <br>
            <center> <input type="submit" name="accion" value="Enviar" class="btn btn-success"> </center>
            <label class="form-label" style="color: white; font-size: 40px;margin-top: 50px; margin-left: 30px">Reseñas:</label>
           
            <c:forEach var="resena" items="${resenas}">
                <c:forEach var="usua" items="${usuarios}">
                    <c:if test="${resenaEncontrada.getIdProducto() == resena.getIdProducto() && resena.getIdUsuario() == usua.getIdUsuario()}">
                        <br>
                        <div style="display: inline-block;"><img id="imagenUsuario" src="img/imgPeliculas/${usua.getFotoPerfil()}" width="100" height="100" style="position: relative; left: 10px; width: 100px; height: 100px; border-radius: 85%; border-color: white; object-fit: cover; margin-left: 30px"></div>
                        <div style="display: inline-block;"><h3 id="h3" style="text-align: left; margin-left: 30px">${usua.getUsuario()}</h3></div>  
                        <br>
                        <br>
                        <div class="rate" data-calificacion="${resena.getCalificacion()}">                                
                            <input type="radio" name="clr1" id="est5" value="5">
                            <input type="radio" name="clr1" id="est4" value="4">
                            <input type="radio" name="clr1" id="est3" value="3">
                            <input type="radio" name="clr1" id="est2" value="2">
                            <input type="radio" name="clr1" id="est1" value="1">
                        </div>
                        <h2 id="h2" style="text-align: left; margin-left: 200px">  | ${resena.getFechaValoracion()}</h2>  
                        <script>
                                var ratingContainers = document.querySelectorAll('.rate');                    
                                document.addEventListener('DOMContentLoaded', function () {
                                ratingContainers.forEach(container => {      
                                    var calificacion = container.getAttribute('data-calificacion');
                                    
                                    // Rellenar estrellas al cargar la página 
                                    fillStars(calificacion, container);

                                    // Función para rellenar las estrellas
                                    function fillStars(count, container) {
                                        container.innerHTML = '';
                                        for (let i = 5; i > 0; i--) {
                                            var star = document.createElement('span');
                                            star.innerHTML = i <= count ? '&#9733;' : '&#9734;'; // Unicode para estrella llena y vacía
                                            container.appendChild(star);
                                        }
                                    }
                                });
                            });
                        </script> 
                        <h3 id="h3" style="text-align: left; margin-left: 50px">${resena.getResena()}</h3>
                        <br>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </form>

        <footer class="footer" style="background-color: black ;">

            <h3 style="padding-left: 50px; color: white">MovieShop</h3>
            <ul>
                <h3 style="padding-left: 350px; color: white">MovieShop</h3>
                <ul>
                    <li><a href="Controlador?menu=Peliculas&accion=Listar" style="padding-right: 20px">Peliculas</a></li>
                    <li><a href="Controlador?menu=Programadores"style="padding-right: 20px">Nosotros</a></li>
                    <li><a href="Controlador?menu=Promociones&accion=Listar"style="padding-right: 20px">Promoción</a></li>
                    <li><a href="Controlador?menu=Cestas&accion=listarId"style="padding-right: 20px">Cesta</a></li>
                </ul>
            </ul>
        </footer>
        <script src="https://www.youtube.com/iframe_api"></script>
        <script>
                    function onYouTubeIframeAPIReady() {
                        var videoContainer = document.getElementById('video-container');
                        var videoUrl = "${productoEncontrado.getTrailer()}";
                        var videoId = extractVideoId(videoUrl);

                        var player = new YT.Player(videoContainer, {
                            videoId: videoId,
                            width: 500,
                            height: 500,
                            playerVars: {
                                autoplay: 0,
                                controls: 1,
                                rel: 0
                            },
                            events: {
                                'onStateChange': onPlayerStateChange
                            }
                        });
                    }
                    function extractVideoId(url) {
                        var videoId = '';
                        var match = url.match(/[?&]v=([^&]+)/);
                        if (match) {
                            videoId = match[1];
                        } else {
                            // Manejar otros formatos de URL de YouTube si es necesario
                        }
                        return videoId;
                    }
                    function onPlayerStateChange(event) {
                        if (event.data == YT.PlayerState.PLAYING) {
                            // Comienza el temporizador cuando el video comienza a reproducirse
                            setTimeout(checkVideoTime, 30000); // 10000 milisegundos = 10 segundos
                        }
                    }
                    function checkVideoTime() {
                        var player = YT.get('video-container');

                        // Verifica si el video ha estado reproduciéndose durante al menos 10 segundos
                        if (player && player.getCurrentTime() >= 30) {
                            // Muestra la ventana emergente (modal)
                            var modal = document.getElementById('myModal');
                            modal.style.display = "block";
                        }
                    }
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

    </body>
</html>
