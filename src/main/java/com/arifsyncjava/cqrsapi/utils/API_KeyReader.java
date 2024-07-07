package com.arifsyncjava.cqrsapi.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class API_KeyReader {

    private final static String API_KEY = "PROFANITY_FILTER_API_KEY";

    public static String getApiKey () {
        Properties properties = new Properties();
        try (InputStream inputStream =
                     new ClassPathResource("api_key.properties").getInputStream()) {
            return properties.getProperty(API_KEY);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
