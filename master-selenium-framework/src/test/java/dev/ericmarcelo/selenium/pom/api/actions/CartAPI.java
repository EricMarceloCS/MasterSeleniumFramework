package dev.ericmarcelo.selenium.pom.api.actions;

import dev.ericmarcelo.selenium.pom.constants.Endpoints;
import dev.ericmarcelo.selenium.pom.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

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

        System.out.println("Before APIRequest");
        Response response = new APIRequest().postToCartRequest(headers, formParams);
        System.out.println("******** After APIRequest");
        setCookies(response.getDetailedCookies());
        System.out.println(response.getDetailedCookies());
        System.out.println("********** After Cookies");
        return response;
    }
}
