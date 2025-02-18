package erpApiAdmin.testData;

import com.github.javafaker.Faker;
import dataBase.DataBaseConnect;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;
import models.Okato;

public class OkatoData {

  DataBaseConnect dataBaseConnect = new DataBaseConnect();
  static Faker faker = new Faker(Locale.forLanguageTag("ru"));

  private int generateId() {
    return faker.number().numberBetween(1, 5690);
  }

  public Okato getAddOkato() throws SQLException {
    int id = generateId();
    String query = "SELECT * FROM erp_okato WHERE id = " + id;
    Map<String, String> value = dataBaseConnect.getSelectData(query, "code", "name");
    return new Okato()
        .setId(id)
        .setCode(value.get("code"))
        .setName(value.get("name"));
  }

}
