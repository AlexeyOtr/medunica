package medunica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class Sheduler extends javax.swing.JFrame {

    DataBase db = null;
    DefaultListModel defaultListModel;
    
    public Sheduler() {
        initComponents();
        // подключение к базе
        db = new DataBase("jdbc:mysql://localhost/medunica?character_set_server=utf8mb4&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor");
        System.out.println(db);
        
        defaultListModel = new DefaultListModel();
        jListSheduleDay.setModel(defaultListModel);
        
        // заполнение комбо бокса специалистами
        ResultSet rs = db.sendSelect("SELECT family, name, patronomic, spec_name FROM personal INNER JOIN spec ON spec_id=spec.id WHERE status='медперсонал';");
        try {
            while (rs.next()){
                comboBoxSpes.addItem(rs.getString("family") + " " + rs.getString("name") + " " + rs.getString("patronomic") + ", " + rs.getString("spec_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            updateListSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        comboBoxSpes = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSheduleDay = new javax.swing.JList<>();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jSpinnerSetTime = new javax.swing.JSpinner(sm);
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("МЕДУНИЦА РАСПИСАНИЕ");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jFormattedTextField1.setText("СНИЛС КЛИЕНТА");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Установка расписания процедур для");

        jLabel4.setText("Иванов Иван Иванович");

        jLabel5.setText("Специалист");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Клиенты", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Установка расписания для");

        dateChooserPanel1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserPanel1OnSelectionChange(evt);
            }
        });
        dateChooserPanel1.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserPanel1OnCommit(evt);
            }
        });

        comboBoxSpes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSpesActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(jListSheduleDay);

        jLabel3.setText("Время работы: ");

        jButton2.setText("Добавить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Удалить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerSetTime, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxSpes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSpes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(dateChooserPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerSetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerSetTime, "HH:mm");
        jSpinnerSetTime.setEditor(de);

        jTabbedPane1.addTab("Сотрудники", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooserPanel1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnCommit
        
        try {
            updateListSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanel1OnCommit

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //defaultListModel.addElement(new SimpleDateFormat("HH:mm").format(jSpinnerSetTime.getValue()));
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserPanel1.getSelectedDate().getTimeInMillis());
        dateTime += " " + new SimpleDateFormat("HH:mm").format(jSpinnerSetTime.getValue());
        
        db.sendInsert("INSERT INTO medunica.shedule_personal (personal_id, datetime) VALUES "
                    + " ((SELECT p.id FROM medunica.personal p WHERE p.family='"+parse[0]+"' && p.name='"+parse[1]+"' && p.patronomic='"+parse[2]+"'),"
                    + " '"+ dateTime +"')");

        defaultListModel.addElement(dateTime);
        
//        try {
//            Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
//            defaultListModel.addElement(d);
//            System.out.println("Mil " + d.getTime());
//        } catch (ParseException ex) {
//            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        int defModel = jListSheduleDay.getSelectedIndex();
        
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        if(defModel >= 0){
            db.sendDelete("DELETE FROM medunica.shedule_personal WHERE "
                    + "personal_id=(SELECT id FROM medunica.personal p WHERE p.family='"+ parse[0] +"' AND p.name='"+ parse[1] +"' AND p.patronomic='"+ parse[2] +"') "
                    + "AND datetime='"+ jListSheduleDay.getSelectedValue() +"'");
//            System.out.println(parse[0] + " " + parse[1] + " " + parse[2] + " " + jListSheduleDay.getSelectedValue());
            defaultListModel.remove(defModel);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dateChooserPanel1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnSelectionChange
        
        try {
            updateListSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanel1OnSelectionChange

    private void comboBoxSpesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpesActionPerformed
        
        try {
            updateListSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboBoxSpesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Обновление данных времени работы 
    private void updateListSheduleDay() throws ParseException{
        
        defaultListModel.removeAllElements();
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserPanel1.getSelectedDate().getTimeInMillis());
        
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        ResultSet rs = db.sendSelect("SELECT sp.datetime FROM medunica.shedule_personal sp WHERE DATE(datetime) = DATE('"+ dateTime +"')"
                + " AND sp.personal_id=(SELECT p.id FROM medunica.personal p WHERE p.family='"+parse[0]+"' && p.name='"+parse[1]+"' && p.patronomic='"+parse[2]+"')");
        try {
            while (rs.next()){
                defaultListModel.addElement(rs.getString("datetime"));
//                System.out.println(rs.getString("datetime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxSpes;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jListSheduleDay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinnerSetTime;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
