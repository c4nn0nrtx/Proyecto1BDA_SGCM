/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BO.CitaBO;
import BO.ConsultaBO;
import BO.MedicoBO;
import BO.PacienteBO;
import DTO.ConsultaNuevaDTO;
import DTO.MedicoNuevoDTO;
import Entidades.Cita;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import configuracion.DependencyInjector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaTusConsultas extends javax.swing.JPanel {

    /**
     * Creates new form pantallaTusConsultas
     */
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private ConsultaBO consultaBO = DependencyInjector.crearConsultaBO();
    private Mapper mapper = new Mapper();
    FramePrincipal framePrincipal;
    
    public pantallaTusConsultas(FramePrincipal frame) {
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
        txtSubTituloConsulta = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtSubTituloConsulta1 = new javax.swing.JLabel();
        txtSubTituloConsulta2 = new javax.swing.JLabel();
        txtSubTituloConsulta3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Tus Consultas");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 37, -1, -1));

        txtSubTituloConsulta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTituloConsulta.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTituloConsulta.setText("Fecha Fin");
        add(txtSubTituloConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Medicina General", "Cardiólogo", "Nutricionista" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 153, 250, -1));

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 226, 833, 324));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 240, 40));

        txtSubTituloConsulta1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTituloConsulta1.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTituloConsulta1.setText("Tipo de Consulta (especialidad):");
        add(txtSubTituloConsulta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 122, -1, -1));

        txtSubTituloConsulta2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTituloConsulta2.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTituloConsulta2.setText("Rango de Fechas:");
        add(txtSubTituloConsulta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        txtSubTituloConsulta3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTituloConsulta3.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTituloConsulta3.setText("Fecha Inicio");
        add(txtSubTituloConsulta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));
        add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 240, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaPacientes");
    }//GEN-LAST:event_btnVolverMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtSubTituloConsulta;
    private javax.swing.JLabel txtSubTituloConsulta1;
    private javax.swing.JLabel txtSubTituloConsulta2;
    private javax.swing.JLabel txtSubTituloConsulta3;
    // End of variables declaration//GEN-END:variables
    public void misConsultas() throws PersistenciaException, NegocioException, SQLException {
        try{
            Usuario usuario = framePrincipal.getUsuarioAutenticado();
            int idPaciente = usuario.getIdUsuario();
            
            Paciente paciente = pacienteBO.buscarPacientePorID(idPaciente);
            
            List<Cita> citasPaciente = citaBO.consultarCitasPacientes(paciente);
            if (citasPaciente.isEmpty()){
                JOptionPane.showMessageDialog(this, "No se encontraron consultas de ese paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<MedicoNuevoDTO> medicosDTO = new ArrayList<>();
            List<ConsultaNuevaDTO> consultasNuevaDTO = new ArrayList<>();
            
            for (int i = 0; i < citasPaciente.size(); i++) {
                Usuario usuarioConsulta = citasPaciente.get(i).getMedico().getUsuario();
                medicosDTO.add(medicoBO.consultarMedico(usuarioConsulta));
                consultasNuevaDTO.add(consultaBO.obtenerConsultasPaciente(citasPaciente.get(i)));
            }
            consultasNuevaDTO.removeIf(element -> element == null);
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
                }
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));

            jScrollPane1.setViewportView(jTable1);

            jScrollPane1.revalidate();
            jScrollPane1.repaint();
        } catch (PersistenciaException | NegocioException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener las consultas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
