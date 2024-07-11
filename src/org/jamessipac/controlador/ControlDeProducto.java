package org.jamessipac.controlador;
import java.util.ArrayList;
import org.jamessipac.modelo.Producto;
/**
 * ControlDeProductos representa la clase donde se utilizan las funciones del ArrayList
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class ControlDeProducto {
    
     public ArrayList<Producto> listaDeProductos=new ArrayList<Producto>();
    /**
     * Devuelve la cantidad de productos que tiene en ese momento el ArrayList
     * @return devuelve la cantidad de productos 
     */ 
    public int cantidadProductos(){
        return listaDeProductos.size();
    }
    /**
     * Devuelve los productos que conteien en ese momento el ArrayList
     * @return devuelve los productos
     */  
    public ArrayList<Producto> getListaDeProductos(){
    return listaDeProductos;
    }
    /**
     * Agrega un producto al ArrayList
     * @param producto parametro para agregar un producto
     */
    public void crearProducto(Producto producto){
    listaDeProductos.add(producto);
    }
    

    
    
}
