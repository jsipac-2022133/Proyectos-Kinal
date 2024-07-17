package modelo;

import java.sql.Date;

public class Cesta {
    private int idCesta;
    private int cantidad;
    private Date fechaProducto;
    private double subTotal;
    private int idUsuario;
    private int idProducto;

    public Cesta() {
    }

    public Cesta(int idCesta, int cantidad, Date fechaProducto, double subTotal, int idUsuario, int idProducto) {
        this.idCesta = idCesta;
        this.cantidad = cantidad;
        this.fechaProducto = fechaProducto;
        this.subTotal = subTotal;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    

    public int getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(int idCesta) {
        this.idCesta = idCesta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(Date fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}

