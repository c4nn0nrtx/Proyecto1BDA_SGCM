/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaCitasPendientes extends javax.swing.JPanel {

    /**
     * Creates new form pantallaCitasPendientes1
     */
    
    FramePrincipal framePrincipal;
    public pantallaCitasPendientes(FramePrincipal frame) {
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

        txtCitasProgramadas = new javax.swing.JLabel();
        txtEmergencia = new javax.swing.JLabel();
        pnlCitasProgramadas = new javax.swing.JScrollPane();
        tblCitasProgramadas = new javax.swing.JTable();
        pnlCitasEmergencia = new javax.swing.JScrollPane();
        tblCitasEmergencia = new javax.swing.JTable();
        btnVolver = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCitasProgramadas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtCitasProgramadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCitasProgramadas.setText("Citas Programadas");
        txtCitasProgramadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCitasProgramadasMouseClicked(evt);
            }
        });
        add(txtCitasProgramadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 6, 870, -1));

        txtEmergencia.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtEmergencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmergencia.setText("Emergencia");
        add(txtEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 262, -1));

        tblCitasProgramadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Paciente", "Horario Programado", "Estado", "Iniciar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlCitasProgramadas.setViewportView(tblCitasProgramadas);

        add(pnlCitasProgramadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 720, 209));

        tblCitasEmergencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Paciente", "Horario Programado", "Estado", "Iniciar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlCitasEmergencia.setViewportView(tblCitasEmergencia);

        add(pnlCitasEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 720, 209));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras (1).png"))); // NOI18N
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
       framePrincipal.cambiarPanel("pantallaMedicosMenu");
    }//GEN-LAST:event_btnVolverMouseClicked

    private void txtCitasProgramadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCitasProgramadasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCitasProgramadasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVolver;
    private javax.swing.JScrollPane pnlCitasEmergencia;
    private javax.swing.JScrollPane pnlCitasProgramadas;
    private javax.swing.JTable tblCitasEmergencia;
    private javax.swing.JTable tblCitasProgramadas;
    private javax.swing.JLabel txtCitasProgramadas;
    private javax.swing.JLabel txtEmergencia;
    // End of variables declaration//GEN-END:variables
}
