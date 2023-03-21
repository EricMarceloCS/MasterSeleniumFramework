package dev.ericmarcelo.selenium.pom.utils;

import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BillingJacksonUtils {

    public static synchronized BillingAddress deserializeBillingAddressJson(InputStream is, BillingAddress billingAddress) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Map<String, String> mapper = new HashMap<>();
        mapBillingAddress(br, mapper);
        setBillingAddress(billingAddress, mapper);
       return billingAddress;
    }

    private static void mapBillingAddress(BufferedReader br, Map<String, String> mapper) throws IOException {
        String str;
        while((str = br.readLine()) != null){
            if(str.length() == 1)
                continue;
            String[] strings = str.split("\"");
            mapper.put(strings[1], strings[3]);
        }
    }

    private static void setBillingAddress(BillingAddress billingAddress, Map<String, String> mapper){
        billingAddress.setFirstName(mapper.get("firstName"))
                .setLastName(mapper.get("lastName"))
                .setCountry(mapper.get("country"))
                .setAddress(mapper.get("address"))
                .setCity(mapper.get("city"))
                .setState(mapper.get("state"))
                .setPostalCode(mapper.get("postalCode"))
                .setEmail(mapper.get("email"))
                .setUsername(mapper.get("username"))
                .setPassword(mapper.get("password"));

        mapper.clear();
    }
}
