
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author SIPAC
 */
public class Historial {
    private int idHistorial;
    private int idUsuario;
    private int idProducto;
    private Timestamp fechaVisualizacion;

    public Historial() {
    }

    public Historial(int idHistorial, int idUsuario, int idProducto, Timestamp fechaVisualizacion) {
        this.idHistorial = idHistorial;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Timestamp getFechaVisualizacion() {
        return fechaVisualizacion;
    }

    public void setFechaVisualizacion(Timestamp fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }
    
    
    
}
