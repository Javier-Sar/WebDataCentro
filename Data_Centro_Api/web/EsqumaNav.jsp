<%-- 
    Document   : PRUEBA
    Created on : 15 sept 2022, 16:39:26
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Centro de computo</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
         <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
         
         
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">

        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

    </head>
    <body>
        <script>
        
              $(function(){
            // debugger;
           
            
            // console.log(name);
             if(${info.getCorp()}!null){
                    alert("FAVOR AUTENTICARSE");
                  window.location.replace("login_inicial.jsp");
                
             }else{
                 
                
             }
                
          });
        </script>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <button class="btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo">
                    <img src="bi.jpg" alt="Logo" style="width:60px;" class="rounded-pill"/>

                </button>


                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="Nav_Principal?accion=0">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Nav_Principal?accion=4" id="4" disabled="">Turnos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Nav_Principal?accion=5" id="5">Control Ingresos CF</a>
                        </li>  
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Personal</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="Nav_Principal?accion=1" id="1" name="1">Personal Registrado</a></li>
                                <li><a class="dropdown-item" href="Nav_Principal?accion=2" id="2">Registral Personal</a></li>
                              
                            </ul>
                        </li>

                    </ul>

                </div>

            </div>
            <div class="dropdown">
                <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown">
                    Cerrar Sesion
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">  <img src="imagenes/sesion.jpg" style="width:40px;" class="rounded-pill"/></a></li>

                    <li><a class="dropdown-item" href="#">${info.getCorp()}</a></li>
                    <li><a class="dropdown-item" href="#">${info.getPuesto()}</a></li>
                    <li><a class="dropdown-item" href="#">${info.getPrimer_Nom()} ${info.getPrimer_Apell()} </a></li>
                    <li><a class="dropdown-item btn btn-danger container-fluid" href="Serv_InicioSesion?accion=2">Cerrar Sesion</a></li>
                </ul>
            </div>
        </nav>


        <div class="offcanvas offcanvas-start" id="demo">
            <div class="offcanvas-header">
                <h1 class="offcanvas-title">DATA CENTRO CF</h1>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas"></button>
            </div>
            <div class="offcanvas-body">
                <p>Centro de computo CF </p>
                <p>Centro de computo BRS</p>
                <br><!-- comment -->
                <br><br>

                <div class="card-text text-center">
                    <p>${info.getCorp()}</p>
                    <p>${info.getPrimer_Nom()} ${info.getSegun_Nom()} ${info.getPrimer_Apell()} ${info.getSegun_Apell()}</p>
                    <p>${info.getPuesto()}</p>
                    <p></p>
                    <a class="btn btn-primary" href="Dashboard.jsp">Dashboard</a>
                </div>


            </div>
        </div>



    </div>


</body>
</html>

