package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI coldChainOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cold Chain Temperature Breach Alert System API")
                        .description("CRUD APIs for Shipments, Temperature Logs, Rules, Breaches, Alerts, and Auth")
                        .version("1.0"));
    }
}
