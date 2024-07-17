package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoTarjetaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "select * from TipoTarjeta";
        List<TipoTarjeta> listaTipoTarjeta = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoTarjeta tT = new TipoTarjeta();
                tT.setIdTipoTarjeta(rs.getInt(1));
                tT.setTipoTarjeta(rs.getString(2));
                listaTipoTarjeta.add(tT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTipoTarjeta;
    }
    
    public int agregar(TipoTarjeta tT){
        String sql = "insert into TipoTarjeta(tipoTarjeta) values(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tT.getTipoTarjeta());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public TipoTarjeta listaTipoTarjeta(int id){
        TipoTarjeta tT = new TipoTarjeta();
        String sql = "select * from TipoTarjeta where idTipoTarjeta = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tT.setIdTipoTarjeta(rs.getInt(1));
                tT.setTipoTarjeta(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tT;
    }
    
    public int actualizar(TipoTarjeta tT){
        String sql = "update TipoTarjeta set TipoTarjeta = ? where idTipoTarjeta = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tT.getTipoTarjeta());
            ps.setInt(2, tT.getIdTipoTarjeta());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "delete from TipoTarjeta where idTipoTarjeta = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
