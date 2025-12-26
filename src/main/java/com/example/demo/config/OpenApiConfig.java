package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cold Chain Temperature Breach Alert System")
                        .version("1.0")
                        .description("Swagger API documentation for Cold Chain System"))
                .servers(List.of(
                        new Server().url("http://localhost:9001")
                ));
    }
}

}