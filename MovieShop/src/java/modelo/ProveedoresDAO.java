package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Proveedores validar(String nombreProveedor, String telefonoProveedor, String email){
        Proveedores proveedores = new Proveedores();
        String sql = "select * from Proveedores where nombreProveedor = ? and telefonoProveedor = ? and email = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreProveedor);
            ps.setString(2, telefonoProveedor);
            ps.setString(3, email);
            rs = ps.executeQuery();
            while(rs.next()){
                proveedores.setIdProveedor(rs.getInt("idProveedor"));
                proveedores.setNombreProveedor(rs.getString("nombreProveedor"));
                proveedores.setTelefonoProveedor(rs.getString("telefonoProveedor"));
                proveedores.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedores;
    }
    public int agregar(Proveedores prov){
        String sql = "insert into Proveedores(nombreProveedor, telefonoProveedor, email)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getTelefonoProveedor());
            ps.setString(3, prov.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return resp;
    }
    public List listar(){
        String sql = "select * from Proveedores";
        List<Proveedores> listaDeProveedores = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Proveedores proveedores = new Proveedores();
                proveedores.setIdProveedor(rs.getInt(1));
                proveedores.setNombreProveedor(rs.getString(2));
                proveedores.setTelefonoProveedor(rs.getString(3));
                proveedores.setEmail(rs.getString(4));
                listaDeProveedores.add(proveedores);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDeProveedores;
    }
    public Proveedores listarCodigoProveedor(int id){
        Proveedores prov = new Proveedores();
        String sql = "select * from Proveedores where idProveedor = "+ id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                prov.setNombreProveedor(rs.getString(2));
                prov.setTelefonoProveedor(rs.getString(3));
                prov.setEmail(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prov;
    }
    public int actualizar(Proveedores prov){
        String sql= "update Proveedores "
                    + "set nombreProveedor = ?,"
                    + " telefonoProveedor = ?,"
                    + " email = ?"
                    + " where idProveedor = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getTelefonoProveedor());
            ps.setString(3, prov.getEmail());
            ps.setInt(4, prov.getIdProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    public void eliminar(int id){
        String sql = "delete from Proveedores where idProveedor = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
