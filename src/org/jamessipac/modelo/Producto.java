package org.jamessipac.modelo;
/**
 * Producto representa la calse que contiene todos los atributos del producto
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class Producto {
    private String id;
    private String nombre;
    private String categoria;
    private String precio;
    
    //contructores
    public Producto(){}
    /**
     * Crea un producto recibiendo como parametros 4 atributos
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param categoria categoria del producto
     * @param precio precio del producto
     */
    public Producto(String id, String nombre, String categoria, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria=categoria;
        this.precio = precio;
    }
    
    //getters y setters
    /**
     * Devuelve el identificador del producto seleccionado
     * @return devuelve el identificador de ese producto
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
     * Devuelve el nombre del producto seleccionado
     * @return devuelve el identificadro de ese producto
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
     * Devuelve la categoria del producto seleccionado
     * @return devuelve la categoria de ese producto
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * Sirve para asignarle una categoria 
     * @param categoria parametro para asignar categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /**
     * Devuelve el precio del producto seleccionado
     * @return devuelve el precio de ese producto
     */    
    public String getPrecio() {
        return precio;
    }
    /**
     * Sirve pra asignarle un precio
     * @param precio parametro para asignar precio
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    

   
    
    
    
}