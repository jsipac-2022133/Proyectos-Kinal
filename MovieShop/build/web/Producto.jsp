<%-- 
    Document   : Producto
    Created on : 16/07/2023, 03:58:22 PM
    Author     : SIPAC
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/Movieshop.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>MovieShop - Películas</title>
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



        <div class="w-200 p-5  w-200 bg-danger mt-4 rounded shadow" style="width: 2000px; position: relative; left: 60px" >
            <div class="row align-items-stretch">
                <div class="col d-none d-lg-block col-md-5 col-lg-2 col-xl-8 rounded">
                    <table class="table table-hover" style="position: relative; right: 20px; top: 10px">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Película</th>
                                <th>Género</th>
                                <th>Categoría</th>
                                <th>Precio</th>
                                <th>Duración</th>
                                <th>Sinopsis</th>
                                <th>Portada</th>
                                <th>Trailer</th>
                                <th>Proveedor</th>  
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>     
                            <c:forEach var="producto" items="${productos}">
                                <tr oncontextmenu="showPopup(event);">
                                    <td>${producto.getIdProducto()}</td>
                                    <td>${producto.getNombreProducto()}</td>                
                                    <td>${producto.getGenero()}</td>
                                    <td>${producto.getNombreCategoria()}</td>
                                    <td>Q.${producto.getPrecio()}0</td>
                                    <td>${producto.getDuracion()}</td>
                                    <td>${producto.getSinopsis()}</td>
                                    <td><img src="img/imgPeliculas/${producto.getPortada()}" width="100" height="120"></td>
                                    <td>${producto.getTrailer()}</td>
                                    <td>${producto.getIdProveedor()}</td>
                                    <td>
                                        <a class="btn btn-warning" id="btnEditar"  href="Controlador?menu=Producto&accion=Editar&idProducto=${producto.getIdProducto()}">Editar</a>
                                        <a class="btn btn-danger" id="btnEliminar"  href="Controlador?menu=Producto&accion=Eliminar&idProducto=${producto.getIdProducto()}">Eliminar</a>



                                    </td>
                                </tr>



                            </c:forEach>
                        </tbody>
                    </table>              
                </div>    



                <div style="margin-top: 10px; position: relative;  right: 10px" class="col bg-white col-sm-4 rounded-end float-end">
                    <div class="text-end">
                        <a href="Controlador?menu=PrincipalAdmin"><button type="button" class="btn btn-outline-secondary">Regresar</button></a>
                        <img src="img/MovieshopLogo.png" width="48" alt="">
                    </div>
                    <h2 class="fw-bold text-center py-5">PELÍCULAS</h2>





                    <form action="Controlador?menu=Producto" method="POST" enctype="multipart/form-data">      
                        <input type="hidden" name="txtIdProducto" value="${productoEncontrado.getIdProducto()}">



                        <div class="mb-4">
                            <label class="form-label">Nombre Película</label>
                            <input id="txt1" type="text" value="${productoEncontrado.getNombreProducto()}" class="form-control" name="txtNombreProducto">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Género</label>
                            <input id="txt2" type="text" value="${productoEncontrado.getGenero()}" class="form-control" name="txtGenero">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Seleccionar Categoría</label>
                            <br>
                            <select id="txt9" name="cmbIdCategoria" class="form-control" id="cmbIdProveedor">
                                <c:forEach var="producto" items="${categorias}">
                                    <option id="deshabilitar" value="${producto.getIdCategoria()}">${producto.getNombreCategoria()}</option>          
                                </c:forEach>
                            </select>
                            <br>
                            <label>Categoria Actual</label>
                            <input id="txt3" type="text" value="${productoEncontrado.getNombreCategoria()}" class="form-control" name="txtCategoria">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Precio</label>
                            <input id="txt4" readonly type="text" value="${productoEncontrado.getPrecio()}" class="form-control" name="txtPrecio">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Tiempo de duración</label>
                            <input id="txt5" type="text" value="${productoEncontrado.getDuracion()}" class="form-control" name="txtDuracion">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Sinopsis</label>
                            <input id="txt6" type="text" value="${productoEncontrado.getSinopsis()}" class="form-control" id="exampleFormControlTextarea1" rows="3" name="txtSinopsis" wrap="soft">
                        </div>
                        <div class="mb-4">
                            <label>Portada</label>
                            <input id="txt7" type="file" value="${productoEncontrado.getPortada()}" name="imgPortada">
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Trailer</label>
                            <input id="txt8" type="text" value="${productoEncontrado.getTrailer()}" class="form-control" id="exampleFormControlTextarea1" rows="3" name="txtTrailer" wrap="soft">
                        </div>



                        <div class="mb-4">
                            <label class="form-label">Proveedor</label>
                            <br>
                            <select id="txt9" name="cmbIdProveedor" class="form-control" id="cmbIdProveedor">
                                <c:forEach var="producto" items="${proveedores}">
                                    <option id="deshabilitar" value="${producto.getIdProveedor()}">${producto.getNombreProveedor()}</option>          
                                </c:forEach>
                            </select>
                            <br>
                            <br>
                            <input id="btnEnviar" type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input id="btnActualizar" type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </div>

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
            if (txt1.value.length == 0 || txt2.value.length == 0 || txt3.value.length == 0 || txt4.value.length == 0 || 
                txt5.value.length == 0 || txt6.value.length == 0 || txt7.value.length == 0 || txt8.value.length == 0 || txt9.value.length == 0) {
                showAlert("Debe llenar todos los campos");
                event.preventDefault();
            }
        });

        btnActualizar.addEventListener('click', (event) => {
            if (txt1.value.length == 0 || txt2.value.length == 0 || txt3.value.length == 0 || txt4.value.length == 0 || 
                txt5.value.length == 0 || txt6.value.length == 0 || txt8.value.length == 0 || txt9.value.length == 0) {
                showAlert("Debe llenar todos los campos");
                event.preventDefault();
            }
        });
    </script>
                        
        <script>
            document.getElementById('btnEditar').addEventListener('click', function () {
                document.getElementById('deshabilitar').disabled = true;
            });
        </script>

        <script src="https://code.jquery.com/jquery-5.3.0.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>



</html>