package com.api.ecommerce.api.ecommerce.controller;


import com.api.ecommerce.api.ecommerce.aspect.annotation.Monitor;
import com.api.ecommerce.api.ecommerce.domain.Product;
import com.api.ecommerce.api.ecommerce.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Monitor
@RestController
@RequestMapping("/api/")
public class ProductController {

    private static final String PATH = "/product";
    private final PriceService priceService;

    public ProductController(PriceService priceService) {
        this.priceService = priceService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            value = PATH,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> getProduct(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId")  int productId,
            @RequestParam("brandId")  int brandId
    ){
        return new ResponseEntity<>(priceService.getProductByPrice(date, productId, brandId), HttpStatus.OK);
    }
}
