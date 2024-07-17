
package org.jamessipac.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.jamessipac.bean.Plato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jamessipac.bean.Producto;
import org.jamessipac.bean.ProductoHasPlato;
import org.jamessipac.db.Conexion;
import org.jamessipac.main.Principal;

public class ProductoHasPlatoController implements Initializable{
    private Principal escenarioPrincipal;
    //VARIABLE PARA REPORTE
    private final String logoTipo = "/org/jamessipac/image/Menu.png";
    private final String fondoReporte = "/org/jamessipac/image/FondoReporte.png";
    private enum operaciones{
        GUARDAR, ELIMINAR, ACTUALIZAR, NINGUNO
    }
    private operaciones tipoDeOperacion=operaciones.NINGUNO;
    private ObservableList<ProductoHasPlato> listaProductoHasPlato;
    private ObservableList<Plato> listaPlato;
    private ObservableList<Producto> listaProducto;
    
    @FXML
    private TextField txtProductoCodigoProducto;
    @FXML
    private ComboBox cmbCodigoPlato;
    @FXML
    private ComboBox cmbCodigoProducto;
    @FXML
    private TableView tblProductosHasPlatos;
    @FXML
    private TableColumn colProductoCodigoProducto;
    @FXML
    private TableColumn colCodigoPlato;
    @FXML
    private TableColumn colCodigoProducto;
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
        cmbCodigoProducto.setItems(getProducto());
        desactivarControles();
    }
    
    public void cargarDatos(){
        tblProductosHasPlatos.setItems(getProductoHasPlato());
        colProductoCodigoProducto.setCellValueFactory(new PropertyValueFactory<ProductoHasPlato, Integer>("Productos_codigoProducto"));
        colCodigoPlato.setCellValueFactory(new PropertyValueFactory<ProductoHasPlato, Integer>("codigoPlato"));
        colCodigoProducto.setCellValueFactory(new PropertyValueFactory<ProductoHasPlato, Integer>("codigoProducto"));
    }
    
    public ObservableList<ProductoHasPlato> getProductoHasPlato(){
        ArrayList<ProductoHasPlato> lista=new ArrayList<ProductoHasPlato>();
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_ListarProductos_has_Platos()");
            ResultSet resultado=procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new ProductoHasPlato(
                        resultado.getInt("Productos_codigoProducto"),
                        resultado.getInt("codigoPlato"),
                        resultado.getInt("codigoProducto")
                ));            
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductoHasPlato=FXCollections.observableArrayList(lista);
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
        
    public Producto buscarProducto(int codigoProducto){
        Producto resultado=null;
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_BuscarProducto(?)");
            procedimiento.setInt(1, codigoProducto);
            ResultSet registro=procedimiento.executeQuery();
            while(registro.next()){
                resultado=new Producto(registro.getInt("codigoProducto"),
                registro.getString("nombreProducto"),
                registro.getInt("cantidadProducto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
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
        
    public void nuevo(){
       switch (tipoDeOperacion) {
            case NINGUNO:
                cmbCodigoPlato.setValue("");
                cmbCodigoPlato.setValue("");                
                cmbCodigoProducto.setValue("");
                cmbCodigoProducto.setValue("");                
                tblProductosHasPlatos.getSelectionModel().clearSelection();
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
                if(txtProductoCodigoProducto.getText()== null || cmbCodigoPlato.getSelectionModel().isEmpty() || cmbCodigoProducto.getSelectionModel().isEmpty()){
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
        ProductoHasPlato registro=new ProductoHasPlato();
        registro.setProductos_codigoProducto(Integer.parseInt(txtProductoCodigoProducto.getText()));
        registro.setCodigoPlato(((Plato) cmbCodigoPlato.getSelectionModel().getSelectedItem()).getCodigoPlato());
        registro.setCodigoProducto(((Producto) cmbCodigoProducto.getSelectionModel().getSelectedItem()).getCodigoProducto());
        try {
            PreparedStatement procedimiento=Conexion.getInstance().getConexion().prepareCall("call sp_AgregarProductos_has_Platos(?,?,?)");
            procedimiento.setInt(1, registro.getProductos_codigoProducto());
            procedimiento.setInt(2, registro.getCodigoPlato());
            procedimiento.setInt(3, registro.getCodigoProducto());
            procedimiento.execute();
            listaProductoHasPlato.add(registro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede repetir el código del registro");
        }
    }
    
    public void seleccionarElemento(){
        ProductoHasPlato productoHasPlatoSeleccionado=(ProductoHasPlato) tblProductosHasPlatos.getSelectionModel().getSelectedItem();
        if(productoHasPlatoSeleccionado != null){
            if(tipoDeOperacion==operaciones.NINGUNO){
                txtProductoCodigoProducto.setText(String.valueOf(((ProductoHasPlato) tblProductosHasPlatos.getSelectionModel().getSelectedItem()).getProductos_codigoProducto()));
                cmbCodigoPlato.getSelectionModel().select(buscarPlato(((ProductoHasPlato) tblProductosHasPlatos.getSelectionModel().getSelectedItem()).getCodigoPlato()));
                cmbCodigoProducto.getSelectionModel().select(buscarProducto(((ProductoHasPlato) tblProductosHasPlatos.getSelectionModel().getSelectedItem()).getCodigoProducto()));
            }else{
                cmbCodigoPlato.getSelectionModel().clearSelection();
                cmbCodigoProducto.getSelectionModel().clearSelection();
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
            URL in = this.getClass().getResource("/org/jamessipac/report/ReporteProductosHasPlatos.jasper");
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
        txtProductoCodigoProducto.setEditable(false);
        cmbCodigoPlato.setDisable(true);
        cmbCodigoProducto.setDisable(true);
    }
    
    public void activarControles(){
        txtProductoCodigoProducto.setEditable(true);
        cmbCodigoPlato.setDisable(false);
        cmbCodigoProducto.setDisable(false);
    }
    
    public void limpiarControles(){
        txtProductoCodigoProducto.clear();
        cmbCodigoPlato.getSelectionModel().clearSelection();
        cmbCodigoProducto.getSelectionModel().clearSelection();
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
    
    public void ventanaProducto(){
        escenarioPrincipal.ventanaProducto();
    }
    
        @FXML
    private void cantidad(KeyEvent event) {
        String caracter = event.getCharacter();

        if (!caracter.matches("[0-9]")) {
            event.consume();

        }
    }
}
