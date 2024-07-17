<%-- 
    Document   : Promocion
    Created on : 17/07/2023, 09:13:36 PM
    Author     : Compu Fire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop - Promocion</title>
        <style>
            body {
                margin: 0;
                font-family: Arial, sans-serif;
            }

            .imagen-container {
                position: relative;
            }

            #imagenAgrandar {
                width: 100%;
                height: auto;
                cursor: pointer;
                transition: transform 0.3s ease-in-out;
            }

            .overlay {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(0, 0, 0, 0.7);
                display: none;
                justify-content: center;
                align-items: center;
            }

            .imagen-agrandada {
                transform: scale(1.5); /* Puedes ajustar el valor según tus necesidades */
            }

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
            #imagen-container {
                text-align: center;
            }
            #mensaje {
                display: none;
                color: #000000;
            }
        </style>
    </head>
    <body style="margin: 0; ; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">       

        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow">
            <div class="row align-items-stretch">               
                <div class="col-md-4 col-lg-4 col-xl-4 bg-white" style="border-radius: 15px;">
                    <div class="row">
                        <div class="col-md-9">
                            <h2 class="fw-bold text-center py-5">PROMOCIÓN</h2> 
                        </div>
                        <div class="col-md-5">
                            <a href="Controlador?menu=PrincipalAdmin"><button type="button" class="btn btn-outline-secondary">Regresar</button></a> 
                            <img src="img/MovieshopLogo.png" width="150" alt="">
                        </div>
                    </div>
                    <div class="row">                       
                        <div class="col-md-12">            
                            <form action="Controlador?menu=Promocion" method="POST" enctype="multipart/form-data"> 
                                <div class="mb-4">
                                    <label class="form-label">Foto Promocional</label>
                                    <img id="miImagen" src="img/imgPeliculas/${promocionEncontrada.getCartelPromocion()}" alt="Ninguna promocion seleccionada" width="300" height="390" style="position: relative; left: 35px; width: 140px; height: 160px; border-radius: 5%; object-fit: cover; box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);" onmouseover="this.style.transform = 'scale(1.1)';" onmouseout="this.style.transform = 'scale(1)';">
                                    <input id="txt1" class="form-control" name="imgCartel" type="file" min="0" placeholder="Inserte una imagenn">
                                </div>
                                <div class="mb-4">
                                    <label>Categoria</label>
                                    <select id="txt9" name="cmbIdCategoria" class="form-control" id="cmbIdCategoria">
                                        <c:forEach var="promociones" items="${categorias}">
                                            <option id="deshabilitar" value="${promociones.getIdCategoria()}">${promociones.getNombreCategoria()}</option>     
                                        </c:forEach>
                                    </select>
                                    <br>
                                    <label>Categoría Activa</label>
                                    <input type="text" class="form-control" value="${promocionEncontrada.getNombreCategoria()}">
                                </div>
                                <div class="mb-4">
                                    <label class="form-label">Descuento</label>
                                    <input id="txt1" class="form-control" name="txtDescuento" value="${promocionEncontrada.getPorcentajePromocion()}" type="number" min="0" placeholder="Ingrese el proncentaje de descuento">
                                </div>
                                <div class="mb-4">
                                    <label class="form-label">Fecha de inicio</label>
                                    <input id="txt2" class="form-control" type="date" value="${promocionEncontrada.getFechaInicio()}" name="dateInicio"/>
                                </div>
                                <div class="mb-4">
                                    <label class="form-label">Fecha de finalización</label>
                                    <input id="txt3" class="form-control" type="date" value="${promocionEncontrada.getFechaFinal()}" name="dateFinal"/>
                                </div>
                                <div>
                                    <input id="btnEnviar" type="submit" name="accion" value="Agregar" class="btn btn-info">
                                    <input id="btnActualizar" type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                </div>
                            </form>        
                        </div>                         
                    </div>
                    <div class="row">&nbsp;</div>
                </div>
                <div class="col-md-8 col-lg-8 col-xl-8">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="fw-bold text-center py-3">Promociones Ingresadas</h3> 
                            <table class="table table-bordered border-primary" class="table table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>Id</th>
                                        <th>Imagen Promocional</th>
                                        <th>Categoria</th>
                                        <th>Promocion</th>
                                        <th>Fecha de Inicio</th>
                                        <th>Fecha de Finalización</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>                  
                                <tbody>
                                    <c:forEach var="promocion" items="${promociones}">
                                        <tr>
                                            <td>${promocion.getIdPromocion()}</td>
                                    <div class="imagen-container">
                                        <td><img name="imgPromo" src="img/imgPeliculas/${promocion.getCartelPromocion()}" width="100" height="120" alt="Imagen" id="imagenAgrandar"></td>
                                        <div class="overlay" id="overlay"></div>
                                    </div>
                                            <td>${promocion.getNombreCategoria()}</td>
                                            <td>${promocion.getPorcentajePromocion()}%</td>
                                            <td>${promocion.getFechaInicio()}</td>
                                            <td>${promocion.getFechaFinal()}</td> 
                                            <td>                              
                                                <a class="btn btn-warning" href="Controlador?menu=Promocion&accion=Editar&idPromocion=${promocion.getIdPromocion()}">Editar</a>
                                                <a class="btn btn-danger" href="Controlador?menu=Promocion&accion=Eliminar&idPromocion=${promocion.getIdPromocion()}">Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                </tbody>
                            </table>   
                        </div>
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
            if (txt1.value.length == 0 || txt2.value.length == 0 || txt3.value.length == 0 ) {
                showAlert("Debe llenar todos los campos");
                event.preventDefault();
            }
        });
        
            btnActualizar.addEventListener('click', (event) => {
            if (txt1.value.length == 0 || txt2.value.length == 0 || txt3.value.length == 0 ) {
                showAlert("Debe llenar todos los campos");
                event.preventDefault();
            }
        });


    </script>


        <script src="https://code.jquery.com/jquery-3.5.0.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

    </body>

</html>
