package dio.web.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Titulo - REST API")
                        .description("Exemplo de utilização do OpenAPI")
                        .version("1.0.0")
                        .termsOfService("Termos de uso: Open Source")
                        .contact(new Contact()
                                .name("Eric")
                                .url("http://localhost:8080")
                                .email("eric.exemplo@teste.com")
                        )
                        .license(new License()
                                .name("Licença - Da True Adm")
                                .url("http://localhost:8080")
                        )
                );
    }
}
