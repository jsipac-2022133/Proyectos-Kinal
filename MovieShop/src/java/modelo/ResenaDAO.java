package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResenaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    // Listar
    public List listar() {
        String sql  = "Select * from Resena";
        List<Resena> listaResena = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Resena r = new Resena();
                r.setIdResena(rs.getInt(1));
                r.setFechaValoracion(rs.getDate(2));
                r.setCalificacion(rs.getInt(3));
                r.setResena(rs.getString(4));
                r.setIdUsuario(rs.getInt(5));
                r.setIdProducto(rs.getInt(6));
                listaResena.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaResena;
    }
    
    //Agregar
    public int agregar(Resena r) {
        String sql = "Insert into Resena (fechaValoracion, calificacion, resena, idUsuario, idProducto) "
                + "values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(r.getFechaValoracion().getTime()));
            ps.setInt(2, r.getCalificacion());
            ps.setString(3, r.getResena());
            ps.setInt(4, r.getIdUsuario());
            ps.setInt(5, r.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //Buscar
    public Resena listarIdResena(int id) {
        Resena r = new Resena();
        String sql = "select * from Resena where idResena = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                r.setFechaValoracion(rs.getDate(2));
                r.setCalificacion(rs.getInt(3));
                r.setResena(rs.getString(4));
                r.setIdUsuario(rs.getInt(5));
                r.setIdProducto(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public Resena listarIdProductoResena(int id){
        Resena r = new Resena();
        String sql = "select * from Resena where idProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setIdResena(rs.getInt(1));
                r.setFechaValoracion(rs.getDate(2));
                r.setCalificacion(rs.getInt(3));
                r.setResena(rs.getString(4));
                r.setIdUsuario(rs.getInt(5));
                r.setIdProducto(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    //Editar
    public int actualizar(Resena r) {
        String sql = "Update Resena set fechaValoracion = ?, calificacion = ?, resena = ? where idResena = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(r.getFechaValoracion().getTime()));
            ps.setInt(2, r.getCalificacion());
            ps.setString(3, r.getResena());
            ps.setInt(4, r.getIdResena());
            ps.executeUpdate();       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resp;
    }
    
    //Eliminar
    public void eliminar(int id){
        String sql = "delete from Resena where idResena = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
