package erpApiAdmin.controllers;

import static erpApiAdmin.endpoints.Organizations.ORGANIZATION_ID;
import static erpApiAdmin.endpoints.Organizations.ORGANIZATION_POST;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.Organization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Specifications;

public class OrganizationController extends Specifications {

  private static final Logger logger = LogManager.getLogger(OrganizationController.class);

  @Step("Создание организации")
  public ValidatableResponse createOrganization(Organization organization) {
    logger.info("Создание организации");
    return given()
        .spec(getErpAdminBaseSpec())
        .body(organization)
        .post(ORGANIZATION_POST.getEndpoint())
        .then();
  }

  @Step("Удаление организации по id")
  public ValidatableResponse deleteOrganization(int organizationId) {
    logger.info("Удаление организации по id");
    return given()
        .spec(getErpAdminBaseSpec())
        .pathParam("organizationId", organizationId)
        .delete(ORGANIZATION_ID.getEndpoint())
        .then();
  }

  @Step("Получение организации по id")
  public ValidatableResponse getOrganization(int organizationId) {
    logger.info("Получение организации по id");
    return given()
        .spec(getErpAdminBaseSpec())
        .pathParam("organizationId", organizationId)
        .when()
        .get(ORGANIZATION_ID.getEndpoint())
        .then();
  }

  @Step("Изменение данных организации")
  public ValidatableResponse putOrganization(Organization organization, int organizationId) {
    logger.info("Изменение данных организации");
    return given()
        .spec(getErpAdminBaseSpec())
        .body(organization)
        .pathParam("organizationId", organizationId)
        .when()
        .put(ORGANIZATION_ID.getEndpoint())
        .then();
  }

}
