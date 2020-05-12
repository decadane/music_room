package ru.kmedhurs.music_room.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API for music room project")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("Smirshin.A.O.","", "decadane@yandex.ru"))
                .build();
    }
}