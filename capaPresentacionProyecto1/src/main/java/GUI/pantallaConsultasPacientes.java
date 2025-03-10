package GUI;

import BO.CitaBO;
import BO.ConsultaBO;
import BO.MedicoBO;
import BO.PacienteBO;
import DTO.CitaNuevoDTO;
import DTO.ConsultaNuevaDTO;
import DTO.MedicoNuevoDTO;
import Entidades.Cita;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import configuracion.DependencyInjector;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Pantalla para mostrar el historial de consultas de un paciente. Permite
 * buscar consultas por número de celular del paciente y rango de fechas.
 *
 * @author Sebastian Moreno
 */
public class pantallaConsultasPacientes extends javax.swing.JPanel {

    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private ConsultaBO consultaBO = DependencyInjector.crearConsultaBO();
    private Mapper mapper = new Mapper();
    FramePrincipal framePrincipal;

    /**
     * Constructor de la pantalla de consultas de pacientes.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaConsultasPacientes(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSubTitulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputCelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JLabel();
        btnSelecionar = new javax.swing.JButton();
        selectorFechaInicio = new com.toedter.calendar.JDateChooser();
        selectorFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSelecionar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Historial de Consultas");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 36, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Fecha Fin:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 200, -1));

        inputCelular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(inputCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, -1));

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Paciente", "Médico", "Especialidad", "Tratamiento", "Notas", "Fecha", "Estado", "Diagnostico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 970, 330));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnSelecionar.setText("Buscar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        add(btnSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 110, 30));
        add(selectorFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 210, 40));
        add(selectorFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 220, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Celular del paciente:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 226, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Fecha Inicio:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 200, -1));

        btnSelecionar1.setText("Restablecer");
        btnSelecionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionar1ActionPerformed(evt);
            }
        });
        add(btnSelecionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Volver". Regresa a la pantalla del
     * menú de médicos. Limpia los campos de búsqueda.
     *
     * @param evt El evento del mouse.
     */
    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaMedicosMenu");
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
        inputCelular.setText("");
        selectorFechaInicio.setDate(null);
        selectorFechaFin.setDate(null);

    }//GEN-LAST:event_btnVolverMouseClicked

    /**
     * Maneja el evento de clic en el botón "Buscar". Realiza la búsqueda de
     * consultas según los criterios ingresados.
     *
     * @param evt El evento del botón.
     */
    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        try {
            consultarPaciente();
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaConsultasPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(pantallaConsultasPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pantallaConsultasPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Restablecer". Limpia los campos de
     * búsqueda.
     *
     * @param evt El evento del botón.
     */
    private void btnSelecionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionar1ActionPerformed
        inputCelular.setText("");
        selectorFechaInicio.setDate(null);
        selectorFechaFin.setDate(null);
    }//GEN-LAST:event_btnSelecionar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnSelecionar1;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JTextField inputCelular;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser selectorFechaFin;
    private com.toedter.calendar.JDateChooser selectorFechaInicio;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables

    /**
     * Realiza la consulta de pacientes y muestra los resultados en la tabla.
     *
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    private void consultarPaciente() throws PersistenciaException, NegocioException, SQLException {
        try {
            Date fechaInicio = selectorFechaInicio.getDate();
            Date fechaFin = selectorFechaFin.getDate();

            LocalDateTime fechaInicioLocal = null;
            LocalDateTime fechaFinLocal = null;

            if (fechaInicio != null) {
                fechaInicioLocal = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            }
            if (fechaFin != null) {
                fechaFinLocal = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            }

            String celular = inputCelular.getText().trim();
            if (celular.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de celular.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Paciente paciente = pacienteBO.buscarPacientePorCelular(celular);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró un paciente con ese número de celular.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Cita> citasPaciente = citaBO.consultarCitasPacientes(paciente);
            if (citasPaciente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron consultas de ese paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<MedicoNuevoDTO> medicosDTO = new ArrayList<>();
            List<ConsultaNuevaDTO> consultasNuevaDTO = new ArrayList<>();

            for (Cita cita : citasPaciente) {
                Usuario usuario = cita.getMedico().getUsuario();
                MedicoNuevoDTO medico = medicoBO.consultarMedico(usuario);
                ConsultaNuevaDTO consulta = consultaBO.obtenerConsultasPaciente(cita);

                if (consulta != null) {
                    LocalDateTime fechaConsulta = consulta.getFechaHora();

                    boolean filtrarPorFecha = true;
                    if (fechaInicioLocal != null && fechaFinLocal != null) {
                        filtrarPorFecha = !fechaConsulta.isBefore(fechaInicioLocal) && !fechaConsulta.isAfter(fechaFinLocal);
                    } else if (fechaInicioLocal != null) {
                        filtrarPorFecha = !fechaConsulta.isBefore(fechaInicioLocal);
                    } else if (fechaFinLocal != null) {
                        filtrarPorFecha = !fechaConsulta.isAfter(fechaFinLocal);
                    }

                    if (filtrarPorFecha) {
                        medicosDTO.add(medico);
                        consultasNuevaDTO.add(consulta);
                    }
                }
            }

            if (consultasNuevaDTO.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron consultas en el rango de fechas especificado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String[] columnas = {"PACIENTE", "MEDICO", "ESPECIALIDAD", "DIAGNOSTICO", "TRATAMIENTO", "NOTAS", "FECHA", "ESTADO"};
            String[][] datos = new String[consultasNuevaDTO.size()][8];
            String nombrePaciente = paciente.getNombre() + " " + paciente.getApellidoPaterno();

            for (int i = 0; i < consultasNuevaDTO.size(); i++) {
                MedicoNuevoDTO medicoNuevo = medicosDTO.get(i);
                ConsultaNuevaDTO consultaNueva = consultasNuevaDTO.get(i);

                datos[i][0] = nombrePaciente;
                datos[i][1] = "Dr. " + medicoNuevo.getNombre() + " " + medicoNuevo.getApellidoPaterno();
                datos[i][2] = medicoNuevo.getEspecialidad();
                datos[i][3] = consultaNueva.getDiagnostico();
                datos[i][4] = consultaNueva.getTratamiento();
                datos[i][5] = consultaNueva.getObservaciones();
                datos[i][6] = consultaNueva.getFechaHora().toString();
                datos[i][7] = consultaNueva.getEstado();
            }

            DefaultTableModel model = new DefaultTableModel(datos, columnas);
            jTable1.setModel(model);
            jScrollPane1.setViewportView(jTable1);
            jScrollPane1.revalidate();
            jScrollPane1.repaint();

        } catch (PersistenciaException | NegocioException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar el paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
