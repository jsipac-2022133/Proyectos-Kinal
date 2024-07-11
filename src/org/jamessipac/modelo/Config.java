
package org.jamessipac.modelo;
/**
 * Config representa la clase que contiene todos los atributos de la empresa
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Config {
    private int id;
    private int ruc;
    private String nombre;
    private int telefono;
    private String direccion;
    
    public Config(){        
    }
    /**
     * Crea a la empresa recibiendo como parametros 4 atributos
     * @param id id de la empresa
     * @param ruc ruc de la empresa
     * @param nombre nombre de la empresa
     * @param telefono telefono de la empresa
     * @param direccion direccion de la empresa
     */
    public Config(int id, int ruc, String nombre, int telefono, String direccion) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    /**
     * Devuelve el id de la empresa seleccionada
     * @return devuelve el id de esa empresa
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
     * Devuelve el ruc de la empresa seleccionada
     * @return devuelve el ruc de esa empresa
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
     * Devuelve el nombre de la emrpesa seleccionada
     * @return devuelve el nombre de esa empresa
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
     * Devuelve el telefono de la empresa seleccionada
     * @return devuelve el telefono de esa empresa
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
     * Devuelve la direccion de la empresa seleccionada
     * @return devuleve la direccion de esa empresa
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
