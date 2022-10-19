<%-- 
    Document   : Ingreso_Rfc
    Created on : 14 sept 2022, 17:22:00
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO DE INGRESO A CF</title>
       <jsp:include page="EsqumaNav.jsp" />
        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
        <script src="Javascript/newjavascript.js" type="text/javascript"></script>

    </head>
    <body>


        <div class="container">
            <div class="card text-center container">
                <h3><b>SOLICITUD DE INGRESO</b></h3>
            <p>Para el registrar un nuevo ingreso fisico al centro de computo
                asegurese de ingresar todos
                los datos requeridos</p>
       
            </div>



            <form action="Sev_Procesamiento" method="POST" >

                <div class="card container">
                    <label for="fname" class="text-center"><b>DATOS DE LA SOLICITUD</b></label>
                    <label for="fname"><b>Corporativo: </b></label>
                    <label for="fname">${info.getCorp()}</label>
                    <input type="hidden"  name="corp" value="${info.getCorp()}">
                    <br>


                    <label for="fname"><b>Nombre: </b> </label>
                    <label for="fname"> ${info.getPrimer_Nom()} ${info.getSegun_Nom()} ${info.getPrimer_Apell()} ${info.getSegun_Apell()}</label>
                    <br><!-- comment -->

                    <label for="fname"><b>Dependencia: </b></label>
                    <label for="fname"> ${info.getPuesto()}</label>
                    <br>

                    <label for="fname"><b>Puesto: </b></label>
                    <label for="fname"> ${info.getDependencia()}</label>
                    <br>




                </div><!-- final del div de datos -->
                
                
                <br>
                <label for="lname"><b>Fecha y hora de Visita   </b></label>
                <input type="datetime-local" id="idFech_ing" name="Fech_ing" required="">

                <label for="lname"><b>Fecha y hora de salida</b> </label>
                <input type="datetime-local" id="lname" name="Fecha_sal" required="">

                <br><!-- comment -->
                <br>

                <label for="country"><b>TIPO DE VISITA</b></label>
                <select id="visita" name="tp_visita" required="">
                    <option value="1">RFC</option>
                    <option value="2">MANTENIMIENTO</option>
                    <option value="3">SOPORTE</option>
                    <option value="4">OTRO</option>
                    
                </select>


                <label for="lname"><b>RFC Relacionado</b></label>
                <input type="text" id="lname" name="relacion" placeholder="No RFC ..." required="">

                <label for="AreaVisita"><b>TIPO DE VISITA</b></label>
                <select id="AreaVistia" name="AreaVisita" required="">
                    <option value="1">CF SOTANO 1 COMPUTADOR</option>
                    <option value="2">CF SOTANO 1 IMPRESORAS</option>
                    <option value="3">CF SOTANO 1 AIRES ACONDICIONADOS</option>
                    <option value="4">CF SOTANO 1 AREA DE OPERADORES</option>
                    <option value="5">CF SOTANO 2 COMUNICACIONES</option>
                    <option value="6">CF SOTANO 2 SERVIDORES</option>
                    <option value="7">CF SOTANO 2 BODEGA</option>
                    <option value="8">CF SOTANO 2 AIRES ACONDICIONADOS</option>
                    <option value="5">CF SOTANO 2 UPS</option>
                    <option value="5">CF SOTANO 3 UPS</option>
                </select>


                <p></p>
                <label for="subject">Comentarios</label>
                <textarea id="subject" name="comentarios" 
                          placeholder="Comentarios (256 max)..." 
                          style="height:200px" required=""></textarea>
                          
                          
                <button type="sumit" class="btn btn-success container-fluid" 
                        name="accion" value="10">
                    <b>Registrar visita</b></button>
                
            </form>
        </div>

        <p>

        </p>

        <div class="container">


        </div>

    </body>




</html>
