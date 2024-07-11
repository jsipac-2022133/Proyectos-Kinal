
package org.jamessipac.modelo;
/**
 * Proveedor represetna la clase que contiene todos los atributos del proveedor
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Proveedor {
    private int id;
    private int ruc;
    private String nombre;
    private int telefono;
    private String direccion;

    public Proveedor() {
    }
    /**
     * Crea un proveedor recibiendo como parametros 5 atirbutos
     * @param id id del proveedor
     * @param ruc ruc del proveedor
     * @param nombre nombre del proveedor
     * @param telefono telefono del proveedor
     * @param direccion direccion del proveedor
     */
    public Proveedor(int id, int ruc, String nombre, int telefono, String direccion) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    /**
     * Devuelve el id del proveedor seleccionado
     * @return devuelve el id de ese proveedor
     */
    public int getId() {
        return id;
    }
    /**
     * Sirve para asignarle un id
     * @param id parametro para asignar id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Devuelve el ruc del proveedor seleccionado
     * @return devuelve el ruc de ese proveedor
     */
    public int getRuc() {
        return ruc;
    }
    /**
     * Sirve para asignarle un ruc 
     * @param ruc parametro para asignar ruc
     */
    public void setRuc(int ruc) {
        this.ruc = ruc;
    }
    /**
     * Devuelve el nombre del proveedor seleccionado
     * @return devuelve el nombre de ese proveedor
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
     * Devuelve el telefono del proveedor seleccionado
     * @return devuelve el telefono de ese proveedor
     */
    public int getTelefono() {
        return telefono;
    }
    /**
     * Sirve para asignarle un telefono
     * @param telefono parametro para asignar telefono
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    /**
     * Devuelve la direccion del proveedor seleccionado
     * @return devuelve la direccion de ese proveedor
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
    
    
    
    
    
}
