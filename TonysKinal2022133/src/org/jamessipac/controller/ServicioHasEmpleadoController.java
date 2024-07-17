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
import org.jamessipac.bean.Empleado;
import org.jamessipac.bean.Servicio;
import org.jamessipac.bean.ServicioHasEmpleado;
import org.jamessipac.db.Conexion;
import org.jamessipac.main.Principal;

public class ServicioHasEmpleadoController implements Initializable {
    //VARIABLE PARA REPORTE
    private final String logoTipo = "/org/jamessipac/image/Menu.png";
    private final String fondoReporte = "/org/jamessipac/image/FondoReporte.png";
    private Principal escenarioPrincipal;

    private enum operaciones {
        GUARDAR, ELIMINAR, ACTUALIZAR, NINGUNO
    }
    private operaciones tipoDeOperacion = operaciones.NINGUNO;
    private ObservableList<ServicioHasEmpleado> listaServicioHasEmpleado;
    private ObservableList<Servicio> listaServicio;
    private ObservableList<Empleado> listaEmpleado;
    private DatePicker fecha;

    @FXML
    private TextField txtServicioCodigoServicio;
    @FXML
    private ComboBox cmbCodigoServicio;
    @FXML
    private ComboBox cmbCodigoEmpleado;
    @FXML
    private GridPane grpFecha;
    @FXML
    private JFXTimePicker tpHoraEvento;
    @FXML
    private TextField txtLugarEvento;
    @FXML
    private TableView tblServiciosHasEmpleados;
    @FXML
    private TableColumn colServicioCodigoServicio;
    @FXML
    private TableColumn colCodigoServicio;
    @FXML
    private TableColumn colCodigoEmpleado;
    @FXML
    private TableColumn colFechaEvento;
    @FXML
    private TableColumn colHoraEvento;
    @FXML
    private TableColumn colLugarEvento;
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
        grpFecha.add(fecha, 1, 1);
        cmbCodigoServicio.setItems(getServicio());
        cmbCodigoEmpleado.setItems(getEmpleado());
        desactivarControles();
        
        tpHoraEvento.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            event.consume(); // No permite la entrada de caracteres
        });
    }

    public void cargarDatos() {
        tblServiciosHasEmpleados.setItems(getServicioHasEmpleado());
        colServicioCodigoServicio.setCellValueFactory(new PropertyValueFactory<ServicioHasEmpleado, Integer>("Servicios_codigoServicio"));
        colCodigoServicio.setCellValueFactory(new PropertyValueFactory<ServicioHasEmpleado, Integer>("codigoServicio"));
        colCodigoEmpleado.setCellValueFactory(new PropertyValueFactory<ServicioHasEmpleado, Integer>("codigoEmpleado"));
        colFechaEvento.setCellValueFactory(new PropertyValueFactory<ServicioHasEmpleado, Date>("fechaEvento"));
        colHoraEvento.setCellValueFactory(new PropertyValueFactory<ServicioHasEmpleado, Time>("horaEvento"));
        colLugarEvento.setCellValueFactory(new PropertyValueFactory<ServicioHasEmpleado, String>("lugarEvento"));
    }

    public ObservableList<ServicioHasEmpleado> getServicioHasEmpleado() {
        ArrayList<ServicioHasEmpleado> lista = new ArrayList<ServicioHasEmpleado>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_ListarServicios_has_Empleados()");
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()) {
                lista.add(new ServicioHasEmpleado(
                        resultado.getInt("Servicios_codigoServicio"),
                        resultado.getInt("codigoServicio"),
                        resultado.getInt("codigoEmpleado"),
                        resultado.getDate("fechaEvento"),
                        resultado.getTime("horaEvento"),
                        resultado.getString("lugarEvento")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaServicioHasEmpleado = FXCollections.observableArrayList(lista);
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

    public Empleado buscarEmpleado(int codigoEmpresa) {
        Empleado resultado = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_BuscarEmpleados(?)");
            procedimiento.setInt(1, codigoEmpresa);
            ResultSet registro = procedimiento.executeQuery();
            while (registro.next()) {
                resultado = new Empleado(registro.getInt("codigoEmpleado"),
                        registro.getInt("numeroEmpleado"),
                        registro.getString("apellidosEmpleado"),
                        registro.getString("nombresEmpleado"),
                        registro.getString("direccionEmpleado"),
                        registro.getString("telefonoContacto"),
                        registro.getString("gradoCocinero"),
                        registro.getInt("codigoTipoEmpleado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ObservableList<Empleado> getEmpleado() {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_ListarEmpleados");
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()) {
                lista.add(new Empleado(
                        resultado.getInt("codigoEmpleado"),
                        resultado.getInt("numeroEmpleado"),
                        resultado.getString("apellidosEmpleado"),
                        resultado.getString("nombresEmpleado"),
                        resultado.getString("direccionEmpleado"),
                        resultado.getString("telefonoContacto"),
                        resultado.getString("gradoCocinero"),
                        resultado.getInt("codigoTipoEmpleado")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEmpleado = FXCollections.observableArrayList(lista);
    }

    public void nuevo() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                cmbCodigoEmpleado.setValue("");
                cmbCodigoServicio.setValue("");                
                tblServiciosHasEmpleados.getSelectionModel().clearSelection();
                fecha.requestFocus();
                activarControles();
                txtServicioCodigoServicio.setEditable(true);
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
                if (txtServicioCodigoServicio.getText() == null || cmbCodigoEmpleado.getSelectionModel().isEmpty() || cmbCodigoServicio.getSelectionModel().isEmpty()
                        || fecha.getSelectedDate() == null || tpHoraEvento.getValue() == null || txtLugarEvento.getText() == null) {
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
        ServicioHasEmpleado registro = new ServicioHasEmpleado();
        registro.setServicios_codigoServicio(Integer.parseInt(txtServicioCodigoServicio.getText()));
        registro.setCodigoEmpleado(((Empleado) cmbCodigoEmpleado.getSelectionModel().getSelectedItem()).getCodigoEmpleado());
        registro.setCodigoServicio(((Servicio) cmbCodigoServicio.getSelectionModel().getSelectedItem()).getCodigoServicio());
        registro.setFechaEvento(fecha.getSelectedDate());
        registro.setHoraEvento(Time.valueOf(tpHoraEvento.getValue()));
        registro.setLugarEvento(txtLugarEvento.getText());
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_AgregarServicios_Has_Empleados(?,?,?,?,?,?)");
            procedimiento.setInt(1, registro.getServicios_codigoServicio());
            procedimiento.setInt(2, registro.getCodigoServicio());
            procedimiento.setInt(3, registro.getCodigoEmpleado());
            procedimiento.setDate(4, new java.sql.Date(registro.getFechaEvento().getTime()));
            procedimiento.setTime(5, registro.getHoraEvento());
            procedimiento.setString(6, registro.getLugarEvento());
            procedimiento.execute();
            listaServicioHasEmpleado.add(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public void seleccionarElemento() {
        ServicioHasEmpleado servicioHasEmpleadoSeleccionado = (ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem();
        if (servicioHasEmpleadoSeleccionado != null) {
            if (tipoDeOperacion == operaciones.NINGUNO) {
                txtServicioCodigoServicio.setText(String.valueOf(((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getServicios_codigoServicio()));
                cmbCodigoServicio.getSelectionModel().select(buscarServicio(((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getCodigoServicio()));
                cmbCodigoEmpleado.getSelectionModel().select(buscarEmpleado(((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getCodigoEmpleado()));
                fecha.selectedDateProperty().set(((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getFechaEvento());                      
                
                            tblServiciosHasEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String horaText = (String.valueOf(((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getHoraEvento()));
                try {
                    LocalTime hora = LocalTime.parse(horaText, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    tpHoraEvento.setValue(hora);
                } catch (Exception e) {
                    System.out.println("Error: Formato de hora inválido");
                }
            }
        }); 
                
                
                txtLugarEvento.setText(((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getLugarEvento());
            } else {
                cmbCodigoEmpleado.getSelectionModel().clearSelection();
                cmbCodigoServicio.getSelectionModel().clearSelection();
                limpiarControles();
            }
        } else {
            limpiarControles();
        }
    }

    public void editar() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                if (tblServiciosHasEmpleados.getSelectionModel().getSelectedItem() != null) {
                    btnEditar.setText("Actualizar");
                    btnReporte.setText("Cancelar");
                    btnNuevo.setDisable(true);
                    btnEliminar.setDisable(true);
                    imgEditar.setImage(new Image("/org/jamessipac/image/Actualizar.png"));
                    imgReporte.setImage(new Image("/org/jamessipac/image/Cancelar.png"));
                    activarControles();
                    cmbCodigoEmpleado.setDisable(true);
                    cmbCodigoServicio.setDisable(true);
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
                tpHoraEvento.setValue(null);
                desactivarControles();
                tipoDeOperacion = operaciones.NINGUNO;
                cmbCodigoEmpleado.setDisable(false);
                cmbCodigoEmpleado.setValue("");
                cmbCodigoServicio.setDisable(false);
                cmbCodigoServicio.setValue("");
                cargarDatos();
                break;
        }
    }

    public void actualizar() {
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EditarServicios_has_Empleados(?,?,?,?)");
            ServicioHasEmpleado registro = (ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem();
            registro.setServicios_codigoServicio(Integer.parseInt(txtServicioCodigoServicio.getText()));
            registro.setFechaEvento(fecha.getSelectedDate());
            registro.setHoraEvento(Time.valueOf(tpHoraEvento.getValue()));
            registro.setLugarEvento(txtLugarEvento.getText());
            procedimiento.setInt(1, registro.getServicios_codigoServicio());
            procedimiento.setDate(2, new java.sql.Date(registro.getFechaEvento().getTime()));
            procedimiento.setTime(3, registro.getHoraEvento());
            procedimiento.setString(4, registro.getLugarEvento());
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
                cmbCodigoEmpleado.setDisable(false);
                cmbCodigoServicio.setDisable(false);
                tblServiciosHasEmpleados.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
            default:
                if (tblServiciosHasEmpleados.getSelectionModel().getSelectedItem() != null) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar Este Registro?");
                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EliminarServicios_has_Empleados(?)");
                            procedimiento.setInt(1, (((ServicioHasEmpleado) tblServiciosHasEmpleados.getSelectionModel().getSelectedItem()).getServicios_codigoServicio()));
                            procedimiento.execute();
                            listaEmpleado.remove(tblServiciosHasEmpleados.getSelectionModel().getSelectedItem());
                            listaServicio.remove(tblServiciosHasEmpleados.getSelectionModel().getSelectedItem());
                            limpiarControles();
                            cargarDatos();
                            cmbCodigoEmpleado.setValue("");
                            cmbCodigoServicio.setValue("");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "No se puede eliminar el registro");
                            limpiarControles();   
                        }
                    } else if (respuesta == JOptionPane.NO_OPTION) {
                        limpiarControles();
                        tblServiciosHasEmpleados.getSelectionModel().clearSelection();
                        cmbCodigoEmpleado.setValue("");
                        cmbCodigoServicio.setValue("");
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
                cmbCodigoEmpleado.setDisable(false);
                cmbCodigoEmpleado.setValue("");
                cmbCodigoServicio.setDisable(false);
                cmbCodigoServicio.setValue("");
                tblServiciosHasEmpleados.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
        }
    }
    
        public void verReporte() {
        JasperReport report;
        JasperPrint re;

        try {
            URL in = this.getClass().getResource("/org/jamessipac/report/ReporteServiciosHasEmpleados.jasper");
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
    

    public void desactivarControles() {
        txtServicioCodigoServicio.setEditable(false);
        cmbCodigoServicio.setDisable(true);
        cmbCodigoEmpleado.setDisable(true);
        fecha.setDisable(true);
        tpHoraEvento.setDisable(true);
        txtLugarEvento.setEditable(false);
    }

    public void activarControles() {
        txtServicioCodigoServicio.setEditable(false);
        cmbCodigoServicio.setDisable(false);
        cmbCodigoEmpleado.setDisable(false);
        fecha.setDisable(false);
        tpHoraEvento.setDisable(false);
        txtLugarEvento.setEditable(true);
    }

    public void limpiarControles() {
        txtServicioCodigoServicio.clear();
        cmbCodigoServicio.getSelectionModel().clearSelection();
        cmbCodigoEmpleado.getSelectionModel().clearSelection();
        fecha.setSelectedDate(null);
        tpHoraEvento.setValue(null);
        txtLugarEvento.clear();
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

    public void ventanaServicio() {
        escenarioPrincipal.ventanaServicio();
    }
    
            @FXML
    private void cantidad(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[0-9]")) {
            event.consume();

        }
    }
}
