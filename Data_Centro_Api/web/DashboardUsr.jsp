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

        <jsp:include page="EsquemaNavU.jsp" />

        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
        <title>Dashboard Usuario</title>
    </head>
    <body>

        <br>

        <div class="container">
            <div class="container-fluid ">
                <div class="row">

                    <div class="col-md-4">
                        <div class="col-lg-4">
                            <div class="container text-center">
                                <div class="card" style="width:350px">
                                    <img class="card-img-top" src="bi.jpg" alt="Card image">


                                    <div class="card-body">
                                        <h4 class="card-title text-center">ESTADO DE SOLICITUDES</h4>
                                        <p class="card-text">Pendiente de autorizacion:<b>
                                                <span class="badge bg-warning rounded-pill">${esta.getPendienteAutorizacion()}</span>

                                            </b> <br>Autorizadas:<b>
                                                <span class="badge bg-success rounded-pill">${esta.getAutorizado()}</span>
                                            </b><br>Denegadas:<b> 
                                                <span class="badge bg-danger rounded-pill">${esta.getDenegado()}</span></b></p>

                                        <a href="Sev_Procesamiento?accion=13" class="btn btn-primary">VER SOLICITUDES</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>




                    <div class="col-md-4">
                        <div class="col-lg-4">
                            <div class="container text-center">
                                <div class="card" style="width:350px">
                                    <img class="card-img-top" src="bi.jpg" alt="Card image">


                                    <div class="card-body">
                                        <h4 class="card-title">SOLICITUD DE INGRESO</h4>
                                        <p class="card-text">Para centro de computo CF</p>
                                        <a href="Sev_Procesamiento?accion=0" class="btn btn-primary">REGISTRAR</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="col-md-4">
                        <div class="col-lg-4">
                            <div class="container text-center">
                                <div class="card" style="width:350px">
                                    <img class="card-img-top" src="bi.jpg" alt="Card image">


                                    <div class="card-body">
                                        <h4 class="card-title">CANCELAR SOLICITUD</h4>
                                        <p class="card-text">Para centro de computo CF</p>
                                        <a href="CtrlRfcs.jsp" class="btn btn-primary">GENERAR</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>



                </div>
            </div>


        </div>

    </body>
</html>
