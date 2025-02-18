package erpApi.controllers;

import static erpApi.endpoints.Prescription.PRESCRIPTION_CANCEL_PUT;
import static erpApi.endpoints.Prescription.PRESCRIPTION_LIST_COUNT_GET;
import static erpApi.endpoints.Prescription.PRESCRIPTION_POST;
import static erpApi.endpoints.Prescription.PRESCRIPTION_UID_GET;
import static io.restassured.RestAssured.given;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Base64;
import models.Cancel;
import models.Prescription;
import models.PrescriptionV2;
import utils.Specifications;

public class PrescriptionController extends Specifications {

  private final Gson gson = new Gson();

  @Step("Регистрация нового рецепта/назначения")
  public ValidatableResponse createPrescription(Prescription prescription) {
    String jsonPrescription = gson.toJson(prescription);
    String encodedData = Base64.getEncoder().encodeToString(jsonPrescription.getBytes());
    String doctorSignature = CryptoController.getDoctorSignature(encodedData);
    PrescriptionV2 prescriptionV2 = new PrescriptionV2()
        .setData(encodedData)
        .setDoctorSignature(doctorSignature);
    String requestBody = gson.toJson(prescriptionV2);
    return given()
        .spec(getBaseSpec())
        .body(requestBody)
        .when()
        .post(PRESCRIPTION_POST.getEndpoint())
        .then();
  }

  @Step("Отмена рецепта/назначения")
  public ValidatableResponse cancelPrescription(Cancel cancel) {
    String jsonCancel = gson.toJson(cancel);
    String encodedData = Base64.getEncoder().encodeToString(jsonCancel.getBytes());
    String doctorSignature = CryptoController.getDoctorSignature(encodedData);
    PrescriptionV2 prescriptionV2 = new PrescriptionV2()
        .setData(encodedData)
        .setDoctorSignature(doctorSignature);
    String requestBody = gson.toJson(prescriptionV2);
    return given()
        .spec(getBaseSpec())
        .body(requestBody)
        .when()
        .put(PRESCRIPTION_CANCEL_PUT.getEndpoint())
        .then();

  }

  @Step("Получить данные рецепта/назначения")
  public ValidatableResponse getPrescriptionByUid(String uid) {
    return given()
        .spec(getBaseSpec())
        .when()
        .get(PRESCRIPTION_UID_GET.getEndpoint(), uid)
        .then();
  }

  @Step("Получение количества рецептов по фильтру")
  public ValidatableResponse getRecipeCountByFilter(String filter) {
    return given()
        .spec(getBaseSpec())
        .when()
        .queryParam("Uid", filter)
        .get(PRESCRIPTION_LIST_COUNT_GET.getEndpoint())
        .then();
  }
}
