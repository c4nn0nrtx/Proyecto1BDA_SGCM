/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
public class pantallaMedicosMenu extends javax.swing.JPanel {

    /**
     * Creates new form pantallaMedicosMenu
     */
     private FramePrincipal framePrincipal;
    public pantallaMedicosMenu(FramePrincipal frame) {
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
        jLabel1 = new javax.swing.JLabel();
        pnlConsultarHistorialPaciente = new javax.swing.JPanel();
        btnAgendarCita = new javax.swing.JLabel();
        pnlAgendarCita1 = new javax.swing.JPanel();
        btnAgendarCita1 = new javax.swing.JLabel();
        pnlActivo = new javax.swing.JPanel();
        btnAgendarCita3 = new javax.swing.JLabel();
        pnlInactivo = new javax.swing.JPanel();
        btnAgendarCita2 = new javax.swing.JLabel();
        pnlInactivo1 = new javax.swing.JPanel();
        btnAgendarCita4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSubTitulo.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTitulo.setText("Menú Principal");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MEDICOS");

        pnlConsultarHistorialPaciente.setBackground(new java.awt.Color(60, 109, 232));

        btnAgendarCita.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita.setText("Consultar Historial Paciente");
        btnAgendarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlConsultarHistorialPacienteLayout = new javax.swing.GroupLayout(pnlConsultarHistorialPaciente);
        pnlConsultarHistorialPaciente.setLayout(pnlConsultarHistorialPacienteLayout);
        pnlConsultarHistorialPacienteLayout.setHorizontalGroup(
            pnlConsultarHistorialPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarHistorialPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlConsultarHistorialPacienteLayout.setVerticalGroup(
            pnlConsultarHistorialPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarHistorialPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAgendarCita1.setBackground(new java.awt.Color(255, 0, 0));

        btnAgendarCita1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita1.setText("Consultar Agenda");
        btnAgendarCita1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlAgendarCita1Layout = new javax.swing.GroupLayout(pnlAgendarCita1);
        pnlAgendarCita1.setLayout(pnlAgendarCita1Layout);
        pnlAgendarCita1Layout.setHorizontalGroup(
            pnlAgendarCita1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgendarCita1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAgendarCita1Layout.setVerticalGroup(
            pnlAgendarCita1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgendarCita1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlActivo.setBackground(new java.awt.Color(0, 204, 0));

        btnAgendarCita3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita3.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita3.setText("Médico Activo");
        btnAgendarCita3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlActivoLayout = new javax.swing.GroupLayout(pnlActivo);
        pnlActivo.setLayout(pnlActivoLayout);
        pnlActivoLayout.setHorizontalGroup(
            pnlActivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActivoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendarCita3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlActivoLayout.setVerticalGroup(
            pnlActivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlInactivo.setBackground(new java.awt.Color(255, 51, 51));

        btnAgendarCita2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAgendarCita2.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita2.setText("Médico Inactivo");
        btnAgendarCita2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlInactivoLayout = new javax.swing.GroupLayout(pnlInactivo);
        pnlInactivo.setLayout(pnlInactivoLayout);
        pnlInactivoLayout.setHorizontalGroup(
            pnlInactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInactivoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlInactivoLayout.setVerticalGroup(
            pnlInactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInactivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlInactivo1.setBackground(new java.awt.Color(255, 51, 51));

        btnAgendarCita4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAgendarCita4.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgendarCita4.setText("Cerrar Sesión");
        btnAgendarCita4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendarCita4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgendarCita4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlInactivo1Layout = new javax.swing.GroupLayout(pnlInactivo1);
        pnlInactivo1.setLayout(pnlInactivo1Layout);
        pnlInactivo1Layout.setHorizontalGroup(
            pnlInactivo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInactivo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlInactivo1Layout.setVerticalGroup(
            pnlInactivo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInactivo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgendarCita4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSubTitulo)
                .addGap(320, 320, 320))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlInactivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(pnlConsultarHistorialPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(pnlAgendarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel1)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtSubTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlAgendarCita1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlConsultarHistorialPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(156, 156, 156)
                .addComponent(pnlInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlInactivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarCita4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCita4MouseClicked
        framePrincipal.cambiarPanel("pantallaInicioSesion");
    }//GEN-LAST:event_btnAgendarCita4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgendarCita;
    private javax.swing.JLabel btnAgendarCita1;
    private javax.swing.JLabel btnAgendarCita2;
    private javax.swing.JLabel btnAgendarCita3;
    private javax.swing.JLabel btnAgendarCita4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlActivo;
    private javax.swing.JPanel pnlAgendarCita1;
    private javax.swing.JPanel pnlConsultarHistorialPaciente;
    private javax.swing.JPanel pnlInactivo;
    private javax.swing.JPanel pnlInactivo1;
    private javax.swing.JLabel txtSubTitulo;
    // End of variables declaration//GEN-END:variables
}
