package com.thinkltp.webrestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class WebRestfulApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebRestfulApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/cloud-vendor/*"))
                .apis(RequestHandlerSelectors.basePackage("com.thinkltp.webrestful"))
                .build()
                .apiInfo(apiCustomData());
    }

    private ApiInfo apiCustomData() {
        return new ApiInfo(
                "Cloud Vendor API",
                "Cloud Vendor Documentation",
                "1.0",
                "cloud vendor service terms",
                new Contact("Iyke Israel", "https://github.com/iykeprince", "iykeprince@gmail.com"),
                "TLP license",
                "https://github.com/iykeprince",
                Collections.emptyList()
        );
    }
}
