<%-- 
    Document   : PrsRgt
    Created on : 30 ago 2022, 20:38:53
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
       
       
            <br>
            <br>
            
            <div class="container-fluid" >
            <h2 class="text-center  text-bg-warning rounded-pill" ><b>
                    PENDIENTES DE AUTORIZACION</b></h2> <br>
            </div>
            <div class="table-responsive" >
                      
                        <table class="table table-bordered table-sm display"
                               style="margin-left:auto;margin-right:auto;" id="Pen">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col"><h6>No</h6></th>
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
                                    <th scope="col"><h6>ACCIONES</h6></th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="v" items="${Visitas}">
                                    <tr>
                                        <td>${v.getID_SOLICITUD()}</td>
                                        <td>${v.getCORP_CRE()} </td>
                                        <td>${v.getPRIMER_NOMBRE()}  ${v.getPRIMER_APELLIDO()}</td>
                                        <td>${v.getFECHA_SOLICITUD()}</td>

                                        <td>${v.getFECHA_INGRESO_PREV()}</td>
                                        <td>${v.getHORA_INGRESO_PREV()}</td>
                                        <td>${v.getFECHA_EGRESO_PREV()}</td>
                                        <td>${v.getHORA_EGRESO_PREV()}</td>


                                        <td>${v.getTP_VISITA()}</td><!-- comment -->
                                        <td>${v.getNO_RELACION()}</td>
                                        <td>${v.getAREA()}</td>
                                        <td>${v.getCOMENTARIO_SOL()}</td>
                                        <td>${v.getESTATUS_SOL()}</td>
                                        <td>

                                            <a class="btn btn-warning" href="Sev_Procesamiento?accion=15&Sol=${v.getID_SOLICITUD()}"><h6>Ver Personal</h6></a>
                                          
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

         
      
        
       <script type="text/javascript">
            $(document).ready(function () {
                $('#Pen').DataTable({
                    language: {
                        search: "BUSCAR:",
                        paginate: {
                            first: "PRIMERA",
                            previous: "ANTERIOR",
                            next: "SIGUIENTE",
                            last: "ULTIMA"
                        },  loadingRecords: "CARGANDO USUARIOS",
                         info:"USUARIOS Registros _START_ DE; _END_ de _TOTAL_;USUARIOS"
                 
                    }
                });
            });

        </script>
    </body>
</html>
