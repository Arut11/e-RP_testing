package dataBase;

import static configs.ConfigSingle.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

  private Connection DatabaseHelper() throws SQLException {
    return DriverManager.getConnection(
        cfg.getDatabaseUrl(),
        cfg.getDatabaseLogin(),
        cfg.getDatabasePassword());
  }

  public Connection getConnection() throws SQLException {
    return DatabaseHelper();
  }

}
