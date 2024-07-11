
package org.jamessipac.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jamessipac.modelo.Conexion;
import org.jamessipac.modelo.Detalle;
import org.jamessipac.modelo.Venta;
/**
 * ControlDeVenta representa la clse donde se almacenan diferentes metodos para poder realizar el CRUD con las ventas
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class ControlDeVenta {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    /**
     * Este metodo sirve para poder realizar el grafico de las ventas
     * @return Devuelve la venta con más valor
     */
    public int idVenta(){
        int id=0;
        String sql="SELECT MAX(id) FROM ventas";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                id=rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
            
    /**
     * Este metodo sirve para poder agregar una nueva venta a la base de datos
     * @param v Parametro para poder agregar la nueva venta
     * @return Devuelve la venta seleccionada
     */
    public int RegistrarVenta(Venta v){
        String sql="INSERT INTO ventas(cliente, vendedor, total, fecha) VALUES (?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.setString(4, v.getFecha());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    /**
     * Este metodo sirve para poder agregar datos al detalle
     * @param dv Parametro para poder agregar esos datos
     * @return Devuelve los datos del detalle
     */
    public int RegistrarDetalle(Detalle dv){
        String sql="INSERT INTO detalle(cod_producto, cantidad, precio, id_venta) VALUES (?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, dv.getCod_pro());
            ps.setInt(2, dv.getCantidad());
            ps.setDouble(3, dv.getPrecio());
            ps.setInt(4, dv.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    /**
     * Este metodo sirve para poder actualizar la cantidad disponibles de productos despues de una venta
     * @param cant Parametro para poder acutalizar el stock disponible
     * @param cod Parametro para poder identificar al producto a actualizar
     * @return Devuelve ya sea verdadero o falso si se pudo actualzar o no
     */
    public boolean actualizarStock(int cant, String cod){
        String sql="UPDATE productos SET stock=? WHERE codigo=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute(); 
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    /**
     * Este metodo sirve para poder mostrar todas las ventas en la tabla
     * @return Devuelve todos los datos de todas las ventas
     */
    public ArrayList listarVentas() {
        ArrayList<Venta> listaVenta = new ArrayList();
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta vent = new Venta();
                vent.setId(rs.getInt("id"));
                vent.setCliente(rs.getString("cliente"));
                vent.setVendedor(rs.getString("vendedor"));
                vent.setTotal(rs.getDouble("total"));
                listaVenta.add(vent);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaVenta;
    }
}
