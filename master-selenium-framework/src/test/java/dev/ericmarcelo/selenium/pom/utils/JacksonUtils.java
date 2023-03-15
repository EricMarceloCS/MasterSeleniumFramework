package dev.ericmarcelo.selenium.pom.utils;

import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JacksonUtils {

    private static Map<String, String> mapper = new HashMap<>();
    public static BillingAddress deserializeBillingAddressJson(InputStream is, BillingAddress billingAddress) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        mapBillingAddress(br);
        setBillingAddress(billingAddress);
       return billingAddress;
    }

    private static void mapBillingAddress(BufferedReader br) throws IOException {
        String str;
        while((str = br.readLine()) != null){
            if(str.length() == 1)
                continue;
            String[] strings = str.split("\"");
            mapper.put(strings[1], strings[3]);
        }
    }

    private static void setBillingAddress(BillingAddress billingAddress){
        billingAddress.setFirstName(mapper.get("firstName"))
                .setLastName(mapper.get("lastName"))
                .setCountry(mapper.get("country"))
                .setAddress(mapper.get("address"))
                .setCity(mapper.get("city"))
                .setState(mapper.get("state"))
                .setPostalCode(mapper.get("postalCode"))
                .setEmail(mapper.get("email"))
                .setUserName(mapper.get("userName"))
                .setPassword(mapper.get("password"));

        mapper.clear();
    }
}
