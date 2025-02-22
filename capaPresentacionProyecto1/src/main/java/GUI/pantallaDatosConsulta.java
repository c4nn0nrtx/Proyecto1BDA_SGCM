/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaDatosConsulta extends javax.swing.JPanel {

    /**
     * Creates new form pantallaDatosConsulta1
     */
    public pantallaDatosConsulta() {
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
        jLabel1 = new javax.swing.JLabel();
        inputNombrePaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputDiagnostico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputHorarioCita = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputObservaciones = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputNombrePaciente1 = new javax.swing.JTextField();
        pnlCancelarCita1 = new javax.swing.JPanel();
        btnFinalizarConsulta = new javax.swing.JLabel();
        pnlCancelarCita2 = new javax.swing.JPanel();
        btnGuardarCambios = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Información de tu Cita");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Paciente:");

        inputNombrePaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputNombrePaciente.setText("Nombre del Paciente");
        inputNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombrePacienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Diagnóstico:");

        inputDiagnostico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputDiagnostico.setText("Diagnóstico del Paciente");
        inputDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDiagnosticoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tratamiento:");

        inputHorarioCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputHorarioCita.setText("Tratamiento del Paciente");
        inputHorarioCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHorarioCitaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Observaciones:");

        inputObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputObservaciones.setText("Tratamiento del Paciente");
        inputObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputObservacionesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Hora de Entrada:");

        inputNombrePaciente1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputNombrePaciente1.setText("Hora del Sistema");
        inputNombrePaciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombrePaciente1ActionPerformed(evt);
            }
        });

        pnlCancelarCita1.setBackground(new java.awt.Color(255, 102, 120));

        btnFinalizarConsulta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnFinalizarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFinalizarConsulta.setText("Finalizar Consulta");
        btnFinalizarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlCancelarCita1Layout = new javax.swing.GroupLayout(pnlCancelarCita1);
        pnlCancelarCita1.setLayout(pnlCancelarCita1Layout);
        pnlCancelarCita1Layout.setHorizontalGroup(
            pnlCancelarCita1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCancelarCita1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCancelarCita1Layout.setVerticalGroup(
            pnlCancelarCita1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCancelarCita1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(btnFinalizarConsulta)
                .addContainerGap())
        );

        pnlCancelarCita2.setBackground(new java.awt.Color(51, 102, 255));

        btnGuardarCambios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlCancelarCita2Layout = new javax.swing.GroupLayout(pnlCancelarCita2);
        pnlCancelarCita2.setLayout(pnlCancelarCita2Layout);
        pnlCancelarCita2Layout.setHorizontalGroup(
            pnlCancelarCita2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCancelarCita2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCancelarCita2Layout.setVerticalGroup(
            pnlCancelarCita2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCancelarCita2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(btnGuardarCambios)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(pnlCancelarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                    .addComponent(pnlCancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(inputObservaciones, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputHorarioCita, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputDiagnostico, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(inputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputNombrePaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSubTitulo)
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtSubTitulo)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNombrePaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(inputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputHorarioCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCancelarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombrePacienteActionPerformed

    private void inputDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDiagnosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDiagnosticoActionPerformed

    private void inputHorarioCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHorarioCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHorarioCitaActionPerformed

    private void inputObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputObservacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputObservacionesActionPerformed

    private void inputNombrePaciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombrePaciente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombrePaciente1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFinalizarConsulta;
    private javax.swing.JLabel btnGuardarCambios;
    private javax.swing.JTextField inputDiagnostico;
    private javax.swing.JTextField inputHorarioCita;
    private javax.swing.JTextField inputNombrePaciente;
    private javax.swing.JTextField inputNombrePaciente1;
    private javax.swing.JTextField inputObservaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlCancelarCita1;
    private javax.swing.JPanel pnlCancelarCita2;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables
}
