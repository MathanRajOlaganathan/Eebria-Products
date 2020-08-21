package com.eebria.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *The model Product represents the Eebria products
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @JsonProperty("name")
    @ApiModelProperty("Represents the Name of the Product")
    private String name;

    @JsonProperty("image")
    @ApiModelProperty("Represents the Image URL of the Product")
    private String imageUrl;

    @JsonProperty("style")
    @ApiModelProperty("Represents the type of the Product")
    private String type;

    @JsonProperty("price")
    @ApiModelProperty("Represents the Price of the Product")
    private float price;

}
