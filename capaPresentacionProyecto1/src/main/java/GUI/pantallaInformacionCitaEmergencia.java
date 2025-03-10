package GUI;

import DTO.CitaNuevoDTO;
import Entidades.Medico;
import Entidades.Paciente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Pantalla para mostrar la información de una cita de emergencia. Muestra los
 * datos del médico, la especialidad, el horario, el paciente y el folio de
 * atención.
 *
 * @author brand
 */
public class pantallaInformacionCitaEmergencia extends javax.swing.JPanel {

    /**
     * Creates new form pantallaCitaEmergencia
     */
    FramePrincipal framePrincipal;

    /**
     * Constructor de la pantalla de información de cita de emergencia.
     * Inicializa los componentes y establece el FramePrincipal.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaInformacionCitaEmergencia(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        txtSubTitulo6 = new javax.swing.JLabel();
        outputFolioAtencion = new javax.swing.JTextField();
        btnVolver = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Situación de Emergencia");

        txtSubTitulo1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo1.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo1.setText("Le atiende:");

        outputNombreDoctor.setEditable(false);
        outputNombreDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        outputNombreDoctor.setForeground(new java.awt.Color(0, 0, 0));
        outputNombreDoctor.setText("Nombre del Doctor");

        txtSubTitulo2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo2.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo2.setText("Especialidad:");

        outputEspecialidad.setEditable(false);
        outputEspecialidad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        outputEspecialidad.setForeground(new java.awt.Color(0, 0, 0));
        outputEspecialidad.setText("Especialidad del Doctor");

        txtSubTitulo3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo3.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo3.setText("Horario:");

        outputHorarioCita.setEditable(false);
        outputHorarioCita.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        outputHorarioCita.setForeground(new java.awt.Color(0, 0, 0));
        outputHorarioCita.setText("Horario de la Cita");
        outputHorarioCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputHorarioCitaActionPerformed(evt);
            }
        });

        txtSubTitulo4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo4.setForeground(new java.awt.Color(204, 0, 51));
        txtSubTitulo4.setText("FAVOR DE PRESENTAR FOLIO PARA SER ATENDIDO");

        outputNombrePaciente.setEditable(false);
        outputNombrePaciente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
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

        txtSubTitulo6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtSubTitulo6.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo6.setText("Folio de Atención:");

        outputFolioAtencion.setEditable(false);
        outputFolioAtencion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        outputFolioAtencion.setForeground(new java.awt.Color(0, 0, 0));
        outputFolioAtencion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outputFolioAtencion.setText("Folio de la Cita");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addGap(144, 144, 144)
                        .addComponent(txtSubTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(txtSubTitulo4)))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSubTitulo5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTitulo3)
                            .addComponent(txtSubTitulo2)
                            .addComponent(outputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputHorarioCita, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSubTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSubTitulo6)
                        .addGap(127, 127, 127))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(outputNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outputFolioAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtSubTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTitulo1)
                    .addComponent(txtSubTitulo6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFolioAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtSubTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSubTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputHorarioCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSubTitulo5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(txtSubTitulo4)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 14, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 14, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void outputHorarioCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputHorarioCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputHorarioCitaActionPerformed

    private void outputNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNombrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNombrePacienteActionPerformed

    /**
     * Maneja el evento de clic en el botón "Volver". Regresa a la pantalla de
     * pacientes. Imprime información del usuario autenticado en la consola
     * (esto es solo para depuración y debería eliminarse en la versión final).
     *
     * @param evt El evento del mouse.
     */
    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaPacientes");
        System.out.println(framePrincipal.getUsuarioAutenticado());
    }//GEN-LAST:event_btnVolverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField outputEspecialidad;
    private javax.swing.JTextField outputFolioAtencion;
    private javax.swing.JTextField outputHorarioCita;
    private javax.swing.JTextField outputNombreDoctor;
    private javax.swing.JTextField outputNombrePaciente;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtSubTitulo1;
    private javax.swing.JLabel txtSubTitulo2;
    private javax.swing.JLabel txtSubTitulo3;
    private javax.swing.JLabel txtSubTitulo4;
    private javax.swing.JLabel txtSubTitulo5;
    private javax.swing.JLabel txtSubTitulo6;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga y muestra los datos de la cita en los campos correspondientes.
     * Obtiene los datos de la cita a través del FramePrincipal y los muestra
     * formateados en los campos de texto. Maneja posibles errores si la
     * información de la cita no está disponible.
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
        outputFolioAtencion.setText(citaGlobal.getFolio());
    }
}
