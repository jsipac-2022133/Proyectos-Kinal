/*
    Programador:        James Brian Sipac Sipac
    Carnet:             2022133
    Creación:           28/03/2023
    Modificaciones:     28/03/2023, 11/04/2023, 18/04/2023, 19/04/2023, 25/04/2023, 10/5/2023
 */
package org.jamessipac.main;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.jamessipac.controller.EmpleadoController;
import org.jamessipac.controller.EmpresaController;
import org.jamessipac.controller.LoginController;
import org.jamessipac.controller.MenuPrincipalController;
import org.jamessipac.controller.PlatoController;
import org.jamessipac.controller.PresupuestoController;
import org.jamessipac.controller.ProductoController;
import org.jamessipac.controller.ProductoHasPlatoController;
import org.jamessipac.controller.ProgramadorController;
import org.jamessipac.controller.ServicioController;
import org.jamessipac.controller.ServicioHasEmpleadoController;
import org.jamessipac.controller.ServicioHasPlatoController;
import org.jamessipac.controller.TipoEmpleadoController;
import org.jamessipac.controller.TipoPlatoController;
import org.jamessipac.controller.UsuarioController;

public class Principal extends Application { 
    


    private final String PAQUETE_VISTA = "/org/jamessipac/view/";
    private Stage escenarioPrincipal;
    private Scene escena;

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("Tony's Kinal 2023");
        escenarioPrincipal.getIcons().add(new Image("/org/jamessipac/image/Menu.png"));
        // Parent root = FXMLLoader.load(getClass().getResource("/org/jamessipac/view/MenuPrincipalView.fxml"));
        // Scene escena = new Scene(root);
        // escenarioPrincipal.setScene(escena);
        
        
        
        ventanaLogin();
        escenarioPrincipal.show();
    }

    public void menuPrincipal() {
        try {
            MenuPrincipalController menu = (MenuPrincipalController) cambiarEscena("MenuPrincipalView.fxml", 398, 400);
            menu.setEscenarioPrincipal(this);   
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ventanaProgramador() {
        try {
            ProgramadorController progra = (ProgramadorController) cambiarEscena("ProgramadorView.fxml", 514, 370);
            progra.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ventanaEmpresa() {
        try {
            EmpresaController empresaController = (EmpresaController) cambiarEscena("EmpresaView.fxml", 806, 500);
            empresaController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ventanaProducto() {
        try {
            ProductoController productoController = (ProductoController) cambiarEscena("ProductoView.fxml", 743, 500);
            productoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ventanaTipoEmpleado() {
        try {
            TipoEmpleadoController tipoEmpleadoController = (TipoEmpleadoController) cambiarEscena("TipoEmpleadoView.fxml", 743, 500);
            tipoEmpleadoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ventanaTipoPlato() {
        try {
            TipoPlatoController tipoPlatoController = (TipoPlatoController) cambiarEscena("TipoPlatoView.fxml", 743, 500);
            tipoPlatoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ventanaEmpleado() {
        try {
            EmpleadoController empleadoController = (EmpleadoController) cambiarEscena("EmpleadoView.fxml", 1349, 506);
            empleadoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ventanaPresupuesto(){
        try {
            PresupuestoController presupuestoController=(PresupuestoController) cambiarEscena("PresupuestoView.fxml", 816, 500);
            presupuestoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ventanaPlato(){
        try {
            PlatoController platoController=(PlatoController) cambiarEscena("PlatoView.fxml", 1104, 506);
            platoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ventanaServicio(){
        try {
            ServicioController servicioController=(ServicioController)cambiarEscena("ServicioView.fxml", 1297, 506);
            servicioController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ventanaServicioHasEmpleado(){
        try {
            ServicioHasEmpleadoController servicioHasEmpleadoController =(ServicioHasEmpleadoController) cambiarEscena("ServicioHasEmpleadoView.fxml", 1284, 506);
            servicioHasEmpleadoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ventanaProductoHasPlato(){
        try {
            ProductoHasPlatoController productoHasPlatoController=(ProductoHasPlatoController) cambiarEscena("ProductoHasPlatoView.fxml", 797, 500);
            productoHasPlatoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ventanaServicioHasPlato(){
        try {
            ServicioHasPlatoController servicioHasPlatoController=(ServicioHasPlatoController) cambiarEscena("ServicioHasPlatoView.fxml", 797, 500);
            servicioHasPlatoController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ventanaLogin(){
        try {
            LoginController loginController=(LoginController) cambiarEscena("LoginView.fxml", 396, 525);
            loginController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public void ventanaUsuario(){
        try {
            UsuarioController usuarioController=(UsuarioController) cambiarEscena("UsuarioView.fxml", 688, 475);
            usuarioController.setEscenarioPrincipal(this);
            escenarioPrincipal.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws Exception {
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA + fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA + fxml));
        escena = new Scene((AnchorPane) cargadorFXML.load(archivo), ancho, alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable) cargadorFXML.getController();
        return resultado;

    }



}
