package GUI;

import BO.CitaBO;
import BO.ConsultaBO;
import DTO.CitaNuevoDTO;
import DTO.ConsultaNuevaDTO;
import Entidades.Cita;
import Entidades.Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import configuracion.DependencyInjector;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pantalla para registrar los datos de una consulta médica. Permite ingresar
 * diagnóstico, tratamiento y observaciones, y finalizar la consulta.
 *
 * @author Sebastian Moreno
 */
public class pantallaDatosConsulta extends javax.swing.JPanel {

    FramePrincipal framePrincipal;
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private ConsultaBO consultaBO = DependencyInjector.crearConsultaBO();
    Mapper mapper = new Mapper();

    /**
     * Constructor de la pantalla de datos de consulta.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaDatosConsulta(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSubTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputDiagnostico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputTratamientoCita = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputObservaciones = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputHoraEntrada = new javax.swing.JTextField();
        pnlCancelarCita1 = new javax.swing.JPanel();
        btnFinalizarConsulta = new javax.swing.JLabel();
        pnlCancelarCita2 = new javax.swing.JPanel();
        btnGuardarCambios = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Consulta");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Diagnóstico:");

        inputDiagnostico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputDiagnostico.setText("Diagnóstico del Paciente");
        inputDiagnostico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputDiagnosticoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputDiagnosticoFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tratamiento:");

        inputTratamientoCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputTratamientoCita.setText("Tratamiento del Paciente");
        inputTratamientoCita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTratamientoCitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTratamientoCitaFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Observaciones:");

        inputObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputObservaciones.setText("Observaciones");
        inputObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputObservacionesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputObservacionesFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Hora de Entrada:");

        inputHoraEntrada.setEditable(false);
        inputHoraEntrada.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        inputHoraEntrada.setForeground(new java.awt.Color(0, 0, 0));
        inputHoraEntrada.setText("Hora del Sistema");
        inputHoraEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHoraEntradaActionPerformed(evt);
            }
        });

        pnlCancelarCita1.setBackground(new java.awt.Color(255, 102, 120));

        btnFinalizarConsulta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnFinalizarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFinalizarConsulta.setText("Finalizar Consulta");
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
        btnGuardarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCambiosMouseClicked(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(pnlCancelarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(pnlCancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputObservaciones, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTratamientoCita, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputDiagnostico, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(txtSubTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(txtSubTitulo)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTratamientoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCancelarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputHoraEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHoraEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHoraEntradaActionPerformed

    /**
     * Maneja el evento de clic en el botón "Guardar Cambios". Llama al método
     * `registrarConsulta` para guardar los datos de la consulta.
     *
     * @param evt El evento del mouse.
     */
    private void btnGuardarCambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCambiosMouseClicked
        try {
            // TODO add your handling code here:
            registrarConsulta();
            btnGuardarCambios.setVisible(false);
            pnlCancelarCita2.setVisible(false);
        } catch (NegocioException ex) {
            Logger.getLogger(pantallaDatosConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pantallaDatosConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaDatosConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarCambiosMouseClicked

    /**
     * Maneja el evento de clic en el botón "Finalizar Consulta". Regresa al
     * menú principal y limpia los campos.
     *
     * @param evt El evento del mouse.
     */
    private void btnFinalizarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarConsultaMouseClicked
        // TODO add your handling code here:
        framePrincipal.cambiarPanel("pantallaMedicosMenu");
        btnGuardarCambios.setVisible(true);
        pnlCancelarCita2.setVisible(true);
        limpiarCampos();
    }//GEN-LAST:event_btnFinalizarConsultaMouseClicked

    /**
     * Maneja el evento "focus gained" (obtener el foco) en el campo de
     * diagnóstico. Si el texto actual es el marcador de posición, lo borra.
     *
     * @param evt El evento FocusEvent.
     */
    private void inputDiagnosticoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputDiagnosticoFocusGained
        if (inputDiagnostico.getText().equals("Diagnóstico del Paciente")) {
            inputDiagnostico.setText("");
        }
    }//GEN-LAST:event_inputDiagnosticoFocusGained

    /**
     * Maneja el evento "focus lost" (perder el foco) en el campo de
     * diagnóstico. Si el campo está vacío, restablece el texto de marcador de
     * posición.
     *
     * @param evt El evento FocusEvent.
     */
    private void inputDiagnosticoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputDiagnosticoFocusLost
        if (inputDiagnostico.getText().trim().isEmpty()) {
            inputDiagnostico.setText("Diagnóstico del Paciente");
        }
    }//GEN-LAST:event_inputDiagnosticoFocusLost

    /**
     * Maneja el evento "focus gained" (obtener el foco) en el campo de
     * tratamiento. Si el texto actual es el marcador de posición, lo borra.
     *
     * @param evt El evento FocusEvent.
     */
    private void inputTratamientoCitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTratamientoCitaFocusGained
        if (inputTratamientoCita.getText().equals("Tratamiento del Paciente")) {
            inputTratamientoCita.setText("");
        }
    }//GEN-LAST:event_inputTratamientoCitaFocusGained

    /**
     * Maneja el evento "focus lost" (perder el foco) en el campo de
     * tratamiento. Si el campo está vacío, restablece el texto de marcador de
     * posición.
     *
     * @param evt El evento FocusEvent.
     */
    private void inputTratamientoCitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTratamientoCitaFocusLost
        if (inputTratamientoCita.getText().trim().isEmpty()) {
            inputTratamientoCita.setText("Tratamiento del Paciente");
        }
    }//GEN-LAST:event_inputTratamientoCitaFocusLost

    /**
     * Maneja el evento "focus gained" (obtener el foco) en el campo de
     * observaciones. Si el texto actual es el marcador de posición, lo borra.
     *
     * @param evt El evento FocusEvent.
     */
    private void inputObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputObservacionesFocusGained
        if (inputObservaciones.getText().equals("Observaciones")) {
            inputObservaciones.setText("");
        }
    }//GEN-LAST:event_inputObservacionesFocusGained

    /**
     * Maneja el evento "focus lost" (perder el foco) en el campo de
     * observaciones. Si el campo está vacío, restablece el texto de marcador de
     * posición.
     *
     * @param evt El evento FocusEvent.
     */
    private void inputObservacionesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputObservacionesFocusLost
        if (inputObservaciones.getText().trim().isEmpty()) {
            inputObservaciones.setText("Observaciones");
        }
    }//GEN-LAST:event_inputObservacionesFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFinalizarConsulta;
    private javax.swing.JLabel btnGuardarCambios;
    private javax.swing.JTextField inputDiagnostico;
    private javax.swing.JTextField inputHoraEntrada;
    private javax.swing.JTextField inputObservaciones;
    private javax.swing.JTextField inputTratamientoCita;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlCancelarCita1;
    private javax.swing.JPanel pnlCancelarCita2;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga la hora actual del sistema en el campo correspondiente.
     */
    public void cargarHoraEntrada() {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        String horaFormateada = horaActual.format(formato);
        inputHoraEntrada.setText(horaFormateada);
    }

    /**
     * Registra la consulta en la base de datos.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     * @throws SQLException Si ocurre un error en la base de datos.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    public void registrarConsulta() throws NegocioException, SQLException, PersistenciaException {

        try {
            String diagnostico = inputDiagnostico.getText();
            String tratamiento = inputTratamientoCita.getText();
            String observaciones = inputObservaciones.getText();
            if (inputDiagnostico.getText().trim().isEmpty()
                    || inputTratamientoCita.getText().trim().isEmpty()
                    || inputObservaciones.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            LocalDateTime fechaHora = LocalDateTime.now();
            CitaNuevoDTO citaFinal = framePrincipal.getCitaFinal();
            Paciente paciente = citaFinal.getPaciente();

            Cita cita = citaBO.consultarCitaPorFechaYPaciente(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), citaFinal.getFechaHora());

            if (cita == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la cita con el folio proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idCita = cita.getIdCita();

            ConsultaNuevaDTO consulta = new ConsultaNuevaDTO(cita, "Atendida", diagnostico, tratamiento, observaciones, fechaHora);

            if (consultaBO.agregarConsulta(consulta, cita)) {

                JOptionPane.showMessageDialog(this, "Consultada guardada correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar consulta");
            }
        } catch (NegocioException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuración
        }
    }

    /**
     * Limpia los campos de entrada de la pantalla.
     */
    public void limpiarCampos() {
        inputDiagnostico.setText("Diagnostico del paciente");
        inputTratamientoCita.setText("Tratamiento del paciente");
        inputObservaciones.setText("Observaciones");
    }

}
