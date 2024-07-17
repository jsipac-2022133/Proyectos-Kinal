package org.jamessipac.controller;

import com.jfoenix.controls.JFXTimePicker;
import eu.schudt.javafx.controls.calendar.DatePicker;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import org.jamessipac.bean.Servicio;
import org.jamessipac.db.Conexion;
import org.jamessipac.main.Principal;

public class ServicioController implements Initializable {

    //VARIABLE PARA REPORTE
    private final String logoTipo="/org/jamessipac/image/Menu.png";
    private final String fondoReporte="/org/jamessipac/image/FondoReporte.png";
    
    private Principal escenarioPrincipal;

    private enum operaciones {
        GUARDAR, ELIMINAR, ACTUALIZAR, NINGUNO
    }
    private operaciones tipoDeOperacion = operaciones.NINGUNO;
    private ObservableList<Servicio> listaServicio;
    private ObservableList<Empresa> listaEmpresa;
    private DatePicker fecha;

    @FXML
    private TextField txtCodigoServicio;
    @FXML
    private TextField txtTipoServicio;
    @FXML
    private JFXTimePicker tpHoraServicio;
    @FXML
    private TextField txtLugarServicio;
    @FXML
    private TextField txtTelefonoServicio;
    @FXML
    private ComboBox cmbCodigoEmpresa;
    @FXML
    private GridPane grpFecha;
    @FXML
    private TableView tblServicios;
    @FXML
    private TableColumn colCodigoServicio;
    @FXML
    private TableColumn colFechaServicio;
    @FXML
    private TableColumn colTipoServicio;
    @FXML
    private TableColumn colHoraServicio;
    @FXML
    private TableColumn colLugarServicio;
    @FXML
    private TableColumn colTelefonoServicio;
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

        tpHoraServicio.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            event.consume(); // No permite la entrada de caracteres
        });
    }

    public void cargarDatos() {
        tblServicios.setItems(getServicio());
        colCodigoServicio.setCellValueFactory(new PropertyValueFactory<Servicio, Integer>("codigoServicio"));
        colFechaServicio.setCellValueFactory(new PropertyValueFactory<Servicio, Date>("fechaServicio"));
        colTipoServicio.setCellValueFactory(new PropertyValueFactory<Servicio, String>("tipoServicio"));
        colHoraServicio.setCellValueFactory(new PropertyValueFactory<Servicio, Time>("horaServicio"));
        colLugarServicio.setCellValueFactory(new PropertyValueFactory<Servicio, String>("lugarServicio"));
        colTelefonoServicio.setCellValueFactory(new PropertyValueFactory<Servicio, String>("telefonoContacto"));
        colCodigoEmpresa.setCellValueFactory(new PropertyValueFactory<Servicio, Integer>("codigoEmpresa"));
    }

   public void seleccionarElemento() {
        Servicio servicioSeleccionado = (Servicio) tblServicios.getSelectionModel().getSelectedItem();
        if (servicioSeleccionado != null) {
            if (tipoDeOperacion == operaciones.NINGUNO) {
                txtCodigoServicio.setText(String.valueOf(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getCodigoServicio()));
                fecha.selectedDateProperty().set(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getFechaServicio());
                txtTipoServicio.setText(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getTipoServicio());
                               
             tblServicios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String horaText = (String.valueOf(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getHoraServicio()));
                try {
                    LocalTime hora = LocalTime.parse(horaText, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    tpHoraServicio.setValue(hora);
                } catch (Exception e) {
                    System.out.println("Error: Formato de hora inválido");
                }
            }
        });              
                txtLugarServicio.setText(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getLugarServicio());
                txtTelefonoServicio.setText(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getTelefonoContacto());
                cmbCodigoEmpresa.getSelectionModel().select(buscarEmpresa(((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getCodigoEmpresa()));
            } else {
                cmbCodigoEmpresa.getSelectionModel().clearSelection();
                tblServicios.getSelectionModel().clearSelection();
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
                tblServicios.getSelectionModel().clearSelection();
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
                if (fecha.getSelectedDate() == null || txtTipoServicio.getText().isEmpty() || tpHoraServicio.getValue() == null
                        || txtLugarServicio.getText().isEmpty() || txtTelefonoServicio.getText().isEmpty() || cmbCodigoEmpresa.getSelectionModel().isEmpty()) {
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
        Servicio registro = new Servicio();
        registro.setFechaServicio(fecha.getSelectedDate());
        registro.setTipoServicio(txtTipoServicio.getText());
        registro.setHoraServicio(Time.valueOf(tpHoraServicio.getValue()));
        registro.setLugarServicio(txtLugarServicio.getText());
        registro.setTelefonoContacto(txtTelefonoServicio.getText());
        registro.setCodigoEmpresa(((Empresa) cmbCodigoEmpresa.getSelectionModel().getSelectedItem()).getCodigoEmpresa());
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_AgregarServicio(?, ?, ?, ?, ?, ?)");
            procedimiento.setDate(1, new java.sql.Date(registro.getFechaServicio().getTime()));
            procedimiento.setString(2, registro.getTipoServicio());
            procedimiento.setTime(3, registro.getHoraServicio());
            procedimiento.setString(4, registro.getLugarServicio());
            procedimiento.setString(5, registro.getTelefonoContacto());
            procedimiento.setInt(6, registro.getCodigoEmpresa());
            procedimiento.execute();
            listaServicio.add(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                if (tblServicios.getSelectionModel().getSelectedItem() != null) {
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
                tpHoraServicio.setValue(null);
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
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EditarServicio(?,?,?,?,?,?)");
            Servicio registro = (Servicio) tblServicios.getSelectionModel().getSelectedItem();
            registro.setFechaServicio(fecha.getSelectedDate());
            registro.setTipoServicio(txtTipoServicio.getText());
            registro.setHoraServicio(Time.valueOf(tpHoraServicio.getValue()));
            registro.setLugarServicio(txtLugarServicio.getText());
            registro.setTelefonoContacto(txtTelefonoServicio.getText());
            procedimiento.setInt(1, registro.getCodigoServicio());
            procedimiento.setDate(2, new java.sql.Date(registro.getFechaServicio().getTime()));
            procedimiento.setString(3, registro.getTipoServicio());
            procedimiento.setTime(4, registro.getHoraServicio());
            procedimiento.setString(5, registro.getLugarServicio());
            procedimiento.setString(6, registro.getTelefonoContacto());
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
                tblServicios.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
            default:
                if (tblServicios.getSelectionModel().getSelectedItem() != null) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseaa Eliminar el Registro?");
                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EliminarServicio(?)");
                            procedimiento.setInt(1, (((Servicio) tblServicios.getSelectionModel().getSelectedItem()).getCodigoServicio()));
                            procedimiento.execute();
                            listaEmpresa.remove(tblServicios.getSelectionModel().getSelectedItem());
                            limpiarControles();
                            cargarDatos();
                            cmbCodigoEmpresa.setValue("");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "No es posible eliminar este registro");
                            limpiarControles();
                        }
                    } else if (respuesta == JOptionPane.NO_OPTION) {
                        limpiarControles();
                        tblServicios.getSelectionModel().clearSelection();
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
                tblServicios.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
        }
    }
    
    
       public void verReporte(){
        JasperReport report;
        JasperPrint re;
        
        try {
            URL in=this.getClass().getResource("/org/jamessipac/report/ReporteServicios.jasper");
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
        txtCodigoServicio.setEditable(false);
        fecha.setDisable(true);
        txtTipoServicio.setEditable(false);
        tpHoraServicio.setEditable(false);
        txtLugarServicio.setEditable(false);
        txtTelefonoServicio.setEditable(false);
        cmbCodigoEmpresa.setDisable(true);
    }

    public void activarControles() {
        txtCodigoServicio.setEditable(false);
        fecha.setDisable(false);
        txtTipoServicio.setEditable(true);
        tpHoraServicio.setEditable(true);
        txtLugarServicio.setEditable(true);
        txtTelefonoServicio.setEditable(true);
        cmbCodigoEmpresa.setDisable(false);
    }

    public void limpiarControles() {
        txtCodigoServicio.clear();
        fecha.setSelectedDate(null);
        txtTipoServicio.clear();
        tpHoraServicio.setValue(null);
        txtLugarServicio.clear();
        txtTelefonoServicio.clear();
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

    public void ventanaServicioHasEmpleado() {
        escenarioPrincipal.ventanaServicioHasEmpleado();
    }

    @FXML
    private void letras(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[a-z\\sA-ZÁ-Úá-ú]")) {
            event.consume();
        }
    }

    @FXML
    private void numeros(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[0-9]")) {
            event.consume();

        }

        Object evt = event.getSource();

        if (txtTelefonoServicio.getText().length() > 7) {
            event.consume();
        }
    }
}
