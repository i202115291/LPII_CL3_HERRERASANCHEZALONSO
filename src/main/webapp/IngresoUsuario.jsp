<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ingresar al Sistema</title>
    <style>
        body {
            background-color: #c5dec9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .login-container {
            text-align: center;
            border: 1px solid #ccc;
            padding: 20px;
            background: #fff;
            border-radius: 10px;
        }
        input[type="text"], input[type="password"] {
            display: block;
            margin: 10px auto;
            padding: 10px;
            width: 80%;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Ingresar al Sistema</h2>
        <form action="ControladorUsuario" method="post">
            <label for="usuario">Usuario</label>
            <input type="text" id="usuario" name="usuario" required>
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" required>
            <input type="submit" value="Ingresar">
        </form>
    </div>
</body>
</html>
