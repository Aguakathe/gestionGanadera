
package presentacion;
import negocio.GanaderoControl;
import javax.swing.JOptionPane;

public class FrmGanadero extends javax.swing.JInternalFrame {

    private final GanaderoControl CONTROL;
        private String accion;
        private String GanaderoIdAnt;
        
    public FrmGanadero() {
        initComponents();
        this.CONTROL = new GanaderoControl();
        this.listar("");
        Tabgeneral.setEnabledAt(1, false);
        this.accion = "";
        txtid.setVisible(false);

        
        
    }
    public void listar(String texto){
        tablaListar.setModel(this.CONTROL.listar(texto));
        ibtotalregistros.setText("Mostrando "+ this.CONTROL.totalMostrados()+" total de "+ this.CONTROL.total());
    }
    private void limpiar(){
        txtNumId.setText("");
        txtactivo.setText("");
        txtdireccion.setText("");
        txtemail.setText("");
        txtganadero.setText("");
        txtid.setText("");
        txtnombre.setText("");
        txtnumero.setText("");
        txttelefono.setText("");
        txttipodocumento.setText("");
    }
    private void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Sistema ", JOptionPane.ERROR_MESSAGE);
    }

    private void mensajeOK(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Sistema ", JOptionPane.INFORMATION_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabgeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtganadero = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txttipodocumento = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtactivo = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnGaurdar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNumId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListar = new javax.swing.JTable();
        ibtotalregistros = new javax.swing.JLabel();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();

        jLabel1.setText("Ganadero id");

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo de documento");

        jLabel4.setText("Numero de documento");

        jLabel5.setText("Telefono");

        jLabel6.setText("Email");

        jLabel7.setText("Direccion");

        jLabel8.setText("Activo");

        btnGaurdar.setText("Guardar");
        btnGaurdar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaurdarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(btnGaurdar))
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncancelar)
                            .addComponent(txtactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtganadero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtganadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGaurdar)
                    .addComponent(btncancelar))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        Tabgeneral.addTab("Editar", jPanel1);

        jLabel9.setText("Numero de id ");

        btnBuscar.setText("Buscar");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tablaListar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaListar);

        ibtotalregistros.setText("Registros");

        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        btnDesactivar.setText("Desactivar");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(86, 86, 86)
                                .addComponent(txtNumId, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnBuscar)
                                .addGap(56, 56, 56)
                                .addComponent(btnNuevo)
                                .addGap(47, 47, 47)
                                .addComponent(btnEditar)))
                        .addContainerGap(87, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnActivar)
                        .addGap(52, 52, 52)
                        .addComponent(btnDesactivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ibtotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDesactivar)
                        .addComponent(ibtotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActivar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        Tabgeneral.addTab("Listar ", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabgeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabgeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Tabgeneral.setEnabledAt(1, true);
        Tabgeneral.setEnabledAt(0, false);
        Tabgeneral.setSelectedIndex(1);
        this.accion = "guardar";
        btnGaurdar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaListar.getSelectedRow() == 1) {
            String id = String .valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 0));
            String ganaderoid = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 1));
            this.GanaderoIdAnt = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(),1));
            String nombre = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 2));
            String tipodedocumento = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 3));
            String numerodocumento = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 4));
            String telefono = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 5));
            String direccion = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 6));
            String email = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 7));
            String activo = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 8));
            
            txtid.setText(id);
            txtNumId.setText(ganaderoid);
            txtnombre.setText(nombre);
            txttipodocumento.setText(tipodedocumento);
            txtnumero.setText(numerodocumento);
            txttelefono.setText(telefono);
            txtdireccion.setText(direccion);
            txtemail.setText(email);
            txtactivo.setText(activo);
            
            Tabgeneral.setEnabledAt(0, false);
            Tabgeneral.setEnabledAt(1, true);
            Tabgeneral.setSelectedIndex(1);
            this.accion = "editar";

            btnGaurdar.setText("editar");
        }else{
            this.mensajeError("Seleccione un registro a editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        Tabgeneral.setEnabledAt(0, true);
        Tabgeneral.setEnabledAt(1, false);
        Tabgeneral.setSelectedIndex(0);
        this.limpiar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnGaurdarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaurdarActionPerformed
        if (txtNumId.getText().length() == 0 || txtNumId.getText().length() > 20) {
        JOptionPane.showMessageDialog(this, "Debes ingresar un id de ganadero, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
        txtNumId.requestFocus();
        return;
    }
    try {
        int id = Integer.parseInt(txtNumId.getText());
        String Nombre = txtnombre.getText();
        String Tipo_Documento = txttipodocumento.getText();
        int Num_Documento = Integer.parseInt(txtnumero.getText());
        int Telefono = Integer.parseInt(txttelefono.getText());
        String Direccion = txtdireccion.getText();
        String Email = txtemail.getText();
        String activoText = txtactivo.getText();
       
        
        if (!activoText.equals("true") && !activoText.equals("false")) {
            JOptionPane.showMessageDialog(this, "El campo de activo debe ser true o false", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean Activo = Boolean.parseBoolean(activoText);
        
        String resp;
        if (this.accion.equals("Editar")) {
            resp = this.CONTROL.Actualizar(id, Nombre, Direccion, GanaderoIdAnt, Tipo_Documento, Num_Documento, Telefono, Email);

            
                if (resp.equals("OK")) {
                    this.mensajeOK("Actualizado correctamente");
                    this.limpiar();
                    this.listar("");
                     Tabgeneral.setSelectedIndex(0);
                    Tabgeneral.setEnabledAt(0, true);
                    Tabgeneral.setEnabledAt(1, false);
                }else{
                    this.mensajeError(resp);
                }
            }else{
                resp = this.CONTROL.Insertar(Nombre, Direccion, Tipo_Documento, Num_Documento, Telefono, Email);
                 if (resp.equals("OK")) {
                    this.mensajeOK("Registrado correctamente");
                    this.limpiar();
                    this.listar("");
                    Tabgeneral.setSelectedIndex(0);
                    Tabgeneral.setEnabledAt(0, true);
                    Tabgeneral.setEnabledAt(1, false);
                } else {
                    this.mensajeError(resp);
                }
            }

            
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa valores numéricos válidos en los campos Edad y Peso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGaurdarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        if (tablaListar.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListar.getValueAt(tablaListar.getSelectedRow(), 2));

            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Deseas activar el registro \"" + nombre + "\"?",
                    "Activar registro",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                String resp = this.CONTROL.Activar(Integer.parseInt(id));
                if (resp.equals("OK")) {
                    this.mensajeOK("Registro activado correctamente");
                    this.listar("");
                } else {
                    this.mensajeError("No se pudo activar el registro: " + resp);
                }
            }
        } else {
            this.mensajeError("Debes seleccionar un solo registro para activar");
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
       int fila = tablaListar.getSelectedRow();
    if (fila != -1) {
        String id = String.valueOf(tablaListar.getValueAt(fila, 0));
        String nombre = String.valueOf(tablaListar.getValueAt(fila, 1));
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas desactivar el registro \"" + nombre + "\"?",
                "Desactivar registro",
                JOptionPane.YES_NO_OPTION
        );
        if (confirmacion == JOptionPane.YES_OPTION) {
            String resp = this.CONTROL.Desactivar(Integer.parseInt(id));
            if (resp.equals("OK")) {
                this.mensajeOK("Registro desactivado correctamente");
                this.listar("");
            } else {
                this.mensajeError("No se pudo desactivar el registro: " + resp);
            }
        }
    } else {
        this.mensajeError("Debes seleccionar un registro para desactivar.");
    }
    }//GEN-LAST:event_btnDesactivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabgeneral;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGaurdar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel ibtotalregistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaListar;
    private javax.swing.JTextField txtNumId;
    private javax.swing.JTextField txtactivo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtganadero;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttipodocumento;
    // End of variables declaration//GEN-END:variables
}
