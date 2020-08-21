package com.eebria.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static com.eebria.service.common.ApplicationConstants.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EebriaProductsApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        webTestClient = webTestClient
                .mutate()
                .responseTimeout(Duration.ofMillis(36000))
                .build();
    }

    @Test
    public void testGetAllProducts() {

        webTestClient.get().uri(ROOT_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(response.getResponseBody()).isNotNull());

    }

    @Test
    public void testGetProductsByType() {

        webTestClient.get().uri(uriBuilder -> uriBuilder.path(ROOT_PATH)
                .queryParam("type", "beer")
                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(response.getResponseBody()).isNotNull());

    }

    @Test
    public void getProductsByRange() {

        webTestClient.get().uri(ROOT_PATH + BY_RANGE, "cheaper")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(response.getResponseBody()).isNotNull());

    }

    @Test
    public void testSortProducts() {

        webTestClient.get().uri(uriBuilder -> uriBuilder.path(ROOT_PATH + SORT)
                .queryParam("orderBy", "name")
                .queryParam("direction", "DESC")
                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(response.getResponseBody()).isNotNull());

    }


}
