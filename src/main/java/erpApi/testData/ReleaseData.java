package erpApi.testData;


import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import models.Release;

public class ReleaseData {
  Faker fakerRu = new Faker(Locale.forLanguageTag("ru"));

  public Release getCreateReleaseTestData(String uid) {
    return new Release()
        .setLocalUid(fakerRu.internet().uuid())
        .setPrescriptionUid(uid)
        .setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
        .setOrganization(new OrganizationData().getOrganization())
        .setSubdivision("1.2.643.5.1.13.13.12.2.31.2847.0.112753")
        .setPharmacist(new PharmacistData().getPharmacist())
        .setMedicationDispense(new MedicationDispenseData().getMedicationDispense())
        .setSigna("Принимать 1 шт перорально 1 раз в день в течение 1 дня")
        .setSoftware("autotestik");
  }
}
