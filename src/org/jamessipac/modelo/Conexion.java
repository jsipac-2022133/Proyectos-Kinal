
package org.jamessipac.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexion representa la clase que contiene la conexion a phpMyAdmin 
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Conexion {
    Connection con;
    /**
     * Ejecuta la conexion a phpMyAdmin
     * @return devuelve la conexion
     */
    public Connection getConnection(){
        try{
            String myBD="jdbc:mysql://localhost:3307/sistemaventa?serverTimezone=UTC";
            con=DriverManager.getConnection(myBD, "root", "");
            return con;
            
        }catch(SQLException e){
            System.out.println(e.toString());          
        }
          return null;
    }
}
