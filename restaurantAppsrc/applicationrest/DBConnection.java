package applicationrest;

import java.sql.*;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "deepika");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
