package erpApi;


import static erpApi.enums.responsevalues.PrescriptionResponseValue.ANNULMENT_EXCEPTED;
import static erpApi.enums.responsevalues.PrescriptionResponseValue.DISPENSED_EXCEPTED;

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
import models.Prescription;
import models.Release;
import models.ReleaseAnnulmentRequest;
import models.ReleaseCancelDto;
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
  private ReleaseAnnulmentRequest releseWithAnnulment = new ReleaseAnnulmentRequest();
  private ReleaseData releaseData = new ReleaseData();
  private ReleaseController releaseClient = new ReleaseController();
  private PrescriptionData prescriptionData = new PrescriptionData();
  private ReleaseCancelDto releaseCancel = new ReleaseCancelDto();
 ValidatableResponse createPrescription;
 ValidatableResponse createRelease;
 ValidatableResponse cancelResponse;
 private int createStatusCode;
 private String guidPrescription;

  @BeforeEach
  public  void setUp() {
  }

  @AfterEach
  public   void cleanUp() {
    dataBaseConnect = new DataBaseConnect();
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
  public void createRelease() throws JsonProcessingException {
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

  @Test
  @AllureId("22233")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Cherednikov")
  @DisplayName("Отмена ошибочного отпуска")
  public void cancelRelease() throws JsonProcessingException {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createPrescription = prescriptionClient.createPrescription(prescription);
    guidPrescription = prescription.getUid();
    relese = releaseData.getCreateReleaseTestData(prescription.getUid());
    createRelease = releaseClient.createRelease(relese);
    releaseCancel = releaseData.getCancelReleaseTestData(relese.getLocalUid());
    cancelResponse = releaseClient.cancelRelease(releaseCancel);
    createStatusCode = cancelResponse.extract().statusCode();
    String actualBody = cancelResponse.extract().asString();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals(relese.getLocalUid(), actualBody,
        "В ответе вернулось не localUID");
  }

  @Test
  @AllureId("22232")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Cherednikov")
  @DisplayName("Регистрация отпуска рецепта с аннулированием")
  public void annulmentRelease() throws JsonProcessingException {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createPrescription = prescriptionClient.createPrescription(prescription);
    guidPrescription = prescription.getUid();
    releseWithAnnulment = releaseData.getAnnulmentReleaseTestData(prescription.getUid());
    createRelease = releaseClient.createAnnulmentRelease(releseWithAnnulment);
    createStatusCode = createRelease.extract().statusCode();
    String actualBody = createRelease.extract().asString();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals(ANNULMENT_EXCEPTED.toString(), actualBody,
        "В ответе вернулось не 'Аnnulmented'");
  }

}
