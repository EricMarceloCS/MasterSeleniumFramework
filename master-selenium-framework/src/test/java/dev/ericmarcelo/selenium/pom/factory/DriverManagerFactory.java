package dev.ericmarcelo.selenium.pom.factory;

import dev.ericmarcelo.selenium.pom.constants.DriverType;
public class DriverManagerFactory {

    public static DriverManager getManager(DriverType driverType){
        switch(driverType) {
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            default -> {
                throw new IllegalArgumentException("Invalid browser name: ");
            }
        }
    }
}
