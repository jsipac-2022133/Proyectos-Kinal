package org.jamessipac.modelo;
/**
 * Venta representa la clase que contiene todos los atributos de la venta
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class Venta {
   private int id;
   private String nombreProducto;
   private int cantidad;
   private double precio;
   private double importe;

    public Venta() {
    }
    /**
     * Devuelve el identificador de la venta seleccionada
     * @return devuelve el identificador de esa venta
     */
    public int getId() {
        return id;
    }
    /**
     * Sirve para asignarle un identificador
     * @param id parametro para asignar identificador
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Devuelve el nombre del producto seleccionado
     * @return devuelve el nombre de ese producto
     */
    public String getNombre() { 
        return nombreProducto;
    }
    /**
     * Sirve para asignarle un nombre
     * @param nombreProducto parametro para asignar nombre
     */
    public void setNombre(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    /**
     * Devuelve la cantidad de productos en venta
     * @return devuelve la cantidad de productos
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Sirve para asignar la cantidad de productos a vender
     * @param cantidad parametro para asignar cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Devuelve el precio del producto seleccionado
     * @return devuelve el preco de ese prodcto
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
    /**
     * Devuelve el importe de la venta
     * @return devuelve el importe de la venta
     */
    public double getImporte() {
        return importe;
    }
    /**
     * Sirve para asignar un importe de venta
     * @param importe parametro para asignar importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
   
   
   
   
   
   
}
