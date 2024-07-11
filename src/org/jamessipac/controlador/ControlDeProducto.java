package org.jamessipac.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import org.jamessipac.modelo.Conexion;
import org.jamessipac.modelo.Config;
import org.jamessipac.modelo.Productos;
/**
 * ControlDeProducto representa la clase donde se almacenan diferentes metodos para poder realizar el CRUD con los productos
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class ControlDeProducto {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Este metodo sirve para poder agregar un nuevo producto a la base de datos
     * @param pro Parametro para poder agregar el nuevo producto
     * @return Devuelve ya sea verdadero o falso si se pude agregar o no
     */
    public boolean RegistrarProductos(Productos pro) {
        String sql = "INSERT INTO productos(codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
        /**
         * Este metodo sirve para poder agregar los datos de la empresa en la base de datos
         * @param conf Parametro para poder agregar los nuevos datos
         * @return Devuelve ya sea verdadero o falso si se pudo agregar o no
         */
        public boolean RegistrarDatos(Config conf) {
        String sql = "INSERT INTO config(ruc, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, conf.getRuc());
            ps.setString(2, conf.getNombre());
            ps.setInt(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    /**
     * Este metodo sirve para poder agregar al ComboBox los proveedores existentes en la base de datos
     * @param proveedor Parametro para poder agregar los datos en el ComboBox
     */    
    public void ConsultarProveedor(JComboBox proveedor) {
        String sql = "SELECT nombre FROM proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    /**
     * Este metodo sirve para poder mostrar los productos en la tabla
     * @return Devuelve todos los datos de todos los productos
     */
    public ArrayList ListarProductos() {
        ArrayList<Productos> Listapro = new ArrayList();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setProveedor(rs.getString("proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
                Listapro.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listapro;
    }
    /**
     * Este metodo sirve para poder eliminar un producto existente en la base de datos
     * @param id Parametro para poder identificar al producto a eliminar
     * @return Devuelve ya sea verdadero o falso si se pudo eliminar o no
     */
    public boolean EliminarProductos(int id) {
        String sql = "DELETE FROM productos WHERE id=?";
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
     * Este metodo sirve para poder actualizar los datos de un producto registrado
     * @param pro Parametro para poder actualizar los datos
     * @return Devuelve ya sea verdadero o falso si se pudo acutalizar o no
     */
    public boolean ModificarProductos(Productos pro) {
        String sql = "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId());
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
     * Este metodo sirve para poder identificar a un producto especfico por medio de su codigo
     * @param cod Parametro para poder identificar a un producto especifico
     * @return Devuelve al producto buscado
     */
    public Productos BuscarPro(String cod) {
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    /**
     * Este metodo sirve para poder buscar los datos de la empresa
     * @return Devuelve los datos de la empresa
     */
    public Config buscarDatos() {
        Config conf = new Config();
        String sql = "SELECT * FROM config";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id"));
                conf.setNombre(rs.getString("nombre"));
                conf.setRuc(rs.getInt("ruc"));
                conf.setTelefono(rs.getInt("telefono"));
                conf.setDireccion(rs.getString("direccion"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conf;
    }
    /**
     * Este metodo sirve para poder actualizar los datos de la empresa
     * @param conf Parametro para poder actualizar los datos de la empresa
     * @return Devuelve ya sea verdadero o falso si se pudo actualizar o no
     */
    public boolean ModificarDatos(Config conf) {
        String sql = "UPDATE config SET ruc=?, nombre=?, telefono=?, direccion=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, conf.getRuc());
            ps.setString(2, conf.getNombre());
            ps.setInt(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setInt(5, conf.getId());
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
}
