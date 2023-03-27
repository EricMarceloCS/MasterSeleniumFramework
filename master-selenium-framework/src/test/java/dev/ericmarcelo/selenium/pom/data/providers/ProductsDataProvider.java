package dev.ericmarcelo.selenium.pom.data.providers;

import dev.ericmarcelo.selenium.pom.objects.Product;
import dev.ericmarcelo.selenium.pom.utils.ProductsJacksonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductsDataProvider {

    public List<Product> getFeaturedProducts() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("products.json");) {
            return ProductsJacksonUtils.deserializeProductsJson(is);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        }
        return null;
    }
}
