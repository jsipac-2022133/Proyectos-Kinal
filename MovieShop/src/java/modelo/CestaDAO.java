package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CestaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    
// Listar
    public List listar(){
        String sql="Select * from Cesta";
        List<Cesta> listaCesta=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cesta c=new Cesta();
                c.setIdCesta(rs.getInt(1));
                c.setCantidad(rs.getInt(2));
                c.setFechaProducto(rs.getDate(3));
                c.setSubTotal(rs.getDouble(4));
                c.setIdUsuario(rs.getInt(5));
                c.setIdProducto(rs.getInt(6));
                listaCesta.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCesta;
    }   
    
// Agregar
    public int Agregar( Cesta c){
        String sql="Insert into Cesta (cantidad, fechaProducto, subtotal, idUsuario, idProducto)\n" +
"	values(?,?,?,?,?);";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getCantidad());
            ps.setDate(2,c.getFechaProducto());
            ps.setDouble(3, c.getSubTotal());
            ps.setInt(4, c.getIdUsuario());
            ps.setInt(5, c.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();        
        }
        return resp;
    }
    
// Listar Por Id
    public Cesta listarIdCesta(int id){
        //instanciar objeto producto
        Cesta c=new Cesta();
        String sql="select * from Cesta where idCesta="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setCantidad(rs.getInt(2));
                c.setFechaProducto(rs.getDate(3));
                c.setSubTotal(rs.getDouble(4));
                c.setIdUsuario(rs.getInt(5));
                c.setIdProducto(rs.getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
    
   public Objeto listaIdUsuario(int idUsuario) {
    List<Cesta> listaCesta = new ArrayList<>();
    String sql = "SELECT * FROM Cesta WHERE idUsuario ="+idUsuario;
    double sumaSubtotales = 0.0;
    
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        
        
        while (rs.next()) {
            Cesta c = new Cesta();
            c.setIdCesta(rs.getInt(1));
            c.setCantidad(rs.getInt(2));
            c.setFechaProducto(rs.getDate(3));
            double subtotal = rs.getDouble(4);
            c.setSubTotal(subtotal);
            c.setIdUsuario(rs.getInt(5));
            c.setIdProducto(rs.getInt(6));
            
            sumaSubtotales += subtotal;
            // No es necesario asignar el idUsuario aquí, ya que estamos consultando por idUsuario
            listaCesta.add(c);
        }
       
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    Objeto objeto = new Objeto();
    objeto.setListaCesta(listaCesta);
    objeto.setSumaSubtotales(sumaSubtotales);
    
    return objeto;
    }
   
   public int actualizar(Cesta c){
        String sql="Update Cesta set cantidad=?, fechaProducto=?, subtotal=?, idUsuario=?, idProducto=? where idCesta= ?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getCantidad());
            ps.setDate(2, c.getFechaProducto());
            ps.setDouble(3, c.getSubTotal());
            ps.setInt(4, c.getIdUsuario());
            ps.setInt(5, c.getIdProducto());
            ps.setInt(6, c.getIdCesta());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
   

    
// Actualizar
    public int actualizarId(Cesta c){
        String sql="Update Cesta set cantidad=?, fechaProducto=?, subtotal=? where idCesta= ?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getCantidad());
            ps.setDate(2, c.getFechaProducto());
            ps.setDouble(3, c.getSubTotal());
            ps.setInt(4, c.getIdCesta());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
// Eliminar
    public void eliminar(int id){
        String sql="delete from Cesta where idCesta="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarId(int id){
        String sql="delete from Cesta where idCesta="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
