package com.example.swingmvcdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    private static Properties properties;

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public ApplicationProperties() {
        if (properties == null) {
            properties = new Properties();

            try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
                properties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
