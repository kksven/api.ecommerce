package com.api.ecommerce.api.ecommerce.service;

import com.api.ecommerce.api.ecommerce.domain.Product;
import com.api.ecommerce.api.ecommerce.exception.CustomNotFoundException;
import com.api.ecommerce.api.ecommerce.model.Brand;
import com.api.ecommerce.api.ecommerce.model.Prices;
import com.api.ecommerce.api.ecommerce.repository.PriceRepository;
import com.api.ecommerce.api.ecommerce.service.imp.PriceServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImpTest {

    @InjectMocks
    PriceServiceImp services;

    @Mock
    private PriceRepository repository;

    private LocalDateTime startDate;
    private int productId;
    private int brandId;

    @BeforeEach
    void init(){
        startDate = LocalDateTime.of(2020, 6,14, 0, 0, 0);
        productId = 35455;
        brandId = 1;
    }

    @Test
    @DisplayName("Throw CustomNotFoundException when repository result is null")
    void shouldThrowNotFoundExceptionWhenNotExistPriceInformation(){

        when(repository.findFirstByStartDateAndProductIdAndBrand(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(null);

        assertThrows(CustomNotFoundException.class,() -> services.getProductByPrice(startDate, productId, brandId));
    }

    @Test
    @DisplayName("return Final price product by startDate and productID and brandID")
    void shouldReturnFinalPriceInformationWhenExist(){

        Prices price = priceBuild(startDate, productId, brandId);
        Product expected = productBuild(startDate, productId, brandId);
        when(repository.findFirstByStartDateAndProductIdAndBrand(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(price);

        Product result = services.getProductByPrice(startDate, productId, brandId);

        assertEquals(expected, result);

    }

    private Prices priceBuild(LocalDateTime startDate, int productId, int brandId){

        LocalDateTime endDate = LocalDateTime.of(2020,12,31, 23, 59, 59);

        Brand brand = new Brand();
        brand.setBrandId(brandId);
        brand.setName("Zara");

        Prices price = new Prices();
        price.setPriceList(1);
        price.setProductId(productId);
        price.setBrand(brand);
        price.setStartDate(startDate);
        price.setEndDate(endDate);
        price.setPrice(30.50);
        price.setPriority(1);
        price.setCurr("EUR");
        return  price;
    }

    private Product productBuild(LocalDateTime startDate, int productId, int brandId){
        return Product.builder()
                .productId(productId)
                .priceList(1)
                .brandID(brandId)
                .startDatePrice(startDate)
                .price(30.5)
                .curr("EUR").build();
    }





}
