
package modelo;

import java.io.InputStream;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private String genero;
    private int idCategoria;
    private double precio;
    private String duracion;
    private String sinopsis;
    private String portada;
    private String trailer;
    private int idProveedor;
    private String nombreCategoria;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String genero, int idCategoria, double precio, String duracion, String sinopsis, String portada, String trailer, int idProveedor, String nombreCategoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.genero = genero;
        this.idCategoria = idCategoria;
        this.precio = precio;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.portada = portada;
        this.trailer = trailer;
        this.idProveedor = idProveedor;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNombreCategoria(){
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }

    
}