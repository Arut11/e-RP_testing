package erpApi.testData;

import models.ReleasePharmacist;

public class PharmacistData {

  public ReleasePharmacist getPharmacist() {
    return new ReleasePharmacist()
        .setName("Ирина")
        .setSurname("Безкруглова")
        .setPatronymic("Константиновна")
        .setSnils("06950154572")
        .setFrmrMedicalStaffPostCode(231);
  }
}
