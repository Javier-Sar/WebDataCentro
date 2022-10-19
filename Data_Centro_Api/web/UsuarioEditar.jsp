<%-- 
    Document   : RstPrs
    Created on : 30 ago 2022, 20:39:08
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Persona</title>
        <jsp:include page="EsqumaNav.jsp" />
        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="text-center">
            <h3>Registro de nueva persona</h3>
            <p>Para el ingreso de una nueva persona al sistema asegurese de ingresar todos
                los datos requeridos</p>
        </div>
        <div class="container">
            <form action="Procesamiento">
                <label for="fname"><b>Usuario</b></label>
                <input type="text" id="fname" name="nombre" 
                       placeholder="Tu nombre ..." value="${u.getUsuario()}">

                
                <label for="country"><b>Rol Actual: ${u.getRol()}</b></label><br><br>
                <label for="country"><b>Rol Nuevo</b></label>
                <select id="country" name="rol">
                    <option value="1">ADMINISTRADOR</option>
                    <option value="2">OPERADOR</option>
                    <option value="3">USUARIO</option>
                    <option value="4">MONITOREO</option>
                </select>
                
                      <label for="Estado"><b>Estado actual:  ${u.getEstado()}</b></label><br><br><!-- comment -->
                      <label for="country"><b>Estado</b></label>
                <select id="country" name="estado">
                    <option value="1">ACTIVO</option>
                    <option value="2">INACTIVO</option>
                 </select>


                <p></p>
                <label for="subject">Comentarios</label>
                <textarea id="subject" name="comentarios" placeholder="Comentarios (256 max)..." style="height:200px"></textarea>

                 <div class="d-grid gap-1 container">

            <a type="submit" class="btn btn-success btn-block" href="Sev_Procesamiento?accion=4&Sol=${s.getID_SOLICITUD()}">ACTUALIZAR</a>
            

            <br>
            <br>

        </div>
            </form>
        </div>

    </body>




</html>
