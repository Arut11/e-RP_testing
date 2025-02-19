package erpApi;


import static erpApi.enums.responsevalues.PrescriptionResponseValue.DISPENSED_EXCEPTED;
import static erpApi.enums.responsevalues.PrescriptionResponseValue.REGISTERED_EXPECTED;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataBase.DataBaseConnect;
import erpApi.controllers.PrescriptionController;
import erpApi.controllers.ReleaseController;
import erpApi.testData.PrescriptionData;
import erpApi.testData.ReleaseData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import models.Cancel;
import models.Prescription;
import models.Release;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Epic("e-RP V2")
@Story("Методы Release")
@Tags({@Tag("e-RP"), @Tag("Работа с отпуском рецептов")})
@Owner("A. Cherednikov")
 class ReleaseTests {

  private DataBaseConnect dataBaseConnect;
  private PrescriptionController prescriptionClient = new PrescriptionController();
  private Prescription prescription = new Prescription();
  private Release relese = new Release();
  private ReleaseData releaseData = new ReleaseData();
  private ReleaseController releaseClient = new ReleaseController();
  private PrescriptionData prescriptionData = new PrescriptionData();
 ValidatableResponse createPrescription;
 ValidatableResponse createRelease;
 ValidatableResponse cancelResponse;
 private int createStatusCode;
 private String guidPrescription;
 private String tempResponce;

  @BeforeEach
  public  void setUp() {
    dataBaseConnect = new DataBaseConnect();
  }

  @AfterEach
  public   void cleanUp() {
    guidPrescription = prescription.getUid();
    if (createStatusCode == HttpStatus.SC_OK) {
      String query = "DELETE FROM erp_prescription WHERE guid = '" + guidPrescription + "'";
      dataBaseConnect.executeUpdate(query);
    }
  }

  @Test
  @AllureId("22228")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Cherednikov")
  @DisplayName("Создание отпуска рецепта")
  public  void createRelease() throws JsonProcessingException {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createPrescription = prescriptionClient.createPrescription(prescription);
    guidPrescription = prescription.getUid();
    relese = releaseData.getCreateReleaseTestData(prescription.getUid());
    createRelease = releaseClient.createRelease(relese);
    createStatusCode = createRelease.extract().statusCode();
    String actualBody = createRelease.extract().asString();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals(DISPENSED_EXCEPTED.toString(), actualBody,
        "В ответе вернулось не 'Dispensed'");
  }
}
