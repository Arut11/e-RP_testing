package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataBaseConnect {

  private DatabaseHelper databaseHelper = new DatabaseHelper();

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

  public String getSelectData(String query, String column) throws SQLException  {
    String code = null;
    try (Connection connection = databaseHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      if (resultSet.next()) {
        code = resultSet.getString(column);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return code;
  }

  public Map<String, String> getSelectData(String query, String... columns) throws SQLException {
    Map<String, String> result = new HashMap<>();
    try (Connection connection = databaseHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      if (resultSet.next()) {
        for (String column : columns) {
          result.put(column, resultSet.getString(column));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

}
