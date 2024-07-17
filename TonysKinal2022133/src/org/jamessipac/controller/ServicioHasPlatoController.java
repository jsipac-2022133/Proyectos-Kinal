
package org.jamessipac.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jamessipac.bean.Plato;
import org.jamessipac.bean.Servicio;
import org.jamessipac.bean.ServicioHasPlato;
import org.jamessipac.db.Conexion;
import org.jamessipac.main.Principal;

public class ServicioHasPlatoController implements Initializable{
    private Principal escenarioPrincipal;
    //VARIABLE PARA REPORTE
    private final String logoTipo = "/org/jamessipac/image/Menu.png";
    private final String fondoReporte = "/org/jamessipac/image/FondoReporte.png";
    private enum operaciones{
        GUARDAR, ELIMINAR, ACTUALIZAR, NINGUNO
    }
    
    private operaciones tipoDeOperacion=operaciones.NINGUNO;
    private ObservableList<ServicioHasPlato> listaServicioHasPlato;
    private ObservableList<Plato> listaPlato;
    private ObservableList<Servicio> listaServicio;
    
    @FXML
    private TextField txtServicioCodigoProducto;
    @FXML
    private ComboBox cmbCodigoPlato;
    @FXML
    private ComboBox cmbCodigoServicio;
    @FXML
    private TableView tblServiciosHasPlatos;
    @FXML
    private TableColumn colServicioCodigoProducto;
    @FXML
    private TableColumn colCodigoPlato;
    @FXML
    private TableColumn colCodigoServicio;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnReporte;
    @FXML
    private ImageView imgNuevo;
    @FXML
    private ImageView imgEliminar;
    @FXML
    private ImageView imgEditar;
    @FXML
    private ImageView imgReporte;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {        
        cargarDatos();
        cmbCodigoPlato.setItems(getPlato());
        cmbCodigoServicio.setItems(getServicio());
        desactivarControles();
    }
    
    public void cargarDatos(){
        tblServiciosHasPlatos.setItems(getServicioHasPlato());
        colServicioCodigoProducto.setCellValueFactory(new PropertyValueFactory<ServicioHasPlato, Integer>("Servicios_codigoProducto"));
        colCodigoPlato.setCellValueFactory(new PropertyValueFactory<ServicioHasPlato, Integer>("codigoPlato"));
        colCodigoServicio.setCellValueFactory(new PropertyValueFactory<ServicioHasPlato, Integer>("codigoServicio"));
    }

    public ObservableList<ServicioHasPlato> getServicioHasPlato(){
        ArrayList<ServicioHasPlato> lista=new ArrayList<ServicioHasPlato>();
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_ListarServicios_has_Platos()");
            ResultSet resultado=procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new ServicioHasPlato(
                    resultado.getInt("Servicios_codigoProducto"),
                    resultado.getInt("codigoPlato"),
                    resultado.getInt("codigoServicio")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaServicioHasPlato=FXCollections.observableArrayList(lista);
    }
    
        public Plato buscarPlato(int codigoPlato){
        Plato resultado=null;
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_BuscarPlato(?)");
            procedimiento.setInt(1, codigoPlato);
            ResultSet registro=procedimiento.executeQuery();
            while(registro.next()){
                resultado=new Plato(registro.getInt("codigoPlato"),
                registro.getInt("cantidad"),
                registro.getString("nombrePlato"),
                registro.getString("descripcionPlato"),
                registro.getDouble("precioPlato"),
                registro.getInt("codigoTipoPlato"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
        public ObservableList<Plato> getPlato(){
        ArrayList<Plato> lista=new ArrayList<Plato>();
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_ListarPlatos");
            ResultSet resultado=procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Plato(
                        resultado.getInt("codigoPlato"),
                        resultado.getInt("cantidad"),
                        resultado.getString("nombrePlato"),
                        resultado.getString("descripcionPlato"),
                        resultado.getDouble("precioPlato"),
                        resultado.getInt("codigoTipoPlato")
                ));
                        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaPlato=FXCollections.observableArrayList(lista);
    }
        
         public Servicio buscarServicio(int codigoServicio) {
        Servicio resultado = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_BuscarServicio(?)");
            procedimiento.setInt(1, codigoServicio);
            ResultSet registro = procedimiento.executeQuery();
            while (registro.next()) {
                resultado = new Servicio(registro.getInt("codigoServicio"),
                        registro.getDate("fechaServicio"),
                        registro.getString("tipoServicio"),
                        registro.getTime("horaServicio"),
                        registro.getString("lugarServicio"),
                        registro.getString("telefonoContacto"),
                        registro.getInt("codigoEmpresa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ObservableList<Servicio> getServicio() {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_ListarServicios()");
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()) {
                lista.add(new Servicio(
                        resultado.getInt("codigoServicio"),
                        resultado.getDate("fechaServicio"),
                        resultado.getString("tipoServicio"),
                        resultado.getTime("horaServicio"),
                        resultado.getString("lugarServicio"),
                        resultado.getString("telefonoContacto"),
                        resultado.getInt("codigoEmpresa")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaServicio = FXCollections.observableArrayList(lista);
    }
    
    public void nuevo(){
         switch (tipoDeOperacion) {
            case NINGUNO:
                cmbCodigoPlato.setValue("");
                cmbCodigoPlato.setValue("");                
                cmbCodigoServicio.setValue("");
                cmbCodigoServicio.setValue("");                
                tblServiciosHasPlatos.getSelectionModel().clearSelection();
                activarControles();
                btnNuevo.setText("Guardar");
                btnEliminar.setText("Cancelar");
                btnEditar.setDisable(true);
                btnReporte.setDisable(true);
                imgNuevo.setImage(new Image("/org/jamessipac/image/Guardar.png"));
                imgEliminar.setImage(new Image("/org/jamessipac/image/Cancelar.png"));
                limpiarControles();
                tipoDeOperacion = operaciones.GUARDAR;
                break;
            case GUARDAR: 
                if(txtServicioCodigoProducto.getText()==null || cmbCodigoPlato.getSelectionModel().isEmpty() || cmbCodigoServicio.getSelectionModel().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
                }else{
                    guardar();
                    desactivarControles();
                    btnNuevo.setText("Nuevo");
                    btnEliminar.setText("Eliminar");
                    btnEditar.setDisable(false);
                    btnReporte.setDisable(false);
                    imgNuevo.setImage(new Image("/org/jamessipac/image/Agregar.png"));
                    imgEliminar.setImage(new Image("/org/jamessipac/image/Eliminar.png"));
                    limpiarControles();
                    activarControles();
                    tipoDeOperacion = operaciones.NINGUNO;
                    cargarDatos();
                    break;
                }
    }
    }
    
    public void guardar(){
        ServicioHasPlato registro=new ServicioHasPlato();
        registro.setServicios_codigoProducto(Integer.parseInt(txtServicioCodigoProducto.getText()));
        registro.setCodigoPlato(((Plato) cmbCodigoPlato.getSelectionModel().getSelectedItem()).getCodigoPlato());
        registro.setCodigoServicio(((Servicio)cmbCodigoServicio.getSelectionModel().getSelectedItem()).getCodigoServicio());
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_AgregarServicios_has_Platos(?,?,?)");
            procedimiento.setInt(1, registro.getServicios_codigoProducto());
            procedimiento.setInt(2, registro.getCodigoPlato());
            procedimiento.setInt(3, registro.getCodigoServicio());
            procedimiento.execute();
            listaServicioHasPlato.add(registro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede repetir el código del registro");
        }
    }
    
    public void seleccionarElemento(){
        ServicioHasPlato servicioHasPlatoSeleccionado=(ServicioHasPlato) tblServiciosHasPlatos.getSelectionModel().getSelectedItem();
        if(servicioHasPlatoSeleccionado != null){
            if(tipoDeOperacion==operaciones.NINGUNO){
                txtServicioCodigoProducto.setText(String.valueOf(((ServicioHasPlato) tblServiciosHasPlatos.getSelectionModel().getSelectedItem()).getServicios_codigoProducto()));
                cmbCodigoPlato.getSelectionModel().select(buscarPlato(((ServicioHasPlato)tblServiciosHasPlatos.getSelectionModel().getSelectedItem()).getCodigoPlato()));
                cmbCodigoServicio.getSelectionModel().select(buscarServicio(((ServicioHasPlato)tblServiciosHasPlatos.getSelectionModel().getSelectedItem()).getCodigoServicio()));
            }else{
            cmbCodigoPlato.getSelectionModel().clearSelection();
            cmbCodigoServicio.getSelectionModel().clearSelection();
            limpiarControles();
        }
        }else{
            limpiarControles();
        }
    }
    
    public void editar(){
        JOptionPane.showMessageDialog(null, "No es posible editar los datos");
    }
    
    public void eliminar(){
        switch (tipoDeOperacion) {
            case GUARDAR:
                limpiarControles();
                desactivarControles();
                btnNuevo.setText("Nuevo");
                btnEliminar.setText("Eliminar");
                btnEditar.setDisable(false);
                btnReporte.setDisable(false);
                imgNuevo.setImage(new Image("/org/jamessipac/image/Agregar.png"));
                imgEliminar.setImage(new Image("/org/jamessipac/image/Eliminar.png"));
                tipoDeOperacion = operaciones.NINGUNO;
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es posible eliminar los datos");
        }
    }
    
        public void verReporte() {
        JasperReport report;
        JasperPrint re;

        try {
            URL in = this.getClass().getResource("/org/jamessipac/report/ReporteServiciosHasPlatos.jasper");
            report = (JasperReport) JRLoader.loadObject(in);
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("logo", this.getClass().getResourceAsStream(logoTipo));
            parametros.put("fondo", this.getClass().getResourceAsStream(fondoReporte));
            re = JasperFillManager.fillReport(report, parametros, Conexion.getInstance().getConexion());
            JasperViewer.viewReport(re, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void desactivarControles(){
        txtServicioCodigoProducto.setEditable(false);
        cmbCodigoPlato.setDisable(true);
        cmbCodigoServicio.setDisable(true);
    }
    
    public void activarControles(){
        txtServicioCodigoProducto.setEditable(true);
        cmbCodigoPlato.setDisable(false);
        cmbCodigoServicio.setDisable(false);
    }
    
    public void limpiarControles(){
        txtServicioCodigoProducto.clear();
        cmbCodigoPlato.getSelectionModel().clearSelection();
        cmbCodigoServicio.getSelectionModel().clearSelection();
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
    private void cantidad(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[0-9]")) {
            event.consume();

        }
    }
}
