<%-- 
    Document   : VistasSolicitud
    Created on : 30 sept 2022, 21:44:15
    Author     : javie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <jsp:include page="EsquemaNavU.jsp" />
        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
        <title>Lolcito</title>
    </head>


    <body>
           
        
     
        
        
        
        
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
                    <p class="card-text"><b>Corporativo Solicitante: </b>${s.getCORP_CRE()}</p>
                     <p class="card-text"><b>Nombre solicitante: </b>${s.getPRIMER_NOMBRE()} ${s.getPRIMER_APELLIDO()} </p>
                     <p class="card-text"><b>Fecha de solicitud: </b>${s.getFECHA_SOLICITUD()} </p>
                      <p class="card-text"><b>Fecha Ingreso: </b>${s.getFECHA_INGRESO_PREV()} </p>
                         <p class="card-text"><b>Fecha Egreso: </b>${s.getFECHA_EGRESO_PREV()} </p>
                         <p class="card-text"><b>Tipo Visita: </b>${s.getTP_VISITA()}</p>
                            <p class="card-text"><b>Numero Relacion </b>${s.getNO_RELACION()}</p>
                          <p class="card-text"><b>Area de trabajo : </b>${s.getAREA()}</p>
                          <p class="card-text"><b>Comentario : </b>${s.getCOMENTARIO_SOL()}</p>
                           
                    <a href="#" class="btn btn-warning">PENDIENTE DE AUTORIZACION</a>
                </div>
            </div>

        </div>
        
        
        <div >
            <br>
            <div class="container">
                <h2>PERSONAL</h2>
            </div>
              <br>
              
               <div class="container">
                   <h5 ><b>INTERNO</b></h5>
                    <div class="col-md-9" >
                        <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                            <thead>
                                <tr>
                                    <th scope="col"><h6>No Solicitud</h6></th>
                                    <th scope="col"><h6>Corp</h6></th>
                                    <th scope="col"><h6>Nombre</h6></th>
                                    <th scope="col"><h6>Dependencia</h6></th>
                                    <th scope="col"><h6>Puesto</h6></th>


                                </tr>
                            </thead>
                            <tbody>
                        
                            <c:forEach var="i" items="${PersonalI}">
                                <tr>
                                    <th scope="row">${i.getId()}</th>
                                    <td>${i.getCorp()} </td>
                                    <td>${i.getPrimer_Nom()}  ${i.getSegun_Nom()} ${i.getPrimer_Apell()} ${i.getSegun_Apell()}</td>
                                    <td >${i.getDependencia()} </td>
                                    <td>${i.getPuesto()}</td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
              
              
              
              
                <div class="container">
                    <h5 ><b>EXTERNO</b></h5>
                    <div class="col-md-9" >
                        <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                            <thead>
                                <tr>
                                    <th scope="col"><h6>No Solicitud</h6></th>
                                    <th scope="col"><h6>Nombre Proveedor</h6></th>
                                    <th scope="col"><h6>Nombre Completo</h6></th>
                                    <th scope="col"><h6>Doc Identificacion</h6></th>


                                </tr>
                            </thead>
                            <tbody>
                        
                            <c:forEach var="e" items="${PersonalE}">
                                <tr>
                                    <th scope="row">${e.getNo_sol()}</th>
                                    <td>${e.getNomProveedor()} </td>
                                    <td >${e.getPnombre()}  ${e.getSnombre()} ${e.getPapellido()} ${e.getSapellido()}</td>
                                    <td>${e.getDocIdentificacion()}</td>

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
