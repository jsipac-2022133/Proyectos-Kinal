package org.jamessipac.vista;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import org.jamessipac.modelo.Producto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jamessipac.controlador.ControlDeProducto;
/**
 *Esta clase representa a la clase en la que se realizan las 4 funciones del CRUD
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class VistaConfiguracionProductos extends javax.swing.JFrame {
    ControlDeProducto controlador=new ControlDeProducto();
    
    DefaultTableModel modelo;
    
    String id="";
    String nombre="";
    String categoria="";
    String precio="";
    
   
    /**
     * Creates new form VistaConfiguracionProductos
     */
    public VistaConfiguracionProductos() {
        initComponents();
        
        this.setTitle("Pollo Campero");
        Image icono=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/campero.png"));
        this.setIconImage(icono); 
        this.setLocationRelativeTo(null);

        jTableProducto.addMouseListener(new MouseAdapter(){
        DefaultTableModel model=new DefaultTableModel();
        
        public void mouseClicked(MouseEvent e){
        int i=jTableProducto.getSelectedRow();
        id=(jTableProducto.getValueAt(i, 0)).toString();
        nombre=(jTableProducto.getValueAt(i, 1)).toString();
        categoria=(jTableProducto.getValueAt(i, 2)).toString();
        precio=(jTableProducto.getValueAt(i, 3)).toString();
        }     
        }); 
        
        this.setSize(970,450);
        this.setLocationRelativeTo(null);     
        
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducto = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Agregar datos del producto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 20, 222, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 90, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(44, 110, 80, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Categoría");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(41, 160, 90, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Precio");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(43, 210, 80, 16);
        getContentPane().add(txtId);
        txtId.setBounds(150, 60, 185, 30);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(150, 110, 185, 30);
        getContentPane().add(txtCategoria);
        txtCategoria.setBounds(150, 160, 185, 30);
        getContentPane().add(txtPrecio);
        txtPrecio.setBounds(150, 210, 185, 30);

        jTableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Categoría", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTableProducto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 60, 541, 275);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Lista de productos");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(600, 10, 147, 25);

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear);
        btnCrear.setBounds(26, 257, 90, 22);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(130, 260, 100, 22);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(240, 260, 110, 22);

        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarCambios);
        btnGuardarCambios.setBounds(116, 297, 170, 22);

        btnRegresar.setText("Regresar al menú principal de administrador");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar);
        btnRegresar.setBounds(10, 330, 370, 22);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1000pxl.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 960, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Agrega los datos de un producto, el cual se agregara al ArrayList
     * @param evt crea un evento al presionarlo
     */
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        
        Producto producto=new Producto(txtId.getText(), txtNombre.getText(), txtCategoria.getText(), txtPrecio.getText());
        //listaDeProductos.add(producto);
        controlador.crearProducto(producto);
        
        mostrarProductos();
        
        txtId.setText("");
        txtNombre.setText("");
        txtCategoria.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_btnCrearActionPerformed
    /**
     * Con este boton se elimina a un producto contenido en el ArrayLIst
     * @param evt crea un evento al presionarlo
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        for (int i = 0; i < controlador.cantidadProductos(); i++) {
        if(id.equals(controlador.listaDeProductos.get(i).getId())){
          controlador.listaDeProductos.remove(i);
         }
        mostrarProductos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    /**
     * Con este boton se muestran los datos de la fila qkue se haya seleccionado en la tabla
     * @param evt crea un evento al presionarlo
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        txtId.setText(id);
        txtNombre.setText(nombre);
        txtCategoria.setText(categoria);
        txtPrecio.setText(precio);
    }//GEN-LAST:event_btnActualizarActionPerformed
    /**
     * Este boton guarda las modificaciones que se realizaron al actualziar un producto
     * @param evt crea un evento al presionarlo 
     */
    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        for (int i = 0; i < controlador.cantidadProductos(); i++) {
            if(id.equals(controlador.listaDeProductos.get(i).getId())){
                controlador.listaDeProductos.get(i).setId(txtId.getText());
                controlador.listaDeProductos.get(i).setNombre(txtNombre.getText());
                controlador.listaDeProductos.get(i).setCategoria(txtCategoria.getText());
                controlador.listaDeProductos.get(i).setPrecio(txtPrecio.getText());
            }
        }
        txtId.setText("");
        txtNombre.setText("");
        txtCategoria.setText("");
        txtPrecio.setText("");
        
        mostrarProductos();
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed
    /**
     * Con este boton se regresa al menu principal del administrador
     * @param evt crea un evento al presionarlo
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuPrincipalAdministrador abrir=new MenuPrincipalAdministrador();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Con este metodo se muestran los datos en la tabla
     */
    public void mostrarProductos(){
        String[][] vector=new String[controlador.cantidadProductos()][4];
        for (int i = 0; i < controlador.cantidadProductos(); i++) {
            vector[i][0]=controlador.listaDeProductos.get(i).getId();
            vector[i][1]=controlador.listaDeProductos.get(i).getNombre();
            vector[i][2]=controlador.listaDeProductos.get(i).getCategoria();
            vector[i][3]=controlador.listaDeProductos.get(i).getPrecio();
        }
        jTableProducto.setModel(new javax.swing.table.DefaultTableModel(vector, new String[]{"Id", "Nombre", "Categoría", "Precio"}));
        }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConfiguracionProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardarCambios;
    public javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableProducto;
    public javax.swing.JTextField txtCategoria;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
