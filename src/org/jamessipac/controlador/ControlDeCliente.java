package org.jamessipac.controlador;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jamessipac.modelo.Cliente;
import org.jamessipac.modelo.Conexion;
/**
 * ControlDeCliente representa la clase donde se utilizan diferentes metodos para realizar las funciones del CRUD
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class ControlDeCliente {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Este metodo sirve para agregar un nuevo cliente a la base de datos
     * @param cl parametro para agregar un nuevo cliente
     * @return devuelve ya sea verdadero o falso si se pudo agregar o no
     */
    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (dni, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    /**
     * Este metodo sirve para mostrar todos los clientes que se tienen en la base de datos
     * @return Develve todos los datos de todos los clientes existentes
     */
    public ArrayList ListarCliente() {
        ArrayList<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getInt("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                ListaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    /**
     * Este metodo sirve para eliminar a un cliente especifico de la base de datos
     * @param id Sirve para poder identifiicar al cliente a eliminar
     * @return Devuelve ya sea verdadero o false si se pudo eliminar o no
     */
    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    /**
     * Este metodo sirve para poder actualizar los datos de un clientes existente en la base de datos
     * @param cl Parametro para poder identificar al cliente a eliminar
     * @return Devuelve ya sea verdadero o falso si se pucdo actualizar o no
     */
    public boolean ModificarCliente(Cliente cl) {
        String sql = "UPDATE clientes SET dni=?, nombre=?, telefono=?, direccion=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setInt(5, cl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    /**
     * Este metodo sirve para poder encontrar a un cliente especifico por medio del dni
     * @param dni Parametro para poder identificar al cliente buscado
     * @return Devuelve los datos de ese cliente buscado
     */
    public Cliente Buscarcliente(int dni) {
        Cliente cl = new Cliente();
        String sql = "SELECT * FROM clientes WHERE dni=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }

}
