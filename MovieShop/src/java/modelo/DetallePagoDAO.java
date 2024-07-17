
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetallePagoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    // Método Listar DetallePago
    
    public List listar(){
        String sql = "select*from DetallePago";
        List<DetallePago> listaDetallePago = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DetallePago dp = new DetallePago();
                dp.setIdDetallePago(rs.getInt(1));
                dp.setCantidad(rs.getInt(2));
                dp.setIdPago(rs.getInt(3));
                dp.setIdCesta(rs.getInt(4));
                listaDetallePago.add(dp);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
           return listaDetallePago; 
    }
    
    //Método Agregar DetallePago
    
    public int agregar (DetallePago dep){
        String sql = "insert into DetallePago( cantidad,  idPago, idCesta)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dep.getCantidad());
           
            ps.setInt(2, dep.getIdPago());
            ps.setInt(3, dep.getIdCesta());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;    
    }
    
    // Método de buscar por Código
//    public DetallePago listarCodigoDetallePago (int id){
//        DetallePago dep = new DetallePago ();
//        String sql ="select*from DetallePago where idDetallePago"+id;
//        try {
//            con = cn.Conexion();
//            ps=con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                dep.setCantidad(rs.getInt(2));
//                dep.setIdProducto(rs.getInt(3));
//                dep.setIdPago(rs.getInt(4));
//                dep.setIdCesta(rs.getInt(5));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dep;
//    }
    

    
    // Método de Eliminar DetallePago
////    public void eliminar(int id){
////        String sql = "delete from DetalleEmpleado where idDetallePago = "+id;
////        try {
////            con = cn.Conexion();
////            ps = con.prepareStatement(sql);
////            ps.executeUpdate();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        
////    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
