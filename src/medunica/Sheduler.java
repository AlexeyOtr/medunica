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
    DefaultListModel dlmListSheduleDayPerson, dlmListClientSpecShedule, dlmListClientShedule;
    
    public Sheduler() {
        
        initComponents();
        
        // подключение к базе
        db = new DataBase("jdbc:mysql://localhost/medunica?character_set_server=utf8mb4&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor");
        System.out.println(db);
        
        dlmListSheduleDayPerson = new DefaultListModel();
        listSheduleDay.setModel(dlmListSheduleDayPerson);
        
        dlmListClientSpecShedule = new DefaultListModel();
        listClientSpecShedule.setModel(dlmListClientSpecShedule);
        
        dlmListClientShedule = new DefaultListModel();
        listClientShedule.setModel(dlmListClientShedule);
        
        // заполнение комбо бокса специалистами
        ResultSet rs = db.sendSelect("SELECT family, name, patronomic, spec_name FROM personal INNER JOIN spec ON spec_id=spec.id WHERE status='медперсонал';");
        try {
            while (rs.next()){
                comboBoxSpes.addItem(rs.getString("family") + " " + rs.getString("name") + " " + rs.getString("patronomic") + ", " + rs.getString("spec_name"));
                comboBoxSpecClients.addItem(rs.getString("family") + " " + rs.getString("name") + " " + rs.getString("patronomic") + ", " + rs.getString("spec_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            updateListPersonSheduleDay();
            updateListClientSpecShedule();
            
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dateChooserComboClientSheduler = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClientShedule = new javax.swing.JList<>();
        formattedTextFieldFindSnilsClient = new javax.swing.JFormattedTextField();
        btnSnilsSearchClient = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSpecClients = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listClientSpecShedule = new javax.swing.JList<>();
        comboBoxClientShedule = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        comboBoxSpes = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSheduleDay = new javax.swing.JList<>();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jSpinnerSetTime = new javax.swing.JSpinner(sm);
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("МЕДУНИЦА РАСПИСАНИЕ");

        dateChooserComboClientSheduler.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserComboClientShedulerOnSelectionChange(evt);
            }
        });
        dateChooserComboClientSheduler.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserComboClientShedulerOnCommit(evt);
            }
        });

        jScrollPane1.setViewportView(listClientShedule);

        try {
            formattedTextFieldFindSnilsClient.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSnilsSearchClient.setText("jButton1");
        btnSnilsSearchClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnilsSearchClientActionPerformed(evt);
            }
        });

        jLabel5.setText("Специалист");

        comboBoxSpecClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSpecClientsActionPerformed(evt);
            }
        });

        listClientSpecShedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientSpecSheduleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listClientSpecShedule);

        comboBoxClientShedule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Расписание для" }));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxClientShedule, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(formattedTextFieldFindSnilsClient, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSnilsSearchClient, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserComboClientSheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxSpecClients, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dateChooserComboClientSheduler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formattedTextFieldFindSnilsClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSnilsSearchClient)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxClientShedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSpecClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
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

        jScrollPane4.setViewportView(listSheduleDay);

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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
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
                .addContainerGap(162, Short.MAX_VALUE))
        );

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerSetTime, "HH:mm");
        jSpinnerSetTime.setEditor(de);

        jTabbedPane1.addTab("Сотрудники", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooserPanel1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnCommit
        
        try {
            updateListPersonSheduleDay();
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

        dlmListSheduleDayPerson.addElement(dateTime);
        
//        try {
//            Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
//            defaultListModel.addElement(d);
//            System.out.println("Mil " + d.getTime());
//        } catch (ParseException ex) {
//            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        int defModel = listSheduleDay.getSelectedIndex();
        
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        if(defModel >= 0){
            db.sendDelete("DELETE FROM medunica.shedule_personal WHERE "
                    + "personal_id=(SELECT id FROM medunica.personal p WHERE p.family='"+ parse[0] +"' AND p.name='"+ parse[1] +"' AND p.patronomic='"+ parse[2] +"') "
                    + "AND datetime='"+ listSheduleDay.getSelectedValue() +"'");
//            System.out.println(parse[0] + " " + parse[1] + " " + parse[2] + " " + jListSheduleDay.getSelectedValue());
            dlmListSheduleDayPerson.remove(defModel);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dateChooserPanel1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnSelectionChange
        
        try {
            updateListPersonSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanel1OnSelectionChange

    private void comboBoxSpesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpesActionPerformed
        
        try {
            updateListPersonSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboBoxSpesActionPerformed

    // Кнопка поиска клиента по снилс
    private void btnSnilsSearchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnilsSearchClientActionPerformed
        
        String prest= "SELECT * FROM clients WHERE snils='"+formattedTextFieldFindSnilsClient.getText()+"'";
        
        ResultSet rs = db.sendSelect(prest);
        
        try {
            if(rs.isBeforeFirst()){
                comboBoxClientShedule.removeAllItems();
                while (rs.next()){
                    comboBoxClientShedule.addItem(rs.getString("family") + " " + rs.getString("name") + " " + rs.getString("patronomic") + ", " + rs.getString("date_birth"));
                }
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        updateListClientShedule();
        
       // System.out.println("Number of records: " + count);
    }//GEN-LAST:event_btnSnilsSearchClientActionPerformed

    private void comboBoxSpecClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpecClientsActionPerformed
        updateListClientSpecShedule();
    }//GEN-LAST:event_comboBoxSpecClientsActionPerformed

    private void dateChooserComboClientShedulerOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserComboClientShedulerOnCommit
//        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserComboClientSheduler.getSelectedDate().getTimeInMillis());
//        System.out.println(dateTime);
        updateListClientSpecShedule();
    }//GEN-LAST:event_dateChooserComboClientShedulerOnCommit

    private void dateChooserComboClientShedulerOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserComboClientShedulerOnSelectionChange
//        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserComboClientSheduler.getSelectedDate().getTimeInMillis());
//        System.out.println("### " + dateTime);
    }//GEN-LAST:event_dateChooserComboClientShedulerOnSelectionChange

    private void listClientSpecSheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientSpecSheduleMouseClicked
        if (evt.getClickCount() == 2) {
            System.out.println(listClientSpecShedule.getSelectedValue());
            
            String parseComboboxSpec = comboBoxSpecClients.getSelectedItem().toString();
            String[] parse = parseComboboxSpec.split("[ ,]+");

            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dateChooserComboClientSheduler.getSelectedDate().getTimeInMillis());
            
            db.sendInsert("INSERT INTO medunica.nomination (client_id, personal_id, kabinet_id, datetime)"
                + " VALUES ((SELECT c.id FROM clients c WHERE c.snils='"+formattedTextFieldFindSnilsClient.getText()+"' ), "
                + "(SELECT p.id FROM personal p WHERE p.family='"+parse[0]+"' AND p.name='"+parse[1]+"' AND p.patronomic='"+parse[2]+"'),"
                + " 1, "
                + "'"+ listClientSpecShedule.getSelectedValue().toString() +"')");
            
            db.sendUpdate("UPDATE medunica.shedule_personal sp SET sp.client_id=(SELECT c.id FROM clients c WHERE c.snils='"+formattedTextFieldFindSnilsClient.getText()+"') WHERE sp.personal_id=(SELECT p.id FROM personal p WHERE p.family='"+parse[0]+"' AND p.name='"+parse[1]+"' AND p.patronomic='"+parse[2]+"') AND sp.datetime='"+ listClientSpecShedule.getSelectedValue().toString() +"'");

            //dlmListSheduleDayPerson.addElement(dateTime);
            updateListClientShedule();
        }
    }//GEN-LAST:event_listClientSpecSheduleMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateListClientShedule();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Обновление данных времени работы при установке расписания работы сотрудников
    private void updateListPersonSheduleDay() throws ParseException{
        
        dlmListSheduleDayPerson.removeAllElements();
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserPanel1.getSelectedDate().getTimeInMillis());
        
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        ResultSet rs = db.sendSelect("SELECT sp.datetime FROM medunica.shedule_personal sp WHERE DATE(datetime) = DATE('"+ dateTime +"')"
                + " AND sp.personal_id=(SELECT p.id FROM medunica.personal p WHERE p.family='"+parse[0]+"' && p.name='"+parse[1]+"' && p.patronomic='"+parse[2]+"')");
        try {
            while (rs.next()){
                dlmListSheduleDayPerson.addElement(rs.getString("datetime"));
//                System.out.println(rs.getString("datetime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Обновление listClientShedule в расписании клиентов
    private void updateListClientShedule(){
        
             
        dlmListClientShedule.removeAllElements();
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserComboClientSheduler.getSelectedDate().getTimeInMillis());
        
        String parseComboboxSpec = comboBoxSpecClients.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        ResultSet rs = db.sendSelect("SELECT n.datetime FROM medunica.nomination n INNER JOIN medunica.clients c ON n.client_id=c.id AND c.snils='"+formattedTextFieldFindSnilsClient.getText()+"' AND DATE(n.datetime) = DATE('"+ dateTime +"')");
        try {
            while (rs.next()){
                dlmListClientShedule.addElement(rs.getString("datetime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Обновление listClientSpecShedule в расписании клиентов
    private void updateListClientSpecShedule(){
        
        
        dlmListClientSpecShedule.removeAllElements();
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserComboClientSheduler.getSelectedDate().getTimeInMillis());
        
        String parseComboboxSpec = comboBoxSpecClients.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        ResultSet rs = db.sendSelect("SELECT sp.datetime FROM medunica.shedule_personal sp WHERE DATE(datetime) = DATE('"+ dateTime +"')"
                + " AND sp.personal_id=(SELECT p.id FROM medunica.personal p WHERE p.family='"+parse[0]+"' && p.name='"+parse[1]+"' && p.patronomic='"+parse[2]+"')");
        try {
            while (rs.next()){
                dlmListClientSpecShedule.addElement(rs.getString("datetime"));
//                System.out.println(rs.getString("datetime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnilsSearchClient;
    private javax.swing.JComboBox<String> comboBoxClientShedule;
    private javax.swing.JComboBox<String> comboBoxSpecClients;
    private javax.swing.JComboBox<String> comboBoxSpes;
    private datechooser.beans.DateChooserCombo dateChooserComboClientSheduler;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JFormattedTextField formattedTextFieldFindSnilsClient;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinnerSetTime;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listClientShedule;
    private javax.swing.JList<String> listClientSpecShedule;
    private javax.swing.JList<String> listSheduleDay;
    // End of variables declaration//GEN-END:variables
}
