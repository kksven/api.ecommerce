package com.api.ecommerce.api.ecommerce.controllers;


import com.api.ecommerce.api.ecommerce.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ProductController {

    private static final String PATH = "/product";

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            value = PATH,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> getProduct(){

        return new ResponseEntity<>(Product.builder().build(), HttpStatus.OK);
    }
}
