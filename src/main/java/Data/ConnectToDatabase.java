package Data;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectToDatabase {
    public List<Object[]> performSearch(String keyword) {
        List<Object[]> searchResults = new ArrayList<>();

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("dungthuy1978");
        ds.setServerName("diepcay");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Dictionary");
        ds.setEncrypt(false);

        try (Connection conn = ds.getConnection()) {
            String sql = "SELECT * FROM Dictionary WHERE Words LIKE ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + keyword + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String word = resultSet.getString(2);
                        String meaning = resultSet.getString(3);

                        searchResults.add(new Object[]{id, word, meaning});
                    }
                }
            }
            System.out.println("Search success");
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return searchResults;
    }

    public static Connection connect() {
        try {
            // Load JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://diepcay:1433;databaseName=Dictionary";

            String user = "sa";
            String password = "dungthuy1978";

            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        List<Object[]> wordList = connectToDatabase.performSearch(""); // Provide a search keyword if needed
        ListWordDatabase.main(wordList);
    }
}
