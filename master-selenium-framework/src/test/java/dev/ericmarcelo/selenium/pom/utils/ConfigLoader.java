package dev.ericmarcelo.selenium.pom.utils;

import dev.ericmarcelo.selenium.pom.constants.EnvType;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String environment = System.getProperty("env", EnvType.STAGE.toString());
        switch(EnvType.valueOf(environment)) {
            case STAGE -> {
                properties = PropertyUtils.propertyLoader("src"
                        + File.separator
                        + "test"
                        + File.separator
                        + "resources"
                        + File.separator
                        + "stg_config.properties");
                break;
            }
            case PRODUCTION -> {
                properties = PropertyUtils.propertyLoader("src"
                        + File.separator
                        + "test"
                        + File.separator
                        + "resources"
                        + File.separator
                        + "prod_config.properties");
                break;
            }
            default -> {
                throw new IllegalStateException("Invalid environment type...");
            }
        }
    }

    public static ConfigLoader getInstance() {
        return configLoader == null ? configLoader = new ConfigLoader() : configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if(prop == null){
            throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file");
        }else {
            return prop;
        }
    }

    public String getUsername() {
        String prop = properties.getProperty("username");
        if(prop == null){
            throw new RuntimeException("property username is not specified in the stg_config.properties file");
        }else {
            return prop;
        }
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if(prop == null){
            throw new RuntimeException("property password is not specified in the stg_config.properties file");
        }else {
            return prop;
        }
    }
}
