<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="model.TblProductocl3" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Producto</title>
    <style>
        body {
            background-color: #c5dec9;
            font-family: Arial, sans-serif;
        }
        h2, h4 {
            text-align: center;
        }
        form {
            margin: 0 auto;
            width: 300px;
            padding: 15px;
            border: 1px solid #000;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #000;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <h2>Registrar Producto</h2>
    <form action="ControladorProducto" method="post">
        <input type="hidden" name="accion" value="Registrar">
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        
        <label for="preciocomp">Precio Compra:</label>
        <input type="number" step="0.01" id="preciocomp" name="preciocomp" required>
        
        <label for="precioven">Precio Venta:</label>
        <input type="number" step="0.01" id="precioven" name="precioven" required>
        
        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" required>
        
        <label for="descrip">Descripción:</label>
        <input type="text" id="descrip" name="descrip" required>
        
        <input type="submit" value="Registrar">
    </form>
    
    <!-- Mensaje de confirmación -->
    <div id="mensajeRegistro" style="text-align: center; margin-top: 15px;">
        <%-- Este espacio será llenado por el servlet con el mensaje --%>
        <%
        String mensaje = (String) request.getAttribute("mensajeRegistro");
        if (mensaje != null) {
        %>
            <p><%= mensaje %></p>
        <%
        }
        %>
    </div>
    
    <h4>Listado de Productos</h4>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio Compra</th>
            <th>Precio Venta</th>
            <th>Estado</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
        <%
        List<TblProductocl3> listadoProductos = (List<TblProductocl3>) request.getAttribute("listadodeproductos");
        if (listadoProductos != null && !listadoProductos.isEmpty()) {
            for (TblProductocl3 producto : listadoProductos) {
        %>
        <tr>
            <td><%= producto.getIdproductoscl3() %></td>
            <td><%= producto.getNombrecl3() %></td>
            <td><%= producto.getPreciocompcl3() %></td>
            <td><%= producto.getPrecioventacl3() %></td>
            <td><%= producto.getEstadocl3() %></td>
            <td><%= producto.getDescripcl3() %></td>
            <td>
                <!-- Formulario para Eliminar -->
                <form action="ControladorProducto" method="get" style="display:inline;">
                    <input type="hidden" name="accion" value="Eliminar">
                    <input type="hidden" name="id" value="<%= producto.getIdproductoscl3() %>">
                    <input type="submit" value="Eliminar">
                </form>
                <!-- Formulario para Actualizar -->
                <form action="ControladorProducto" method="get" style="display:inline;">
                    <input type="hidden" name="accion" value="Actualizar">
                    <input type="hidden" name="id" value="<%= producto.getIdproductoscl3() %>">
                    <input type="submit" value="Actualizar">
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="7" style="text-align: center;">No hay productos registrados.</td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>