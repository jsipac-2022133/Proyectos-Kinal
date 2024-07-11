
package org.jamessipac.vista;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import org.jamessipac.controlador.ControlDeEmpleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static org.jamessipac.vista.VistaCliente.txtFase2Calle;

/**
 *En esta clase se elige al empleado que atendera la compra
 * @author James Sipac
 * @since 18 de julio de 2022
 */
public class EleccionEmpleado extends javax.swing.JFrame {
     public ControlDeEmpleado controlador=ControlDeEmpleado.getInstancia();
     
    public static DefaultTableModel modelo2;
    
    String id="";
    String nombre="";
    String apellido="";
    String telefono="";
    String direccion="";
    /**
     * Creates new form EleccionEmpleado
     */
    public EleccionEmpleado() {
        initComponents();
        
        this.setTitle("Pollo Campero");
        Image icono=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/campero.png"));
        this.setIconImage(icono); 
        this.setLocationRelativeTo(null);
        
        modelo2=new DefaultTableModel();
        modelo2.addColumn("Id");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Apellido");
        modelo2.addColumn("Teléfono");
        modelo2.addColumn("Dirección");
        jTableEmpleado.setModel(modelo2);
        
        
        jTableEmpleado.addMouseListener(new MouseAdapter(){
        DefaultTableModel model=new DefaultTableModel();
        
        public void mouseClicked(MouseEvent e){
            int i=jTableEmpleado.getSelectedRow();
            id=(jTableEmpleado.getValueAt(i, 0)).toString();
            nombre=(jTableEmpleado.getValueAt(i, 1)).toString();
            apellido=(jTableEmpleado.getValueAt(i, 2)).toString();
            telefono=(jTableEmpleado.getValueAt(i, 3)).toString();
            direccion=(jTableEmpleado.getValueAt(i, 4)).toString();
        }
        });
        this.setSize(860,460);
        this.setLocationRelativeTo(null);
    }
    /**3
     * Con este metodo se muestran los datos contenidos en el ArrayList
     */
    public void mostrarEmpleados(){
    String[][] vector=new String[controlador.cantidadEmpleados()][5];
    for (int i = 0; i < controlador.cantidadEmpleados(); i++) {
        vector[i][0]=controlador.listaDeEmpleados.get(i).getId();
        vector[i][1]=controlador.listaDeEmpleados.get(i).getNombre();
        vector[i][2]=controlador.listaDeEmpleados.get(i).getApellido();
        vector[i][3]=controlador.listaDeEmpleados.get(i).getTelefono();
        vector[i][4]=controlador.listaDeEmpleados.get(i).getDireccion();
    }
    jTableEmpleado.setModel(new javax.swing.table.DefaultTableModel(vector, new String[]{"Id","Nombre","Apellido","Teléfono","Dirección"}));
            
   }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVerMenu = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmpleado = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnElegir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(740, 330, 72, 22);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Elija al empleado que lo atenderá");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 40, 290, 25);

        btnVerMenu.setText("Ver lista de empleados disponibles");
        btnVerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerMenu);
        btnVerMenu.setBounds(16, 381, 290, 22);
        getContentPane().add(txtId);
        txtId.setBounds(660, 90, 154, 22);

        jTableEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido", "Teléfono", "Dirección"
            }
        ));
        jScrollPane2.setViewportView(jTableEmpleado);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(16, 89, 507, 274);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(660, 140, 154, 22);
        getContentPane().add(txtApellido);
        txtApellido.setBounds(660, 190, 154, 22);
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(660, 230, 154, 22);
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(660, 270, 154, 22);

        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        getContentPane().add(btnElegir);
        btnElegir.setBounds(451, 375, 72, 22);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 90, 13, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(570, 140, 56, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Apellido");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(570, 190, 57, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(570, 230, 59, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Dirección");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(570, 270, 63, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1000pxl.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 850, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Con este boton se confirma la eleccion y pasa a la siguiente ventana
     * @param evt crea un evento al presionarlo
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        EleccionRestaurante abrir=new EleccionRestaurante();
        abrir.setVisible(true);
        this.setVisible(false);
        
        //PARA DATOS DE EMPLEADO ELEGIDO
        String nombreEmpleado=txtNombre.getText();
        EleccionRestaurante.txtFase1Nombre.setText(nombreEmpleado);
        String apellidoEmpleado=txtApellido.getText();
        EleccionRestaurante.txtFase1Apellido.setText(apellidoEmpleado);
        String telefonoEmpleado=txtTelefono.getText();
        EleccionRestaurante.txtFase1Telefono.setText(telefonoEmpleado);
        String direccionEmpleado=txtDireccion.getText();
        EleccionRestaurante.txtFase1Direccion.setText(direccionEmpleado);
       
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Con este boton se muestran los datos en la tabla
     * @param evt crea un evento al presionarlo
     */
    private void btnVerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMenuActionPerformed
         mostrarEmpleados();
    }//GEN-LAST:event_btnVerMenuActionPerformed
    /**
     * Con este boton se muestran los datos del empleado elegido
     * @param evt crea un evento al presionarlo
     */
    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
       txtId.setText(id);
       txtNombre.setText(nombre);
       txtApellido.setText(apellido);
       txtTelefono.setText(telefono);
       txtDireccion.setText(direccion);
    }//GEN-LAST:event_btnElegirActionPerformed

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
            java.util.logging.Logger.getLogger(EleccionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EleccionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EleccionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EleccionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EleccionEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnVerMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmpleado;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
