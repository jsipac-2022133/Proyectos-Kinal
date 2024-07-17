package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServletResponse;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public Usuario validar(String usuario, String pass) {
        Usuario usua = new Usuario();
        String sql = "select * from Usuarios where usuario = ? and pass = ? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                usua.setIdUsuario(rs.getInt("idUsuario"));
                usua.setNombreUsuario(rs.getString("nombreUsuario"));
                usua.setApellidoUsuario(rs.getString("apellidoUsuario"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setPass(rs.getString("pass"));
                usua.setEmail(rs.getString("email"));
                usua.setFotoPerfil(rs.getString(7));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usua;
    }

    // Agregar Usuario
    public int Agregar(Usuario u) {
        String sql = "insert into Usuarios(nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getApellidoUsuario());
            ps.setString(3, u.getUsuario());
            ps.setString(4, u.getPass());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getFotoPerfil());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void actualizarImg(String rutaCompleta, int id) throws FileNotFoundException {

        String sql = "update Usuarios set fotoPerfil=?  where idUsuario=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rutaCompleta);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int actualizarUsuario(Usuario us) {
        String sql = "update Usuarios "
                + "set usuario = ?"
                + "where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUsuario());
            ps.setInt(2, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizarContra(Usuario us) {
        String sql = "update Usuarios "
                + "set pass = ?"
                + "where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getPass());
            ps.setInt(2, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizarFotoPerfil(Usuario us) {
        String sql = "update Usuarios "
                + "set fotoPerfil = ?"
                + "where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getFotoPerfil());
            ps.setInt(2, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizarEmail(Usuario us) {
        String sql = "update Usuarios "
                + "set email = ?"
                + "where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getEmail());
            ps.setInt(2, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizarNombre(Usuario us) {
        String sql = "update Usuarios "
                + "set nombreUsuario = ?"
                + "where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombreUsuario());
            ps.setInt(2, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public int actualizarApellido(Usuario us) {
        String sql = "update Usuarios "
                + "set apellidoUsuario = ?"
                + "where idUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getApellidoUsuario());
            ps.setInt(2, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public List listar() {
        String sql = "Select * from Usuarios";
        List<Usuario> listaUsuario = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usua = new Usuario();
                usua.setIdUsuario(rs.getInt(1));
                usua.setNombreUsuario(rs.getString(2));
                usua.setApellidoUsuario(rs.getString(3));
                usua.setUsuario(rs.getString(4));
                usua.setPass(rs.getString(5));
                usua.setEmail(rs.getString(6));
                usua.setFotoPerfil(rs.getString(7));
                System.out.println(usua.getFotoPerfil());
                listaUsuario.add(usua);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }

    public Usuario listarIdUsuario(int id) {
        Usuario usua = new Usuario();
        String sql = "select * from Usuarios where idUsuario=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usua.setIdUsuario(rs.getInt(1));
                usua.setNombreUsuario(rs.getString(2));
                usua.setApellidoUsuario(rs.getString(3));
                usua.setUsuario(rs.getString(4));
                usua.setPass(rs.getString(5));
                usua.setEmail(rs.getString(6));
                usua.setFotoPerfil(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usua;
    }

    public void eliminarUsuario(int id) {
        String sql = "Delete from Usuarios where idUsuario = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Usuario ELIMINADOOOOO");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
