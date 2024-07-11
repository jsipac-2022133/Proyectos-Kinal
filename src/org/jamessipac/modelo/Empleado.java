package org.jamessipac.modelo;
/**
 * Empleado representa la clase que contiene todos los atributos del empleado
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class Empleado {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    
    //constructores
    public Empleado(){};
    /**
     * Crea un empleado recibiendo como parametros 4 atributos
     * @param id identificador del empleado
     * @param nombre nombre del empleado
     * @param apellido apellido del empleado
     * @param telefono telefono del empleado
     * @param direccion direccion del empleado
     */
    public Empleado(String id, String nombre, String apellido, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    //getters y setters
    /**
     * Devuelve el identificador del empleado seleccionado
     * @return devuelve el identificador de ese cliente
     */
    public String getId() {
        return id;
    }
    /**
     * Sirve para asignarle un identificador
     * @param id parametro para asignar identificador
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Devuelve el nombre del empleado seleccionado
     * @return devuelve el nombre de ese empleado
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
     * Devuelve el apellido del empleado seleccionado
     * @return devuelve el apellido de ese empleado
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
     * Devuelve el telefono del empleado seleccionado
     * @return devuelve el telefono de ese empleado
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
    /**
     * Devuelve la direccion del empleado seleccionado
     * @return devuelve la direccion de ese empleado
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

