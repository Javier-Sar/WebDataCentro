/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servidores;

import Dao.Dao_Usuario;
import Dao.Dao_Visitas;
import ModeloDatos.Cls_CreaVisita;
import ModeloDatos.Cls_InfoUser;
import ModeloDatos.Cls_Personal_Externo;
import ModeloDatos.Cls_Usuarios;
import ModeloDatos.Cls_Visita;
import ModeloDatos.Cls_Vistas_Autorizar;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.logging.Level;
import java.util.logging.Logger;
/*LIBRERIAS PARA CORRERLO EN APACHE
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
*/
/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author javie
 */
@WebServlet(name = "Sev_Procesamiento", urlPatterns = {"/Sev_Procesamiento"})
public class Sev_Procesamiento extends HttpServlet {

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

            Cls_Visita c = new Cls_Visita();
            Dao_Visitas daoVisita = new Dao_Visitas();
            Dao_Usuario daoUsuario = new Dao_Usuario();
            List<Cls_Visita> lista = new ArrayList();

            boolean resultado = false;
            String accion = request.getParameter("accion");
            System.out.println("accion" + accion);
            switch (accion) {

                case "0":
                    Cls_InfoUser u = new Cls_InfoUser();

                    //u = daoUsuario.InfoUser(accion);
                    // request.setAttribute("user", u);
                    request.getRequestDispatcher("Ingreso_Rfc.jsp").forward(request, response);
                    break;

                case "00":
                
                    request.getRequestDispatcher("Ingreso_Rfc_Cord.jsp").forward(request, response);
                    break;

                case "1":
                     try {
                    lista = daoVisita.Vistas_Pen_Auto();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("Visitas", lista);
                request.getRequestDispatcher("Vistas_Autorizar.jsp").forward(request, response);

                break;

                case "2": //lista solicitudes autorizadas para darle inicio
                    lstSolAut(request, response);

                    break;

                case "3": // toma id sol y genera displey de solcitid con personal autorizado

                    lstSolAutoPersonal(request, response);

                    break;

                case "4": // cambia estatus a visita en transcurso
                    inciaVisita(request, response);
                    break;

                case "5":  // inicia la visitas en transcurso 
                    VisitaTranscurso(request, response);
                    break;

                case "6":
                    DetalleTranscurso(request, response);
                    break;

                case "7":

                    FinalizaVisitia(request, response);
                    break;
                case "10":
                    System.out.println("Case10");
                    Cls_CreaVisita v = new Cls_CreaVisita();
                    HttpSession ses = request.getSession();
                    LocalDate fechahoy = LocalDate.now();
                    DateFormat datef = new SimpleDateFormat("HH:mm:ss");
                    Date date = new Date();
                    int r;

                    String fechai = request.getParameter("Fech_ing");
                    String[] fechaIngreso = fechai.split("T");

                    String fechae = request.getParameter("Fecha_sal");
                    String[] fechaegreso = fechae.split("T");

                    v.setCorp(request.getParameter("corp"));
                    System.out.println(v.getCorp());

                    v.setFecha_Sol(fechahoy.toString());
                    System.out.println("fecha sol" + v.getFecha_Sol());
                    v.setFecha_Ing(fechaIngreso[0]);
                    System.out.println("fecha ing " + v.getFecha_Ing());
                    v.setHora_Ingr(fechaIngreso[1]);
                    System.out.println("HoraIngreso" + fechaIngreso[1]);

                    v.setFecha_Egr(fechaegreso[0]);
                    System.out.println("fecha sal" + v.getFecha_Egr());
                    v.setHora_Egr(fechaegreso[1]);
                    System.out.println("HoraEgreso" + v.getHora_Egr());

                    v.setTp_Visita(Integer.parseInt(request.getParameter("tp_visita")));
                    System.out.println("Tp visita " + v.getTp_Visita());

                    v.setNo_Relacion(request.getParameter("relacion"));
                    System.out.println("realcion " + v.getNo_Relacion());

                    v.setId_Area(Integer.parseInt(request.getParameter("AreaVisita")));
                    System.out.println("AREA " + v.getId_Area());

                    v.setEstatus(1);
                    System.out.println("estatus" + v.getEstatus());

                    v.setComentario(request.getParameter("comentarios"));
                    System.out.println("comen" + v.getComentario());
                    //
                    System.out.println("Hora :" + datef.format(date));

                    r = daoVisita.IngresarVISITA(v);
                    if (r == 0) {
                        request.getRequestDispatcher("Ingreso_Rfc.jsp").forward(request, response);

                    } else {
                        request.setAttribute("No_Visita", r);
                        request.getRequestDispatcher("Vistas_EnrolarPersonal.jsp").forward(request, response);

                    }
                    System.out.println(r);

                    break;

                case "11": //funcion para buscar un corp interno

                    BuscarInterno(request, response);
                    break;

                case "12":
                    System.out.println("Paso 12");
                    IngresarPersonalEx(request, response);

                    break;

                case "13":
                    ListaSolUser(request, response);
                    break;

                case "14":
                    VerSolWithPersonal(request, response);
                    break;

                case "15":
                    Detallesol(request, response);
                    break;

                case "16":
                    AutorizaSoli(request, response);
                    break;

                case "17":
                    DeniSol(request, response);
                    break;
                case "30": // case de 30 a 40 es para usuarios y personal
                    ActualizaUser(request, response);
                    break;
                case "31": // case de 30 a 40 es para usuarios y personal

                    break;
                case "32": // case de 30 a 40 es para usuarios y personal

                    break;

                case "40": //case 40 a 50 historicos
                    GeneraHistorico(request, response);
                    break;
                default:

                    System.out.println("Se vino por defoult");
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

    private void BuscarInterno(HttpServletRequest request, HttpServletResponse response) {

        Cls_InfoUser c = new Cls_InfoUser();
        Dao_Usuario daoUsuario = new Dao_Usuario();
        Dao_Visitas daoVisitas = new Dao_Visitas();
        boolean res = false;
        PrintWriter out;
        try {
            out = response.getWriter();

            String corp = request.getParameter("corp");
            int NoSol = Integer.parseInt(request.getParameter("NoSol"));

            c = daoUsuario.InfoUser(corp);
            if (isNull(c)) {
                System.out.println("No existe");
            } else {
                res = daoVisitas.EnrollaPerinterno(corp, NoSol);
                JSONObject json = new JSONObject();
                json.put("Nombre", c.getPrimer_Nom());
                json.put("SNombre", c.getSegun_Nom());
                json.put("PApellido", c.getPrimer_Apell());
                json.put("SApellido", c.getSegun_Apell());
                json.put("Dependencia", c.getDependencia());
                json.put("Puesto", c.getPuesto());

                out.print(json);
                System.out.println("Hizo el json");
            }

        } catch (IOException ex) {
            System.out.println("expecion de json");
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fin buscar interno

    private void IngresarPersonalEx(HttpServletRequest request, HttpServletResponse response) {

        Dao_Visitas daoVisitas = new Dao_Visitas();
        Cls_Personal_Externo e = new Cls_Personal_Externo();

        int No_Sol = Integer.parseInt(request.getParameter("NoSol"));
        String Pnombre = request.getParameter("Pnombre");
        String Snombre = request.getParameter("Snombre");
        String Pappe = request.getParameter("Papellido");
        String Sappe = request.getParameter("Sapellido");
        String DocIde = request.getParameter("Doc");
        String NomProve = request.getParameter("Nprove");

        System.out.println(No_Sol);
        e.setNo_sol(No_Sol);
        System.out.println(Pnombre);
        e.setPnombre(Pnombre);
        System.out.println(Snombre);
        e.setSnombre(Snombre);
        System.out.println(Pappe);
        e.setPapellido(Pappe);
        System.out.println(Sappe);
        e.setSapellido(Sappe);
        System.out.println(DocIde);
        e.setDocIdentificacion(DocIde);
        System.out.println(NomProve);
        e.setNomProveedor(NomProve);

        boolean res = daoVisitas.EnrollaPerExt(e);
        System.out.println(" Respuesta de insert de personal externo" + res);

        System.out.println("Primer nobmre 12: " + Pnombre);

    }

    private void ListaSolUser(HttpServletRequest request, HttpServletResponse response) {
        Cls_Visita c = new Cls_Visita();
        Dao_Visitas daoVisita = new Dao_Visitas();
        List<Cls_Visita> listaP = new ArrayList();
        List<Cls_Visita> listaA = new ArrayList();
        List<Cls_Visita> listaD = new ArrayList();
        try {

            listaP = daoVisita.Lst_Visitas_User_Estado("47579", 1);
            listaA = daoVisita.Lst_Visitas_User_Estado("47579", 2);
            listaD = daoVisita.Lst_Visitas_User_Estado("47579", 3);

            request.setAttribute("Visitas", listaP);
            request.setAttribute("VisitasA", listaA);
            request.setAttribute("VisitasD", listaD);
            request.getRequestDispatcher("SolicitudesUser.jsp").forward(request, response);

        } catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void VerSolWithPersonal(HttpServletRequest request, HttpServletResponse response) {
        Dao_Visitas daoVisitas = new Dao_Visitas();
        Cls_Vistas_Autorizar c = new Cls_Vistas_Autorizar();
        List<Cls_Visita> listaP = new ArrayList();
        List<Cls_Personal_Externo> listaPE = new ArrayList();
        List<Cls_InfoUser> listaPI = new ArrayList();
        //
        int No_Sol = Integer.parseInt(request.getParameter("Sol"));
        System.out.println(No_Sol);

        try {

            c = daoVisitas.Lst_VisitaUnic(No_Sol);
            listaPE = daoVisitas.LstPersonalExterno(No_Sol);
            listaPI = daoVisitas.LstPersonalInterno(No_Sol);
            //asigna atributos y pagina
            request.setAttribute("s", c);
            request.setAttribute("PersonalE", listaPE);
            request.setAttribute("PersonalI", listaPI);
            request.getRequestDispatcher("VistasSolicitud.jsp").forward(request, response);

        } //
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// funciont

    private void Detallesol(HttpServletRequest request, HttpServletResponse response) {

        Dao_Visitas daoVisitas = new Dao_Visitas();
        Cls_Vistas_Autorizar c = new Cls_Vistas_Autorizar();
        List<Cls_Visita> listaP = new ArrayList();
        List<Cls_Personal_Externo> listaPE = new ArrayList();
        List<Cls_InfoUser> listaPI = new ArrayList();
        //
        int No_Sol = Integer.parseInt(request.getParameter("Sol"));
        System.out.println(No_Sol);

        try {

            c = daoVisitas.Lst_VisitaUnic(No_Sol);
            listaPE = daoVisitas.LstPersonalExterno(No_Sol);
            listaPI = daoVisitas.LstPersonalInterno(No_Sol);
            //asigna atributos y pagina
            request.setAttribute("s", c);
            request.setAttribute("PersonalE", listaPE);
            request.setAttribute("PersonalI", listaPI);
            request.getRequestDispatcher("Detalle_Vista_Cord.jsp").forward(request, response);

        } //
        catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DeniSol(HttpServletRequest request, HttpServletResponse response) {
        String accionA = request.getParameter("accion");
        System.out.println("ACCION DENIEGA" + accionA);
        String ComentD = request.getParameter("Comen");
        System.out.println("Coment Autorizado " + ComentD);

        int idSol = Integer.parseInt(request.getParameter("IdSol"));
        System.out.println("Id Sol" + idSol);

        Dao_Visitas daoVisitas = new Dao_Visitas();
        boolean res = false;
        List<Cls_Visita> lista = new ArrayList();

        try {

            res = daoVisitas.CambiaEstatus(idSol, 3, ComentD);
            System.out.println("Respuesta" + res);
            lista = daoVisitas.Vistas_Pen_Auto();
            request.setAttribute("Visitas", lista);
            request.getRequestDispatcher("Vistas_Autorizar.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exit lstvisitaspnd");
        }

    }

    private void AutorizaSoli(HttpServletRequest request, HttpServletResponse response) {
        String accionA = request.getParameter("accion");
        System.out.println("ACCION AUTORIZA" + accionA);
        String ComentD = request.getParameter("Comen");
        System.out.println("Coment Autorizado " + ComentD);

        int idSol = Integer.parseInt(request.getParameter("IdSol"));
        System.out.println("Id Sol" + idSol);

        Dao_Visitas daoVisitas = new Dao_Visitas();
        boolean res = false;
        List<Cls_Visita> lista = new ArrayList();

        try {

            res = daoVisitas.CambiaEstatus(idSol, 2, ComentD);
            System.out.println("Respuesta" + res);
            lista = daoVisitas.Vistas_Pen_Auto();
            request.setAttribute("Visitas", lista);
            request.getRequestDispatcher("Vistas_Autorizar.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exit lstvisitaspnd");
        }

    }

    private void lstSolAut(HttpServletRequest request, HttpServletResponse response) {

        Dao_Visitas daoVisitas = new Dao_Visitas();
        List<Cls_Vistas_Autorizar> listaA = new ArrayList();

        try {
            listaA = daoVisitas.Lst_Sol_Estatus(2);

            //asigna atributos y pagina
            request.setAttribute("SolA", listaA);

            request.getRequestDispatcher("VisitasAutorizadas.jsp").forward(request, response);

        } //
        catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// lst sol auto

    private void lstSolAutoPersonal(HttpServletRequest request, HttpServletResponse response) {

        Dao_Visitas daoVisitas = new Dao_Visitas();
        Cls_Vistas_Autorizar c = new Cls_Vistas_Autorizar();
        List<Cls_Visita> listaP = new ArrayList();
        List<Cls_Personal_Externo> listaPE = new ArrayList();
        List<Cls_InfoUser> listaPI = new ArrayList();
        //
        int No_Sol = Integer.parseInt(request.getParameter("Sol"));
        System.out.println(No_Sol);

        try {

            c = daoVisitas.Lst_VisitaUnic(No_Sol);
            listaPE = daoVisitas.LstPersonalExterno(No_Sol);
            listaPI = daoVisitas.LstPersonalInterno(No_Sol);
            //asigna atributos y pagina
            request.setAttribute("s", c);
            request.setAttribute("PersonalE", listaPE);
            request.setAttribute("PersonalI", listaPI);
            request.getRequestDispatcher("Detalle_Visita_Oper.jsp").forward(request, response);

        } //
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void inciaVisita(HttpServletRequest request, HttpServletResponse response) {
        Dao_Visitas daoVisitas = new Dao_Visitas();
        int No_Sol = Integer.parseInt(request.getParameter("Sol"));
        System.out.println(No_Sol);
        boolean res = false;

        try {
            res = daoVisitas.CambiaEstatusSimple(No_Sol, 4);
            request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// FIN INICIO DE VISITA

    private void VisitaTranscurso(HttpServletRequest request, HttpServletResponse response) {
        try {
            Dao_Visitas daoVisitas = new Dao_Visitas();
            List<Cls_Vistas_Autorizar> listaA = new ArrayList();

            listaA = daoVisitas.Lst_Sol_Estatus(4);
            request.setAttribute("listaPro", listaA);
            request.getRequestDispatcher("VistasTranscurso.jsp").forward(request, response);

        } catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void DetalleTranscurso(HttpServletRequest request, HttpServletResponse response) {

        Dao_Visitas daoVisitas = new Dao_Visitas();
        Cls_Vistas_Autorizar c = new Cls_Vistas_Autorizar();
        List<Cls_Visita> listaP = new ArrayList();
        List<Cls_Personal_Externo> listaPE = new ArrayList();
        List<Cls_InfoUser> listaPI = new ArrayList();
        //
        int No_Sol = Integer.parseInt(request.getParameter("Sol"));
        System.out.println(No_Sol);

        try {

            c = daoVisitas.Lst_VisitaUnic(No_Sol);
            listaPE = daoVisitas.LstPersonalExterno(No_Sol);
            listaPI = daoVisitas.LstPersonalInterno(No_Sol);
            //asigna atributos y pagina
            request.setAttribute("s", c);
            request.setAttribute("PersonalE", listaPE);
            request.setAttribute("PersonalI", listaPI);
            request.getRequestDispatcher("Detalle_Visita_Transcurso.jsp").forward(request, response);

        } //
        catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void FinalizaVisitia(HttpServletRequest request, HttpServletResponse response) {
        String accionA = request.getParameter("accion");
        System.out.println("ACCION FINALIZA" + accionA);
        String ComentD = request.getParameter("Comen");
        System.out.println("Coment FINALIZA " + ComentD);

        int idSol = Integer.parseInt(request.getParameter("IdSol"));
        System.out.println("Id Sol" + idSol);

        Dao_Visitas daoVisitas = new Dao_Visitas();
        boolean res = false;
        List<Cls_Vistas_Autorizar> listaA = new ArrayList();
        try {

            res = daoVisitas.CambiaEstatus(idSol, 5, ComentD);
            System.out.println("Respuesta" + res);

            listaA = daoVisitas.Lst_Sol_Estatus(4);
            request.setAttribute("listaPro", listaA);
            request.getRequestDispatcher("VistasTranscurso.jsp").forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exit lstvisitaspnd");
        }
    }

    private void ActualizaUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String usr = request.getParameter("USR");
            System.out.println("usr" + usr);
            Dao_Usuario daoUsuario = new Dao_Usuario();

            Cls_Usuarios InfoUsr = new Cls_Usuarios();
            InfoUsr = daoUsuario.InfoUSR(usr);
            request.setAttribute("u", InfoUsr);
            request.getRequestDispatcher("UsuarioEditar.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GeneraHistorico(HttpServletRequest request, HttpServletResponse response) {

        String fechaI = request.getParameter("fechaI");
        String fechaF = request.getParameter("fechaF");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Dao_Visitas daoVisitas = new Dao_Visitas();

        try {

            List<Cls_Vistas_Autorizar> listaA = new ArrayList();

            listaA = daoVisitas.Lst_Historico(fechaI, fechaF, estado);
            request.setAttribute("listaPro", listaA);
            request.getRequestDispatcher("HistoricoGen.jsp").forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(Sev_Procesamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
