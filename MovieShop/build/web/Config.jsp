<%-- 
    Document   : Config
    Created on : 19/10/2023, 08:08:55 PM
    Author     : santiago
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=" UTF-8">
        <link rel="icon" href="img/Movieshop.png">
        <meta name="viewport" content="width=decive-width, initial-scale=1.0">
        <title>MovieShop - Configuración</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>        <link rel="stylesheet" href="CSS/Cesta.css">
        <script src="https://kit.fontawesome.com/0492441fbc.js" crossorigin="anonymous"></script>
        <style>
            #h2{
                color: #000000;
                text-align: right;
            }
            #h3{
                color: #0000000;
                text-align: right;
            }
            /* Estilo básico para la ventana de confirmación */
            #customConfirm {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: #fff;
                padding: 20px;
                border: 1px solid #ccc;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
                z-index: 1000;
            }

            #customConfirmMessage {
                margin-bottom: 10px;
            }

            #customConfirmButtons {
                text-align: right;
            }

            #customConfirmButtons button {
                margin-left: 10px;
            }
            .mensaje{
                color: #000000;
                font-size: 30px;
            }
            #confirmYes{
                background:#FF0000;
                color:#fff;
                border:none;
                position:relative;
                height:60px;
                font-size:1.6em;
                padding:0 2em;
                cursor:pointer;
                transition:800ms ease all;
                outline:none;
              }
              #confirmYes:hover{
                background:#fff;
                color:#FF0000;
              }
              #confirmYes:before,#confirmYes:after{
                content:'';
                position:absolute;
                top:0;
                right:0;
                height:2px;
                width:0;
                background: #FF0000;
                transition:400ms ease all;
              }
              #confirmYes:after{
                right:inherit;
                top:inherit;
                left:0;
                bottom:0;
              }
              #confirmYes:hover:before,#confirmYes:hover:after{
                width:100%;
                transition:800ms ease all;
              }
              #confirmNo{
                background:#FF0000;
                color:#fff;
                border:none;
                position:relative;
                height:60px;
                font-size:1.6em;
                padding:0 2em;
                cursor:pointer;
                transition:800ms ease all;
                outline:none;
              }
              #confirmNo:hover{
                background:#fff;
                color:#FF0000;
              }
              #confirmNo:before,#confirmNo:after{
                content:'';
                position:absolute;
                top:0;
                right:0;
                height:2px;
                width:0;
                background: #FF0000;
                transition:400ms ease all;
              }
              #confirmNo:after{
                right:inherit;
                top:inherit;
                left:0;
                bottom:0;
              }
              #confirmNo:hover:before,#confirmNo:hover:after{
                width:100%;
                transition:800ms ease all;
              }
              .confirmation-message{
                  color: #000000;
                  font-size: 50px;
              }
        </style>
        <script>
            function togglePasswordVisibility() {
                var passwordInput = document.getElementById("txtContra");
                var eyeIcon = document.getElementById("eyeIcon");

                if (passwordInput.type === "password") {
                    passwordInput.type = "text";
                    eyeIcon.src = "img/imgPeliculas/Ocultar5.png"; // Ruta de la imagen para ocultar
                } else {
                    passwordInput.type = "password";
                    eyeIcon.src = "img/imgPeliculas/Mostrar.png"; // Ruta de la imagen para mostrar
                }
            }
            document.addEventListener('DOMContentLoaded', function() {
                const customConfirm = document.getElementById('customConfirm');
                const customConfirmMessage = document.getElementById('customConfirmMessage');
                const confirmYesButton = document.getElementById('confirmYes');
                const confirmNoButton = document.getElementById('confirmNo');
                const btnEliminar = document.getElementById('btnEliminar');  // Nuevo id

                function showConfirm(message, callback) {
                    customConfirmMessage.textContent = message;
                    customConfirm.style.display = 'block';

                    confirmYesButton.addEventListener('click', () => {
                        customConfirm.style.display = 'none';
                        callback(true);
                    });

                    confirmNoButton.addEventListener('click', () => {
                        customConfirm.style.display = 'none';
                        callback(false);
                    });
                }

                btnEliminar.addEventListener('click', (event) => {  // Nuevo id
                    showConfirm("¿Estás seguro de eliminar tu cuenta?", (confirmed) => {
                        if(confirmed){
                            
                        }else{
                            customConfirm.style.display = 'none';
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <header class="header">
            <div class="menu container" style="width: 75vw">

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
        <h1 style="text-align: center; font-size: 50px; ">Configuración De Perfíl  </h1>
        <div class="d-flex">
            <div class="col-md-8" style="margin-left: 330px">
                <div class="card">
                    <div class="card-body">
                        <div class="form-group" style="font-size: 50px; background-color: black;">
                            <label style="color: #FFFFFF; border-left: 10px solid #000000; border-right: 750px solid #000000;">
                                Datos Del Usuario
                            </label>
                            <a id="btnEliminar" class="btn btn-outline-danger">Elimina Tu Cuenta</a>
                        </div>
                        <div class="box-container-2">
                            <div class="box-2">
                                <div class="Cont">
                                    <form action="Controlador?menu=Config" method="POST" enctype="multipart/form-data">
                                        <div class="mb-4" style="font-size: 35px">
                                            <label class="form-label">Foto De Perfíl</label>
                                            <a class="dropdown-item" href="#">
                                                <input type="file" value="" name="imgPerfil" class="form-control" style="border-color: #000000; display: inline; width: 900px"/>
                                                <img id="imagenUsuario" src="img/imgPeliculas/${usuarioEncontrado.getFotoPerfil()}" width="300" height="390" style="position: relative; left: 35px; width: 140px; height: 160px; border-radius: 5%; object-fit: cover; box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);" onmouseover="this.style.transform = 'scale(1.1)';" onmouseout="this.style.transform = 'scale(1)';">
                                            </a>
                                            <button type="submit" name="accion" class="btn btn-secondary" value="ActualizarFoto">Actualizar</button>
                                        </div>
                                        <div class="mb-4" style="font-size: 35px">
                                            <label class="form-label">Usuario</label>
                                            <input type="text" value="${usuarioEncontrado.getUsuario()}" name="txtUsuario" class="form-control" style="border-color: #000000" />
                                            <button type="submit" name="accion" class="btn btn-secondary" value="ActualizarUsuario">Actualizar</button>
                                        <div class="mb-4" style="font-size: 35px">
                                            <label class="form-label">Contraseña</label>
                                            <input type="password" value="${usuarioEncontrado.getPass()}" id="txtContra" name="txtContra" class="form-control" style="border-color: #000000" />
                                            <button type="submit" name="accion" class="btn btn-secondary" value="ActualizarPass">Actualizar</button>
                                            <button type="button" onclick="togglePasswordVisibility()" id="toggleBtn" style="margin-top: 5px; border: none">
                                                <img id="eyeIcon" src="img/imgPeliculas/Mostrar.png" alt="Mostrar" height="25px" width="50px">
                                            </button>
                                        </div>
                                        <div class="mb-4" style="font-size: 35px">
                                            <label class="form-label">Email</label>
                                            <input type="text" value="${usuarioEncontrado.getEmail()}" name="txtEmail" class="form-control" style="border-color: #000000" />
                                            <button type="submit" name="accion" class="btn btn-secondary" value="ActualizarEmail">Actualizar</button>
                                        </div>
                                        <div class="mb-4" style="font-size: 35px">
                                            <label class="form-label">Nombre</label>
                                            <input type="text" value="${usuarioEncontrado.getNombreUsuario()}" name="txtNombreUser" class="form-control" style="border-color: #000000" />
                                            <button type="submit" name="accion" class="btn btn-secondary" value="ActualizarNombre">Actualizar</button>
                                        </div>
                                        <div class="mb-4" style="font-size: 35px">
                                            <label class="form-label">Apellido</label>
                                            <input type="text" value="${usuarioEncontrado.getApellidoUsuario()}" name="txtApellidoUser" class="form-control" style="border-color: #000000" />
                                            <button type="submit" name="accion" class="btn btn-secondary" value="ActualizarApellido">Actualizar</button>
                                        </div>
                                        <div id="customConfirm">
                                            <div id="customConfirmMessage" class="confirmation-message"></div>
                                            <br>
                                            <div id="customConfirmButtons">
                                                <center>
                                                    <button id="confirmYes" type="submit" name="accion" value="EliminarUsuario">Sí</button>
                                                    <a id="confirmNo" style="text-decoration: none">No</a>
                                                </center>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>