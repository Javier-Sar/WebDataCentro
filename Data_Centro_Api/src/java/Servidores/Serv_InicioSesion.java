/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servidores;

import Dao.Dao_Usuario;
import Dao.Dao_Visitas;
import ModeloDatos.Cls_EstadoSol;
import ModeloDatos.Cls_InfoUser;
import ModeloDatos.Cls_Usuarios;
import ModeloDatos.Cls_Valida_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javie
 */
@WebServlet(name = "Serv_InicioSesion", urlPatterns = {"/Serv_InicioSesion"})
public class Serv_InicioSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String accion = request.getParameter("accion");
            System.out.println("accion" + accion);

            switch (accion) {
                case "1":
                    Dao_Usuario dao_usr = new Dao_Usuario();
                    Cls_Valida_User usrr = new Cls_Valida_User();

                    String usr = request.getParameter("usr");
                    System.out.println(usr);
                    String pass = request.getParameter("pass");
                    System.out.println(pass);
                    try {
                        usrr = dao_usr.Valida_Usr(usr, pass);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Serv_InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("resultado" + usrr.getResultado());

                    switch (usrr.getResultado()) {
                        case "TRUE":

                            System.out.println("se vino switch case true ");
                            Cls_InfoUser info = new Cls_InfoUser();
                             {
                                info = dao_usr.InfoUser(usr);
                                request.getSession().setAttribute("info", info);

                            }
                            switch (info.getRol()) {

                                case "OPERADOR":
                                    request.getRequestDispatcher("Vistas_Operador.jsp").forward(request, response);
                                    break;
                                case "ADMINISTRADOR":
                                    request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
                                    break;

                                case "USUARIO":
                                    Dao_Visitas daoVisitas = new Dao_Visitas();
                                    Cls_EstadoSol esta = new Cls_EstadoSol();

                                     {
                                        try {
                                            esta = daoVisitas.EstadoSoli(usr);
                                            request.getSession().setAttribute("esta", esta);
                                        } catch (ClassNotFoundException ex) {
                                            Logger.getLogger(Serv_InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }

                                    request.getRequestDispatcher("DashboardUsr.jsp").forward(request, response);
                                    break;

                                case "MONITOREO":
                                    request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
                                    break;
                            }// FINIS SWITCH DENTRO DE SWITHC

                            break;

                        case "FALSE":
                            System.out.println("se vino switch case false ");
                            request.getRequestDispatcher("login_inicial.jsp").forward(request, response);
                            break;

                    }
                    break; // fin de case 1 switch principal
                    
                case "2":
                        request.getSession().setAttribute("info", null);
                          request.getRequestDispatcher("login_inicial.jsp").forward(request, response);
                        break;

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Get");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("post");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
