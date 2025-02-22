package GUI;

import Entidades.Usuario;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;

/**
 * Frame Principal Tiene un cardLayout para cambiar a todas las pantallas
 * necesarias.
 *
 * @author Sebastian Moreno
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    private CardLayout cardLayout;
    //Pantallas
    pantallaInicioSesion pantallaInicioSesion;
    pantallaRegistro pantallaRegistro;
    pantallaMenuPrincipalPacientes pantallaPacientes;
    pantallaInformacionUsuario pantallaInformacionUsuarios;
    pantallaTusConsultas pantallaTusConsultas;
    pantallaMedicosMenu pantallaMedicosMenu;
    pantallaCitasPendientes pantallaCitasPendientes;
    pantallaConsultasPacientes pantallaConsultasPacientes;
    pantallaAgendarCita pantallaAgendarCita;
    //Pantallas
    private Usuario usuarioAutenticado;

    public FramePrincipal() {
        setTitle("Sistema clinica");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();

        inicializarPantallas();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 700));

        panelPrincipal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    /* METODOS DE APOYO EN FRAME PRINCIPAL*/
    public void inicializarPantallas() {
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        pantallaInicioSesion = new pantallaInicioSesion(this);
        pantallaRegistro = new pantallaRegistro(this);
        pantallaPacientes = new pantallaMenuPrincipalPacientes(this);
        pantallaInformacionUsuarios = new pantallaInformacionUsuario(this);
        pantallaTusConsultas = new pantallaTusConsultas(this);
        pantallaMedicosMenu = new pantallaMedicosMenu(this);
        pantallaCitasPendientes = new pantallaCitasPendientes(this);
        pantallaConsultasPacientes = new pantallaConsultasPacientes(this);
        pantallaAgendarCita = new pantallaAgendarCita(this);

        panelPrincipal.add(pantallaInicioSesion, "pantallaInicioSesion");
        panelPrincipal.add(pantallaRegistro, "pantallaRegistro");
        panelPrincipal.add(pantallaPacientes, "pantallaPacientes");
        panelPrincipal.add(pantallaInformacionUsuarios, "pantallaInformacionUsuarios");
        panelPrincipal.add(pantallaTusConsultas, "pantallaTusConsultas");
        panelPrincipal.add(pantallaMedicosMenu, "pantallaMedicosMenu");
        panelPrincipal.add(pantallaCitasPendientes,"pantallaCitasPendientes");
        panelPrincipal.add(pantallaConsultasPacientes,"pantallaConsultasPacientes");
        panelPrincipal.add(pantallaAgendarCita, "pantallaAgendarCita");

        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void cambiarPanel(String nombrePanel) {
        cardLayout.show(panelPrincipal, nombrePanel);
    }

    public void setUsuarioAutenticado(Usuario usuario) {
        this.usuarioAutenticado = usuario;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public pantallaMedicosMenu getPantallaMedicosMenu() {
        return pantallaMedicosMenu;
    }
    public pantallaInformacionUsuario getPantallaInformacion() {
        return pantallaInformacionUsuarios;
    }
}
