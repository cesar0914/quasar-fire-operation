package co.com.mercadolibre.quasarfireoperation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Quasar Fire Operation API")
                        .description("Documentación técnica para el consumo de los servicios referentes a Quasar Fire Operation API.")
                        .version("v1.0.0"));
    }
}
