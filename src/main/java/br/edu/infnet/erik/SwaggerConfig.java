package br.edu.infnet.erik;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API: Gestão de títulos")
                .version("1.0")
                .description("API para gestão de títulos empresariais")
                .contact(new Contact()
                    .name("Erik Tronkos")
                    .email("erik.tronkos@al.infnet.edu.br")));
    }
}