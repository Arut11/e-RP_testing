package erpApi.controllers;

import static erpApi.endpoints.Release.RELEASE_POST;
import static io.restassured.RestAssured.given;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Base64;
import models.Release;
import models.ReleaseV2;
import utils.Specifications;

public class ReleaseController extends Specifications {

  private final Gson gson = new Gson();

  @Step("Регистрация отпуска рецепта")
  public ValidatableResponse createRelease(Release release) {
    String jsonRelease = gson.toJson(release);
    String encodedData = Base64.getEncoder().encodeToString(jsonRelease.getBytes());
    String pharmacistSignature = CryptoController.getDoctorSignature(encodedData);
    ReleaseV2 releaseV2 = new ReleaseV2()
        .setData(encodedData)
        .setPharmacistSignature(pharmacistSignature);
    String requestBody = gson.toJson(releaseV2);
    return given()
        .spec(getBaseSpec())
        .body(requestBody)
        .when()
        .post(RELEASE_POST.getEndpoint())
        .then();
  }


}
