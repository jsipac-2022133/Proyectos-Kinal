<%-- 
    Document   : Login
    Created on : 13/07/2023, 07:39:10 PM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop - Iniciar Sesión </title>

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
        </script>
    </head>
    <body style="margin: 0; overflow: hidden; background-size: cover">
        <img src="img/FONDOs.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">

        <div class="container w-75 bg-danger mt-5 rounded shadow">
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded">
                    <img src="img/MovieshopLogo.png" width="680">                 
                </div>

                <div class="col bg-white p-5 rounded-end">
                    <div class="text-end">
                        <img src="img/MovieshopLogo.png" width="48" alt="">
                    </div>
                    <h2 class="fw-bold text-center py-5">BIENVENIDO</h2>


                    <form action="Validar" method="POST">
                        <div class="mb-4">
                            <label class="form-label"></label>
                            <input type="text" class="form-control" name="txtUser" placeholder="Usuario" >
                        </div>
                        <div class="mb-4" style="font-size: 35px">

                            <div class="input-group">
                                <input type="password" id="txtContra" name="txtPass" class="form-control" placeholder="Contraseña" />
                                <div class="input-group-append">
                                    <button type="button" onclick="togglePasswordVisibility()" id="toggleBtn" style="margin-left: 10px">
                                        <img id="eyeIcon" src="img/imgPeliculas/Mostrar.png" alt="Mostrar" height="25px" width="50px">
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="mb-4">
                            <input type="checkbox" name="connected" class="form-check-input">
                            <label for="connecter" class="form-check-label">Mantenerme Conectado</label>
                        </div>

                        <div class="d-grid">
                            <button type="submit" name="accion" value="Ingresar" class="btn btn-primary">Iniciar Sesión</button>
                        </div>

                        <div>
                            <br> 
                            <p>No tienes cuenta? <a href="Controlador?menu=AgregarUsuarios">Registrate</a></p> <br> <br> 
                        </div> 
                    </form>


                    <div class="container w-100 my-5">
                        <div class="row text-center">
                            <div class="col-12">Iniciar Sesión</div>    
                        </div>
                        <div class="row" >
                            <div class="col" >
                                <button class="btn btn-outline-primary w-100 my-1" >
                                    <a href="Controlador?menu=Facebook">
                                        <div class="row align-items-center">
                                            <div class="col-2 d-none d-md-block">
                                                <img src="img/FacebookLogin.png" width="32" alt="">
                                            </div>
                                            <div class="col-10 text-center" hr >
                                                Facebook
                                            </div>
                                        </div>
                                    </a>
                                </button>
                            </div>
                            <div class="col">
                                <button class="btn btn-outline-danger w-100 my-1">
                                    <a href="Controlador?menu=Google">
                                        <div class="row align-items-center">
                                            <div class="col-2 d-none d-md-block">
                                                <img src="img/LogoGoogle.png" width="32" alt="">
                                            </div>
                                            <div class="col-10 text-center">
                                                Google
                                            </div>
                                        </div>
                                    </a>
                                </button>
                            </div>
                        </div>   
                    </div>
                </div>
            </div>
        </div>





        <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>

</html>
