package com.catalog_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQLClientConfig {

    @Value("${product.service.url}")
    private String productServiceUrl;

    @Bean
    public HttpGraphQlClient httpGraphQlClient(){

        WebClient webClient = WebClient.builder()
                .baseUrl(productServiceUrl)
                .build();
        return HttpGraphQlClient.builder(webClient).build();
    }
}
