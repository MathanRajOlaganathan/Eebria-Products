package com.eebria.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static com.eebria.service.common.ApplicationConstants.ROOT_PATH;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 *Configuration class to bootstrap  the application.
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */
@SpringBootApplication
public class EebriaServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(EebriaServiceApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return  route(GET("/"), req ->
                ServerResponse.temporaryRedirect(URI.create(ROOT_PATH))
                        .build());
    }

}
