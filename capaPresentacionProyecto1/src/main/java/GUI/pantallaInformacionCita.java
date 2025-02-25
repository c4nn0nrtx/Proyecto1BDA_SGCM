package GUI;

import DTO.CitaNuevoDTO;
import Entidades.Medico;
import Entidades.Paciente;
import Exception.PersistenciaException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Pantalla para mostrar la información de una cita. Muestra los datos del
 * médico, la especialidad, el horario y el paciente. Permite cancelar la cita.
 *
 * @author PC
 */
public class pantallaInformacionCita extends javax.swing.JPanel {

    /**
     * Creates new form informacionDeTuCita
     */
    FramePrincipal framePrincipal;

    /**
     * Constructor de la pantalla de información de cita. Inicializa los
     * componentes y establece el FramePrincipal.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaInformacionCita(FramePrincipal frame) {
        this.framePrincipal = frame;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSubTitulo = new javax.swing.JLabel();
        txtSubTitulo1 = new javax.swing.JLabel();
        outputNombreDoctor = new javax.swing.JTextField();
        txtSubTitulo2 = new javax.swing.JLabel();
        outputEspecialidad = new javax.swing.JTextField();
        txtSubTitulo3 = new javax.swing.JLabel();
        outputHorarioCita = new javax.swing.JTextField();
        txtSubTitulo4 = new javax.swing.JLabel();
        outputNombrePaciente = new javax.swing.JTextField();
        txtSubTitulo5 = new javax.swing.JLabel();
        pnlCancelarCita1 = new javax.swing.JPanel();
        btnFinalizarConsulta = new javax.swing.JLabel();
        btnVolver = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Información de tu Cita");

        txtSubTitulo1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo1.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo1.setText("Le atiende:");

        outputNombreDoctor.setEditable(false);
        outputNombreDoctor.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        outputNombreDoctor.setForeground(new java.awt.Color(0, 0, 0));
        outputNombreDoctor.setText("Nombre del Doctor");
        outputNombreDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputNombreDoctorActionPerformed(evt);
            }
        });
        outputNombreDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputNombreDoctorKeyPressed(evt);
            }
        });

        txtSubTitulo2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo2.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo2.setText("Especialidad:");

        outputEspecialidad.setEditable(false);
        outputEspecialidad.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        outputEspecialidad.setForeground(new java.awt.Color(0, 0, 0));
        outputEspecialidad.setText("Especialidad del Doctor");

        txtSubTitulo3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo3.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo3.setText("Horario:");

        outputHorarioCita.setEditable(false);
        outputHorarioCita.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        outputHorarioCita.setForeground(new java.awt.Color(0, 0, 0));
        outputHorarioCita.setText("Horario de la Cita");
        outputHorarioCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputHorarioCitaActionPerformed(evt);
            }
        });

        txtSubTitulo4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTitulo4.setForeground(new java.awt.Color(204, 0, 51));
        txtSubTitulo4.setText("LAS CITAS SOLO SE PUEDEN CANCELAR  DENTRO DE LAS 24 HRS DE SU CREACION");

        outputNombrePaciente.setEditable(false);
        outputNombrePaciente.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        outputNombrePaciente.setForeground(new java.awt.Color(0, 0, 0));
        outputNombrePaciente.setText("Nombre del Paciente");
        outputNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputNombrePacienteActionPerformed(evt);
            }
        });

        txtSubTitulo5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo5.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo5.setText("Paciente:");

        pnlCancelarCita1.setBackground(new java.awt.Color(255, 102, 120));

        btnFinalizarConsulta.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnFinalizarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFinalizarConsulta.setText("Cancelar Cita");
        btnFinalizarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarConsultaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCancelarCita1Layout = new javax.swing.GroupLayout(pnlCancelarCita1);
        pnlCancelarCita1.setLayout(pnlCancelarCita1Layout);
        pnlCancelarCita1Layout.setHorizontalGroup(
            pnlCancelarCita1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCancelarCita1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCancelarCita1Layout.setVerticalGroup(
            pnlCancelarCita1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCancelarCita1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(txtSubTitulo4)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSubTitulo5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSubTitulo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTitulo2)
                            .addComponent(outputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTitulo1)
                            .addComponent(outputHorarioCita, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSubTitulo)
                .addGap(246, 246, 246))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtSubTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addGap(76, 76, 76)
                .addComponent(txtSubTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSubTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSubTitulo3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pnlCancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputHorarioCita, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSubTitulo5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(txtSubTitulo4)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void outputHorarioCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputHorarioCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputHorarioCitaActionPerformed

    private void outputNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNombrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNombrePacienteActionPerformed

    private void outputNombreDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputNombreDoctorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNombreDoctorKeyPressed

    /**
     * Maneja el evento de clic en el botón "Volver". Regresa a la pantalla de
     * pacientes.
     *
     * @param evt El evento del mouse.
     */
    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaPacientes");
    }//GEN-LAST:event_btnVolverMouseClicked

    /**
     * Maneja el evento de clic en el botón "Cancelar Cita". Muestra un cuadro
     * de confirmación y, si el usuario confirma, llama al método `cancelarCita`
     * de la pantalla de pacientes.
     *
     * @param evt El evento del mouse.
     */
    private void btnFinalizarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarConsultaMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cancelar la cita: ", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario cancelo la cita.");
            pantallaMenuPrincipalPacientes cancelar = framePrincipal.getPantallaPacientes();
            cancelar.cancelarCita();
        } else {
            System.out.println("El usuario no cancelo la cita.");
        }
    }//GEN-LAST:event_btnFinalizarConsultaMouseClicked

    private void outputNombreDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNombreDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNombreDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFinalizarConsulta;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JTextField outputEspecialidad;
    private javax.swing.JTextField outputHorarioCita;
    private javax.swing.JTextField outputNombreDoctor;
    private javax.swing.JTextField outputNombrePaciente;
    private javax.swing.JPanel pnlCancelarCita1;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtSubTitulo1;
    private javax.swing.JLabel txtSubTitulo2;
    private javax.swing.JLabel txtSubTitulo3;
    private javax.swing.JLabel txtSubTitulo4;
    private javax.swing.JLabel txtSubTitulo5;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga y muestra los datos de la cita en los campos correspondientes.
     * Obtiene los datos de la cita a través del FramePrincipal y los muestra
     * formateados en los campos de texto.
     */
    public void cargarDatosCita() {
        CitaNuevoDTO citaGlobal = framePrincipal.getCitaFinal();
        Medico medico = citaGlobal.getMedico();
        Paciente paciente = citaGlobal.getPaciente();
        LocalDateTime fechaHora = citaGlobal.getFechaHora();
        outputNombreDoctor.setText("Dr. " + medico.getNombre() + " " + medico.getApellidoPaterno());
        outputEspecialidad.setText(medico.getEspecialidad());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM, h:mm a", Locale.forLanguageTag("es-MX"));
        String fechaFormateada = fechaHora.format(formatter);
        outputHorarioCita.setText(fechaFormateada.substring(0, 1).toUpperCase() + fechaFormateada.substring(1));
        outputNombrePaciente.setText(paciente.getNombre() + " " + paciente.getApellidoPaterno());
    }
}
