/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Configuracion.Conexion;
import ModeloDatos.Cls_InfoUser;
import ModeloDatos.Cls_Usuarios;
import ModeloDatos.Cls_Valida_User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class Dao_Usuario {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public Cls_Valida_User Valida_Usr(String usr, String pass) throws ClassNotFoundException {

        String consulta = "EXEC VALIDA_USR '" + usr + "','" + pass + "';";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Valida_User> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {

                Cls_Valida_User usrr = new Cls_Valida_User();
                usrr.setResultado(rs.getString("RESULTADO"));
                System.out.println("Resultado del loguin" + usrr.getResultado());

                lista.add(usrr);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cls_Valida_User res = new Cls_Valida_User();
        res = lista.get(0);

        return res;
    }// fin de funcion valida_usr

    public List Lst_usr() throws ClassNotFoundException {

        String consulta = "SELECT U.ID, U.USUARIO, U.PASS, E.DESCRIPCION_E, P.DESCRIPCION_P from TB_USERS U,TB_EST_USER E, TB_PERFIL P\n"
                + "WHERE U.ESTADO= E.ID AND\n"
                + "U.PERFIL = P.ID";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Usuarios> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Usuarios usr = new Cls_Usuarios();
                usr.setId(rs.getInt("ID"));
                System.out.println(usr.getId());
                usr.setUsuario(rs.getString("USUARIO"));
                System.out.println(usr.getUsuario());
                usr.setPass(rs.getString("PASS"));
                System.out.println(usr.getPass());
                usr.setRol(rs.getString("DESCRIPCION_P"));
                System.out.println(usr.getRol());
                usr.setEstado(rs.getString("DESCRIPCION_E"));
                System.out.println(usr.getEstado());
                lista.add(usr);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }/// fin de listar usuarios

    public Cls_Usuarios Inf_Usr(String usrr) throws ClassNotFoundException {

        String consulta = "SELECT C.CORPORATIVO,C.PRIMER_NOMBRE,C.SEGUNDO_NOMBRE,C.PRIMER_APELLIDO,C.SEGUNDO_APELLIDO,C.DEPENDENCIA,C.PUESTO, T.DESCRIPCION_P\n"
                + "FROM  TB_USUARIOS_CORPORATIVOS C, TB_PERFIL T,TB_USERS U\n"
                + "WHERE C.CORPORATIVO ='" + usrr + "' AND\n"
                + "U.PERFIL = T.ID AND\n"
                + "U.USUARIO = C.CORPORATIVO";

        /*
                "SELECT U.ID, U.USUARIO, U.PASS, E.DESCRIPCION_E, P.DESCRIPCION_P from TB_USERS U,TB_EST_USER E, TB_PERFIL P\n"
                + "WHERE U.ESTADO= E.ID AND\n"
                + "U.PERFIL = P.ID AND\n"
                + "U.USUARIO ='" + usrr + "'";

         */
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Usuarios> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Usuarios usr = new Cls_Usuarios();
                usr.setId(rs.getInt("ID"));
                System.out.println(usr.getId());
                usr.setUsuario(rs.getString("USUARIO"));
                System.out.println(usr.getUsuario());
                usr.setPass(rs.getString("PASS"));
                System.out.println(usr.getPass());
                usr.setRol(rs.getString("DESCRIPCION_P"));
                System.out.println(usr.getRol());
                usr.setEstado(rs.getString("DESCRIPCION_E"));
                System.out.println(usr.getEstado());
                usr.setNombre(rs.getString("NOMBRE"));
                System.out.println(usr.getNombre());

                lista.add(usr);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cls_Usuarios res = new Cls_Usuarios();
        res = lista.get(0);

        return res;
    }//info usuarios

    public Cls_InfoUser InfoUser(String corp) {

        String consulta = "SELECT C.CORPORATIVO,C.PRIMER_NOMBRE,C.SEGUNDO_NOMBRE,C.PRIMER_APELLIDO,C.SEGUNDO_APELLIDO,C.DEPENDENCIA,C.PUESTO, T.DESCRIPCION_P\n"
                + "FROM  TB_USUARIOS_CORPORATIVOS C, TB_PERFIL T,TB_USERS U\n"
                + "WHERE C.CORPORATIVO ='" + corp + "' AND\n"
                + "U.PERFIL = T.ID AND\n"
                + "U.USUARIO = C.CORPORATIVO";
        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_InfoUser> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.wasNull()) {
                System.out.println("objeto vacio");
                return null;
            } else {
                while (rs.next()) {
                    Cls_InfoUser usr = new Cls_InfoUser();
                    usr.setCorp(rs.getString("CORPORATIVO"));
                    usr.setPrimer_Nom(rs.getString("PRIMER_NOMBRE"));
                    usr.setSegun_Nom(rs.getString("SEGUNDO_NOMBRE"));
                    usr.setPrimer_Apell(rs.getString("PRIMER_APELLIDO"));
                    usr.setSegun_Apell(rs.getString("SEGUNDO_APELLIDO"));
                    usr.setDependencia(rs.getString("DEPENDENCIA"));
                    usr.setPuesto(rs.getString("PUESTO"));
                    usr.setRol(rs.getString("DESCRIPCION_P"));

                    lista.add(usr);

                }
            } //fin de else if

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista.get(0);
    }

    public Cls_Usuarios InfoUSR(String Corp) {

        String consulta = "SELECT U.ID, U.USUARIO, U.PASS, "
                + "E.DESCRIPCION_E, P.DESCRIPCION_P from TB_USERS U,"
                + "TB_EST_USER E, TB_PERFIL P\n"
                + "WHERE U.ESTADO= E.ID AND\n"
                + "U.PERFIL = P.ID and\n"
                + "U.USUARIO = '"+Corp+"'";

        System.out.println("Consulta hacia bd: " + consulta);
        List<Cls_Usuarios> lista = new ArrayList();

        try {
            con = cn.open();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cls_Usuarios usr = new Cls_Usuarios();
                usr.setId(rs.getInt("ID"));
                System.out.println(usr.getId());
                usr.setUsuario(rs.getString("USUARIO"));
                System.out.println(usr.getUsuario());
                usr.setPass(rs.getString("PASS"));
                System.out.println(usr.getPass());
                usr.setRol(rs.getString("DESCRIPCION_P"));
                System.out.println(usr.getRol());
                usr.setEstado(rs.getString("DESCRIPCION_E"));
                System.out.println(usr.getEstado());
                lista.add(usr);

            }
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dao_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

      

        return lista.get(0);
    }

}
