package ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloDB {

    static String DB_URL = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.uzfqtmeirzyioxrfjniw&password=Hjxbc4hiHc8u9Jjq";
    static String QUERY = "select * from websites";

    public static void main(String[] args) {
            // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.println(", domain: " + rs.getString("domain"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }


}
