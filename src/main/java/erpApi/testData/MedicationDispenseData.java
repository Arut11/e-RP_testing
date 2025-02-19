package erpApi.testData;

import models.MedicationDispense;

public class MedicationDispenseData {

  public MedicationDispense getMedicationDispense(){
    return new MedicationDispense()
        .setName("Метформин, табл. пролонг., 750 мг")
        .setCode("21.20.10.119-000001-1-00093-2000000743440")
        .setHandbook("esklp")
        .setCount(1)
        .setPrice(1.1F);
  }
}
