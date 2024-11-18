package com.sunflower.dslist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.profiles.active}")
    private String appProfile;

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(apiInfo())
                .servers(List.of(new Server().url(serverUrl).description(appProfile + " server")));
    }

    private Info apiInfo() {
        return new Info().title("Ds-List API")
                .contact(new Contact()
                        .name("Jackson Rodrigues")
                        .email("jacksonnalmeida30@gmail.com")
                        .url("https://github.com/JacksonAlmeida"))
                .version("v1")
                .description("Esta documentação foi desenvolvida como parte do bootcamp DSList, oferecido pela " +
                        "Escola DevSuperior.");
    }

}
