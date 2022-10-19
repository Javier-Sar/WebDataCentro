<%-- 
    Document   : solicitud_usuario
    Created on : 13 ago 2022, 10:16:07
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud de Usuario</title>

        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="conteiner text-center">
            <h3>Registro de nueva persona</h3>
            <p>Para el ingreso de una nueva persona al sistema asegurese de ingresar todos
                los datos requeridos</p>
        </div>
        <div class="container">
            <form action="Procesamiento">
                <label for="fname">Primer Nombre</label>
                <input type="text" id="fname" name="nombre" placeholder="Tu nombre ...">
                <label for="fname">Segundo Nombre</label>
                <input type="text" id="fname" name="nombre" placeholder="Tu nombre ...">

                <label for="lname">Primer Apellido</label>
                <input type="text" id="lname" name="apellido" placeholder="Tu apellido ...">
                <label for="lname">Segundo Apellido</label>
                <input type="text" id="lname" name="apellido" placeholder="Tu apellido ...">
                
                <label for="lname">Dpi</label>
                <input type="text" id="lname" name="dpi" placeholder="Tu DPI ...">
                
                <label for="lname">Dependencia</label>
                <input type="text" id="lname" name="dependencia" placeholder="Tu dependencia ...">
                
                <label for="lname">Corporativo</label>
                <input type="text" id="lname" name="corporativo" placeholder="Corporativo ...">
                

                <label for="country">Rol deseado</label>
                <select id="country" name="rol">
                    <option value="1">ADMINISTRADOR</option>
                    <option value="2">OPERADOR</option>
                    <option value="3">USUARIO</option>
                    <option value="4">MONITOREO</option>
                </select>
                
                
                
                <p></p>
                <label for="subject">Comentarios</label>
                <textarea id="subject" name="comentarios" placeholder="Comentarios (256 max)..." style="height:200px"></textarea>

                <input type="submit" value="SOLICITAR">
            </form>
        </div>

    </body>




</html>

