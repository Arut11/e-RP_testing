package erpApi;

import dataBase.DataBaseConnect;
import dto.Cancel;
import dto.Prescription;
import erpApi.client.PrescriptionClient;
import erpApi.testData.PrescriptionData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static junit.framework.Assert.assertEquals;

public class CreatePrescriptionTests {

    private DataBaseConnect dataBaseConnect;
    private PrescriptionClient prescriptionClient;
    private Prescription prescription;
    private PrescriptionData prescriptionData;
    private Cancel cancel;
    ValidatableResponse createResponse;
    ValidatableResponse cancelResponse;
    private int createStatusCode;
    private static final String REGISTERED_EXPECTED = "\"Registered\"";
    private static final String CANCEL_EXPECTED = "\"Canceled\"";
    private String guidPrescription;

    @BeforeEach
    public void setUp() {
        dataBaseConnect = new DataBaseConnect();
        prescriptionClient = new PrescriptionClient();
        prescription = new Prescription();
        cancel = new Cancel();
        prescriptionData = new PrescriptionData();

    }

    @AfterEach
    public void cleanUp() {
        guidPrescription = prescription.getUid();
        if (createStatusCode == HttpStatus.SC_OK) {
            String query = "DELETE FROM erp_prescription WHERE guid = '" + guidPrescription + "'";
            dataBaseConnect.executeUpdate(query);
        }

    }

    @Test
    @AllureId("20977")
    @Tag("eRP-Api-V2")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("A. Sargatyan")
    @DisplayName("Проверка создания рецепта")
    public void createPrescriptionTest() {
        prescription = prescriptionData.getCreatePrescriptionTestData();
        createResponse = prescriptionClient.createPrescription(prescription);
        createStatusCode = createResponse.extract().statusCode();
        String actualBody = createResponse.extract().asString();
        assertEquals("Статус код вернулся не 200",
                HttpStatus.SC_OK, createStatusCode);
        assertEquals("В ответе вернулось не 'Registered'",
                REGISTERED_EXPECTED, actualBody);

    }

    @Test
    @AllureId("21029")
    @Tag("eRP-Api-V2")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("A. Sargatyan")
    @DisplayName("Проверка отмены рецепта")
    public void cancelPrescriptionTest() {
    prescription = prescriptionData.getCreatePrescriptionTestData();
    createResponse = prescriptionClient.createPrescription(prescription);
    cancel = prescriptionData.getCancelPrescriptionTestData(prescription.getUid());
    cancelResponse = prescriptionClient.cancelPrescription(cancel);
    createStatusCode = cancelResponse.extract().statusCode();
    String actualBody = cancelResponse.extract().asString();
    assertEquals("Статус код вернулся не 200",
            HttpStatus.SC_OK, createStatusCode);
    assertEquals("В ответе вернулось не 'Canceled'",
            CANCEL_EXPECTED, actualBody);

    }

}
