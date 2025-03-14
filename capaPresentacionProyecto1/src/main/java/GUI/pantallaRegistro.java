package GUI;

import BO.Direccion_PacienteBO;
import BO.PacienteBO;
import BO.UsuarioBO;
import DTO.Direccion_PacienteNuevaDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.NegocioException;
import com.toedter.calendar.JDateChooser;
import configuracion.DependencyInjector;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pantalla de registro. Permite a los usuarios registrarse en la aplicación
 * como médicos.
 *
 * @author Sebastian Moreno
 */
public class pantallaRegistro extends javax.swing.JPanel {

    private UsuarioBO usuarioBO = DependencyInjector.crearUsuarioBO();
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private Direccion_PacienteBO direccionBO = DependencyInjector.crearDireccionBO();
    private Usuario usuario;
    private Direccion_Paciente direccion;
    private JDateChooser selectorFechas;
    private FramePrincipal framePrincipal;

    /**
     * Constructor de la pantalla de registro. Inicializa los componentes, el
     * selector de fechas y establece el FramePrincipal.
     *
     * @param frame El FramePrincipal que contiene esta pantalla.
     */
    public pantallaRegistro(FramePrincipal frame) {
        this.framePrincipal = frame;
        selectorFechas = new JDateChooser();
        selectorFechas.setBounds(650, 300, 200, 40);
        LocalDate minDate = LocalDate.now().minusYears(6);
        selectorFechas.setMaxSelectableDate(java.sql.Date.valueOf(minDate));
        LocalDate maxDate = LocalDate.now().minusYears(150);
        selectorFechas.setMinSelectableDate(java.sql.Date.valueOf(maxDate));
        selectorFechas.setDate(java.sql.Date.valueOf(minDate));
        this.add(selectorFechas);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        txtTituloPantalla = new javax.swing.JLabel();
        txtSubTitulo = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JLabel();
        txtApellidoM = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        txtCelular = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JLabel();
        txtColonia = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JLabel();
        txtCalle = new javax.swing.JLabel();
        txtNumeroExt = new javax.swing.JLabel();
        inputCorreo = new javax.swing.JTextField();
        inputUsuario = new javax.swing.JTextField();
        inputContraseña = new javax.swing.JTextField();
        inputCalle = new javax.swing.JTextField();
        inputNumExt = new javax.swing.JTextField();
        inputColonia = new javax.swing.JTextField();
        inputCodigoPostal = new javax.swing.JTextField();
        inputNombre = new javax.swing.JTextField();
        inputApellidoP = new javax.swing.JTextField();
        inputCelular = new javax.swing.JTextField();
        inputApellidoM = new javax.swing.JTextField();
        pnlBotonVolver = new javax.swing.JPanel();
        btnVolver = new javax.swing.JLabel();
        txtCelular1 = new javax.swing.JLabel();
        pnlBotonRegistrate = new javax.swing.JPanel();
        btnRegistrate1 = new javax.swing.JLabel();

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTituloPantalla.setFont(new java.awt.Font("Roboto", 1, 44)); // NOI18N
        txtTituloPantalla.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloPantalla.setText("Registro Médico");
        panelPrincipal.add(txtTituloPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("CLINICA SALUDABLE");
        panelPrincipal.add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtCodigoPostal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCodigoPostal.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoPostal.setText("Codigo Postal*:");
        panelPrincipal.add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setText("Nombre(s)*:");
        panelPrincipal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txtApellidoP.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoP.setText("Apellido Paterno*:");
        panelPrincipal.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        txtApellidoM.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoM.setText("Apellido Materno (Opcional):");
        panelPrincipal.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setText("Usuario*:");
        panelPrincipal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        txtCelular.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCelular.setForeground(new java.awt.Color(0, 0, 0));
        txtCelular.setText("Fecha de Nacimiento*:");
        panelPrincipal.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, -1, -1));

        txtCorreoElectronico.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCorreoElectronico.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreoElectronico.setText("Correo Electronico*:");
        panelPrincipal.add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        txtColonia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtColonia.setForeground(new java.awt.Color(0, 0, 0));
        txtColonia.setText("Colonia*:");
        panelPrincipal.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        txtContraseña.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
        txtContraseña.setText("Contraseña*:");
        panelPrincipal.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        txtCalle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCalle.setForeground(new java.awt.Color(0, 0, 0));
        txtCalle.setText("Calle*:");
        panelPrincipal.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        txtNumeroExt.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNumeroExt.setForeground(new java.awt.Color(0, 0, 0));
        txtNumeroExt.setText("Numero Ext*:");
        panelPrincipal.add(txtNumeroExt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        inputCorreo.setBorder(null);
        panelPrincipal.add(inputCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 230, 40));

        inputUsuario.setBorder(null);
        panelPrincipal.add(inputUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 260, 40));

        inputContraseña.setBorder(null);
        panelPrincipal.add(inputContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 260, 40));

        inputCalle.setBorder(null);
        panelPrincipal.add(inputCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 200, 40));

        inputNumExt.setBorder(null);
        panelPrincipal.add(inputNumExt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 110, 40));

        inputColonia.setBorder(null);
        panelPrincipal.add(inputColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 200, 40));

        inputCodigoPostal.setBorder(null);
        panelPrincipal.add(inputCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 200, 40));

        inputNombre.setBorder(null);
        panelPrincipal.add(inputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 200, 40));

        inputApellidoP.setBorder(null);
        panelPrincipal.add(inputApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 200, 40));

        inputCelular.setBorder(null);
        panelPrincipal.add(inputCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 200, 40));

        inputApellidoM.setBorder(null);
        panelPrincipal.add(inputApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 230, 40));

        pnlBotonVolver.setBackground(new java.awt.Color(0, 0, 0));
        pnlBotonVolver.setForeground(new java.awt.Color(0, 0, 0));

        btnVolver.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonVolverLayout = new javax.swing.GroupLayout(pnlBotonVolver);
        pnlBotonVolver.setLayout(pnlBotonVolverLayout);
        pnlBotonVolverLayout.setHorizontalGroup(
            pnlBotonVolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonVolverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBotonVolverLayout.setVerticalGroup(
            pnlBotonVolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonVolverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPrincipal.add(pnlBotonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 600, 150, 40));

        txtCelular1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCelular1.setForeground(new java.awt.Color(0, 0, 0));
        txtCelular1.setText("Celular*:");
        panelPrincipal.add(txtCelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, -1, -1));

        pnlBotonRegistrate.setBackground(new java.awt.Color(0, 0, 0));
        pnlBotonRegistrate.setForeground(new java.awt.Color(0, 0, 0));

        btnRegistrate1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrate1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrate1.setText("Registrate");
        btnRegistrate1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrate1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonRegistrateLayout = new javax.swing.GroupLayout(pnlBotonRegistrate);
        pnlBotonRegistrate.setLayout(pnlBotonRegistrateLayout);
        pnlBotonRegistrateLayout.setHorizontalGroup(
            pnlBotonRegistrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(pnlBotonRegistrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBotonRegistrateLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnRegistrate1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlBotonRegistrateLayout.setVerticalGroup(
            pnlBotonRegistrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlBotonRegistrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBotonRegistrateLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnRegistrate1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelPrincipal.add(pnlBotonRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 500, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Volver". Navega a la pantalla de
     * inicio de sesión.
     *
     * @param evt El evento del mouse.
     */
    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaInicioSesion");
    }//GEN-LAST:event_btnVolverMouseClicked

    /**
     * Maneja el evento de clic en el botón "Registrate". Valida los campos y,
     * si son válidos, agrega el usuario.
     *
     * @param evt El evento del mouse.
     */
    private void btnRegistrate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrate1MouseClicked

        if (validarCampos() == true) {
            agregarUsuario();
        } else {

        }

    }//GEN-LAST:event_btnRegistrate1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnRegistrate1;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JTextField inputApellidoM;
    private javax.swing.JTextField inputApellidoP;
    private javax.swing.JTextField inputCalle;
    private javax.swing.JTextField inputCelular;
    private javax.swing.JTextField inputCodigoPostal;
    private javax.swing.JTextField inputColonia;
    private javax.swing.JTextField inputContraseña;
    private javax.swing.JTextField inputCorreo;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputNumExt;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel pnlBotonRegistrate;
    private javax.swing.JPanel pnlBotonVolver;
    private javax.swing.JLabel txtApellidoM;
    private javax.swing.JLabel txtApellidoP;
    private javax.swing.JLabel txtCalle;
    private javax.swing.JLabel txtCelular;
    private javax.swing.JLabel txtCelular1;
    private javax.swing.JLabel txtCodigoPostal;
    private javax.swing.JLabel txtColonia;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JLabel txtCorreoElectronico;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNumeroExt;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtTituloPantalla;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

    /*METODOS NECESARIOS PARA LA CREACION DE USUARIOS Y PACIENTES*/
    /**
     * Agrega un nuevo usuario a la base de datos. Obtiene los datos de los
     * campos de entrada, crea objetos DTO y llama a los métodos
     * correspondientes de la capa de negocio para agregar el usuario y el
     * paciente.
     */
    public void agregarUsuario() {
        try {
            LocalDate fechaLocal = LocalDate.now();
            String nombreUsuario = inputUsuario.getText();
            String contrasenha = inputContraseña.getText();
            String nombre = inputNombre.getText();
            String ApellidoP = inputApellidoP.getText();
            String ApellidoM = inputApellidoM.getText();
            String Telefono = inputCelular.getText();
            String Correo = inputCorreo.getText();

            java.util.Date Fecha = selectorFechas.getDate(); // obtener fecha seleccionada en el selector.

            if (Fecha != null) {
                fechaLocal = Fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            } else {
                System.out.println("No se ha seleccionado una fecha.");
            }
            String calle = inputCalle.getText();
            String colonia = inputColonia.getText();
            int cp = Integer.parseInt(inputCodigoPostal.getText());
            String numeroExt = inputNumExt.getText();

            UsuarioNuevoDTO usuarioDTO = new UsuarioNuevoDTO(nombreUsuario, contrasenha);
            Direccion_PacienteNuevaDTO direccionDTO = new Direccion_PacienteNuevaDTO(calle, colonia, cp, numeroExt);
            PacienteNuevoDTO paciente = new PacienteNuevoDTO(usuario, direccion, nombre, ApellidoP, ApellidoM, Correo, fechaLocal, Telefono);
            boolean pacienteExito = pacienteBO.agregarPaciente(paciente, usuarioDTO, direccionDTO);

            // Verificar si la operación fue exitosa.
            if (pacienteExito == true) {
                JOptionPane.showMessageDialog(this, "Usuario agregado correctamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar usuario");
            }

        } catch (NegocioException ex) {
            // Manejo de excepciones específicas de la capa de negocio
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Captura de errores inesperados, logueo y mensaje genérico al usuario. Se debería especificar si es posible exactamente que falló
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error inesperado", ex);
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Limpia los campos de entrada del formulario.
     */
    public void limpiarCampos() {
        inputUsuario.setText("");
        inputContraseña.setText("");
        inputNombre.setText("");
        inputApellidoP.setText("");
        inputApellidoM.setText("");
        inputCelular.setText("");
        selectorFechas.setDate(null);
        inputCorreo.setText("");
        inputCalle.setText("");
        inputColonia.setText("");
        inputCodigoPostal.setText("");
        inputNumExt.setText("");
    }

    /**
     * Valida todos los campos del formulario.
     *
     * @return true si todos los campos son válidos, false en caso contrario.
     */
    public boolean validarCampos() {

        if (!validarNombre()
                || !validarApellidoP()
                || !validarTelefono()
                || !validarCorreo()
                || !validarColonia()
                || !validarCodigoPostal()) {

            return false; // Si alguna validación falla, no continuar
        }

        if (inputUsuario.getText() != null && !inputUsuario.getText().isEmpty()
                && inputContraseña.getText() != null && !inputContraseña.getText().isEmpty()
                && inputNombre.getText() != null && !inputNombre.getText().isEmpty()
                && inputApellidoP.getText() != null && !inputApellidoP.getText().isEmpty()
                && inputCelular.getText() != null && !inputCelular.getText().isEmpty()
                && inputCorreo.getText() != null && !inputCorreo.getText().isEmpty()
                && selectorFechas.getDate() != null
                && inputCalle.getText() != null && !inputCalle.getText().isEmpty()
                && inputColonia.getText() != null && !inputColonia.getText().isEmpty()
                && inputCodigoPostal.getText() != null && !inputCodigoPostal.getText().isEmpty()
                && inputNumExt.getText() != null && !inputNumExt.getText().isEmpty()) {

            return true;
            // Aquí puedes continuar con la lógica si todos los campos están completos.
        } else {
            JOptionPane.showMessageDialog(null, "Llena todos los campos obligatorios(*) para completar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    /**
     * Valida el campo de correo electrónico.
     *
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    private boolean validarCorreo() {
        String correo = inputCorreo.getText();
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (correo == null || !correo.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Correo inválido. Debe tener el formato usuario@dominio.com", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida el campo de código postal.
     *
     * @return true si el código postal es válido, false en caso contrario.
     */
    private boolean validarCodigoPostal() {
        String cpTexto = inputCodigoPostal.getText();
        try {
            int cp = Integer.parseInt(cpTexto);
            if (cp < 10000 || cp > 99999) {
                JOptionPane.showMessageDialog(null, "Código Postal inválido. Debe tener exactamente 5 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código Postal inválido. Debe ser un número de 5 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Valida el campo de teléfono.
     *
     * @return true si el teléfono es válido, false en caso contrario.
     */
    private boolean validarTelefono() {
        String telefono = inputCelular.getText().trim(); // Elimina espacios en blanco
        String regex = "^[0-9]{10}$"; // NUMEROS DE 10 DIGITOS SOLAMENTE.

        if (telefono.isEmpty() || !telefono.matches(regex)) { // Si está vacío o no cumple con la validación
            JOptionPane.showMessageDialog(null,
                    "Número de teléfono inválido. Debe contener 10 dígitos numéricos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida el campo de nombre.
     *
     * @return true si el nombre es válido, false en caso contrario.
     */
    private boolean validarNombre() {
        String nombre = inputNombre.getText();
        // Se establece un patrón el cual el nombre debe cumplir
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+( [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$";
        // verificar que no sea un campo vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo del nombre no fue rellenado. Ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            // verificar que el nombre esté dentro de los límites establecidos
        } else if (nombre.length() < 3 || nombre.length() > 50) {
            JOptionPane.showMessageDialog(null, "Nombre inválido. La cantidad de caracteres está fuera del límite.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            // verificar que el nombre cumpla con el patrón establecido
        } else if (!nombre.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Nombre inválido. Debe iniciar con mayúscula y solo contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Valida el campo de apellido paterno.
     *
     * @return true si el apellido paterno es válido, false en caso contrario.
     */
    private boolean validarApellidoP() {
        String apellido = inputApellidoP.getText().trim(); // Eliminamos espacios en blanco
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";

        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo del apellido paterno no fue rellenado. Ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (apellido.length() < 3 || apellido.length() > 50) {
            JOptionPane.showMessageDialog(null, "Apellido paterno inválido. La cantidad de caracteres está fuera del límite.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!apellido.matches(regex)) { // Verificamos si está vacío o no cumple con el regex
            JOptionPane.showMessageDialog(null,
                    "Apellido paterno inválido. Debe iniciar con mayúscula y solo contener letras.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Valida el campo de apellido materno.
     *
     * @return true si el apellido materno es válido, false en caso contrario.
     */
    private boolean validarApellidoM() {
        String apellido = inputApellidoM.getText();
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
        if (apellido == null || !apellido.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Apellido materno inválido. Debe iniciar con mayúscula y solo contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida el campo de colonia.
     *
     * @return true si la colonia es válida, false en caso contrario.
     */
    private boolean validarColonia() {
        String colonia = inputColonia.getText();
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ0-9 ]+$"; // Permite letras, números y espacios
        if (colonia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de la colonia no fue rellenado. Ingrese una colonia válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (colonia.length() < 3 || colonia.length() > 50) {
            JOptionPane.showMessageDialog(null, "Colonia inválida. La cantidad de caracteres está fuera del límite.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (colonia == null || !colonia.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Colonia inválida. Solo se permiten letras, números y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
