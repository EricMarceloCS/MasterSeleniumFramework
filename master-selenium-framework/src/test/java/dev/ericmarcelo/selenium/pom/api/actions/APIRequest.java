package dev.ericmarcelo.selenium.pom.api.actions;

import dev.ericmarcelo.selenium.pom.constants.Endpoints;
import dev.ericmarcelo.selenium.pom.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIRequest {

    public Response getRequest(Endpoints endpoints) {
        Cookies cookies = new Cookies();
        Response response = given()
                .baseUri(ConfigLoader.getInstance()
                        .getBaseUrl())
                .cookies(cookies)
                .log()
                .all()
                .when()
                .get("/" +endpoints.toString().toLowerCase())
                .then()
                .log()
                .all()
                .extract()
                .response();

        if(response.getStatusCode() != 200) {
            throw new RuntimeException(
                    "Failed to fetch the account, HTTP Status Code: "
                            + response.getStatusCode()
            );

        }
        return response;
    }

    public Response postRequest(Headers headers, Map<String, String> formParams, Endpoints endpoints) {
        Cookies cookies = new Cookies();
        Response response = given()
                .baseUri(ConfigLoader.getInstance()
                        .getBaseUrl())
                .headers(headers)
                .formParams(formParams)
                .cookies(cookies)
                .log()
                .all()
                .when()
                .post("/" +endpoints.toString().toLowerCase())
                .then()
                .log()
                .all()
                .extract()
                .response();

        if(response.getStatusCode() != 302) {
            throw new RuntimeException(
                    "Failed to fetch the account, HTTP Status Code: "
                            + response.getStatusCode()
            );

        }
        return response;
    }

    public Response postToCartRequest(Headers headers, Map<String, Object> formParams) {
        Cookies cookies = new Cookies();
        Response response = given()
                .baseUri(ConfigLoader.getInstance()
                        .getBaseUrl())
                .headers(headers)
                .formParams(formParams)
                .cookies(cookies)
                .log()
                .all()
                .when()
                .post("/?wc-ajax=add_to_cart")
                .then()
                .log()
                .all()
                .extract()
                .response();

        if(response.getStatusCode() != 200) {
            throw new RuntimeException(
                    "Failed to fetch the account, HTTP Status Code: "
                            + response.getStatusCode()
            );

        }
        return response;
    }
}
