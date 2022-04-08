package ec.com.servicioentidad.banco.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")
@Configuration
@OpenAPIDefinition
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("BancoES")
                .description("Servicio Entidad Banco")
                .termsOfService("https://www.google.com")
                .version("1.0.0")
                .license(new License()
                    .name("Apache 2.0")
                    .url("https://www.gnu.org/licenses/gpl-3.0.html"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("oscar.sarcoss@outlook.com")));
    }

}
