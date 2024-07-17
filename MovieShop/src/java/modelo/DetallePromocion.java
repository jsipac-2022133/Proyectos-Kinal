package modelo;

public class DetallePromocion {
    
    private int idDetallePromocion;
    private double precioFinal;
    private int idPromocion;
    private int idProducto;

    public DetallePromocion() {
    }

    public DetallePromocion(int idDetallePromocion, double precioFinal, int idPromocion, int idProducto) {
        this.idDetallePromocion = idDetallePromocion;
        this.precioFinal = precioFinal;
        this.idPromocion = idPromocion;
        this.idProducto = idProducto;
    }

    public int getIdDetallePromocion() {
        return idDetallePromocion;
    }

    public void setIdDetallePromocion(int idDetallePromocion) {
        this.idDetallePromocion = idDetallePromocion;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
