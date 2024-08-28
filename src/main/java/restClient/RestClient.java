package restClient;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.oauth2;
import static io.restassured.http.ContentType.JSON;

public class RestClient {

    private static final String BASE_URL = "http://192.168.7.238/dev/";
    private static final String TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjNTBoWDBpSEtxVTNaM1lUVzVZTGtqVEdsMWx3NE8xOURYR2JieGoyZGRZIn0.eyJleHAiOjE3MjQ4OTE5NjMsImlhdCI6MTcyNDg1NTk2MywianRpIjoiYjI5Y2YyYTEtM2YyMS00MGFhLThlMTgtYTEzYTkzNWRlZjhiIiwiaXNzIjoiaHR0cHM6Ly9hdXRoLmRldi5wZDE1LnNvbC5tdHAvYXV0aC9yZWFsbXMvUnQzMVJzZXJBdXRoIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjljOWQwMTNjLWVhMTEtNDdkNi1iMmYyLWZlYzA3ODk3YTE2YiIsInR5cCI6IkJlYXJlciIsImF6cCI6InNvZnRydXN0X3BoYXJtYWN5IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXJ0MzFyc2VyYXV0aCIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJvZ3JuIjoiMTAyMzEwMTMzOTAzMCIsImNsaWVudEhvc3QiOiIxNzIuMjguNjIuNjkiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImNsaWVudElkIjoic29mdHJ1c3RfcGhhcm1hY3kiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtc29mdHJ1c3RfcGhhcm1hY3kiLCJjbGllbnRBZGRyZXNzIjoiMTcyLjI4LjYyLjY5In0.BMCdfJVpyEjgt-QQwd5Cyrtml3ARkWrT7FWKp4jnlrJR7cdsJEVc9bJI-jjp2XBGYwALMe2H4iGFK863VyoJoEpvjyKWxRshhhAzcNLA1UAlf0rgvpepbYvD-J4kqK_f998wj-mg61Eeq0gFkbZ3kt0Zv-tIW0wnuo0VcKIQuS6uUpXBJi9Yxb5q4u7jImlvhbW64XuvgB-i6ZRuyepY1rRY2gyZkuXnuKWKr4hqsVvfDUCrpc9LbW9EIoG5LfV9UYz3-VqbXTopIhNmp73FVPBpByf4W2BezbMPJ5hRhTR5LlBtBT5b3bNV9lBpzk0u4EUeVKF9V_N2V5eug1QfoQ";
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
