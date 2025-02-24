/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BO.CitaBO;
import DTO.CitaNuevoDTO;
import Entidades.Cita;
import Entidades.Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import configuracion.DependencyInjector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaFolio extends javax.swing.JPanel {

    /**
     * Creates new form pantallaFolio
     */
    FramePrincipal framePrincipal;
    private CitaBO citaBO = DependencyInjector.crearCitaBO();

    public pantallaFolio(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();
        //QUITAR EL FOCUS DEL INPUT DE FOLIO
        SwingUtilities.invokeLater(() -> this.requestFocusInWindow());

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
        btnVolver = new javax.swing.JLabel();

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
        inputFolio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputFolioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputFolioFocusLost(evt);
            }
        });
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
        btnGuardarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCambiosMouseClicked(evt);
            }
        });

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

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inputFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFolioActionPerformed

    private void btnGuardarCambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCambiosMouseClicked
        try {
            validarFolio();
        } catch (NegocioException ex) {
            Logger.getLogger(pantallaFolio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaFolio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarCambiosMouseClicked

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaCitasPendientes");
    }//GEN-LAST:event_btnVolverMouseClicked

    private void inputFolioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFolioFocusGained
        if (inputFolio.getText().equals("Ingrese el folio de la cita de emergencia")) {
            inputFolio.setText("");
        }

    }//GEN-LAST:event_inputFolioFocusGained

    private void inputFolioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputFolioFocusLost
        if (inputFolio.getText().trim().isEmpty()) {
            inputFolio.setText("Ingrese el folio de la cita de emergencia");
        }
    }//GEN-LAST:event_inputFolioFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardarCambios;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JTextField inputFolio;
    private javax.swing.JPanel pnlCancelarCita2;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtSubTitulo1;
    // End of variables declaration//GEN-END:variables

    public boolean validarFolio() throws NegocioException, PersistenciaException {
        CitaNuevoDTO citaFinal = framePrincipal.getCitaFinal();
        System.out.println(citaFinal);
        Paciente paciente = citaFinal.getPaciente();

        Cita cita = citaBO.consultarCitaPorFechaYPaciente(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), citaFinal.getFechaHora());
        cita.setFolio(inputFolio.getText());

        boolean exito = citaBO.validarFolio(cita);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Folio correcto.");
            pantallaDatosConsulta horaEntrada = framePrincipal.getPantallaDatosConsulta();
            horaEntrada.cargarHoraEntrada();
            framePrincipal.cambiarPanel("pantallaDatosConsulta");
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Folio incorrecto para esta cita.", "Folio invalido.", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

}
