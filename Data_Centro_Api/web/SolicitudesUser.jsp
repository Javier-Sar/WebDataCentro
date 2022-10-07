<%-- 
    Document   : SolicitudesUser
    Created on : 29 sept 2022, 21:56:16
    Author     : javie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitudes Usuario</title>
                <jsp:include page="EsquemaNavU.jsp" />
        <link href="CSS/Estilos_PrsRst.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <div >
            <div class="hijo text-center">
                <h2>ESTATUS DE SOLICITUDES</h2>
                <div class="container">
                    <h5 >PENDIENTES DE AUTORIZACION</h5>
                <div class="col-md-9" >
                    <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                        <thead>
                            <tr>
                                <th scope="col"><h6>Id</h6></th>
                                <th scope="col"><h6>CORP</h6></th>
                                <th scope="col"><h6>NOMBRE SOLICITANTE</h6></th>
                                <th scope="col"><h6>FECHA SOLICITUD</h6></th>
                                <th scope="col"><h6>FECHA INGRESO</h6></th>
                                <th scope="col"><h6>HORA INGRESO</h6></th>
                                <th scope="col"><h6>FECHA EGRESO</h6></th>
                                <th scope="col"><h6>HORA EGRESO</h6></th>
                                <th scope="col"><h6>ESTATUS </h6></th>
                                <th scope="col"><h6>TIPO VISITA</h6></th>
                                <th scope="col"><h6>NO RELACION</h6></th>
                                <th scope="col"><h6>AREA</h6></th>
                                <th scope="col"><h6>COMENTARIO</h6></th>
                                <th scope="col" class="col-md-9"><h6>ESTADO</h6></th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="v" items="${Visitas}">
                                <tr>
                                    <th scope="row">${v.getID_SOLICITUD()}</th>
                                    <td>${v.getCORP_CRE()} </td>
                                    <td>${v.getPRIMER_NOMBRE()}  ${v.getPRIMER_APELLIDO()}</td>
                                    <td>${v.getFECHA_SOLICITUD()}</td>

                                    <td>${v.getFECHA_INGRESO_PREV()}</td>
                                    <td>${v.getHORA_INGRESO_PREV()}</td>
                                    <td>${v.getFECHA_EGRESO_PREV()}</td>
                                    <td>${v.getHORA_EGRESO_PREV()}</td>

                                    <td>${v.getESTATUS_SOL()}</td>
                                    <td>${v.getTP_VISITA()}</td><!-- comment -->
                                    <td>${v.getNO_RELACION()}</td>
                                    <td>${v.getAREA()}</td>
                                    <td>${v.getCOMENTARIO_SOL()}</td>
                                    <td>

                                        <a class="btn btn-primary" href="Sev_Procesamiento?accion=14&Sol=${v.getID_SOLICITUD()}"><h8>VER DETALLE</h8></a>
                                  
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
        </div>
                                    
                                    
                                    
                                     <div >
            <div class="hijo text-center">
                <h2>AUTORIZADAS</h2>
                <div class="container">
                    <h5 >SOLICITUDES AUTORIZADAS</h5>
                <div class="col-md-9" >
                    <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                        <thead>
                            <tr>
                                <th scope="col"><h6>Id</h6></th>
                                <th scope="col"><h6>CORP</h6></th>
                                <th scope="col"><h6>NOMBRE SOLICITANTE</h6></th>
                                <th scope="col"><h6>FECHA SOLICITUD</h6></th>
                                <th scope="col"><h6>FECHA INGRESO</h6></th>
                                <th scope="col"><h6>HORA INGRESO</h6></th>
                                <th scope="col"><h6>FECHA EGRESO</h6></th>
                                <th scope="col"><h6>HORA EGRESO</h6></th>
                                
                                <th scope="col"><h6>TIPO VISITA</h6></th>
                                <th scope="col"><h6>NO RELACION</h6></th>
                                <th scope="col"><h6>AREA</h6></th>
                                <th scope="col"><h6>COMENTARIO</h6></th>
                               <th scope="col"><h6>ESTATUS </h6></th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${VisitasA}">
                                
                                
                      
                                <tr>
                                    <th scope="row">${p.getID_SOLICITUD()}</th>
                                    <td>${p.getCORP_CRE()} </td>
                                    <td>${p.getPRIMER_NOMBRE()}  ${v.getPRIMER_APELLIDO()}</td>
                                    <td>${p.getFECHA_SOLICITUD()}</td>

                                    <td>${p.getFECHA_INGRESO_PREV()}</td>
                                    <td>${p.getHORA_INGRESO_PREV()}</td>
                                    <td>${p.getFECHA_EGRESO_PREV()}</td>
                                    <td>${p.getHORA_EGRESO_PREV()}</td>

                                   
                                    <td>${p.getTP_VISITA()}</td><!-- comment -->
                                    <td>${p.getNO_RELACION()}</td>
                                    <td>${p.getAREA()}</td>
                                    <td>${p.getCOMENTARIO_SOL()}</td>
                                    <td>
                                         <a type="button" class="btn btn-outline-success" href="#"> ${p.getESTATUS_SOL()}</a>
                                    </td>
                                  
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
        </div>
        
        
         <div >
            <div class="hijo text-center">
                <h2>DENEGADAS</h2>
                <div class="container">
                    <h5 >SOLICITUDES DENEGADAS</h5>
                <div class="col-md-9" >
                    <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                        <thead>
                            <tr>
                                
                                <th scope="col"><h6>CORP</h6></th>
                                <th scope="col"><h6>NOMBRE SOLICITANTE</h6></th>
                                <th scope="col"><h6>FECHA SOLICITUD</h6></th>
                                <th scope="col"><h6>FECHA INGRESO</h6></th>
                                <th scope="col"><h6>HORA INGRESO</h6></th>
                                <th scope="col"><h6>FECHA EGRESO</h6></th>
                                <th scope="col"><h6>HORA EGRESO</h6></th>
                                
                                <th scope="col"><h6>TIPO VISITA</h6></th>
                                <th scope="col"><h6>NO RELACION</h6></th>
                                <th scope="col"><h6>AREA</h6></th>
                                <th scope="col"><h6>COMENTARIO</h6></th>
                                <th scope="col"><h6>ESTATUS </h6></th>
                               

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="d" items="${VisitasD}">
                                <tr>
                                    <th scope="row">${d.getCORP_CRE()} </th>
                                
                                    <td>${d.getPRIMER_NOMBRE()}  ${d.getPRIMER_APELLIDO()}</td>
                                    <td>${d.getFECHA_SOLICITUD()}</td>

                                    <td>${d.getFECHA_INGRESO_PREV()}</td>
                                    <td>${d.getHORA_INGRESO_PREV()}</td>
                                    <td>${d.getFECHA_EGRESO_PREV()}</td>
                                    <td>${d.getHORA_EGRESO_PREV()}</td>

                                   
                                    <td>${d.getTP_VISITA()}</td><!-- comment -->
                                    <td>${d.getNO_RELACION()}</td>
                                    <td>${d.getAREA()}</td>
                                    <td>${d.getCOMENTARIO_SOL()}</td>
                                    <td>
                                        <a type="button" class="btn btn-outline-danger" href="#"> ${d.getESTATUS_SOL()}</a>
                                       
                                    </td>
                                   
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
                </div>
        </div>
                                    
                                    
    </body>
</html>
