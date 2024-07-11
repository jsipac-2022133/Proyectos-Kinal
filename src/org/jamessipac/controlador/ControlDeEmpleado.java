package org.jamessipac.controlador;
import java.util.ArrayList;
import org.jamessipac.modelo.Empleado;
/**
 * ControlDeEmpleado representa la clase donde se utilizan las funciones del ArrayList
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class ControlDeEmpleado {
   public ArrayList<Empleado> listaDeEmpleados=new ArrayList<Empleado>();
   private static ControlDeEmpleado instancia;
   /**
    * Devuelve la cantidad de empleados qeu tiene en ese momento el ArrayList
    * @return devuelve la cantidad de empleados 
    */  
   public int cantidadEmpleados(){
        return listaDeEmpleados.size();
    }
    /**
     * Devuelve los empleados que conteien en ese momento el ArrayList
     * @return devuelve los empleados 
     */  
    public ArrayList<Empleado> getListaDeEmpleados(){
    return listaDeEmpleados;
    }
    /**
     * Agrega un empleado al ArrayList
     * @param empleado parametro para agregar un empleado
     */
    public void crearEmpleado(Empleado empleado){
    listaDeEmpleados.add(empleado);
    }
    /**
     * Crea una instancia de esta clase
     * @return devuelve la instancia
     */
    public static ControlDeEmpleado getInstancia() {
    if(instancia == null) {
            instancia = new ControlDeEmpleado();
    } return instancia; 
    }//getInstancia
    

}
