package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetallePromocionDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    //Listar
    public List listar() {
        String sql = "select * from DetallePromocion";
        List<DetallePromocion> listaDetallePromocion = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetallePromocion dp = new DetallePromocion();
                dp.setIdDetallePromocion(rs.getInt(1));
                dp.setPrecioFinal(rs.getDouble(2));
                dp.setIdPromocion(rs.getInt(3));
                dp.setIdProducto(rs.getInt(4));
                listaDetallePromocion.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDetallePromocion;
    }

    //Agregar
    public int agregar(DetallePromocion dp) {
        String sql = "Insert into DetallePromocion (precioFinal, idPromocion, idProducto)"
                + "values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dp.getPrecioFinal());
            ps.setInt(2, dp.getIdPromocion());
            ps.setInt(3, dp.getIdProducto());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    //Buscar
    public DetallePromocion listarIdDetallePromocion(int id) {
        DetallePromocion dp = new DetallePromocion();
        String sql = "select * from DetallePromocion where idDetallePromocion = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dp.setPrecioFinal(rs.getDouble(2));
                dp.setIdPromocion(rs.getInt(3));
                dp.setIdProducto(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dp;
    }

    public DetallePromocion listarIdProducto(int id) {
        DetallePromocion dp = new DetallePromocion();
        String sql = "select * from DetallePromocion where idProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dp.setPrecioFinal(rs.getDouble(2));
                dp.setIdPromocion(rs.getInt(3));
                dp.setIdProducto(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dp;
    }

    public void calcularYActualizarPrecioFinal(int detallePromocionId) {
        // Realiza el cálculo y la actualización del precio final
        DetallePromocion dp = new DetallePromocion();
        String updateSql = "UPDATE DetallePromocion D "
                + "INNER JOIN Producto P ON D.idProducto = P.idProducto "
                + "INNER JOIN Promocion PR ON D.idPromocion = PR.idPromocion "
                + "SET D.precioFinal = truncate(P.precio - (P.precio * (PR.porcentajePromocion / 100)),2) "
                + "WHERE D.idProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(updateSql);
            ps.setInt(1, detallePromocionId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
 }

}