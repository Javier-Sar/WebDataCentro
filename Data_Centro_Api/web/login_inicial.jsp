<%-- 
    Document   : login_inicial
    Created on : 13 ago 2022, 8:25:28
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script><!-- comment -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Centro Z4</title>
    </head>
    <body>
   <section class="vh-100">
  <div class="container-fluid h-custom" >
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">  
          
          <img src="bi.jpg" class="img-fluid" alt="Sample image"/>
      

      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          <form action='Serv_InicioSesion' method="POST">
         
              <div class="container-fluid text-center">
                 
                  <p><h2><b>SISTEMA DE GESTION CENTRO DE COMPUTO CF</b></h2></p>
                           </div>
          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0">Bienvenido a Corporación BI</p>
          </div>

          <!-- Corp input -->
          <div class="form-outline mb-4">
            <input type="Text" id="usr_1" class="form-control form-control-lg"
                   placeholder="Ingrese su corporativo" name="usr"/>
            <label class="form-label" for="form3Example3"> Corporativo</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" id="pass_1" class="form-control form-control-lg"
                   placeholder="Ingrese su contraseña"  name="pass"/>
            <label class="form-label" for="form3Example4">Contraseña</label>
          </div>

          <div class="d-flex justify-content-between align-items-center" >
            <!-- Checkbox -->
            <div class="form-check mb-0">
              <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
              <label class="form-check-label" for="form2Example3">
                Recordar
              </label>
            </div>
            <a href="sol_rst.jsp" class="text-body">Olvide la contraseña</a>
          </div>
         
          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"  
                    style="padding-left: 2.5rem; padding-right: 2.5rem;" name="accion" value="1">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0">Si no tienes cuenta solicitala con sistemas centrales <a href="solicitud_usuario.jsp"
                class="link-danger">Petición</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
  <div
    class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0">
      Copyright © 2022. All rights reserved Javier Sarceño.
    </div>
    <!-- Copyright -->

 
  </div>
</section>
        
        
    </body>
   
</html>
