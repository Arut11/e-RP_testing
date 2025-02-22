package erpApi.enums.responsevalues;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PrescriptionResponseValue {

  REGISTERED_EXPECTED("\"Registered\"") ,
  CANCEL_EXPECTED("\"Canceled\""),
  DISPENSED_EXCEPTED("\"Dispensed\""),
  ANNULMENT_EXCEPTED("\"Annulmented\"");


  private final String value;

  @Override
  public String toString() {
    return value.toString();
  }

}
