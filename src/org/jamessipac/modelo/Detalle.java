package org.jamessipac.modelo;

/**
 * Detalle representa la clase en la que se realizan las uniones de diferentes
 * entidades
 *
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Detalle {

    private int id;
    private String cod_pro;
    private int cantidad;
    private double precio;
    private int id_venta;

    public Detalle() {
    }
    /**
     * Crea el detalle recibiendo como parametros 5 atributos
     * @param id id del detalle
     * @param cod_pro codigo del producto
     * @param cantidad cantidad de productos
     * @param precio precio del producto
     * @param id_venta id de la venta
     */
    public Detalle(int id, String cod_pro, int cantidad, double precio, int id_venta) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_venta = id_venta;
    }
    /**
     * Devuelve el id de la consulta seleccionada
     * @return devuelve el id de esa consulta
     */
    public int getId() {
        return id;
    }
    /**
     * Sirve para asignar un id 
     * @param id parametro para asignar id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Devuelve el codigo del producto seleccionado
     * @return devuelve el codigo de ese producto
     */
    public String getCod_pro() {
        return cod_pro;
    }
    /**
     * Sirve para asignarle un codigo
     * @param cod_pro parametro para asignar codigo
     */
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }
    /**
     * Devuelve la cantidad de productos a vender
     * @return devuelve la cantidad de productos
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Sirve para asignarle una cantidad
     * @param cantidad parametro para asignar cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    /**
     * Devuelve el id de la venta seleccionada
     * @return devuelve el id de esa venta
     */
    public int getId_venta() {
        return id_venta;
    }
    /**
     * Sirve para asignarle un id a la venta
     * @param id_venta parametro para asignar id a la venta
     */
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

}
