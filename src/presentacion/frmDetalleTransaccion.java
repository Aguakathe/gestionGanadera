
package presentacion;

import javax.swing.JOptionPane;
import negocio.GanadoControl;
import negocio.DetalleTransaccionControl;

public class frmDetalleTransaccion extends javax.swing.JInternalFrame {

    private final DetalleTransaccionControl CONTROL;
    private String accion;
    private String ganadero_id_ant;
    public frmDetalleTransaccion() {
        initComponents();
        this.CONTROL = new DetalleTransaccionControl();
        this.listar("");
        tabgenreañ.setEnabledAt(1, false);
        this.accion = "";
        txtid.setVisible(false);
    }
     private void listar(String texto) {
        tabladetaller.setModel(this.CONTROL.listar(texto));
        //Mostrando el total Mostardo (Método creado en CategoriaCotrol) y mostrando el total acumulativo de la base de datos
        ibtotalreghistros.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total());
    }
     private void limpiar() {
        txtIdganadi.setText("");
        txtPrecio.setText("");
        txtTransaccioniddd.setText("");
        txtid.setText("");
        txtganaderoid.setText("");
        txtTransaccioniddd.setText("");
        this.accion = "guardar";
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

        tabgenreañ = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTrasanccionid = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladetaller = new javax.swing.JTable();
        ibtotalreghistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtganaderoid = new javax.swing.JTextField();
        txtTransaccioniddd = new javax.swing.JTextField();
        txtIdganadi = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();

        jLabel1.setText("Id transaccion ");

        btnBuscar.setText("Buscar");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        tabladetaller.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabladetaller);

        ibtotalreghistros.setText("Registros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTrasanccionid, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(btnBuscar)
                        .addGap(80, 80, 80)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(btneditar)))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ibtotalreghistros)
                .addGap(270, 270, 270))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTrasanccionid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btneditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ibtotalreghistros)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tabgenreañ.addTab("Listar", jPanel1);

        jLabel2.setText("Id ganadero ");

        jLabel3.setText("Id transaccion");

        jLabel4.setText("Id ganado");

        jLabel5.setText("Cantidad");

        jLabel6.setText("Precio unitario");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(164, 164, 164))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnguardar)
                            .addGap(163, 163, 163))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(202, 202, 202)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtganaderoid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTransaccioniddd, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdganadi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(153, 153, 153)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtganaderoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransaccioniddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdganadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btnguardar))
                .addGap(92, 92, 92))
        );

        tabgenreañ.addTab("Editar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabgenreañ)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabgenreañ)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabgenreañ.setEnabledAt(1, true);
        tabgenreañ.setEnabledAt(0, false);
        tabgenreañ.setSelectedIndex(1);
        this.accion = "Guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        tabgenreañ.setEnabledAt(0, true);
        tabgenreañ.setEnabledAt(1, false);
        tabgenreañ.setSelectedIndex(0);
        this.limpiar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtganaderoid.getText().length()==0) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un ID de ganadero, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
        txtganaderoid.requestFocus();
        return;
        }
        try{
            int ganaderoid = Integer.parseInt(txtganaderoid.getText());
            int idtransaccion = Integer.parseInt(txtTransaccioniddd.getText());
            int idganado = Integer.parseInt(txtIdganadi.getText());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int cantidad = Integer.parseInt(txtcantidad.getText());
             String estado = txtEstado.getText().trim().toLowerCase();
             if (!estado.equals("pendiente") && !estado.equals("completado") && !estado.equals("cancelado")) {
            JOptionPane.showMessageDialog(this, "Estado inválido. Usa: pendiente, completado o cancelado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
             String resp;
             
             if (this.accion.equals("Editar")) {
                int id = Integer.parseInt(txtid.getText());
                resp = this.CONTROL.Actualizar(id, idtransaccion, idganado, precio, cantidad, idganado);
                if (resp.equals("OK")) {
                this.mensajeOK("Transacción actualizada correctamente");
                this.limpiar();
                this.listar("");
                tabgenreañ.setSelectedIndex(0);
                tabgenreañ.setEnabledAt(1, false);
            } else {
                this.mensajeError(resp);
            }
        } else {
            // Insertar nueva transacción
            resp = this.CONTROL.Insertar(idtransaccion, idganado, precio, cantidad,estado);

            if (resp.equals("OK")) {
                this.mensajeOK("Transacción registrada correctamente");
                this.limpiar();
                this.listar("");
                tabgenreañ.setSelectedIndex(0);
                tabgenreañ.setEnabledAt(0, true);
                tabgenreañ.setEnabledAt(1, false);
            } else {
                this.mensajeError(resp);
            }
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa un número válido en el campo Total o ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }
            
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        if (tabladetaller.getSelectedRowCount() == 1) {
            String id = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(), 0));
            String ganaderoId = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(), 1));
            this.ganadero_id_ant = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(),1));
            String idganado = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(), 2));
            String precio = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(), 3));
            String cantidad = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(), 4));
            String estado = String.valueOf(tabladetaller.getValueAt(tabladetaller.getSelectedRow(), 5));
            
            txtid.setText(id); 
            txtganaderoid.setText(ganaderoId);
            txtIdganadi.setText(idganado);
            txtPrecio.setText(precio);
            txtcantidad.setText(cantidad);
            txtEstado.setText(estado);
            
            tabgenreañ.setEnabledAt(0, false);
            tabgenreañ.setEnabledAt(1, true);
            tabgenreañ.setSelectedIndex(1);
            this.accion = "editar";

            btnguardar.setText("editar");
}
    }//GEN-LAST:event_btneditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel ibtotalreghistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabgenreañ;
    private javax.swing.JTable tabladetaller;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdganadi;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTransaccioniddd;
    private javax.swing.JTextField txtTrasanccionid;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtganaderoid;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
