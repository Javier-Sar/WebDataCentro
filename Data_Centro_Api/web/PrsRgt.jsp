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

        <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">

        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>




    </head>
    <body>

        <div class="container-fluid">
            <div class="container-fluid" >
                <br>
                <h2 class="text-center  text-bg-secondary rounded-pill" ><b>
                        USUARIOS</b></h2> <br>
            </div>



            <table id="table_id" class="table table-bordered table-sm display">
                <thead class="table-dark">

                    <tr>
                        <th>ID</th>
                        <th>USUARIO</th>
                        <th>PASS</th>
                        <th>ESTADO</th>
                        <th>ROL</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Cls_Usuarios" items="${usuario}">
                        <tr>

                            <td>${Cls_Usuarios.getId()}</td>
                            <td>${Cls_Usuarios.getUsuario()}</td>
                            <td>${Cls_Usuarios.getPass()}</td>
                            <td>${Cls_Usuarios.getEstado()}</td>
                            <td>${Cls_Usuarios.getRol()}</td>
                            <td>
                                <a class="btn btn-warning" href="Sev_Procesamiento?accion=30&USR=${Cls_Usuarios.getUsuario()}">Editar</a>
                                <a class="btn btn-info" href="Sev_Procesamiento?accion=31&USR=${Cls_Usuarios.getUsuario()}">Cambiar Contraseña</a>
                                <a class="btn btn-danger" href="Sev_Procesamiento?accion=32&USR=${Cls_Usuarios.getUsuario()}">Dar de baja</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#table_id').DataTable({
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
