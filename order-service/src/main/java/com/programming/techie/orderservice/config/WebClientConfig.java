package com.programming.techie.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced   //If multiple client instances are running then this is used as it automatically creates the client side
    //load balancer and this balancer is used to call one of the service, In this scenario - Inventory-service is the one
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
