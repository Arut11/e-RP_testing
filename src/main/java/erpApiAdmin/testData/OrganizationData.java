package erpApiAdmin.testData;

import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import models.Organization;

public class OrganizationData extends Organization {

  static Faker fakerRu = new Faker(Locale.forLanguageTag("ru"));
  Faker fakerUS = new Faker(Locale.US);
  OkatoData okatoData;

  public Organization getCreateOrganizationTestData() throws SQLException {
    okatoData = new OkatoData();
    return new Organization()
        .setId(super.getId())
        .setName(fakerRu.name().firstName())
        .setFullName(fakerRu.name().fullName())
        .setOgrn(fakerRu.number().digits(13))
        .setInn(fakerRu.number().digits(10))
        .setFederalOid(fakerRu.regexify("[0-9]{7}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}"))
        .setPhone(fakerRu.phoneNumber().phoneNumber())
        .setAddress(fakerRu.address().fullAddress())
        .setLatitude(fakerRu.address().latitude())
        .setLongitude(fakerRu.address().longitude())
        .setWebsiteUrl(fakerRu.internet().url())
        .setOkato(okatoData.getAddOkato())
        .setDateBegin(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
        .setDateEnd(
            LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
  }

}
