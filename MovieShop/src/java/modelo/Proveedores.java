package modelo;


public class Proveedores {
    public int idProveedor;
    public String nombreProveedor;
    public String telefonoProveedor;
    public String email;
    
    public Proveedores(){
    
    }
    public Proveedores(int idProveedor, String nombreProveedor, String telefonoProveedor, String email){
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.email = email;
    }
    public int getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNombreProveedor(){
        return nombreProveedor;
    }
    public void setNombreProveedor(String nombreProveedor){
        this.nombreProveedor = nombreProveedor;
    }
    public String getTelefonoProveedor(){
        return telefonoProveedor;
    }
    public void setTelefonoProveedor(String telefonoProveedor){
        this.telefonoProveedor = telefonoProveedor;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
