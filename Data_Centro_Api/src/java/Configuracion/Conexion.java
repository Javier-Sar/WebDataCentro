/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Javier
 */
public class Conexion {
     private PreparedStatement preparar = null;    
    private  Connection coneccion=null;    
    private ResultSet resultado = null;
    private String usr ="administrador";
    private String pass="Banco2022.";
    
     //Cadena de Conexion
    //String stringConnectionUrl = "jdbc:sqlserver://DESKTOP-V38TSKH\\JAVIER;databaseName=BD_DATACENTRO";
    
    //cadena azure
    String stringConnectionUrl ="jdbc:sqlserver://proyectosjav.database.windows"
            + ".net:1433;database=BD_DATACENTRO;user="+usr+"@proyectosjav;"
            + "password="+pass+";encrypt=true;trustServerCertificate=false"
            + ";hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    
    //Driver o controlador JDBC
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection open() throws ClassNotFoundException{        
        try {  
                 Class.forName(driver);
               // coneccion = DriverManager.getConnection(stringConnectionUrl,"sa","97javier97");
                coneccion = DriverManager.getConnection(stringConnectionUrl);
                System.out.println("Conectado");
                
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);            
            System.out.println("Excepción: " + e.getMessage());
            System.out.println("No conectado");
        }
        return coneccion;
    }
    
    public void close() throws Exception{
        //Connection coneccion = null;
        try {
            if (coneccion != null){
                coneccion.clearWarnings();
                coneccion.close();                
            }
        } catch (SQLException e) {
            coneccion = null;
            throw new Exception(e.getMessage());
        }

    }
    
    public boolean executeSql (String cmd) throws Exception{
            if (cmd != null)
            try {
                    this.preparar = this.coneccion.prepareStatement(cmd);
                    this.preparar.executeUpdate();
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
            else
                    throw new Exception("El comando a ejecutar es nulo!");
            return true;
    }
	
    public ResultSet executeQuery (String strSQL){
        
            if (strSQL != null)
            try {        
                    
                    preparar = coneccion.prepareStatement(strSQL);                    
                    resultado = preparar.executeQuery();	
            } catch (SQLException e) {                    
                System.out.println("Error al ejecutar el query en Clase: Conexion: " + e.toString());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
            //close();
            return resultado;
    }
}
