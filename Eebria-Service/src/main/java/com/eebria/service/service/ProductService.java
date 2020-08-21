package com.eebria.service.service;

import com.eebria.service.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *The abstract layer to fetch the products from the Eebria api.
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */
public interface ProductService {

    public Flux<Product> getProductsByType(String type);

    public Flux<Product> getAllProducts();

    public Mono<Product> getProductByRange(String range);

    public Flux<Product> sortProducts(String[] orderBy, String direction);
}
