/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaTusConsultas extends javax.swing.JPanel {

    /**
     * Creates new form pantallaTusConsultas
     */
    
     private FramePrincipal framePrincipal;
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

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Tus Consultas");
        add(txtSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 37, -1, -1));

        txtSubTituloConsulta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTituloConsulta.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTituloConsulta.setText("Fecha de Consulta:");
        add(txtSubTituloConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Medicina General", "Cardiólogo", "Nutricionista" }));
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
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 240, 40));

        txtSubTituloConsulta1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSubTituloConsulta1.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTituloConsulta1.setText("Tipo de Consulta (especialidad):");
        add(txtSubTituloConsulta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 122, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        framePrincipal.cambiarPanel("pantallaPacientes");
    }//GEN-LAST:event_btnVolverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtSubTitulo;
    private javax.swing.JLabel txtSubTituloConsulta;
    private javax.swing.JLabel txtSubTituloConsulta1;
    // End of variables declaration//GEN-END:variables
}
