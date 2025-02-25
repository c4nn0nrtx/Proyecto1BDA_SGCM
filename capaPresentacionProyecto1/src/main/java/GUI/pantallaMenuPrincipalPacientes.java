package GUI;

import BO.CitaBO;
import BO.UsuarioBO;
import DTO.CitaNuevoDTO;
import Entidades.Cita;
import Exception.NegocioException;
import Exception.PersistenciaException;
import configuracion.DependencyInjector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pantalla del menú principal para pacientes. Permite a los pacientes acceder a
 * las funcionalidades de la aplicación, como agendar citas, cancelar citas,
 * solicitar consultas de emergencia, ver sus consultas y acceder a su perfil.
 *
 * @author Sebastian Moreno
 */
public class pantallaMenuPrincipalPacientes extends javax.swing.JPanel {

    private FramePrincipal framePrincipal;
    private CitaBO citaBO = DependencyInjector.crearCitaBO();

    /**
     * Constructor de la pantalla. Inicializa los componentes y establece el
     * FramePrincipal.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaMenuPrincipalPacientes(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtSubTitulo = new javax.swing.JLabel();
        txtTituloEmergencia = new javax.swing.JLabel();
        pnlCancelarCita = new javax.swing.JPanel();
        btnCancelarCita = new javax.swing.JLabel();
        pnlAgendarCita = new javax.swing.JPanel();
        btnAgendarCita = new javax.swing.JLabel();
        pnlCerrarSesion = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JLabel();
        btnRegistros = new javax.swing.JLabel();
        btnEmergencia = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("MENU PRINCIPAL");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        txtTituloEmergencia.setFont(new java.awt.Font("Roboto", 1, 44)); // NOI18N
        txtTituloEmergencia.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloEmergencia.setText("¿Situacion de Emergencia?");
        add(txtTituloEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        pnlCancelarCita.setBackground(new java.awt.Color(255, 102, 120));

        btnCancelarCita.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnCancelarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelarCita.setText("Cancelar Cita Programada");
        btnCancelarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarCitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCancelarCitaLayout = new javax.swing.GroupLayout(pnlCancelarCita);
        pnlCancelarCita.setLayout(pnlCancelarCitaLayout);
        pnlCancelarCitaLayout.setHorizontalGroup(
            pnlCancelarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
            .addGroup(pnlCancelarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCancelarCitaLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(btnCancelarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );
        pnlCancelarCitaLayout.setVerticalGroup(
            pnlCancelarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(pnlCancelarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCancelarCitaLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(btnCancelarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );

        add(pnlCancelarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 340, 90));

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
            .addComponent(btnAgendarCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        pnlAgendarCitaLayout.setVerticalGroup(
            pnlAgendarCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendarCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 340, 90));

        pnlCerrarSesion.setBackground(new java.awt.Color(60, 109, 232));

        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
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
            .addGap(0, 190, Short.MAX_VALUE)
            .addGroup(pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCerrarSesionLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE)))
        );
        pnlCerrarSesionLayout.setVerticalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCerrarSesionLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(pnlCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, 190, 40));

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("¡Pulsa el boton!");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });
        add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 70, 70));

        btnRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario-de-llenado.png"))); // NOI18N
        btnRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrosMouseClicked(evt);
            }
        });
        add(btnRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, -1, -1));

        btnEmergencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/llamada-de-socorro.png"))); // NOI18N
        btnEmergencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmergencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmergenciaMouseClicked(evt);
            }
        });
        add(btnEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        txtTitulo.setFont(new java.awt.Font("Roboto", 1, 44)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtTitulo.setText("Usuarios");
        add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        lblNombre1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(0, 204, 51));
        lblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre1.setText("TEXTOPRUEBA");
        lblNombre1.setToolTipText("");
        add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1000, -1));

        lblNombre2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre2.setText("Bienvenido");
        add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Mis Consultas". Navega a la
     * pantalla de consultas del paciente y carga sus consultas.
     *
     * @param evt El evento del mouse.
     */
    private void btnRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosMouseClicked
        framePrincipal.cambiarPanel("pantallaTusConsultas");
        pantallaTusConsultas consultas = framePrincipal.getPantallaTusConsultas();
        try {
            consultas.misConsultas();
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrosMouseClicked

    /**
     * Maneja el evento de clic en el botón "Perfil". Navega a la pantalla de
     * información del usuario y carga los datos del paciente.
     *
     * @param evt El evento del mouse.
     */
    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        pantallaInformacionUsuario informacionUsuario = framePrincipal.getPantallaInformacion();

        if (informacionUsuario != null) {
            try {
                // Verifica que la pantalla no sea null
                informacionUsuario.cargarPaciente();
            } catch (PersistenciaException ex) {
                Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            framePrincipal.cambiarPanel("pantallaInformacionUsuarios"); // Cambia de pantalla
        } else {
            System.err.println("Error: pantallaInformacionUsuarios es null.");
        }

    }//GEN-LAST:event_btnPerfilMouseClicked
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
     * Maneja el evento de clic en el botón "Agendar una Cita". Verifica si el
     * usuario tiene una cita activa. Si no, navega a la pantalla para agendar
     * citas y carga las citas disponibles. Si ya tiene una cita, muestra un
     * mensaje informativo.
     *
     * @param evt El evento del mouse.
     */
    private void btnAgendarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCitaMouseClicked

        try {
            String cita = citaBO.obtenerUltimaCita(framePrincipal.getUsuarioAutenticado().getIdUsuario());

            if (cita == null) { // Si no hay cita, cambiar de panel
                framePrincipal.cambiarPanel("pantallaAgendarCita");
                pantallaAgendarCita agendarCita = framePrincipal.getPantallaAgendarCita();

                try {
                    agendarCita.cargarCitas();
                } catch (NegocioException | SQLException | PersistenciaException ex) {
                    Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tienes una cita activa:\n" + cita, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAgendarCitaMouseClicked

    /**
     * Maneja el evento de clic en el botón "Cancelar Cita Programada". Cancela
     * la cita del paciente previa confirmación.
     *
     * @param evt El evento del mouse.
     */
    private void btnCancelarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarCitaMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cancelar la cita: ", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario cancelo la cita.");
            cancelarCita();
        } else {
            System.out.println("El usuario no cancelo la cita.");
        }
    }//GEN-LAST:event_btnCancelarCitaMouseClicked

    /**
     * Maneja el evento de clic en el botón "Emergencia". Solicita una consulta
     * de emergencia previa confirmación.
     *
     * @param evt El evento del mouse.
     */
    private void btnEmergenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmergenciaMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de realizar una consulta de EMERGENCIA?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario seleccionó Sí.");
            try {
                // Obtener la última cita del usuario autenticado
                String cita = citaBO.obtenerUltimaCitaEmergencia(framePrincipal.getUsuarioAutenticado().getIdUsuario());
                if (cita != null) {
                    // Si ya tiene una cita activa, mostrar un mensaje y detener el proceso
                    JOptionPane.showMessageDialog(null, "Ya tienes una cita activa:\n" + cita, "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // Si no tiene cita, proceder con la emergencia
                pantallaAgendarCita pantalla = framePrincipal.getPantallaAgendarCita();
                boolean exito = pantalla.agendarCitaEmergenciaBO();
                if (exito) {
                    framePrincipal.cambiarPanel("pantallaInformacionCitaEmergencia");
                    pantallaInformacionCitaEmergencia pantallaEmergencia = framePrincipal.getPantallaInformacionCitaEmergencia();
                    pantallaEmergencia.cargarDatosCita();
                } else {

                }

            } catch (PersistenciaException ex) {
                Logger.getLogger(pantallaMenuPrincipalPacientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al verificar la última cita.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("El usuario seleccionó No.");
        }
    }//GEN-LAST:event_btnEmergenciaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgendarCita;
    private javax.swing.JLabel btnCancelarCita;
    private javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JLabel btnEmergencia;
    private javax.swing.JLabel btnPerfil;
    private javax.swing.JLabel btnRegistros;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JPanel pnlAgendarCita;
    private javax.swing.JPanel pnlCancelarCita;
    private javax.swing.JPanel pnlCerrarSesion;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtTituloEmergencia;
    // End of variables declaration//GEN-END:variables
// FALTA ALGUN METODO PARA VALIDAR SI UN USUARIO TIENE CITAS ACTIVAS.

    /**
     * Cancela la cita del paciente.
     */
    public void cancelarCita() {
        int idPaciente = framePrincipal.getUsuarioAutenticado().getIdUsuario();

        try {
            Cita cita = citaBO.cancelarCita(idPaciente);

            if (cita == null) {
                JOptionPane.showMessageDialog(this, "Cita cancelada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No puedes cancelar la cita porque han pasado más de 24 horas desde su creación.",
                        "Información", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al cancelar la cita: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Carga y muestra el nombre del usuario en el JLabel lblNombre1.
     */
    public void cargarNombre() {

        lblNombre1.setText(""); // Borra el texto anterior (opcional)
        lblNombre1.setText(framePrincipal.getUsuarioAutenticado().getNombreUsuario() + "!");
        lblNombre1.revalidate(); // Vuelve a validar el componente
        lblNombre1.repaint(); // Fuerza el repintado en pantalla
    }
}
