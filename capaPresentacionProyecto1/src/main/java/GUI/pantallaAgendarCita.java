/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BO.CitaBO;
import BO.HorarioMedicoBO;
import BO.MedicoBO;
import BO.PacienteBO;
import DTO.CitaNuevoDTO;
import DTO.HorarioMedicoNuevoDTO;
import DTO.MedicoNuevoDTO;
import DTO.PacienteNuevoDTO;
import Entidades.Cita;
import Entidades.Horario;
import Entidades.Medico;
import Entidades.Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import configuracion.DependencyInjector;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaAgendarCita extends javax.swing.JPanel {

    private HorarioMedicoBO horarioMedicoBO = DependencyInjector.crearHorarioMedicoBO();
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private Object[][] horarioMedicoAlmacenado;
    private Medico medico = new Medico();
    private Horario horario = new Horario();

    Mapper mapper = new Mapper();

    /**
     * Creates new form pantallaAgendarCita1
     */
    FramePrincipal framePrincipal;

    public pantallaAgendarCita(FramePrincipal frame) throws NegocioException, SQLException {

        this.framePrincipal = frame;
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
        pnlAgendarCita = new javax.swing.JPanel();
        btnAgendarCita = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitasDisponibles = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Agendar Cita");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Horarios Disponibles:");

        pnlAgendarCita.setBackground(new java.awt.Color(60, 109, 232));

        btnAgendarCita.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita.setText("Agendar una Cita");
        btnAgendarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgendarCitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAgendarCitaLayout = new javax.swing.GroupLayout(pnlAgendarCita);
        pnlAgendarCita.setLayout(pnlAgendarCitaLayout);
        pnlAgendarCitaLayout.setHorizontalGroup(
            pnlAgendarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendarCitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAgendarCitaLayout.setVerticalGroup(
            pnlAgendarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendarCitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblCitasDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        tblCitasDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Doctor", "Especialidad", "Horario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCitasDisponibles.setRowHeight(40);
        jScrollPane1.setViewportView(tblCitasDisponibles);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 135, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtSubTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        framePrincipal.cambiarPanel("pantallaPacientes");
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnAgendarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCitaMouseClicked
        agendarCitaDesdeTabla();
        framePrincipal.cambiarPanel("pantallaInformacionCita");
        pantallaInformacionCita agendarCitas = framePrincipal.getPantallaInformacionCitas();
        agendarCitas.cargarDatosCita();

    }//GEN-LAST:event_btnAgendarCitaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgendarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAgendarCita;
    private javax.swing.JTable tblCitasDisponibles;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables
    /**
     * Metodo que carga las citas cuando se introduce a la pantalla.
     * Las setea dentro de la tabla una vez consultadas con el BO.
     * @throws NegocioException
     * @throws SQLException
     * @throws PersistenciaException 
     */
    public void cargarCitas() throws NegocioException, SQLException, PersistenciaException {
        try {
            // Obtener la lista de horarios de los médicos
            List<Medico> listadoMedicos = medicoBO.obtenerMedicosConHorario();

            // Convertir DayOfWeek a String en español (o el formato que uses en la BD)
            String diaSemana = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

            // Obtener la fecha actual en formato "YYYY-MM-DD"
            String fecha = LocalDate.now().toString();

            String[] columnas = {"DOCTOR", "ESPECIALIDAD", "HORARIO"};
            List<String[]> listaDatos = new ArrayList<>();

            // Iterar sobre los horarios médicos para obtener sus citas disponibles
            for (Medico listaMedicos : listadoMedicos) {
                int idMedico = listaMedicos.getUsuario().getIdUsuario();

                // Obtener las citas disponibles para ese médico
                List<CitaNuevoDTO> citasDisponibles = citaBO.cargarCitas(idMedico, diaSemana, fecha);

                // Si hay citas disponibles, agregarlas a la tabla
                for (CitaNuevoDTO cita : citasDisponibles) {
                    Medico medico = cita.getMedico(); // Obtener el médico de la cita

                    listaDatos.add(new String[]{
                        "Dr. " + medico.getNombre() + " " + medico.getApellidoPaterno() + " " + medico.getApellidoMaterno(), // Nombre del doctor
                        medico.getEspecialidad(), // Especialidad del médico
                        cita.getFechaHora().toLocalTime().toString() // Horario de la cita (Solo la hora)
                    });
                }
            }

            // Convertir la lista a un array para la tabla
            String[][] datos = listaDatos.toArray(new String[0][]);

            // Configurar la tabla con los datos obtenidos
            tblCitasDisponibles.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
            jScrollPane1.setViewportView(tblCitasDisponibles);
            jScrollPane1.revalidate();
            jScrollPane1.repaint();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar las citas: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * Metodo que agenda una cita desde la tabla.
     * Obtiene las filas seleccionadas y convierte esos datos a objetos
     * Para posteriormente agendar una cita usando el BO con los objetos creados.
     */
    private void agendarCitaDesdeTabla() {
        int filaSeleccionada = tblCitasDisponibles.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Obtener datos de la fila seleccionada
            String nombreMedico = tblCitasDisponibles.getValueAt(filaSeleccionada, 0).toString();
            String especialidad = tblCitasDisponibles.getValueAt(filaSeleccionada, 1).toString();
            String hora = tblCitasDisponibles.getValueAt(filaSeleccionada, 2).toString();
            System.out.println(nombreMedico);

            // Buscar en la BD o crear el objeto MedicoNuevoDTO    // mejor manera de encontrar algun medico???
            MedicoNuevoDTO medico = medicoBO.obtenerMedicoPorNombre(nombreMedico.replace("Dr. ", "").trim());
            Medico medicoEntity = mapper.DTOMedicoToEntity(medico);
            if (medico == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el médico seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener paciente (puede ser el paciente logueado o seleccionado de una lista)
            int id = framePrincipal.getUsuarioAutenticado().getIdUsuario(); // paciente
            Paciente paciente = pacienteBO.buscarPacientePorID(id);
            PacienteNuevoDTO pacienteNuevo = mapper.PacienteToNuevoDTO(paciente);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // Convertir la hora (String) a LocalTime
            LocalTime horaCita = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));

            // Combinar la fecha actual con la hora de la cita
            LocalDateTime fechaHora = LocalDateTime.of(fechaActual, horaCita);

            // Asignar la fecha y hora a la cita
            CitaNuevoDTO nuevaCita = new CitaNuevoDTO();
            nuevaCita.setFechaHora(fechaHora);
            nuevaCita.setMedico(medicoEntity);
            nuevaCita.setPaciente(paciente);
            framePrincipal.setCitaFinal(nuevaCita);
            System.out.println(nuevaCita + "LOOOOOOOOOOOOOL");
            // Intentar agendar la cita
            boolean citaAgendada = citaBO.agendarCita(nuevaCita, pacienteNuevo, medico);
            if (citaAgendada) {
                JOptionPane.showMessageDialog(this, "Cita agendada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agendar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar la cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
