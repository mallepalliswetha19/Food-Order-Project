import java.sql.*;
import java.util.*;
import java.util.*;

public class DataBaseConnection {
    private final static String URL="jdbc:mysql://localhost:3306/youtube";
    private final static String USER="root";
    private final static String PASSWORD="Swetha@19";
    Scanner sc=new Scanner(System.in);

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);

    }
 public static boolean checkLoginCrediantals(String email, String password){
     try (Connection con = getConnection()) {
         String checkquery = "select * from person where email=? and password=?";
         PreparedStatement ps = con.prepareStatement(checkquery);
         ps.setString(1, email);
         ps.setString(2, password);
         ResultSet rs = ps.executeQuery();
         return rs.next();
     }
     catch (SQLException e) {
         e.printStackTrace();
         return false;
     }
 }
 public static void registerUser(String newEmail, String newPassword){
        try(Connection con=getConnection()) {
            String insertQuery = "insert into person (email,password) values (?,?)";
            PreparedStatement ps1 = con.prepareStatement(insertQuery);
            ps1.setString(1, newEmail);
            ps1.setString(2, newPassword);
             ps1.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

 }

}
