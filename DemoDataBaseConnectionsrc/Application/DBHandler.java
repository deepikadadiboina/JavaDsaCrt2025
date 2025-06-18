package Application;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBHandler {
    public static void insertStudent(String name, String email) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (id, name, email) VALUES (student_seq.NEXTVAL, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


	