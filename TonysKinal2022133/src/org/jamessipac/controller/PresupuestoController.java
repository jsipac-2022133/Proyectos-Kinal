package org.jamessipac.controller;

import eu.schudt.javafx.controls.calendar.DatePicker;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jamessipac.bean.Empresa;
import org.jamessipac.bean.Presupuesto;
import org.jamessipac.db.Conexion;
import org.jamessipac.main.Principal;
import org.jamessipac.report.GenerarReporte;

public class PresupuestoController implements Initializable {
    
    //VARIABLE PARA REPORTE
    private final String logoTipo="/org/jamessipac/image/Menu.png";
    private final String fondoReporte="/org/jamessipac/image/FondoReporte.png";

    private Principal escenarioPrincipal;

    private enum operaciones {
        GUARDAR, ELIMINAR, ACTUALIZAR, NINGUNO
    }
    private operaciones tipoDeOperacion = operaciones.NINGUNO;
    private ObservableList<Presupuesto> listaPresupuesto;
    private ObservableList<Empresa> listaEmpresa;
    private DatePicker fecha;

    @FXML
    private TextField txtCodigoPresupuesto;
    @FXML
    private TextField txtCantidadPresupuesto;
    @FXML
    private GridPane grpFecha;
    @FXML
    private ComboBox cmbCodigoEmpresa;
    @FXML
    private TableView tblPresupuestos;
    @FXML
    private TableColumn colCodigoPresupuesto;
    @FXML
    private TableColumn colFechaSolicitud;
    @FXML
    private TableColumn colCantidadPresupuesto;
    @FXML
    private TableColumn colCodigoEmpresa;
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
        fecha = new DatePicker(Locale.ENGLISH); //El lenguaje que quiere el objeto
        fecha.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        fecha.getCalendarView().todayButtonTextProperty().setValue("Today"); //Para que nos muestre la fecha de hoy
        fecha.getCalendarView().setShowWeeks(false);
        fecha.getStylesheets().add("/org/jamessipac/resource/TonysKinal.css");
        fecha.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            event.consume(); // No permite la entrada de caracteres
        });
        grpFecha.add(fecha, 3, 0);
        cmbCodigoEmpresa.setItems(getEmpresa());

        desactivarControles();
    }

    public void cargarDatos() {
        tblPresupuestos.setItems(getPresupuesto());
        colCodigoPresupuesto.setCellValueFactory(new PropertyValueFactory<Presupuesto, Integer>("codigoPresupuesto"));
        colFechaSolicitud.setCellValueFactory(new PropertyValueFactory<Presupuesto, Date>("fechaSolicitud"));
        colCantidadPresupuesto.setCellValueFactory(new PropertyValueFactory<Presupuesto, Double>("cantidadPresupuesto"));
        colCodigoEmpresa.setCellValueFactory(new PropertyValueFactory<Presupuesto, Integer>("codigoEmpresa"));
    }

 

    public void seleccionarElemento() {
        Presupuesto presupuestoSeleccionado = (Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem();
        
        if (presupuestoSeleccionado != null) {
            if(tipoDeOperacion==operaciones.NINGUNO){
            txtCodigoPresupuesto.setText(String.valueOf(((Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem()).getCodigoPresupuesto()));
            fecha.selectedDateProperty().set(((Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem()).getFechaSolicitud());
            txtCantidadPresupuesto.setText(String.valueOf(((Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem()).getCantidadPresupuesto()));
            cmbCodigoEmpresa.getSelectionModel().select(buscarEmpresa(((Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem()).getCodigoEmpresa()));
            }else{
                cmbCodigoEmpresa.getSelectionModel().clearSelection();
                tblPresupuestos.getSelectionModel().clearSelection();
                limpiarControles();                
            }
           

        } else {
            limpiarControles();
        }
    }

     public Empresa buscarEmpresa(int codigoEmpresa) {
        Empresa resultado = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_BuscarEmpresa(?)");
            procedimiento.setInt(1, codigoEmpresa);
            ResultSet registro = procedimiento.executeQuery();
            while (registro.next()) {
                resultado = new Empresa(registro.getInt("codigoEmpresa"),
                        registro.getString("nombreEmpresa"),
                        registro.getString("direccion"),
                        registro.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ObservableList<Presupuesto> getPresupuesto() {
        ArrayList<Presupuesto> lista = new ArrayList<Presupuesto>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_ListarPresupuestos()");
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()) {
                lista.add(new Presupuesto(
                        resultado.getInt("codigoPresupuesto"),
                        resultado.getDate("fechaSolicitud"),
                        resultado.getDouble("cantidadPresupuesto"),
                        resultado.getInt("codigoEmpresa")
                ));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPresupuesto = FXCollections.observableArrayList(lista);
    }

    public ObservableList<Empresa> getEmpresa() {
        ArrayList<Empresa> lista = new ArrayList<Empresa>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_ListarEmpresas");
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()) {
                lista.add(new Empresa(resultado.getInt("codigoEmpresa"),
                        resultado.getString("nombreEmpresa"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpresa = FXCollections.observableArrayList(lista);
    }

    public void nuevo() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                cmbCodigoEmpresa.setValue("");
                tblPresupuestos.getSelectionModel().clearSelection();
                fecha.requestFocus();
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
                if (fecha.getSelectedDate() == null || txtCantidadPresupuesto.getText().isEmpty() || cmbCodigoEmpresa.getSelectionModel().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
                } else {
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

    public void guardar() {
        Presupuesto registro = new Presupuesto();
        registro.setFechaSolicitud(fecha.getSelectedDate());
        registro.setCantidadPresupuesto(Double.parseDouble(txtCantidadPresupuesto.getText()));
        registro.setCodigoEmpresa(((Empresa) cmbCodigoEmpresa.getSelectionModel().getSelectedItem()).getCodigoEmpresa());
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_AgregarPresupuesto(?,?,?)");
            procedimiento.setDate(1, new java.sql.Date(registro.getFechaSolicitud().getTime()));
            procedimiento.setDouble(2, registro.getCantidadPresupuesto());
            procedimiento.setInt(3, registro.getCodigoEmpresa());
            procedimiento.execute();
            listaPresupuesto.add(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public void editar() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                if (tblPresupuestos.getSelectionModel().getSelectedItem() != null) {
                    btnEditar.setText("Actualizar");
                    btnReporte.setText("Cancelar");
                    btnNuevo.setDisable(true);
                    btnEliminar.setDisable(true);
                    imgEditar.setImage(new Image("/org/jamessipac/image/Actualizar.png"));
                    imgReporte.setImage(new Image("/org/jamessipac/image/Cancelar.png"));
                    activarControles();
                    cmbCodigoEmpresa.setDisable(true);
                    tipoDeOperacion = operaciones.ACTUALIZAR;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
                }
                break;
            case ACTUALIZAR:
                actualizar();
                btnEditar.setText("Editar");
                btnReporte.setText("Reporte");
                btnNuevo.setDisable(false);
                btnEliminar.setDisable(false);
                imgEditar.setImage(new Image("/org/jamessipac/image/Editar.png"));
                imgReporte.setImage(new Image("/org/jamessipac/image/Reporte.png"));
                limpiarControles();
                desactivarControles();
                tipoDeOperacion = operaciones.NINGUNO;
                cmbCodigoEmpresa.setDisable(false);
                cmbCodigoEmpresa.setValue("");
                cargarDatos();
                break;
        }
    }

    public void actualizar() {
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EditarPresupuesto(?,?,?)");
            Presupuesto registro = (Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem();
            registro.setFechaSolicitud(fecha.getSelectedDate());
            registro.setCantidadPresupuesto(Double.parseDouble(txtCantidadPresupuesto.getText()));
            procedimiento.setInt(1, registro.getCodigoPresupuesto());
            procedimiento.setDate(2, new java.sql.Date(registro.getFechaSolicitud().getTime()));
            procedimiento.setDouble(3, registro.getCantidadPresupuesto());
            procedimiento.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar el registro");
                            limpiarControles();  
        }
    }

    public void eliminar() {
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
                cmbCodigoEmpresa.setDisable(false);
                tblPresupuestos.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
            default:
                if (tblPresupuestos.getSelectionModel().getSelectedItem() != null) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?", "Eliminar Presupuesto", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EliminarPresupuesto(?)");
                            procedimiento.setInt(1, (((Presupuesto) tblPresupuestos.getSelectionModel().getSelectedItem()).getCodigoPresupuesto()));
                            procedimiento.execute();
                            listaEmpresa.remove(tblPresupuestos.getSelectionModel().getSelectedItem());
                            limpiarControles();
                            cargarDatos();
                            cmbCodigoEmpresa.setValue("");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "No se puede eliminar el registro");
                            limpiarControles();   
                        }
                    } else if (respuesta == JOptionPane.NO_OPTION) {
                        limpiarControles();
                        tblPresupuestos.getSelectionModel().clearSelection();
                        cmbCodigoEmpresa.setValue("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila");
                }
        }
    }

    public void reporte() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                verReporte();
                break;
            case ACTUALIZAR:
                limpiarControles();
                desactivarControles();
                btnEditar.setText("Editar");
                btnReporte.setText("Reporte");
                btnNuevo.setDisable(false);
                btnEliminar.setDisable(false);
                imgEditar.setImage(new Image("/org/jamessipac/image/Editar.png"));
                imgReporte.setImage(new Image("/org/jamessipac/image/Reporte.png"));
                cmbCodigoEmpresa.setDisable(false);
                cmbCodigoEmpresa.setValue("");
                tblPresupuestos.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
        }
    }

            public void verReporte(){
        JasperReport report;
        JasperPrint re;
        
        try {
            URL in=this.getClass().getResource("/org/jamessipac/report/ReportePresupuesto.jasper");
            report=(JasperReport)JRLoader.loadObject(in);
            Map parametros=new HashMap();
            parametros.clear();
            parametros.put("logo", this.getClass().getResourceAsStream(logoTipo));
            parametros.put("fondo", this.getClass().getResourceAsStream(fondoReporte));
            re=JasperFillManager.fillReport(report, parametros, Conexion.getInstance().getConexion());
            JasperViewer.viewReport(re,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void desactivarControles() {
        txtCodigoPresupuesto.setEditable(false);
        fecha.setDisable(true);
        txtCantidadPresupuesto.setEditable(false);
        cmbCodigoEmpresa.setDisable(true);
    }

    public void activarControles() {
        txtCodigoPresupuesto.setEditable(false);
        fecha.setDisable(false);
        txtCantidadPresupuesto.setEditable(true);
        cmbCodigoEmpresa.setDisable(false);
    }

    public void limpiarControles() {
        txtCodigoPresupuesto.clear();
        fecha.setSelectedDate(null);
        txtCantidadPresupuesto.clear();
        cmbCodigoEmpresa.getSelectionModel().clearSelection();
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void menuPrincipal() {
        escenarioPrincipal.menuPrincipal();
    }

    public void ventanaEmpresa() {
        escenarioPrincipal.ventanaEmpresa();
    }
    
        @FXML
    private void numeros(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[0-9.]")) {
            event.consume();

        }
        if(txtCantidadPresupuesto.getText().contains(".") && !caracter.matches("[0-9]") ){
            event.consume();
        }
    }
}
