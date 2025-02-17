package erpApi.controllers;

import static configs.ConfigSingle.cfg;
import static io.restassured.RestAssured.given;

import utils.Specifications;

/**
 * <h3>Для работы методами сервиса подписи</h3>
 */
public class CryptoController extends Specifications {

  public static String getDoctorSignature(String encodedData) {
    String requestBody = "\"" + encodedData + "\"";
    return given()
        .spec(getCryptoBaseSpec())
        .queryParams("numCert", cfg.getDoctorCertificateNumber())
        .body(requestBody)
        .when()
        .post(cfg.getCryptoServiceUrl())
        .then()
        .extract()
        .path("data");
  }

}