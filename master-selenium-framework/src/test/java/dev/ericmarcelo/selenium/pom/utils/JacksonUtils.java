package dev.ericmarcelo.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static BillingAddress deserializeJson(InputStream is, BillingAddress billingAddress) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.readValue(is, billingAddress.getClass());
    }
}
