package erpApi.controllers;

import static erpApi.endpoints.Release.RELEASE_ANNULMENT_POST;
import static erpApi.endpoints.Release.RELEASE_POST;
import static erpApi.endpoints.Release.RELEASE_PUT;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Base64;
import models.Release;
import models.ReleaseAnnulmentRequest;
import models.ReleaseCancelDto;
import models.ReleaseV2;
import utils.Specifications;

public class ReleaseController extends Specifications {

  //private final Gson gson = new Gson();
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Step("Регистрация отпуска рецепта")
  public ValidatableResponse createRelease(Release release) throws JsonProcessingException {
    String jsonRelease = objectMapper.writeValueAsString(release);
    //String jsonRelease = gson.toJson(release);
    String encodedData = Base64.getEncoder().encodeToString(jsonRelease.getBytes());
    String pharmacistSignature = CryptoController.getDoctorSignature(encodedData);
    ReleaseV2 releaseV2 = new ReleaseV2()
        .setData(encodedData)
        .setPharmacistSignature(pharmacistSignature);
    //String requestBody = gson.toJson(releaseV2);
    String requestBody = objectMapper.writeValueAsString(releaseV2);
    return given()
        .spec(getBaseSpec())
        .body(requestBody)
        .when()
        .post(RELEASE_POST.getEndpoint())
        .then();
  }

  @Step("Отмена ошибочного отпуска")
  public ValidatableResponse cancelRelease(ReleaseCancelDto releaseCancel) throws JsonProcessingException {
    String jsonRelease = objectMapper.writeValueAsString(releaseCancel);
    String encodedData = Base64.getEncoder().encodeToString(jsonRelease.getBytes());
    String pharmacistSignature = CryptoController.getDoctorSignature(encodedData);
    ReleaseV2 releaseV2 = new ReleaseV2()
        .setData(encodedData)
        .setPharmacistSignature(pharmacistSignature);
    String requestBody = objectMapper.writeValueAsString(releaseV2);
    return given()
        .spec(getBaseSpec())
        .body(requestBody)
        .when()
        .put(RELEASE_PUT.getEndpoint())
        .then();
  }

  @Step("Регистрация отпуска рецепта с аннулированием")
  public ValidatableResponse createAnnulmentRelease(ReleaseAnnulmentRequest releseWithAnnulment) throws JsonProcessingException {
    String jsonRelease = objectMapper.writeValueAsString(releseWithAnnulment);
    //String jsonRelease = gson.toJson(release);
    String encodedData = Base64.getEncoder().encodeToString(jsonRelease.getBytes());
    String pharmacistSignature = CryptoController.getDoctorSignature(encodedData);
    ReleaseV2 releaseV2 = new ReleaseV2()
        .setData(encodedData)
        .setPharmacistSignature(pharmacistSignature);
    //String requestBody = gson.toJson(releaseV2);
    String requestBody = objectMapper.writeValueAsString(releaseV2);
    return given()
        .spec(getBaseSpec())
        .body(requestBody)
        .when()
        .post(RELEASE_ANNULMENT_POST.getEndpoint())
        .then();
  }
}
