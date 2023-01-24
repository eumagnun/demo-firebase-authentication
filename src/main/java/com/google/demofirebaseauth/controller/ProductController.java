package com.google.demofirebaseauth.controller;


import com.google.demofirebaseauth.dto.Product;
import com.google.demofirebaseauth.repository.ProductRepository;
import com.google.demofirebaseauth.repository.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(produces = "application/json")

    public ResponseEntity get() {
        try {
            List<Product> productList = new ArrayList<>();
            productRepository.findAll().forEach(p -> productList.add(p.parseDto()));
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity create(@RequestBody Product product) {
        try{
            ProductEntity productEntity = productRepository.save(product.parseEntity());
            return ResponseEntity.status(HttpStatus.OK).body(productEntity.parseDto());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}
