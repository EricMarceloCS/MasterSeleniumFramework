package dev.ericmarcelo.selenium.pom.utils;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String path) {
        Properties properties = new Properties();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            properties.load(bufferedReader);
        } catch (Exception e) {
            System.err.println("Unable to load properties...");
            e.printStackTrace();

            Throwable[] suppressed = e.getSuppressed();
            Arrays.stream(suppressed)
                    .forEach(s -> System.out.println("Suppressed Exception: " + s.getMessage()));
        }

        return properties;
    }
}
