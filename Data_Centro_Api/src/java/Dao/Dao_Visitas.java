/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Configuracion.Conexion;
import ModeloDatos.Cls_CreaVisita;
import ModeloDatos.Cls_EstadoSol;
import ModeloDatos.Cls_InfoUser;
import ModeloDatos.Cls_Personal_Externo;
import ModeloDatos.Cls_Visita;
import ModeloDatos.Cls_Vistas_Autorizar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class Dao_Visitas {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public List Lst_Visitas() throws ClassNotFoundException {

        String consulta = "SELECT V.ID, V.NOMBRE_RESPONSABLE,V.APELLIDO_RESPONSABLE,V.CORPORATIVO,V.DEPENDENCIA,\n"
                + "V.TP_VISITA, V.RFC_RELACIONADO, V.COMENTARIOS, E.DESCRIPCION FROM TB_VISITA V, ESTADO_VISITA E\n"
                + "WHERE V.ESTADO = E.ID_ESTADO";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Visita> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Visita v = new Cls_Visita();
                v.setID(rs.getInt("ID"));
                v.setNOMBRE_RESPONSABLE(rs.getString("NOMBRE_RESPONSABLE"));
                v.setAPELLIDO_RESPONSABLE(rs.getString("APELLIDO_RESPONSABLE"));
                v.setCORPORATIVO(rs.getString("CORPORATIVO"));
                v.setDEPENDENCIA(rs.getString("DEPENDENCIA"));
                v.setTP_VISITA(rs.getString("TP_VISITA"));
                v.setRFC_RELACIONADO(rs.getString("RFC_RELACIONADO"));
                v.setCOMENTARIOS(rs.getString("COMENTARIOS"));
                v.setESTADO(rs.getString("DESCRIPCION"));

                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }/// fin de listar usuarios

    public List Vistas_Pen_Auto() throws ClassNotFoundException {

        String consulta = "SELECT S.ID_SOLICITUD, S.CORP_CREA, C.PRIMER_NOMBRE, C.PRIMER_APELLIDO,S.FECHA_SOLICITUD,S.FECHA_INGRESO_PREV,S.HORA_INGRESO_PREV,\n"
                + "S.FECHA_EGRESO_PREV,S.HORA_EGRESO_PREV, E.DESCRIPCION_ESTATUS, V.DESCRIPCION_TPVISTA, S.NO_RELACION_SOL, CF.DESCRIPCION_AREA, S.COMENTARIO\n"
                + "FROM TB_SOLICITUD S, TB_USUARIOS_CORPORATIVOS C, TB_ESTATUS_SOL E, TB_TP_VISTA V, TB_AREAS_CF CF\n"
                + "WHERE S.CORP_CREA = C.CORPORATIVO AND\n"
                + "E.ID_ESTATUS_SOL = S.ID_ESTATUS AND\n"
                + "V.ID_TP_VISITA = S.TP_SOLICITUD AND\n"
                + "CF.ID_AREA_CF = S.ID_AREA  AND\n"
                + "S.ID_ESTATUS =1";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Vistas_Autorizar> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Vistas_Autorizar v = new Cls_Vistas_Autorizar();
                v.setID_SOLICITUD(rs.getInt("ID_SOLICITUD"));
                v.setCORP_CRE(rs.getString("CORP_CREA"));
                v.setPRIMER_NOMBRE(rs.getString("PRIMER_NOMBRE"));
                v.setPRIMER_APELLIDO(rs.getString("PRIMER_APELLIDO"));
                v.setFECHA_SOLICITUD(rs.getString("FECHA_SOLICITUD"));

                v.setFECHA_INGRESO_PREV(rs.getString("FECHA_INGRESO_PREV"));
                String[] f = rs.getString("HORA_INGRESO_PREV").split("\\.");
                v.setHORA_INGRESO_PREV(f[0]);
                v.setFECHA_EGRESO_PREV(rs.getString("FECHA_EGRESO_PREV"));
                String[] e = rs.getString("HORA_EGRESO_PREV").split("\\.");
                v.setHORA_EGRESO_PREV(e[0]);
                v.setESTATUS_SOL(rs.getString("DESCRIPCION_ESTATUS"));
                v.setTP_VISITA(rs.getString("DESCRIPCION_TPVISTA"));
                v.setNO_RELACION(rs.getString("NO_RELACION_SOL"));
                v.setAREA(rs.getString("DESCRIPCION_AREA"));
                v.setCOMENTARIO_SOL(rs.getString("COMENTARIO"));

                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }/// fin de listar usuarios

    public int IngresarVISITA(Cls_CreaVisita c) {
        int r = 0;
        boolean res = false;

        String Tabla = "TB_SOLICITUD";
        String Column = "ID_SOLICITUD";

        String sentencia = "INSERT INTO TB_SOLICITUD(CORP_CREA,FECHA_SOLICITUD"
                + ",FECHA_INGRESO_PREV,HORA_INGRESO_PREV,FECHA_EGRESO_PREV,"
                + "HORA_EGRESO_PREV,TP_SOLICITUD,NO_RELACION_SOL,ID_AREA,"
                + "ID_ESTATUS,COMENTARIO)\n"
                + "VALUES\n"
                + "('" + c.getCorp() + "','" + c.getFecha_Sol() + "',"
                + "'" + c.getFecha_Ing() + "','" + c.getHora_Ingr() + "','" + c.getFecha_Egr() + "'"
                + ",'" + c.getHora_Egr() + "'," + c.getTp_Visita() + ",'" + c.getNo_Relacion() + "'"
                + "," + c.getId_Area() + "," + c.getEstatus() + ",'" + c.getComentario() + "')"
                + " ";
        try {
            cn.open();
            System.out.println("query que se ejecutara" + sentencia);
            res = cn.executeSql(sentencia);
            System.out.println("resputa insert" + res);
            r = ObtLastId(Tabla, Column);
            System.out.println("R" + r);
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;

    }

    public int ObtLastId(String Tabla, String Column) throws ClassNotFoundException {

        String consulta = "select TOP 1 * from " + Tabla + " \n"
                + "order by " + Column + "  DESC;";

        System.out.println("Consulta hacia bd: " + consulta);
        int no = 0;

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                no = rs.getInt("ID_SOLICITUD");
                System.out.println("No id tabla" + no);
            }

            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return no;

    }/// fin de listar usuarios

    public boolean EnrollaPerExt(Cls_Personal_Externo c) {

        boolean res = false;

        String sentencia = "insert into TB_GRUPO_PERSONAL_EXTERNO "
                + "(ID_SOLICITUD,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,"
                + "SEGUNDO_APELLIDO,DOC_IDENTIFICACION,NOM_PROVEEDOR)\n"
                + "values(" + c.getNo_sol() + ",'" + c.getPnombre() + "','" + c.getSnombre() + "','" + c.getPapellido() + ""
                + "','" + c.getSapellido() + "','" + c.getDocIdentificacion() + "','" + c.getNomProveedor() + "')";
        try {
            cn.open();
            System.out.println("query que se ejecutara" + sentencia);
            res = cn.executeSql(sentencia);
            System.out.println("resputa insert" + res);
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;

    }//fin erolla personal

    public boolean EnrollaPerinterno(String Corp, int noSol) {

        boolean res = false;

        String sentencia = "INSERT INTO TB_GRUPO_PERSONAL_INTERNO"
                + "(ID_SOLICITUD,CORPORATIVO)\n"
                + "VALUES(" + noSol + ",'" + Corp + "')";
        try {
            cn.open();
            System.out.println("query que se ejecutara" + sentencia);
            res = cn.executeSql(sentencia);
            System.out.println("resputa insert" + res);
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;

    }//fin erolla personal

    public Cls_EstadoSol EstadoSoli(String Corp) throws ClassNotFoundException {

        String pendientes = "select COUNT(*) PEN_AUTORIZACION from TB_SOLICITUD \n"
                + "WHERE ID_ESTATUS = 1 AND\n"
                + "CORP_CREA = '" + Corp + "'";
        System.out.println("Consulta hacia bd: " + pendientes);

        String autorizadas = "select COUNT(*) AUTORIZADO from TB_SOLICITUD \n"
                + "WHERE ID_ESTATUS = 2 AND\n"
                + "CORP_CREA = '" + Corp + "'";

        String denegadas = "select COUNT(*) DENEGADO from TB_SOLICITUD \n"
                + "WHERE ID_ESTATUS = 3 AND\n"
                + "CORP_CREA = " + Corp + "";

        Cls_EstadoSol v = new Cls_EstadoSol();

        //obtiene pendientes
        try {
            con = cn.open();
            ps = con.prepareStatement(pendientes);
            rs = ps.executeQuery();
            while (rs.next()) {

                v.setPendienteAutorizacion(Integer.parseInt(rs.getString("PEN_AUTORIZACION")));
                System.out.println("Pen de Autorizar" + v.getPendienteAutorizacion());

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }// finaliza pendientes

        //obtiene autorizados
        try {
            con = cn.open();
            ps = con.prepareStatement(autorizadas);
            rs = ps.executeQuery();
            while (rs.next()) {

                v.setAutorizado(Integer.parseInt(rs.getString("AUTORIZADO")));
                System.out.println("Autorizadas" + v.getAutorizado());

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }// finaliza autorizados

        //obtiene denegadas
        try {
            con = cn.open();
            ps = con.prepareStatement(denegadas);
            rs = ps.executeQuery();
            while (rs.next()) {

                v.setDenegado(Integer.parseInt(rs.getString("DENEGADO")));
                System.out.println("DENEGADO" + v.getAutorizado());

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }// finaliza denegadas

        return v;

    }/// fin de listar usuarios

    public List Lst_Visitas_User_Estado(String Corp, int estado) throws ClassNotFoundException {
        String consulta = "SELECT S.ID_SOLICITUD, S.CORP_CREA, C.PRIMER_NOMBRE, C.PRIMER_APELLIDO,S.FECHA_SOLICITUD,S.FECHA_INGRESO_PREV,S.HORA_INGRESO_PREV,\n"
                + "S.FECHA_EGRESO_PREV,S.HORA_EGRESO_PREV, E.DESCRIPCION_ESTATUS, V.DESCRIPCION_TPVISTA, S.NO_RELACION_SOL, CF.DESCRIPCION_AREA, S.COMENTARIO\n"
                + "FROM TB_SOLICITUD S, TB_USUARIOS_CORPORATIVOS C, TB_ESTATUS_SOL E, TB_TP_VISTA V, TB_AREAS_CF CF\n"
                + "WHERE S.CORP_CREA = C.CORPORATIVO AND\n"
                + "E.ID_ESTATUS_SOL = S.ID_ESTATUS AND\n"
                + "V.ID_TP_VISITA = S.TP_SOLICITUD AND\n"
                + "CF.ID_AREA_CF = S.ID_AREA AND\n"
                + "S.CORP_CREA ='" + Corp + "' AND\n"
                + "S.ID_ESTATUS =" + estado + "";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Vistas_Autorizar> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Vistas_Autorizar v = new Cls_Vistas_Autorizar();
                v.setID_SOLICITUD(rs.getInt("ID_SOLICITUD"));
                v.setCORP_CRE(rs.getString("CORP_CREA"));
                v.setPRIMER_NOMBRE(rs.getString("PRIMER_NOMBRE"));
                v.setPRIMER_APELLIDO(rs.getString("PRIMER_APELLIDO"));
                v.setFECHA_SOLICITUD(rs.getString("FECHA_SOLICITUD"));
                v.setFECHA_INGRESO_PREV(rs.getString("FECHA_INGRESO_PREV"));
                String[] f = rs.getString("HORA_INGRESO_PREV").split("\\.");
                v.setHORA_INGRESO_PREV(f[0]);

                v.setFECHA_EGRESO_PREV(rs.getString("FECHA_EGRESO_PREV"));
                String[] e = rs.getString("HORA_EGRESO_PREV").split("\\.");
                v.setHORA_EGRESO_PREV(e[0]);
                v.setESTATUS_SOL(rs.getString("DESCRIPCION_ESTATUS"));
                v.setTP_VISITA(rs.getString("DESCRIPCION_TPVISTA"));
                v.setNO_RELACION(rs.getString("NO_RELACION_SOL"));
                v.setAREA(rs.getString("DESCRIPCION_AREA"));
                v.setCOMENTARIO_SOL(rs.getString("COMENTARIO"));

                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }/// fin de listar usuarios

    public Cls_Vistas_Autorizar Lst_VisitaUnic(int NoSol) throws ClassNotFoundException {
        String consulta = "SELECT S.ID_SOLICITUD, S.CORP_CREA, C.PRIMER_NOMBRE, "
                + "C.PRIMER_APELLIDO,S.FECHA_SOLICITUD,S.FECHA_INGRESO_PREV,S.HORA_INGRESO_PREV,\n"
                + "S.FECHA_EGRESO_PREV,S.HORA_EGRESO_PREV, E.DESCRIPCION_ESTATUS, "
                + "V.DESCRIPCION_TPVISTA, S.NO_RELACION_SOL, CF.DESCRIPCION_AREA, S.COMENTARIO\n"
                + "FROM TB_SOLICITUD S, TB_USUARIOS_CORPORATIVOS C, TB_ESTATUS_SOL E, TB_TP_VISTA V, TB_AREAS_CF CF\n"
                + "WHERE S.CORP_CREA = C.CORPORATIVO AND\n"
                + "E.ID_ESTATUS_SOL = S.ID_ESTATUS AND\n"
                + "V.ID_TP_VISITA = S.TP_SOLICITUD AND\n"
                + "CF.ID_AREA_CF = S.ID_AREA AND\n"
                + "S.ID_SOLICITUD= " + NoSol + "";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Vistas_Autorizar> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Vistas_Autorizar v = new Cls_Vistas_Autorizar();
                v.setID_SOLICITUD(rs.getInt("ID_SOLICITUD"));
                v.setCORP_CRE(rs.getString("CORP_CREA"));
                v.setPRIMER_NOMBRE(rs.getString("PRIMER_NOMBRE"));
                v.setPRIMER_APELLIDO(rs.getString("PRIMER_APELLIDO"));
                v.setFECHA_SOLICITUD(rs.getString("FECHA_SOLICITUD"));
                v.setFECHA_INGRESO_PREV(rs.getString("FECHA_INGRESO_PREV"));
                String[] f = rs.getString("HORA_INGRESO_PREV").split("\\.");
                v.setHORA_INGRESO_PREV(f[0]);

                v.setFECHA_EGRESO_PREV(rs.getString("FECHA_EGRESO_PREV"));
                String[] e = rs.getString("HORA_EGRESO_PREV").split("\\.");
                v.setHORA_EGRESO_PREV(e[0]);
                v.setESTATUS_SOL(rs.getString("DESCRIPCION_ESTATUS"));
                v.setTP_VISITA(rs.getString("DESCRIPCION_TPVISTA"));
                v.setNO_RELACION(rs.getString("NO_RELACION_SOL"));
                v.setAREA(rs.getString("DESCRIPCION_AREA"));
                v.setCOMENTARIO_SOL(rs.getString("COMENTARIO"));

                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista.get(0);

    }/// fin de listar usuarios

    public List LstPersonalExterno(int NoSol) {

        String consulta = "SELECT * FROM TB_GRUPO_PERSONAL_EXTERNO\n"
                + "WHERE ID_SOLICITUD =" + NoSol + "";

        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Personal_Externo> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Personal_Externo v = new Cls_Personal_Externo();
                v.setNo_sol(rs.getInt("ID_SOLICITUD"));
                v.setPnombre(rs.getString("PRIMER_NOMBRE"));
                v.setSnombre(rs.getString("SEGUNDO_NOMBRE"));
                v.setPapellido(rs.getString("PRIMER_APELLIDO"));
                v.setSapellido(rs.getString("SEGUNDO_APELLIDO"));
                v.setDocIdentificacion(rs.getString("DOC_IDENTIFICACION"));
                v.setNomProveedor(rs.getString("NOM_PROVEEDOR"));
                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public List LstPersonalInterno(int NoSol) {

        String consulta = "SELECT I.CORPORATIVO,I.ID_SOLICITUD, C.PRIMER_NOMBRE,C.SEGUNDO_NOMBRE,C.PRIMER_APELLIDO,C.SEGUNDO_APELLIDO, C.DEPENDENCIA,C.PUESTO\n"
                + "FROM TB_GRUPO_PERSONAL_INTERNO I,TB_USUARIOS_CORPORATIVOS C\n"
                + "WHERE \n"
                + "I.CORPORATIVO= C.CORPORATIVO AND\n"
                + "I.ID_SOLICITUD =" + NoSol + "";

        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_InfoUser> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_InfoUser v = new Cls_InfoUser();
                v.setId(rs.getInt("ID_SOLICITUD"));
                v.setCorp(rs.getString("CORPORATIVO"));
                v.setPrimer_Nom(rs.getString("PRIMER_NOMBRE"));
                v.setSegun_Nom(rs.getString("SEGUNDO_NOMBRE"));
                v.setPrimer_Apell(rs.getString("PRIMER_APELLIDO"));
                v.setSegun_Apell(rs.getString("SEGUNDO_APELLIDO"));
                v.setDependencia(rs.getString("DEPENDENCIA"));
                v.setPuesto(rs.getString("PUESTO"));
                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public boolean CambiaEstatus(int No_Sol, int Status, String Comentario) {

        boolean res = false;
        
        String sentencia ="";
        
switch(Status){

    case 2:
           sentencia = "UPDATE TB_SOLICITUD\n"
                + "SET ID_ESTATUS =" + Status + ","
                      + "COMENTARIO_AUTORIZA='" + Comentario + "'\n"
                + "WHERE ID_SOLICITUD =" + No_Sol + "";
        break;
        
        
    case 3: 
          sentencia = "UPDATE TB_SOLICITUD\n"
                + "SET ID_ESTATUS =" + Status + ","
                      + "COMENTARIO_DENI='" + Comentario + "'\n"
                + "WHERE ID_SOLICITUD =" + No_Sol + "";
        break;
}
           

        try {
            cn.open();
            System.out.println("query que se ejecutara" + sentencia);
            res = cn.executeSql(sentencia);
            System.out.println("resputa insert" + res);
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;

    }//fin erolla personal

    //lista solicitudes por estatus
    public List Lst_Sol_Estatus(int idEstatus) throws ClassNotFoundException {

        String consulta = "SELECT S.ID_SOLICITUD, S.CORP_CREA, C.PRIMER_NOMBRE,"
                + " C.PRIMER_APELLIDO,S.FECHA_SOLICITUD,S.FECHA_INGRESO_PREV,"
                + "S.HORA_INGRESO_PREV,\n"
                + "S.FECHA_EGRESO_PREV,S.HORA_EGRESO_PREV, E.DESCRIPCION_ESTATUS,"
                + " V.DESCRIPCION_TPVISTA, S.NO_RELACION_SOL, CF.DESCRIPCION_AREA, "
                + "S.COMENTARIO\n"
                + "FROM TB_SOLICITUD S, TB_USUARIOS_CORPORATIVOS C, TB_ESTATUS_SOL E, "
                + "TB_TP_VISTA V, TB_AREAS_CF CF\n"
                + "WHERE S.CORP_CREA = C.CORPORATIVO AND\n"
                + "E.ID_ESTATUS_SOL = S.ID_ESTATUS AND\n"
                + "V.ID_TP_VISITA = S.TP_SOLICITUD AND\n"
                + "CF.ID_AREA_CF = S.ID_AREA AND\n"
                + "S.ID_ESTATUS =" + idEstatus + ""
                + "ORDER BY S.ID_SOLICITUD DESC";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Vistas_Autorizar> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Vistas_Autorizar v = new Cls_Vistas_Autorizar();
                v.setID_SOLICITUD(rs.getInt("ID_SOLICITUD"));
                v.setCORP_CRE(rs.getString("CORP_CREA"));
                v.setPRIMER_NOMBRE(rs.getString("PRIMER_NOMBRE"));
                v.setPRIMER_APELLIDO(rs.getString("PRIMER_APELLIDO"));
                v.setFECHA_SOLICITUD(rs.getString("FECHA_SOLICITUD"));

                v.setFECHA_INGRESO_PREV(rs.getString("FECHA_INGRESO_PREV"));
                String[] f = rs.getString("HORA_INGRESO_PREV").split("\\.");
                v.setHORA_INGRESO_PREV(f[0]);
                v.setFECHA_EGRESO_PREV(rs.getString("FECHA_EGRESO_PREV"));
                String[] e = rs.getString("HORA_EGRESO_PREV").split("\\.");
                v.setHORA_EGRESO_PREV(e[0]);
                v.setESTATUS_SOL(rs.getString("DESCRIPCION_ESTATUS"));
                v.setTP_VISITA(rs.getString("DESCRIPCION_TPVISTA"));
                v.setNO_RELACION(rs.getString("NO_RELACION_SOL"));
                v.setAREA(rs.getString("DESCRIPCION_AREA"));
                v.setCOMENTARIO_SOL(rs.getString("COMENTARIO"));

                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }/// fin de listar usuarios

    public boolean CambiaEstatusSimple(int No_sol, int Status) {
        boolean res = false;

        String sentencia = "UPDATE TB_SOLICITUD\n"
                + "SET ID_ESTATUS =" + Status + "\n "
                + "WHERE ID_SOLICITUD =" + No_sol + "";
        try {
            cn.open();
            System.out.println("query que se ejecutara" + sentencia);
            res = cn.executeSql(sentencia);
            System.out.println("resputa insert" + res);
            cn.close();

        } catch (Exception ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public List Lst_Historico(String fechaI, String FechaF, int estado) {
        String consulta = "";
        if (estado == 0) {
            consulta = "SELECT S.ID_SOLICITUD, S.CORP_CREA, C.PRIMER_NOMBRE,"
                    + " C.PRIMER_APELLIDO,S.FECHA_SOLICITUD,"
                    + "S.FECHA_INGRESO_PREV,S.HORA_INGRESO_PREV,\n"
                    + "S.FECHA_EGRESO_PREV,S.HORA_EGRESO_PREV, "
                    + "E.DESCRIPCION_ESTATUS, V.DESCRIPCION_TPVISTA,"
                    + " S.NO_RELACION_SOL, CF.DESCRIPCION_AREA, S.COMENTARIO\n"
                    + "FROM TB_SOLICITUD S, TB_USUARIOS_CORPORATIVOS C, TB_ESTATUS_SOL E,"
                    + " TB_TP_VISTA V, TB_AREAS_CF CF\n"
                    + "WHERE S.CORP_CREA = C.CORPORATIVO AND\n"
                    + "E.ID_ESTATUS_SOL = S.ID_ESTATUS AND\n"
                    + "V.ID_TP_VISITA = S.TP_SOLICITUD AND\n"
                    + "CF.ID_AREA_CF = S.ID_AREA  AND\n"
                    + "FECHA_INGRESO_PREV BETWEEN '" + fechaI + "' AND '" + FechaF + "'";
            System.out.println("Consulta hacia bd: " + consulta);
        } else {
            consulta = "SELECT S.ID_SOLICITUD, S.CORP_CREA, C.PRIMER_NOMBRE,"
                    + " C.PRIMER_APELLIDO,S.FECHA_SOLICITUD,S.FECHA_INGRESO_PREV,"
                    + "S.HORA_INGRESO_PREV,\n"
                    + "S.FECHA_EGRESO_PREV,S.HORA_EGRESO_PREV, E.DESCRIPCION_ESTATUS, "
                    + "V.DESCRIPCION_TPVISTA, S.NO_RELACION_SOL, "
                    + "CF.DESCRIPCION_AREA, S.COMENTARIO\n"
                    + "FROM TB_SOLICITUD S, TB_USUARIOS_CORPORATIVOS C, "
                    + "TB_ESTATUS_SOL E, TB_TP_VISTA V, TB_AREAS_CF CF\n"
                    + "WHERE S.CORP_CREA = C.CORPORATIVO AND\n"
                    + "E.ID_ESTATUS_SOL = S.ID_ESTATUS AND\n"
                    + "V.ID_TP_VISITA = S.TP_SOLICITUD AND\n"
                    + "CF.ID_AREA_CF = S.ID_AREA  AND\n"
                    + "ID_ESTATUS = "+estado+" AND\n"
                    + "FECHA_INGRESO_PREV BETWEEN '2022-09-21' AND '2022-10-29'";
            System.out.println("Consulta hacia bd: " + consulta);
        }

        List<Cls_Vistas_Autorizar> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Vistas_Autorizar v = new Cls_Vistas_Autorizar();
                v.setID_SOLICITUD(rs.getInt("ID_SOLICITUD"));
                v.setCORP_CRE(rs.getString("CORP_CREA"));
                v.setPRIMER_NOMBRE(rs.getString("PRIMER_NOMBRE"));
                v.setPRIMER_APELLIDO(rs.getString("PRIMER_APELLIDO"));
                v.setFECHA_SOLICITUD(rs.getString("FECHA_SOLICITUD"));

                v.setFECHA_INGRESO_PREV(rs.getString("FECHA_INGRESO_PREV"));
                String[] f = rs.getString("HORA_INGRESO_PREV").split("\\.");
                v.setHORA_INGRESO_PREV(f[0]);
                v.setFECHA_EGRESO_PREV(rs.getString("FECHA_EGRESO_PREV"));
                String[] e = rs.getString("HORA_EGRESO_PREV").split("\\.");
                v.setHORA_EGRESO_PREV(e[0]);
                v.setESTATUS_SOL(rs.getString("DESCRIPCION_ESTATUS"));
                v.setTP_VISITA(rs.getString("DESCRIPCION_TPVISTA"));
                v.setNO_RELACION(rs.getString("NO_RELACION_SOL"));
                v.setAREA(rs.getString("DESCRIPCION_AREA"));
                v.setCOMENTARIO_SOL(rs.getString("COMENTARIO"));

                lista.add(v);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao_Visitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
