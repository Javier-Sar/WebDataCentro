<%-- 
    Document   : DashboardUsr
    Created on : 29 sept 2022, 21:34:23
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">

        <jsp:include page="EsqumaNav.jsp" />
        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
        <title>Dashboard Usuario</title>
    </head>
    <body>


        <div class="container ">



            <div class="container">
                <div class="row">
                    <div class="col-6 col-sm-4">
                        <div class="card" style="height:200px;">
                            <div class="card-body">
                                <h4 class="card-title text-center">FORMULARIO DE INGRESO</h4>
                                <p class="card-text">Formulario para ingreso de 
                                    personal al centro de computo</p>
                                <a href="Sev_Procesamiento?accion=0"
                                   class="btn btn-primary container-fluid">
                                    <b>Ingreso de visita</b></a>
                            </div>
                        </div></div>
                    <div class="col-6 col-sm-4"><div class="card" style="height:200px;">
                            <div class="card-body">
                                <h4 class="card-title text-center">PENDIENTES AUTORIZAR</h4>
                                <p class="card-text">Podra encontrar el listado de
                                    solicitudes con su detalle pendiente de autorizar.</p>
                                <a href="Sev_Procesamiento?accion=1" 
                                   class="btn btn-primary container-fluid">
                                    <b>Visitas pendientes de autorizacion</b></a>
                              
                            </div>
                        </div></div>
                    <div class="col-6 col-sm-4"><div class="card" style="height:200px;">
                            <div class="card-body">
                                <h4 class="card-title text-center">SOLICITUDES AUTORIZADAS</h4>
                                <p class="card-text">Podra encontrar el listado de solicitudes
                                autorizadas para dar inicio con la visita fisica</p>
                                <a href="Sev_Procesamiento?accion=2" 
                                   class="btn btn-primary container-fluid">
                                    <b>Iniciar visita</b></a>
                            </div>
                        </div></div>
                    <p></p>
                    <!-- Obligar a las siguientes columnas a pasar a una nueva línea en el breakpoint md y hacia arriba -->
                    <div class="w-100 d-none d-md-block"></div>
                    
                    <div class="col-6 col-sm-4"><div class="card" style="height:200px;">
                            <div class="card-body">
                                <h4 class="card-title text-center">VISITAS EN TRANSCURSO</h4>
                                <p class="card-text">Podra visualizar todas las visitas 
                                en transcurso dentro del centro de computo CF.</p>
                               <a href="Sev_Procesamiento?accion=5" 
                                  class="btn btn-primary container-fluid">
                                   <b>VER </b></a>
                            </div>
                        </div></div>

                    <div class="col-6 col-sm-4"><div class="card" style="height:200px;">
                            <div class="card-body">
                                <h4 class="card-title text-center">BUSCAR SOLICITUD</h4>
                                <p class="card-text">Podra ejecutar una busqueda de una
                                solicitud por medio de su Numero de solicitud</p>
                                <a href="Ingreso_Rfc.jsp" 
                                   class="btn btn-primary container-fluid">
                                    <b>Buscar</b></a>
                            </div>
                        </div></div>
                    <div class="col-6 col-sm-4"><div class="card" style="height:200px;">
                            <div class="card-body">
                                <h4 class="card-title text-center">HISTORICO</h4>
                                <p class="card-text">Podra ejecutar consultas de los
                                historicos de las solicitudes</p>
                               <a href="Ingreso_Rfc.jsp" 
                                  class="btn btn-primary container-fluid">
                                   <b>Historial de visitas</b></a>
                            </div>
                        </div></div>
                </div>
                
            </div>


        </div>



    </body>
</html>
