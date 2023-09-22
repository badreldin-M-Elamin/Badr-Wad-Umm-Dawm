
import java.sql.*;

public class PgDBConnect1 {


    private final String url = "jdbc:postgresql://localhost/postJavaDB";
    private final String user = "postgres";
    private final String password = "1234";

    public Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            System.out.println("Welcome to Postgrsql!");
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "SELECT * FROM \"javaDB\".table5"
            );
            int ID;
            String Description;
            while (resultSet.next()){
                ID = resultSet.getInt("ID");
                Description = resultSet.getString("Description").trim();
                System.out.println("ID :" + ID + "Description :" + Description);

            }
            System.out.println("Thank You and Goodby!");
            resultSet.close();
            statement.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {
        PgDBConnect1 pgDB = new PgDBConnect1();
                     pgDB.connect();
    }
}