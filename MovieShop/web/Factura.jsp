<%-- 
    Document   : Factura
    Created on : 12/09/2023, 09:42:38 PM
    Author     : SIPAC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factura de Venta de Películas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .header {
            text-align: center;
            background-color: #333;
            color: #fff;
            padding: 10px;
        }

        .invoice-details {
            text-align: right;
        }

        .invoice-details p {
            margin: 5px 0;
        }

        .invoice-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .invoice-table th, .invoice-table td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        .invoice-table th {
            background-color: #333;
            color: #fff;
        }

        .total {
            text-align: right;
            margin-top: 20px;
            font-weight: bold;
        }

        @media print {
            .print-button {
                display: none;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Factura de Venta de Películas</h1>            
        </div>
        <div class="invoice-details">
            <label>Fecha de Compra:</label>
            <input type="date" class="form-control" style="margin-bottom: 10px;" id="fechaPago" name="txtDate">
            <br>
            <label>Número de factura:</label>
            <input style="width: 100px" type="text" id="numeroFactura" value="" readonly>
        </div>
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>Descripción</th>
                    <th>Cantidad</th>
                    <th>Precio Unitario</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="cesta" items="${cestas}">
                            <c:forEach var="usuario" items="${usuarios}">
                                <c:forEach var="producto" items="${productos}">
                                    <c:if test="${producto.getIdProducto() == cesta.getIdProducto() && cesta.getIdUsuario() == usuario.getIdUsuario()}">
                                    
                                        <tr>
                                            <td>${producto.getNombreProducto()}</td>
                                            <td>${cesta.getCantidad()}</td>
                                            <td>Q.${producto.getPrecio()}</td>
                                            <td>${producto.getPrecio()} </td>
                                        </tr>
                                     
                                              
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>     
            </tbody>
        </table>
        <div class="total">
            <p>Total a Pagar: Q.${subtotal}</p>
        </div>
    </div>

    <!-- <button class="print-button" onclick="window.print()">Imprimir</button> -->

     <script>
            // Esto sirve para asginar la fecha actual 
            var fechaActual = new Date().toISOString().slice(0, 10);

            //Aquí se asigna
            document.getElementById("fechaPago").value = fechaActual;
        </script>
    
        <script>
    // Función para generar un número aleatorio de 5 dígitos
    function generarNumeroFactura() {
        const numeroAleatorio = Math.floor(10000 + Math.random() * 90000); // Genera un número aleatorio entre 10000 y 99999
        return numeroAleatorio;
    }

    // Obtiene el elemento input por su id
    const inputNumeroFactura = document.getElementById('numeroFactura');

    // Asigna el número generado al valor del input
    inputNumeroFactura.value = generarNumeroFactura();
</script>

        
    <script>
      // Luego de cargar la página, inicia automáticamente la impresión
      window.onload = function () {
          window.print();
      }
  </script>
</body>
</html>

