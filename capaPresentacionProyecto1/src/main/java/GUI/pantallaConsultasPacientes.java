/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaConsultasPacientes extends javax.swing.JPanel {

    /**
     * Creates new form pantallaConsultasPacientes
     */
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private ConsultaBO consultaBO = DependencyInjector.crearConsultaBO();
    private Mapper mapper = new Mapper();
    FramePrincipal framePrincipal;

    public pantallaConsultasPacientes(FramePrincipal frame) {
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
        jLabel4 = new javax.swing.JLabel();
        inputCelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JLabel();
        btnSelecionar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Historial de Consultas");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 36, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Celular:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 226, -1));

        inputCelular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(inputCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 226, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Paciente", "Médico", "Especialidad", "Tratamiento", "Notas", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 286, 833, 324));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnSelecionar.setText("Seleccionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        add(btnSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaMedicosMenu");
        jTable1.setModel(new DefaultTableModel());
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.revalidate();
        jScrollPane1.repaint();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        try {
            // TODO add your handling code here:
            consultarPaciente();
        } catch (PersistenciaException ex) {
            Logger.getLogger(pantallaConsultasPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(pantallaConsultasPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pantallaConsultasPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JTextField inputCelular;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables

    private void consultarPaciente() throws PersistenciaException, NegocioException, SQLException {
        try {
            String celular = inputCelular.getText().trim();
            if (celular.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de celular.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Paciente paciente = pacienteBO.buscarPacientePorCelular(celular);
            System.out.println(paciente);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró un paciente con ese número de celular.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Cita> citasPaciente = citaBO.consultarCitasPacientes(paciente);
            if (citasPaciente.isEmpty()){
                JOptionPane.showMessageDialog(this, "No se encontraron consultas de ese paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<MedicoNuevoDTO> medicosDTO = new ArrayList<>();
            List<ConsultaNuevaDTO> consultasNuevaDTO = new ArrayList<>();
            for (int i = 0; i < citasPaciente.size(); i++) {
                Usuario usuario = citasPaciente.get(i).getMedico().getUsuario();
                medicosDTO.add(medicoBO.consultarMedico(usuario));
                consultasNuevaDTO.add(consultaBO.obtenerConsultasPaciente(citasPaciente.get(i)));
            }
            String[] columnas = {"PACIENTE", "MEDICO", "ESPECIALIDAD", "TRATAMIENTO", "NOTAS", "FECHA", "ESTADO"};

            String[][] datos = new String[consultasNuevaDTO.size()][7];
            String nombrePaciente = paciente.getNombre() + " " + paciente.getApellidoPaterno();
            
            for (int i = 0; i < consultasNuevaDTO.size(); i++) {
                MedicoNuevoDTO medicoNuevo = medicosDTO.get(i);
                ConsultaNuevaDTO consultaNueva = consultasNuevaDTO.get(i);
                String nombreMedico = "Dr. " + medicoNuevo.getNombre() + " " + " " + medicoNuevo.getApellidoPaterno();
                if (consultaNueva != null) {
                    datos[i][0] = nombrePaciente;
                    datos[i][1] = nombreMedico;
                    datos[i][2] = medicoNuevo.getEspecialidad();
                    datos[i][3] = consultaNueva.getTratamiento();
                    datos[i][4] = consultaNueva.getObservaciones();
                    datos[i][5] = consultaNueva.getFechaHora().toString();
                    datos[i][6] = consultaNueva.getEstado();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron consultas de ese paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));

            jScrollPane1.setViewportView(jTable1);

            jScrollPane1.revalidate();
            jScrollPane1.repaint();

        } catch (PersistenciaException | NegocioException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar el paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
