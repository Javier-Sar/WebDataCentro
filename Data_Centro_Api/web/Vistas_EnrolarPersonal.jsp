<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrolla Personal</title>
        <jsp:include page="EsqumaNav.jsp" />
        <link href="CSS/Estilos_RstPrs.css" rel="stylesheet" type="text/css"/>
        <script src="JS/JSAgregaPersonal.js" type="text/javascript"></script>

    </head>
    <body>

        <div class="container text-center">
            <h3><b>Registro de personal<b> </h3>
                        <p>Tiene que registrar todo el personal que se vaya a presentar
                            de manera fisica al centro del computo</p>
                        <p>Numero de solicitud</p>
                        <input type="text" value="${No_Visita}" id="vis" disabled="" class="text-center">
                        
                        </div>
                        <br>

                        <form name="interno" method="POST" action="Sev_Procesamiento">
                            <div class="container">

                                <h3><B>PERSONAL INTERNO</B></h3>

                                <label>Corporativo</label>
                                <input  type="text" id="Corp" name="corp">
                                <a title="Buscar" class="btn btn-primary" href="javascript:about()">Buscar</a>
                          

                            </div>

                            <div class="container" id="lstInterno"></div>

                            <br>
                        </form>







                        <div class="container">

                            <h3><B>PERSONAL EXTERNO</B></h3>
                            <div class="form">

                                <form>

                                    <label>Primer Nombre</label>
                                    <input  type="text" id="Pnombre">

                                    <label>Segundo Nombre</label>
                                    <input type="text" id="Snombre">

                                    <label>Primer Apellido</label>
                                    <input  type="text" id="Papellido">

                                    <label>Segundo Apellido</label>
                                    <input type="text" id="Sapellido">

                                    <label>Doc Identificacion</label>
                                    <input type="text" id="Doc">

                                    <label>Nom Proveedor</label>
                                    <input type="text" id="Nprove">

                                    <a title="Buscar" class="btn btn-primary" href="javascript:AddExt()">Registrar</a>

                                </form>
                            </div>


                        </div>

                        <div class="container" id="lstExterno"></div><!-- comment -->

                        <br>
                        
                        <div class="container text-center">
                            <a class="btn btn-warning" href="Dashboard.jsp">Terminar registro</a>
                        </div>
                        <script src="https://code.jquery.com/jquery-1.11.3.js"></script>

                        <script>

                            function about(e) {

                                let corp = document.getElementById("Corp").value;
                                let NoSol = document.getElementById("vis").value;
                                
                                console.log(corp);
                                console.log(NoSol);
                                //alert(corp);
                                //e.preventDefault();
                                $.ajax({

                                    url: "${pageContext.request.contextPath}/Sev_Procesamiento?accion=11&corp=" + corp+"&NoSol="+NoSol,
                                    type: "GET",
                                    dataType: "JSON",
                                    succes: function (data) {
                                        console.log(data);
                                        alert(data.Nombre);
                                    },
                                    error: function (jqXHR, estado, error) {
                                        console.log(estado);
                                        console.log(error);

                                    },
                                    complete: function (jqXHR, estado) {
                                        console.log(estado);
                                    }
                                });
                                agrega1();

                            }


                            function AddExt(e) {
                              let NoSol = document.getElementById("vis").value;
                                let Pnom = document.getElementById("Pnombre").value;
                                let Snom = document.getElementById("Snombre").value;
                                let Papell = document.getElementById("Papellido").value;
                                let Sapell = document.getElementById("Sapellido").value;
                                let DocIde = document.getElementById("Doc").value;
                                let Nprov = document.getElementById("Nprove").value;

                                //alert(corp);
                                //e.preventDefault();
                                $.ajax({

                                    url: "${pageContext.request.contextPath}/Sev_Procesamiento?accion=12&Pnombre=" + Pnom + "&Snombre=" + Snom + "&Papellido=" + Papell + "\
&Sapellido=" + Sapell + "&Doc=" + DocIde + "&Nprove=" + Nprov+"&NoSol="+NoSol,
                                    type: "GET",
                                    dataType: "JSON",
                                    succes: function (data) {
                                        console.log(data);
                                        alert(data.Nombre);
                                    },
                                    error: function (jqXHR, estado, error) {
                                        console.log(estado);
                                        console.log(error);

                                    },
                                    complete: function (jqXHR, estado) {
                                        console.log(estado);
                                    }
                                });


                                 agrega();
                            }





                        </script><!-- comment -->





                        </body>
                        </html>
