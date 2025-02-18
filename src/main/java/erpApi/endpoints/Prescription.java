package erpApi.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Prescription {

  PRESCRIPTION_LIST_COUNT_GET("/erp/erpApi/v2/prescription/list/count"),
  PRESCRIPTION_SHORT_LIST_GET("/erp/erpApi/v2/prescription/shortList"),
  PRESCRIPTION_PATIENT_LIST_GET("/erp/erpApi/v2/prescription/patientList"),
  PRESCRIPTION_UID_GET("/erp/erpApi/v2/prescription/{uid}"),
  PRESCRIPTION_UID_SEMDS_GET("/erp/erpApi/v2/prescription/{uid}/semds"),
  PRESCRIPTION_UID_SIGNATURES_GET("/erp/erpApi/v2/prescription/{uid}/signatures"),
  PRESCRIPTION_POST("/erp/erpApi/v2/prescription"),
  PRESCRIPTION_SEMD_POST("/erp/erpApi/v2/prescription/{uid}/semd"),
  PRESCRIPTION_CANCEL_PUT("/erp/erpApi/v2/prescription/cancel");

  private final String endpoint;

}
