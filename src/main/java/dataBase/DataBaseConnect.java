package dataBase;

import java.sql.*;

public class DataBaseConnect {

        private static final String DB_URL = "jdbc:postgresql://192.168.7.220:5432/erp_db_dev";
        private static final String DB_USER = "sa";
        private static final String DB_PASSWORD = "sagfhjkzYES!";

        private DatabaseHelper databaseHelper;

    public int executeUpdate(String query) {
        int affectedRows = 0;
        try (Connection connection = databaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            affectedRows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public String getData(String query, String... columns) {
        try (Connection connection = databaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                if (columns.length == 1) {
                    return resultSet.getString(columns[0]);
                } else {
                }
            } else {
                throw new RuntimeException("Не удалось получить данные из базы данных");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DataBaseConnect() {
        databaseHelper = new DatabaseHelper(DB_URL, DB_USER, DB_PASSWORD);

    }

}
