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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
import org.jamessipac.bean.Producto;
import org.jamessipac.db.Conexion;
import org.jamessipac.main.Principal;
import org.jamessipac.report.GenerarReporte;

public class ProductoController implements Initializable {

    private Principal escenarioPrincipal;
    //VARIABLE PARA REPORTE
    private final String logoTipo="/org/jamessipac/image/Menu.png";
    private final String fondoReporte="/org/jamessipac/image/FondoReporte.png";   
    
    private enum operaciones {
        NUEVO, GUARDAR, ELIMINAR, ACTUALIZAR, CANCELAR, NINGUNO
    }
    private operaciones tipoDeOperacion = operaciones.NINGUNO;
    private ObservableList<Producto> listaProducto;

    @FXML
    private TextField txtCodigoProducto;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtCantidadProducto;
    @FXML
    private TableView tblProductos;
    @FXML
    private TableColumn colCodigoProducto;
    @FXML
    private TableColumn colNombreProducto;
    @FXML
    private TableColumn colCantidadProducto;
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
    }

    public void cargarDatos() {
        tblProductos.setItems(getProducto());
        colCodigoProducto.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("codigoProducto"));
        colNombreProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombreProducto"));
        colCantidadProducto.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("cantidadProducto"));
    }

    public ObservableList<Producto> getProducto() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_ListarProductos");
            ResultSet resultado = procedimiento.executeQuery();
            while (resultado.next()) {
                lista.add(new Producto(
                        resultado.getInt("codigoProducto"),
                        resultado.getString("nombreProducto"),
                        resultado.getInt("cantidadProducto")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto = FXCollections.observableArrayList(lista);
    }

    public void nuevo() {
        txtNombreProducto.requestFocus();
        switch (tipoDeOperacion) {
            case NINGUNO:
                activarControles();
                limpiarControles();
                btnNuevo.setText("Guardar");
                btnEliminar.setText("Cancelar");
                btnEditar.setDisable(true);
                btnReporte.setDisable(true);
                imgNuevo.setImage(new Image("/org/jamessipac/image/Guardar.png"));
                imgEliminar.setImage(new Image("/org/jamessipac/image/Cancelar.png"));
                tipoDeOperacion = operaciones.GUARDAR;
                break;
            case GUARDAR:
                if (txtNombreProducto.getText().isEmpty() || txtCantidadProducto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
                } else {
                    guardar();
                    limpiarControles();
                    desactivarControles();
                    btnNuevo.setText("Nuevo");
                    btnEliminar.setText("Eliminar");
                    btnEditar.setDisable(false);
                    btnReporte.setDisable(false);
                    imgNuevo.setImage(new Image("/org/jamessipac/image/Agregar.png"));
                    imgEliminar.setImage(new Image("/org/jamessipac/image/Eliminar.png"));
                    tipoDeOperacion = operaciones.NINGUNO;
                    cargarDatos();
                    break;

                }

        }
    }

    public void guardar() {
        Producto registro = new Producto();
        registro.setNombreProducto(txtNombreProducto.getText());
        registro.setCantidadProducto(Integer.parseInt(txtCantidadProducto.getText()));

        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_AgregarProducto(?,?);");
            procedimiento.setString(1, registro.getNombreProducto());
            procedimiento.setInt(2, registro.getCantidadProducto());
            procedimiento.execute();
            listaProducto.add(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void seleccionarElemento() {

        Producto empresaSeleccionada = (Producto) tblProductos.getSelectionModel().getSelectedItem();

        if (empresaSeleccionada != null) {
            if(tipoDeOperacion==operaciones.NINGUNO){
            txtCodigoProducto.setText(String.valueOf(((Producto) tblProductos.getSelectionModel().getSelectedItem()).getCodigoProducto()));
            txtNombreProducto.setText(((Producto) tblProductos.getSelectionModel().getSelectedItem()).getNombreProducto());
            txtCantidadProducto.setText(String.valueOf(((Producto) tblProductos.getSelectionModel().getSelectedItem()).getCantidadProducto()));
            } else {
            limpiarControles();
        }

        } else {
            limpiarControles();
        }

    }

    public void editar() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                if (tblProductos.getSelectionModel().getSelectedItem() != null) {
                    txtNombreProducto.requestFocus();
                    btnEditar.setText("Actualizar");
                    btnReporte.setText("Cancelar");
                    btnNuevo.setDisable(true);
                    btnEliminar.setDisable(true);
                    imgEditar.setImage(new Image("/org/jamessipac/image/Actualizar.png"));
                    imgReporte.setImage(new Image("/org/jamessipac/image/Cancelar.png"));
                    activarControles();
                    tipoDeOperacion = operaciones.ACTUALIZAR;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
                }
                break;
            case ACTUALIZAR:
                if (txtNombreProducto.getText().isEmpty() || txtCantidadProducto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
                } else {
                actualizar();
                btnEditar.setText("Editar");
                btnReporte.setText("Reporte");
                imgEditar.setImage(new Image("/org/jamessipac/image/Editar.png"));
                imgReporte.setImage(new Image("/org/jamessipac/image/Reporte.png"));
                btnNuevo.setDisable(false);
                btnEliminar.setDisable(false);
                limpiarControles();
                desactivarControles();
                tipoDeOperacion = operaciones.NINGUNO;
                cargarDatos();
                break;
        }
        }
    }

    public void actualizar() {
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EditarProducto(?, ?, ?)");
            Producto registro = (Producto) tblProductos.getSelectionModel().getSelectedItem();
            registro.setNombreProducto(txtNombreProducto.getText());
            registro.setCantidadProducto(Integer.parseInt(txtCantidadProducto.getText()));
            procedimiento.setInt(1, registro.getCodigoProducto());
            procedimiento.setString(2, registro.getNombreProducto());
            procedimiento.setInt(3, Integer.parseInt(txtCantidadProducto.getText()));
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
                tipoDeOperacion = operaciones.NINGUNO;
                break;
            default:
                if (tblProductos.getSelectionModel().getSelectedItem() != null) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?", "Eliminar Producto", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_EliminarProducto(?)");
                            procedimiento.setInt(1, (((Producto) tblProductos.getSelectionModel().getSelectedItem()).getCodigoProducto()));
                            procedimiento.execute();
                            listaProducto.remove(tblProductos.getSelectionModel().getSelectedItem());
                            limpiarControles();
                            tblProductos.getSelectionModel().clearSelection();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "No se puede eliminar el registro");
                            limpiarControles();   
                        }
                    } else if (respuesta == JOptionPane.NO_OPTION) {
                        limpiarControles();
                        tblProductos.getSelectionModel().clearSelection();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
                }
        }
    }

    public void reporte() {
        switch (tipoDeOperacion) {
            case NINGUNO:
                verReporte();
                break;
            case ACTUALIZAR:
                desactivarControles();
                limpiarControles();
                btnEditar.setText("Editar");
                btnReporte.setText("Reporte");
                btnNuevo.setDisable(false);
                btnEliminar.setDisable(false);
                imgEditar.setImage(new Image("/org/jamessipac/image/Editar.png"));
                imgReporte.setImage(new Image("/org/jamessipac/image/Reporte.png"));
                tblProductos.getSelectionModel().clearSelection();
                tipoDeOperacion = operaciones.NINGUNO;
                break;
        }
    }
    
        public void verReporte(){
        JasperReport report;
        JasperPrint re;
        
        try {
            URL in=this.getClass().getResource("/org/jamessipac/report/ReporteProductos.jasper");
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
        txtCodigoProducto.setEditable(false);
        txtNombreProducto.setEditable(false);
        txtCantidadProducto.setEditable(false);
    }

    public void activarControles() {
        txtCodigoProducto.setEditable(false);
        txtNombreProducto.setEditable(true);
        txtCantidadProducto.setEditable(true);
    }

    public void limpiarControles() {
        txtCodigoProducto.clear();
        txtNombreProducto.clear();
        txtCantidadProducto.clear();
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
    
    public void ventanaProductoHasPlato(){
        escenarioPrincipal.ventanaProductoHasPlato();
    }

    @FXML
    private void numeros(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[0-9]")) {
            event.consume();

        }
    }

    @FXML
    private void letras(KeyEvent event){
        String caracter=event.getCharacter();
        
        if(!caracter.matches("[a-z\\sA-ZÁ-Úá-ú]")){
            event.consume();
        }
    }
}
