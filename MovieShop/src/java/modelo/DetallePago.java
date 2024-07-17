
package modelo;

public class DetallePago {
    private int idDetallePago;
    private int cantidad;
    
    private int idPago;
    private int idCesta;

    public DetallePago() {
    }

    public DetallePago(int idDetallePago, int cantidad, int idPago, int idCesta) {
        this.idDetallePago = idDetallePago;
        this.cantidad = cantidad;
       
        this.idPago = idPago;
        this.idCesta = idCesta;
    }

    public int getIdDetallePago() {
        return idDetallePago;
    }

    public void setIdDetallePago(int idDetallePago) {
        this.idDetallePago = idDetallePago;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(int idCesta) {
        this.idCesta = idCesta;
    }
    
    
}
