import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jjohnson on 5/20/2016.
 */
public class CoffeTables {

    public static void viewTables(Connection connection, String dbName) throws SQLException {

        Statement statement = null;
        String query = "SELECT" +
                "COF_NAME, SUP_ID, PRICE, " + "SALES, TOTAL " +
                "from " + dbName + ".COFFES";

        try {
            statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String coffeename = results.getString("COF_NAME");
                int supplierID = results.getInt("SUP_ID");
                float price = results.getFloat("PRICE");
                int sales = results.getInt("SALES");
                int total = results.getInt("TOTAL");
                System.out.println(coffeename + "\t" + supplierID +
                        "\t" + price + "\t" + sales +
                        "\t" + total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public static void main(String[] args) {


    }
}
