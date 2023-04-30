import java.net.URL;
import java.security.DrbgParameters.Reseed;
import java.sql.*;

public class dataconn {

    public static void main(String[] args) {

        String url = "jdbc:mysql:///database1";
        String username = "root";
        String password = "abhijite";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            // connection colpleted

            Statement s = conn.createStatement();
            String query = "select * from students";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
