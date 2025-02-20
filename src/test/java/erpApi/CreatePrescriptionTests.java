package erpApi;

import static erpApi.enums.responsevalues.PrescriptionResponseValue.CANCEL_EXPECTED;
import static erpApi.enums.responsevalues.PrescriptionResponseValue.REGISTERED_EXPECTED;

import dataBase.DataBaseConnect;
import erpApi.controllers.PrescriptionController;
import erpApi.testData.PrescriptionData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import models.PrescriptionCancel;
import models.Prescription;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Epic("e-RP V2")
@Story("Методы Prescription")
@Tags({@Tag("e-RP"), @Tag("Работа с рецептами")})
@Owner("A.Sargatyan")
public class CreatePrescriptionTests {

  private DataBaseConnect dataBaseConnect;
  private PrescriptionController prescriptionClient;
  private Prescription prescription;
  private PrescriptionData prescriptionData;
  private PrescriptionCancel cancelReciepe;
  ValidatableResponse createResponse;
  ValidatableResponse cancelResponse;
  private int createStatusCode;
  private String guidPrescription;

  @BeforeEach
  public void setUp() {
    dataBaseConnect = new DataBaseConnect();
    prescriptionClient = new PrescriptionController();
    prescription = new Prescription();
    cancelReciepe = new PrescriptionCancel();
    prescriptionData = new PrescriptionData();
  }

  @AfterEach
  public void cleanUp() {
    guidPrescription = prescription.getUid();
    if (createStatusCode == HttpStatus.SC_OK) {
      String query = "DELETE FROM erp_prescription WHERE guid = '" + guidPrescription + "'";
      dataBaseConnect.executeUpdate(query);
    }
  }

  @Test
  @AllureId("20977")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan")
  @DisplayName("Создание рецепта")
  public void createPrescriptionTest() {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createResponse = prescriptionClient.createPrescription(prescription);
    createStatusCode = createResponse.extract().statusCode();
    String actualBody = createResponse.extract().asString();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals(REGISTERED_EXPECTED.toString(), actualBody,
        "В ответе вернулось не 'Registered'");
  }

  @Test
  @AllureId("21029")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan")
  @DisplayName("Отмена рецепта")
  public void cancelPrescriptionTest() {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createResponse = prescriptionClient.createPrescription(prescription);
    cancelReciepe = prescriptionData.getCancelPrescriptionTestData(prescription.getUid());
    cancelResponse = prescriptionClient.cancelPrescription(cancelReciepe);
    createStatusCode = cancelResponse.extract().statusCode();
    String actualBody = cancelResponse.extract().asString();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals(CANCEL_EXPECTED.toString(), actualBody,
        "В ответе вернулось не 'Canceled'");
  }

  @Test
  @AllureId("21016")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan")
  @DisplayName("Получение данных рецепта")
  public void getRecipeData() {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createResponse = prescriptionClient.createPrescription(prescription);
    guidPrescription = prescription.getUid();
    createResponse = prescriptionClient.getPrescriptionByUid(guidPrescription);
    createStatusCode = createResponse.extract().statusCode();
    Prescription prescriptionResponse = createResponse.extract().as(Prescription.class);
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals(prescription, prescriptionResponse,
        "Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно");
  }

  @Test
  @AllureId("21028")
  @Tag("eRP-Api-V2")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan, A. Cherednikov")
  @DisplayName("Получение количества рецептов по фильтру")
  public void getRecipeCount() {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createResponse = prescriptionClient.createPrescription(prescription);
    guidPrescription = prescription.getUid();
    createResponse = prescriptionClient.getRecipeCountByFilter(guidPrescription);
    createStatusCode = createResponse.extract().statusCode();
    String count = createResponse.extract().asString();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200");
    Assertions.assertEquals("1", count,
        "Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно");
  }
}
