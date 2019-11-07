package medunica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
                return false;
            }
    }
    
}
