
package org.jamessipac.modelo;
/**
 * login representa la clase en la que contiene todos los atributos para poder ingresar al programa
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class login {
    private int id;
    private String nombre;
    private String correo;
    private String pass;
    private String rol;

    public login() {
    }
    /**
     * Crea una cuenta recibiendo como parametros 5 atributos
     * @param id id de la cuenta
     * @param nombre nombre del usuario
     * @param correo correo del usuario
     * @param pass contraseña del usuario
     * @param rol rol de la persona
     */
    public login(int id, String nombre, String correo, String pass, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.rol=rol;
    }
    /**
     * Devuelve el id de la cuenta seleccionada
     * @return devuelve el id de la cuenta de esa persona
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
     * Devuelve el nombre del usuario selessionado
     * @return 
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
     * Devuelve el correo del usuario seleccionado
     * @return devuelve el correo de ese usuario
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Sirve para asignarle un correo
     * @param correo parametro para asignar correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Devuelve la contraseña del usuario seleccionado
     * @return devuelve la contraseña de ese usuario
     */
    public String getPass() {
        return pass;
    }
    /**
     * Devuelve el rol del usuario seleccionado
     * @return devuelve el rol de ese usuario
     */
    public String getRol() {
        return rol;
    }
    /**
     * Sirve para asignarle un rol a persona
     * @param rol parametro para asignar rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    /**
     * Sirve para asignarle una contraseña
     * @param pass parametro para asignar contraseña
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
