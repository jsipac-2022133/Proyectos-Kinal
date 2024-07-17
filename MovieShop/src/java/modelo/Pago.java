package modelo;

import java.sql.Date;

public class Pago {
    
    private int idPago;
    private double cantidadAPagar;
    private int idTipoTarjeta;
    private Date fechaPago;
    private int idUsuario;

    public Pago() {
    }

    public Pago(int idPago, double cantidadAPagar, int idTipoTarjeta, Date fechaPago, int idUsuario) {
        this.idPago = idPago;
        this.cantidadAPagar = cantidadAPagar;
        this.idTipoTarjeta = idTipoTarjeta;
        this.fechaPago = fechaPago;
        this.idUsuario = idUsuario;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getCantidadAPagar() {
        return cantidadAPagar;
    }

    public void setCantidadAPagar(double cantidadAPagar) {
        this.cantidadAPagar = cantidadAPagar;
    }

    public int getIdTipoTarjeta() {
        return idTipoTarjeta;
    }

    public void setIdTipoTarjeta(int idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
