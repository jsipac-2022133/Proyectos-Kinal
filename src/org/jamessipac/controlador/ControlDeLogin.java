
package org.jamessipac.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jamessipac.modelo.Conexion;
import org.jamessipac.modelo.login;
/**
 * Control de Login representa la clase que contiene diferentes metodos para poder ingresar al programa
 * @author James Sipac
 * @since 10 de septiembre de 2022  
 */
public class ControlDeLogin {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    /**
     * Este metodo sirve para poder ingresar al programa ya sea como administrador o usuario
     * @param correo parametro para poder identificar una cuenta especifica
     * @param pass parametro para poder validar que es la persona correcta
     * @return Devuelve los datos de esa cuenta
     */
    public login log(String correo, String pass){
        login l=new login();
        String sql="SELECT * FROM usuarios WHERE correo=? AND pass=?"; 
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    /**
     * Este metodo sirve para agregar una nueva cuenta a la base de datos
     * @param reg Parametro para poder registrar la nueva cuenta
     * @return Devuelve ya sea verdadero o falso si se pudo registrar o no
     */
    public boolean Registrar(login reg){
        String sql="INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
