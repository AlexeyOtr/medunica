package medunica;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
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
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextDirection;

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
            //ResultSet rs = db.sendSelect("SELECT family, name, patronomic, spec_name FROM personal INNER JOIN spec ON spec_id=spec.id WHERE status='медперсонал';");
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
        jButtonPrintSheduleClient = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblSetSheduleFor = new javax.swing.JLabel();
        dateChooserPanelPersonal = new datechooser.beans.DateChooserPanel();
        comboBoxSpes = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSheduleDay = new javax.swing.JList<>();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        spinnerSetTime = new javax.swing.JSpinner(sm);
        jLabel3 = new javax.swing.JLabel();
        btnAddShedule = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("МЕДУНИЦА РАСПИСАНИЕ");

        dateChooserComboClientSheduler.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserComboClientShedulerOnCommit(evt);
            }
        });

        listClientShedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientSheduleMouseClicked(evt);
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

        jButtonPrintSheduleClient.setText("Печать расписания");
        jButtonPrintSheduleClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintSheduleClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxClientShedule, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(formattedTextFieldFindSnilsClient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSnilsSearchClient, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateChooserComboClientSheduler, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonPrintSheduleClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(comboBoxSpecClients, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(formattedTextFieldFindSnilsClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSnilsSearchClient))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jButton1))
                    .addComponent(dateChooserComboClientSheduler, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxClientShedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSpecClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrintSheduleClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Клиенты", jPanel1);

        lblSetSheduleFor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSetSheduleFor.setText("Установка расписания для");

        dateChooserPanelPersonal.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserPanelPersonalOnSelectionChange(evt);
            }
        });
        dateChooserPanelPersonal.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserPanelPersonalOnCommit(evt);
            }
        });

        comboBoxSpes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSpesActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(listSheduleDay);

        jLabel3.setText("Время работы: ");

        btnAddShedule.setText("Добавить");
        btnAddShedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSheduleActionPerformed(evt);
            }
        });

        btnRemove.setText("Удалить");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
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
                        .addComponent(spinnerSetTime, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddShedule, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserPanelPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSetSheduleFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxSpes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSetSheduleFor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSpes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(dateChooserPanelPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerSetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddShedule)
                    .addComponent(btnRemove))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        JSpinner.DateEditor de = new JSpinner.DateEditor(spinnerSetTime, "HH:mm");
        spinnerSetTime.setEditor(de);

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

    private void dateChooserPanelPersonalOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserPanelPersonalOnCommit
        
        try {
            updateListPersonSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanelPersonalOnCommit

    private void btnAddSheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSheduleActionPerformed
        
        //defaultListModel.addElement(new SimpleDateFormat("HH:mm").format(jSpinnerSetTime.getValue()));
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserPanelPersonal.getSelectedDate().getTimeInMillis());
        dateTime += " " + new SimpleDateFormat("HH:mm").format(spinnerSetTime.getValue());
        
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
    }//GEN-LAST:event_btnAddSheduleActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
       
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
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void dateChooserPanelPersonalOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanelPersonalOnSelectionChange
        
        try {
            updateListPersonSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanelPersonalOnSelectionChange

    private void comboBoxSpesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpesActionPerformed
        
        try {
            updateListPersonSheduleDay();
        } catch (ParseException ex) {
            Logger.getLogger(Sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboBoxSpesActionPerformed

    // Кнопка поиска клиента по снилс
    private void btnSnilsSearchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnilsSearchClientActionPerformed
        
        comboBoxClientShedule.removeAllItems();
        
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

    // Обработчик комбо бокса специальности в окне расписания для клиентов
    private void comboBoxSpecClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpecClientsActionPerformed
        updateListClientSpecShedule();
    }//GEN-LAST:event_comboBoxSpecClientsActionPerformed

    // Обработчик выбора даты в расписании клиентов
    private void dateChooserComboClientShedulerOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserComboClientShedulerOnCommit
        updateListClientSpecShedule();
        updateListClientShedule();
    }//GEN-LAST:event_dateChooserComboClientShedulerOnCommit

    // Обработчик двойного клика по времени работы специалиста в списке jList
    private void listClientSpecSheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientSpecSheduleMouseClicked
        
        if (evt.getClickCount() == 2) {
            
            String parseComboboxSpec = comboBoxSpecClients.getSelectedItem().toString();
            String[] parse = parseComboboxSpec.split("[ ,]+");
            
            db.sendInsert("INSERT INTO medunica.nomination (client_id, personal_id, datetime) VALUES ((SELECT c.id FROM clients c WHERE c.snils='"+ formattedTextFieldFindSnilsClient.getText() +"' ), (SELECT p.id FROM personal p WHERE p.family='"+ parse[0] +"' AND p.name='"+ parse[1] +"' AND p.patronomic='"+ parse[2] +"'), '"+ listClientSpecShedule.getSelectedValue().toString() +"');");
            db.sendUpdate("UPDATE medunica.shedule_personal sp SET sp.client_id=(SELECT c.id FROM clients c WHERE c.snils='"+formattedTextFieldFindSnilsClient.getText()+"') WHERE sp.personal_id=(SELECT p.id FROM personal p WHERE p.family='"+parse[0]+"' AND p.name='"+parse[1]+"' AND p.patronomic='"+parse[2]+"') AND sp.datetime='"+ listClientSpecShedule.getSelectedValue().toString() +"'");

            updateListClientSpecShedule();
            updateListClientShedule();
            
        }
    }//GEN-LAST:event_listClientSpecSheduleMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateListClientShedule();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Обработчик двойного клика по расписанию клиента для удаления
    private void listClientSheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientSheduleMouseClicked
        if (evt.getClickCount() == 2) {
            
            String parseComboboxSpec = comboBoxSpecClients.getSelectedItem().toString();
            String[] parse = parseComboboxSpec.split("[ ,]+");
            
            String parseListClientShedule = listClientShedule.getSelectedValue();
            String[] pars = parseListClientShedule.split("[ ,каб.№]+");
            
            System.out.println(pars[0]);
            System.out.println(pars[1]);
            System.out.println(pars[2]);

            db.sendDelete("DELETE FROM medunica.nomination WHERE datetime='"+ pars[0] +" "+ pars[1] +"' AND client_id=(SELECT c.id FROM medunica.clients c WHERE c.snils='"+ formattedTextFieldFindSnilsClient.getText() +"')");
            db.sendUpdate("UPDATE medunica.shedule_personal sp SET sp.client_id=NULL WHERE sp.datetime='"+ pars[0] +" "+ pars[1] +"' AND sp.client_id=(SELECT c.id FROM medunica.clients c WHERE c.snils='"+ formattedTextFieldFindSnilsClient.getText() +"')");
            
            updateListClientSpecShedule();
            updateListClientShedule();
            
        }
    }//GEN-LAST:event_listClientSheduleMouseClicked

    private void jButtonPrintSheduleClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintSheduleClientActionPerformed
        try {
            FileOutputStream fos = new FileOutputStream(new File("Расписание для клиента.docx"));
            
            XWPFDocument myNewDoc = new XWPFDocument();

            // Добавляется нумерация страниц
            CTP ctp = CTP.Factory.newInstance();
            //this add page number incremental
            ctp.addNewR().addNewPgNum();

            XWPFParagraph codePara = new XWPFParagraph(ctp, myNewDoc);
            XWPFParagraph[] paragraphs = new XWPFParagraph[1];
            paragraphs[0] = codePara;
            //position of number
            codePara.setAlignment(ParagraphAlignment.RIGHT);

            CTSectPr sectPr = myNewDoc.getDocument().getBody().addNewSectPr();


            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(myNewDoc, sectPr);
            headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, paragraphs);


            CTPageMar pageMar = sectPr.addNewPgMar();
            pageMar.setLeft(BigInteger.valueOf(1200L));
            pageMar.setTop(BigInteger.valueOf(423L));
            pageMar.setRight(BigInteger.valueOf(567L));
            pageMar.setBottom(BigInteger.valueOf(285L));


            XWPFParagraph parag1 = myNewDoc.createParagraph();
            XWPFRun run1 = parag1.createRun();
            XWPFRun run01 = parag1.createRun();
            
            run1.setText("Государственное автономное учреждение социального обслуживания Краснодарского края");
            run01.setText("«Краевой комплексный центр реабилитации инвалидов «Медуница»");
            run01.addBreak();
            run01.addBreak();
            run01.setText("Расписание для ");
            parag1.setAlignment(ParagraphAlignment.CENTER);
            run1.setFontFamily("Times New Roman");
            run1.setFontSize(13);
            run1.setBold(true);
            run1.addBreak();
            parag1.setSpacingAfter(1000);
            run01.setFontFamily("Times New Roman");
            run01.setFontSize(13);
            run01.setBold(true);
            run01.addBreak();
            // ТАБЛИЦА
            XWPFTable table10 = myNewDoc.createTable();

            XWPFTableRow table10RowOne = table10.getRow(0);

            XWPFRun run10t1 =  table10RowOne.getCell(0).addParagraph().createRun();
            run10t1.setFontFamily("Times New Roman"); run10t1.setFontSize(12); run10t1.setText(" № п/п ");
            table10RowOne.getCell(0).removeParagraph(0);

            String s10 = "";

            for (int i = 1; i <= 7; i++) {
                if (i == 1) {
                    s10 = " Дата";
                } else if (i == 2) {
                    s10 = " АД/утро";
                } else if (i == 3) {
                    s10 = " АД/вечер";
                } else if (i == 4) {
                    s10 = " PS утро";
                } else if (i == 5) {
                    s10 = " PS вечер";
                } else if (i == 6) {
                    s10 = " T утром";
                } else if (i == 7) {
                    s10 = " T вечер";
                } else s10 = " ";
                XWPFRun run10t2 = table10RowOne.addNewTableCell().addParagraph().createRun();
                run10t2.setFontFamily("Times New Roman");
                run10t2.setFontSize(12);
                run10t2.setText(s10);
                table10RowOne.getCell(i).removeParagraph(0);

            }
            for (int i = 0; i < 8; i++) {
                table10RowOne.getCell(i).setWidth("1500");
            }

//            table1RowOne.setHeight(300);
//            table1RowOne.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

            for (int i = 1; i <= 29; i++) {
                String s1 = "";
                if (i == 0) {
                    s1 = "1. Диета";
                } else
                if (i == 1) {
                    s1 = "2. ЛФК";
                } else
                if (i == 2) {
                    s1 = "3. Консультация физиотерапевта";
                } else {
                    s1 = " ";
                }
                XWPFTableRow table10RowTwo = table10.createRow();
                table10RowTwo.setHeight(250);
                table10RowTwo.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

                XWPFRun run10t01 = table10RowTwo.getCell(0).addParagraph().createRun();
                run10t01.setFontFamily("Times New Roman");
                run10t01.setFontSize(12);
                run10t01.setText(" " + String.valueOf(i));
                table10RowTwo.getCell(0).removeParagraph(0);


            }

            myNewDoc.write(fos);
            fos.close();

            System.out.println("Document created");
            
           // java.lang.Process builder = new ProcessBuilder("C:\\Program Files (x86)\\Microsoft Office\\Office16\\WINWORD.exe", "ReabilitationCard.docx").start();
        } catch (Exception e) {
            System.out.println("Something is wrong");
        }
    }//GEN-LAST:event_jButtonPrintSheduleClientActionPerformed

    // Обновление данных времени работы при установке расписания работы сотрудников
    private void updateListPersonSheduleDay() throws ParseException{
        
        dlmListSheduleDayPerson.removeAllElements();
        
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(dateChooserPanelPersonal.getSelectedDate().getTimeInMillis());
        
        String parseComboboxSpec = comboBoxSpes.getSelectedItem().toString();
        String[] parse = parseComboboxSpec.split("[ ,]+");
        
        ResultSet rs = db.sendSelect("SELECT sp.datetime FROM medunica.shedule_personal sp WHERE DATE(datetime) = DATE('"+ dateTime +"')"
                + " AND sp.personal_id=(SELECT p.id FROM medunica.personal p WHERE p.family='"+parse[0]+"' && p.name='"+parse[1]+"' && p.patronomic='"+parse[2]+"')");
        try {
            while (rs.next()){
                dlmListSheduleDayPerson.addElement(rs.getString("datetime"));
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
        
        //ResultSet rs = db.sendSelect("SELECT n.datetime FROM medunica.nomination n INNER JOIN medunica.clients c ON n.client_id=c.id AND c.snils='"+formattedTextFieldFindSnilsClient.getText()+"' AND DATE(n.datetime) = DATE('"+ dateTime +"')");
        ResultSet rs = db.sendSelect("SELECT n.datetime, p.family, c1.number, s.spec_name\n" +
            " FROM medunica.nomination n \n" +
            " INNER JOIN medunica.clients c ON n.client_id=c.id AND c.snils='"+ formattedTextFieldFindSnilsClient.getText() +"' AND DATE(n.datetime) = DATE('"+ dateTime +"') \n" +
            " INNER JOIN medunica.personal p ON n.personal_id=p.id\n" +
            " INNER JOIN medunica.cabinet c1 ON p.kabinet_id=c1.id\n" +
            " INNER JOIN medunica.spec s ON p.spec_id=s.id");
        try {
            while (rs.next()){
                dlmListClientShedule.addElement(rs.getString("datetime") + ", каб.№" + rs.getString("number"));
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
        
        ResultSet rs = db.sendSelect("SELECT sp.datetime, sp.client_id FROM medunica.shedule_personal sp WHERE DATE(datetime) = DATE('"+ dateTime +"')"
                + " AND sp.personal_id=(SELECT p.id FROM medunica.personal p WHERE p.family='"+parse[0]+"' && p.name='"+parse[1]+"' && p.patronomic='"+parse[2]+"') AND sp.client_id IS NULL");
        try {
            while (rs.next()){
                dlmListClientSpecShedule.addElement(rs.getString("datetime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddShedule;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSnilsSearchClient;
    private javax.swing.JComboBox<String> comboBoxClientShedule;
    private javax.swing.JComboBox<String> comboBoxSpecClients;
    private javax.swing.JComboBox<String> comboBoxSpes;
    private datechooser.beans.DateChooserCombo dateChooserComboClientSheduler;
    private datechooser.beans.DateChooserPanel dateChooserPanelPersonal;
    private javax.swing.JFormattedTextField formattedTextFieldFindSnilsClient;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPrintSheduleClient;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSetSheduleFor;
    private javax.swing.JList<String> listClientShedule;
    private javax.swing.JList<String> listClientSpecShedule;
    private javax.swing.JList<String> listSheduleDay;
    private javax.swing.JSpinner spinnerSetTime;
    // End of variables declaration//GEN-END:variables
}
