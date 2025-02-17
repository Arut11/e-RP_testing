package dataBase;

import static configs.ConfigSingle.cfg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnect {

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
    databaseHelper = new DatabaseHelper(
        cfg.getDatabaseUrl(),
        cfg.getDatabaseLogin(),
        cfg.getDatabasePassword());

  }

}
