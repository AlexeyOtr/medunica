package medunica;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

// 1. Конфиг для настройки подключения к БД

public class DataBase {

    private Connection conn = null;

    // pth - строка пути к базе и параметрами подключения
    // l - логин      p - пароль
    public DataBase(String pth, String us, String pass) {
        if(loadDriverDB()){
            try {
                conn = DriverManager.getConnection(pth + "&user=" + us + "&password="+ pass);
            } catch (SQLException ex) {
                System.err.println("SQLException: " + ex.getMessage());
                System.err.println("SQLState: " + ex.getSQLState());
                System.err.println("VendorError: " + ex.getErrorCode());
                Component frame = null;
                JOptionPane.showMessageDialog(frame,"Ошибка подключения к БД","ОШИБКА",JOptionPane.ERROR_MESSAGE); 
                System.exit(0);
            }
        }
    }
    
    // Подключение драйвера (коннектора) MySQL
    private boolean loadDriverDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            return true;
            } catch (Exception ex) {
                System.err.println("Ошибка загрузки драйвера БД " + ex);
                Component frame = null;
                JOptionPane.showMessageDialog(frame,"Ошибка загрузки драйвера БД","ОШИБКА",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                return false;
            }
    }
    
    // Отправка запроса к БД, возвращает результат запроса
    public ResultSet sendSelect(String query){
            try {
                Statement stmt = conn.createStatement();
                return stmt.executeQuery(query);
            } catch (SQLException ex) {
                System.err.println("Ошибка запроса к БД " + ex);
                Component frame = null;
                JOptionPane.showMessageDialog(frame,"Ошибка отправки запроса","ОШИБКА",JOptionPane.ERROR_MESSAGE);
                return null;
            }
    }
    
    // Отправка запроса к БД, INSERT
    public boolean sendInsert(String query){
            try {
                Statement stmt = conn.createStatement();
                stmt.execute(query);
                return true;
            } catch (SQLException ex) {
                System.err.println("Ошибка запроса к БД");
                return false;
            }
    }
    
    // Отправка запроса к БД, UPDATE
    public boolean sendUpdate(String query){
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                return true;
            } catch (SQLException ex) {
                System.err.println("Ошибка запроса к БД UPDATE");
                return false;
            }
    }
    
    // Отправка запроса на удаление данных
    public boolean sendDelete(String query){
        try {
                Statement stmt = conn.createStatement();
                stmt.execute(query);
                return true;
            } catch (SQLException ex) {
                System.err.println("Ошибка запроса к БД при удалении данных");
                return false;
            }
    }
}
