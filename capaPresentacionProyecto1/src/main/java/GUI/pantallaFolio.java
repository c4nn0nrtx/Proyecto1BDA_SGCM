/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaFolio extends javax.swing.JPanel {

    /**
     * Creates new form pantallaFolio
     */
    public pantallaFolio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSubTitulo = new javax.swing.JLabel();
        txtSubTitulo1 = new javax.swing.JLabel();
        inputFolio = new javax.swing.JTextField();
        pnlCancelarCita2 = new javax.swing.JPanel();
        btnGuardarCambios = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSubTitulo.setText("Folio:");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 82, -1));

        txtSubTitulo1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        txtSubTitulo1.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSubTitulo1.setText("Ingresa el folio de la consulta");
        add(txtSubTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, 988, -1));

        inputFolio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputFolio.setText("Ingrese el folio de la cita de emergencia");
        inputFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFolioActionPerformed(evt);
            }
        });
        add(inputFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 505, 50));

        pnlCancelarCita2.setBackground(new java.awt.Color(51, 102, 255));

        btnGuardarCambios.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardarCambios.setText("Ingresar");
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlCancelarCita2Layout = new javax.swing.GroupLayout(pnlCancelarCita2);
        pnlCancelarCita2.setLayout(pnlCancelarCita2Layout);
        pnlCancelarCita2Layout.setHorizontalGroup(
            pnlCancelarCita2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        pnlCancelarCita2Layout.setVerticalGroup(
            pnlCancelarCita2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(pnlCancelarCita2, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 459, 170, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void inputFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFolioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardarCambios;
    private javax.swing.JTextField inputFolio;
    private javax.swing.JPanel pnlCancelarCita2;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtSubTitulo1;
    // End of variables declaration//GEN-END:variables
}
