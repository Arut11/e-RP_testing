package erpApiAdmin.testData;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CreateOrganizationWithoutRequiredFieldsWithParameterizedTestsData {

  static Faker fakerRu = new Faker(Locale.forLanguageTag("ru"));
  static OkatoData okatoData = new OkatoData();

  @Step("Не передаем обязательные поля")
  public static Object[][] getNegativeDataOrganizationTest() throws SQLException {
    return new Object[][]{
        {
            0,
            null,
            fakerRu.name().fullName(),
            fakerRu.number().digits(13),
            fakerRu.number().digits(10),
            fakerRu.regexify("[0-9]{7}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}"),
            fakerRu.phoneNumber().phoneNumber(),
            fakerRu.address().fullAddress(),
            fakerRu.address().latitude(),
            fakerRu.address().longitude(),
            fakerRu.internet().url(),
            okatoData.getAddOkato(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
            LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
        },
        {
            0,
            fakerRu.name().firstName(),
            fakerRu.name().fullName(),
            null,
            fakerRu.number().digits(10),
            fakerRu.regexify("[0-9]{7}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}"),
            fakerRu.phoneNumber().phoneNumber(),
            fakerRu.address().fullAddress(),
            fakerRu.address().latitude(),
            fakerRu.address().longitude(),
            fakerRu.internet().url(),
            okatoData.getAddOkato(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
            LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),

        },
        {
            0,
            fakerRu.name().firstName(),
            fakerRu.name().fullName(),
            fakerRu.number().digits(13),
            fakerRu.number().digits(10),
            null,
            fakerRu.phoneNumber().phoneNumber(),
            fakerRu.address().fullAddress(),
            fakerRu.address().latitude(),
            fakerRu.address().longitude(),
            fakerRu.internet().url(),
            okatoData.getAddOkato(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
            LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
        },
        {
            0,
            null,
            fakerRu.name().fullName(),
            null,
            fakerRu.number().digits(10),
            null,
            fakerRu.phoneNumber().phoneNumber(),
            fakerRu.address().fullAddress(),
            fakerRu.address().latitude(),
            fakerRu.address().longitude(),
            fakerRu.internet().url(),
            okatoData.getAddOkato(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
            LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),

        }

    };
  }

}
