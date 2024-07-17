<%-- 
    Document   : Correo
    Created on : 31/08/2023, 09:15:48 AM
    Author     : SIPAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

        <title>Verificación</title>
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
                    <h2 class="fw-bold text-center py-5">Verifica tu Correo</h2>
                    <h6 class="text-center">Te hemos mandado un correo para asegurarnos que hayas puesto bien tu correo electronico</h6>
                    <br>

                    <form action="${emailUsuario}" target="_blank" method="POST" enctype="multipart/form-data">
                        <div class="mb-4">                            
                            <input type="text"  name="Bienvenida" value="Hola ${nombreUsuario}, te saludamos desde MovieShop. Te Enviamos este correo para verificar que has sido tú el que ha creado su cuenta. Ahora, disfruta de las grandiosas películas y series que tenemos para ti 🎬 🍿 🎥." style="display: none;">                             
                             
                        </div>                            
                        
                        
                        <div class="d-grid">
                            <button type="submit" value="Agregar" class="btn btn-primary">VERIFICA TU CUENTA</button>

                        </div>
                    </form>     
                    <br>
                    <br>
                    <br>
                    <br>

                    <form action="Controlador?menu=Index" target="_blank" method="POST" enctype="multipart/form-data">
                        <div class="d-grid">
                            <button type="submit" name="accion" value="Agregar" class="btn btn-primary">INICIAR</button>
                        </div>
                    </form>                           
                </div>
            </div>
        </div>
    </div>

</body>
</html>
