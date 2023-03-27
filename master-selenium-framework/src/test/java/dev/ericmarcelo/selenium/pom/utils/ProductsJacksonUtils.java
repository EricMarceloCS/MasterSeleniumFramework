package dev.ericmarcelo.selenium.pom.utils;
import dev.ericmarcelo.selenium.pom.objects.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductsJacksonUtils {

    public static synchronized List<Product> deserializeProductsJson(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        List<Product> products = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        String str = null;
        try {
            while((str = br.readLine()) != null) {
                strings.add(str.trim());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        strings.removeIf(s -> s.equals("["));
        strings.removeIf(s -> s.equals("]"));
        strings.removeIf(s -> s.equals("{"));
        strings.removeIf(s -> s.equals("},"));
        strings.removeIf(s -> s.equals("}"));

        for (int i = 0; i < strings.size(); i = i + 3){
            Product product = new Product(Integer.valueOf(strings.get(i).substring(7, 11)));
            product.setFeatured(Boolean.valueOf(strings.get(i+1).substring(13, 17)));
            product.setName(strings.get(i+2).substring(10).replace("\"", ""));
            products.add(product);
        }

        products = products.stream().filter(p -> p.isFeatured()).toList();

        return products;
    }
}
