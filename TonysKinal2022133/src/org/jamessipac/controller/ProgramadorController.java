
package org.jamessipac.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jamessipac.main.Principal;

public class ProgramadorController implements Initializable{
    private Principal escenarioPrincipal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
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
    
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Button btnDatos;
    @FXML
    private Button btnContacto;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnDatos){
            lbl1.setText("Programador:");
            lbl2.setText("James Brian Sipac Sipac");
            lbl3.setText("Carnet:");
            lbl4.setText("2022133");
            lbl5.setText("Código Técnico:");
            lbl6.setText("IN5AV");
        }else if(event.getSource()==btnContacto){
            lbl1.setText("Teléfono:");
            lbl2.setText("33410750");
            lbl3.setText("E-mail");
            lbl4.setText("jsipac-2022133@kinal.edu.gt");
            lbl5.setText("Dirección:");
            lbl6.setText("Patzún, Chimaltenango");
        }
    }
    
    
}
