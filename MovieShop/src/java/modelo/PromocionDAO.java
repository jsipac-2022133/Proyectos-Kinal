package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PromocionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    
    public int agregar(Promocion prom){
        String sql = "Insert into Promocion (cartelPromocion, idCategoria, porcentajePromocion, fechaInicio, fechaFinal) values(?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prom.getCartelPromocion());
            ps.setInt(2, prom.getIdCategoria());
            ps.setInt(3, prom.getPorcentajePromocion());
            ps.setDate(4, prom.getFechaInicio());
            ps.setDate(5, prom.getFechaFinal());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
    public Promocion listarCodigoPromocion(int id){
        Promocion prom = new Promocion();
        String sql = "Select Promocion.*, Categoria.nombreCategoria from Promocion "
                + "inner join Categoria on Promocion.idCategoria = Categoria.idCategoria where idPromocion ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                prom.setIdPromocion(rs.getInt(1));
                prom.setCartelPromocion(rs.getString(2));
                prom.setIdCategoria(rs.getInt(3));
                prom.setPorcentajePromocion(rs.getInt(4));
                prom.setFechaInicio(rs.getDate(5));
                prom.setFechaFinal(rs.getDate(6));
                prom.setNombreCategoria(rs.getString(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return prom;
    }
    
    public int actualizar(Promocion prom) {
        String sql = "Update Promocion "
                + "set cartelPromocion = ?, "
                + "idCategoria = ?,"
                + "porcentajePromocion = ?,"
                + "fechaInicio = ?, "
                + "fechaFinal = ?"
                + "where idPromocion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prom.getCartelPromocion());
            ps.setInt(2, prom.getIdCategoria());
            ps.setInt(3, prom.getPorcentajePromocion());
            ps.setDate(4,prom.getFechaInicio());
            ps.setDate(5, prom.getFechaFinal());
            ps.setInt(6, prom.getIdPromocion());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return resp;
    }
       
    
    public void eliminar(int id){
        String sql = "delete from Promocion where idPromocion = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // Envia el id de la promocion vencida y la manda a una variable la cual procedera a llamar al metodo eliminar
    public List listarPromocionesVencidas(){
        String sql = "select idPromocion from Promocion where fechaFinal <= curdate()";
        List<Promocion> listaPromocionesVencidas = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Promocion promo = new Promocion();
                promo.setIdPromocion(rs.getInt(1));
                listaPromocionesVencidas.add(promo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPromocionesVencidas;
    }
    
    public List listarPromocionesVigentes(){
        String sql = "select Promocion.*, Categoria.nombreCategoria from Promocion "
                + "inner join Categoria on Promocion.idCategoria = Categoria.idCategoria "
                + "where fechaInicio <= curdate() and curdate() <= fechaFinal";
        List<Promocion> listaPromocionVigente = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Promocion promo = new Promocion();
                promo.setIdPromocion(rs.getInt(1));
                promo.setCartelPromocion(rs.getString(2));
                promo.setIdCategoria(rs.getInt(3));
                promo.setPorcentajePromocion(rs.getInt(4));
                promo.setFechaInicio(rs.getDate(5));
                promo.setFechaFinal(rs.getDate(6));
                promo.setNombreCategoria(rs.getString(7));
                listaPromocionVigente.add(promo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPromocionVigente;
    }
    
    public List listar(){
        String sql = "select Promocion.*, Categoria.nombreCategoria from Promocion "
                + "inner join Categoria on Promocion.idCategoria = Categoria.idCategoria";
        List<Promocion> listaPromocion = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Promocion promo = new Promocion();
                promo.setIdPromocion(rs.getInt(1));
                promo.setCartelPromocion(rs.getString(2));
                promo.setIdCategoria(rs.getInt(3));
                promo.setPorcentajePromocion(rs.getInt(4));
                promo.setFechaInicio(rs.getDate(5));
                promo.setFechaFinal(rs.getDate(6));
                promo.setNombreCategoria(rs.getString(7));
                listaPromocion.add(promo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaPromocion;
    }
}
