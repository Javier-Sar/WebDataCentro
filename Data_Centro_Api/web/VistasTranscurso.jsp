<%-- 
    Document   : VistasTranscurso
    Created on : 5 oct 2022, 12:30:56
    Author     : javie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Personas Registradas</title>
        <jsp:include page="EsqumaNav.jsp" />
        <link href="CSS/Estilos_PrsRst.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container text-center">
            <h1 class="display-4"><b>VISITAS EN TRANSCURSO</b></h1>
        </div>
        <br>
        <br>
        
    
        <!-- cards -->
         <c:forEach var="v" items="${listaPro}">
        
              <div class="container">
                <div class="card">
                    <div class="card-header">
                        <ul class="nav nav-pills card-header-pills">

                            <li class="nav-item">
                                <a class="nav-link" href="#"><b>CENTRO DE COMPUTO CF</b></a>
                            </li>

                        </ul>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"><b>DATOS DE SOLICITUD</b></h5>
                        <p class="card-text"><b>Corporativo Solicitante: </b>${v.getCORP_CRE()}</p>
                        <p class="card-text"><b>Nombre solicitante: </b>${v.getPRIMER_NOMBRE()} ${v.getPRIMER_APELLIDO()} </p>
                        <p class="card-text"><b>Fecha de solicitud: </b>${v.getFECHA_SOLICITUD()} </p>
                        <p class="card-text"><b>Fecha Ingreso: </b>${v.getFECHA_INGRESO_PREV()} </p>
                        <p class="card-text"><b>Fecha Egreso: </b>${v.getFECHA_EGRESO_PREV()} </p>
                        <p class="card-text"><b>Tipo Visita: </b>${v.getTP_VISITA()}</p>
                        <p class="card-text"><b>Numero:   </b>${v.getNO_RELACION()}</p>
                        <p class="card-text"><b>Area de trabajo : </b>${v.getAREA()}</p>
                        <p class="card-text"><b>Comentario : </b>${v.getCOMENTARIO_SOL()}</p>

                        <a href="#" class="btn btn-success">TRANSCURRIENDO</a>
                        <br>
                         <br>
                        <div class="d-grid gap-2 container-fluid">

                            <a type="button" class="btn btn-warning btn-block" href="Sev_Procesamiento?accion=6&Sol=${v.getID_SOLICITUD()}">VER DETALLES</a>
                            


                        </div>
                    </div>
                        <input type="hidden" name="IdSol" value="${v.getID_SOLICITUD()}">
                </div>

            </div>
     </c:forEach>
    </body>
</html>
