package dev.ericmarcelo.selenium.pom.api.actions;

import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class SignUpAPI {
    private Cookies cookies;

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    private String fetchRegisterNonceValueUsingJsoup() {
        Response response = getAccount();
        Document document = Jsoup.parse(response.body().prettyPrint());
        Element element = document.selectFirst("#woocommerce-register-nonce");
        return element.attr("value");
    }

    private Response getAccount() {
        Cookies cookies = new Cookies();
        Response response = given()
                .baseUri(ConfigLoader.getInstance()
                        .getBaseUrl())
                .cookies(cookies)
                .log()
                .all()
                .when()
                .get("/account")
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

        setCookies(response.getDetailedCookies());

        return response;
    }

    public Response register(User user) {
        Cookies cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);

        Map<String, String> formParams = new HashMap<>();
        formParams.put("username", user.getUsername());
        formParams.put("password", user.getPassword());
        formParams.put("email", user.getEmail());
        formParams.put("woocommerce-register-nonce", fetchRegisterNonceValueUsingJsoup());
        formParams.put("register", "Register");

        Response response = given()
                .baseUri(ConfigLoader.getInstance()
                        .getBaseUrl())
                .headers(headers)
                .formParams(formParams)
                .cookies(cookies)
                .log()
                .all()
                .when()
                .post("/account")
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

        setCookies(response.getDetailedCookies());
        return response;
    }
}
