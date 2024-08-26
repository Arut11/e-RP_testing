package erpAdminApiTests;

import dto.Organization;
import erpApiAdmin.client.OrganizationClient;
import erpApiAdmin.testData.OrganizationData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import static junit.framework.Assert.assertEquals;

public class OrganizationTests {

    private OrganizationClient organizationClient;
    private OrganizationData organizationTestDate;
    private Organization organization;
    private int createStatusCode;
    private ValidatableResponse createResponse;
    private boolean deleteTest;


    @BeforeEach
    public void setUp() {
        organizationClient = new OrganizationClient();
        organizationTestDate = new OrganizationData();
        organization = organizationTestDate.getCreateOrganizationTestData();
        createResponse = organizationClient.createOrganization(organization);

    }

    @AfterEach
    public void cleanUp() {
        if (createStatusCode == HttpStatus.SC_OK && deleteTest) {
            int organizationId = createResponse.extract().path("id");
            ValidatableResponse deleteResponse = organizationClient.deleteOrganization(organizationId);
            int deleteStatusCode = deleteResponse.extract().statusCode();
            assertEquals("Статус код вернулся не 200 при удалении организации",
                    HttpStatus.SC_OK, deleteStatusCode);

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
    int id = createResponse.extract().path("id");
    organization.setId(id);
    assertEquals("Статус код вернулся не 200 при создании организации",
            HttpStatus.SC_OK, createStatusCode);
    assertEquals("Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно",
            organization, responseOrganization);

    }

    @Test
    @AllureId("20924")
    @Tag("eRP-Admin-Api")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("A. Sargatyan")
    @DisplayName("Проверка редактирования созданной организации")
    public void putOrganizationTest() {
        int id = createResponse.extract().path("id");
        organization = organizationTestDate.getCreateOrganizationTestData();
        organization.setId(id);
        createResponse = organizationClient.putOrganization(organization, id);
        Organization putResponse = createResponse.extract().as(Organization.class);
        createStatusCode = createResponse.extract().statusCode();
        assertEquals("Статус код вернулся не 200 при создании организации",
                HttpStatus.SC_OK, createStatusCode);
        assertEquals("Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно",
                organization,  putResponse);

    }

    @Test
    @AllureId("20925")
    @Tag("eRP-Admin-Api")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("A. Sargatyan")
    @DisplayName("Проверка удаления созданной организации")
    public void deleteOrganizationTest() {
        int organizationId = createResponse.extract().path("id");
        ValidatableResponse deleteResponse = organizationClient.deleteOrganization(organizationId);
        int deleteStatusCode = deleteResponse.extract().statusCode();
        assertEquals("Статус код вернулся не 200 при удалении организации",
                HttpStatus.SC_OK, deleteStatusCode);
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
        ValidatableResponse getResponse = organizationClient.getOrganization(organizationId);
        Organization Response = getResponse.extract().as(Organization.class);
        int getStatusCode = getResponse.extract().statusCode();
        assertEquals("Статус код вернулся не 200 при удалении организации",
                HttpStatus.SC_OK, getStatusCode);
        assertEquals("Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно",
                organization,  Response);

    }

}
