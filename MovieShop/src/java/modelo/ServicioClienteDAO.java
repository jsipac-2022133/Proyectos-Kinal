package modelo;

import java.sql.Connection;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;



    public List listar() {
        String sql = "Select * from ServicioCliente;";
        List<ServicioCliente> listarServicioCliente = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ServicioCliente scl = new ServicioCliente();
                scl.setIdServicio(rs.getInt(1));
                scl.setDescripcion(rs.getString(2));
                scl.setIdUsuario(rs.getInt(3));
                scl.setIdProducto(rs.getInt(4));
                listarServicioCliente.add(scl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listarServicioCliente;
    }

    //Agregar
    public int agregar(ServicioCliente scl) {
        String sql = "Insert into ServicioCliente ( descripcion, idUsuario, idProducto) values (?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, scl.getDescripcion());
            ps.setInt(2, scl.getIdUsuario());
            ps.setInt(3, scl.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // metodo buscar por codigo
    public ServicioCliente listarServicioCliente(int id) {
        //  instanciar un objeto Empleado
        ServicioCliente scl = new ServicioCliente();
        String sql = "Select * from ServicioCliente where idServicio = id";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                scl.setDescripcion(rs.getString(2));
                scl.setIdUsuario(rs.getInt(3));
                scl.setIdProducto(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scl;
    }

    //metodo Editar
    public int actualizar(ServicioCliente scl) {
        String sql = "Update ServicioCliente" + " set descripcion= ?," + "idUsuario= ?," + "idProducto= ?," + "Where idServicio=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, scl.getDescripcion());
            ps.setInt(2, scl.getIdUsuario());
            ps.setInt(3, scl.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Eliminar
    public void eliminar(int id) {
        String sql = "delete from ServicioCliente where idServicio =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
