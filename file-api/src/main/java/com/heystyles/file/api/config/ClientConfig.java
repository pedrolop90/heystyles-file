package com.heystyles.file.api.config;

import com.heystyles.common.response.ClientResponseErrorHandler;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Autowired
    private ClientProperties clientProperties;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(clientProperties.getConnectionTimeout()))
                .setReadTimeout(Duration.ofMillis(clientProperties.getReadTimeout()))
                .errorHandler(new ClientResponseErrorHandler())
                .build();
    }
}
