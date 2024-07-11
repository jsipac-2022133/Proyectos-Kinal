
package org.jamessipac.modelo;
/**
 * Productos representa la clase que conteien todos los atributos del producto
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Productos {
    private int id;
    private String codigo;
    private String nombre;
    private String proveedor;
    private int stock;
    private double precio;
    
    public Productos(){        
    }
    /**
     * Crea un producto recibiendo como parametros 6 atributos
     * @param id id del producto
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param proveedor proveedor del producto
     * @param stock stock del producto
     * @param precio precio del producto
     */
    public Productos(int id, String codigo, String nombre, String proveedor, int stock, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
    }
    /**
     * Devuelve el id del producto seleccionado
     * @return devuelve el id de ese producto
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
     * Devuelve el codigo del producto seleccionado
     * @return devuleve el codigo de ese producto
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Sirve para asignarle un codigo
     * @param codigo parametro para asignar codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Devuelve el nombre del producto seleccionado
     * @return devuelve el nombre de ese produto
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
     * Devuelve el proveedor del producto seleccionado
     * @return devuelve el nombre de ese proveedor
     */
    public String getProveedor() {
        return proveedor;
    }
    /**
     * Sirve para asignar un proveedor
     * @param proveedor parametro para asignar proveedor
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    /**
     * Devuelve la cantidad disponible del producto seleccionado
     * @return devuelve la cantidad disponible de es producto
     */
    public int getStock() {
        return stock;
    }
    /**
     * Sirve para asignarle un stock
     * @param stock parametro para asignar stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * Devuelve el precio del producto seleccionado
     * @return devuelve el precio de ese producto
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Sirve para asignarle un precio
     * @param precio parametro para asignar precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
