package providers;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiProvider {

    public static void filters() {
        RestAssured.filters(new RequestLoggingFilter(System.out), new RequestLoggingFilter(System.out));

    }
    public Response get (String endpoint, String status) {
        return given()
                .accept(ContentType.JSON)
                .queryParam("status", status)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();

    }
}
