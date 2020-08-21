package com.eebria.service.controller;

import com.eebria.service.Exception.InValidTypeException;
import com.eebria.service.Exception.NotInRangeException;
import com.eebria.service.Exception.SortingException;
import com.eebria.service.common.Direction;
import com.eebria.service.common.OrderBy;
import com.eebria.service.common.Range;
import com.eebria.service.common.Type;
import com.eebria.service.model.Product;
import com.eebria.service.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

import static com.eebria.service.common.ApplicationConstants.*;

/**
 *The Product Rest Controller to handle the incoming api request.
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */

@RestController
@RequestMapping(ROOT_PATH)
@Slf4j
@CrossOrigin(origins = EEBRIA_UI_URL)
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping
    @ApiOperation("Retrieves all Products by the product type")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SuccessFul Retrieval of Products by type")})
    public Flux<Product> getProductsByType(@RequestParam(value = "type",required = false,defaultValue = "") String type, ServerHttpRequest request) {
        log.info("API received request: "+request.getPath()+" input param: type: "+type);
        if (!type.isEmpty())
        {
            if (!(type.equals(Type.CIDER.getType())
                    || type.equals(Type.BEER.getType()))) {
                throw new InValidTypeException("Invalid Type");
            }

            return productService.getProductsByType(type);
        }

        return productService.getAllProducts();
    }


    @GetMapping(BY_RANGE)
    @ApiOperation("Retrieve a Product by range")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SuccessFul Retrieval of Products by range"),
                    @ApiResponse(code= 412,message="Precondition Failed")})
    public Mono<Product> getProductsByRange(@PathVariable(value = "range") String range,ServerHttpRequest request) {
        log.info("API received request: "+request.getPath()+" input param: range: "+range);
        if (!(range.equals(Range.CHEAPER.getRange())
                || range.equals(Range.EXPENSIVE.getRange()))) {
            throw new NotInRangeException("Invalid Range Condition");
        }
        return productService.getProductByRange(range);
    }


    @GetMapping(SORT)
    @ApiOperation("Retrieve all Products Ordered by name,price in ascending or descending direction")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SuccessFul Retrieval of Products by range"),
                    @ApiResponse(code= 412,message="Precondition Failed")})
    public Flux<Product> sortProducts(@RequestParam("orderBy") String orderBy[],
                                                @RequestParam("direction") String direction, ServerHttpRequest request) {
        log.info("API received request: "+request.getPath()+" input params: orderBy: "+Arrays.asList(orderBy)+" ,direction: "+direction);

        if (!(direction.equals(Direction.ASCENDING.getDirectionCode())
                || direction.equals(Direction.DESCENDING.getDirectionCode()))) {
            throw new SortingException("Invalid sort direction");
        }
        System.out.println(Arrays.asList(orderBy).contains(OrderBy.NAME.getOrderByCode()));

        if(orderBy.length>1)
        {
            if (!(Arrays.asList(orderBy).contains(OrderBy.NAME.getOrderByCode()) && Arrays.asList(orderBy).contains(OrderBy.PRICE.getOrderByCode()))) {
                throw new SortingException("Invalid orderBy condition");
            }
        }
        else{
            if (!(Arrays.asList(orderBy).contains(OrderBy.NAME.getOrderByCode()) || Arrays.asList(orderBy).contains(OrderBy.PRICE.getOrderByCode()))) {
                throw new SortingException("Invalid orderBy condition");
            }
        }


        return productService.sortProducts(orderBy,direction);

    }

}