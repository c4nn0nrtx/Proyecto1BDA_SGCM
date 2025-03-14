package GUI;

import BO.CitaBO;
import BO.Direccion_PacienteBO;
import BO.MedicoBO;
import BO.PacienteBO;
import BO.UsuarioBO;
import DTO.MedicoNuevoDTO;
import Entidades.Usuario;
import Exception.NegocioException;
import Exception.PersistenciaException;
import configuracion.DependencyInjector;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pantalla del menú principal para médicos. Permite a los médicos acceder a las
 * funcionalidades de la aplicación, como consultar el historial de pacientes,
 * agendar citas, cambiar su estado (activo/inactivo) y cerrar sesión.
 *
 * @author Sebastian Moreno
 */
public class pantallaMedicosMenu extends javax.swing.JPanel {

    /**
     * Creates new form pantallaMedicosMenu
     */
    private UsuarioBO usuarioBO = DependencyInjector.crearUsuarioBO();
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private Direccion_PacienteBO direccionBO = DependencyInjector.crearDireccionBO();
    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private FramePrincipal framePrincipal;

    /**
     * Constructor de la pantalla. Inicializa los componentes y establece el
     * FramePrincipal.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaMedicosMenu(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();
        txtActivo.setVisible(false);
        txtInactivo.setVisible(false);

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
        pnlConsultarHistorialPaciente = new javax.swing.JPanel();
        btnConsultarHistorialPaciente = new javax.swing.JLabel();
        pnlAgendarCita = new javax.swing.JPanel();
        btnAgendarCita = new javax.swing.JLabel();
        pnlActivo = new javax.swing.JPanel();
        btnEstadoActivo = new javax.swing.JLabel();
        pnlInactivo = new javax.swing.JPanel();
        btnEstadoInactivo = new javax.swing.JLabel();
        pnlCerrarSesion = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        txtActivo = new javax.swing.JLabel();
        txtInactivo = new javax.swing.JLabel();
        txtStatusinicial = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Menú Principal");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 40, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MEDICOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 103, -1, -1));

        pnlConsultarHistorialPaciente.setBackground(new java.awt.Color(60, 109, 232));

        btnConsultarHistorialPaciente.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnConsultarHistorialPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarHistorialPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultarHistorialPaciente.setText("Consultar Historial Paciente");
        btnConsultarHistorialPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarHistorialPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarHistorialPacienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultarHistorialPacienteLayout = new javax.swing.GroupLayout(pnlConsultarHistorialPaciente);
        pnlConsultarHistorialPaciente.setLayout(pnlConsultarHistorialPacienteLayout);
        pnlConsultarHistorialPacienteLayout.setHorizontalGroup(
            pnlConsultarHistorialPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultarHistorialPacienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultarHistorialPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlConsultarHistorialPacienteLayout.setVerticalGroup(
            pnlConsultarHistorialPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarHistorialPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsultarHistorialPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlConsultarHistorialPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 193, 390, 80));

        pnlAgendarCita.setBackground(new java.awt.Color(255, 0, 0));

        btnAgendarCita.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita.setText("Consultar Agenda");
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
            .addGroup(pnlAgendarCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAgendarCitaLayout.setVerticalGroup(
            pnlAgendarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendarCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 193, 380, 80));

        pnlActivo.setBackground(new java.awt.Color(0, 204, 0));

        btnEstadoActivo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnEstadoActivo.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadoActivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEstadoActivo.setText("Médico Activo");
        btnEstadoActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadoActivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadoActivoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlActivoLayout = new javax.swing.GroupLayout(pnlActivo);
        pnlActivo.setLayout(pnlActivoLayout);
        pnlActivoLayout.setHorizontalGroup(
            pnlActivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEstadoActivo, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlActivoLayout.setVerticalGroup(
            pnlActivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEstadoActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnlActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 330, -1));

        pnlInactivo.setBackground(new java.awt.Color(255, 51, 51));

        btnEstadoInactivo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnEstadoInactivo.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadoInactivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEstadoInactivo.setText("Médico Inactivo");
        btnEstadoInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadoInactivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadoInactivoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlInactivoLayout = new javax.swing.GroupLayout(pnlInactivo);
        pnlInactivo.setLayout(pnlInactivoLayout);
        pnlInactivoLayout.setHorizontalGroup(
            pnlInactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(pnlInactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInactivoLayout.createSequentialGroup()
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addComponent(btnEstadoInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlInactivoLayout.setVerticalGroup(
            pnlInactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(pnlInactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInactivoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstadoInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(pnlInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 330, -1));

        pnlCerrarSesion.setBackground(new java.awt.Color(255, 51, 51));

        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCerrarSesionLayout = new javax.swing.GroupLayout(pnlCerrarSesion);
        pnlCerrarSesion.setLayout(pnlCerrarSesionLayout);
        pnlCerrarSesionLayout.setHorizontalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCerrarSesionLayout.setVerticalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCerrarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 467, -1, -1));

        txtStatus.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(0, 0, 0));
        txtStatus.setText("Status:");
        add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, -1, -1));

        txtActivo.setForeground(new java.awt.Color(51, 153, 0));
        txtActivo.setText("ACTIVO");
        add(txtActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 80, -1));

        txtInactivo.setForeground(new java.awt.Color(255, 0, 0));
        txtInactivo.setText("INACTIVO");
        add(txtInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 129, 70, -1));

        txtStatusinicial.setText("jLabel2");
        add(txtStatusinicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Cerrar Sesión". Navega a la
     * pantalla de inicio de sesión.
     *
     * @param evt El evento del mouse.
     */
    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        framePrincipal.cambiarPanel("pantallaInicioSesion");
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    /**
     * Maneja el evento de clic en el botón "Médico Inactivo". Actualiza el
     * estado del médico a inactivo previa confirmación.
     *
     * @param evt El evento del mouse.
     */
    private void btnEstadoInactivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoInactivoMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de actualizar tu estado a inactivo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario seleccionó Sí.");
            try {
                actualizarEstadoMedicoInactivo();
            } catch (NegocioException ex) {
                Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PersistenciaException ex) {
                Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El usuario seleccionó No.");
        }
    }//GEN-LAST:event_btnEstadoInactivoMouseClicked

    /**
     * Maneja el evento de clic en el botón "Médico Activo". Actualiza el estado
     * del médico a activo previa confirmación.
     *
     * @param evt El evento del mouse.
     */
    private void btnEstadoActivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoActivoMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de actualizar tu estado a activo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario seleccionó Sí.");
            try {
                actualizarEstadoMedicoActivo();
            } catch (NegocioException ex) {
                Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PersistenciaException ex) {
                Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El usuario seleccionó No.");
        }
    }//GEN-LAST:event_btnEstadoActivoMouseClicked

    /**
     * Maneja el evento de clic en el botón "Consultar Agenda". Navega a la
     * pantalla de citas pendientes y carga las citas programadas y de
     * emergencia.
     *
     * @param evt El evento del mouse.
     */
    private void btnAgendarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCitaMouseClicked
        framePrincipal.cambiarPanel("pantallaCitasPendientes");
        pantallaCitasPendientes citas = framePrincipal.getPantallaCitasPendientes();
        try {
            actualizarCitas();
        } catch (SQLException ex) {
            Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaMedicosMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        citas.consultarCitasProgramadas();
        citas.consultarCitasEmergencia();
    }//GEN-LAST:event_btnAgendarCitaMouseClicked

    /**
     * Maneja el evento de clic en el botón "Consultar Historial Paciente".
     * Navega a la pantalla de consultas de pacientes.
     *
     * @param evt El evento del mouse.
     */
    private void btnConsultarHistorialPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarHistorialPacienteMouseClicked
        framePrincipal.cambiarPanel("pantallaConsultasPacientes");
    }//GEN-LAST:event_btnConsultarHistorialPacienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgendarCita;
    private javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JLabel btnConsultarHistorialPaciente;
    private javax.swing.JLabel btnEstadoActivo;
    private javax.swing.JLabel btnEstadoInactivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlActivo;
    private javax.swing.JPanel pnlAgendarCita;
    private javax.swing.JPanel pnlCerrarSesion;
    private javax.swing.JPanel pnlConsultarHistorialPaciente;
    private javax.swing.JPanel pnlInactivo;
    private javax.swing.JLabel txtActivo;
    private javax.swing.JLabel txtInactivo;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtStatusinicial;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables

    /**
     * Actualiza el estado del médico a inactivo en la base de datos.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    public void actualizarEstadoMedicoInactivo() throws NegocioException, SQLException, PersistenciaException {
        Usuario usuarioAutenticado = framePrincipal.getUsuarioAutenticado();

        MedicoNuevoDTO medicoDTO = medicoBO.consultarMedico(usuarioAutenticado);
        medicoBO.actualizarMedico(medicoDTO, "Inactivo");
        txtInactivo.setVisible(true);
        txtActivo.setVisible(false);
        txtStatusinicial.setVisible(false);
    }

    /**
     * Actualiza el estado del médico a activo en la base de datos.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    public void actualizarEstadoMedicoActivo() throws NegocioException, SQLException, PersistenciaException {
        Usuario usuarioAutenticado = framePrincipal.getUsuarioAutenticado();

        MedicoNuevoDTO medicoDTO = medicoBO.consultarMedico(usuarioAutenticado);
        medicoBO.actualizarMedico(medicoDTO, "Activo");
        txtInactivo.setVisible(false);
        txtActivo.setVisible(true);
        txtStatusinicial.setVisible(false);

    }

    /**
     * Consulta y muestra el estado actual del médico.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    public void consultarStatus() throws NegocioException, SQLException, PersistenciaException {
        Usuario usuarioAutenticado = framePrincipal.getUsuarioAutenticado();

        MedicoNuevoDTO medicoDTO = medicoBO.consultarMedico(usuarioAutenticado);

        String status = medicoDTO.getEstado();

        if (status.equals("Activo")) {
            txtStatusinicial.setForeground(Color.green);
            txtStatusinicial.setText(status);

        } else if (status.equals("Inactivo")) {
            txtStatusinicial.setForeground(Color.red);
            txtStatusinicial.setText(status);

        }

    }

    /**
     * Actualiza las citas en la base de datos.
     *
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    public void actualizarCitas() throws SQLException, PersistenciaException {
        citaBO.actualizarCita();
    }

}
