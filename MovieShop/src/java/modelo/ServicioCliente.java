
package modelo;

public class ServicioCliente {
    private int idServicio;
    private String descripcion;
    private int idUsuario;
    private int idProducto;

    public ServicioCliente() {
    }

    public ServicioCliente(int idServicio, String descripcion, int idUsuario, int idProducto) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    
}
