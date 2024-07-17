/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santiago
 */
public class CategoriaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public int agregar(Categoria cat){
        String sql = "insert into Categoria(nombreCategoria) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getNombreCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return resp;
    }
    // Método que verifica si la categoria posee o no peliculas antes de ser eliminado
    public int categoriaEnUso(int idCategoria) {
        int cantidadReferencias = 0;
        String sql = "select count(p.idProducto) as CantidadReferencias " +
                     "from Categoria c " +
                     "left join Producto p on c.idCategoria = p.idCategoria " +
                     "where c.idCategoria = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCategoria);

            rs = ps.executeQuery();

            if (rs.next()) {
                cantidadReferencias = rs.getInt("CantidadReferencias");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cantidadReferencias;
    }
     public Categoria listarCategoriaId(int id){
        Categoria categ = new Categoria();
        String sql = "select * from Categoria where idCategoria ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                categ.setIdCategoria(rs.getInt(1));
                categ.setNombreCategoria(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categ;
    }
    public int Actualizar(Categoria categ){
        String sql = "update Categoria "
                + "set nombreCategoria = ?"
                + "where idCategoria = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, categ.getNombreCategoria());
            ps.setInt(2, categ.getIdCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    public void Eliminar(int id){
        String sql = "delete from Categoria where idCategoria = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List listar(){
        String sql = "select * from Categoria";
        List<Categoria> listaDeCategorias = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNombreCategoria(rs.getString(2));
                listaDeCategorias.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDeCategorias;
    }
    
}
