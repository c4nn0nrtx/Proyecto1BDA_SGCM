package GUI;

import BO.UsuarioBO;
import DTO.UsuarioNuevoDTO;
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
 * Pantalla Inicio de Sesión.
 *
 * @author Sebastian Moreno
 */
public class pantallaInicioSesion extends javax.swing.JPanel {

    private UsuarioBO usuarioBO = DependencyInjector.crearUsuarioBO();
    /**
     * Creates new form pantallaInicioSesion
     */
    private FramePrincipal framePrincipal;
    public Usuario usuarioGlobal;

    public pantallaInicioSesion(FramePrincipal frame) {
        this.framePrincipal = frame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        txtTituloPantalla = new javax.swing.JLabel();
        txtSubTitulo = new javax.swing.JLabel();
        inputUsuario = new java.awt.TextField();
        txtUsuario = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JLabel();
        pnlBotonInicioSesion = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JLabel();
        pnlBotonRegistrate = new javax.swing.JPanel();
        btnRegistrate = new javax.swing.JLabel();
        inputContraseña = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        txtTituloPantalla.setFont(new java.awt.Font("Roboto", 1, 44)); // NOI18N
        txtTituloPantalla.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloPantalla.setText("Iniciar Sesión");

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("CLINICA SALUDABLE");

        inputUsuario.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        inputUsuario.setText("Introduce tu nombre de usuario");
        inputUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputUsuarioMouseClicked(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 26)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setText("Usuario :");

        txtContraseña.setFont(new java.awt.Font("Roboto", 0, 26)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
        txtContraseña.setText("Contraseña:");

        pnlBotonInicioSesion.setBackground(new java.awt.Color(0, 0, 0));
        pnlBotonInicioSesion.setForeground(new java.awt.Color(0, 0, 0));
        pnlBotonInicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBotonInicioSesionMouseEntered(evt);
            }
        });

        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonInicioSesionLayout = new javax.swing.GroupLayout(pnlBotonInicioSesion);
        pnlBotonInicioSesion.setLayout(pnlBotonInicioSesionLayout);
        pnlBotonInicioSesionLayout.setHorizontalGroup(
            pnlBotonInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );
        pnlBotonInicioSesionLayout.setVerticalGroup(
            pnlBotonInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlBotonRegistrate.setBackground(new java.awt.Color(0, 0, 0));
        pnlBotonRegistrate.setForeground(new java.awt.Color(0, 0, 0));

        btnRegistrate.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrate.setText("Registrate");
        btnRegistrate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonRegistrateLayout = new javax.swing.GroupLayout(pnlBotonRegistrate);
        pnlBotonRegistrate.setLayout(pnlBotonRegistrateLayout);
        pnlBotonRegistrateLayout.setHorizontalGroup(
            pnlBotonRegistrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrate, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        pnlBotonRegistrateLayout.setVerticalGroup(
            pnlBotonRegistrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        inputContraseña.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        inputContraseña.setText("inputContraseña");
        inputContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputContraseñaMouseClicked(evt);
            }
        });
        inputContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputContraseñaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlBotonInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(pnlBotonRegistrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTituloPantalla)
                    .addComponent(txtContraseña)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inputContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)))
                .addContainerGap(877, Short.MAX_VALUE))
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(txtSubTitulo)
                    .addContainerGap(926, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(txtTituloPantalla)
                .addGap(57, 57, 57)
                .addComponent(txtUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(txtContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBotonRegistrate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotonInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(txtSubTitulo)
                    .addContainerGap(713, Short.MAX_VALUE)))
        );

        add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseClicked
        framePrincipal.cambiarPanel("pantallaRegistro");
    }//GEN-LAST:event_btnRegistrateMouseClicked

    private void inputUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputUsuarioMouseClicked
        inputUsuario.setText("");
    }//GEN-LAST:event_inputUsuarioMouseClicked

    private void inputContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputContraseñaMouseClicked
        inputContraseña.setText("");
    }//GEN-LAST:event_inputContraseñaMouseClicked

    private void inputContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputContraseñaKeyPressed
                                                  
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        try {
            autenticarUsuario(); // Ahora este método se encarga de todo
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(pantallaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_inputContraseñaKeyPressed

    private void pnlBotonInicioSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonInicioSesionMouseEntered

    }//GEN-LAST:event_pnlBotonInicioSesionMouseEntered

    private void btnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseEntered
        pnlBotonInicioSesion.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnIniciarSesionMouseEntered

    private void btnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseExited
        pnlBotonInicioSesion.setBackground(Color.black);
    }//GEN-LAST:event_btnIniciarSesionMouseExited

    private void btnRegistrateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseEntered
        pnlBotonRegistrate.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnRegistrateMouseEntered

    private void btnRegistrateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseExited
        pnlBotonRegistrate.setBackground(Color.black);
    }//GEN-LAST:event_btnRegistrateMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnIniciarSesion;
    private javax.swing.JLabel btnRegistrate;
    private javax.swing.JPasswordField inputContraseña;
    private java.awt.TextField inputUsuario;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel pnlBotonInicioSesion;
    private javax.swing.JPanel pnlBotonRegistrate;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtTituloPantalla;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

    //METODOS APOYO PARA INICIO DE SESION//
    public void autenticarUsuario() throws PersistenciaException, SQLException {
        try {
            String nombreUsuario = inputUsuario.getText();
            char[] listadoContraseña = inputContraseña.getPassword();
            String contraseña = new String(listadoContraseña);

            UsuarioNuevoDTO usuario = new UsuarioNuevoDTO(nombreUsuario, contraseña);
            Usuario usuarioGuardado = usuarioBO.autenticarUsuario(usuario);

            if (usuarioGuardado != null) {
                framePrincipal.setUsuarioAutenticado(usuarioGuardado);

                if (usuarioBO.esMedico(usuarioGuardado.getIdUsuario())) {
                    JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso!");

                    pantallaMedicosMenu pantallaMedicos = framePrincipal.getPantallaMedicosMenu();
                    if (pantallaMedicos != null) {
                        pantallaMedicos.consultarStatus(); // Solo si es médico
                        framePrincipal.cambiarPanel("pantallaMedicosMenu");
                    } else {
                        System.err.println("⚠ Error: pantallaMedicosMenu es null.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso!");
                    framePrincipal.cambiarPanel("pantallaPacientes"); // Si no es médico
                }

            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
            }

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}
