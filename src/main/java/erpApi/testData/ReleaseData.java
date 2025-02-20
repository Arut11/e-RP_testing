package erpApi.testData;


import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import models.Release;
import models.ReleaseCancelDto;

public class ReleaseData {
  Faker fakerRu = new Faker(Locale.forLanguageTag("ru"));

  public Release getCreateReleaseTestData(String uid) {
    return new Release()
        .setLocalUid(fakerRu.internet().uuid())
        .setPrescriptionUid(uid)
        .setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
        .setOrganization(new OrganizationData().getOrganization())
        .setSubdivision(new SubdivisionData().getSubdivision())
        .setPharmacist(new PharmacistData().getPharmacist())
        .setMedicationDispense(new MedicationDispenseData().getMedicationDispense())
        .setSigna("Принимать 1 шт перорально 1 раз в день в течение 1 дня")
        .setSoftware("autotestik");
  }

  public ReleaseCancelDto getCancelReleaseTestData(String localUid) {
    return new ReleaseCancelDto()
        .setLocalUid(localUid)
        .setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
        .setAuthor(new PharmacistData().getPharmacist())
        .setReason("autoooo");
  }
}
