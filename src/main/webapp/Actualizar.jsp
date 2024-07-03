<%@ page import="model.TblProductocl3" %>
<%
    TblProductocl3 producto = (TblProductocl3) request.getAttribute("producto");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Actualizar Producto</title>
    <style>
        body {
            background-color: #c5dec9;
            font-family: Arial, sans-serif;
        }
        h2 {
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
        input[type="text"], input[type="number"], textarea, button {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #000;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            padding: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Actualizar Producto</h2>
    <form action="ControladorProducto" method="post">
        <input type="hidden" name="accion" value="Actualizar">
        <input type="hidden" name="id" value="<%= producto.getIdproductoscl3() %>">
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="<%= producto.getNombrecl3() %>" required>
        
        <label for="preciocomp">Precio Compra:</label>
        <input type="number" step="0.01" id="preciocomp" name="preciocomp" value="<%= producto.getPreciocompcl3() %>" required>
        
        <label for="precioven">Precio Venta:</label>
        <input type="number" step="0.01" id="precioven" name="precioven" value="<%= producto.getPrecioventacl3() %>" required>
        
        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" value="<%= producto.getEstadocl3() %>" required>
        
        <label for="descrip">Descripción:</label>
        <textarea id="descrip" name="descrip" required><%= producto.getDescripcl3() %></textarea>
        
        <button type="submit">Actualizar</button>
    </form>
</body>
</html>