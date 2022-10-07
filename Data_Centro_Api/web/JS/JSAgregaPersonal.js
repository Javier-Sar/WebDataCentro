/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global frompersonal */

function agrega() {


    // $.post('Sev_Procesamiento?accion=12',
    //         {corp: 47579}, function(response){
    //             
    //             var tabla="";
    //         });

    let content = `<div class="container text-center">
     <div class="card">
    <label>PROVEEDOR REGISTRADO</label><br>
    <label>Proveedor: ${Nprove.value}</label>
<p>
${Pnombre.value} ${Snombre.value}
<b>Nombre: ${Papellido.value} ${Sapellido.value}</b>
</p>
    <label>Documento Identificacion: ${Doc.value}</label>
    </div>
</div>
`;

    let cont = `
<div class="row">
  <div class="mcol-xs-6 col-sm-4">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">PERSONAL EXTERNO REGISTRADO</h5>
        <p class="card-text">Proveedor: ${Nprove.value}</p>
    <p class="card-text">Nombre: ${Pnombre.value} ${Snombre.value}  ${Papellido.value} ${Sapellido.value}</p>
    <p class="card-text">Doc Identificacion: ${Doc.value}</p>
        <a href="#" class="btn btn-danger">Eliminar</a>
      </div>
    </div>
  </div>
    <br>
`;




    lstExterno.innerHTML += cont;
}




function agrega1() {

    let content = `<div class="container text-center">
     <div class="card">
    <label>PERSONAL INTERNO REGISTRADO</label><br>
    <label>Corp: ${Corp.value}</label>

</div>
</div>
`;

    let cont = `
<div class="row">
  <div class="mcol-xs-6 col-sm-4">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">PERSONAL INTERNO REGISTRADO</h5>
        <p class="card-text">Corporativo: ${Corp.value}</p>
        <a href="#" class="btn btn-danger">Eliminar</a>
      </div>
    </div>
  </div>
    <br>
`;
    lstInterno.innerHTML += cont;
}
