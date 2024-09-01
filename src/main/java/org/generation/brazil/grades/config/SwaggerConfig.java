package org.generation.brazil.grades.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI minhaAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto API Alunos - Generation")
                        .version("1.0.0")
                        .description("Projeto desenvolvido para o processo seletivo do bootcamp da Generation")
                );
    }
}
