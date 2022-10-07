/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



/* global frompersonal */

var request, formpersonal;

var READY_STATE_UNINITIALIZED = 0;
var READY_STATE_LOADING = 1;
var READY_STATE_LOADED = 2;
var READY_STATE_INTERACTIVE = 3;
var READY_STATE_COMPLETE = 4;



    //declara variable




    // obtenmos formulario

    formpersonal = document.forms["interno"];
  

    //asignar linesing 

 
  formpersonal.addEventListener("button",cargarContenido,false);




function cargarContenido(e) {
    
    let corp = formpersonal.elements["corp"].value();

    e.preventDefault();

    InitXHMREQUEST();

    if (request) {

        //request.onreadystatechange = procesaRespu();
        request.open("POST", "Sev_Procesamiento", true);
        request.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        request.send(crear_query_string());
    }
}

function InitXHMREQUEST() {


    request = new XMLHttpRequest();


}

function procesaRespu() {
    if (request.readyState === READY_STATE_COMPLETE & request.status === 200) {
        console.log(request.response);
    }

}

function crear_query_string() {

    let corp = formpersonal.elements["corp"].value;
    return "accion=11" +
            "&corpAdd" + encodeURI(corp)
            ;
}