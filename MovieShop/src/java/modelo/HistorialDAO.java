package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SIPAC
 */
public class HistorialDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar(int idUsuario) {
        String sql = "WITH ProductosConRowNumber AS (\n"
                + "    SELECT \n"
                + "        P.idProducto,\n"
                + "        P.nombreProducto,\n"
                + "        P.genero,\n"
                + "        P.idCategoria,\n"
                + "        P.precio,\n"
                + "        P.duracion,\n"
                + "        P.sinopsis,\n"
                + "        P.portada,\n"
                + "        P.trailer,\n"
                + "        P.idProveedor,\n"
                + "        H.fechaVisualizacion,\n"
                + "        ROW_NUMBER() OVER (PARTITION BY P.idProducto ORDER BY H.fechaVisualizacion DESC) AS rn\n"
                + "    FROM Producto P\n"
                + "    INNER JOIN Historial H ON H.idProducto = P.idProducto\n"
                + "    WHERE H.idUsuario = " + idUsuario + "\n"
                + ")\n"
                + "SELECT \n"
                + "    idProducto,\n"
                + "    nombreProducto,\n"
                + "    genero,\n"
                + "    idCategoria,\n"
                + "    precio,\n"
                + "    duracion,\n"
                + "    sinopsis,\n"
                + "    portada,\n"
                + "    trailer,\n"
                + "    idProveedor\n"
                + "FROM ProductosConRowNumber\n"
                + "WHERE rn = 1\n"
                + "ORDER BY fechaVisualizacion DESC";
        List<Producto> listaProducto = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setGenero(rs.getString(3));
                p.setIdCategoria(rs.getInt(4));
                p.setPrecio(rs.getDouble(5));
                p.setDuracion(rs.getString(6));
                p.setSinopsis(rs.getString(7));
                p.setPortada(rs.getString(8));
                p.setTrailer(rs.getString(9));
                p.setIdProveedor(rs.getInt(10));
                listaProducto.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;

    }

    public int agregar(int idUsuario, int idProducto) {
        String sql = "insert into Historial(idUsuario, idProducto)values(?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setInt(2, idProducto);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int idUsusario, int idProducto){
        String sql="delete from Historial where idUsuario="+idUsusario+" and idProducto="+idProducto;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
