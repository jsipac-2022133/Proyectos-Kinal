
package org.jamessipac.modelo;
/**
 * Venta repersenta la clase qeu conteine todos los atirbutos de la venta
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Venta {
    private int id;
    private String cliente;
    private String vendedor;
    private double total;
    private String fecha;
    
    public Venta(){        
    }
    /**
     * Crea una venta recibiendo como parametros 5 atributos
     * @param id id de la venta
     * @param cliente cleinte de la venta
     * @param vendedor vendedor
     * @param total total de la venta
     * @param fecha fecha de la venta
     */
    public Venta(int id, String cliente, String vendedor, double total, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
        this.fecha=fecha;        
    }
    /**
     * Devuelve el id de la venta seleccionada
     * @return devuelve el id de esa venta
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
     * Devuelve el cliente de la venta seleccionada
     * @return devuelve el cliente de esa venta
     */
    public String getCliente() {
        return cliente;
    }
    /**
     * Sirve para asignarle un cliente a la venta
     * @param cliente parametro para asignar cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    /**
     * Devuelve el vendedor de la venta seleccionada
     * @return devuelve el vendedor de esa venta
     */
    public String getVendedor() {
        return vendedor;
    }
    /**
     * Sirve para asignarle un vendedor
     * @param vendedor parametro para asignar vendedor
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    /**
     * Devuelve el total de la venta seleccionada
     * @return devuelve el total de esa venta
     */
    public double getTotal() {
        return total;
    }
    /**
     * Sirve para asignarle un total a la venta
     * @param total parametro para asignar total
     */
    public void setTotal(double total) {
        this.total = total;
    }
    /**
     * Devuelve la fecha de la venta seleccionada
     * @return devuelve la fecha de esa venta
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Sirve para asignarle una fecha
     * @param fecha parametro para asignar fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
    
    
}
