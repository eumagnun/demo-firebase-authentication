package com.google.demofirebaseauth.dto;

import com.google.demofirebaseauth.repository.model.ProductEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;

    private String description;

    private Double price;

    public ProductEntity parseEntity(){
        return new ProductEntity(this.id, this.description, this.price);
    }
}
