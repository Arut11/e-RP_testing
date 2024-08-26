package restClient;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.oauth2;
import static io.restassured.http.ContentType.JSON;

public class RestClient {

    private static final String BASE_URL = "http://192.168.7.238/dev/";
    private static final String TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjNTBoWDBpSEtxVTNaM1lUVzVZTGtqVEdsMWx3NE8xOURYR2JieGoyZGRZIn0.eyJleHAiOjE3MjQ3NDQ1ODksImlhdCI6MTcyNDcwODU4OSwianRpIjoiZmQ3MTg2OGItYzM5Ny00YThiLTllYjMtM2JmYjNmNTYwNGU0IiwiaXNzIjoiaHR0cHM6Ly9hdXRoLmRldi5wZDE1LnNvbC5tdHAvYXV0aC9yZWFsbXMvUnQzMVJzZXJBdXRoIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjljOWQwMTNjLWVhMTEtNDdkNi1iMmYyLWZlYzA3ODk3YTE2YiIsInR5cCI6IkJlYXJlciIsImF6cCI6InNvZnRydXN0X3BoYXJtYWN5IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXJ0MzFyc2VyYXV0aCIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJvZ3JuIjoiMTAyMzEwMTMzOTAzMCIsImNsaWVudEhvc3QiOiIxNzIuMjguNjIuNjkiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImNsaWVudElkIjoic29mdHJ1c3RfcGhhcm1hY3kiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtc29mdHJ1c3RfcGhhcm1hY3kiLCJjbGllbnRBZGRyZXNzIjoiMTcyLjI4LjYyLjY5In0.KRjAGU4Ypu4hfCIAkS47oH1PbdovH-FA5xIrfQy0qIgz3NL6hy_Z9y78LN0p4wbHIk6e8PTdIJnSY4bhcPHJOWRJddct-IBbHZPsNwFr_K5fRqK0I1MvUmq46Tn55zp5CNqrDRRmptLEaSrQqsBh1SyInGdnqzzFkhlF9S67CvAftKLTQA1aKg6wfhIleFDMw7y87KBWC57xJfuLHajXgtf7EGhIKkv_TMTk1-t0dNVdaVafgxkhkPZinReIMOR41jsVfFuRYOdVz6Lx0INU_MQ0V18Vlpga-J23TL2gQUIOTEgm80U0sVv19WR5F6QviWQ709UIYo4-uRSLhcBXyg";

    private static final String TOKEN_URL = "https://auth.dev.pd15.sol.mtp/auth/realms/Rt31RserAuth/protocol/openid-connect/token";
    private static final String CLIENT_ID = "softrust_pharmacy";
    private static final String CLIENT_SECRET = "0KVfu0wSoc6zkFFSDcPoLFSg5E08VECe";
    private static final String GRANT_TYPE = "client_credentials";

    protected static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setAuth(oauth2(TOKEN))
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();

    }

    protected static RequestSpecification getErpAdminBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();

    }

    protected static RequestSpecification getCryptoBaseSpec() {
        return new RequestSpecBuilder()
                .setAccept(JSON)
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();

    }

    public static String getToken() {
        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLIENT_SECRET)
                .formParam("grant_type", GRANT_TYPE)
                .post(TOKEN_URL);
            return response.jsonPath().getString("access_token");

    }

}
