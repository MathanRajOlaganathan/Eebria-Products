package com.eebria.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
/**
 *The Swagger configuration to enable the api documentation for the Eebria Rest API.
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eebria.service"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {

        Contact contact = new Contact("Mathan Raj Olaganathan","https://www.linkedin.com/in/mathanrajo",
                "omrfrance1990@gmail.com");

        StringVendorExtension listVendorExtension = new StringVendorExtension("Role", "Software Developer");
        ApiInfo apiInfo = new ApiInfo("Eebria RestFul Service API",
                "Eebria Product RestFul Service",
                "1.0",
                "",
                (springfox.documentation.service.Contact) contact,
                "Eebria RestFul Service - Github"
                ,"https://github.com/MathanRajOlaganathan/eebria-products",
                Arrays.asList(listVendorExtension));
        return apiInfo;
    }
}