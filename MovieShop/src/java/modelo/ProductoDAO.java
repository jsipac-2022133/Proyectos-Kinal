package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

//Listar
    public List listar() {
        String sql = "Select Producto.*, Categoria.nombreCategoria from Producto "
                + "inner join Categoria on Producto.idCategoria = Categoria.idCategoria;";
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
                p.setNombreCategoria(rs.getString(11));
                listaProducto.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;

    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "select * from Producto where idProducto=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("portada");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }

//AGREGAR
    public int agregar(Producto p) {
        String sql = "insert into Producto(nombreProducto, genero, categoria, precio, duracion, sinopsis, portada, trailer, idProveedor) values (?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getIdCategoria());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getDuracion());
            ps.setString(6, p.getSinopsis());
            ps.setString(7, p.getPortada());
            ps.setString(8, p.getTrailer());
            ps.setInt(9, p.getIdProveedor());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

//Buscar
    public Producto listarIdProducto(int id) {
        //instanciar objeto producto
        Producto p = new Producto();
        String sql = "Select Producto.*, Categoria.nombreCategoria from Producto "
                + "inner join Categoria on Producto.idCategoria = Categoria.idCategoria where idProducto =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
                p.setNombreCategoria(rs.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
// Ver películas con promoción
    public Producto listarPeliculasPromo(int id){
        Producto prod = new Producto();
        String sql = "select * from Producto where idCategoria = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                prod.setIdProducto(rs.getInt(1));
                prod.setNombreProducto(rs.getString(2));
                prod.setGenero(rs.getString(3));
                prod.setIdCategoria(rs.getInt(4));
                prod.setPrecio(rs.getDouble(5));
                prod.setDuracion(rs.getString(6));
                prod.setSinopsis(rs.getString(7));
                prod.setPortada(rs.getString(8));
                prod.setTrailer(rs.getString(9));
                prod.setIdProveedor(rs.getInt(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prod;
    }
//Editar
    public int actualizar(Producto p) {
        String sql = "Update Producto set nombreProducto=?, genero=?, idCategoria=?, precio=?, duracion=?, sinopsis=?, portada=?, trailer=?, idProveedor=? where idProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getIdCategoria());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getDuracion());
            ps.setString(6, p.getSinopsis());
            ps.setString(7, p.getPortada());
            ps.setString(8, p.getTrailer());
            ps.setInt(9, p.getIdProveedor());            
            ps.setInt(10, p.getIdProducto());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }
    public void actualizarImg(String rutaCompleta, int id) throws FileNotFoundException{
        
       File imagenFile = new File(rutaCompleta);
        FileInputStream Portada = new FileInputStream(imagenFile);
                String sql= "update Producto set portada=?  where idProducto=?";
                try {
                    con = cn.Conexion();
                    ps= con.prepareStatement(sql);
                    ps.setBlob(1, Portada );
                    ps.setInt(2, id);
                    ps.executeUpdate();
                 } catch (Exception e) {
                     e.printStackTrace();
                }
    }

//ELIMINAR
    public void eliminar(int id) {
        String sql = "delete from Producto where idProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

}
