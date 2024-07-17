<%-- 
    Document   : DetalleDescuento
    Created on : 19/07/2023, 01:23:44 AM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Detalle Descuento</title>
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
    </head>
    <body style="margin: 0; ; background-size: cover">
        <img src="img/FondoColores.gif" alt="" style="width: 100vw; height: 100vh; object-fit: cover; position: fixed; top: 0; left: 0; z-index: -1">

        <div class="w-200 p-3 container w-100 bg-danger mt-5 rounded shadow" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-5 col-xl-8 rounded">
                    <table class="table table-bordered border-primary">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Precio Final</th>
                                <th>Id Descuento</th>
                                <th>Id Producto</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="detallePromocion" items="${detallePromociones}">
                                <tr oncontextmenu = "showPopup(event);">
                                    <td>${detallePromocion.getIdDetallePromocion()}</td>
                                    <td>Q.${detallePromocion.getPrecioFinal()}0</td>
                                    <td>${detallePromocion.getIdPromocion()}</td>
                                    <td>${detallePromocion.getIdProducto()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>              
                </div>

                <style>
                    .popup-overlay {
                        display: none;
                        position: fixed;
                        top: 0;
                        left: 0;
                        width: 100%;
                        height: 100%;
                        background-color: rgba(0, 0, 0, 0.5);
                    }

                    .popup-content {

                        position: fixed;
                        top: 50%;
                        left: 50%;
                        transform: translate(-50%, -50%);
                        background-color: white;
                        padding: 20px;
                        border-radius: 5px;
                    }
                </style>

                <div class="popup-overlay" id="popupOverlay">
                    <div class="popup-content">
                        <!-- Contenido de la ventana emergente -->
                        <p style="text-align: center;">Seleccione la acción que desea realizar:</p>        
                        <div style="display: flex; flex-direction: column; align-items: center;">
                            <a id="btnEditarPopup" href="#btnEditar" style="margin-bottom: 10px;">Editar</a>
                            <a id="btnEliminarPopup" href="#btnEliminar" style="margin-bottom: 10px;">Eliminar</a>
                            <button onclick="hidePopup();">Cerrar</button>
                        </div>
                    </div>
                </div>

                <div style="margin-top: 1px" class="col bg-white col-sm-4 rounded-end float-end">
                    <div class="text-end">
                        <a href="Controlador?menu=PrincipalAdmin"><button type="button" class="btn btn-outline-secondary">Regresar</button></a>

                        <img src="img/MovieshopLogo.png" width="100">
                    </div>
                    <h2 class="fw-bold text-center py-5">DETALLE PROMOCIÓN</h2>

                    <form action="Controlador?menu=DetallePromocion" method="POST">
                        <div class="mb-4">
                            <label class="form-label">Precio Final</label>
                            <input id="txt1" type="text" value="${detallePromocionEncontrado.getPrecioFinal()}" class="form-control" name="txtPrecioFinal">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Promocion</label>
                            <br>
                            <select id="txt2" name="txtIdPromocion" class="form-control">
                                <c:forEach var="detallePromocion" items="${promociones}">
                                    <option value="${detallePromocion.getIdPromocion()}">${detallePromocion.getIdPromocion()} - ${detallePromocion.getPorcentajePromocion()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Producto</label>
                            <br>
                            <select id="txt3" name="txtIdProducto" class="form-control">
                                <c:forEach var="detallePromocion" items="${productos}">
                                    <option value="${detallePromocion.getIdProducto()}">${detallePromocion.getIdProducto()} - ${detallePromocion.getNombreProducto()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input id="btnEnviar" type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <br>
                        <br>    
                    </form>
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
            if (txt1.value.length == 0 || txt2.value.length == 0 || txt3.value.length == 0) {
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
