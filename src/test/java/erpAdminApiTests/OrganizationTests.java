package erpAdminApiTests;

import java.sql.SQLException;
import models.Organization;
import erpApiAdmin.controllers.OrganizationController;
import erpApiAdmin.testData.OrganizationData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OrganizationTests {

  private OrganizationController organizationController;
  private OrganizationData organizationTestDate;
  private Organization organization;
  private int createStatusCode;
  private ValidatableResponse createResponse;
  private boolean deleteTest;


  @BeforeEach
  public void setUp() throws SQLException {
    organizationController = new OrganizationController();
    organizationTestDate = new OrganizationData();
    organization = organizationTestDate.getCreateOrganizationTestData();
    createResponse = organizationController.createOrganization(organization);
  }

  @AfterEach
  public void cleanUp() {
    if (createStatusCode == HttpStatus.SC_OK && deleteTest) {
      int organizationId = createResponse.extract().path("id");
      ValidatableResponse deleteResponse = organizationController.deleteOrganization(organizationId);
      int deleteStatusCode = deleteResponse.extract().statusCode();
      Assertions.assertEquals(HttpStatus.SC_OK, deleteStatusCode,
          "Статус код вернулся не 200 при удалении организации");
    }
  }

  @Test
  @AllureId("20923")
  @Tag("eRP-Admin-Api")
  @Severity(SeverityLevel.BLOCKER)
  @Owner("A. Sargatyan")
  @DisplayName("Проверка создания организации")
  public void createOrganizationTest() {
    createStatusCode = createResponse.extract().statusCode();
    Organization responseOrganization = createResponse.extract().as(Organization.class);

    String responseBody = createResponse.extract().asString();
    System.out.println("Тело ответа: " + responseBody);

    int id = createResponse.extract().path("id");
    organization.setId(id);
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200 при создании организации");
    Assertions.assertEquals(organization, responseOrganization,
        "Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно");
  }

  @Test
  @AllureId("20924")
  @Tag("eRP-Admin-Api")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan")
  @DisplayName("Проверка редактирования созданной организации")
  public void putOrganizationTest() throws SQLException {
    int id = createResponse.extract().path("id");
    organization = organizationTestDate.getCreateOrganizationTestData();
    organization.setId(id);
    createResponse = organizationController.putOrganization(organization, id);
    Organization putResponse = createResponse.extract().as(Organization.class);
    String responseBody = createResponse.extract().asString();
    System.out.println("Тело ответа: " + responseBody);
    createStatusCode = createResponse.extract().statusCode();
    Assertions.assertEquals(HttpStatus.SC_OK, createStatusCode,
        "Статус код вернулся не 200 при создании организации");
    Assertions.assertEquals(organization, putResponse,
        "Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно");
  }

  @Test
  @AllureId("20925")
  @Tag("eRP-Admin-Api")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan")
  @DisplayName("Проверка удаления созданной организации")
  public void deleteOrganizationTest() {
    int organizationId = createResponse.extract().path("id");
    ValidatableResponse deleteResponse = organizationController.deleteOrganization(organizationId);
    int deleteStatusCode = deleteResponse.extract().statusCode();
    Assertions.assertEquals(HttpStatus.SC_OK, deleteStatusCode,
        "Статус код вернулся не 200 при удалении организации");
    deleteTest = false;
  }

  @Test
  @AllureId("20926")
  @Tag("eRP-Admin-Api")
  @Severity(SeverityLevel.CRITICAL)
  @Owner("A. Sargatyan")
  @DisplayName("Проверка получения ранее созданной организации")
  public void getOrganizationTest() {
    int organizationId = createResponse.extract().path("id");
    organization.setId(organizationId);
    ValidatableResponse getResponse = organizationController.getOrganization(organizationId);
    Organization Response = getResponse.extract().as(Organization.class);
    int getStatusCode = getResponse.extract().statusCode();
    Assertions.assertEquals(HttpStatus.SC_OK, getStatusCode,
        "Статус код вернулся не 200 при удалении организации");
    Assertions.assertEquals(organization, Response,
        "Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно");
  }

}
