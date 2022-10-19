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

        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container-fluid" style="text-align:center;">
            <br>
            <h2>ESTATUS DE SOLICITUDES</h2>

        </div>
        <br><!-- comment -->
        <br>
        <div class="container-fluid" >
            <h4 class="text-center  text-bg-warning rounded-pill" ><b>
                    PENDIENTES DE AUTORIZACION</b></h4>
            <div class="table-responsive" >
                <table class="table table-bordered table-sm display" style="margin-left:auto;margin-right:auto;" id="Pendi">
                    <thead class="table-dark">
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
                            <th scope="col"  class="col-md-9"><h6>COMENTARIO</h6></th>
                            <th scope="col"><h6>ESTADO</h6></th>

                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="v" items="${Visitas}">
                            <tr>
                                <td scope="row">${v.getID_SOLICITUD()}</td>
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

        <br>
        <br>



       
            <div class="container-fluid">
                <h4 class="text-center  text-bg-success rounded-pill" ><b>
                            AUTORIZADAS</b></h4>
            </div>
                <div class="container-fluid">
                    
                    <div class="able-responsive">

                        
                            <table class="table table-bordered table-sm display" style="margin-left:auto;margin-right:auto;" id="autorizadas">
                                <thead class="table-dark">
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
                                            <td>${p.getID_SOLICITUD()}</td>
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
                
                

        <br>
        <br>
         
                <div class="container-fluid">
                      <h4 class="text-center  text-bg-danger rounded-pill" ><b>
                            DENEGADAS</b></h4>
                  
                        <div class="table-responsive" >
                            <table class="table table-bordered table-sm display" 
                                   style="margin-left:auto;margin-right:auto;" id="Dene">
                                <thead class="table-dark">
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
                
        
        
        
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#Pendi').DataTable({
                        language: {
                            search: "BUSCAR:",
                            paginate: {
                                first: "PRIMERA",
                                previous: "ANTERIOR",
                                next: "SIGUIENTE",
                                last: "ULTIMA"
                            }, loadingRecords: "CARGANDO USUARIOS",
                            info: "USUARIOS Registros _START_ DE; _END_ de _TOTAL_;USUARIOS"

                        }
                    });


                    $('#autorizadas').DataTable({
                        language: {
                            search: "BUSCAR:",
                            paginate: {
                                first: "PRIMERA",
                                previous: "ANTERIOR",
                                next: "SIGUIENTE",
                                last: "ULTIMA"
                            }, loadingRecords: "CARGANDO USUARIOS",
                            info: "USUARIOS Registros _START_ DE; _END_ de _TOTAL_;USUARIOS"

                        }
                    });
                    
                     $('#Dene').DataTable({
                        language: {
                            search: "BUSCAR:",
                            paginate: {
                                first: "PRIMERA",
                                previous: "ANTERIOR",
                                next: "SIGUIENTE",
                                last: "ULTIMA"
                            }, loadingRecords: "CARGANDO USUARIOS",
                            info: "USUARIOS Registros _START_ DE; _END_ de _TOTAL_;USUARIOS"

                        }
                    });
                    
                });

            </script>                    

    </body>
</html>
