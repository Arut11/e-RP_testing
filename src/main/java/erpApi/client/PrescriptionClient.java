package erpApi.client;

import dto.Prescription;
import dto.PrescriptionV2;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import restClient.RestClient;
import com.google.gson.Gson;
import java.util.Base64;

import static io.restassured.RestAssured.given;

public class PrescriptionClient extends RestClient {

    private static final String PRESCRIPTION_LIST_COUNT_PATH = "/erp/erpApi/v2/prescription/list/count";
    private static final String PRESCRIPTION_SHORT_LIST_PATH = "/erp/erpApi/v2/prescription/shortList";
    private static final String PRESCRIPTION_PATIENT_LIST_PATH = "/erp/erpApi/v2/prescription/patientList";
    private static final String PRESCRIPTION_UID_PATH = "/erp/erpApi/v2/prescription/{uid}";
    private static final String PRESCRIPTION_UID_SEMDS_PATH = "/erp/erpApi/v2/prescription/{uid}/semds";
    private static final String PRESCRIPTION_UID_SIGNATURES_PATH = "/erp/erpApi/v2/prescription/{uid}/signatures";
    private static final String PRESCRIPTION_PATH = "/erp/erpApi/v2/prescription";
    private static final String PRESCRIPTION_SEMD_PATH = "/erp/erpApi/v2/prescription/{uid}/semd";
    private static final String PRESCRIPTION_CANCEL_PATH = "/erp/erpApi/v2/prescription/cancel";

    private final Gson gson = new Gson();

   @Step("Регистрация нового рецепта/назначения")
   public ValidatableResponse createPrescription(Prescription prescription) {
       String jsonPrescription = gson.toJson(prescription);
       String encodedData = Base64.getEncoder().encodeToString(jsonPrescription.getBytes());
       String doctorSignature = CryptoClient.getDoctorSignature(encodedData);
       PrescriptionV2 prescriptionV2 = new PrescriptionV2()
               .setData(encodedData)
               .setDoctorSignature(doctorSignature);
       String requestBody = gson.toJson(prescriptionV2);
           return given()
                   .spec(getBaseSpec())
                   .body(requestBody)
                   .when()
                   .post(PRESCRIPTION_PATH)
                   .then();

   }

    @Step("Получение списка рецептов/назначений")
    public ValidatableResponse getPrescriptionByUid(String uid) {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(PRESCRIPTION_UID_PATH, uid)
                .then();
    }

}
