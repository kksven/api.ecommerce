package com.api.ecommerce.api.ecommerce.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    ProductController productController;

    @Test
    @DisplayName("Should return the price when the date is valid for the first price of the day. ")
    void testCaseOne(){
        LocalDateTime startDate = LocalDateTime.of(2020, 6,14, 0, 0, 0);
        int productId = 35455;
        int brandId = 1;

        double expect = 35.50;

        final double result = getPriceFromController(startDate, productId, brandId);

        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Should return the price when the date is between the intermediate range of day price")
    void testCaseTwo(){
        LocalDateTime startDate = LocalDateTime.of(2020, 6,14, 16, 0, 0);
        int productId = 35455;
        int brandId = 1;

        double expect = 25.45;

        final double result = getPriceFromController(startDate, productId, brandId);

        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Should return the first price when the date is the last range of day price")
    void testCaseThree(){
        LocalDateTime startDate = LocalDateTime.of(2020, 6,14, 21, 0, 0);
        int productId = 35455;
        int brandId = 1;

        double expect = 35.5;

        final double result = getPriceFromController(startDate, productId, brandId);

        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Should return the price when date is between the first range of day price")
    void testCaseFour(){
        LocalDateTime startDate = LocalDateTime.of(2020, 6,15, 10, 0, 0);
        int productId = 35455;
        int brandId = 1;

        double expect = 30.5;

        final double result = getPriceFromController(startDate, productId, brandId);

        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Should return the price when dte the last range of day price")
    void shouldReturnPriceWhenDateIsValidGreaterThanTheRange(){
        LocalDateTime startDate = LocalDateTime.of(2020, 6,16, 21, 0, 0);
        int productId = 35455;
        int brandId = 1;

        double expect = 38.95;

        final double result = getPriceFromController(startDate, productId, brandId);

        assertEquals(expect, result);
    }

    private double getPriceFromController(LocalDateTime startDate, int productId, int brandId) {
        return Objects.requireNonNull(productController.getProduct(startDate, productId, brandId)
                .getBody())
                .getPrice();
    }
}
