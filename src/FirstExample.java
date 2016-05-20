import java.sql.*;

/**
 * Created by jjohnson on 5/20/2016.
 */
public class FirstExample {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    // Database credentials
    static final String USER = "jordan";
    static final String PASS = "Temp1234";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet results = statement.executeQuery(sql);

            // STEP 5 : Extract data from result set
            while (results.next()) {
                // Retrieve by column name
                int id = results.getInt("id");
                int age = results.getInt("age");
                String first = results.getString("first");
                String last = results.getString("last");

                // Display values
                System.out.println("ID: " + id);
                System.out.println(", Age: " + age);
                System.out.println(", First: " + first);
                System.out.println(", Last: " + last);
            }

            // STEP 6 : Clean-up environment
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            // Handle errors for Class.forName
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(statement != null)
                    statement.close();
            } catch(SQLException se2) {
                // nothing we can do
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }  // end main
} // end FirstExample
