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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Clase que representa la interfaz gráfica para agendar una cita médica.
 * Permite seleccionar una fecha, mostrar los horarios disponibles y confirmar
 * la cita con un médico.
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
    private String fecha;
    private String diaSemana;

    Mapper mapper = new Mapper();

    /**
     * Referencia al frame principal de la aplicación.
     */
    FramePrincipal framePrincipal;

    /**
     * Constructor de la pantalla de agendamiento de citas.
     *
     * @param frame Referencia al frame principal.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public pantallaAgendarCita(FramePrincipal frame) throws NegocioException, SQLException {

        this.framePrincipal = frame;
        initComponents();
        selectorFechas.setMinSelectableDate(new Date());
        LocalDate maxDate = LocalDate.now().plusYears(1);
        selectorFechas.setMaxSelectableDate(java.sql.Date.valueOf(maxDate));

    }

    /**
     * Inicializa los componentes de la interfaz gráfica. Este método es
     * generado automáticamente por el diseñador de interfaces.
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
        pnlBuscar1 = new javax.swing.JPanel();
        btnAgendarCita2 = new javax.swing.JLabel();
        selectorFechas = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Agendar Cita");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 13, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Horarios Disponibles:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 235, -1));

        pnlAgendarCita.setBackground(new java.awt.Color(60, 109, 232));

        btnAgendarCita.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
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

        add(pnlAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, -1, -1));

        tblCitasDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        tblCitasDisponibles.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 753, 305));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, -1, -1));

        pnlBuscar1.setBackground(new java.awt.Color(60, 109, 232));
        pnlBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBuscar1MouseClicked(evt);
            }
        });

        btnAgendarCita2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita2.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita2.setText("Buscar");
        btnAgendarCita2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendarCita2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgendarCita2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscar1Layout = new javax.swing.GroupLayout(pnlBuscar1);
        pnlBuscar1.setLayout(pnlBuscar1Layout);
        pnlBuscar1Layout.setHorizontalGroup(
            pnlBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
            .addGroup(pnlBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBuscar1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAgendarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlBuscar1Layout.setVerticalGroup(
            pnlBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(pnlBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBuscar1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAgendarCita2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(pnlBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));
        add(selectorFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 100, 310, 45));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Buscar por Fecha:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 104, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que maneja el evento de clic en el botón de agendar cita.
     *
     * @param evt Evento de clic del ratón.
     */
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        framePrincipal.cambiarPanel("pantallaPacientes");
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * Método que maneja el evento de clic en el botón de buscar horarios
     * disponibles.
     *
     * @param evt Evento de clic del ratón.
     */
    private void btnAgendarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCitaMouseClicked
        boolean exito = agendarCitaDesdeTabla();
        if (exito) {
            framePrincipal.cambiarPanel("pantallaInformacionCita");
            pantallaInformacionCita agendarCitas = framePrincipal.getPantallaInformacionCitas();
            agendarCitas.cargarDatosCita();
        } else {

        }
    }//GEN-LAST:event_btnAgendarCitaMouseClicked

    /**
     * Método que maneja el evento de clic en el botón de regresar a la pantalla anterior.
     *
     * @param evt Evento de clic del ratón.
     */
    private void btnAgendarCita2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCita2MouseClicked
        try {
            cargarCitas();
        } catch (NegocioException ex) {
            Logger.getLogger(pantallaAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pantallaAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgendarCita2MouseClicked

    private void pnlBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlBuscar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgendarCita;
    private javax.swing.JLabel btnAgendarCita2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAgendarCita;
    private javax.swing.JPanel pnlBuscar1;
    private com.toedter.calendar.JDateChooser selectorFechas;
    private javax.swing.JTable tblCitasDisponibles;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables
   /**
     * Metodo que carga las citas cuando se introduce a la pantalla. Las setea
     * dentro de la tabla una vez consultadas con el BO.
     *
     * @throws NegocioException
     * @throws SQLException
     * @throws PersistenciaException
     */
    public void cargarCitas() throws NegocioException, SQLException, PersistenciaException {
        try {
            // Obtener la lista de horarios de los médicos
            List<Medico> listadoMedicos = medicoBO.obtenerMedicosConHorario();
            System.out.println(listadoMedicos);

            // Obtener la fecha seleccionada en el JDateChooser
            Date fechaSeleccionada = selectorFechas.getDate();

            if (fechaSeleccionada == null) {
                // Si no hay fecha seleccionada, usar la fecha y el día actuales
                diaSemana = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
                fecha = LocalDate.now().toString();
            } else {
                // Si hay una fecha seleccionada, convertirla a LocalDate
                LocalDate fechaElegida = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                // Obtener el día de la semana en español
                diaSemana = fechaElegida.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

                // Obtener la fecha en formato "YYYY-MM-DD"
                fecha = fechaElegida.toString();
            }

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
     * Metodo que agenda una cita desde la tabla. Obtiene las filas
     * seleccionadas y convierte esos datos a objetos Para posteriormente
     * agendar una cita usando el BO con los objetos creados.
     */
    private boolean agendarCitaDesdeTabla() {
        int filaSeleccionada = tblCitasDisponibles.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            // Obtener datos de la fila seleccionada
            String nombreMedico = tblCitasDisponibles.getValueAt(filaSeleccionada, 0).toString();
            String especialidad = tblCitasDisponibles.getValueAt(filaSeleccionada, 1).toString();
            String hora = tblCitasDisponibles.getValueAt(filaSeleccionada, 2).toString();

            // Buscar el médico en la BD
            MedicoNuevoDTO medico = medicoBO.obtenerMedicoPorNombre(nombreMedico.replace("Dr. ", "").trim());
            if (medico == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el médico seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            Medico medicoEntity = mapper.DTOMedicoToEntity(medico);

            // Obtener paciente autenticado
            int idPaciente = framePrincipal.getUsuarioAutenticado().getIdUsuario();
            Paciente paciente = pacienteBO.buscarPacientePorID(idPaciente);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            PacienteNuevoDTO pacienteNuevo = mapper.PacienteToNuevoDTO(paciente);

            // Obtener la fecha seleccionada o la actual
            Date fechaSeleccionada = selectorFechas.getDate();
            LocalDate fechaElegida = (fechaSeleccionada == null)
                    ? LocalDate.now()
                    : fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Convertir la hora de la cita a LocalTime
            LocalTime horaCita = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime fechaHora = LocalDateTime.of(fechaElegida, horaCita);

            // Crear objeto de cita
            CitaNuevoDTO nuevaCita = new CitaNuevoDTO();
            nuevaCita.setFechaHora(fechaHora);
            nuevaCita.setMedico(medicoEntity);
            nuevaCita.setPaciente(paciente);

            // Intentar agendar la cita
            boolean citaAgendada = citaBO.agendarCita(nuevaCita, pacienteNuevo, medico);
            if (citaAgendada) {
                JOptionPane.showMessageDialog(this, "Cita agendada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                framePrincipal.setCitaFinal(nuevaCita);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agendar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar la cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return false;
    }

    /**
 * Agenda una cita de emergencia para el paciente autenticado con el primer médico disponible.
 * 
 * Este método obtiene la primera cita disponible en la tabla de citas, busca al médico y 
 * al paciente en la base de datos, y luego intenta agendar la cita de emergencia con la fecha
 * seleccionada o la fecha actual. Finalmente, muestra un mensaje de éxito o error
 *
 * @return true si la cita fue agendada exitosamente, false en caso contrario.
 */
    public boolean agendarCitaEmergenciaBO() {
        try {
            // Cargar las citas disponibles
            cargarCitas();

            // Obtener la primera fila de la tabla de citas disponibles
            if (tblCitasDisponibles.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No hay citas disponibles para agendar.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Extraer datos de la primera fila
            String nombreMedico = tblCitasDisponibles.getValueAt(0, 0).toString();
            String especialidad = tblCitasDisponibles.getValueAt(0, 1).toString();
            String hora = tblCitasDisponibles.getValueAt(0, 2).toString();

            // Obtener el objeto del médico a partir del nombre
            MedicoNuevoDTO medico = medicoBO.obtenerMedicoPorNombre(nombreMedico.replace("Dr. ", "").trim());
            if (medico == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el médico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Obtener el paciente autenticado
            int idPaciente = framePrincipal.getUsuarioAutenticado().getIdUsuario();
            Paciente paciente = pacienteBO.buscarPacientePorID(idPaciente);
            PacienteNuevoDTO pacienteNuevo = mapper.PacienteToNuevoDTO(paciente);

            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Obtener la fecha seleccionada o la actual
            Date fechaSeleccionada = selectorFechas.getDate();
            LocalDate fechaElegida = (fechaSeleccionada == null)
                    ? LocalDate.now()
                    : fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Convertir la hora de la cita a LocalTime
            LocalTime horaCita = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime fechaHora = LocalDateTime.of(fechaElegida, horaCita);

            // Crear el objeto de cita
            CitaNuevoDTO nuevaCita = new CitaNuevoDTO();
            nuevaCita.setFechaHora(fechaHora);
            nuevaCita.setMedico(mapper.DTOMedicoToEntity(medico));
            nuevaCita.setPaciente(paciente);

            // Intentar agendar la cita
            Cita citaAgendada = citaBO.agendarCitaEmergencia(nuevaCita, pacienteNuevo, medico);

            nuevaCita.setFolio(citaAgendada.getFolio());
            System.out.println(nuevaCita); // logger 
            if (citaAgendada != null) {
                JOptionPane.showMessageDialog(this, "Cita de emergencia agendada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                framePrincipal.setCitaFinal(nuevaCita);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agendar la cita de emergencia.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agendar la cita de emergencia: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return false;
    }

}
