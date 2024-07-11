package org.jamessipac.controlador;
import java.util.ArrayList;
import org.jamessipac.modelo.Cliente;
/**
 * ControlDeCliete representa la clase donde se utilizan las diferentes funciones del ArrayList
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class ControlDeCliente {
    private ArrayList<Cliente> listaDeClientes=new ArrayList<Cliente>();
    /**
     * Devuelve la cantidad de clientes qeu tiene en ese momento el ArrayList
     * @return devuelve la catnidad de clientes
     */ 
    public int cantidadClientes(){
        return listaDeClientes.size();
    }
    /**
     * Devuelve los clientes que contiene en ese momento el ArrayList
     * @return devuelve los clientes
     */  
    public ArrayList<Cliente> getListaDeClientes(){
    return listaDeClientes;
    }
    /**
     * Agrega un cliente al ArrayList
     * @param cliente parametro para agregar un cliente
     */
    public void crearCliente(Cliente cliente){
    listaDeClientes.add(cliente);
    }
    

}
