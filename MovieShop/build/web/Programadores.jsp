<%-- 
    Document   : Programadores
    Created on : 5/09/2023, 04:18:33 PM
    Author     : SIPAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <!-- add your css file -->
        <link rel="stylesheet" href="CSS/Programadores.css" />

        <title>Programadores de MovieShop</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Lobster&family=Montserrat:ital,wght@0,700;1,400&display=swap');
            * {
                margin: 0;
                padding: 0;
            }
            html,
            body {
                height: 100%;
                touch-action: none;
            }
            body{
                overflow: hidden;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                background: #111;
                -webkit-perspective: 1000px;
                perspective: 1000px;
                -webkit-transform-style: preserve-3d;
                transform-style: preserve-3d;
            }
            #dragcontainer,
            #spincontainer{
                position: relative;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                margin-left: 300px;
                margin: auto;
                -webkit-transform-style: preserve-3d;
                transform-style: preserve-3d;
                -webkit-transform: rotateX(-10deg);
                transform: rotateX(-10deg);
            }

            #dragcontainer img{
                -webkit-transform-style: preserve-3d;
                transform-style: preserve-3d;
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                line-height: 200px;
                font-size: 50px;
                text-align: center;
                -webkit-box-shadow: 0 0 8px #fff;
                box-shadow: 0 0 8px #fff;
                -webkit-box-reflect: below 10px linear-gradient(transparent, transparent, #0005);
            }


            #dragcontainer img:hover{
                -webkit-box-shadow: 0 0 15px #fffd;
                box-shadow: 0 0 15px #fffd;
                -webkit-box-reflect: below 10px linear-gradient(transparent, transparent, #0007);
            }



            #dragcontainer p{
                font-family: 'Courier New', Courier, monospace;
                position: absolute;
                font-size: 50px;
                top: 100%;
                left: 50%;
                -webkit-transform: translate(-50%, -50%) rotateX(90deg);
                transform: translate(-50%, -50%) rotateX(90deg);
                color: #fff;    
            }



            #ground{
                width: 900px;
                height: 900px;
                position: absolute;
                top: 100%;
                left: 50%;
                -webkit-transform: translate(-50%, -50%) rotateX(90deg);
                transform: translate(-50%, -50%) rotateX(90deg);
                background: -webkit-radial-gradient(center center, farthest-side, #9993, transparent);
            }





            @-webkit-keyframes spin{
                from{
                    -webkit-transform: rotateY(0deg);
                    transform: rotateY(0deg);
                }
                to{
                    -webkit-transform: rotateY(360deg);
                    transform: rotateY(360deg);
                }
            }

            @keyframes spin{
                from{
                    -webkit-transform: rotateY(0deg);
                    transform: rotateY(0deg);
                }
                to{
                    -webkit-transform: rotateY(360deg);
                    transform: rotateY(360deg);
                }
            }

            @-webkit-keyframes spinrevert{

                from{
                    -webkit-transform: rotateY(0deg);
                    transform: rotateY(0deg);
                }
                to{
                    -webkit-transform: rotateY(360deg);
                    transform: rotateY(360deg);
                }
            }

            @keyframes spinrevert{
                from{
                    -webkit-transform: rotateY(360deg);
                    transform: rotateY(360deg);
                }
                to{
                    -webkit-transform: rotateY(0deg);
                    transform: rotateY(0deg);
                }
            }


            /* CSS */
            .tooltip {
                position: relative;
                cursor: pointer;
                display: inline-block;
            }



            .tooltip img {

                width: 100%;

                height: auto;

            }



            .tooltip .tooltiptext {

                visibility: hidden;

                width: 200px;

                height: 50px;

                background-color: white;

                color: black;

                padding: 10px;

                border-radius: 2px;

                white-space: nowrap;

                text-align: center;

                position: absolute;

                bottom: 100%;

                left: 50%;

                transform: translateX(-50%);

                z-index: 1;

                opacity: 0;

                transition: opacity 0.2s;

            }



            .tooltip:hover .tooltiptext {

                visibility: visible;

                opacity: 1;

            }



            #movieshop-info {

                font-family: 'Roboto', sans-serif;

                display: flex;

                justify-content: space-between;

                align-items: center;

                padding: 20px;

                background-color: #111;

                color: #fff;

                margin-left: 10px;

                width: 40%;

            }





            #movie-description {

                flex: 1;

                padding: 20px;

            }



            #movie-description h2 {

                font-size: 24px;

                margin-bottom: 10px;

            }



            #movie-description p {

                font-size: 16px;

                line-height: 1.5;

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

            .header{
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

            .box-container-1,
            .box-container-2,
            .box-container-3{
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 40x;
            }

            .box-1, 
            .box-2,
            .box-3{
                border-radius: 5px;
                z-index: 1000;
                display: none;
            }

            .box-1:nth-child(1),
            .box-1:nth-child(2),
            .box-1:nth-child(3),
            .box-1:nth-child(4){
                display: inline-block;
            }

            .box-2:nth-child(1),
            .box-2:nth-child(2),
            .box-2:nth-child(3),
            .box-2:nth-child(4){
                display: inline-block;
            }

            .box-3:nth-child(1),
            .box-3:nth-child(2),
            .box-3:nth-child(3),
            .box-3:nth-child(4){
                display: inline-block;
            }

            .load-more{
                margin-top: 40px;
                display: inline-block;
                padding: 10px 25px;
                border-radius: 15px;
                border: 1px solid #ff2f28;
                color: #ff2f28;
                font-size: 16px;
                cursor: pointer;
                align-self: flex-end;
            }

            .load-more:hover{
                background-color: #ff2f28;
                color: #ffffff;
            }

            /* .content img{
                width: 100%;
                margin-bottom: 15px;
            
            } */

            .content h3{
                font-size: 20px;
                margin-bottom: 10px;
            }

            .content{
                color: #cfcfcf;
                font-size: 20px;

            }

            .footer{
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 100px 0;
                margin-top: 100px;
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

                .footer{
                    margin-top: 30px;
                    padding: 30px;
                    flex-direction: column;
                    text-align: center;
                }

                .footer ul{
                    margin-top: 15px;
                    justify-content: center;

                }
            }


        </style>
    </head>

    <body style="background-color: #cfcfcf
          ">
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
            </div>


                
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
        </header>    
        <div id="dragcontainer" >
            <div id="spincontainer" >
                <img src="img/imgProgramadores/scrum.jpeg" alt="">
                <img src="img/imgProgramadores/james.jpeg" alt="">
                <img src="img/imgProgramadores/sergio.jpeg" alt="">
                <img src="img/imgProgramadores/bachac.jpeg" alt="">
                <img src="img/imgProgramadores/josue.jpeg" alt="">
                <img src="img/imgProgramadores/ruben.jpeg" alt="">
                <img src="img/imgProgramadores/joshua.jpeg" alt="">
                <img src="img/imgProgramadores/miguel.jpeg" alt="">
                <img src="img/imgProgramadores/scrum2.jpeg" alt="">    
                <p style="color: black">Programadores de MovieShop</p>
            </div>
            <div id="ground">
            </div>
        </div>  
        <div id="movieshop-info">

            <div id="movie-poster">
            </div>
            <div id="movie-description">
                <h2>¡Bienvenido a Movieshop!</h2>
                <p>
                    En Movieshop, te damos la bienvenida a un mundo lleno de entretenimiento cinematográfico y televisivo sin límites. Nuestra plataforma te brinda la oportunidad de disfrutar de una amplia selección de películas y series en línea, todo en un solo lugar y a tu alcance.
                </p>
                <br>
                <p>
                    Descubre una biblioteca repleta de títulos que abarcan géneros para todos los gustos, desde emocionantes películas de acción y aventuras hasta conmovedoras historias románticas, pasando por intrigantes series de misterio y suspenso. Sea cual sea tu preferencia, en Movieshop encontrarás algo que te atrape.
                </p>
                <br>
                <p>
                    Navega por nuestro catálogo y explora las últimas novedades o revive clásicos atemporales. Con Movieshop, la diversión está al alcance de tus manos, en cualquier momento y en cualquier lugar.
                </p>
                <br>
                <p>
                    Así que prepárate para sumergirte en el emocionante mundo del cine y la televisión desde la comodidad de tu hogar. ¡Disfruta de Movieshop y sumérgete en un océano de historias cautivadoras!
                </p>
                <br>
                <p>A la izquierda podemos ver a los programadores que hicieron posible este proyecto. 👈 </p>
            </div>
        </div>
        <!-- add your js file -->

        <script src="CSS/Programadores.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
