package erpApi.client;

import restClient.RestClient;
import static io.restassured.RestAssured.given;

public class CryptoClient extends RestClient {

    private static final String CRYPTO_SERVICE_PATH = "http://192.168.7.54:81/api/crypto/DetachedSign";
    private static final String CERT_NUM = "01dac17c7517a4000000b4b400050001";

    public static String getDoctorSignature(String encodedData) {
        String requestBody = "\"" + encodedData + "\"";
        return given()
                .spec(getCryptoBaseSpec())
                .queryParams("numCert", CERT_NUM)
                .body(requestBody)
                .when()
                .post(CRYPTO_SERVICE_PATH)
                .then()
                .extract()
                .path("data");

    }

}