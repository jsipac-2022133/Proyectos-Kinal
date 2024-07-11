package org.jamessipac.modelo;
/**
 * Restaurante representa la clase que contiene todos los atributos del restaurante
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class Restaurante {
   private String id;
   private String calle;
   private String zona;
   private String lugar;
   private String telefono;
   
   //contructores
   public Restaurante(){};
   /**
    * Crea un restaurante recibiendo como parametros 5 atributos
    * @param id identificador del restaurante
    * @param calle calle del restaurante
    * @param zona zona del restaurante
    * @param lugar lugar del restaurante
    * @param telefono telefono del restaurante
    */
    public Restaurante(String id,String calle, String zona, String lugar, String telefono) {
        this.id=id;
        this.calle = calle;
        this.zona = zona;
        this.lugar = lugar;
        this.telefono = telefono;
    }
    
    
    //métodos get y set
    /**
     * Devuelve el identificador del restaurante seleccionado
     * @return devuelve el identificador de ese restaurante
     */
    public String getId() {    
        return id;
    }
    /**
     * Sirve para asignar un identificador
     * @param id parametro para asignar identificador
     */    
    public void setId(String id) {    
        this.id = id;
    }
    /**
     * Devuelve la calle del restaurante seleccionado
     * @return devuelve la calle de ese restaurante
     */
    public String getCalle() {
        return calle;
    }
    /**
     * Sirve para asignarle una calle
     * @param calle parametro para asignar calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * Devuelve la zona del restaurante seleccionado
     * @return devuelve la zona de ese restaurante
     */
    public String getZona() {
        return zona;
    }
    /**
     * Sirve para asignarle una zona 
     * @param zona parametro para asignar zona
     */
    public void setZona(String zona) {
        this.zona = zona;
    }
    /**
     * Devuelve el lugar del restaurante seleccionado
     * @return devuelve el lugar de ese restaurante
     */
    public String getLugar() {
        return lugar;
    }
    /**
     * Sirve para asignarle un lugar 
     * @param lugar parametro para asignar lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    /**
     * Devuelve el telefono del restaurante seleccionado
     * @return devuelve el telefono de ese restaurante
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
