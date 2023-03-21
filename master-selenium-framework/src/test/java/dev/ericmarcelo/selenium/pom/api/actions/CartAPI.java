package dev.ericmarcelo.selenium.pom.api.actions;

import dev.ericmarcelo.selenium.pom.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CartAPI {

    private Cookies cookies;

    public CartAPI() {

    }
    public CartAPI(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public Response addToCart(Integer productId, Integer quantity) {
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);

        Map<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

        if(cookies == null)
            cookies = new Cookies();

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
                    "Failed to add product "
                            + productId
                            + "to the cart, "
                            + "HTTP Status Code: "
                            + response.getStatusCode()
            );

        }

        setCookies(response.getDetailedCookies());
        return response;
    }
}
