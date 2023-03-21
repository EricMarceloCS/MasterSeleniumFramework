package dev.ericmarcelo.selenium.pom.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
        List<io.restassured.http.Cookie> restAssuredCookies = new ArrayList<>();
        for(io.restassured.http.Cookie cookie : cookies) {
            restAssuredCookies.add(cookie);
        }

        List<Cookie> seleniumCookies = new ArrayList<>();

        for(io.restassured.http.Cookie rac : restAssuredCookies){
            seleniumCookies.add(new Cookie(
                    rac.getName(),
                    rac.getValue(),
                    rac.getDomain(),
                    rac.getPath(),
                    rac.getExpiryDate(),
                    rac.isSecured(),
                    rac.isHttpOnly(),
                    rac.getSameSite())
            );
        }
        return seleniumCookies;
    }

}
