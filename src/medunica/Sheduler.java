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
        listClientShedule = new javax.swing.JList<>();
        formattedTextFieldFindSnilsClient = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSpecClients = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listClientSpecShedule = new javax.swing.JList<>();
        comboBoxClientShedule = new javax.swing.JComboBox<>();
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

        jScrollPane1.setViewportView(listClientShedule);

        try {
            formattedTextFieldFindSnilsClient.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Специалист");

        comboBoxSpecClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSpecClientsActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listClientSpecShedule);

        comboBoxClientShedule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Расписание для" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(formattedTextFieldFindSnilsClient, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxClientShedule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSpecClients, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxClientShedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(formattedTextFieldFindSnilsClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboBoxSpecClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String prest= "SELECT * FROM clients WHERE snils='"+formattedTextFieldFindSnilsClient.getText()+"'";
        
        ResultSet rs = db.sendSelect(prest);
        
        try {
            if(rs.isBeforeFirst()){
                comboBoxClientShedule.removeAllItems();
                while (rs.next()){
                    comboBoxClientShedule.addItem(rs.getString("family") + " " + rs.getString("name") + " " + rs.getString("patronomic") + ", " + rs.getString("date_birth"));
//                String mov_name = rs.getString(2);
//                System.out.println(mov_name);
//                selectedID = rs.getString("id");
//                textFieldFamily.setText(rs.getString("family"));
//                textFieldName.setText(rs.getString("name"));
//                textFieldPatron.setText(rs.getString("patronomic"));
//                formattedTextFieldDateBirth.setText(rs.getString("date_birth"));
//                formattedTextFieldPasportSeries.setText(rs.getString("pasport_series"));
//                formattedTextFieldPasportNumber.setText(rs.getString("pasport_number"));
//                formattedTextFieldDateOfIssue.setText(rs.getString("date_of_issue"));
//                formattedTextFieldTelephone.setText(rs.getString("telephone"));
//                formattedTextFieldEmail.setText(rs.getString("email"));
//                textFieldIssuedBy.setText(rs.getString("issued_by"));
//                textFieldResidenceAddress.setText(rs.getString("residence_address"));
//                textFieldPermanentRegistration.setText(rs.getString("permanent_registration"));
//                textFieldIpr.setText(rs.getString("ipr"));
//                formattedTextFieldIprData.setText(rs.getString("ipr_date"));
//                comboBoxServiceForm.getModel().setSelectedItem(rs.getString("service_form"));
//                
//                comboBoxDisabilityGroup.getModel().setSelectedItem(rs.getString("disability_group"));
//                comboBoxPrimaryViolations.getModel().setSelectedItem(rs.getString("primary_violations"));
//                comboBoxRehabilitationFacilities.getModel().setSelectedItem(rs.getString("rehabilitation_facilities"));
//                comboBoxWelfareLavel.getModel().setSelectedItem(rs.getString("welfare_level"));
//                comboBoxEducation.getModel().setSelectedItem(rs.getString("education"));
//                comboBoxMaritalStatus.getModel().setSelectedItem(rs.getString("marital_status"));
//                textFieldCauseOfDisability.setText(rs.getString("cause_of_disability"));
//                formattedTextFieldDisabilityDate.setText(rs.getString("disability_date"));
//                textFieldPlaceOfWork.setText(rs.getString("place_of_work"));
//                spinnerNamberOfFamily.setValue(Integer.valueOf(rs.getString("number_family_members")));
//                spinnerNumberMinorChildren.setValue(Integer.valueOf(rs.getString("number_minor_children")));
//                
//                formattedTextFieldRecipientIncome12Months.setText(rs.getString("recipient_income12_months"));
//                formattedTextFieldSpousesIncome12Months.setText(rs.getString("spouses_income12_months"));
//                formattedTextFieldIncomeMotherFather.setText(rs.getString("income_mother_father"));
//                formattedTextFieldAmountIncomeAllFamily.setText(rs.getString("amount_income_all_family"));
//                formattedTextFieldAverageRevenue.setText(rs.getString("average_revenue"));
//                formattedTextFieldRecipientsPerCapitaIncome.setText(rs.getString("recipients_per_capitaIncome"));
//                formattedTextField75pRecipientIncome.setText(rs.getString("_75p_recipient_income"));
//                formattedTextFieldCapPerCapitaIncome.setText(rs.getString("cap_per_capita_income"));
//                formattedTextFieldDifferencePerCapitaIncome.setText(rs.getString("difference_per_capita_income"));
//                formattedTextFieldNumberDaysMonth.setText(rs.getString("number_days_month"));
//                formattedTextFieldActualNumberDays.setText(rs.getString("actual_number_days"));
//                formattedTextFieldContract24Days.setText(rs.getString("contract_24_days"));
//                formattedTextFieldActualContractAmount.setText(rs.getString("actual_contract_amount"));
//                comboBoxStatus_source_income_all.getModel().setSelectedItem(rs.getString("status_source_income_all"));
//                comboBoxSpousesIncome12Months.getModel().setSelectedItem(rs.getString("status_spouses_income_12_months"));
//                comboBoxIncomeMotherFather.getModel().setSelectedItem(rs.getString("status_income_mother_father"));
                System.out.println("!!!!!!!!!!!!!!!!");
                }
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println("Number of records: " + count);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBoxSpecClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpecClientsActionPerformed
        
    }//GEN-LAST:event_comboBoxSpecClientsActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxClientShedule;
    private javax.swing.JComboBox<String> comboBoxSpecClients;
    private javax.swing.JComboBox<String> comboBoxSpes;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
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
