package com.arifsyncjava.cqrsapi.product.validation;

import com.arifsyncjava.cqrsapi.enums.ErrorMessage;
import com.arifsyncjava.cqrsapi.exceptions.ProfanityFilterException;
import com.arifsyncjava.cqrsapi.exceptions.SimpleResponse;
import com.arifsyncjava.cqrsapi.utils.API_KeyReader;
import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;


public class ProfanityValidator {
//
// @Bean
//   public RestClient  restClient (RestClientBuilderCustomizer customizer) {
//        return RestClient
//                .builder()
//                .apply((Consumer<RestClient.Builder>) customizer)
//                .build();
//    }



    private final static String API_KEY = API_KeyReader.getApiKey();

//    private final RestClient restClient;
//    public ProfanityValidator(RestClient restClient) {
//        this.restClient = restClient;
//    }|




    public static boolean hasProfanity (String name, String description) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-key", API_KEY);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<ProfanityApiResponse> nameResponseEntity = restTemplate.exchange(
                    "https://api.api-ninjas.com/v1/profanityFilter?text=" + name,
                    HttpMethod.GET,
                    entity,
                    ProfanityApiResponse.class
            );

            ResponseEntity<ProfanityApiResponse> descriptionProfanity =
                    restTemplate.exchange(
                            "https://api.api-ninjas.com/v1/profanityFilter?text=" + description,
                            HttpMethod.GET,
                            entity,
                            ProfanityApiResponse.class
                    );

            return (nameResponseEntity.getBody().isHas_profanity()
                    || descriptionProfanity.getBody().isHas_profanity());



        } catch (Exception exception) {
            throw new ProfanityFilterException(
                    new SimpleResponse(ErrorMessage.PROFANITY_FILTER_DOWN.getMessage()));


        }




    }












}
