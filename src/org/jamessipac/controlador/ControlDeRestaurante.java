package org.jamessipac.controlador;
import java.util.ArrayList;
import org.jamessipac.modelo.Restaurante;
/**
 * ControlDeRestaurante represetna la clase donde se utilizan las funciones del ArrayList
 * @author James Sipac
 */
public class ControlDeRestaurante {
    public ArrayList<Restaurante> listaDeRestaurantes=new ArrayList<Restaurante>();
    private static ControlDeRestaurante instancia;
    /**
     * Devuelve la cantidad de restaurantes tiene en ese momento el ArrayList
     * @return devuelve la cantidad de restaurantes
     */ 
    public int cantidadRestaurantes(){
        return listaDeRestaurantes.size();
    }
    /**
     * Devuelve los restaurantes que conteien en en ese momento el ArrayList
     * @return devuelve los restaurantes 
     */  
    public ArrayList<Restaurante> getListaDeRestaurantes(){
    return listaDeRestaurantes;
    }
    /**
     * Agrega un restaurante al ArrayList
     * @param retaurante parametro para agregar restaurante
     */
    public void crearRestaurante(Restaurante retaurante){
    listaDeRestaurantes.add(retaurante);
    }
    /**
     * Crea una instancia de esta clase
     * @return retorna la instancia
     */
    public static ControlDeRestaurante getInstancia() {
    if(instancia == null) {
            instancia = new ControlDeRestaurante();
    } return instancia; 
    }//getInstancia
    
}
