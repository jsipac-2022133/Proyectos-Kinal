
package org.jamessipac.modelo;
/**
 * Cliente representa la clase que contiene todos los atributos del cliente
 * @author James Sipac
 * @since 10 de septiembre 2022
 */
public class Cliente {
    private int id;
    private int dni;
    private String nombre;
    private int telefono;
    private String direccion;

    public Cliente() {
    }
    /**
     * Crea un cliente recibiendo como parámetros 5 atributos
     * @param id id del cliente
     * @param dni dni del cliente
     * @param nombre nombre del cliente
     * @param telefono telefono del cliente
     * @param direccion direccion del cliente
     */
    public Cliente(int id, int dni, String nombre, int telefono, String direccion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    /**
     * Devuelve el id del cliente seleccionado
     * @return devuelve el id de ese cliente
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
     * Devuelve el dni del cliente seleccionado
     * @return devuelve el dni de ese cliente
     */
    public int getDni() {
        return dni;
    }
    /**
     * Sirve para asignarle un dni 
     * @param dni parametro para asignar dni
     */
    public void setDni(int dni) {
        this.dni = dni;
    }
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
     * Devuelve el telefono del cliente seleccionado
     * @return devuelve el telefono de ese cliente
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
    
    
    
    
}
