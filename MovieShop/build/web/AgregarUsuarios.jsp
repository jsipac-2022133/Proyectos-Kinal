<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop - Crear Cuenta</title>
        <style>            
            .custom-alert {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: gray; 
                padding: 20px;
                text-align: center;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
                z-index: 9999;
            }

            
            .custom-alert-content {
                color: white; 
            }

            
            #customAlertClose {
                background-color: #333;
                color: white;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
                margin-top: 10px;
                border-radius: 5px;
            }

        </style>
        <script>
    function togglePasswordVisibility() {
        var passwordInput = document.getElementById("txt4");
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
    <body style="margin: 0; background-size: cover">
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
                    <h2 class="fw-bold text-center py-5">CREAR CUENTA</h2>


                    <form action="Controlador?menu=Usuario" method="POST" enctype="multipart/form-data">
                        <div class="mb-4">
                            <label class="form-label">Nombres</label>
                            <input id="txt1" type="text" class="form-control" name="txtNombres" placeholder="Nombres">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Apellidos</label>
                            <input id="txt2" type="text" class="form-control" name="txtApellidos" placeholder="Apellidos">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Usuario</label>
                            <input id="txt3" type="text" class="form-control" name="txtUsuario" placeholder="Usuario">
                        </div>
   <div class="mb-4" style="display: flex; flex-direction: column;">
    <label class="form-label">Contraseña</label>
    <div style="display: flex; align-items: center;">
        <input id="txt4" type="password" class="form-control" name="txtPass" placeholder="Contraseña" style="flex: 1;">
        <button type="button" onclick="togglePasswordVisibility()" id="toggleBtn" style="margin-left: 5px;">
            <img id="eyeIcon" src="img/imgPeliculas/Mostrar.png" alt="Mostrar" height="25px" width="50px">
        </button>
    </div>
</div>


                        <div class="mb-4">
                            <label class="form-label">Email</label>
                            <input id="txt5" type="text" class="form-control" name="txtEmail" id="txtEmail" placeholder="Email">
                        </div>
                        <div class="mb-4">
                            <label>Foto de Perfil</label> <br>
                            <input type="file" value="#" name="imgFotoPerfil">
                        </div>
                        <div class="d-grid">
                            <button id="btnEnviar" type="submit" name="accion" value="Agregar" class="btn btn-primary">Crear Cuenta</button>
                        </div>
                    </form>                           
                </div>
            </div>
        </div>
    </div>

    <!-- Esto es para el nuevo alert de cerrar -->
    <div id="customAlert" class="custom-alert">
        <div class="custom-alert-content">
            <p id="customAlertMessage"></p>
            <button id="customAlertClose">Cerrar</button>
        </div>
    </div>



    <script>
        const customAlert = document.getElementById('customAlert');
        const customAlertMessage = document.getElementById('customAlertMessage');
        const customAlertClose = document.getElementById('customAlertClose');

        function showAlert(message) {
            customAlertMessage.textContent = message;
            customAlert.style.display = 'block';
        }

        customAlertClose.addEventListener('click', () => {
            customAlert.style.display = 'none';
        });

        btnEnviar.addEventListener('click', (event) => {
            if (txt1.value.length == 0 || txt2.value.length == 0 || txt3.value.length == 0 || txt4.value.length == 0 || txt5.value.length == 0) {
                showAlert("Debe llenar todos los campos");
                event.preventDefault();
            }
        });


    </script>
    <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>

</html>