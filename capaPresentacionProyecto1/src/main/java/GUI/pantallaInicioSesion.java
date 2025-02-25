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
 * Pantalla Inicio de Sesión. Permite al usuario ingresar sus credenciales
 * (usuario y contraseña) para iniciar sesión en la aplicación. Ofrece también
 * la opción de registrarse si aún no tiene una cuenta.
 *
 * @author Sebastian Moreno
 */
public class pantallaInicioSesion extends javax.swing.JPanel {

    private UsuarioBO usuarioBO = DependencyInjector.crearUsuarioBO();
    /**
     * Creates new form pantallaInicioSesion
     */
    private FramePrincipal framePrincipal;

    /**
     * Usuario global que se utiliza para almacenar la información del usuario
     * que ha iniciado sesión.
     */
    public Usuario usuarioGlobal;

    /**
     * Constructor de la pantalla. Inicializa los componentes y establece el
     * FramePrincipal.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
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
        inputUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputUsuarioFocusLost(evt);
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

        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
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
        inputContraseña.setText("Introduce una contraseña");
        inputContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputContraseñaFocusLost(evt);
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
                        .addComponent(inputContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                        .addComponent(inputUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        inputUsuario.getAccessibleContext().setAccessibleName("");

        add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Registrate". Navega a la pantalla
     * de registro.
     *
     * @param evt El evento del mouse.
     */
    private void btnRegistrateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseClicked
        framePrincipal.cambiarPanel("pantallaRegistro");
    }//GEN-LAST:event_btnRegistrateMouseClicked

    /**
     * Maneja el evento de tecla presionada en el campo de contraseña. Si se
     * presiona la tecla Enter, intenta autenticar al usuario.
     *
     * @param evt El evento del teclado.
     */
    private void inputContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputContraseñaKeyPressed

        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                autenticarUsuario(); // Ahora este método se encarga de todo
            } catch (PersistenciaException | SQLException ex) {
                Logger.getLogger(pantallaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_inputContraseñaKeyPressed

    /**
     * Maneja el evento de mouseEntered en el botón "Iniciar Sesión". Cambia el
     * color de fondo del botón a gris claro.
     *
     * @param evt El evento del mouse.
     */
    private void btnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseEntered
        pnlBotonInicioSesion.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnIniciarSesionMouseEntered

    /**
     * Maneja el evento de mouseExited en el botón "Iniciar Sesión". Restaura el
     * color de fondo del botón a negro.
     *
     * @param evt El evento del mouse.
     */
    private void btnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseExited
        pnlBotonInicioSesion.setBackground(Color.black);
    }//GEN-LAST:event_btnIniciarSesionMouseExited

    /**
     * Maneja el evento de mouseEntered en el botón "Registrate". Cambia el
     * color de fondo del botón a gris claro.
     *
     * @param evt El evento del mouse.
     */
    private void btnRegistrateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseEntered
        pnlBotonRegistrate.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnRegistrateMouseEntered

    /**
     * Maneja el evento de mouseExited en el botón "Registrate". Restaura el
     * color de fondo del botón a negro.
     *
     * @param evt El evento del mouse.
     */
    private void btnRegistrateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseExited
        pnlBotonRegistrate.setBackground(Color.black);
    }//GEN-LAST:event_btnRegistrateMouseExited

    /**
     * Maneja el evento de clic en el botón "Iniciar Sesión". Intenta autenticar
     * al usuario.
     *
     * @param evt El evento del mouse.
     */
    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        try {
            autenticarUsuario(); // Ahora este método se encarga de todo
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(pantallaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    /**
     * Maneja el evento de foco ganado en el campo de usuario. Si el texto
     * actual es el texto de marcador de posición, lo borra.
     *
     * @param evt El evento de foco.
     */
    private void inputUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUsuarioFocusGained
        if (inputUsuario.getText().equals("Introduce tu nombre de usuario")) {
            inputUsuario.setText("");
        }
    }//GEN-LAST:event_inputUsuarioFocusGained

    /**
     * Maneja el evento de foco perdido en el campo de usuario. Si el campo está
     * vacío, restablece el texto de marcador de posición.
     *
     * @param evt El evento de foco.
     */
    private void inputUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUsuarioFocusLost
        if (inputUsuario.getText().trim().isEmpty()) {
            inputUsuario.setText("Introduce tu nombre de usuario");
        }
    }//GEN-LAST:event_inputUsuarioFocusLost

    /**
     * Maneja el evento de foco ganado en el campo de contraseña. Si el texto
     * actual es el texto de marcador de posición, lo borra y cambia el tipo de
     * campo a password field para ocultar la contraseña.
     *
     * @param evt El evento de foco.
     */
    private void inputContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputContraseñaFocusGained
        if (String.valueOf(inputContraseña.getPassword()).equals("Introduce una contraseña")) {
            inputContraseña.setText(""); // Cambia el carácter oculto de la contraseña
            inputContraseña.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_inputContraseñaFocusGained

    /**
     * Maneja el evento de foco perdido en el campo de contraseña. Si el campo
     * está vacío, restablece el texto de marcador de posición.
     *
     * @param evt El evento de foco.
     */
    private void inputContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputContraseñaFocusLost
        if (inputUsuario.getText().trim().isEmpty()) {
            inputUsuario.setText("Introduce una contraseña");
        }
    }//GEN-LAST:event_inputContraseñaFocusLost


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
    /**
     * Autentica al usuario con las credenciales ingresadas.
     *
     * @throws PersistenciaException Si ocurre un error al acceder a la base de
     * datos.
     * @throws SQLException Si ocurre un error durante la autenticación.
     */
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
                    inputUsuario.setText("");
                    inputContraseña.setText("");
                    framePrincipal.getPantallaPacientes().cargarNombre();
                    framePrincipal.cambiarPanel("pantallaPacientes"); // Si no es médico
                }

            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
                inputContraseña.setText("");
            }

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}
