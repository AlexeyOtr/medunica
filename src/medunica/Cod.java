package medunica;

public class Cod extends javax.swing.JFrame {

    DataBase db = null;
    
    public Cod() {
        initComponents();
        db = new DataBase("jdbc:mysql://localhost/medunica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CODER");

        testBtn.setText("TEST");
        testBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(617, Short.MAX_VALUE)
                .addComponent(testBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(testBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testBtnActionPerformed
        // TODO add your handling code here:
        db.sendInsert("INSERT INTO login (login, password, personal_id) VALUES('dsgsde', 'ioshrgoir', 1)");
        
    }//GEN-LAST:event_testBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton testBtn;
    // End of variables declaration//GEN-END:variables
}
