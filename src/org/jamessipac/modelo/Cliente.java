package org.jamessipac.modelo;
/**
 * Cliente represetna la clase que contiene todos los atributos del cliente
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class Cliente {
    
    
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    
    
     //contructores
    public Cliente(){}
    /**
     * Crea un cliente recibiendo como parametros 4 atributos
     * @param nombre nombre del cliente
     * @param apellido apellido del cliente
     * @param direccion direccion del cliente
     * @param telefono telefono del cliente
     */
    public Cliente(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;        
    }
    
    //getters y setters

    /**
     * Devuelve el nombre del cliente seleccionado
     * @return devuelve el nombre de ese cliente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Sirve para asignarle un nombre 
     * @param nombre parametro para asignar nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el apellido del cliente seleccionado
     * @return devuelve el apellido de ese cliente
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Sirve para asignarle un apellido
     * @param apellido parametro para asignar apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Devuelve la direccion del cliente seleccionado
     * @return devuelve la direccion de ese cliente
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Sirve para asignarle una direccion
     * @param direccion parametro para asignar direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Devuelve el telefono del cliente seleccionado
     * @return devuelve el telefono de ese cliente
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Sirve para asignarle un telefono 
     * @param telefono parametro para asignar telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
