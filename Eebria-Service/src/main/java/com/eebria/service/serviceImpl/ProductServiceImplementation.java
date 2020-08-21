package com.eebria.service.serviceImpl;

import com.eebria.service.Exception.ProductException;
import com.eebria.service.common.Direction;
import com.eebria.service.common.OrderBy;
import com.eebria.service.common.Range;
import com.eebria.service.model.Product;
import com.eebria.service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Optional;

/**
 * The Service Implementation to  fetch the products from the Eebria API.
 *
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */
@Service
@Slf4j
public class ProductServiceImplementation implements ProductService {

    private final WebClient webClient;

    public ProductServiceImplementation(@Value("${eebria.api.base.url}") String baseURL) {
        this.webClient = WebClient.builder().baseUrl(baseURL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    /**
     *
     * @return Flux<Product>
     */
    private Flux<Product> getProducts() {
        return webClient.get()
                .uri("")
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ProductException("Error in request. Please check the request", clientResponse.statusCode().value())))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ProductException("RunTimeException from Product Service", clientResponse.statusCode().value())))
                .bodyToFlux(Product.class);
    }

    @Override
    public Flux<Product> getAllProducts() {
        log.info("Fetching the products:ProductServiceImplementation:getAllProducts()");
        return getProducts();
    }


    @Override
    public Mono<Product> getProductByRange(String range) {
        log.info("Fetching the products by range:ProductServiceImplementation:getProductByRange()");
        if (range.equals(Range.CHEAPER.getRange())) {
            return getProducts().sort(Comparator.comparing(Product::getPrice)).elementAt(0);
        } else {
            return getProducts().sort(Comparator.comparing(Product::getPrice).reversed()).elementAt(0);
        }

    }

    @Override
    public Flux<Product> getProductsByType(String type) {
        log.info("Fetching the products by type:ProductServiceImplementation:getProductsByType()");
        return getProducts().filter(p -> p.getType().equals(type));
    }

    @Override
    public Flux<Product> sortProducts(String[] orderBy, String direction) {
        log.info("Fetching the sorted products:ProductServiceImplementation:sortProducts()");
        Comparator<Product> comparator = null;
        Comparator<Product> priceComparator = Comparator.comparing(Product::getPrice);
        Comparator<Product> nameComparator = Comparator.comparing(Product::getName);
        Flux<Product> product = null;
        if (orderBy.length > 1) {
            if (orderBy[0].equals(OrderBy.NAME.getOrderByCode())) {
                comparator = nameComparator.thenComparing(priceComparator);
            } else {
                comparator = priceComparator.thenComparing(nameComparator);
            }
        } else {
            if (orderBy[0].equals(OrderBy.NAME.getOrderByCode())) {
                comparator = nameComparator;
            } else {
                comparator = priceComparator;
            }

        }

        if (direction.equals(Direction.DESCENDING.getDirectionCode()))
            product = Optional.ofNullable(getProducts().sort(comparator.reversed())).orElseThrow(
                    NullPointerException::new);
        else
            product = Optional.ofNullable(getProducts().sort(comparator)).orElseThrow(
                    NullPointerException::new);

        return product;
    }
}
