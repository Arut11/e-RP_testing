package erpAdminApiTests;

import dto.Okato;
import dto.Organization;
import erpApiAdmin.client.OrganizationClient;
import erpApiAdmin.testData.CreatingOrganizationWithoutUsingAdditionalFieldsCheckParametersData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static junit.framework.Assert.assertEquals;

public class CreateOrganizationWithoutUsingAdditionalFieldsParameterizedTests {

    private OrganizationClient organizationClient;
    private Organization organization;
    private int createStatusCode;
    private ValidatableResponse createResponse;

    @BeforeEach
    public void setUp() {
        organizationClient = new OrganizationClient();

    }

    @AfterEach
    public void cleanUp() {
        if (createStatusCode == HttpStatus.SC_OK) {
            int organizationId = createResponse.extract().path("id");
            ValidatableResponse deleteResponse = organizationClient.deleteOrganization(organizationId);
            int deleteStatusCode = deleteResponse.extract().statusCode();
            assertEquals("Статус код вернулся не 200 при удалении организации",
                    HttpStatus.SC_OK, deleteStatusCode);

        }
    }


    public static Object[][] getOrganizationParameterizedTests() {
        return CreatingOrganizationWithoutUsingAdditionalFieldsCheckParametersData.getPositiveDataOrganizationTest();

    }


    @ParameterizedTest
    @AllureId("20927")
    @Tag("eRP-Admin-Api")
    @Severity(SeverityLevel.NORMAL)
    @Owner("A. Sargatyan")
    @MethodSource("getOrganizationParameterizedTests")
    @DisplayName("Проверка создания организации без передачи необязательных полей")
    public void createOrganizationWithoutUsingAdditionalFieldsParameterizedTest(int id, String name, String fullName, String ogrn, String inn, String federalOid,
                                                        String phone, String address, String latitude, String longitude, String setWebsiteUrl,
                                                        Okato okato, String dateBegin, String dateEnd) {
        organization = new Organization()
                .setId(id)
                .setName(name)
                .setFullName(fullName)
                .setOgrn(ogrn)
                .setInn(inn)
                .setFederalOid(federalOid)
                .setPhone(phone)
                .setAddress(address)
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setWebsiteUrl(setWebsiteUrl)
                .setOkato(okato)
                .setDateBegin(dateBegin)
                .setDateEnd(dateEnd);

        createResponse = organizationClient.createOrganization(organization);
        createStatusCode = createResponse.extract().statusCode();
        Organization responseOrganization = createResponse.extract().as(Organization.class);
        int idFromResponse = createResponse.extract().path("id");
        organization.setId(idFromResponse);
        assertEquals("Статус код вернулся не 200 при создании организации",
                HttpStatus.SC_OK, createStatusCode);
        assertEquals("Тело ответа вернулось некорректное, либо одно из полей сохранилось неверно",
                organization, responseOrganization);

        System.out.println(responseOrganization);

    }

}
