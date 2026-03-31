import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // بيانات الاتصال بقاعدة البيانات PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/university_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password"; 

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("✅ Erfolgreich mit PostgreSQL verbunden!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Verbindung fehlgeschlagen!");
            e.printStackTrace();
        }
    }
}
