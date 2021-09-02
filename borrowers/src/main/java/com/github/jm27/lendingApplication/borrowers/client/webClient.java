package com.github.jm27.lendingApplication.borrowers.client;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@EnableWebFlux
public class webClient {
    @Bean
    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }
}
