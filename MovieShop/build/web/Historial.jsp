<%-- 
    Document   : Historial
    Created on : 25/11/2023, 04:32:12 PM
    Author     : SIPAC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="img/Movieshop.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Historial - MovieShop</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="CSS/Peliculas.css">


        <style>
            .custom-tooltip {
                position: relative;
                display: inline-block;
                cursor: pointer;
            }

            .custom-tooltip .tooltiptext {
                visibility: hidden;
                background-color: #333; 
                color: #fff; 
                font-size: 18px; 
                padding: 10px; 
                width: 200px; 
                border-radius: 6px;
                position: absolute;
                z-index: 1;
                bottom: 50%; 
                left: 50%;
                transform: translateX(-50%);
                opacity: 0;
                transition: opacity 0.3s;
            }

            .custom-tooltip:hover .tooltiptext {
                visibility: visible;
                opacity: 1;
            }
        </style>
        <style>

            #search-input {
                width: 300px; 
                border: none;
                outline: none;
                font-size: 16px;
                background: #ccc; 
                padding: 5px; 
            }

            .search-icon {
                color: #555; 
                margin-right: 10px; 
            }

        </style>

        <%--botón eliminar--%>
        <style>
    .box-2 {
        position: relative;
    }

    .eliminar-button {
        position: absolute;
        top: 10px; 
        right: 10px; 
        background-color: red; 
        color: white; 
        border: none;
        padding: 5px 10px;
        cursor: pointer;
        text-decoration: none;
    }
</style>

    </head>
    <body>

        <header >

            <div class="menu container" style="z-index: 1">

                <a href="Controlador?menu=Principal" class="logo">MovieShop</a>
                <input type="checkbox" id="menu" />

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

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>



        <div class="search-bar container" style="margin-left: 200px">
            <input type="text" id="search-input" placeholder="Buscar película...">
        </div>
        <br>
        <div class="genre-filter" style="margin-left: 330px">
            <label for="genre-select">Seleccionar género:</label>
            <select id="genre-select">
                <option value="">Todos</option>
                <option value="Aventura">Aventura</option>
                <option value="Comedia">Comedia</option>
                <option value="Drama">Drama</option>

            </select>
        </div>

       <section class="movies container">
    <h2>HISTORIAL</h2>
    <hr>

    <div class="box-container-1">
        <c:forEach var="producto" items="${productos}">
            <div class="box-2" data-genre="${producto.getGenero().toLowerCase()}">
                <div class="content">
                    <div class="custom-tooltip">
                        <a href="Controlador?menu=InformacionPelicula&accion=Editar&idProducto=${producto.getIdProducto()}">
                            <img src="img/imgPeliculas/${producto.getPortada()}" width="250" height="370">                            
                        </a>                        
                        <a class="eliminar-button" href="Controlador?menu=Historial&accion=Eliminar&idProducto=${producto.getIdProducto()}">x</a>
                    </div>
                    <h3 style="font-size: 30px;">${producto.getNombreProducto()}</h3>
                </div>
            </div>
        </c:forEach>
    </div>
</section>






        <footer class="footer container">

            <h3>MovieShop</h3>
            <ul>
                <li><a href="#">Inicio</a></li>
                <li><a href="#">Nosotros</a></li>
                <li><a href="#">Películas</a></li>
                <li><a href="#">Contacto</a></li>
                <li><div class="rw-ui-container"></div></li>
            </ul>
        </footer>


<script>
   document.addEventListener("DOMContentLoaded", function () {
    let boxes = [...document.querySelectorAll('.box-container-1 .box-2')];

    for (var i = 0; i < boxes.length; i++) {
        boxes[i].style.display = 'inline-block';
    }
});

</script>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const searchInput = document.getElementById("search-input");
                const movieBoxes = document.querySelectorAll('.box-container-1 .box-2');

                searchInput.addEventListener("input", function () {
                    const searchTerm = searchInput.value.toLowerCase();
                    for (let i = 0; i < movieBoxes.length; i++) {
                        const movieName = movieBoxes[i].querySelector("h3").textContent.toLowerCase();
                        if (movieName.includes(searchTerm)) {
                            movieBoxes[i].style.display = "inline-block";
                        } else {
                            movieBoxes[i].style.display = "none";
                        }
                    }
                });
            });

        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const genreSelect = document.getElementById("genre-select");
                const movieBoxes = document.querySelectorAll('.box-container-1 .box-2');

                genreSelect.addEventListener("change", function () {
                    const selectedGenre = genreSelect.value.toLowerCase();

                    for (let i = 0; i < movieBoxes.length; i++) {
                        const movieGenre = movieBoxes[i].getAttribute("data-genre").toLowerCase();

                        if (selectedGenre === "" || selectedGenre === movieGenre) {
                            movieBoxes[i].style.display = "inline-block";
                        } else {
                            movieBoxes[i].style.display = "none";
                        }
                    }
                });
            });

        </script>        
        

        <!-- Esto es para la calificación de la página -->
        <script type="text/javascript">(function (d, t, e, m) {

                // Async Rating-Widget initialization.
                window.RW_Async_Init = function () {

                    RW.init({
                        huid: "493924",
                        uid: "e1a737a602522207d717556325282e06",
                        source: "website",
                        options: {
                            "advanced": {
                                "font": {
                                    "hover": {
                                        "color": "#FFFFFF"
                                    },
                                    "size": "24px",
                                    "color": "#FFFFFF"
                                }
                            },
                            "size": "large",
                            "label": {
                                "background": "#000000"
                            },
                            "lng": "es",
                            "style": "oxygen",
                            "isDummy": false
                        }
                    });
                    RW.render();
                };
                // Append Rating-Widget JavaScript library.
                var rw, s = d.getElementsByTagName(e)[0], id = "rw-js",
                        l = d.location, ck = "Y" + t.getFullYear() +
                        "M" + t.getMonth() + "D" + t.getDate(), p = l.protocol,
                        f = ((l.search.indexOf("DBG=") > -1) ? "" : ".min"),
                        a = ("https:" == p ? "secure." + m + "js/" : "js." + m);
                if (d.getElementById(id))
                    return;
                rw = d.createElement(e);
                rw.id = id;
                rw.async = true;
                rw.type = "text/javascript";
                rw.src = p + "//" + a + "external" + f + ".js?ck=" + ck;
                s.parentNode.insertBefore(rw, s);
            }(document, new Date(), "script", "rating-widget.com/"));</script>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script src="//code.tidio.co/zsd5io1qpp2eqcfntesfezgbrfomvnpm.js" async></script>
    </body>
</html>