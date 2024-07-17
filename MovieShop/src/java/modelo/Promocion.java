package modelo;

import java.sql.Date;


public class Promocion {
    private int idPromocion;
    private String cartelPromocion;
    private int idCategoria;
    private int porcentajePromocion;
    private Date fechaInicio;
    private Date fechaFinal;
    private String nombreCategoria;

    public Promocion() {
    }

    public Promocion(int idPromocion, String cartelPromocion, int idCategoria, int porcentajePromocion, Date fechaInicio, Date fechaFinal, String nombreCategoria) {
        this.idPromocion = idPromocion;
        this.cartelPromocion = cartelPromocion;
        this.idCategoria = idCategoria;
        this.porcentajePromocion = porcentajePromocion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getCartelPromocion() {
        return cartelPromocion;
    }

    public void setCartelPromocion(String cartelPromocion) {
        this.cartelPromocion = cartelPromocion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public int getPorcentajePromocion() {
        return porcentajePromocion;
    }

    public void setPorcentajePromocion(int porcentajePromocion) {
        this.porcentajePromocion = porcentajePromocion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public String getNombreCategoria(){
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
    
}
