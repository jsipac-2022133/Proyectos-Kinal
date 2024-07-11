package org.jamessipac.vista;
import org.jamessipac.modelo.Venta;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.print.Printable;
import java.awt.*;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class VistaClienteCompra extends javax.swing.JFrame implements Printable{    
    String productos[]={"Pieza de pollo","Pizza"};  
    double precios[]={14.75, 99};
    double precio=0;
    int cantidad=0;
    
    DefaultTableModel modelo=new DefaultTableModel();
    ArrayList<Venta> listaVentas=new ArrayList<Venta>();
    
    public VistaClienteCompra() {
        initComponents();
        this.setTitle("Pollo Campero");
        Image icono=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/campero.png"));
        this.setIconImage(icono);
      
        Image logo=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/camperoTitulo.png"));
        lblLogo.setIcon(new ImageIcon(logo.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
        this.setSize(700, 800);
        this.setLocationRelativeTo(null);
        
        Image iconoAgregar=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/agregarCompra.jpg"));
        btnAgregar.setIcon(new ImageIcon(iconoAgregar.getScaledInstance(btnAgregar.getWidth(), btnAgregar.getHeight(), Image.SCALE_SMOOTH)));
        
        DefaultComboBoxModel modeloDelComboBox=new DefaultComboBoxModel(productos);
        cboProducto.setModel(modeloDelComboBox);
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO UNITARIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("SUBTOTAL"); 
        actualizarTabla();
        calcularPrecio();
        
        lblFecha.setText("Fecha de certificación: "+fechaActual());
        
        this.setSize(680,595);
        this.setLocationRelativeTo(null);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();
        lblPrecio = new javax.swing.JLabel();
        lblImporte = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        recibo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblCambio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        recibo1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        txtFecha1 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        lblTotal1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreCliente1 = new javax.swing.JTextField();
        txtApellidoCliente1 = new javax.swing.JTextField();
        txtDireccionCliente1 = new javax.swing.JTextField();
        txtTelefonoCliente1 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtBillete = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnIngresarBillete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblApellidoCliente = new javax.swing.JLabel();
        lblDireccionCliente = new javax.swing.JLabel();
        lblTelefonoCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblFase3Telefono = new javax.swing.JLabel();
        lblFase3Calle = new javax.swing.JLabel();
        lblFase3Zona = new javax.swing.JLabel();
        lblFase3Lugar = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblFase3NombreE = new javax.swing.JLabel();
        lblFase3ApellidoE = new javax.swing.JLabel();
        lblFase3TelefonoE = new javax.swing.JLabel();
        lblFase3DireccionE = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnImprimir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(lblLogo);
        lblLogo.setBounds(30, 22, 362, 119);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PRODUCTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 150, 99, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CANTIDAD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 199, 94, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("PRECIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 150, 64, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("SUBTOTAL");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 190, 93, 25);

        cboProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });
        getContentPane().add(cboProducto);
        cboProducto.setBounds(147, 147, 150, 31);

        spnCantidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });
        getContentPane().add(spnCantidad);
        spnCantidad.setBounds(220, 190, 73, 31);

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecio.setText("Q 0.00");
        getContentPane().add(lblPrecio);
        lblPrecio.setBounds(440, 150, 80, 25);

        lblImporte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblImporte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblImporte.setText("Q 0.00");
        getContentPane().add(lblImporte);
        lblImporte.setBounds(440, 190, 80, 25);

        lblTitulo.setFont(new java.awt.Font("Arial Black", 1, 40)); // NOI18N
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(398, 115, 0, 0);

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(540, 150, 78, 65);

        recibo.setBorder(new javax.swing.border.MatteBorder(null));
        recibo.setLayout(null);

        tblProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        recibo.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 630, 90);

        lblCambio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCambio.setText("Q 0.00");
        recibo.add(lblCambio);
        lblCambio.setBounds(550, 200, 83, 25);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("CAMBIO");
        recibo.add(jLabel12);
        jLabel12.setBounds(470, 200, 80, 25);

        recibo1.setBorder(new javax.swing.border.MatteBorder(null));
        recibo1.setLayout(null);

        tblProductos1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblProductos1);

        recibo1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 20, 630, 151);

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setText("Número de autorización: 9595121C");
        recibo1.add(jTextField2);
        jTextField2.setBounds(230, 640, 240, 26);

        txtFecha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recibo1.add(txtFecha1);
        txtFecha1.setBounds(210, 700, 280, 26);

        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField9.setText("DATOS DEL CLIENTE");
        recibo1.add(jTextField9);
        jTextField9.setBounds(410, 260, 150, 26);

        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField10.setText("Factura Serie: 94262EGDS");
        recibo1.add(jTextField10);
        jTextField10.setBounds(260, 670, 180, 26);

        jTextField11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField11.setText("Sujetos a pagos trimestrales");
        recibo1.add(jTextField11);
        jTextField11.setBounds(250, 730, 190, 26);

        jTextField12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField12.setText("Documento Tributario o Electrónico");
        recibo1.add(jTextField12);
        jTextField12.setBounds(240, 610, 230, 26);

        lblTotal1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal1.setText("Q 0.00");
        recibo1.add(lblTotal1);
        lblTotal1.setBounds(550, 190, 83, 25);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("TOTAL");
        recibo1.add(jLabel13);
        jLabel13.setBounds(480, 190, 58, 25);

        txtNombreCliente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recibo1.add(txtNombreCliente1);
        txtNombreCliente1.setBounds(370, 310, 260, 26);

        txtApellidoCliente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recibo1.add(txtApellidoCliente1);
        txtApellidoCliente1.setBounds(370, 350, 260, 26);

        txtDireccionCliente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recibo1.add(txtDireccionCliente1);
        txtDireccionCliente1.setBounds(370, 390, 260, 26);

        txtTelefonoCliente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recibo1.add(txtTelefonoCliente1);
        txtTelefonoCliente1.setBounds(370, 430, 260, 26);

        jTextField14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField14.setText("Cuéntanos tu experiencia al: 23221755");
        recibo1.add(jTextField14);
        jTextField14.setBounds(210, 760, 260, 26);

        recibo.add(recibo1);
        recibo1.setBounds(0, 0, 0, 0);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("TOTAL");
        recibo.add(jLabel14);
        jLabel14.setBounds(480, 120, 58, 25);
        recibo.add(txtBillete);
        txtBillete.setBounds(570, 160, 64, 22);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("EFECTIVO");
        recibo.add(jLabel15);
        jLabel15.setBounds(460, 160, 90, 25);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Q 0.00");
        recibo.add(lblTotal);
        lblTotal.setBounds(550, 120, 83, 25);

        btnIngresarBillete.setText("Aceptar billete");
        btnIngresarBillete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarBilleteActionPerformed(evt);
            }
        });
        recibo.add(btnIngresarBillete);
        btnIngresarBillete.setBounds(320, 170, 120, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cuéntanos tu experiencia al: 23221755");
        recibo.add(jLabel5);
        jLabel5.setBounds(190, 540, 250, 30);

        lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreCliente.setText("Nombre del Cliente");
        recibo.add(lblNombreCliente);
        lblNombreCliente.setBounds(20, 290, 260, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Número de autorización: 9595121C");
        recibo.add(jLabel7);
        jLabel7.setBounds(50, 460, 230, 30);

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recibo.add(lblFecha);
        lblFecha.setBounds(350, 460, 270, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Sujetos a pagos trimestrales");
        recibo.add(jLabel9);
        jLabel9.setBounds(230, 510, 180, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Factura Serie: 94262EGDS");
        recibo.add(jLabel10);
        jLabel10.setBounds(350, 430, 170, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Documento Tributario o Electrónico");
        recibo.add(jLabel8);
        jLabel8.setBounds(50, 430, 230, 20);

        lblApellidoCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellidoCliente.setText("Apellido del Cliente");
        recibo.add(lblApellidoCliente);
        lblApellidoCliente.setBounds(20, 320, 130, 20);

        lblDireccionCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDireccionCliente.setText("Dirección del Cliente");
        recibo.add(lblDireccionCliente);
        lblDireccionCliente.setBounds(20, 350, 140, 20);

        lblTelefonoCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefonoCliente.setText("Teléfono del Cliente");
        recibo.add(lblTelefonoCliente);
        lblTelefonoCliente.setBounds(20, 380, 130, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("DATOS DEL RESTAURANTE");
        recibo.add(jLabel6);
        jLabel6.setBounds(200, 250, 240, 25);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("DATOS DEL EMPLEADO");
        recibo.add(jLabel16);
        jLabel16.setBounds(440, 250, 210, 25);

        lblFase3Telefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3Telefono.setText("Telefono Restaurante");
        recibo.add(lblFase3Telefono);
        lblFase3Telefono.setBounds(220, 380, 150, 20);

        lblFase3Calle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3Calle.setText("Calle Restaurante");
        recibo.add(lblFase3Calle);
        lblFase3Calle.setBounds(220, 290, 110, 20);

        lblFase3Zona.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3Zona.setText("Zona Restaurante");
        recibo.add(lblFase3Zona);
        lblFase3Zona.setBounds(220, 320, 120, 20);

        lblFase3Lugar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3Lugar.setText("Lugar Restaurante");
        recibo.add(lblFase3Lugar);
        lblFase3Lugar.setBounds(220, 350, 120, 20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("DATOS DEL CLIENTE");
        recibo.add(jLabel17);
        jLabel17.setBounds(10, 250, 190, 25);

        lblFase3NombreE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3NombreE.setText("Nombre del Empleado");
        recibo.add(lblFase3NombreE);
        lblFase3NombreE.setBounds(440, 290, 140, 20);

        lblFase3ApellidoE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3ApellidoE.setText("Apellido del Empleado");
        recibo.add(lblFase3ApellidoE);
        lblFase3ApellidoE.setBounds(440, 320, 150, 20);

        lblFase3TelefonoE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3TelefonoE.setText("Telefono del Empleado");
        recibo.add(lblFase3TelefonoE);
        lblFase3TelefonoE.setBounds(440, 350, 140, 20);

        lblFase3DireccionE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFase3DireccionE.setText("Direccion del Empleado");
        recibo.add(lblFase3DireccionE);
        lblFase3DireccionE.setBounds(440, 380, 150, 20);
        recibo.add(jSeparator1);
        jSeparator1.setBounds(0, 420, 640, 3);

        getContentPane().add(recibo);
        recibo.setBounds(7, 239, 645, 240);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir);
        btnImprimir.setBounds(580, 500, 76, 22);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1000pxl.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 690, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Con este boton se agregan productos a la compra
     * @param evt crea un evento al presionarlo
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       Venta venta=new Venta();
       venta.setId(cboProducto.getSelectedIndex());
       venta.setNombre(cboProducto.getSelectedItem().toString());
       venta.setPrecio(precio);
       venta.setCantidad(cantidad);
       venta.setImporte(precio*cantidad);
       if(!buscarVenta(venta)){

          listaVentas.add(venta);
       }
       actualizarTabla();
       borrarVenta();
    }//GEN-LAST:event_btnAgregarActionPerformed
    /**
     * Con este metodo se verifica si ese producto ya esta en la lista de compra
     * @param nueva parametro para verificar su existencia en la compra
     * @return devuelve verdadero o falso dependiendo si ya esta o no en la compra
     */
    public boolean buscarVenta(Venta nueva){
        for (Venta v: listaVentas) {
        if(v.getId()==nueva.getId()){
            int nuevaCantidad=v.getCantidad()+nueva.getCantidad();
            v.setCantidad(nuevaCantidad);
            v.setImporte(v.getPrecio()*nuevaCantidad);
            return true;
        }
        }
        return false;
    }  
    /**
     * Despues poner en la lista de compra un producto, este metodo actualiza ciertos datos
     */
    public void borrarVenta(){
        precio=0;
        cantidad=1;
        cboProducto.setSelectedIndex(0);
        spnCantidad.setValue(1);
        calcularPrecio();
    }
    /**
     * Con este Combo Box se elige el producto a comprar y se calcula su precio
     * @param evt crea un evento al presionarlo
     */
    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
        calcularPrecio();
    }//GEN-LAST:event_cboProductoActionPerformed
    /**
     * Con este spinner se elige la cantidad de un mismo producto a comprar y se calcula su precio
     * @param evt crea un evento al presionarlo
     */
    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        calcularPrecio();
    }//GEN-LAST:event_spnCantidadStateChanged
    /**
     * Con este boton se imprime la factura de la compra 
     * @param evt crea un evento al presionarlo
     */
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
               try{
            PrinterJob gap=PrinterJob.getPrinterJob();
            gap.setPrintable(this);
            boolean top=gap.printDialog();
            if(top){
                gap.print();
            }
        }catch(PrinterException e){
            JOptionPane.showMessageDialog(null, "Error de programa","Error\n"+e,JOptionPane.INFORMATION_MESSAGE);
        }               
        
    }//GEN-LAST:event_btnImprimirActionPerformed
    /**
     * Con este boton se ingresa el billete con el que se pagara y se muestra el cambio
     * @param evt crea un evento al presionarlo
     */
    private void btnIngresarBilleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarBilleteActionPerformed
        while(modelo.getRowCount()>0){
         modelo.removeRow(0);
        }
        double total=0;
        for (Venta v: listaVentas) {
            Object compra[]=new Object[4];
            compra[0]=v.getNombre();
            compra[1]=aMoneda(v.getPrecio());
            compra[2]=v.getCantidad();
            compra[3]=aMoneda(v.getImporte());
            total+=v.getImporte();
            modelo.addRow(compra);
        }     
        
        lblTotal.setText(aMoneda(total));
        lblCambio.setText(aMoneda(Double.parseDouble(txtBillete.getText())-total));
        
        tblProductos.setModel(modelo);
    }//GEN-LAST:event_btnIngresarBilleteActionPerformed
    /**
     * Con este metodo se calcula el importe de la compra basandose en la eleccion y cantidad de productos
     */
    public void calcularPrecio(){
        precio=precios[cboProducto.getSelectedIndex()];
        cantidad=Integer.parseInt(spnCantidad.getValue().toString());
        lblPrecio.setText(aMoneda(precio));
        lblImporte.setText(aMoneda(precio*cantidad));
        
    }
    /**
     * Con este metodo se muestra en la factura la fecha en la que se realizo la compra
     * @return returna la fecha actual
     */
    public static String fechaActual(){  
    Date fecha=new Date();
    SimpleDateFormat formatoFecha=new SimpleDateFormat();
    return formatoFecha.format(fecha);
    }  
    /**
     * Con este metodo se realiza una conversion del precio a tipo moneda
     * @param precio parametro para realizar la conversion
     * @return retorna el precio en moneda
     */
    public String aMoneda(double precio){
        return "Q"+precio;
    }
    /**
     * Despues de realizar algun cambio en la compra, con este metodo se realiza el cambio en la tabla
     */
    public void actualizarTabla(){
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        double total=0;
        for (Venta venta: listaVentas) {
            Object compra[]=new Object[4];
            compra[0]=venta.getNombre();
            compra[1]=aMoneda(venta.getPrecio());
            compra[2]=venta.getCantidad();
            compra[3]=aMoneda(venta.getImporte());
            total+=venta.getImporte();
            modelo.addRow(compra);
        }     
        
        lblTotal.setText(aMoneda(total));     
        tblProductos.setModel(modelo);
    }
    
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
            java.util.logging.Logger.getLogger(VistaClienteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaClienteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaClienteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaClienteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaClienteCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnIngresarBillete;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField9;
    public static javax.swing.JLabel lblApellidoCliente;
    private javax.swing.JLabel lblCambio;
    public static javax.swing.JLabel lblDireccionCliente;
    public static javax.swing.JLabel lblFase3ApellidoE;
    public static javax.swing.JLabel lblFase3Calle;
    public static javax.swing.JLabel lblFase3DireccionE;
    public static javax.swing.JLabel lblFase3Lugar;
    public static javax.swing.JLabel lblFase3NombreE;
    public static javax.swing.JLabel lblFase3Telefono;
    public static javax.swing.JLabel lblFase3TelefonoE;
    public static javax.swing.JLabel lblFase3Zona;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblLogo;
    public static javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblPrecio;
    public static javax.swing.JLabel lblTelefonoCliente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JPanel recibo;
    private javax.swing.JPanel recibo1;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblProductos1;
    public static javax.swing.JTextField txtApellidoCliente1;
    private javax.swing.JTextField txtBillete;
    public static javax.swing.JTextField txtDireccionCliente1;
    private javax.swing.JTextField txtFecha1;
    public static javax.swing.JTextField txtNombreCliente1;
    public static javax.swing.JTextField txtTelefonoCliente1;
    // End of variables declaration//GEN-END:variables

    @Override
    /**
     * Con este metodo se realizan algunos detalles para la impresion de la factura
     */
    public int print(Graphics grafico, PageFormat formatoPagina, int index) throws PrinterException {
        if(index>0){
        return NO_SUCH_PAGE;
        }
        Graphics2D imprimir=(Graphics2D) grafico;
        imprimir.translate(formatoPagina.getImageableX()+70, formatoPagina.getImageableY()+30);
        imprimir.scale(1.0, 1.0);
        recibo.printAll(grafico);
        return PAGE_EXISTS;
    }
}
