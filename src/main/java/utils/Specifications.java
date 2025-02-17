package utils;

import static configs.ConfigSingle.cfg;
import static io.restassured.RestAssured.oauth2;
import static io.restassured.http.ContentType.JSON;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * <h3>Спецификации для e-RP API</h3>
 */

public class Specifications {

  /**
   * Спецификация для работы с методами e-RP V2
   */

  protected static RequestSpecification getBaseSpec() {
    return new RequestSpecBuilder()
        .setAuth(oauth2(getToken()))
        .setContentType(JSON)
        .setBaseUri(cfg.getErpUrl())
        .build();
  }

  /**
   * Спецификация для работы с методами e-RP Admin
   */

  protected static RequestSpecification getErpAdminBaseSpec() {
    return new RequestSpecBuilder()
        .setContentType(JSON)
        .setBaseUri(cfg.getErpUrl())
        .build();
  }

  /**
   * Спецификация для метода получения сигнатуры мед. работника
   */

  protected static RequestSpecification getCryptoBaseSpec() {
    return new RequestSpecBuilder()
        .setAccept(JSON)
        .setContentType(JSON)
        .setBaseUri(cfg.getErpUrl())
        .build();
  }

  /**
   * Метод получения токена для работы с e-RP V2
   */

  public static String getToken() {
    Response response = RestAssured.given()
        .contentType("application/x-www-form-urlencoded")
        .formParam("client_id", cfg.getClientId())
        .formParam("client_secret", cfg.getClientSecret())
        .formParam("grant_type", cfg.getGrantType())
        .post(cfg.getTokenUrl());
    return response.jsonPath().getString("access_token");
  }

}
