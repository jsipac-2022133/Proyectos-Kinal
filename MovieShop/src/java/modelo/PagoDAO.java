package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "select * from Pago";
        List<Pago> listaPago = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pago pa = new Pago();
                pa.setIdPago(rs.getInt(1));
                pa.setCantidadAPagar(rs.getDouble(2));
                pa.setIdTipoTarjeta(rs.getInt(3));
                pa.setFechaPago(rs.getDate(4));
                pa.setIdUsuario(rs.getInt(5));
                listaPago.add(pa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPago;
    }
    
    public int agregar(Pago pa){
        String sql = "Insert into Pago (cantidadAPagar, idTipoTarjeta,fechaPago, idUsuario) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, pa.getCantidadAPagar());
            ps.setInt(2, pa.getIdTipoTarjeta());
            ps.setDate(3, pa.getFechaPago());
            ps.setInt(4, pa.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Pago listarCodigoPago(int id){
        Pago pa = new Pago();
        String sql = "select * from Pago where codigoPago = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pa.setIdPago(rs.getInt(1));
                pa.setCantidadAPagar(rs.getDouble(2));
                pa.setIdTipoTarjeta(rs.getInt(3));
                pa.setFechaPago(rs.getDate(4));
                pa.setIdUsuario(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pa;
    }
}
