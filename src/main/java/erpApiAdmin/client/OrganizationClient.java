package erpApiAdmin.client;

import dto.Organization;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import restClient.RestClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static io.restassured.RestAssured.given;

public class OrganizationClient extends RestClient {

    private static final String ORGANIZATION_PATH = "/erp/admin/erpAdminApi/organizations";
    private static final String ORGANIZATION_ID_PATCH = "/erp/admin/erpAdminApi/organizations/{organizationId}";

    private static final Logger logger = LogManager.getLogger(OrganizationClient.class);

@Step("Создание организации")
    public ValidatableResponse createOrganization(Organization organization) {
        logger.info("Создание организации");
            return given()
                    .spec(getErpAdminBaseSpec())
                    .body(organization)
                    .when()
                    .post(ORGANIZATION_PATH)
                    .then();

    }

@Step("Удаление организации по id")
    public ValidatableResponse deleteOrganization(int organizationId) {
        logger.info("Удаление организации по id");
        return given()
                .spec(getErpAdminBaseSpec())
                .pathParam("organizationId", organizationId)
                .when()
                .delete(ORGANIZATION_ID_PATCH)
                .then();

    }

@Step("Получение организации по id")
    public ValidatableResponse getOrganization(int organizationId) {
        logger.info("Получение организации по id");
        return given()
                .spec(getErpAdminBaseSpec())
                .pathParam("organizationId", organizationId)
                .when()
                .get(ORGANIZATION_ID_PATCH)
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
                .put(ORGANIZATION_ID_PATCH)
                .then();

    }

}
