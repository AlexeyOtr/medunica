package medunica;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdminForm extends javax.swing.JFrame {

    DataBase db = null;
    
    public AdminForm() {
        initComponents();
        // подключение к базе
        db = new DataBase("jdbc:mysql://localhost/medunica?character_set_server=utf8mb4&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor");
        System.out.println(db);
        comboBoxSpec.removeAllItems();
        comboBoxSpecAdd.removeAllItems();
        
        ResultSet rs = db.sendSelect("SELECT * FROM spec");
        try {
            while (rs.next()){
                comboBoxSpec.addItem(rs.getString("spec_name"));
                comboBoxSpecAdd.addItem(rs.getString("spec_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelAddUser = new javax.swing.JPanel();
        textFieldFamily = new javax.swing.JTextField();
        lblFamily = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        lblPatron = new javax.swing.JLabel();
        textFieldPatron = new javax.swing.JTextField();
        comboBoxSpecAdd = new javax.swing.JComboBox<>();
        lblSpec = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        lblSnils = new javax.swing.JLabel();
        formattedTextFieldSnils = new javax.swing.JFormattedTextField();
        btnRemoveUser = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        lblPassRepet = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordFieldRepet = new javax.swing.JPasswordField();
        btnSearchUserSnils = new javax.swing.JButton();
        btnReloudComboSpec = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        textFieldSpec = new javax.swing.JTextField();
        btnAddSpec = new javax.swing.JButton();
        comboBoxSpec = new javax.swing.JComboBox<>();
        btnRemoveSpec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("МЕДУНИЦА АДМИНИСТРАТОР");

        lblFamily.setText("Фамилия");

        lblName.setText("Имя");

        lblPatron.setText("Отчество");

        comboBoxSpecAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "массажист" }));

        lblSpec.setText("Специальность");

        btnAddUser.setText("ДОБАВИТЬ");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        lblSnils.setText("СНИЛС");

        try {
            formattedTextFieldSnils.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnRemoveUser.setText("УДАЛИТЬ");
        btnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUserActionPerformed(evt);
            }
        });

        lblPass.setText("Пароль");

        lblPassRepet.setText("Повтор");

        btnSearchUserSnils.setText("jButton2");
        btnSearchUserSnils.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUserSnilsActionPerformed(evt);
            }
        });

        btnReloudComboSpec.setText("jButton2");
        btnReloudComboSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloudComboSpecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddUserLayout = new javax.swing.GroupLayout(panelAddUser);
        panelAddUser.setLayout(panelAddUserLayout);
        panelAddUserLayout.setHorizontalGroup(
            panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddUserLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAddUserLayout.createSequentialGroup()
                        .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAddUserLayout.createSequentialGroup()
                        .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPassRepet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSnils, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPatron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSpec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFamily, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldFamily)
                            .addComponent(textFieldName)
                            .addComponent(textFieldPatron)
                            .addComponent(passwordField)
                            .addComponent(passwordFieldRepet)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddUserLayout.createSequentialGroup()
                                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxSpecAdd, javax.swing.GroupLayout.Alignment.LEADING, 0, 151, Short.MAX_VALUE)
                                    .addComponent(formattedTextFieldSnils))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchUserSnils, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReloudComboSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(98, 98, 98))
        );
        panelAddUserLayout.setVerticalGroup(
            panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddUserLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldFamily, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFamily))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatron)
                    .addComponent(textFieldPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSpecAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpec)
                    .addComponent(btnReloudComboSpec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSnils)
                    .addComponent(formattedTextFieldSnils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchUserSnils))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassRepet)
                    .addComponent(passwordFieldRepet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Добавить сотрудника", panelAddUser);

        btnAddSpec.setText("Добавить");
        btnAddSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSpecActionPerformed(evt);
            }
        });

        comboBoxSpec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRemoveSpec.setText("Удалить");
        btnRemoveSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSpecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxSpec, 0, 354, Short.MAX_VALUE)
                    .addComponent(textFieldSpec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddSpec, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(btnRemoveSpec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSpec))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveSpec))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Специальность", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Кнопка добавления сотрудника
    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        Component frame = null;
        if(passwordField.getPassword().equals("Поле ввода пароля не должно быть пустым")){ // Если поле пустое, то выдать сообщение пользователю об ошибке
            System.out.println("Поле ввода пароля не должно быть пустым");
            JOptionPane.showMessageDialog(frame,"Необходимо заполнить все поля","ВНИМАНИЕ",JOptionPane.WARNING_MESSAGE);
        } else if(passwordField.getPassword().equals(passwordFieldRepet.getPassword())){ // в случае совпадения паролей
            if(formattedTextFieldSnils.isEditValid()){
                // запись в БД данных о новом пользователе системы 
                if(db.sendInsert("INSERT INTO medunica.personal (family, name, patronomic, spec_id, snils, pass) "
                    + "VALUES ('"+textFieldFamily.getText()+"', '"+textFieldName.getText()+"', '"+textFieldPatron.getText()+"', (SELECT id FROM medunica.spec WHERE spec_name='"+comboBoxSpecAdd.getSelectedItem().toString()+"'), '"+formattedTextFieldSnils.getText()+"', '"+passwordField.getText()+"')")){
                    // Очистка полей ввода
                    textFieldFamily.setText(""); 
                    textFieldName.setText("");
                    textFieldPatron.setText("");
                    formattedTextFieldSnils.setText("");
                    passwordField.setText("");
                    passwordFieldRepet.setText("");
                    System.out.println("Данные успешно добавлены");
                    JOptionPane.showMessageDialog(frame,"Данные успешно добавлены","",JOptionPane.INFORMATION_MESSAGE);
                } else{
                    System.out.println("Ошибка отправки данных в БД, скорее всего совпадение СНИЛС");
                    JOptionPane.showMessageDialog(frame,"Ошибка отправки данных в БД\nскорее всего совпадение СНИЛС","ВНИМАНИЕ",JOptionPane.WARNING_MESSAGE);
                }
            } else{
                System.out.println("Не заполнено поле СНИЛС");
                JOptionPane.showMessageDialog(frame,"Не заполнено поле СНИЛС","ВНИМАНИЕ",JOptionPane.WARNING_MESSAGE);
            }
        } else{
            System.out.println("Введённые пароли не совпадают");
            JOptionPane.showMessageDialog(frame,"Введённые пароли не совпадают","ВНИМАНИЕ",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAddUserActionPerformed

    // Кнопка добавления специальности
    private void btnAddSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpecActionPerformed
        Component frame = null;
        if(textFieldSpec.getText().equals("")){
            System.out.println("НЕ заполнено поле спец");
            JOptionPane.showMessageDialog(frame,"НЕ заполнено поле спец","ВНИМАНИЕ",JOptionPane.WARNING_MESSAGE);
        } else if(db.sendInsert("INSERT INTO medunica.spec (spec_name) VALUES ('"+textFieldSpec.getText()+"')")){
            JOptionPane.showMessageDialog(frame,"Специальность " + textFieldSpec.getText()+" добавлена","",JOptionPane.INFORMATION_MESSAGE);
            textFieldSpec.setText("");
        }
        
        comboBoxSpec.removeAllItems();
        ResultSet rs = db.sendSelect("SELECT * FROM spec");
        try {
            while (rs.next()){
                comboBoxSpec.addItem(rs.getString("spec_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAddSpecActionPerformed

    //  Кнопка удаления специальности
    private void btnRemoveSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSpecActionPerformed
        
        Component frame = null;
        
        if(db.sendDelete("DELETE FROM medunica.spec WHERE spec_name='"+comboBoxSpec.getSelectedItem().toString()+"'")){
            JOptionPane.showMessageDialog(frame,"Специальность " + comboBoxSpec.getSelectedItem().toString()+" удалена","",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame,"Специальность "+ comboBoxSpec.getSelectedItem().toString()+" удалить не удалось","ВНИМАНИЕ",JOptionPane.WARNING_MESSAGE);
        }
        
        comboBoxSpec.removeAllItems();
        ResultSet rs = db.sendSelect("SELECT * FROM spec");
        try {
            while (rs.next()){
                comboBoxSpec.addItem(rs.getString("spec_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveSpecActionPerformed

    // Удаление пользователя
    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUserActionPerformed
        
        Component frame = null;
        
        if(formattedTextFieldSnils.isEditValid()){
            if(db.sendDelete("DELETE FROM medunica.personal WHERE snils='"+formattedTextFieldSnils.getText()+"'")){
                // Очистка полей ввода
                        textFieldFamily.setText(""); 
                        textFieldName.setText("");
                        textFieldPatron.setText("");
                        formattedTextFieldSnils.setText("");
                        passwordField.setText("");
                        passwordFieldRepet.setText("");
                System.out.println("Пользователь успешно удалён");
                JOptionPane.showMessageDialog(frame,"Пользователь успешно удалён","",JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Пользователь НЕ удалён");
                JOptionPane.showMessageDialog(frame,"Пользователь НЕ удалён","",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame,"Не выбран пользователь для удаления","",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRemoveUserActionPerformed

    // Кнопка поиска пользователя по СНИЛС
    private void btnSearchUserSnilsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserSnilsActionPerformed
        
        ResultSet rs = db.sendSelect("SELECT family, name, patronomic, snils, spec_name FROM personal INNER JOIN spec ON spec_id=spec.id WHERE snils='"+formattedTextFieldSnils.getText()+"'");
        try {
            while (rs.next()){
                textFieldFamily.setText(rs.getString("family"));
                textFieldName.setText(rs.getString("name"));
                textFieldPatron.setText(rs.getString("patronomic"));
                comboBoxSpecAdd.setSelectedItem(rs.getString("spec_name"));
                formattedTextFieldSnils.setText(rs.getString("snils"));
                System.out.println("SNILS " + formattedTextFieldSnils.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSearchUserSnilsActionPerformed

    // Кнопка обновления комбо бокса специальностей
    private void btnReloudComboSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloudComboSpecActionPerformed
        comboBoxSpecAdd.removeAllItems();
        ResultSet rs = db.sendSelect("SELECT * FROM spec");
        try {
            while (rs.next()){
                comboBoxSpecAdd.addItem(rs.getString("spec_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReloudComboSpecActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSpec;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnReloudComboSpec;
    private javax.swing.JButton btnRemoveSpec;
    private javax.swing.JButton btnRemoveUser;
    private javax.swing.JButton btnSearchUserSnils;
    private javax.swing.JComboBox<String> comboBoxSpec;
    private javax.swing.JComboBox<String> comboBoxSpecAdd;
    private javax.swing.JFormattedTextField formattedTextFieldSnils;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFamily;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPassRepet;
    private javax.swing.JLabel lblPatron;
    private javax.swing.JLabel lblSnils;
    private javax.swing.JLabel lblSpec;
    private javax.swing.JPanel panelAddUser;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordFieldRepet;
    private javax.swing.JTextField textFieldFamily;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldPatron;
    private javax.swing.JTextField textFieldSpec;
    // End of variables declaration//GEN-END:variables
}
