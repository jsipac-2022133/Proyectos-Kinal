
package org.jamessipac.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.jamessipac.main.Principal;

public class MenuPrincipalController implements Initializable{
    private Principal escenarioPrincipal;    
    @FXML
    private Button btnCerrarSesion;
    final Tooltip cerrar=new Tooltip();
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
             cerrar.setText("Cerrar la sesión activa");
        btnCerrarSesion.setTooltip(cerrar);

       /* btnCerrarSesion.setOnMouseEntered(event -> {
            PauseTransition pause = new PauseTransition(Duration.millis(100));
            pause.setOnFinished(e -> cerrar.show(btnCerrarSesion, event.getScreenX(), event.getScreenY()));
            pause.play();
        });

        btnCerrarSesion.setOnMouseExited(event -> cerrar.hide());*/
    }
    

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
   public void menuPrincipal(){
       escenarioPrincipal.menuPrincipal();
   }
   public void ventanaProgramador(){
       escenarioPrincipal.ventanaProgramador();
   }
   public void ventanaEmpresa(){
       escenarioPrincipal.ventanaEmpresa();
   }
   public void ventanaProducto(){
       escenarioPrincipal.ventanaProducto();
   }
   
   public void ventanaTipoEmpleado(){
       escenarioPrincipal.ventanaTipoEmpleado();
   }
   
   public void ventanaTipoPlato(){
       escenarioPrincipal.ventanaTipoPlato();
   }
   public void ventanaEmpleado(){
       escenarioPrincipal.ventanaEmpleado();
   }
   public void ventanaPresupuesto(){
       escenarioPrincipal.ventanaPresupuesto();
   }
   public void ventanaPlato(){
       escenarioPrincipal.ventanaPlato();
   }
   public void ventanaServicioHasEmpleado(){
       escenarioPrincipal.ventanaServicioHasEmpleado();
   }
   public void ventanaProductoHasPlato(){
       escenarioPrincipal.ventanaProductoHasPlato();
   }
   public void ventanaServicioHasPlato(){
       escenarioPrincipal.ventanaServicioHasPlato();
   }
   public void ventanaLogin(){
       escenarioPrincipal.ventanaLogin();
   }
   public void ventanaUsuario(){
       escenarioPrincipal.ventanaUsuario();
   }
}